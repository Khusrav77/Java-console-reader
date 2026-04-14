package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class UpdateHandler implements CommandHandler{

    private final Service service;

    public UpdateHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) {
        String newData = service.update(command.getId(), command.getValue());
        return new OutputMessage("Update: " + newData);
    }
}
