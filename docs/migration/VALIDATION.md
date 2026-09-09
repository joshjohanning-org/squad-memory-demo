# AtlasFX Migration Validation

## Purpose

The validation judge compares migration work with observable source behavior.
Agent confidence and code review are not substitutes for this evidence.

## Baseline judge

Run:

```bash
./scripts/validate-characterization.sh
```

The harness verifies:

- A valid trade is persisted once.
- A valid trade emits one audit event.
- Validation rejects non-positive notionals.
- Validation rejects notionals above the desktop approval limit.
- Validation rejects non-positive rates.
- Validation rejects blank traders.
- Rejected trades produce no persistence or audit side effects.

Run the judge before and after every production-code migration batch. A batch
must not weaken or delete an assertion merely to make the target pass.

## Validating the judge

A trustworthy judge must detect breakage. During the demonstration:

1. Run the baseline and confirm it passes.
2. Make a temporary local mutation, such as swapping persistence and validation.
3. Run the judge and confirm it fails.
4. discard the temporary mutation.

Do not commit the deliberate defect.

## Work-item evidence

Each completed work item records:

```text
Command: ./scripts/validate-characterization.sh
Result: pass | fail
Relevant rule IDs:
Reviewer:
```

Future migration slices may add compiler, API contract, database integration,
security, and deployment checks. Add those checks here before relying on them as
completion gates.
