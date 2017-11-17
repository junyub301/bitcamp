package bitcamp.java100.ch15.ex7;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastClient {

    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);

        MulticastSocket socket = new MulticastSocket();

        InetAddress ip = InetAddress.getByName("238.1.2.3");

        int port =9999;

        while (true) {

            System.out.print("보낼 메시지? ");
            String message = keyboard.nextLine();

            if (message.equals("quit"))
                break;

            byte[] bytes = message.getBytes("UTF-8");

            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, ip, port);

            socket.send(packet);
            System.out.println("데이터 출력 완료!");

        }
        socket.close();
        keyboard.close();
    }

}
