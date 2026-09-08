package com.example.atlasfx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class InMemoryTradeRepository implements TradeRepository {
    private final Map<UUID, Trade> trades = new LinkedHashMap<>();

    @Override
    public void save(Trade trade) {
        trades.put(trade.id(), trade);
    }

    @Override
    public Optional<Trade> findById(UUID id) {
        return Optional.ofNullable(trades.get(id));
    }

    @Override
    public List<Trade> findAll() {
        return new ArrayList<>(trades.values());
    }
}
