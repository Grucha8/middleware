package currencyMarket.server;

import currencyMarket.generated.*;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CurrencyRatesImpl extends CurrencyRatesGrpc.CurrencyRatesImplBase {
    private static final Logger logger = Logger.getLogger(CurrencyRatesImpl.class.getName());

    private final CurrencyBroker currencyBroker;

    public CurrencyRatesImpl(CurrencyBroker currencyBroker) {
        this.currencyBroker = currencyBroker;
    }

    @Override
    public void initCurrencyRates(WhichCurrencies request, StreamObserver<CurrencyRatesResponse> responseObserver) {

        responseObserver.onNext(getCurrentCurrencyRates(request));
        responseObserver.onCompleted();
        logger.log(Level.INFO, "New bank connected");
    }

    @Override
    public void streamCurrencyRates(WhichCurrencies request, StreamObserver<CurrencyRatesResponse> responseObserver) {

        while (true) {
            responseObserver.onNext(getCurrentCurrencyRates(request));

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private CurrencyRatesResponse getCurrentCurrencyRates(WhichCurrencies request) {
        return CurrencyRatesResponse
                .newBuilder()
                .addAllCurrencyAndRate(
                        request
                                .getCurrencyList()
                                .stream()
                                .map(
                                        currency -> CurrencyAndRate
                                                .newBuilder()
                                                .setCurrency(currency)
                                                .setRate(currencyBroker.currentCurrencyRates.get(currency))
                                                .build()
                                ).collect(Collectors.toList())
                ).build();
    }
}
