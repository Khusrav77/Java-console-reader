package com.shh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.JdbcRepository;
import com.shh.service.Parser;
import com.shh.service.Service;
import com.shh.service.Validator;

import java.util.Scanner;

public class Application {

    private final ConfigApp configApp;
    private final JdbcRepository repository;
    private final CommandDispatcher dispatcher;
    private final Parser parser;

    public Application() {
        this.configApp = new ConfigApp();
        ObjectMapper mapper = configApp.mapper();
        this.repository = configApp.repository();
        Service service = configApp.service(repository);
        this.dispatcher = configApp.dispatcher(service, mapper);
        Validator validator = configApp.validator();
        this.parser = configApp.parser(validator, mapper);
    }

    public void start() {
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                var inputLine = scanner.nextLine();
                if(inputLine.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    Command command = parser.parse(inputLine);
                    OutputMessage result = dispatcher.handleCommand(command);
                    System.out.println(result.getMsg());
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}
