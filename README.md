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

## Suggested 10-minute demo

### 1. Ask the team to analyze the whole system

```text
Team, analyze the complete AtlasFX application. Produce an evidence-backed current-state architecture and modernization risk assessment. Cite every source file you relied on and have the reviewer challenge any unsupported claim.
```

This should fan work out across the lead, reviewer, security, docs, and developer-experience roles.

### 2. Establish a durable directive

```text
Always distinguish verified facts from hypotheses. Never claim whole-codebase coverage without listing every analyzed source file.
```

Squad should persist the directive through its decisions workflow so agents can use it in later sessions.

### 3. Ask for a migration slice

```text
Design the first migration slice for trade capture. Preserve the existing validation and audit behavior, but separate the desktop UI, business logic, and persistence concerns. Do not write code yet.
```

### 4. End the session and start a new one

Exit Copilot, then run:

```bash
copilot --agent squad
```

Ask:

```text
What does the team remember about AtlasFX, what decisions did we make, and what evidence standard must future modernization recommendations follow?
```

Then inspect the changed files:

```bash
git status --short
git diff
```

The useful part of the demo is that the memory is visible, reviewable, and versionable rather than hidden in a conversation.

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

Squad is distributed under the MIT License. This demo is independently authored and is not an official Squad sample.
