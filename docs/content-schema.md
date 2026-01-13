# Content Schema (Spring Scholar)

Every content file uses YAML front matter so the platform can parse and filter it. The body is Markdown and can include Mermaid diagrams or code blocks.

## Required fields

```yaml
id: java-basics-01
title: Java 21/25 Basics: What Changed
summary: A quick overview of the most important language and runtime changes.
module: modern-java-foundation
type: text
minLevel: newbie
targetOS: any
order: 10
```

## Optional fields

```yaml
tags: [java21, java25, foundations]
estimatedMinutes: 10
prerequisites:
  - java-basics-00
levelVariants:
  newbie: java-basics-01
  pro: java-basics-01-pro
  hero: java-basics-01-hero
```

## Supported content types

- `text`
- `diagram`
- `code`
- `best-practice`
- `command`
- `exercise`
- `quiz`
- `exam`

## Target OS values

- `any`
- `windows`
- `wsl`
- `mac`
- `linux`

## Notes

- For diagrams, include Mermaid code blocks: ` ```mermaid `.
- For commands, include separate blocks for Bash and PowerShell when needed.
- For quizzes/exams, keep a YAML block in the Markdown body with questions and answers so they can be parsed later.

