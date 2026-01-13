---
id: docker-k8s-01
title: Docker & Kubernetes Basics for Boot 4
summary: Packaging and deploying Spring Boot services.
module: hero-specializations
type: command
minLevel: pro
targetOS: any
order: 40
tags: [docker, kubernetes]
estimatedMinutes: 14
---

## Docker build

```bash
docker build -t spring-scholar:latest .
```

```powershell
docker build -t spring-scholar:latest .
```

## Kubernetes deploy (kubectl)

```bash
kubectl apply -f k8s/deployment.yaml
kubectl rollout status deployment/spring-scholar
```

```powershell
kubectl apply -f k8s/deployment.yaml
kubectl rollout status deployment/spring-scholar
```

### Best practices

> **Best Practice:** Use health probes (`liveness`, `readiness`) so Kubernetes can manage rollouts safely.

> **Best Practice:** Store configuration in ConfigMaps and secrets, not in container images.

