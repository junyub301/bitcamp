package bitcamp.java100.ch15.ex5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("서버 시작!");
        
        Socket socket = ss.accept();
        
        DataInputStream netIn = new DataInputStream(socket.getInputStream());
        
        String filename = netIn.readUTF();
        
        FileOutputStream fileOut = new FileOutputStream("xx-" + filename);
        
        long length = netIn.readLong();
        
        for (long i = 0; i < length; i++) {
            fileOut.write(netIn.read());
        }
        
        DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
        netOut.writeUTF("success");
        
        fileOut.close();
        netIn.close();
        netOut.close();
        socket.close();
        ss.close();
        
    }
    
}
