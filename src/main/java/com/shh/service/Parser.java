package com.shh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.Command;
import com.shh.model.CommandType;
import com.shh.model.Person;

public  class Parser {

    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public Command parse (String input) throws JsonProcessingException {

        CommandType commandType = validator.validate(input);
        String[] data = input.split(" ", 3);

        return  switch (commandType) {
            case CREATE -> parseCreate(data);

            case GET -> parseGet(data);

            case UPDATE -> parseUpdate(data);

            case DELETE -> parseDelete(data);

            default -> throw new IllegalArgumentException("unknown command type");

        };

    }

    private Command parseCreate(String[] data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(data[1], Person.class);
        return new Command(CommandType.CREATE, null, person);
    }

    private Command parseGet(String[] data){
        if (data.length == 1) {
            return new Command(CommandType.GET_ALL, null, null);
        }
        var id = Integer.parseInt(data[1]);
        return new Command(CommandType.GET, id, null);
    }

    private Command parseUpdate(String[] data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var id = Integer.parseInt(data[1]);
        var newValue = data[2];
        Person person = objectMapper.readValue(newValue, Person.class);
        return new Command(CommandType.UPDATE, id, person);
    }

    private Command parseDelete(String[] data){
        var id = Integer.parseInt(data[1]);
        return new Command(CommandType.DELETE, id, null);
    }
}
