package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class DeleteHandler implements CommandHandler{

    private Repository<String, Integer> repository;


    public DeleteHandler(Repository repository) {
        this.repository = repository;
    }


    @Override
    public OutputMessage handle(Command command) {
        String result = repository.delete(command.getId());

        return new OutputMessage(result);
    }
}
