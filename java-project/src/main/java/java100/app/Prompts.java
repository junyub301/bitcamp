package java100.app;

import java.util.Scanner;

public class Prompts {
    static Scanner keyScan = new Scanner(System.in);
    
    public static String input(String message ) {

        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        return keyScan.nextLine();
    }

    public static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes") || response.equals("") ) {
            return true;
        }
        return false;
    }

    public static boolean confirm2(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("n") || response.equals("N") || response.equals("") ) {
            return false;
        }
        return true;
    }


}
