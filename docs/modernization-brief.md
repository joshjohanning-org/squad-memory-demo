# AtlasFX Modernization Brief

## Scenario

AtlasFX is a fictional Java desktop application used to capture foreign-exchange trades. It represents a small teaching example, not a production system.

The current application combines:

- A desktop presentation layer.
- Business validation and pricing.
- Direct persistence calls.
- Audit-event creation.

## Desired outcome

Assess a gradual move toward:

1. A web presentation layer.
2. An application API.
3. Isolated domain services.
4. Replaceable persistence adapters.

## Constraints

- Preserve trade validation behavior.
- Preserve auditability.
- Avoid a big-bang rewrite.
- Separate verified source-code facts from proposed future architecture.
- Every whole-codebase claim must include a complete source-file inventory.

## Open questions

- Which behaviors need characterization tests before extraction?
- Where should transaction boundaries live?
- How will desktop and web clients coexist during migration?
- Which audit fields are required by policy?
