import java.util.Scanner;

public class MassageBox3 {
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
