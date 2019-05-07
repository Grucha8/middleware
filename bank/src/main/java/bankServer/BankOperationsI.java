package bankServer;

import com.zeroc.Ice.Current;
import Bank.BankOperations;
import Bank.NegativeMoneyError;
import Bank.WrongPeselError;
import Bank.ClientInformation;
import Bank.NoPasswordError;
import Bank.AccountAlreadyExists;
import Bank.WrongPasswordError;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;

import java.util.Optional;

public class BankOperationsI implements BankOperations {
    private AccountFactory accountFactory;
    private ObjectAdapter objectAdapter;

    public BankOperationsI(final float premiumRange, ObjectAdapter objectAdapter, CurrencyListener currencyListener) {
        this.accountFactory = new AccountFactory(premiumRange, objectAdapter, currencyListener);
        this.objectAdapter = objectAdapter;
    }

    @Override
    public String register(String firstName, String lastName, String pesel, long monthlyIncome, Current current)
            throws NegativeMoneyError, WrongPeselError {

        System.out.println(String.format("%s %s with pesel: %s wants to register", firstName, lastName, pesel));

        if (!checkIfPeselIfRight(pesel)) {
            throw new WrongPeselError();
        } else if (monthlyIncome < 0 ) {
            throw new NegativeMoneyError();
        }

        return handleNewClient(new ClientInformation(firstName, lastName, pesel, monthlyIncome)).orElseGet(null);
    }

    @Override
    public String login(String pesel, Current current) throws WrongPeselError, NoPasswordError, WrongPasswordError {


        if (current.ctx.containsKey("password")) {
            if (checkIfPeselIfRight(pesel)) {

                StandardAccountI acc;
                if ((acc = (StandardAccountI) objectAdapter.find(new Identity(pesel, "standard"))) != null) {
                    if (acc.password.equals(current.ctx.get("password")))
                        return "standard";
                    else
                        throw new WrongPasswordError();

                } else if ((acc = (PremiumAccountI) objectAdapter.find(new Identity(pesel, "premium"))) != null) {
                    if (acc.password.equals(current.ctx.get("password")))
                        return "premium";
                    else
                        throw new WrongPasswordError();

                }
            } else {
                System.err.println("Wrong pesel");
                throw new WrongPeselError();
            }
        } else {
            System.err.println("No password");
            throw new NoPasswordError();
        }

        return null;
    }

    private Optional<String> handleNewClient(ClientInformation clientInformation) {
        try {
            return Optional.of(accountFactory.createNewAccount(clientInformation));
        } catch (AccountAlreadyExists accountAlreadyExists) {
            System.err.println("Someone wanted to register on already registered pesel");
        }

        return Optional.empty();
    }

    private boolean checkIfPeselIfRight(String pesel) {
        return pesel.length() == 11;
    }
}
