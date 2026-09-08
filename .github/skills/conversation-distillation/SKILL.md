---
name: conversation-distillation
description: Extract durable facts, decisions, patterns, and follow-ups from a long working session without preserving the raw transcript as memory.
---

# Conversation Distillation

Use this skill after a long or multi-step working session when useful context should survive beyond the current conversation.

## Goal

Convert noisy conversation into a small set of evidence-backed memory entries. Do not summarize everything. Preserve only information that will change future work.

## Extraction schema

For each candidate, record:

```text
Type: fact | decision | directive | pattern | anti-pattern | follow-up
Statement: one concise, standalone statement
Evidence: source file, command result, or user statement
Scope: agent | project | reusable
Owner: responsible person or agent, when applicable
Status: verified | user-directed | hypothesis | open
Destination: agent history | decisions | wisdom | skill | session log
```

## Process

1. Identify statements that affect future work.
2. Drop greetings, brainstorming that went nowhere, repeated background, and superseded ideas.
3. Separate verified facts from hypotheses and proposals.
4. Detect conflicts with existing decisions and wisdom.
5. Ask the reviewer to reject unsupported, ambiguous, duplicated, or overly broad candidates.
6. Route accepted items using the placement rules below.
7. Have Scribe write the accepted items and record a brief session log.
8. Re-read the destination files and confirm that the accepted items were persisted.

## Placement rules

| Information | Destination |
|-------------|-------------|
| What happened during this session | `.squad/log/` |
| Project rule or architecture decision | `.squad/decisions.md` |
| Knowledge useful only to one specialist | `.squad/agents/{name}/history.md` |
| Reusable lesson for the whole team | `.squad/identity/wisdom.md` |
| Repeatable procedure with steps | `.github/skills/{name}/SKILL.md` |
| Unresolved work | Session log plus the project's normal task tracker |

## Retention rules

- Do not persist raw transcripts.
- Do not persist secrets, credentials, customer data, personal data, or confidential content.
- Do not promote a hypothesis into wisdom.
- Do not retain information merely because it was mentioned repeatedly.
- Prefer updating an existing entry over creating a near-duplicate.
- Record the source and date for facts likely to become stale.

## Output

Before writing memory, present a compact table of candidates:

| Type | Statement | Evidence | Destination | Verdict |
|------|-----------|----------|-------------|---------|

The reviewer verdict must be `accept`, `revise`, or `drop`.
