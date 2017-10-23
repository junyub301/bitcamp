package bitcamp.java100.ch06.ex2;

import java.io.Console;

public class MassageBox {

    static boolean confirm(String message) {
        
        Console console = System.console();
        
        String response = console.readLine(message).toLowerCase();
        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }
}
