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

    public Application application(){return new Application(dispatcher(),parser());}

    private Validator validator() {return new Validator();}
    private ObjectMapper mapper() {return new ObjectMapper();}
    private Parser parser() {return new Parser(validator(), mapper());}
    private JdbcRepository repository() {return new JdbcRepositoryImpl();}
    private Service service() {return new ServiceImpl(repository());}

    private CommandHandler createHandler(){return new CreateHandler(service());}
    private CommandHandler getHandler(){return new GetHandler(service(), mapper());}
    private CommandHandler getAllHandler(){return new GetAllHandler(service(), mapper());}
    private CommandHandler updateHandler(){return new UpdateHandler(service());}
    private CommandHandler deleteHandler(){return new DeleteHandler(service());}

    private CommandDispatcher dispatcher(){
        Map<CommandType, CommandHandler> handlers = Map.of(
                CommandType.CREATE, createHandler(),
                CommandType.GET, getHandler(),
                CommandType.GET_ALL, getAllHandler(),
                CommandType.UPDATE, updateHandler(),
                CommandType.DELETE, deleteHandler()
        );
        return new CommandDispatcher(handlers);
    }
}
