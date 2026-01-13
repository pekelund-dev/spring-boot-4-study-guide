package com.springscholar.content;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

@Component
public class ContentDocumentLoader {
    public ContentDocument loadDocument(Path path) {
        try {
            String raw = Files.readString(path, StandardCharsets.UTF_8);
            if (!raw.startsWith("---")) {
                throw new IllegalArgumentException("Content file missing YAML front matter: " + path);
            }
            int end = raw.indexOf("---", 3);
            if (end == -1) {
                throw new IllegalArgumentException("Content file missing closing front matter: " + path);
            }
            String yamlBlock = raw.substring(3, end).trim();
            String body = raw.substring(end + 3).trim();
            Yaml yaml = new Yaml();
            Map<String, Object> metadata = yaml.load(yamlBlock);
            if (metadata == null) {
                metadata = Collections.emptyMap();
            }
            return new ContentDocument(
                (String) metadata.get("id"),
                (String) metadata.get("title"),
                (String) metadata.get("summary"),
                (String) metadata.get("module"),
                (String) metadata.get("type"),
                (String) metadata.get("minLevel"),
                (String) metadata.get("targetOS"),
                metadata.get("order") instanceof Integer order ? order : 0,
                castStringList(metadata.get("tags")),
                metadata.get("estimatedMinutes") instanceof Integer minutes ? minutes : null,
                body,
                new LinkedHashMap<>(metadata)
            );
        } catch (IOException ex) {
            throw new ContentNotFoundException("Unable to load content document at " + path, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private List<String> castStringList(Object value) {
        if (value instanceof List<?> list) {
            return list.stream().map(String.class::cast).toList();
        }
        return List.of();
    }
}
