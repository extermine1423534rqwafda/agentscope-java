package io.agentscope.core.formatter;

public class FormatterOptions {
    private boolean collapseTextSequence;

    public FormatterOptions() {}

    public boolean isCollapseTextSequence() {
        return collapseTextSequence;
    }

    public void setCollapseTextSequence(boolean collapseTextSequence) {
        this.collapseTextSequence = collapseTextSequence;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final FormatterOptions o = new FormatterOptions();

        public Builder collapseTextSequence(boolean v) {
            o.setCollapseTextSequence(v);
            return this;
        }

        public FormatterOptions build() {
            return o;
        }
    }
}
