package com.shh;

import com.shh.model.CommandType;

public class Validator {

    public void validate(String [] data) {

        var command = data[0];


        switch (command) {

            case "CREATE" -> validateCreate(data);

            case "GET" -> validateGet(data);

            case "UPDATE" -> validateUpdate(data);

            case "DELETE" -> validateDelete(data);

            default -> throw new IllegalArgumentException("unknown command type");

        };

    }


    private void validateCreate(String [] data) {
        if (data.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments for Create command");
        }
        if (!data[0].equalsIgnoreCase(CommandType.CREATE.name())) {
            throw new IllegalArgumentException("Command must start with 'Create'");
        }
    }

    private void validateGet(String [] data) {
        if (data.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments for Get command");
        }
        if (!data[0].equalsIgnoreCase(CommandType.GET.name())){
            throw new IllegalArgumentException("Command must start with 'Get'");
        }
        if (!isInt(data[1])) {
            throw new IllegalArgumentException("ID must be a number");
        }

    }

    private void validateUpdate(String [] data) {

        if (data.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments for Update command");
        }
        if (!data[0].equalsIgnoreCase(CommandType.UPDATE.name())) {
            throw new IllegalArgumentException("Command must start with 'Update'");
        }
        if (!isInt(data[1])) {
            throw new IllegalArgumentException("ID must be a number");
        }
    }

    private void validateDelete(String [] data) {


        if (data.length != 2) {

            throw new IllegalArgumentException("Invalid number of arguments for DELETE command");
        }
        if (!data[0].equalsIgnoreCase(CommandType.DELETE.name())){
            throw new IllegalArgumentException("Command must start with 'Delete'");
        }

        if (!isInt(data[1])) {
            throw new IllegalArgumentException("ID must be a number");
        }

    }

    private boolean isInt(String id) {
        try {
            Integer.parseInt(id);
        } catch (Exception e) {
            return true;
        }
        return false;
    }


}
