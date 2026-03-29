package com.shh;

import com.shh.model.Command;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        Parser parser = new Parser(validator);

        while (true){
            var inputLine = scanner.nextLine();


           if (inputLine.equals("exit"))  {
                break;
            }

            Command command = parser.parse(inputLine);

            System.out.println(command);

        }
        

    }




}