---
id: java-best-practices-01
title: Modern Java Best Practices for Spring Boot 4
summary: Opinionated guidance for writing clean, modern Java in Spring Boot 4.
module: modern-java-foundation
type: best-practice
minLevel: newbie
targetOS: any
order: 50
tags: [java, best-practices]
estimatedMinutes: 15
---

## Design and style

- Prefer **records** for request/response DTOs.
- Keep **immutability** as the default; use builders for complex objects.
- Use **sealed types** for domain boundaries where possible.

## Performance and safety

- Avoid premature optimization; measure with profiling tools.
- Keep logging structured; avoid logging secrets.
- Prefer `List.of(...)` and `Map.of(...)` for unmodifiable collections.

## Spring-friendly practices

- Use `@Validated` on services for guard rails.
- Keep mapping logic in dedicated mappers to avoid bloated controllers.

### Best practice callouts

> **Best Practice:** Keep your DTOs independent of persistence entities.

> **Best Practice:** Use Java toolchains to align local dev and CI builds.

