---
id: data-web-diagram-01
title: Web Request Lifecycle with Validation
summary: Visual flow of validation and error handling in a Boot 4 API.
module: data-and-web
type: diagram
minLevel: newbie
targetOS: any
order: 15
tags: [validation, diagram]
estimatedMinutes: 8
---

```mermaid
sequenceDiagram
  participant Client
  participant Controller
  participant Validator
  participant Service
  participant Repo
  Client->>Controller: POST /courses
  Controller->>Validator: Validate DTO
  Validator-->>Controller: Violations
  Controller->>Client: 400 + error schema
  Controller->>Service: Valid DTO
  Service->>Repo: Save
  Repo-->>Service: Entity
  Service-->>Controller: Result
  Controller-->>Client: 201 + payload
```

