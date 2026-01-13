---
id: spring-ai-01
title: Spring AI Foundations
summary: Use Spring AI to build assistants and retrieval pipelines.
module: hero-specializations
type: text
minLevel: hero
targetOS: any
order: 10
tags: [spring-ai, ai]
estimatedMinutes: 18
---

## Core ideas

- **Prompt templates**: reusable instructions for the model.
- **Retrieval**: contextual search over your study content.
- **Tools/functions**: allow the model to call trusted APIs.

### Simple retrieval flow

```mermaid
flowchart LR
  A[Question] --> B[Vector Search]
  B --> C[Context]
  C --> D[Prompt Template]
  D --> E[Model Response]
```

### Best practices

> **Best Practice:** Store embeddings alongside content metadata to filter by level and OS before retrieval.

> **Best Practice:** Keep a human-readable trace of prompts and sources for auditability.

