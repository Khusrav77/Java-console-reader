package com.shh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.model.CommandType;
import com.shh.model.Person;

public final class Validator {
    //CREATE {"name":"Ваня","age":18}
    //UPDATE 3 {"name":"Петя","age":16}
    //DELETE 2
    //GET 1
    //GET

    public CommandType validate(String  input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Command data cannot be null or empty");
        }

        input = input.trim();
        String[] data = input.split(" ", 3);
        CommandType commandType;

        try {
            commandType = CommandType.valueOf(data[0].toUpperCase());

        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown command type " + data[0]);
        }

        switch (commandType) {

            case CREATE -> validateCreate(data);

            case GET -> validateGet(data);

            case UPDATE -> validateUpdate(data);

            case DELETE -> validateDelete(data);

            default -> throw new IllegalArgumentException("unknown command type");

        }
        return commandType;
    }

    private void validateCreate(String [] data) {
       checkLength(data, 2, CommandType.CREATE);
       isValidJson(data[1]);
    }

    private void validateGet(String [] data) {
        if (data.length != 1) {
            checkLength(data, 2, CommandType.GET);
            checkId(data[1]);
        }
    }

    private void validateUpdate(String [] data) {
        checkLength(data, 3, CommandType.UPDATE);
        checkId(data[1]);
        isValidJson(data[2]);
    }

    private void validateDelete(String [] data) {
        checkLength(data, 2, CommandType.DELETE);
        checkId(data[1]);
    }

    private void checkLength(String[] data, int expected, CommandType command) {
        if (data.length != expected) {
           throw new IllegalArgumentException("Invalid number of arguments for " + command + " command");
        }
    }

    private void checkId(String id) {
        if (!isInt(id)) {
            throw new IllegalArgumentException("ID must be a number");
        }
    }

    private boolean isInt(String id) {
        try {
            Integer.parseInt(id);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readValue(json, Person.class);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

}
