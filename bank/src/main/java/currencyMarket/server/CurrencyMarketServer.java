package currencyMarket.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class CurrencyMarketServer {
    private static final Logger logger = Logger.getLogger(CurrencyMarketServer.class.getName());

    private int port = 50061;
    private Server server;

    private void start(CurrencyBroker currencyBroker) throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new CurrencyRatesImpl(currencyBroker))
                .build()
                .start();
        logger.info("Currency Market Server started on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                CurrencyMarketServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) {

        CurrencyBroker currencyBroker = new CurrencyBroker();
        currencyBroker.start();

        CurrencyMarketServer currencyMarketServer = new CurrencyMarketServer();

        try {
            currencyMarketServer.start(currencyBroker);
            currencyMarketServer.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
