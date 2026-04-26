package com.shh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Person;
import com.shh.repository.JdbcRepository;
import com.shh.repository.JdbcRepositoryImpl;
import com.shh.repository.Repository;
import com.shh.service.*;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.RepositoryImpl;
import java.util.Map;

public final class ConfigApp {


    public CommandDispatcher dispatcher(Service service, ObjectMapper mapper){
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

    public Validator validator() {return new Validator();}
    public Parser parser(Validator validator, ObjectMapper mapper ) {return new Parser(validator, mapper);}
    public ObjectMapper mapper() {return new ObjectMapper();}
    public DataLoader dataLoader(ObjectMapper mapper) {return new DataLoaderImpl(mapper);}
    public Service service(JdbcRepository repository) {return new ServiceImpl(repository);}
    public JdbcRepository repository() {return new JdbcRepositoryImpl();}

}
