# Spring Boot 4 Study Guide — Content Manifest

This manifest follows the 5-phase structure and aligns topics to the Spring project ecosystem (Spring Framework, Spring Boot, Spring Data, Spring Security, Spring AI, Spring Observability, Spring Cloud where relevant) as the source-of-truth surface area for the curriculum.

## Phase 1: The Modern Java Foundation (PH1)

### Lessons
- **PH1-L1 — Java 21/25 Basics**
  - Difficulty Variants: [Newbie, Pro, Hero]
  - Content File: [PH1-L1-Java-21-25-Basics.md](./PH1-L1-Java-21-25-Basics.md)
  - Includes: Theory, Diagrams, Examples, Best Practices, Exercises, Quiz, Exam
- **PH1-L2 — Virtual Threads**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH1-L3 — Functional Java**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH1-L4 — Build Tools (Maven/Gradle)**
  - Difficulty Variants: [Newbie, Pro, Hero]
  - OS Variants: [Windows, Mac, Linux]

### Quizzes (JSON)
```json
{
  "phase": "PH1",
  "quizzes": [
    {
      "id": "PH1-Q1",
      "topic": "Java 21/25 Language Features"
    },
    {
      "id": "PH1-Q2",
      "topic": "Virtual Threads & Concurrency"
    },
    {
      "id": "PH1-Q3",
      "topic": "Functional Java Patterns"
    },
    {
      "id": "PH1-Q4",
      "topic": "Build Tooling Fundamentals"
    }
  ]
}
```

### Hands-on Labs
- **PH1-LAB1 — Refactor DTOs to Records**
- **PH1-LAB2 — Virtual Thread Executor Lab**
- **PH1-LAB3 — Stream Pipeline Refactor**
- **PH1-LAB4 — Boot App Build & Run (Maven/Gradle)**

---

## Phase 2: Core Spring & Boot 4 Essentials (PH2)

### Lessons
- **PH2-L1 — IoC & Dependency Injection**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH2-L2 — Spring Boot 4 Auto-Configuration**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH2-L3 — The Modularized Starter System**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH2-L4 — Jakarta EE 11 Alignment**
  - Difficulty Variants: [Newbie, Pro, Hero]

### Quizzes (JSON)
```json
{
  "phase": "PH2",
  "quizzes": [
    {
      "id": "PH2-Q1",
      "topic": "IoC Container & Dependency Injection"
    },
    {
      "id": "PH2-Q2",
      "topic": "Boot 4 Auto-Configuration Mechanics"
    },
    {
      "id": "PH2-Q3",
      "topic": "Starter Modules & Dependency Graphs"
    },
    {
      "id": "PH2-Q4",
      "topic": "Jakarta EE 11 Namespace Migration"
    }
  ],
  "exams": [
    {
      "id": "PH2-EX1",
      "topic": "Core Spring & Boot 4 Essentials"
    }
  ]
}
```

### Hands-on Labs
- **PH2-LAB1 — Constructor Injection Refactor**
- **PH2-LAB2 — Build a Custom Boot Starter**
- **PH2-LAB3 — Create an Auto-Configuration Module**
- **PH2-LAB4 — Jakarta EE 11 Dependency Audit**

---

## Phase 3: Data & Web (Zero to Pro) (PH3)

### Lessons
- **PH3-L1 — Jakarta EE 11 Alignment for Data/Web**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH3-L2 — Spring Data JPA & JDBC Client**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH3-L3 — Validation & Error Handling**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH3-L4 — Web APIs with Spring MVC & Spring WebFlux**
  - Difficulty Variants: [Newbie, Pro, Hero]

### Quizzes (JSON)
```json
{
  "phase": "PH3",
  "quizzes": [
    {
      "id": "PH3-Q1",
      "topic": "Jakarta Data & Repository Abstractions"
    },
    {
      "id": "PH3-Q2",
      "topic": "JPA vs JdbcClient Tradeoffs"
    },
    {
      "id": "PH3-Q3",
      "topic": "Validation & ProblemDetail Errors"
    },
    {
      "id": "PH3-Q4",
      "topic": "Web API Layering (MVC/WebFlux)"
    }
  ]
}
```

