package com.example.springscholar;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ContentController {
    private final ContentService contentService;
    private final ProgressService progressService;
    private final SessionContext sessionContext;

    public ContentController(ContentService contentService, ProgressService progressService, SessionContext sessionContext) {
        this.contentService = contentService;
        this.progressService = progressService;
        this.sessionContext = sessionContext;
    }

    @GetMapping("/")
    public String home(Model model, Authentication authentication) {
        model.addAttribute("modules", contentService.getModules(sessionContext));
        model.addAttribute("sessionContext", sessionContext);
        model.addAttribute("isAuthenticated", isAuthenticated(authentication));
        model.addAttribute("username", username(authentication));
        model.addAttribute("scores", scores(authentication));
        model.addAttribute("completed", completed(authentication));
        model.addAttribute("pinned", pinned(authentication));
        model.addAttribute("lastUpdated", lastUpdated(authentication));
        return "index";
    }

    @GetMapping("/modules/{moduleId}")
    public String module(@PathVariable String moduleId, Model model, Authentication authentication) {
        var module = contentService.getModuleById(moduleId, sessionContext);
        if (module == null) {
            return "redirect:/";
        }
        model.addAttribute("module", module);
        model.addAttribute("sessionContext", sessionContext);
        model.addAttribute("isAuthenticated", isAuthenticated(authentication));
        model.addAttribute("username", username(authentication));
        model.addAttribute("scores", scores(authentication));
        model.addAttribute("completed", completed(authentication));
        model.addAttribute("pinned", pinned(authentication));
        return "module";
    }

    @PostMapping("/preferences")
    public String updatePreferences(@RequestParam String level,
                                    @RequestParam String targetOs,
                                    @RequestParam(required = false) String focus) {
        sessionContext.setLevel(LearningLevel.from(level));
        sessionContext.setTargetOs(TargetOs.from(targetOs));
        sessionContext.setFocus(focus);
        return "redirect:/";
    }

    @PostMapping("/progress/complete")
    public String completeSection(@RequestParam String moduleId, @RequestParam String sectionId, Authentication authentication) {
        if (isAuthenticated(authentication)) {
            progressService.markCompleted(authentication.getName(), sectionId);
        }
        return "redirect:/modules/" + moduleId + "#" + sectionId;
    }

    @PostMapping("/progress/pin")
    public String pinSection(@RequestParam String moduleId, @RequestParam String sectionId, Authentication authentication) {
        if (isAuthenticated(authentication)) {
            progressService.togglePinned(authentication.getName(), sectionId);
        }
        return "redirect:/modules/" + moduleId + "#" + sectionId;
    }

    @PostMapping("/quiz/submit")
    public String submitQuiz(@RequestParam String moduleId,
                              @RequestParam String sectionId,
                              @RequestParam MultiValueMap<String, String> formData,
                              Authentication authentication) {
        var section = contentService.getSection(moduleId, sectionId);
        if (section == null || section.questions() == null) {
            return "redirect:/modules/" + moduleId;
        }
        int score = 0;
        for (int i = 0; i < section.questions().size(); i++) {
            var answer = formData.getFirst("q_" + i);
            if (answer != null && Integer.parseInt(answer) == section.questions().get(i).correctIndex()) {
                score++;
            }
        }
        if (isAuthenticated(authentication)) {
            progressService.recordScore(authentication.getName(), sectionId, score);
        }
        return "redirect:/modules/" + moduleId + "?score=" + score + "#" + sectionId;
    }

    private boolean isAuthenticated(Authentication authentication) {
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
    }

    private String username(Authentication authentication) {
        return isAuthenticated(authentication) ? authentication.getName() : "";
    }

    private Map<String, Integer> scores(Authentication authentication) {
        if (!isAuthenticated(authentication)) {
            return Map.of();
        }
        return progressService.getScores(authentication.getName());
    }

    private Map<String, Boolean> completed(Authentication authentication) {
        if (!isAuthenticated(authentication)) {
            return Map.of();
        }
        var map = new HashMap<String, Boolean>();
        progressService.getCompleted(authentication.getName()).forEach(section -> map.put(section, true));
        return map;
    }

    private Map<String, Boolean> pinned(Authentication authentication) {
        if (!isAuthenticated(authentication)) {
            return Map.of();
        }
        var map = new HashMap<String, Boolean>();
        progressService.getPinned(authentication.getName()).forEach(section -> map.put(section, true));
        return map;
    }

    private String lastUpdated(Authentication authentication) {
        if (!isAuthenticated(authentication)) {
            return "";
        }
        var updated = progressService.getLastUpdated(authentication.getName());
        return updated == null ? "" : updated.toString();
    }
}
