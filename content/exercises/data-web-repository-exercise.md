---
id: exercise-data-web-01
title: Exercise: Build a Repository with JDBC Client
summary: Implement a simple repository using the JDBC Client and parameter binding.
module: data-and-web
type: exercise
minLevel: newbie
targetOS: any
order: 110
tags: [exercise, jdbc]
estimatedMinutes: 30
---

## Goal

Create a repository that stores and fetches courses filtered by level.

### Requirements

1. Use `JdbcClient` to insert a course.
2. Query by `level` using named parameters.
3. Return results as a list of `Course` records.

### Validation checklist

- [ ] Uses named parameters.
- [ ] Maps rows to record constructor.
- [ ] Handles empty results safely.

