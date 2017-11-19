package bitcamp.java100.ch05.test21;
import java.util.Scanner;

public class Test21_1 {
      
   
    public static void main(String[] args){
        
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력하세요: ");
        String line = keyScan.nextLine();
        System.out.println(line);
        keyScan.close();
        
    }
}