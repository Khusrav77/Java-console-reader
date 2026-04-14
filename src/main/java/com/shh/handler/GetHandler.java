package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class GetHandler implements CommandHandler{

    private final Service service;

    public GetHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) {
        var result = service.get(command.getId());
        return new OutputMessage(result.toString());
    }
}
