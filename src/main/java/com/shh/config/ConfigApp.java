package com.shh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Person;
import com.shh.repository.Repository;
import com.shh.service.*;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.RepositoryImpl;
import java.util.Map;

public final class ConfigApp {

    public CommandDispatcher dispatcher(Repository repository, Mapper mapper){

        Service service = new ServiceImpl(repository);

        CommandHandler createHandler = new  CreateHandler(service);
        CommandHandler getHandler = new GetHandler(service, mapper);
        CommandHandler getAllHandler = new GetAllHandler(service, mapper);
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

    public Parser parser() {return new Parser(new Validator());}
    public Mapper mapper() {return new MapperImpl(new ObjectMapper());}
    public DataLoader dataLoader() {return new DataLoaderImpl(mapper());}
    public Repository repository(Map<Integer, Person> storage) {
        return new RepositoryImpl(storage);
    }

}
