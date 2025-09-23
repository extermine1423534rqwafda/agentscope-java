package io.agentscope.core.model;

import java.util.Map;

public class ToolCall {
    private String id;
    private String name;
    private Map<String, Object> arguments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ToolCall c = new ToolCall();

        public Builder id(String id) {
            c.setId(id);
            return this;
        }

        public Builder name(String name) {
            c.setName(name);
            return this;
        }

        public Builder arguments(Map<String, Object> args) {
            c.setArguments(args);
            return this;
        }

        public ToolCall build() {
            return c;
        }
    }
}
