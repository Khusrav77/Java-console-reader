package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.MessageService;


public final class DeleteHandler implements CommandHandler{

    private MessageService messageService;

    public DeleteHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public OutputMessage handle(Command command) {
        var result = messageService.delete(command.getId());
        return new OutputMessage(result);
    }
}
