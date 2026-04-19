package com.shh.dispacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shh.handler.CommandHandler;
import com.shh.model.Command;
import com.shh.model.CommandType;
import com.shh.model.OutputMessage;

import java.util.Map;

public final class CommandDispatcher {

    private final Map<CommandType, CommandHandler> handlers;

    public CommandDispatcher(Map<CommandType, CommandHandler> handlers){
        this.handlers = handlers;
    }

    public OutputMessage handleCommand(Command command) throws JsonProcessingException {
        CommandHandler handler = handlers.get(command.getType());
        if (handler == null) {
            throw new  IllegalArgumentException(
                    "No handler registered for command type: " +command.getType());
        }
        return handler.handle(command);
    }

}
