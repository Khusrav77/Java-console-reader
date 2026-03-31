package com.shh.config;

import com.shh.util.Parser;
import com.shh.util.Validator;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.Storage;

import java.util.Map;

public final class ConfigApp {



    public CommandDispatcher dispatcher(){

        Storage storage = new Storage();

        CommandHandler createHandler = new  CreateHandler(storage);
        CommandHandler getHandler = new GetHandler(storage);
        CommandHandler getAllHandler = new GetAllHandler(storage);
        CommandHandler updateHandler =  new UpdateHandler(storage);
        CommandHandler deleteHandler = new DeleteHandler(storage);

        Map<CommandType, CommandHandler> handlers = Map.of(
                CommandType.CREATE, createHandler,
                CommandType.GET, getHandler,
                CommandType.GET_ALL, getAllHandler,
                CommandType.UPDATE, updateHandler,
                CommandType.DELETE, deleteHandler
        );

        return new CommandDispatcher(handlers);
    }

    public Parser parser() {
        return new Parser(validator());
    }

    private Validator validator() {
        return new Validator();
    }
}
