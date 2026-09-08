---
last_updated: 2026-09-08T17:17:12.881Z
---

# Team Wisdom

Reusable patterns and heuristics learned through work. NOT transcripts — each entry is a distilled, actionable insight.

## Patterns

**Pattern:** Inventory before inference. **Context:** For large-codebase analysis, enumerate the complete in-scope file set before describing architecture or claiming coverage.

**Pattern:** Durable memory should contain conclusions and evidence, not transcripts. **Context:** Distill conversations into facts, decisions, patterns, owners, and unresolved questions.

**Pattern:** Use characterization before extraction. **Context:** When modernizing legacy systems, capture current behavior before separating presentation, domain, and persistence concerns.

## Anti-Patterns

**Avoid:** Treating a long-running chat as the canonical project memory. **Why:** It is difficult to review, version, correct, scope, and share.

**Avoid:** Centralizing every instruction and fact in one file. **Why:** It increases context cost and mixes knowledge with different owners and lifetimes.
