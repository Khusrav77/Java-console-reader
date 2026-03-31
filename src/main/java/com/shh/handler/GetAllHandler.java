package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;


public final class GetAllHandler implements CommandHandler{

    private final Repository<String, Integer> repository;

    public GetAllHandler(Repository repository) {
        this.repository = repository;
    }


    @Override
    public OutputMessage handle(Command command) {

        var list = repository.getAll();

        return new OutputMessage(list.toString());
    }
}
