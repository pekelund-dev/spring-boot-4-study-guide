---
id: java-build-tools-01
title: Build Tools: Maven & Gradle for Boot 4
summary: Focused setup for fast feedback loops in Spring Boot 4.
module: modern-java-foundation
type: command
minLevel: newbie
targetOS: any
order: 40
tags: [maven, gradle]
estimatedMinutes: 10
---

## Maven (recommended for structured multi-module)

```bash
mvn -v
mvn -DskipTests package
```

```powershell
mvn -v
mvn -DskipTests package
```

## Gradle (great for fast incremental builds)

```bash
./gradlew -v
./gradlew bootRun
```

```powershell
./gradlew -v
./gradlew bootRun
```

## Toolchain configuration (Gradle)

```kotlin
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}
```

### Best practices

> **Best Practice:** Pin the Java toolchain version explicitly to keep CI and local builds consistent.

> **Best Practice:** Use the `dependencyManagement` plugin or BOMs to keep versions aligned.

