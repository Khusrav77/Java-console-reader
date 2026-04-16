package com.shh.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Mapper;
import com.shh.service.Service;


public final class GetHandler implements CommandHandler{

    private final Service service;
    private final Mapper mapper;

    public GetHandler(Service service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public OutputMessage handle(Command command) throws JsonProcessingException {
        var result = service.get(command.getId());
        var json = mapper.objectToJson(result);
        return new OutputMessage(json);
    }
}
