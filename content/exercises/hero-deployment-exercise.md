---
id: exercise-hero-deploy-01
title: Exercise: Containerize and Deploy
summary: Package a Spring Boot 4 service and deploy it to a local Kubernetes cluster.
module: hero-specializations
type: exercise
minLevel: hero
targetOS: any
order: 120
tags: [exercise, docker, kubernetes]
estimatedMinutes: 45
---

## Goal

Create a container image and deploy it with health probes.

### Requirements

1. Build an image using `docker build`.
2. Create a Kubernetes deployment with `liveness` and `readiness` probes.
3. Validate that the service is reachable.

### Validation checklist

- [ ] Image builds successfully.
- [ ] Deployment is healthy and ready.
- [ ] Probes are configured with correct paths.

