package bitcamp.java100.ch15.ex5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) throws Exception {
        
        File photo = new File("./sample/a.jpg");
        
        FileInputStream fileIn = new FileInputStream(photo);
        
        Socket socket = new Socket("192.168.0.86", 9999);
        
        DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
        
        netOut.writeUTF(photo.getName());
        
        netOut.writeLong(photo.length());
        
        int b;
        while((b = fileIn.read()) != -1) {
            netOut.write(b);
        }
        
        DataInputStream netIn = new DataInputStream(socket.getInputStream());
        String response = netIn.readUTF();
        
        System.out.println(response);
        netOut.close();
        netIn.close();
        socket.close();
        fileIn.close();
        
    }
}
