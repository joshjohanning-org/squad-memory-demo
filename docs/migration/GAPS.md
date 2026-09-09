# AtlasFX Migration Gap Inventory

Use this file for cases where the rulebook does not define a safe
source-to-target mapping. A gap blocks only the affected work.

| ID | Area | Question | Affected work | Status | Decision owner |
|----|------|----------|---------------|--------|----------------|
| GAP-001 | Application API | Should the new application boundary use REST, messaging, or another interface? | PILOT-002 | Open | Lead |
| GAP-002 | Transactions | What must happen if persistence succeeds and audit emission fails? | PILOT-002, MIG-101 | Open | Lead and Security |
| GAP-003 | Audit policy | Which fields, retention rules, and delivery guarantees are required? | MIG-101 | Open | Security |
| GAP-004 | Persistence | Which production database and adapter technology should replace the in-memory repository? | MIG-102 | Open | Lead |
| GAP-005 | Client coexistence | How long must desktop and web clients operate together? | MIG-103 | Open | Lead |

## Adding a gap

1. Assign the next `GAP-NNN` identifier.
2. State the missing decision without proposing it as fact.
3. List the blocked work items.
4. Name the decision owner.
5. Add `TODO(migration-gap): GAP-NNN` only where code must remain incomplete.

The lead closes a gap by recording the approved decision, updating the
rulebook, and identifying every work item affected by the new rule.
