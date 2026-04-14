package com.shh.config;

import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Person;
import com.shh.repository.Repository;
import com.shh.service.DataLoader;
import com.shh.service.DataLoaderImpl;
import com.shh.service.Service;
import com.shh.service.ServiceImpl;
import com.shh.service.Parser;
import com.shh.service.Validator;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.RepositoryImpl;
import java.util.Map;

public final class ConfigApp {

    public CommandDispatcher dispatcher(Repository repository){

        Service service = new ServiceImpl(repository);

        CommandHandler createHandler = new  CreateHandler(service);
        CommandHandler getHandler = new GetHandler(service);
        CommandHandler getAllHandler = new GetAllHandler(service);
        CommandHandler updateHandler =  new UpdateHandler(service);
        CommandHandler deleteHandler = new DeleteHandler(service);

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

    public DataLoader dataLoader() {return new DataLoaderImpl();}

    public Repository repository(Map<Integer, Person> storage) {
        return new RepositoryImpl(storage);
    }

}
