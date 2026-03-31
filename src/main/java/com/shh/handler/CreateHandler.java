package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Storage;

public final class CreateHandler implements CommandHandler {

    private final Storage storage;

    public CreateHandler(Storage storage) {
        this.storage = storage;
    }



    @Override
    public OutputMessage handle(Command command) {

        Integer id = storage.create(command.getValue());
        return new OutputMessage("String saved with id = "+ id);
    }


}
