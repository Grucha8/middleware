package bankServer;

import Bank.ClientInformation;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import Bank.AccountAlreadyExists;

import java.util.Random;

public class AccountFactory {

    private final float PREMIUM_RANGE;
    private final String ASCIICHARS = "1234567890qwertyuiopasdfghjklzxcvbnm";

    ObjectAdapter adapter;
    private CurrencyListener currencyListener;

    public AccountFactory(float premiumRange, ObjectAdapter adapter, CurrencyListener currencyListener) {
        this.PREMIUM_RANGE = premiumRange;
        this.adapter = adapter;
        this.currencyListener = currencyListener;
    }

    public String createNewAccount(ClientInformation clientInformation) throws AccountAlreadyExists {
        String password = generatePassword();
        String accountType;

        try {
            if (clientInformation.monthlyIncome < PREMIUM_RANGE) {
                registerNewStandardAccount(clientInformation, password);
                accountType = "standard";
            }
            else {
                registerNewPremiumAccount(clientInformation, password, currencyListener);
                accountType = "premium";
            }
        } catch (Exception e) {
            System.err.println("Account with this pesel already exists");
            throw new AccountAlreadyExists();
        }

        System.out.println("Created new account: " + clientInformation.pesel + ":" + password);
        return String.format("%s-%s", password, accountType);
    }

    private String generatePassword() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++)
            sb.append(ASCIICHARS.charAt(r.nextInt(ASCIICHARS.length())));

        return sb.toString();
    }

    private void registerNewStandardAccount(ClientInformation clientInformation, String password) {
        adapter.add(
                new StandardAccountI(clientInformation.firstName, clientInformation.lastName, clientInformation.monthlyIncome, password),
                new Identity(clientInformation.pesel, "standard")
        );
    }


    private void registerNewPremiumAccount(ClientInformation clientInformation, String password, CurrencyListener currencyListener) {
        adapter.add(
                new PremiumAccountI(clientInformation.firstName, clientInformation.lastName, clientInformation.monthlyIncome, password, currencyListener),
                new Identity(clientInformation.pesel, "premium")
        );
    }


}
