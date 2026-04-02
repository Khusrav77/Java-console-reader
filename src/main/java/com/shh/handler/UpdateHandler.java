package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.MessageService;


public final class UpdateHandler implements CommandHandler{

    private final MessageService messageService;

    public UpdateHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public OutputMessage handle(Command command) {
        String newData = messageService.update(command.getId(), command.getValue());
        return new OutputMessage("Update: " + newData);
    }
}
