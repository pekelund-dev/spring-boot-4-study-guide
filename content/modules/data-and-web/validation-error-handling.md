---
id: validation-errors-01
title: Validation & Error Handling
summary: Consistent API validation and error responses for Boot 4.
module: data-and-web
type: best-practice
minLevel: newbie
targetOS: any
order: 20
tags: [validation, errors]
estimatedMinutes: 14
---

## Validation strategy

- Annotate request DTOs with Jakarta Validation constraints.
- Centralize error responses with `@ControllerAdvice`.
- Use problem-details or a consistent JSON error schema.

```java
public record CreateCourseRequest(
    @NotBlank String title,
    @Min(5) int minutes
) {}
```

```java
@RestControllerAdvice
class ApiErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ErrorResponse.from(ex));
    }
}
```

### Best practices

> **Best Practice:** Return a consistent error schema (`code`, `message`, `fieldErrors`) across all endpoints.

> **Best Practice:** Log correlation IDs so validation errors can be traced in production.

