package com.shh.config;

import com.shh.dispacher.CommandDispatcher;
import com.shh.repository.Repository;
import com.shh.service.DataLoader;
import com.shh.service.DataLoaderImpl;
import com.shh.service.MessageService;
import com.shh.service.MessageServiceImpl;
import com.shh.util.IdGenerator;
import com.shh.util.IdGeneratorImpl;
import com.shh.util.Parser;
import com.shh.util.Validator;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.RepositoryImpl;

import java.util.Map;

public final class ConfigApp {

    private final DataLoader dataLoader = new DataLoaderImpl();
    private final Map<Integer, String> storage;
    private final Repository repository;
    private final IdGenerator idGenerator;

    public ConfigApp() {
        this.storage = dataLoader.load();
        int maxId = storage.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        this.idGenerator = new IdGeneratorImpl(maxId);
        this.repository = new RepositoryImpl(idGenerator, storage);
    }



    public CommandDispatcher dispatcher(){

        MessageService messageService = new MessageServiceImpl(repository);

        CommandHandler createHandler = new  CreateHandler(messageService);
        CommandHandler getHandler = new GetHandler(messageService);
        CommandHandler getAllHandler = new GetAllHandler(messageService);
        CommandHandler updateHandler =  new UpdateHandler(messageService);
        CommandHandler deleteHandler = new DeleteHandler(messageService);

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
        return new Parser(new Validator());
    }

    public void saveData(){
        dataLoader.save(storage);
    }

}
