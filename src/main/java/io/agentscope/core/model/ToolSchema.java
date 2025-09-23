package io.agentscope.core.model;

import java.util.Map;

public class ToolSchema {
    private String name;
    private String description;
    private Map<String, Object> parameters; // JSON Schema

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ToolSchema s = new ToolSchema();

        public Builder name(String name) {
            s.setName(name);
            return this;
        }

        public Builder description(String desc) {
            s.setDescription(desc);
            return this;
        }

        public Builder parameters(Map<String, Object> params) {
            s.setParameters(params);
            return this;
        }

        public ToolSchema build() {
            return s;
        }
    }
}
