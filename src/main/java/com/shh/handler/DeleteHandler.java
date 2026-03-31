package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class DeleteHandler implements CommandHandler{

    private Repository storage;


    public DeleteHandler(Repository storage) {
        this.storage = storage;
    }


    @Override
    public OutputMessage handle(Command command) {
        String result = storage.delete(command.getId());

        return new OutputMessage(result);
    }
}
