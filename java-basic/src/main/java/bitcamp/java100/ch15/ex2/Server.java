package bitcamp.java100.ch15.ex2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {

        // 클라이언트 연결을 받는 객체 준비
        // 어떤 포트번호를 사용할지 결정해야 한다. 여기선 9999포트 번호를 사용한다.
        // 대기열 갯수를 설정 할수 있다.
        ServerSocket ss = new ServerSocket(9999, 3);
        System.out.println("서버를 실행하였다!");

        // 클라이언트 연결을 기다린다. 
        // => 클라이언트가 서버에 연결을 요청하면 클라이언트 정보가 서버의 대기열에 추가된다.

        Scanner keyScan = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            
            System.out.println("클라이언트 승인:");
            keyScan.nextLine();

            // 대기열에서 대기중인 클라이언트 정보를 가져와서 통신준비를 한다.
            Socket socket = ss.accept();
            
            System.out.println("클라이언트와 연결 되었음!");
            System.out.printf("%s : %d\n",
                    socket.getInetAddress().getHostAddress(),
                    socket.getPort());
            
            socket.close();
        }

        // 사용후 자원 해제
        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}

