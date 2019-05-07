package bankServer;

import Bank.PremiumAccount;
import Bank.NegativeMoneyError;
import Bank.NoSuchCurrencyError;
import Bank.CreditReturn;
import Bank.WrongPasswordError;
import Bank.NoPasswordError;
import com.zeroc.Ice.Current;

public class PremiumAccountI extends StandardAccountI implements PremiumAccount {

    private CurrencyListener currencyListener;

    public PremiumAccountI(String firstName, String lastName, final float initialAccountBalance, final String password, CurrencyListener currencyListener) {
        super(firstName, lastName, initialAccountBalance, password);
        this.currencyListener = currencyListener;
    }

    @Override
    public CreditReturn tryToGetCredit(String foreignCurrency, float amount, long timeToPayOff, Current current)
            throws NegativeMoneyError, NoSuchCurrencyError, WrongPasswordError, NoPasswordError {
        if (current.ctx.containsKey("password")) {
            if (current.ctx.get("password").equals(password)) {
                if (amount <= 0)
                    throw new NegativeMoneyError();
                else {
                    if (currencyListener.checkIfThisCurrencyIsObserved(foreignCurrency)) {
                        double rate = currencyListener.getCurrencyRate(foreignCurrency);
                        double creditInterest;
                        if (timeToPayOff < 30)
                            creditInterest = 0.05;
                        else if (timeToPayOff < 90)
                            creditInterest = 0.14;
                        else
                            creditInterest = 0.25;

                        float moneyToPayOff = (float) (amount * creditInterest);

                        return new CreditReturn((float) (rate * moneyToPayOff), moneyToPayOff);
                    } else {
                        System.err.println("No such currency");
                        throw new NoSuchCurrencyError();
                    }
                }
            } else {
                throw new WrongPasswordError();
            }
        } else {
            System.err.println("No password provided");
            throw new NoPasswordError();
        }
    }

}
