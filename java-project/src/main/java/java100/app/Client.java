package java100.app;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("서버주소? ");
        String serverAddr = keyboard.nextLine();

        try (Socket socket = new Socket(serverAddr, 9999);

                PrintStream out = new PrintStream(
                        new BufferedOutputStream(socket.getOutputStream()));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                ){

            while (true) {
                System.out.print("명령> ");
                String command = keyboard.nextLine();

                out.println(command);
                out.flush();

                if (command.equals("quit")) {
                    break;
                }
                
                while (true) {
                    String line = in.readLine();
                    if (line.isEmpty())
                        break;

                    System.out.println(line);
                } // while
            } // while
        } catch (Exception e) {
            e.printStackTrace();
        }

        keyboard.close();
    }
}
