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
public class Udp_932_client {    
    private static DatagramSocket socket;
    private static DatagramPacket sendPacket, receivePacket;
    private static final String host = "localhost";    
    private static final int port = 1108;
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {        
        socket = new DatagramSocket();
        // gui ma sinh vien
        String data = "B17dcat136;932";
        sendData(data);
        // Nhan de bai
        data = receiveData();
        String reqId = data.split(";")[0].trim();
        String name = data.split(";")[1].trim();
        System.out.println(data);
        // xu ly
        name = chTen(name);
        String kq = reqId+";"+name;
        sendData(kq);
        
    }

    private static String receiveData() throws IOException {
        byte[] byteArr = new byte[1024];
        receivePacket = new DatagramPacket(byteArr, byteArr.length);
        socket.receive(receivePacket);
        return new String(receivePacket.getData());
    }

    private static void sendData(String data) throws UnknownHostException, IOException {
        byte[] byteArr = data.getBytes();
        sendPacket = new DatagramPacket(byteArr, byteArr.length, InetAddress.getByName(host), port);
        socket.send(sendPacket);
    }

    private static String chTen(String data) {
        data = data.toLowerCase().trim().replaceAll("\\s+", " ");
        String[] strArr = data.split(" ");
        String kq = "";
        for (String s : strArr) {            
            s = s.trim();
            kq+=Character.toUpperCase(s.charAt(0)) + s.substring(1)+ " ";            
        }
        return kq.trim();
    }

    
}
