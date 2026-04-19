package com.shh.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Service;


public final class GetAllHandler implements CommandHandler{

    private final Service service;
    private final ObjectMapper mapper;

    public GetAllHandler(Service service, ObjectMapper mapper) {
        this.service = service;
        this.mapper =mapper;
    }

    @Override
    public OutputMessage handle(Command command) throws JsonProcessingException {
        var list = service.getAll();
        var json = mapper.writeValueAsString(list);
        return new OutputMessage(json);
    }
}
