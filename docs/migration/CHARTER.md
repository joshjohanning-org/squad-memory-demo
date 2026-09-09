# AtlasFX Migration Squad Charter

## Mission

Modernize AtlasFX incrementally while preserving observable trade-submission
behavior and producing inspectable evidence for every completed work item.

This repository demonstrates the migration operating model. It does not attempt
to complete the full rewrite.

## Sources of truth

1. Existing source code defines verified current behavior.
2. `RULEBOOK.md` defines approved migration transformations.
3. `GAPS.md` records unresolved mappings and design decisions.
4. `VALIDATION.md` defines the mechanical judge.
5. `WORK-QUEUE.md` defines bounded work, dependencies, and status.
6. `.squad/decisions.md` records approved project decisions and directives.

When these sources conflict, stop the affected work and ask the lead to resolve
the conflict. Do not silently choose one.

## Operating rules

- Establish a passing baseline before changing production code.
- Work on one bounded queue item at a time.
- Keep current-state facts separate from target-state proposals.
- Do not invent a target pattern when the rulebook is silent.
- Record unresolved cases in the gap inventory.
- Keep implementation and review in separate agent contexts.
- Treat compiler, test, and parity output as evidence.
- Fix repeated failures in the rulebook or workflow, not file by file.
- Preserve the existing desktop path until an approved work item removes it.

## Roles

| Role | Responsibility |
|------|----------------|
| Lead | Owns migration sequencing and approves rulebook changes |
| Migrator | Implements one bounded work item using approved rules |
| Reviewer | Challenges rule compliance and behavioral parity independently |
| Security | Reviews trust boundaries, sensitive data, and audit requirements |
| Docs | Keeps rulebook, gaps, evidence, and decisions aligned |
| Scribe | Persists reviewed decisions and durable learning |

## Required handoff

Every Migrator handoff must include:

```text
Work item:
Files changed:
Rules applied:
Validation evidence:
Gaps created or resolved:
Assumptions:
Reviewer verdict:
```

## Definition of done

A migration work item is complete only when:

- Its dependency items are complete.
- An independent reviewer accepts the implementation.
- Required validation passes.
- Every deviation is linked to an explicit gap.
- The work item contains evidence rather than an unsupported completion claim.
