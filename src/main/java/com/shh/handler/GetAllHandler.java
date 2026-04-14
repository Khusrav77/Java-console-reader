package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class GetAllHandler implements CommandHandler{

    private final Service service;

    public GetAllHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) {
        var list = service.getAll();
        return new OutputMessage(list.toString());
    }
}
