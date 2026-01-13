# Spring Scholar Content

This directory contains all learning material as **content-as-data**. Every file is written in Markdown with a YAML front matter block so the platform can filter by level and operating system.

## Structure

```
content/
  manifest.yaml
  modules/
    modern-java-foundation/
    core-spring-essentials/
    data-and-web/
    security-and-resilience/
    hero-specializations/
    other/
  quizzes/
  exams/
  exercises/
```

## Authoring workflow

1. Add a new Markdown file under the appropriate module folder.
2. Fill out the YAML front matter fields described in `docs/content-schema.md`.
3. Add the file path to `content/manifest.yaml` in the right module and section.
4. Keep fragments small and focused so they can be re-ordered and filtered by level/OS.

