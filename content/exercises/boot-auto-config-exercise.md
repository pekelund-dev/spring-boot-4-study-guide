---
id: exercise-auto-config-01
title: Exercise: Build a Custom Auto-Configuration
summary: Create an auto-configuration that registers a greeting service.
module: core-spring-essentials
type: exercise
minLevel: pro
targetOS: any
order: 100
tags: [exercise, auto-configuration]
estimatedMinutes: 25
---

## Goal

Create a Boot 4 auto-configuration that registers a `GreetingService` only when a property is enabled.

### Requirements

1. Create an interface `GreetingService` with a method `String greet(String name)`.
2. Provide a default implementation that returns `"Hello, <name>"`.
3. Register it only when `app.greeting.enabled=true`.
4. Ensure the bean is not created if another `GreetingService` exists.

### Starter guidance

```java
@AutoConfiguration
@EnableConfigurationProperties(GreetingProperties.class)
public class GreetingAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "app.greeting", name = "enabled", havingValue = "true")
    @ConditionalOnMissingBean
    GreetingService greetingService(GreetingProperties properties) {
        return name -> properties.getPrefix() + " " + name;
    }
}
```

### Validation checklist

- [ ] Auto-configuration class uses `@AutoConfiguration`.
- [ ] Bean uses `@ConditionalOnProperty`.
- [ ] Includes `@ConditionalOnMissingBean` on the service bean.
- [ ] Properties class uses `@ConfigurationProperties` with prefix `app.greeting`.

### Stretch goals

- Add a unit test using `ApplicationContextRunner`.
- Support a fallback greeting when the name is blank.

