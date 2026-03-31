package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class UpdateHandler implements CommandHandler{

    private Repository storage;

    public UpdateHandler(Repository storage) {
        this.storage = storage;
    }



    @Override
    public OutputMessage handle(Command command) {
        String result = storage.update(command.getId(), command.getValue());

        return new OutputMessage("Update: " + result);
    }
}
