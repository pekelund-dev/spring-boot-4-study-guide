---
id: resilience-01
title: Built-in Resilience
summary: Resilience patterns with Spring Boot 4 defaults.
module: security-and-resilience
type: text
minLevel: pro
targetOS: any
order: 20
tags: [resilience, reliability]
estimatedMinutes: 14
---

## Patterns to adopt

- **Timeouts**: prevent cascading failures.
- **Bulkheads**: isolate critical resources.
- **Retry**: only for idempotent operations.
- **Circuit breakers**: fast-fail on downstream outages.

### Sample config (pseudo)

```yaml
resilience:
  timeouts:
    default: 2s
  retry:
    maxAttempts: 2
```

### Best practices

> **Best Practice:** Make resilience policies explicit and visible in configuration rather than hiding defaults.

> **Best Practice:** Ensure retries include backoff and jitter to avoid traffic spikes.

