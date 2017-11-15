package bitcamp.java100.ch15.ex2;

import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        // 서버에 연결 요청
        // 서버 대기열에 자리가 있으면 리턴한다.
        // 서버 대기열에 자리가 없으면 예외발생.
        Socket socket = new Socket("192.168.0.58",9999);
        System.out.println("서버와 연결 되었다!");


        System.out.printf("%s : %d\n",
                socket.getInetAddress().getHostAddress(),
                socket.getPort());

        socket.close();
    }

}
