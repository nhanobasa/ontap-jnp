/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Udp_802_server {
    private static DatagramPacket receivePacket, sendPacket;
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1107);
            System.out.println("Server Stated!");
            while (true) {                
                String msv = receiveData(socket);
                System.out.println("Sinh vien: " + msv);
                
                String question = "reqID;10;2,3,2,5, 6, 5";
                sendData(question, socket, receivePacket.getAddress(), receivePacket.getPort());
                
                String result = receiveData(socket);
                System.out.println(result);                
            }
        } catch (SocketException ex) {
            Logger.getLogger(Udp_802_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_802_server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    private static String receiveData(DatagramSocket socket) throws IOException {
        if (socket != null) {            
            byte[] byteData = new byte[1024];
            receivePacket = new DatagramPacket(byteData, byteData.length);
            socket.receive(receivePacket);
            return new String(byteData).trim();
        }        
        return null;
    }

    private static void sendData(String question, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            
            byte[] byteArr = new byte[1024];            
            byteArr = question.getBytes();
            sendPacket = new DatagramPacket(byteArr, byteArr.length, address, port);            
            socket.send(sendPacket);                        
        }
    }

}
