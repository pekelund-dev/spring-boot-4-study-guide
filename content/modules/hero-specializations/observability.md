---
id: observability-01
title: Observability in Boot 4
summary: Metrics, logs, and traces for production insight.
module: hero-specializations
type: text
minLevel: pro
targetOS: any
order: 30
tags: [observability, metrics]
estimatedMinutes: 14
---

## Signals to capture

- **Metrics**: request latency, error rates.
- **Logs**: structured JSON logs with correlation IDs.
- **Traces**: end-to-end request visibility.

### Example: structured logging

```yaml
logging:
  pattern:
    console: '{"timestamp":"%d","level":"%p","traceId":"%X{traceId}","message":"%m"}%n'
```

### Best practices

> **Best Practice:** Standardize log fields (`traceId`, `spanId`, `userId`) across services for easier tracing.

> **Best Practice:** Expose health and metrics endpoints with appropriate security controls.

