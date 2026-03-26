package com.shh;

import com.shh.model.CommandType;

public class Validator {

    public void validate(String [] data) {

        CommandType commandType;

        try {
            commandType = CommandType.valueOf(data[0].toUpperCase());

        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown command type");
        }


         switch (commandType) {

            case CREATE -> validateCreate(data);

            case GET -> validateGet(data);

            case UPDATE -> validateUpdate(data);

            case DELETE -> validateDelete(data);

            default -> throw new IllegalArgumentException("unknown command type");

        }

    }


    private void validateCreate(String [] data) {
       chekLength(data, 2, CommandType.CREATE);

       chekId(data[1]);
    }

    private void validateGet(String [] data) {

        chekLength(data, 2, CommandType.GET);

        chekId(data[1]);

    }

    private void validateUpdate(String [] data) {

        chekLength(data, 3, CommandType.UPDATE);

        chekId(data[1]);
    }

    private void validateDelete(String [] data) {

        chekLength(data, 2, CommandType.DELETE);

        chekId(data[1]);

    }

    private void chekLength(String[] data, int expected, CommandType command) {
        if (data.length != expected) {
           throw new IllegalArgumentException("Invalid number of arguments for " + command + " command");
        }
    }

    private void chekId(String id) {
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
