---
id: exercise-java-foundation-01
title: Exercise: Build a Level-Aware Content Mapper
summary: Apply records, pattern matching, and collections to map content into a view model.
module: modern-java-foundation
type: exercise
minLevel: newbie
targetOS: any
order: 210
tags: [exercise, java21]
estimatedMinutes: 30
---

## Goal

Implement a mapper that turns heterogeneous content items into a unified `ContentCard` view.

### Requirements

1. Model content with a sealed interface and records for Lesson, Quiz, Exercise.
2. Use pattern matching in a `switch` to render titles and metadata.
3. Return a list of cards sorted by duration.

### Starter model

```java
public sealed interface ContentItem permits Lesson, Quiz, Exercise {}
public record Lesson(String title, int minutes) implements ContentItem {}
public record Quiz(String title, int questions) implements ContentItem {}
public record Exercise(String title, int minutes) implements ContentItem {}
```

### Validation checklist

- [ ] Uses sealed interface + records.
- [ ] Uses pattern matching in a switch.
- [ ] Returns immutable list.

