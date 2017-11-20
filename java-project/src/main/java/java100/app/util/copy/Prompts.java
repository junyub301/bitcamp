package java100.app.util.copy;

import java.util.Scanner;

public class Prompts {
    static Scanner keyScan = new Scanner(System.in);
    
    
    public static int inputInt(String message, Object...values ) {
        System.out.printf(message, values);
        return Integer.parseInt(keyScan.nextLine());
    }

    public static String inputString(String message, Object...values ) {
        System.out.printf(message, values);
        return keyScan.nextLine();
    }
    
    @Deprecated
    public static String input(String message ) {
        System.out.print(message);
        return keyScan.nextLine();
    }
    
    public static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes") || response.equals("") ) {
            return true;
        }
        return false;
    }

    public static boolean confirm2(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if(response.equals("n") || response.equals("N") || response.equals("") ) {
            return false;
        }
        return true;
    }


}
