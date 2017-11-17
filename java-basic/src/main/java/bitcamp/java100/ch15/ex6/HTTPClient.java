package bitcamp.java100.ch15.ex6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HTTPClient {
    
    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("www.etnews.com", 80);
        
        PrintStream out = new PrintStream(
                          new BufferedOutputStream(
                          socket.getOutputStream()));
        
        // HTTP 요청 프로토콜에 따라 출력
        // => request-line출력
        out.println("GET / HTTP/1.1");
        
        // 헤더 출력 : 최소한 Host 헤더는 보내야 한다.
        out.println("Host: www.etnews.com");
    
        out.println();
        out.flush();
        
        BufferedReader in  = new BufferedReader(
                             new InputStreamReader( // 바이너리 스트림을 캐릭터 스트림으로 변환
                             socket.getInputStream()));

        String line;
        
        while (true) {
            line = in.readLine();
            System.out.println(line);
            if (line.equals(""))
                break;
        }
        
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char)b);
        }
        
        out.close();
        in.close();
        socket.close();
        
    }

}
