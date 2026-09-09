# AtlasFX Migration Instructions

AtlasFX is a fictional modernization demonstration. Do not treat proposed target
architecture as verified current behavior.

Before performing migration work:

1. Read `docs/migration/CHARTER.md`.
2. Read the relevant sections of `docs/migration/RULEBOOK.md`.
3. Check `docs/migration/GAPS.md` for unresolved decisions.
4. Select a bounded item from `docs/migration/WORK-QUEUE.md`.
5. Follow the `migration-batch` skill.

Do not invent a target pattern when the rulebook is silent. Record the case in
`docs/migration/GAPS.md` and stop the affected portion of the migration.

Every migration handoff must report:

- Work item ID
- Files changed
- Rulebook sections applied
- Validation evidence
- Gaps created or resolved
- Assumptions and unresolved risks

Production code is not considered migrated until an independent reviewer checks
the rulebook claims and the validation judge passes.
