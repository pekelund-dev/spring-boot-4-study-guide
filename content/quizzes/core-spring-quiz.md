---
id: quiz-core-spring-01
title: Quiz: Core Spring Essentials
summary: Validate your understanding of IoC and auto-configuration.
module: core-spring-essentials
type: quiz
minLevel: newbie
targetOS: any
order: 250
tags: [quiz, spring]
estimatedMinutes: 10
---

```yaml
questions:
  - id: q1
    prompt: "Which injection style is recommended for required dependencies?"
    options:
      - "Field injection"
      - "Constructor injection"
      - "Static injection"
      - "Method parameter injection"
    answer: "Constructor injection"
  - id: q2
    prompt: "What file lists Boot auto-configuration imports?"
    options:
      - "META-INF/spring.factories"
      - "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports"
      - "application.yml"
      - "bootstrap.properties"
    answer: "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports"
```

