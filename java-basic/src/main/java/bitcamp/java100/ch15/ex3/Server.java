package bitcamp.java100.ch15.ex3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {

        // 클라이언트 연결을 받는 객체 준비
        // 어떤 포트번호를 사용할지 결정해야 한다. 여기선 9999포트 번호를 사용한다.
        // 대기열 갯수를 설정 할수 있다.
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버를 실행하였다!");

        Socket socket = ss.accept();
        
        Scanner in = new Scanner(socket.getInputStream());
        
        String line = in.nextLine();
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        out.println(line);
        
        in.close();
        out.close();
        
        socket.close();
        
        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}

