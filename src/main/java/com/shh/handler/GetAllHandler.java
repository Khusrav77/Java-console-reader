package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Storage;

import java.util.List;

public class GetAllHandler implements CommandHandler{

    private final Storage storage;

    public GetAllHandler(Storage storage) {
        this.storage = storage;
    }


    @Override
    public OutputMessage handle(Command command) {

        var list = storage.getAll();

        return new OutputMessage(list.toString());
    }
}
