package com.example.springscholar;

import java.util.List;

public record ContentModule(
        String id,
        String title,
        String description,
        String minLevel,
        List<ContentSection> sections) {
}
