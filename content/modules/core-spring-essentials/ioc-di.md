---
id: spring-ioc-01
title: IoC & Dependency Injection in Spring 7
summary: Understand container-managed components and constructor injection.
module: core-spring-essentials
type: text
minLevel: newbie
targetOS: any
order: 10
tags: [ioc, di]
estimatedMinutes: 18
---

## Key concepts

- **Inversion of Control**: the container builds and wires your components.
- **Constructor injection**: default choice for immutability and testability.
- **Configuration vs component scanning**: balance explicit config with auto discovery.

```java
@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }
}
```

## Wiring graph basics

Spring builds a dependency graph from beans. If multiple beans satisfy a dependency, you must resolve it:

```java
@Bean
@Primary
CourseRepository jdbcCourseRepository() {
    return new JdbcCourseRepository();
}
```

### Best practices

> **Best Practice:** Avoid field injection; it hides dependencies and complicates testing.

> **Best Practice:** Prefer constructor injection for required dependencies and setters only for optional ones.

