package bitcamp.java100.ch15.ex4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {

        ArrayList<SenderStub> senders = new ArrayList<>();
        ArrayList<ReceiverStub> receivers = new ArrayList<>();


        ServerSocket ss = new ServerSocket(9999);

        for (int i = 0; i < 4; i++) {
            Socket socket = ss.accept();

            Scanner in = new Scanner(socket.getInputStream());
            String message = in.nextLine();
            
            if (message.equals("receiver")) {
                receivers.add(new ReceiverStub(socket));
            }else {
                senders.add(new SenderStub(socket));
            }
        }
        System.out.println("접속 모두 완료했음!");
        while(true) {
        for (int i = 0; i < senders.size(); i++) {
            System.out.println("메시지 수신중...");
            SenderStub sender = senders.get(i);
            String message = sender.nextMessage();
            System.out.printf("메시지 수신: %s\n", message);
            
            System.out.println("메시지 송신중...");
            for(int j = 0; j < receivers.size(); j++) {
                ReceiverStub receiver = receivers.get(j);
                receiver.receive(message);
            }
            System.out.println("메시지 송신 완료");
        }
        }
    }
}
