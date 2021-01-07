/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 * Cho chuoi chua chuan hoa:" tRan DuC  NHAN     "
 * Chua hoa chuoi do
 * Su dung luong ki tu
 * BufferWriter
 * BerfferRender
 * 
 * port 1101
 * 
 */
public class ChuanHoaChuoiServer {
    public static void main(String[] args) {
        
        try {
            ServerSocket ss = new ServerSocket(1101);
            System.out.println("Server startd...");
            
            while (true) {                
                // Khoi tao ket noi
                Socket socket = ss.accept();
                System.out.println("New Connection");
                
                // Tao luong ky tu  
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              
                String str = "tRan DuC  NHAN     ";
                
                //  Gui cho client chuoi chua chuan hoa
                bw.write(str);
                bw.newLine();
                bw.flush();
                
                System.out.println("send message successfull!");
                
                // Nhan ket qua tu client
                str = br.readLine();
                System.out.println("Ket Qua: " + str);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChuanHoaChuoiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
