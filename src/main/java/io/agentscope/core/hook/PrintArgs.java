package io.agentscope.core.hook;

public final class PrintArgs implements HookArgs {
    private final String text;

    public PrintArgs(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
