---
id: security-7-01
title: Spring Security 7 Essentials
summary: Authentication, authorization, and modern security defaults.
module: security-and-resilience
type: text
minLevel: newbie
targetOS: any
order: 10
tags: [security, spring-security]
estimatedMinutes: 20
---

## Core building blocks

- **Security filter chain**: the heart of request processing.
- **Authorization managers**: fine-grained access control.
- **Password encoders**: strong hashing with adaptive algorithms.

```java
@Bean
SecurityFilterChain appSecurity(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/content/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
        .build();
}
```

## Recommended defaults

- Enable CSRF for browser-based clients.
- Use `PasswordEncoder` with `BCrypt`.
- Separate public content endpoints from authenticated endpoints.

### Best practices

> **Best Practice:** Use least-privilege authorization and avoid broad `permitAll` outside public content.

> **Best Practice:** Keep secrets out of code; rely on environment variables or vaults.

