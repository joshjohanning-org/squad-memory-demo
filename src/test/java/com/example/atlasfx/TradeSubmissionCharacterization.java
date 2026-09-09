package com.example.atlasfx;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public final class TradeSubmissionCharacterization {
    private TradeSubmissionCharacterization() {
    }

    public static void main(String[] args) {
        acceptsValidTrade();
        rejectsInvalidTradesWithoutSideEffects();
        System.out.println("Trade submission characterization passed");
    }

    private static void acceptsValidTrade() {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();
        RecordingAuditLog auditLog = new RecordingAuditLog();
        TradeService service = new TradeService(new TradeValidator(), repository, auditLog);
        Trade trade = trade("2500000", "0.91", "demo-trader");

        service.submit(trade);

        check(repository.findAll().size() == 1, "valid trade must be persisted once");
        check(repository.findById(trade.id()).orElseThrow() == trade,
                "repository must retain the submitted trade");
        check(auditLog.submissionCount == 1, "valid trade must be audited once");
        check(auditLog.lastTrade == trade, "audit must receive the submitted trade");
    }

    private static void rejectsInvalidTradesWithoutSideEffects() {
        assertRejected(trade("0", "0.91", "demo-trader"), "Notional must be positive");
        assertRejected(trade("100000001", "0.91", "demo-trader"),
                "Notional exceeds the desktop approval limit");
        assertRejected(trade("2500000", "0", "demo-trader"), "Rate must be positive");
        assertRejected(trade("2500000", "0.91", " "), "Trader is required");
    }

    private static void assertRejected(Trade trade, String expectedMessage) {
        InMemoryTradeRepository repository = new InMemoryTradeRepository();
        RecordingAuditLog auditLog = new RecordingAuditLog();
        TradeService service = new TradeService(new TradeValidator(), repository, auditLog);

        try {
            service.submit(trade);
            throw new AssertionError("expected validation failure: " + expectedMessage);
        } catch (IllegalArgumentException error) {
            check(expectedMessage.equals(error.getMessage()),
                    "unexpected validation message: " + error.getMessage());
        }

        check(repository.findAll().isEmpty(), "rejected trade must not be persisted");
        check(auditLog.submissionCount == 0, "rejected trade must not be audited");
    }

    private static Trade trade(String notional, String rate, String trader) {
        return new Trade(
                UUID.fromString("4a53eb41-04c7-483c-9c3b-0fdcd41ea671"),
                CurrencyPair.of("USD", "EUR"),
                new BigDecimal(notional),
                new BigDecimal(rate),
                trader,
                Instant.parse("2026-09-08T12:00:00Z"));
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static final class RecordingAuditLog implements AuditLog {
        private int submissionCount;
        private Trade lastTrade;

        @Override
        public void tradeSubmitted(Trade trade) {
            submissionCount++;
            lastTrade = trade;
        }
    }
}
