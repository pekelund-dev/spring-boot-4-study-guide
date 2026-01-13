---
id: spring-ioc-diagram-01
title: IoC Container Wiring Diagram
summary: Visual overview of how Spring wires beans at startup.
module: core-spring-essentials
type: diagram
minLevel: newbie
targetOS: any
order: 15
tags: [ioc, diagram]
estimatedMinutes: 8
---

```mermaid
flowchart TD
  A[Component Scan] --> B[Bean Definitions]
  B --> C[Dependency Graph]
  C --> D[Instantiate Beans]
  D --> E[Inject Dependencies]
  E --> F[Application Ready]
```

### Best practice

> **Best Practice:** Use `@Configuration` classes for explicit wiring of critical infrastructure.

