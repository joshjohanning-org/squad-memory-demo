# Facilitator Guide

## Goal

Show how a multi-agent team can preserve useful project context between sessions without treating a long chat transcript as the source of truth.

## Story

AtlasFX is a fictional foreign-exchange trade capture system:

- The desktop UI calls persistence code directly.
- Validation is split between UI and service classes.
- Audit events are written during trade submission.
- The desired future state is a three-tier web architecture.

The demonstration asks Squad to build a reliable current-state model before recommending a migration.

## What to watch

After each substantial prompt, inspect:

```bash
git status --short
git diff -- .squad .github/skills docs
```

Useful questions:

- Did an agent record a fact, a hypothesis, or a decision?
- Is the information in the correct memory layer?
- Did the Scribe preserve the important conclusion without copying a transcript?
- Can another agent explain the conclusion and cite its source?
- Does a second session reuse the decision without being reminded?

## Prompts

### Current-state analysis

```text
Team, enumerate every Java source file, map the call flow from the desktop UI to persistence and audit, and document the current architecture. Mark anything you cannot verify as a hypothesis.
```

### Adversarial review

```text
Have the reviewer challenge the architecture report. Reject any statement that does not cite a source file or that implies full coverage without an inventory.
```

### Durable learning

```text
What did we learn that should become team wisdom, and what is specific to AtlasFX and belongs only in decisions or agent history?
```

### New session recall

```text
Without redoing the initial analysis, summarize the verified architecture, active migration decisions, known risks, and evidence standard.
```

## Expected discussion

The file-backed approach provides:

- Visibility and version history.
- Reuse across sessions and developers.
- A natural pull-request review point.
- Separation between current decisions and reusable techniques.

It also creates responsibilities:

- Memory can be wrong or stale.
- More files consume more model context.
- Prompts do not enforce policy like an authorization system.
- Sensitive information written to the repository remains sensitive.
- Parallel agents need a merge protocol to avoid conflicting writes.
