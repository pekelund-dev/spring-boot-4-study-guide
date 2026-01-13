package com.example.springscholar;

import java.util.List;

public record Question(
        String id,
        String prompt,
        List<String> options,
        int correctIndex) {
}
