# AtlasFX Migration Work Queue

The queue is deliberately small. Its purpose is to demonstrate dependency-aware,
resumable migration work rather than complete the modernization.

| ID | Work item | Depends on | Completion evidence | Status |
|----|-----------|------------|---------------------|--------|
| PILOT-001 | Establish the trade-submission characterization judge | None | Baseline harness passes and reviewer confirms coverage | Ready |
| PILOT-002 | Design a disposable application-boundary adapter | PILOT-001, GAP-001, GAP-002 | Lead-approved design and adversarial review | Blocked |
| MIG-101 | Add the approved application adapter while retaining the desktop path | PILOT-002, GAP-003 | Judge and adapter contract checks pass | Blocked |
| MIG-102 | Add a replaceable production persistence adapter | MIG-101, GAP-004 | Judge and database integration checks pass | Blocked |
| MIG-103 | Introduce the web client and controlled desktop coexistence | MIG-101, GAP-005 | End-to-end parity scenarios pass | Blocked |

## Pilot behavior

`PILOT-002` is disposable. Its purpose is to stress-test the rulebook and expose
missing decisions. Do not merge its implementation as production progress.

## Selecting work

The coordinator may assign only items whose dependencies and required gaps are
resolved. A Migrator works on one item at a time and returns the handoff required
by `CHARTER.md`.

When repository state changes, rebuild the queue from this table and validation
evidence. Do not rely on an agent remembering what was completed in a prior chat.
