package com.shh.util;

import com.shh.model.Command;
import com.shh.model.CommandType;

public  class Parser {

    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    // ============ PARSER METHODE ============= //
    public Command parse (String input) {

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

    // ============ PRIVATE METHODE ============= //
    private Command parseCreate(String[] data){
        var value = data[1];
        return new Command(CommandType.CREATE, null, value);
    }

    private Command parseGet(String[] data){
        if (data.length == 1) {
            return new Command(CommandType.GET_ALL, null, null);
        }

        var id = Integer.parseInt(data[1]);
        return new Command(CommandType.GET, id, null);

    }

    private Command parseUpdate(String[] data){
        var id = Integer.parseInt(data[1]);
        var newValue = data[2];
        return new Command(CommandType.UPDATE, id, newValue);
    }

    private Command parseDelete(String[] data){
        var id = Integer.parseInt(data[1]);
        return new Command(CommandType.DELETE, id, null);
    }

}
