package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Storage;

public class UpdateHandler implements CommandHandler{

    private  Storage storage;

    public UpdateHandler(Storage storage) {
        this.storage = storage;
    }



    @Override
    public OutputMessage handle(Command command) {
        String result = storage.update(command.getId(), command.getValue());

        return new OutputMessage("Update: " + result);
    }
}
