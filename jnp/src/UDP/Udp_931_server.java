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
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Udp_931_server {

    private static DatagramPacket receivePacket, sendPacket;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(1107);
            System.out.println("Server stated!");

            while (true) {
                String str = receiveData(socket);
                System.out.println("Sinh vien: " + str);

                // Sinh day so ngau nhien gui cho client
                Random rd = new Random(); // creating Random object
                int[] arr = new int[50];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rd.nextInt(); // storing random integers in an array
                    System.out.println(arr[i]); // printing each array element
                }
                
                str = Arrays.toString(arr);
                str = str.replaceAll("\\[", "").replaceAll("\\]", "");
                System.out.println(str);
                // gui de bai
                String data = "reqId;"+str;                
                sendData(data, socket, receivePacket.getAddress(), receivePacket.getPort());
                
                // Nhan ket qua 
                data = receiveData(socket);
                System.out.println("ket qua: " + data);
                
            }
        } catch (SocketException ex) {
            Logger.getLogger(Udp_931_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_931_server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static String receiveData(DatagramSocket socket) throws IOException {
        if (socket != null) {
            byte[] byteArr =  new byte[1024];
            receivePacket = new DatagramPacket(byteArr, byteArr.length);
            socket.receive(receivePacket);            
            return new String(receivePacket.getData()).trim();
        }
        return null;
    }

    private static void sendData(String data, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            byte[] byteArr = data.getBytes();
            sendPacket = new DatagramPacket(byteArr, byteArr.length, address, port);
            socket.send(sendPacket);
        }
    }
    
    
}
