package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.CommandType;
import com.shh.model.OutputMessage;

import java.util.Map;

public class CommandDispatcher {

    private final Map<CommandType, CommandHandler> handlers;


    public CommandDispatcher(Map<CommandType, CommandHandler> handlers){
        this.handlers = handlers;
    }



    public OutputMessage handleCommand(Command command) {
        CommandHandler handler = handlers.get(command.getType());

        if (handler == null) {
            throw new  IllegalArgumentException("Handler not found for: " +command.getType());
        }

        return handler.handle(command);
    }




}
