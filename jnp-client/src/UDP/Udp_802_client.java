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
import java.net.UnknownHostException;

/**
 *
 * @author nhani
 */
public class Udp_802_client {

    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 1107;
        
        DatagramSocket socket = new DatagramSocket();
        String str = "b17dcat136;802";
        
        // Gui msv
        sendData(str, socket, address, port);
        
        // Nhan de bai
        str = receiveData(socket);
        System.out.println(str.length());
        String[] strArr = str.split(";");
        
        String reqId = strArr[0]+";";
        int n = Integer.parseInt(strArr[1]);
        String l = strArr[2];
        
        for (int i = 1; i <= n; i++) {
            if(!l.contains(String.valueOf(i))){
                reqId+=i+",";
            }
        }
        
        System.out.println(reqId.substring(0, reqId.length()-1));
        sendData(reqId, socket, address, port);
        
        socket.close();
    }
    
    private static String receiveData(DatagramSocket socket) throws IOException {
        if (socket != null) {            
            byte[] byteData = new byte[1024];
            receivePacket = new DatagramPacket(byteData, byteData.length);
            socket.receive(receivePacket);
            return new String(receivePacket.getData());
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
