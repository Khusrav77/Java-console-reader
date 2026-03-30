package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Storage;

public class GetHandler implements CommandHandler{

    private  Storage storage;

    public GetHandler(Storage storage) {
        this.storage = storage;
    }


    @Override
    public OutputMessage handle(Command command) {
        String result = storage.get(command.getId());

        return new OutputMessage(result);
    }
}
