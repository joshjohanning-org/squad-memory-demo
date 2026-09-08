package com.example.atlasfx;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public final class TradeEntryFrame {
    private final TradeService tradeService;

    public TradeEntryFrame(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    public void submit(String base, String counter, String notional, String rate, String trader) {
        Trade trade = new Trade(
                UUID.randomUUID(),
                CurrencyPair.of(base, counter),
                new BigDecimal(notional),
                new BigDecimal(rate),
                trader,
                Instant.now());

        tradeService.submit(trade);
    }
}
