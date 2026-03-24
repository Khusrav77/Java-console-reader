package com.shh;

import com.shh.model.Command;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        while (true){
            var inputLine = scanner.nextLine();



           if (inputLine.equals("exit"))  {
                break;
            }

            Command pars = parser.parse(inputLine);

            System.out.println(pars);

        }



    }




}