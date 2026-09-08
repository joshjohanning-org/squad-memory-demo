package com.example.atlasfx;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Trade(
        UUID id,
        CurrencyPair pair,
        BigDecimal notional,
        BigDecimal rate,
        String trader,
        Instant createdAt) {
}
