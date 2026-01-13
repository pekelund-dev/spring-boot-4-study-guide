---
id: boot-auto-config-01
title: Spring Boot 4 Auto-Configuration
summary: How Boot 4 automatically wires common infrastructure.
module: core-spring-essentials
type: text
minLevel: newbie
targetOS: any
order: 20
tags: [auto-configuration, boot]
estimatedMinutes: 16
---

## What auto-configuration does

Spring Boot 4 uses conditional configuration to wire beans when the right dependencies and properties are present. This keeps your configuration minimal but explicit.

### Key annotation

```java
@AutoConfiguration
public class ObservabilityAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    ObservationRegistry observationRegistry() {
        return ObservationRegistry.create();
    }
}
```

### How it is discovered

- Auto-configurations are listed under `META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
- Conditions evaluate classpath, properties, and existing beans.

### Best practices

> **Best Practice:** When overriding auto-configured beans, use `@ConditionalOnMissingBean` on your own config to preserve defaults.

> **Best Practice:** Keep configuration properties grouped and documented (`@ConfigurationProperties`).

