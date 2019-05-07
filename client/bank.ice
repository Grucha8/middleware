
#ifndef BANK_ICE
#define BANK_ICE

module Bank {

    exception NoSuchCurrencyError {};
    exception NegativeMoneyError {};
    exception WrongPeselError {};
    exception AccountAlreadyExists {};
    exception WrongPasswordError {};
    exception NoPasswordError {};

    struct ClientInformation {
        string firstName;
        string lastName;
        string pesel;
        long monthlyIncome;
    };

    struct CreditReturn {
        float foreignCurrency;
        float nativeCurrency;
    };


    interface BankOperations {
        string register(string firstName, string lastName, string pesel, long monthlyIncome) throws WrongPeselError, NegativeMoneyError;
        string login(string pesel) throws WrongPeselError, NoPasswordError, WrongPasswordError;
    };

    interface StandardAccount {
        float getAccountBalance() throws WrongPasswordError, NoPasswordError;
    };

    interface PremiumAccount extends StandardAccount {
        CreditReturn tryToGetCredit(string foreignCurrency, float amount, long timeToPayOff) throws NoSuchCurrencyError, NegativeMoneyError, WrongPasswordError, NoPasswordError;
    };
};

#endif