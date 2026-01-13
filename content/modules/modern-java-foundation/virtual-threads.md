---
id: java-virtual-threads-01
title: Virtual Threads for Spring Boot 4
summary: How virtual threads enable massive concurrency with simpler code.
module: modern-java-foundation
type: diagram
minLevel: newbie
targetOS: any
order: 20
tags: [virtual-threads, concurrency]
estimatedMinutes: 15
---

## The mental model

Virtual threads let you write familiar blocking code while the JVM handles scheduling efficiently.

```mermaid
flowchart LR
  A[Request arrives] --> B[Virtual Thread]
  B --> C[Blocking I/O]
  C --> D[Continuation parked]
  D --> E[Scheduler resumes]
```

## When to use them

- I/O-heavy request handling
- Integration-heavy services (HTTP, database, queue)
- Background tasks with lots of wait time

## When to be careful

- CPU-bound workloads (virtual threads do not increase CPU cores)
- Thread-local heavy code (prefer structured context propagation)

### Code example

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> service.handle(request));
}
```

### Best practice

> **Best Practice:** Use `Thread.ofVirtual()` for custom background work, but prefer Spring-managed executors for web requests.

> **Best Practice:** Tune connection pools conservatively; virtual threads do not replace database sizing.

