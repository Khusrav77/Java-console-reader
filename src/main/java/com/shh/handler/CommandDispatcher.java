package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.Result;

public class CommandDispatcher {

    private final CreateHandler createHandler;
    private final GetHandler getHandler;
    private final GetAllHandler getAllHandler;
    private final UpdateHandler updateHandler;
    private final DeleteHandler deleteHandler;


    public CommandDispatcher(CreateHandler createHandler,
                             GetHandler getHandler,
                             GetAllHandler getAllHandler,
                             UpdateHandler updateHandler,
                             DeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.getHandler = getHandler;
        this.getAllHandler = getAllHandler;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }

    public Result handleCammand(Command command) {

       return switch (command.getType()) {
           case CREATE -> createHandler.handle(command);
           case GET -> getAllHandler.handle(command);
           default -> new Result("is not implemented");
        };

    }


}
