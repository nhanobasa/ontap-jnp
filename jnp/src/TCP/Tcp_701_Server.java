/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nhani
 */
public class Tcp_701_Server {

    public static void main(String[] args) {
        String s = "1,3,9,19,33,20";
        OutputStream out;
        InputStream inp;
        int kc, a, b;        
        byte[] myByte = new byte[1024];
        try {
// Khoi tao TCP Server
            ServerSocket serverSocket = new ServerSocket(1106);
            System.out.println("Server started...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Connection.");
                out = socket.getOutputStream();
                inp = socket.getInputStream();
                // Nhan ve ma sinh vien va ma cau hoi
                inp.read(myByte);                
                String recStr = new String(myByte).trim();
                String[] temp = recStr.split(";");
                String msv = temp[0];
                String maCh = temp[1];                
                System.out.println("Sinh vien: " + msv + " cau hoi: " + maCh);

                // Gui de bai cho client
                out.write(s.getBytes());
                out.flush();

                // Nhan ket qua tu client
                kc = inp.read();
                a = inp.read();
                b = inp.read();
                System.out.println(kc + "," + a + "," + b);                
                out.close();
                inp.close();
                socket.close();
                System.out.println("End Connection!");                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
