package com.shh.config;

import com.shh.repository.Repository;
import com.shh.util.Parser;
import com.shh.util.Validator;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.RepositoryImpl;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class ConfigApp {

    public CommandDispatcher dispatcher(){

        Repository<Integer, String> repository = new RepositoryImpl();
        AtomicInteger idGenerator = new AtomicInteger();

        CommandHandler createHandler = new  CreateHandler(repository, idGenerator);
        CommandHandler getHandler = new GetHandler(repository);
        CommandHandler getAllHandler = new GetAllHandler(repository);
        CommandHandler updateHandler =  new UpdateHandler(repository);
        CommandHandler deleteHandler = new DeleteHandler(repository);

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

    private  Validator validator() {
        return new Validator();
    }
}
