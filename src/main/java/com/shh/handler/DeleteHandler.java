package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class DeleteHandler implements CommandHandler{

    private Service service;

    public DeleteHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) {
        var result = service.delete(command.getId());
        return new OutputMessage(result);
    }
}
