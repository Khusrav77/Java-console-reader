package com.shh;

import com.shh.config.ConfigApp;
import com.shh.handler.CommandDispatcher;
import com.shh.model.Command;
import com.shh.model.OutputMessage;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConfigApp configApp = new ConfigApp();
        CommandDispatcher dispatcher = configApp.dispatcher();
        Parser parser = configApp.parser();

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

        

    }




}