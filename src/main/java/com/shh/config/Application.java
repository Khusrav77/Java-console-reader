package com.shh.config;

import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.service.Parser;
import java.util.Scanner;

public class Application {

    private final CommandDispatcher dispatcher;
    private final Parser parser;

    public Application(CommandDispatcher dispatcher, Parser parser) {
        this.dispatcher = dispatcher;
        this.parser = parser;
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
