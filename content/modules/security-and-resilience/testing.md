---
id: testing-01
title: Testing Boot 4 Applications
summary: Fast, layered tests for Spring Boot 4 services.
module: security-and-resilience
type: text
minLevel: newbie
targetOS: any
order: 30
tags: [testing, spring-test]
estimatedMinutes: 15
---

## Recommended testing pyramid

- **Unit tests**: business logic and utilities.
- **Slice tests**: web/data layers with Spring Test.
- **Integration tests**: full container + database.

```java
@WebMvcTest(CourseController.class)
class CourseControllerTest {
    // web slice tests
}
```

```java
@SpringBootTest
@Testcontainers
class CourseIntegrationTest {
    // integration tests
}
```

### Best practices

> **Best Practice:** Use Testcontainers for realistic integration tests without hardcoded infra.

> **Best Practice:** Keep tests deterministic; avoid sleep-based assertions.