### Hands-on Labs
- **PH3-LAB1 — Build a Repository with JdbcClient**
- **PH3-LAB2 — Add Validation & ProblemDetail Errors**
- **PH3-LAB3 — CRUD API with Spring MVC**
- **PH3-LAB4 — Reactive API with WebFlux**

---

## Phase 4: Security & Resilience (PH4)

### Lessons
- **PH4-L1 — Spring Security 7**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH4-L2 — Built-in Resilience**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH4-L3 — Testing (Slice, Integration, Contract)**
  - Difficulty Variants: [Newbie, Pro, Hero]

### Quizzes (JSON)
```json
{
  "phase": "PH4",
  "quizzes": [
    {
      "id": "PH4-Q1",
      "topic": "Security 7 DSL & Authorization Managers"
    },
    {
      "id": "PH4-Q2",
      "topic": "Resilience Patterns & Annotations"
    },
    {
      "id": "PH4-Q3",
      "topic": "Testing Strategy & Coverage"
    }
  ],
  "exams": [
    {
      "id": "PH4-EX1",
      "topic": "Security & Resilience Capstone"
    }
  ]
}
```

### Hands-on Labs
- **PH4-LAB1 — Secure Role-Based Endpoints**
- **PH4-LAB2 — Apply Resilience Policies to a Client**
- **PH4-LAB3 — Create Slice & Integration Tests**

---

## Phase 5: Hero Specializations (Cloud & AI) (PH5)

### Lessons
- **PH5-L1 — Spring AI**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH5-L2 — GraalVM & Native Images**
  - Difficulty Variants: [Newbie, Pro, Hero]
  - OS Variants: [Windows, Mac, Linux]
- **PH5-L3 — Observability (Spring Observability + OpenTelemetry)**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH5-L4 — Docker & Kubernetes**
  - Difficulty Variants: [Newbie, Pro, Hero]
  - OS Variants: [Windows, Mac, Linux]
- **PH5-L5 — Spring Cloud & Distributed Systems (Config, Gateway, Discovery)**
  - Difficulty Variants: [Newbie, Pro, Hero]

### Quizzes (JSON)
```json
{
  "phase": "PH5",
  "quizzes": [
    {
      "id": "PH5-Q1",
      "topic": "Spring AI Foundations"
    },
    {
      "id": "PH5-Q2",
      "topic": "GraalVM & AOT Constraints"
    },
    {
      "id": "PH5-Q3",
      "topic": "Observability Signals (Logs/Traces/Metrics)"
    },
    {
      "id": "PH5-Q4",
      "topic": "Containers & K8s Workflows"
    },
    {
      "id": "PH5-Q5",
      "topic": "Spring Cloud Building Blocks"
    }
  ],
  "exams": [
    {
      "id": "PH5-EX1",
      "topic": "Hero Specializations Capstone"
    }
  ]
}
```

### Hands-on Labs
- **PH5-LAB1 — Build a Spring AI Summarizer**
- **PH5-LAB2 — Native Image Build Pipeline**
- **PH5-LAB3 — OpenTelemetry Tracing Setup**
- **PH5-LAB4 — Containerize & Deploy to Kubernetes**
- **PH5-LAB5 — Spring Cloud Config + Gateway Demo**

---

## “Other” Topics (PH6)

### Lessons
- **PH6-L1 — Documentation & Migration Strategy**
  - Difficulty Variants: [Newbie, Pro, Hero]
- **PH6-L2 — Environment Setup (JDK 21/25)**
  - Difficulty Variants: [Newbie, Pro, Hero]
  - OS Variants: [Windows, Mac, Linux]

### Quizzes (JSON)
```json
{
  "phase": "PH6",
  "quizzes": [
    {
      "id": "PH6-Q1",
      "topic": "Upgrade Ordering & Migration Risks"
    }
  ]
}
```

### Hands-on Labs
- **PH6-LAB1 — Install JDK 21/25 on All OS Targets**
- **PH6-LAB2 — Create a Migration Checklist**
