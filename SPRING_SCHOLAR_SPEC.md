# Comprehensive Specification: Spring Scholar Platform

## 1. Core Mission
A "Zero to Hero" learning platform for Spring Boot 4 & Spring 7. The system must adapt content based on the user's current level (Newbie/Pro/Hero) and their local environment (Windows, Mac, Linux, WSL).

## 2. Access Control & User Logic
- **Guest Access:** All study material (Text, Diagrams, Examples) must be fully readable without a login.
- **Authenticated Access (Spring Security 7):**
    - Save progress through modules.
    - Store Quiz and Exam results.
    - **Personalization:** Users can "pin" specific topics or customize their learning path (e.g., "Focus on Cloud-Native").
- **State Management:** Use a "SessionContext" to track the user's selected OS and Level.

## 3. Content Architecture (Extensible System)
The platform must support a "Content-as-Data" approach to make it easy to add new modules.
- **Material Types Required:** - Text (Markdown) & Code Examples (with copy-to-clipboard).
    - Mermaid.js for Diagrams.
    - Best Practices & Useful Commands (Callout boxes).
    - **Interactive:** Coding Exercises (Validation logic), Quizzes (Multiple choice), and Exams (Timed sets).
- **Adaptability Logic:** - Every content fragment should have metadata tags: `minLevel`, `targetOS`.
    - Example: If `OS == 'Windows'`, show PowerShell commands. If `OS == 'Linux'`, show Bash.

## 4. Technical Stack (2026 Standards)
- **Backend:** Spring Boot 4.x, Java 25 (Virtual Threads enabled).
- **Data:** Jakarta Data 1.1 + PostgreSQL 18 (for persistence) + Redis (for session/progress).
- **UI:** Modern, high-performance interface (Tailwind CSS 4.0, shadcn/ui components).
- **AI Integration:** Spring AI for generating personalized study summaries.

## 5. Study Curriculum Hierarchy
1. **The Modern Java Foundation:** Java 21/25, Virtual Threads, Functional Java, Build Tools.
2. **Core Spring Essentials:** IoC, Auto-Config, Modular Starters, Jakarta EE 11.
3. **Data & Web:** Jakarta Data, JPA/JDBC Client, Validation.
4. **Security & Resilience:** Spring Security 7, Core Resilience annotations.
5. **Hero Specializations:** Spring AI, GraalVM, Observability, K8s/Docker.
