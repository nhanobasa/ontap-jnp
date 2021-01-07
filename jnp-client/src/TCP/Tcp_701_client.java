/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author nhani
 */
public class Tcp_701_client {
    public static void main(String[] args) throws IOException {
        byte[] myByte = new byte[1024];
        String s;
        InputStream is;
        OutputStream os;
        String host= "127.0.0.1";
        int port = 1106;
        
        Socket socket = new Socket(host, port); 
        System.out.println("Connected...");
        is = socket.getInputStream();
        
        // Gui ma sinh vien va ma cau hoi
        s = "B17DCAT136;701";
        os = socket.getOutputStream();
        os.write(s.getBytes());
        
        
        // Nhan de bai
        is.read(myByte);
        s = new String(myByte).trim();
        System.out.println(s);
        
        // Xu ly du lieu
        String[] strArr =  s.split(",");        
        int[] arr = new int[strArr.length];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i].trim());
        }
        
        int minKc = Integer.MAX_VALUE, pos1 = 0, pos2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int temp = Math.abs(arr[i] - arr[j]);
                if (temp < minKc) {
                    minKc = temp;
                    pos1 = arr[i];
                    pos2 = arr[j];
                }
            }
        }
        
        // gui ket qua len server
        os.write(minKc);
        os.write(pos1);
        os.write(pos2);
        
        os.close();
        is.close();                
        socket.close();
    }       
}
