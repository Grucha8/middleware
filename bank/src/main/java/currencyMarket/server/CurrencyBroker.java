package currencyMarket.server;

import currencyMarket.generated.Currency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CurrencyBroker extends Thread {

    protected Map<Currency, Double> currentCurrencyRates = new HashMap<>();

    public CurrencyBroker() {
        currentCurrencyRates.put(Currency.USD, 3.6);
        currentCurrencyRates.put(Currency.EUR, 4.2);
        currentCurrencyRates.put(Currency.GBP, 5.0);
        currentCurrencyRates.put(Currency.CHF, 2.4);
    }

    public void run() {
        Random r = new Random();
        while (true) {
            currentCurrencyRates.replaceAll((k, v) -> {
                double newValue = v + (r.nextDouble() * 2 - 1) * 0.1;
                System.out.print(String.format("%s = %f ", k, newValue));
                if (newValue > v) System.out.println("+"); else System.out.println("-");
                return newValue;
            });
            System.out.println("===============");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
