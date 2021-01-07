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
public class Udp_803_server {

    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1108);
            System.out.println("Server stated!");
            while (true) {

                // Nhan msv
                String str = receiveData(socket);
                System.out.println(str);
                // gui de bai
                str = "reqId; Qnc8d5xakjAAdasfWW";
                sendData(str, socket, receivePacket.getAddress(), receivePacket.getPort());
                // nhan ket qua
                str = receiveData(socket);
                System.out.println("Ket qua; " + str);               

            }
        } catch (SocketException ex) {
            Logger.getLogger(Udp_803_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_803_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String receiveData(DatagramSocket socket) throws IOException {
        if (socket != null) {
            byte[] byteArr = new byte[1024];
            receivePacket = new DatagramPacket(byteArr, byteArr.length);
            socket.receive(receivePacket);
            return new String(receivePacket.getData());
        }
        return null;
    }

    private static void sendData(String data, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            byte[] byteArr;
            byteArr = data.getBytes();
            sendPacket = new DatagramPacket(byteArr, byteArr.length, address, port);
            socket.send(sendPacket);
        }
    }

}
