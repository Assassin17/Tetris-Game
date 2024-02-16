package org.encord;

import org.encord.Service.GameLogic;

import java.util.*;
import java.util.logging.Logger;


/***
 * No Use of SpringBoot for solving this question , hence can't leverage autowired and other annotations...
 */
public class Main {
    private final static Logger log = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        log.info("Welcome to Encode Tetris Game Assignment");

        GameLogic logicLayer = new GameLogic();


        /** We can use this for file input but for this use case we can take input from CLI...

         try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
         stream.forEach(System.out::println);
         }
         **/

        //TODO: considering Q0 case --> Q is a Char and 0 being integer..

        Scanner input = new Scanner(System.in);
        String userInput;
        while((userInput=input.nextLine())!=null){
            logicLayer.maxHeight(userInput);
        }
        {
            System.out.println("Stopping server");
            System.exit(1);
        }


    }
}