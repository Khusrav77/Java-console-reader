package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.MessageService;


public final class GetAllHandler implements CommandHandler{

    private final MessageService messageService;

    public GetAllHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public OutputMessage handle(Command command) {
        var list = messageService.getAll();
        return new OutputMessage(list.toString());
    }
}
