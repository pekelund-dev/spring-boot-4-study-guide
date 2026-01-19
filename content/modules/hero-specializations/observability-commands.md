---
id: observability-commands-01
title: Observability Commands and Endpoints
summary: Quick commands for checking metrics, health, and traces.
module: hero-specializations
type: command
minLevel: pro
targetOS: any
order: 35
tags: [observability, commands]
estimatedMinutes: 10
---

## Local checks

```bash
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/metrics
```

```powershell
Invoke-RestMethod http://localhost:8080/actuator/health
Invoke-RestMethod http://localhost:8080/actuator/metrics
```

### Best practice

> **Best Practice:** Lock down actuator endpoints in production and expose only what you need.

