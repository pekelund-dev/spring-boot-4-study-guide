package com.example.springscholar;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionContext {
    private LearningLevel level = LearningLevel.NEWBIE;
    private TargetOs targetOs = TargetOs.ANY;
    private String focus = "";

    public LearningLevel getLevel() {
        return level;
    }

    public void setLevel(LearningLevel level) {
        this.level = level;
    }

    public TargetOs getTargetOs() {
        return targetOs;
    }

    public void setTargetOs(TargetOs targetOs) {
        this.targetOs = targetOs;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus == null ? "" : focus.trim();
    }
}
