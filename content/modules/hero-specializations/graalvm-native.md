---
id: graalvm-native-01
title: GraalVM & Native Images
summary: Compile Spring Boot 4 apps into fast-starting native binaries.
module: hero-specializations
type: text
minLevel: hero
targetOS: any
order: 20
tags: [graalvm, native]
estimatedMinutes: 16
---

## Why native images

- Instant startup for serverless workloads.
- Lower memory footprint.
- Smaller deployment units for edge environments.

### Useful commands

```bash
./gradlew nativeCompile
./gradlew nativeRun
```

```powershell
./gradlew nativeCompile
./gradlew nativeRun
```

### Pitfalls to watch

- Reflection configuration may be required.
- Dynamic proxies can require hints.
- Native images favor ahead-of-time initialization.

### Best practices

> **Best Practice:** Keep reflection usage minimal and register configuration explicitly.

> **Best Practice:** Use the Spring AOT engine to generate hints automatically where possible.

