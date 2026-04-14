package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class CreateHandler implements CommandHandler {

    private final Service service;

    public CreateHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) {
       var id = service.create(command.getValue());
       return new OutputMessage("String saved with id = "+ id);
    }
}
