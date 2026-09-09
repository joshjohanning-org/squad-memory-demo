# Squad Memory Demo

A safe, fictional demo of [Squad](https://github.com/bradygaster/squad) for exploring multi-agent orchestration and file-backed memory with GitHub Copilot.

The repository models **AtlasFX**, a fictional 25-year-old Java desktop application being assessed for migration to a three-tier web architecture. It contains no customer code, data, architecture, or other proprietary material.

> [!WARNING]
> Squad is alpha software. Its commands, file formats, and behavior can change. Review generated changes before committing them, and do not use broad automatic tool approval with sensitive repositories.

## What this demonstrates

- A coordinator that routes work to specialist personas.
- Shared decisions that every agent reads.
- Per-agent history that accumulates specialized context.
- Distilled team wisdom containing reusable patterns and anti-patterns.
- Skills that encode repeatable workflows.
- A small codebase whose cross-file relationships can be analyzed and verified.
- Optional Graphify output for exploring the codebase as a knowledge graph.

## Quick start

Prerequisites:

- Git
- [GitHub Copilot CLI](https://docs.github.com/copilot/how-tos/set-up/install-copilot-cli)
- Node.js 22.5 or later when installing Squad through npm

```bash
git clone https://github.com/joshjohanning-org/squad-memory-demo.git
cd squad-memory-demo
npm install --global @bradygaster/squad-cli@0.13.0
squad doctor
copilot --agent squad
```

The repository includes `.mcp.json`, which starts Squad's local state MCP server through `npx`. Review the configuration before approving it.

## Optional: visualize the codebase with Graphify

[Graphify](https://github.com/Graphify-Labs/graphify) can build an interactive knowledge graph from the fictional AtlasFX source and documentation. This is separate from Squad memory:

- Graphify models relationships in the repository.
- Squad retains findings, decisions, hypotheses, and reusable guidance from the team's work.

The repository includes Graphify's project-scoped GitHub Copilot CLI skill under `.copilot/skills/graphify/`. Install Graphify with `pipx`, then start Copilot:

```bash
pipx install graphifyy
pipx ensurepath
copilot --agent squad
```

Open a new terminal after running `pipx ensurepath` so the `graphify` command is available.

Inside Copilot CLI, run:

```text
/graphify src/main/java
```

Graphify writes the generated graph, report, wiki, and cache to `graphify-out/`. The directory is ignored because the output can be regenerated from the repository. For this small demo, its main value is visualizing cross-file relationships rather than reducing context usage.

To update an existing graph after the source changes:

```text
/graphify src/main/java --update
```

To run Graphify directly:

```bash
graphify extract src/main/java --code-only --out .
```

## End-to-end demo

This walkthrough demonstrates the full flow:

```text
multi-agent analysis
  -> long working conversation
  -> candidate memory extraction
  -> evidence and reviewer gate
  -> Scribe persistence
  -> file inspection
  -> new session recall
```

### Step 1: Start Squad

From the repository root:

```bash
copilot --agent squad
```

Keep this Copilot session open through step 5.

### Step 2: Analyze the fictional application

Paste this into Copilot:

```text
Team, analyze the complete AtlasFX application.

Produce an evidence-backed current-state architecture and modernization risk assessment. Enumerate every Java source file before making whole-codebase claims. Cite every source file you rely on and have the reviewer challenge unsupported conclusions.
```

Expected behavior:

- The coordinator routes work to relevant specialist personas.
- The lead reconstructs the architecture and execution flow.
- The reviewer compares coverage claims with the actual source inventory.
- Security examines trust boundaries and audit behavior.
- Docs organizes the findings.
- Scribe records the work after the agent batch completes.

The important result is a verified source-code analysis, not memory recall yet.

### Step 3: Add decisions, a hypothesis, and a follow-up

Continue in the same Copilot session:

```text
For the modernization plan, preserve the existing trade validation and audit behavior. Prefer an incremental migration over a big-bang rewrite.

We are considering a REST API between the future web client and application service, but that is only a hypothesis. We have not selected the API style yet.

The next action is to identify characterization tests for the trade submission path.
```

This deliberately introduces different types of information:

| Information | Intended classification |
|-------------|-------------------------|
| Preserve validation and auditing | Project decision |
| Prefer incremental migration | Project decision |
| Consider a REST API | Hypothesis, not a decision |
| Identify characterization tests | Open follow-up |

### Step 4: Extract candidate memory

Ask Squad to run the distillation process without writing anything yet:

```text
Run the conversation-distillation skill on everything discussed in this session.

Extract only information that should affect future work. Classify each candidate as a fact, decision, directive, pattern, anti-pattern, or follow-up.

For each candidate, include:
- The standalone statement
- Its evidence
- Whether it is verified, user-directed, a hypothesis, or still open
- The proposed memory destination

Have the reviewer mark each candidate as accept, revise, or drop.

Do not persist anything yet. Show me the candidate table first.
```

Expected output should resemble:

| Type | Statement | Status | Destination | Verdict |
|------|-----------|--------|-------------|---------|
| Fact | Trade submission includes validation, persistence, and auditing | Verified from source | Agent history | Accept |
| Decision | Preserve validation and audit behavior | User-directed | `decisions.md` | Accept |
| Decision | Use incremental migration | User-directed | `decisions.md` | Accept |
| Hypothesis | Introduce a REST API | Unconfirmed | Session log | Accept as hypothesis |
| Pattern | Characterize behavior before extraction | Reusable | `wisdom.md` | Accept |
| Follow-up | Identify characterization tests | Open | Session log and task tracker | Accept |

The exact wording may differ. The key behavior is that the REST idea remains a hypothesis instead of silently becoming an architecture decision.

### Step 5: Approve and persist the accepted entries

After reviewing the candidate table, paste:

```text
Persist the accepted and revised entries.

Use the proposed destinations:
- Project decisions and directives go to shared decisions
- Specialist knowledge goes to the appropriate agent history
- Reusable modernization patterns go to team wisdom
- Repeatable procedures go to skills
- Hypotheses and open follow-ups stay clearly marked

Ask Scribe to perform the writes and verify each destination by reading it back. Then tell me exactly which files or memory records changed.
```

Expected behavior:

- Scribe writes shared decisions to `.squad/decisions.md`.
- Project-specific findings may go to an agent's `history.md`.
- Reusable patterns may go to `.squad/identity/wisdom.md`.
- The REST API idea remains explicitly unconfirmed.
- Scribe reads the destinations back to confirm persistence.

### Step 6: Inspect the memory

In another terminal, or after leaving Copilot, run:

```bash
git status --short
git diff -- .squad/decisions.md
git diff -- .squad/identity/wisdom.md
git diff -- .squad/agents
git diff -- .github/skills
```

You can also ask Squad:

```text
Show me exactly what was persisted from this session and where each item was stored.
```

Session and orchestration logs may not appear in `git diff` because the demo ignores runtime log directories.

### Step 7: End the first session

Inside Copilot CLI:

```text
/exit
```

Leave the generated memory changes uncommitted. This makes them easy to inspect during the demo.

### Step 8: Start a new session

From the same repository:

```bash
copilot --agent squad
```

Do not explain AtlasFX again. Ask only:

```text
Without repeating the previous analysis, tell me:

1. What is verified about the current AtlasFX trade submission flow?
2. What modernization decisions did we make?
3. What architecture ideas remain hypotheses?
4. What reusable modernization lesson did the team retain?
5. What follow-up remains open?

For every answer, identify the Squad memory source you used.
```

A successful result distinguishes:

- **Verified fact:** validation, persistence, and audit are part of submission.
- **Decision:** preserve those behaviors and migrate incrementally.
- **Hypothesis:** a REST API is being considered but has not been selected.
- **Wisdom:** characterize existing behavior before extracting components.
- **Follow-up:** identify characterization tests.

### Step 9: Show the result

Run:

```bash
git diff -- .squad .github/skills
```

The demonstration story is:

> We had a long working conversation containing facts, decisions, ideas, and follow-ups. Squad distilled it, reviewed the candidate knowledge, stored each accepted item in the appropriate memory layer, and a new session recovered the important context without replaying the transcript.

If Squad does not automatically select the distillation skill, use the complete prompt from step 4. The prompt contains the full procedure and does not depend on automatic skill selection.

## How Squad's memory is structured

| Layer | Location | Purpose |
|-------|----------|---------|
| Current focus | `.squad/identity/now.md` | Short-lived description of what the team is working on now |
| Shared decisions | `.squad/decisions.md` | Active rules and architecture decisions read by the team |
| Decision inbox | `.squad/decisions/inbox/` | Parallel agent writes awaiting consolidation by the Scribe |
| Agent history | `.squad/agents/*/history.md` | Specialized observations retained by an individual persona |
| Team wisdom | `.squad/identity/wisdom.md` | Distilled patterns and anti-patterns intended to survive long term |
| Skills | `.github/skills/*/SKILL.md` | Reusable procedures that teach agents how to perform a task |
| Tiered state | `.squad/memory/` | Squad's local memory index, policy, audit, and provider state |
| Orchestration logs | `.squad/orchestration-log/` | Append-only records of agent dispatches, ignored by this demo |

The files serve different purposes:

- **Decisions** answer, "What have we agreed to do?"
- **History** answers, "What has this specialist learned?"
- **Wisdom** answers, "What reusable lesson should the whole team retain?"
- **Skills** answer, "How should the team repeat this kind of work?"

The `conversation-distillation` skill provides a concrete extraction schema and placement rules for turning a long session into these layers.

Squad's documentation describes progressive summarization for growing history and decision files. Skills and wisdom are intended for durable knowledge. See [Memory and Knowledge](https://bradygaster.github.io/squad/docs/concepts/memory-and-knowledge/).

## Demo repository layout

```text
.
├── .github/
│   ├── agents/squad.agent.md
│   └── skills/whole-codebase-analysis/SKILL.md
├── .squad/
│   ├── agents/
│   ├── decisions.md
│   ├── identity/
│   │   ├── now.md
│   │   └── wisdom.md
│   ├── memory/
│   ├── routing.md
│   └── team.md
├── docs/
│   ├── demo-guide.md
│   └── modernization-brief.md
└── src/main/java/com/example/atlasfx/
```

## Governance guidance

Treat `.squad/` as code:

1. Review memory changes in pull requests.
2. Keep facts, hypotheses, decisions, and reusable guidance separate.
3. Do not persist secrets, customer data, personal data, or raw confidential transcripts.
4. Assign owners to shared skills and important decisions.
5. Archive or remove stale knowledge instead of letting context grow indefinitely.
6. Require evidence for claims about large-codebase coverage.
7. Apply the same security and quality gates to agent-authored changes as human-authored changes.

Squad's coordinator and compliance behavior is prompt-driven. The Markdown files improve continuity and auditability, but they are not a hard policy enforcement boundary.

## Useful Squad commands

```bash
squad doctor
squad status
squad cost
squad upgrade --dry-run
```

## Sources

- [Squad repository](https://github.com/bradygaster/squad)
- [Installation](https://bradygaster.github.io/squad/docs/get-started/installation/)
- [Memory and Knowledge](https://bradygaster.github.io/squad/docs/concepts/memory-and-knowledge/)
- [GitHub Copilot agent skills](https://docs.github.com/en/enterprise-cloud@latest/copilot/concepts/agents/about-agent-skills)
- [Graphify](https://github.com/Graphify-Labs/graphify)

Squad is distributed under the MIT License. This demo is independently authored and is not an official Squad sample.
