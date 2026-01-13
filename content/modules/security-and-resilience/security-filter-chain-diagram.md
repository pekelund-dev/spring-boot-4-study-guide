---
id: security-filter-chain-01
title: Security Filter Chain Flow
summary: Visual overview of how requests pass through Spring Security filters.
module: security-and-resilience
type: diagram
minLevel: newbie
targetOS: any
order: 15
tags: [security, diagram]
estimatedMinutes: 8
---

```mermaid
flowchart LR
  A[Incoming Request] --> B[Security Filters]
  B --> C[Authentication]
  C --> D[Authorization]
  D --> E[Controller]
```

### Best practice

> **Best Practice:** Keep public and private routes in separate filter chains when possible.

