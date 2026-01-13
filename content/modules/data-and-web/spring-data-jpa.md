---
id: data-jpa-01
title: Spring Data JPA & JDBC Client
summary: Choosing the right persistence abstraction in Boot 4.
module: data-and-web
type: text
minLevel: newbie
targetOS: any
order: 10
tags: [spring-data, jpa, jdbc]
estimatedMinutes: 18
---

## When to use JPA vs JDBC Client

- **JPA**: richer domain mapping, caching, and lifecycle hooks.
- **JDBC Client**: simpler, more explicit SQL, faster for read-heavy systems.

### Code example (JDBC Client)

```java
public List<Course> findByLevel(String level) {
    return jdbcClient.sql("select * from courses where level = :level")
        .param("level", level)
        .query(Course.class)
        .list();
}
```

### Code example (JPA Repository)

```java
public interface CourseRepository extends JpaRepository<Course, UUID> {
    List<Course> findByLevel(String level);
}
```

### Best practices

> **Best Practice:** Start with JDBC Client for simple workloads and add JPA only when you need richer object mapping.

> **Best Practice:** Keep transaction boundaries explicit with `@Transactional` at service boundaries.

