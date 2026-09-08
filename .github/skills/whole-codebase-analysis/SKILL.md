---
name: whole-codebase-analysis
description: Build an evidence-backed inventory and architecture model before making whole-codebase modernization claims.
---

# Whole-Codebase Analysis

Use this skill when a user asks for comprehensive analysis, modernization planning, architecture recovery, or confidence that an agent considered the full repository.

## Required process

1. Enumerate all in-scope source files before analysis.
2. State exclusions and the reason for each exclusion.
3. Trace entry points, dependencies, state changes, persistence, and externally visible behavior.
4. Cite file paths for every verified architectural claim.
5. Label inferred behavior as a hypothesis.
6. Ask the reviewer to compare the cited inventory with the actual file inventory.
7. Do not claim complete coverage when files were skipped, inaccessible, generated, or too large to inspect.

## Output

Return:

- Scope and complete file inventory.
- Current-state component and dependency map.
- Verified cross-file execution paths.
- Unknowns and hypotheses.
- Modernization risks.
- Recommended next discovery steps.
- Reviewer coverage assessment.

## Durable learning

- Project-specific findings belong in agent history or shared decisions.
- Reusable analysis techniques belong in team wisdom or this skill.
- Raw conversation transcripts do not belong in durable memory.
