package io.agentscope.core.model;

public interface MessageContent {
    ContentKind getKind();

    enum ContentKind {
        TEXT,
        IMAGE,
        AUDIO,
        VIDEO
    }
}
