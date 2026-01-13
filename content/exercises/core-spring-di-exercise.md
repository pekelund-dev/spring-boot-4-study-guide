---
id: exercise-core-spring-di-01
title: Exercise: Refactor to Constructor Injection
summary: Improve testability by refactoring a service to constructor injection.
module: core-spring-essentials
type: exercise
minLevel: newbie
targetOS: any
order: 120
tags: [exercise, di]
estimatedMinutes: 25
---

## Goal

Refactor a Spring service currently using field injection to constructor injection, then write a unit test with mocks.

### Requirements

1. Replace `@Autowired` field injection with a constructor.
2. Add a unit test using `@ExtendWith(MockitoExtension.class)`.
3. Ensure the service fails fast if dependencies are missing.

### Validation checklist

- [ ] Constructor injection used.
- [ ] No field injection remains.
- [ ] Unit test covers happy path and error path.

