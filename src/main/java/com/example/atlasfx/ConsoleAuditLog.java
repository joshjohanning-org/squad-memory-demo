package com.example.atlasfx;

public final class ConsoleAuditLog implements AuditLog {
    @Override
    public void tradeSubmitted(Trade trade) {
        System.out.printf(
                "AUDIT trade=%s pair=%s/%s trader=%s%n",
                trade.id(),
                trade.pair().base(),
                trade.pair().counter(),
                trade.trader());
    }
}
