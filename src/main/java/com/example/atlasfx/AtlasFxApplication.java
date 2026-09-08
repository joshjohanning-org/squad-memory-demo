package com.example.atlasfx;

public final class AtlasFxApplication {
    private AtlasFxApplication() {
    }

    public static void main(String[] args) {
        TradeRepository repository = new InMemoryTradeRepository();
        TradeService service = new TradeService(
                new TradeValidator(),
                repository,
                new ConsoleAuditLog());
        TradeEntryFrame frame = new TradeEntryFrame(service);

        frame.submit("USD", "EUR", "2500000", "0.91", "demo-trader");
        System.out.printf("Stored trades: %d%n", repository.findAll().size());
    }
}
