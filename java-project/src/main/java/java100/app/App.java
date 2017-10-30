package java100.app;
import java.util.Scanner;



//01026344150
//jinyoun.eom@gmail.com

public class App {

    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList list = new ArrayList();


        while(true) {
            Score score = new Score();
            score.input();
            list.add(score);

            if(!confirm("계속 하시겠습니까?")) break; 
        }
        
        for (int i = 0; i < list.size(); i++) {
//            Score s = (Score)list.get(i);
//            s.print();
            ((Score)list.get(i)).print();
        }
    }
}






