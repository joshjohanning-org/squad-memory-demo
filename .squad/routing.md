# Work Routing

How to decide who handles what.

## Routing Table

| Work Type | Route To | Examples |
|-----------|----------|----------|
| Architecture recovery and migration sequencing | lead | Current-state maps, target architecture, migration slices |
| Bounded migration implementation | migrator | Characterization fixtures, adapter extraction, approved transformations |
| Evidence and coverage verification | reviewer | File inventory, unsupported claims, test gaps |
| Developer workflow and adoption | devrel | CLI experience, onboarding, repeatable demos |
| Threat modeling and data boundaries | security | Secrets, permissions, trust boundaries, audit requirements |
| Durable knowledge organization | docs | ADRs, architecture reports, glossary, memory placement |

Preset installation adds concrete routes for the configured team. Add or edit rows
here only when their agent names also exist in the casting registry.

## Issue Routing

| Label | Action | Who |
|-------|--------|-----|
| `squad` | Triage: analyze issue, assign `squad:{member}` label | Lead |
| `squad:{name}` | Pick up issue and complete the work | Named member |

### How Issue Assignment Works

1. When a GitHub issue gets the `squad` label, the **Lead** triages it — analyzing content, assigning the right `squad:{member}` label, and commenting with triage notes.
2. When a `squad:{member}` label is applied, that member picks up the issue in their next session.
3. Members can reassign by removing their label and adding another member's label.
4. The `squad` label is the "inbox" — untriaged issues waiting for Lead review.

## Rules

1. **Eager by default** — spawn all agents who could usefully start work, including anticipatory downstream work.
2. **Scribe always runs** after substantial work, always as `mode: "background"`. Never blocks.
3. **Quick facts → coordinator answers directly.** Don't spawn an agent for "what port does the server run on?"
4. **When two agents could handle it**, pick the one whose domain is the primary concern.
5. **"Team, ..." → fan-out.** Spawn all relevant agents in parallel as `mode: "background"`.
6. **Anticipate downstream work.** If a feature is being built, spawn the tester to write test cases from requirements simultaneously.
7. **Issue-labeled work** — when a `squad:{member}` label is applied to an issue, route to that member. The Lead handles all `squad` (base label) triage.

## Work Type → Agent

| Work Type | Primary | Secondary |
|-----------|---------|----------|
| Whole-codebase modernization assessment | lead | reviewer |
| Migration work item implementation | migrator | reviewer |
| Migration rule or gap decision | lead | security |
| Coverage or evidence challenge | reviewer | docs |
| Developer onboarding and usability | devrel | docs |
| Security and compliance analysis | security | reviewer |
| Documentation and memory curation | docs | lead |
