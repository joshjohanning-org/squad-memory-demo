---
name: migration-batch
description: Execute one bounded AtlasFX modernization batch using the migration rulebook, gap inventory, independent review, and mechanical validation.
---

# Migration Batch

Use this skill when implementing or rehearsing an AtlasFX migration work item.

## Inputs

- One work item from `docs/migration/WORK-QUEUE.md`
- `docs/migration/RULEBOOK.md`
- `docs/migration/GAPS.md`
- `docs/migration/VALIDATION.md`
- The source files named by the work item

## Required process

1. Confirm the work item's dependencies are complete.
2. State the source files and rulebook sections in scope.
3. Run the current-state judge before changing production code.
4. Implement only the assigned batch.
5. Mark unsupported mappings as `TODO(migration-gap): GAP-NNN`.
6. Add or update the matching entry in `docs/migration/GAPS.md`.
7. Run the validation required by the work item.
8. Ask the reviewer to compare the diff with the rulebook and source behavior.
9. Do not mark the item complete until the reviewer accepts it and the judge passes.

## Reviewer independence

Give the reviewer:

- The work item
- The source and changed files
- The rulebook
- The validation output

Do not give the reviewer the implementer's reasoning as proof that the change is
correct.

## Required handoff

```text
Work item:
Files changed:
Rules applied:
Validation evidence:
Gaps created or resolved:
Assumptions:
Reviewer verdict:
```

## Learning loop

If the same defect appears in more than one file or batch, do not keep fixing it
locally. Propose a rulebook change, have the lead approve it, then revisit every
batch affected by that rule.
