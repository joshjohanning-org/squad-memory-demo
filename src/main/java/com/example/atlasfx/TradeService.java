package com.example.atlasfx;

public final class TradeService {
    private final TradeValidator validator;
    private final TradeRepository repository;
    private final AuditLog auditLog;

    public TradeService(TradeValidator validator, TradeRepository repository, AuditLog auditLog) {
        this.validator = validator;
        this.repository = repository;
        this.auditLog = auditLog;
    }

    public void submit(Trade trade) {
        validator.validate(trade);
        repository.save(trade);
        auditLog.tradeSubmitted(trade);
    }
}
