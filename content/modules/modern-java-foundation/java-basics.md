---
id: java-basics-01
title: Java 21/25 Basics: What Changed
summary: Key language, runtime, and platform improvements that matter for Spring Boot 4.
module: modern-java-foundation
type: text
minLevel: newbie
targetOS: any
order: 10
tags: [java21, java25, foundations]
estimatedMinutes: 25
---

## Why this matters for Spring Boot 4

Spring Boot 4 targets modern JVMs, so understanding the latest Java features helps you design clearer APIs, safer concurrency, and more efficient services. The goal is not to memorize every JEP, but to know what improves daily Spring development.

## Highlights you should know

### Language and API evolution

- **Record patterns & pattern matching**: reduce boilerplate when mapping data in controllers and DTOs.
- **Sealed types**: model domain constraints (e.g., only certain event types) with compile-time enforcement.
- **Text blocks**: cleaner SQL and JSON in configuration, tests, and examples.
- **Sequenced collections**: predictable ordered data handling for responses and UI.

### Runtime improvements

- **Virtual threads**: scale request handling without oversubscribing platform threads.
- **Enhanced GC telemetry**: better observability in prod environments.
- **Foreign memory and functions** (where applicable): faster interop for high-performance integrations.

## Example: DTO mapping with record patterns

```java
public sealed interface ContentItem permits Lesson, Quiz, Exercise {}

public record Lesson(String title, int minutes) implements ContentItem {}
public record Quiz(String title, int questions) implements ContentItem {}

public String describe(ContentItem item) {
    return switch (item) {
        case Lesson(var title, var minutes) -> "%s (%d min)".formatted(title, minutes);
        case Quiz(var title, var questions) -> "%s (%d questions)".formatted(title, questions);
        case Exercise(var title, var minutes) -> "%s (%d min)".formatted(title, minutes);
    };
}
```

## Best practices

> **Best Practice:** Prefer immutable data structures (records + unmodifiable collections) for DTOs to improve safety and clarity.

> **Best Practice:** Keep compatibility in mind: compile your app with the Java toolchain version you deploy to.

## Useful commands

```bash
java -version
javac --release 21 Main.java
```

```powershell
java -version
javac --release 21 Main.java
```

## Quick checkpoints

- You can explain the difference between records and traditional POJOs.
- You can identify where virtual threads help (blocking I/O scenarios).
- You can use pattern matching in at least one controller or mapper.

