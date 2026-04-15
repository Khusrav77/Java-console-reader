package com.shh.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class GetHandler implements CommandHandler{

    private final Service service;

    public GetHandler(Service service) {
        this.service = service;
    }

    @Override
    public OutputMessage handle(Command command) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var result = service.get(command.getId());
        var json = mapper.writeValueAsString(result);
        return new OutputMessage(json);
    }
}
