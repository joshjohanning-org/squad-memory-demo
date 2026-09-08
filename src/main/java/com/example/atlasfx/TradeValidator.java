package com.example.atlasfx;

import java.math.BigDecimal;

public final class TradeValidator {
    private static final BigDecimal MAX_NOTIONAL = new BigDecimal("100000000");

    public void validate(Trade trade) {
        if (trade.notional().signum() <= 0) {
            throw new IllegalArgumentException("Notional must be positive");
        }
        if (trade.notional().compareTo(MAX_NOTIONAL) > 0) {
            throw new IllegalArgumentException("Notional exceeds the desktop approval limit");
        }
        if (trade.rate().signum() <= 0) {
            throw new IllegalArgumentException("Rate must be positive");
        }
        if (trade.trader() == null || trade.trader().isBlank()) {
            throw new IllegalArgumentException("Trader is required");
        }
    }
}
