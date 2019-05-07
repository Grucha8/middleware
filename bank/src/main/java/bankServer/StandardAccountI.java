package bankServer;

import Bank.StandardAccount;
import Bank.WrongPasswordError;
import Bank.NoPasswordError;
import com.zeroc.Ice.Current;

public class StandardAccountI implements StandardAccount {
    float accountBalance;
    final String password;

    final String firstName;
    final String lastName;

    public StandardAccountI(String firstName, String lastName, final float initialAccountBalance, final String password) {
        this.accountBalance = initialAccountBalance;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public float getAccountBalance(Current current) throws WrongPasswordError, NoPasswordError {
        if (current.ctx.containsKey("password")) {
            if (current.ctx.get("password").equals(password)) {
                return accountBalance;

            } else {
                throw new WrongPasswordError();
            }
        }
        else {
            System.err.println("No password provided");
            throw new NoPasswordError();
        }
    }

}
