---
id: boot-starters-01
title: The Modularized Starter System
summary: How Boot 4 encourages smaller, composable starters.
module: core-spring-essentials
type: text
minLevel: pro
targetOS: any
order: 30
tags: [starters, modules]
estimatedMinutes: 12
---

## Why modular starters matter

Smaller starters reduce dependency bloat and make it easier to reason about application capabilities.

### Example

```groovy
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
```

### Best practices

> **Best Practice:** Prefer starter bundles that align with your bounded context instead of pulling the full web stack by default.

> **Best Practice:** Audit transitive dependencies regularly to keep the app lean.

