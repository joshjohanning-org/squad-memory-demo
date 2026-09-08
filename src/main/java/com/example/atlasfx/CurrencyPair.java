package com.example.atlasfx;

import java.util.Currency;

public record CurrencyPair(Currency base, Currency counter) {
    public static CurrencyPair of(String base, String counter) {
        return new CurrencyPair(Currency.getInstance(base), Currency.getInstance(counter));
    }
}
