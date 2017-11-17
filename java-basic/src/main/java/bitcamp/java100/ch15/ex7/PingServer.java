package bitcamp.java100.ch15.ex7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class PingServer {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        
        while (true ) {
            System.out.println("데이터를 기다리는 중...");
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength(), "UTF-8"); 

            System.out.printf("보낸이 주소: %s\n",packet.getAddress().getHostAddress());
            System.out.printf("보낸이 포트번호: %d\n",packet.getPort());
            System.out.printf("메시지: %s\n", message);
            System.out.println("---------------------------------------------------------");

        }
        // socket.close();
    }
}
