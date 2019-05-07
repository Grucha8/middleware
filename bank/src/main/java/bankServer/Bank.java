package bankServer;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import currencyMarket.generated.Currency;

import java.util.*;

public class Bank {

    // first parameter is configuration file
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write premium range: ");

        Optional<Float> range;
        try {
            range = Optional.of(Float.parseFloat(scanner.nextLine()));
        } catch (Exception e) {
            System.err.println("Wrong number");
            e.getStackTrace();
            throw new RuntimeException();
        }

        System.out.println("Which currencies you want to observer (USD, EUR, GBP, CHF): ");
        String currencies = scanner.nextLine();

        CurrencyListener currencyListener = new CurrencyListener("localhost", 50061, getSetOfCurrencies(currencies));
        currencyListener.start();

        try (Communicator communicator = Util.initialize(args)) {
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("BankAdapter", "tcp -h localhost -p 10000:udp -h localhost -p 10000");

            BankOperationsI bankOperationsServant = new BankOperationsI(range.get(), adapter, currencyListener);
            adapter.add(bankOperationsServant, new Identity("registration", "registration"));
            adapter.activate();

            communicator.waitForShutdown();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    private static Set<Currency> getSetOfCurrencies(String currencies) {
        Set<Currency> currenciesSet = new HashSet<>();

        for (String c: currencies.split(" ")) {
            if (c.matches("USD|EUR|GBP|CHF"))
                currenciesSet.add(Currency.valueOf(c));
        }

        return currenciesSet;
    }
}
