package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class UpdateHandler implements CommandHandler{

    private Repository<String, Integer> repository;

    public UpdateHandler(Repository repository) {
        this.repository = repository;
    }



    @Override
    public OutputMessage handle(Command command) {
        String result = repository.update(command.getId(), command.getValue());

        return new OutputMessage("Update: " + result);
    }
}
