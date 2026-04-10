package com.shh;

import com.shh.config.ConfigApp;
import com.shh.dispacher.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Repository;
import com.shh.service.DataLoader;
import com.shh.util.Parser;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ConfigApp configApp = new ConfigApp();
        DataLoader dataLoader = configApp.dataLoader();
        var initialData = dataLoader.load();
        Repository repository = configApp.repository(initialData);
        Parser parser = configApp.parser();
        CommandDispatcher dispatcher = configApp.dispatcher(repository);

        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                var inputLine = scanner.nextLine();

                if (inputLine.equals("exit"))  {
                    break;
                }

                Command command = parser.parse(inputLine);
                OutputMessage result = dispatcher.handleCommand(command);

                System.out.println(result.getMsg());

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        dataLoader.save(repository.getMap());
    }

}