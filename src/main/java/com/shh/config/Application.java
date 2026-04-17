package com.shh.config;

import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;
import com.shh.service.DataLoader;
import com.shh.service.Mapper;
import com.shh.service.Parser;

import java.util.Scanner;

public class Application {

    private final ConfigApp configApp;
    private final CommandDispatcher dispatcher;
    private final Parser parser;
    private final DataLoader dataLoader;
    private final  Repository repository;

    public Application() {
        this.configApp = new ConfigApp();
        this.dataLoader = configApp.dataLoader();
        var initialData = dataLoader.load();
        this.repository = configApp.repository(initialData);
        Mapper mapper = configApp.mapper();
        this.dispatcher = configApp.dispatcher(repository, mapper);
        this.parser = configApp.parser();
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
        dataLoader.save(repository.getMap());
    }

}
