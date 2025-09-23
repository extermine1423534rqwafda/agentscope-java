package io.agentscope.core.model;

public class ModelMessageContentItem {
    private String type; // text,image,audio,video
    private String text;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ModelMessageContentItem i = new ModelMessageContentItem();

        public Builder type(String t) {
            i.setType(t);
            return this;
        }

        public Builder text(String t) {
            i.setText(t);
            return this;
        }

        public Builder url(String u) {
            i.setUrl(u);
            return this;
        }

        public ModelMessageContentItem build() {
            return i;
        }
    }
}
