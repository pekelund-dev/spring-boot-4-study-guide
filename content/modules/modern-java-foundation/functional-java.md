---
id: java-functional-01
title: Functional Java in Modern Spring
summary: Practical functional patterns with streams, optionals, and records.
module: modern-java-foundation
type: code
minLevel: pro
targetOS: any
order: 30
tags: [functional, streams]
estimatedMinutes: 15
---

## Pattern: Mapping request DTOs

```java
public record CourseRequest(String title, int minutes) {}

public Course toEntity(CourseRequest request) {
    return Optional.ofNullable(request)
        .map(r -> new Course(r.title(), r.minutes()))
        .orElseThrow(() -> new IllegalArgumentException("Request required"));
}
```

## Functional error handling

```java
public Either<ValidationError, Course> validate(CourseRequest request) {
    return request.title().isBlank()
        ? Either.left(new ValidationError("title"))
        : Either.right(new Course(request.title(), request.minutes()));
}
```

## Stream-based aggregation

```java
public Map<String, Long> countByLevel(List<Course> courses) {
    return courses.stream()
        .collect(Collectors.groupingBy(Course::level, Collectors.counting()));
}
```

### Best practices

> **Best Practice:** Keep functional chains short and readable; break out helper methods for clarity.

> **Best Practice:** Avoid overusing `Optional` in fields; prefer it for return values.

