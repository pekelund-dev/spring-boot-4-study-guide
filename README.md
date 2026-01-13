# spring-boot-4-study-guide

Spring Scholar is a "Zero to Hero" study platform for Spring Boot 4 and Spring Framework 7. The project starts with content-as-data so the learning material can be expanded quickly before wiring up user accounts and progress tracking.

## Content-first approach

- All study material lives in `content/` as Markdown with YAML metadata.
- The manifest (`content/manifest.yaml`) lists modules and ordering.
- Schema and authoring rules are in `docs/content-schema.md`.

## Build and run (Java 25 + Spring Boot 4)

### Prerequisites

- Java 25 installed (ensure `java -version` reports 25).
- Gradle (or use the Gradle wrapper once added).

### Build

```bash
gradle clean build
```

### Run

```bash
gradle bootRun
```

### Verify content endpoints

```bash
curl http://localhost:8080/api/content/manifest
curl http://localhost:8080/api/content/documents
curl "http://localhost:8080/api/content/documents?level=newbie&targetOS=any"
```
