# Graph Report - squad-memory-demo  (2026-09-08)

## Corpus Check
- cluster-only mode — file stats not available

## Summary
- 39 nodes · 65 edges · 6 communities (2 shown, 4 thin omitted)
- Extraction: 85% EXTRACTED · 15% INFERRED · 0% AMBIGUOUS · INFERRED: 10 edges (avg confidence: 0.82)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `ded1dff7`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- Trade Submission Workflow
- Application and Auditing
- Trade Domain Operations
- In-Memory Trade Storage
- Currency Pair Model
- Repository Contract

## God Nodes (most connected - your core abstractions)
1. `Trade` - 14 edges
2. `TradeService` - 8 edges
3. `InMemoryTradeRepository` - 7 edges
4. `TradeRepository` - 7 edges
5. `AuditLog` - 5 edges
6. `TradeValidator` - 5 edges
7. `TradeEntryFrame` - 4 edges
8. `ConsoleAuditLog` - 4 edges
9. `CurrencyPair` - 4 edges
10. `AtlasFxApplication` - 3 edges

## Surprising Connections (you probably didn't know these)
- `ConsoleAuditLog` --implements--> `AuditLog`  [EXTRACTED]
  com/example/atlasfx/ConsoleAuditLog.java → com/example/atlasfx/AuditLog.java
- `TradeService` --references--> `TradeRepository`  [EXTRACTED]
  com/example/atlasfx/TradeService.java → com/example/atlasfx/TradeRepository.java
- `InMemoryTradeRepository` --references--> `Trade`  [EXTRACTED]
  com/example/atlasfx/InMemoryTradeRepository.java → com/example/atlasfx/Trade.java
- `Trade` --references--> `CurrencyPair`  [EXTRACTED]
  com/example/atlasfx/Trade.java → com/example/atlasfx/CurrencyPair.java
- `InMemoryTradeRepository` --implements--> `TradeRepository`  [EXTRACTED]
  com/example/atlasfx/InMemoryTradeRepository.java → com/example/atlasfx/TradeRepository.java

## Import Cycles
- None detected.

## Communities (6 total, 4 thin omitted)

### Community 0 - "Trade Submission Workflow"
Cohesion: 0.27
Nodes (4): AuditLog, TradeEntryFrame, TradeService, TradeValidator

### Community 1 - "Application and Auditing"
Cohesion: 0.25
Nodes (3): AtlasFxApplication, ConsoleAuditLog, Override

## Knowledge Gaps
- **4 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `Trade` connect `Trade Domain Operations` to `Application and Auditing`, `In-Memory Trade Storage`, `Currency Pair Model`, `Repository Contract`?**
  _High betweenness centrality (0.406) - this node is a cross-community bridge._
- **Why does `TradeService` connect `Trade Submission Workflow` to `Trade Domain Operations`, `Repository Contract`?**
  _High betweenness centrality (0.153) - this node is a cross-community bridge._
- **Why does `InMemoryTradeRepository` connect `In-Memory Trade Storage` to `Application and Auditing`, `Trade Domain Operations`, `Repository Contract`?**
  _High betweenness centrality (0.141) - this node is a cross-community bridge._