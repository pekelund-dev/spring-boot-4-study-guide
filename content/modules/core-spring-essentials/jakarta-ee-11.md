---
id: jakarta-ee-11-01
title: Jakarta EE 11 Alignment
summary: What changed in Jakarta EE 11 and why it matters for Boot 4.
module: core-spring-essentials
type: text
minLevel: newbie
targetOS: any
order: 40
tags: [jakarta-ee, jakarta11]
estimatedMinutes: 12
---

## Key alignment points

- **Namespace stability**: consistent `jakarta.*` APIs.
- **Security & validation updates**: relevant for web endpoints and DTOs.
- **Persistence modernization**: updated APIs used by Spring Data.

### Example validation annotation

```java
public record RegisterRequest(
    @Email String email,
    @NotBlank String password
) {}
```

### Best practices

> **Best Practice:** Keep your dependencies aligned with Jakarta EE 11 to avoid version skew in validation and persistence.

> **Best Practice:** Use BOMs to ensure all Jakarta API versions remain compatible.

