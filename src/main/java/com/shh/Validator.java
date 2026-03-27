package com.shh;

import com.shh.model.CommandType;

public class Validator {

    public CommandType validate(String [] data) {

        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Command data cannot be null or empty");
        }

        CommandType commandType;

        try {
            commandType = CommandType.valueOf(data[0].toUpperCase());
            switch (commandType) {

                case CREATE -> validateCreate(data);

                case GET -> validateGet(data);

                case UPDATE -> validateUpdate(data);

                case DELETE -> validateDelete(data);

                default -> throw new IllegalArgumentException("unknown command type");

            }
            return commandType;

        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown command type");
        }
        
    }


    private void validateCreate(String [] data) {
       checkLength(data, 2, CommandType.CREATE);

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


}
