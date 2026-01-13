package com.example.springscholar;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContentService {
    private final ContentCatalog catalog;

    public ContentService(ObjectMapper objectMapper) throws IOException {
        var resource = new ClassPathResource("content/study-content.json");
        this.catalog = objectMapper.readValue(resource.getInputStream(), ContentCatalog.class);
    }

    public List<ContentModule> getModules(SessionContext context) {
        return catalog.modules().stream()
                .map(module -> filterModule(module, context))
                .filter(module -> !module.sections().isEmpty())
                .collect(Collectors.toList());
    }

    public ContentModule getModuleById(String id, SessionContext context) {
        return catalog.modules().stream()
                .filter(module -> Objects.equals(module.id(), id))
                .findFirst()
                .map(module -> filterModule(module, context))
                .orElse(null);
    }

    public ContentSection getSection(String moduleId, String sectionId) {
        return catalog.modules().stream()
                .filter(module -> Objects.equals(module.id(), moduleId))
                .flatMap(module -> module.sections().stream())
                .filter(section -> Objects.equals(section.id(), sectionId))
                .findFirst()
                .orElse(null);
    }

    private ContentModule filterModule(ContentModule module, SessionContext context) {
        if (!context.getLevel().allows(module.minLevel())) {
            return new ContentModule(module.id(), module.title(), module.description(), module.minLevel(), List.of());
        }
        var filteredSections = new ArrayList<ContentSection>();
        for (var section : module.sections()) {
            if (!context.getLevel().allows(section.minLevel())) {
                continue;
            }
            if (!matchesOs(section, context.getTargetOs())) {
                continue;
            }
            if (!matchesFocus(section, context.getFocus())) {
                continue;
            }
            filteredSections.add(section);
        }
        return new ContentModule(module.id(), module.title(), module.description(), module.minLevel(), filteredSections);
    }

    private boolean matchesOs(ContentSection section, TargetOs targetOs) {
        if (section.targetOs() == null || section.targetOs().isEmpty()) {
            return true;
        }
        return section.targetOs().stream()
                .map(value -> value.toUpperCase(Locale.ROOT))
                .anyMatch(value -> value.equals("ANY") || value.equals(targetOs.name()));
    }

    private boolean matchesFocus(ContentSection section, String focus) {
        if (focus == null || focus.isBlank()) {
            return true;
        }
        if (section.focusTags() == null || section.focusTags().isEmpty()) {
            return false;
        }
        return section.focusTags().stream().anyMatch(tag -> tag.equalsIgnoreCase(focus));
    }
}
