package io.agentscope.core.hook;

import io.agentscope.core.message.Msg;

public final class ReplyArgs implements HookArgs {
    private final Msg input;

    public ReplyArgs(Msg input) {
        this.input = input;
    }

    public Msg getInput() {
        return input;
    }
}
