package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class GetHandler implements CommandHandler{

    private Repository storage;

    public GetHandler(Repository storage) {
        this.storage = storage;
    }


    @Override
    public OutputMessage handle(Command command) {
        String result = storage.get(command.getId());

        return new OutputMessage(result);
    }
}
