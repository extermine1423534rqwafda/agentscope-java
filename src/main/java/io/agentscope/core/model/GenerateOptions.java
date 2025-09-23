package io.agentscope.core.model;

public class GenerateOptions {
    private Double temperature;
    private Double topP;
    private Integer maxTokens;
    private Double frequencyPenalty;
    private Double presencePenalty;

    public GenerateOptions() {}

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTopP() {
        return topP;
    }

    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Double getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Double frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Double getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Double presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final GenerateOptions o = new GenerateOptions();

        public Builder temperature(Double v) {
            o.setTemperature(v);
            return this;
        }

        public Builder topP(Double v) {
            o.setTopP(v);
            return this;
        }

        public Builder maxTokens(Integer v) {
            o.setMaxTokens(v);
            return this;
        }

        public Builder frequencyPenalty(Double v) {
            o.setFrequencyPenalty(v);
            return this;
        }

        public Builder presencePenalty(Double v) {
            o.setPresencePenalty(v);
            return this;
        }

        public GenerateOptions build() {
            return o;
        }
    }
}
