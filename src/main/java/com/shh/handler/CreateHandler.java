package com.shh.handler;

import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;
import java.util.concurrent.atomic.AtomicInteger;


public final class CreateHandler implements CommandHandler {

    private final Repository repository;
    private final AtomicInteger idGenerator;

    public CreateHandler(Repository<String, Integer> repository, AtomicInteger idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public OutputMessage handle(Command command) {
        Integer id = idGenerator.incrementAndGet();
        repository.create(id, command.getValue());
        return new OutputMessage("String saved with id = "+ id);
    }
}
