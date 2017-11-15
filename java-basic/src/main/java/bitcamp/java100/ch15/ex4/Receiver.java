package bitcamp.java100.ch15.ex4;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 9999);

        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("receiver");

        Scanner in = new Scanner(socket.getInputStream());

        while(true) {
            System.out.println(in.nextLine());

        }
    }

}
