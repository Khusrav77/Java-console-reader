package com.shh.config;

import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Person;
import com.shh.repository.MessageRepository;
import com.shh.service.DataLoader;
import com.shh.service.DataLoaderImpl;
import com.shh.service.MessageService;
import com.shh.service.MessageServiceImpl;
import com.shh.service.Parser;
import com.shh.service.Validator;
import com.shh.handler.*;
import com.shh.model.CommandType;
import com.shh.repository.MessageRepositoryImpl;
import java.util.Map;

public final class ConfigApp {

    public CommandDispatcher dispatcher(MessageRepository messageRepository){

        MessageService messageService = new MessageServiceImpl(messageRepository);

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

    public DataLoader dataLoader() {return new DataLoaderImpl();}

    public MessageRepository repository(Map<Integer, Person> storage) {
        return new MessageRepositoryImpl(storage);
    }

}
