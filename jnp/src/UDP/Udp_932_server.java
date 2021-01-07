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

/**
 *
 * @author nhani
 */
public class Udp_932_server {

    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket = new DatagramSocket(1108);
        System.out.println("Server started");
        while (true) {            
            // Nhan msv + mch
            String data = receiveData(socket);
            System.out.println("Sinh vien: " + data);
            // Gui de bai
            data = "reqId; tRaN duc   nHaN  ";
            sendData(data, socket, receivePacket.getAddress(), receivePacket.getPort());
            // nhan ket qua 
            data = receiveData(socket);
            System.out.println("Ket qua: " + data);
        }
    }

    private static String receiveData(DatagramSocket socket) throws IOException {
        byte[] byteArr = new byte[1024];
        receivePacket = new DatagramPacket(byteArr, byteArr.length);
        socket.receive(receivePacket);
        return new String(receivePacket.getData());
    }

    private static void sendData(String data, DatagramSocket socket, InetAddress address, int port) throws IOException {
        byte[] byteArr = data.getBytes();
        sendPacket = new DatagramPacket(byteArr, byteArr.length, address, port);
        socket.send(sendPacket);
    }
}
