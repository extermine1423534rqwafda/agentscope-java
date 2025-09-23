package io.agentscope.core.hook;

import io.agentscope.core.message.Msg;

public final class ObserveArgs implements HookArgs {
    private final Msg message;

    public ObserveArgs(Msg message) {
        this.message = message;
    }

    public Msg getMessage() {
        return message;
    }
}
