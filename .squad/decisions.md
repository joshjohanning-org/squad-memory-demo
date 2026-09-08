# Squad Decisions

## Active Decisions

### DEMO-001: Keep the scenario fictional

- **Decision:** All application names, code, business rules, users, and data in this repository are fictional.
- **Reason:** The repository is public and intended for demonstrations.
- **Status:** Active

### DEMO-002: Require evidence for coverage claims

- **Decision:** A whole-codebase claim must list every analyzed source file and disclose exclusions.
- **Reason:** Confidence should come from inspectable evidence rather than an agent assertion.
- **Status:** Active

### DEMO-003: Separate memory by durability

- **Decision:** Store project facts in decisions or agent history, reusable techniques in skills or wisdom, and avoid persisting raw transcripts.
- **Reason:** Different knowledge has different owners, lifetimes, and review requirements.
- **Status:** Active

## Governance

- Review durable memory changes like code.
- Never store secrets, personal data, customer data, or confidential transcripts.
- Mark facts, hypotheses, decisions, and reusable patterns explicitly.
