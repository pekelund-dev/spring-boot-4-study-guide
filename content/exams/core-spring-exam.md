---
id: exam-core-spring-01
title: Exam: Core Spring & Boot 4 Essentials
summary: Timed exam covering IoC, auto-configuration, and starters.
module: core-spring-essentials
type: exam
minLevel: pro
targetOS: any
order: 300
tags: [exam, spring]
estimatedMinutes: 35
---

```yaml
timeLimitMinutes: 30
questions:
  - id: e1
    prompt: "Which annotation declares Boot auto-configuration classes?"
    options:
      - "@Configuration"
      - "@AutoConfiguration"
      - "@ComponentScan"
      - "@EnableWebMvc"
    answer: "@AutoConfiguration"
  - id: e2
    prompt: "What is the primary benefit of constructor injection?"
    options:
      - "Fewer imports"
      - "Hidden dependencies"
      - "Immutability and testability"
      - "Automatic caching"
    answer: "Immutability and testability"
  - id: e3
    prompt: "Where are Boot auto-configurations registered?"
    options:
      - "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports"
      - "application.yml"
      - "META-INF/spring.factories"
      - "META-INF/services"
    answer: "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports"
```

