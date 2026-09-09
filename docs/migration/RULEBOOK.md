# AtlasFX Migration Rulebook

This rulebook contains approved source-to-target transformations. Agents must
not infer missing rules from the desired architecture.

## Rule format

Each rule has a stable ID so Migrators can cite it and Reviewers can verify it.

```text
ID:
Source pattern:
Target pattern:
Required evidence:
Exceptions:
```

## Approved rules

### MIG-001: Preserve the domain model during boundary extraction

- **Source pattern:** `Trade` and `CurrencyPair` are created by the desktop entry
  path and passed to `TradeService`.
- **Target pattern:** New adapters may translate external input into the existing
  domain types. Do not duplicate validation rules in the adapter.
- **Required evidence:** Characterization tests pass against `TradeService`.
- **Exceptions:** Any required domain-model change must be recorded as a gap.

### MIG-002: Keep validation in the service path

- **Source pattern:** `TradeService.submit()` invokes `TradeValidator` before
  persistence and auditing.
- **Target pattern:** Every new entry point must call the same service path or an
  approved replacement with equivalent ordering.
- **Required evidence:** Invalid trades produce no persistence or audit event.
- **Exceptions:** Changes to validation messages or limits require an approved
  business decision.

### MIG-003: Preserve side-effect ordering

- **Source pattern:** Validation occurs before persistence, and persistence
  occurs before audit emission.
- **Target pattern:** Preserve this ordering until transaction and audit failure
  semantics are explicitly decided.
- **Required evidence:** Tests verify that rejected trades have no side effects
  and accepted trades are stored and audited once.
- **Exceptions:** See `GAP-002`.

### MIG-004: Introduce adapters without removing the desktop path

- **Source pattern:** `TradeEntryFrame` is the existing entry adapter.
- **Target pattern:** Add new delivery or persistence adapters behind existing
  domain interfaces. Keep the desktop path operational during the pilot.
- **Required evidence:** Existing characterization tests continue to pass.
- **Exceptions:** Removing the desktop path requires a separately approved work
  item and cutover plan.

### MIG-005: Cite rules and validation in every handoff

- **Source pattern:** An agent claims a migration batch is complete.
- **Target pattern:** The handoff names the applied rule IDs and includes the
  validation command and result.
- **Required evidence:** Reviewer can reproduce the result from repository state.
- **Exceptions:** None.

## Proposed patterns that are not rules

The following ideas remain hypotheses and must not be implemented as defaults:

- REST as the application API style
- Spring Boot as the application framework
- A specific persistent database or ORM
- Transaction boundaries
- Audit delivery guarantees
