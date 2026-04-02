package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.MessageService;


public final class GetHandler implements CommandHandler{

    private final MessageService messageService;

    public GetHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public OutputMessage handle(Command command) {
        var result = messageService.get(command.getId());
        return new OutputMessage(result);
    }
}
