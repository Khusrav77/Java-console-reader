package com.shh;

import com.shh.config.ConfigApp;
import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.MessageRepository;
import com.shh.service.DataLoader;
import com.shh.service.Parser;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ConfigApp configApp = new ConfigApp();
        DataLoader dataLoader = configApp.dataLoader();
        var initialData = dataLoader.load();
        MessageRepository messageRepository = configApp.repository(initialData);
        Parser parser = configApp.parser();
        CommandDispatcher dispatcher = configApp.dispatcher(messageRepository);

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
        dataLoader.save(messageRepository.getMap());
    }

}