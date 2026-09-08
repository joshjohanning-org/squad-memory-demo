package com.example.atlasfx;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TradeRepository {
    void save(Trade trade);

    Optional<Trade> findById(UUID id);

    List<Trade> findAll();
}
