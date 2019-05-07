package bankServer;

import currencyMarket.generated.Currency;
import currencyMarket.generated.CurrencyRatesGrpc;
import currencyMarket.generated.CurrencyRatesResponse;
import currencyMarket.generated.WhichCurrencies;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CurrencyListener extends Thread {
    private static final Logger logger = Logger.getLogger(CurrencyListener.class.getName());


    private final ManagedChannel channel;
    private final CurrencyRatesGrpc.CurrencyRatesBlockingStub currencyRatesStub;
    private final CurrencyRatesGrpc.CurrencyRatesStub currencyRatesNonBlockingStub;

    private final Map<Currency, Double> currencyRates = new HashMap<>();


    public CurrencyListener(String host, int port, Set<Currency> currencySetToObserve) {
        for (Currency c: currencySetToObserve) {
            currencyRates.put(c, 0.0);
        }

        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        currencyRatesStub = CurrencyRatesGrpc.newBlockingStub(channel);
        currencyRatesNonBlockingStub = CurrencyRatesGrpc.newStub(channel);

        initCurrencyRates();
    }

    private void initCurrencyRates() {
        WhichCurrencies request = WhichCurrencies.newBuilder()
                .addAllCurrency(currencyRates.keySet())
                .build();

        CurrencyRatesResponse result = currencyRatesStub.initCurrencyRates(request);
        result.getCurrencyAndRateList().forEach(
                r -> currencyRates.put(r.getCurrency(), r.getRate())
        );

    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void run() {

        StreamObserver<CurrencyRatesResponse> responseObserver = new StreamObserver<CurrencyRatesResponse>() {
            @Override
            public void onNext(CurrencyRatesResponse value) {
                value.getCurrencyAndRateList().forEach(r -> {
                    System.out.println(String.format("%s = %f ", r.getCurrency(), r.getRate()));
                    currencyRates.put(r.getCurrency(), r.getRate());
                });
                System.out.println("===========");
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("RPC ERROR");
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed getting information about currencies");
            }
        };

        currencyRatesNonBlockingStub
                .streamCurrencyRates(
                        WhichCurrencies.newBuilder().addAllCurrency(currencyRates.keySet()).build(),
                        responseObserver
                );


    }


    public boolean checkIfThisCurrencyIsObserved(String currency) {
        return currencyRates.containsKey(Currency.valueOf(currency));
    }

    public double getCurrencyRate(String currency) {
        return currencyRates.get(Currency.valueOf(currency));
    }
}
