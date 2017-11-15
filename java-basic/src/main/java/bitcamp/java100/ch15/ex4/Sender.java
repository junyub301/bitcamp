package bitcamp.java100.ch15.ex4;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {

    public static void main(String[] args) throws Exception {
        
        Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost",9999);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("sender");
        
        while(true) {
            
            System.out.print("입력: ");
            out.println(keyboard.nextLine());
        }
        
    }
}
