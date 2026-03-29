package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.Result;
import com.shh.repository.Storage;

public class CreateHandler implements CommandHandler {

    private final Storage storage;

    public CreateHandler(Storage storage) {
        this.storage = storage;
    }



    @Override
    public Result handle(Command command) {

        Integer id = storage.create(command.getValue());

        return new Result("String saved with id = "+ id);
    }


}
