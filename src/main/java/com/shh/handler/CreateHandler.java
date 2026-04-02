package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.MessageService;


public final class CreateHandler implements CommandHandler {

    private final MessageService  messageService;

    public CreateHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public OutputMessage handle(Command command) {
       var id = messageService.create(command.getValue());
       return new OutputMessage("String saved with id = "+ id);
    }
}
