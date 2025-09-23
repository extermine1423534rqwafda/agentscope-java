package io.agentscope.core.hook;

import io.agentscope.core.message.Msg;
import java.util.List;

public final class ReplyListArgs implements HookArgs {
    private final List<Msg> inputs;

    public ReplyListArgs(List<Msg> inputs) {
        this.inputs = inputs;
    }

    public List<Msg> getInputs() {
        return inputs;
    }
}
