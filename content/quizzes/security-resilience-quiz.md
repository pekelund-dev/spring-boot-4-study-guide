---
id: quiz-security-resilience-01
title: Quiz: Security & Resilience
summary: Test your knowledge of Spring Security and resilience patterns.
module: security-and-resilience
type: quiz
minLevel: newbie
targetOS: any
order: 230
tags: [quiz, security]
estimatedMinutes: 10
---

```yaml
questions:
  - id: q1
    prompt: "Which component defines request authorization rules?"
    options:
      - "SecurityFilterChain"
      - "RestTemplate"
      - "JdbcClient"
      - "BeanFactory"
    answer: "SecurityFilterChain"
  - id: q2
    prompt: "When is retry recommended?"
    options:
      - "Non-idempotent writes"
      - "Idempotent operations"
      - "All operations"
      - "CPU-bound tasks"
    answer: "Idempotent operations"
```

