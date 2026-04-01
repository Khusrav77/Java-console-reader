package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class GetHandler implements CommandHandler{

    private Repository<String, Integer> repository;

    public GetHandler(Repository repository) {
        this.repository = repository;
    }

    @Override
    public OutputMessage handle(Command command) {
        String result = repository.get(command.getId());
        return new OutputMessage(result);
    }
}
