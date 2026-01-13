package com.example.springscholar;

import java.util.List;

public record ContentSection(
        String id,
        String title,
        String type,
        String body,
        String code,
        String diagram,
        List<String> commands,
        List<Question> questions,
        String minLevel,
        List<String> targetOs,
        List<String> focusTags,
        String exercisePrompt,
        String exerciseStarter,
        String exerciseSolution) {
}
