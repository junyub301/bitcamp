package bitcamp.java100.ch15.ex1;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
         
        // 클라이언트 연결을 받는 객체 준비
        // 어떤 포트번호를 사용할지 결정해야 한다. 여기선 9999포트 번호를 사용한다.
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버를 실행하였다!");
        
        // 클라이언트 연결을 기다린다. 
        // => 클라이언트가 서버에 연결을 요청하면 클라이언트 정보가 서버의 대기열에 추가된다.
        
        Socket socket = ss.accept();
        
        System.out.println("클라이언트와 연결 되었음!");
        System.out.printf("서버 IP = %s\n", socket.getLocalAddress().getHostAddress());
        System.out.printf("서버 Port = %d\n", socket.getLocalPort());
        System.out.printf("클라이언트 IP = %s\n",socket.getInetAddress().getHostAddress());
        System.out.printf("클라이언트 Port = %d\n",socket.getPort());
      
        // 사용후 자원 해제
        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}

