package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.Result;
import com.shh.repository.Storage;

public class GetAllHandler implements CommandHandler{

    private final Storage storage;

    public GetAllHandler(Storage storage) {
        this.storage = storage;
    }


    @Override
    public Result handle(Command command) {

        String result = storage.get(command.getId());

        return new Result(result);
    }
}
