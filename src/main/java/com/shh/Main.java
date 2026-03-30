package com.shh;

import com.shh.handler.CommandDispatcher;
import com.shh.handler.CreateHandler;
import com.shh.handler.GetAllHandler;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import com.shh.repository.Storage;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        CreateHandler createHandler = new CreateHandler(storage);
        GetAllHandler getAllHandler = new GetAllHandler(storage);
        CommandDispatcher commandDispatcher = new CommandDispatcher(createHandler, null, getAllHandler, null, null);

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        Parser parser = new Parser(validator);



        while (true){
            try {
                var inputLine = scanner.nextLine();


                if (inputLine.equals("exit"))  {
                    break;
                }

                Command command = parser.parse(inputLine);
                OutputMessage result = commandDispatcher.handleCommand(command);

                System.out.println(result.getMsg());

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        

    }




}