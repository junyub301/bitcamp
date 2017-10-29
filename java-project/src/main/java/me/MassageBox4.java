package me;
import java.util.Scanner;

public class MassageBox4 {
    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }
}
