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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Udp_931_client {

    private static DatagramPacket sendPacket;
    private static DatagramPacket receivePacket;
    
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            int port = 1107;
            
            String data = "B17dcat136;931";
            // gui ma sinh vien +  ma cau hoi
            sendData(data, socket, address, port);
            // Nhan de bai
            data = receiveData(socket).trim();
            String reqId = data.split(";")[0];
            data = data.split(";")[1];
            System.out.println("data:\n " + data);
            // xy ly tim max, min
            String[] strArr = data.split(",");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i].trim());
            }
            
            Arrays.sort(arr);
            int max = arr[arr.length-1];
            int min =arr[0];
            
            // Gui ket qua
            reqId+=";"+min+";"+max;
            System.out.println(reqId);
            sendData(reqId, socket, address, port);           
                    
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(Udp_931_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_931_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void sendData(String data, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            byte[] byteArr = data.getBytes();
            sendPacket = new DatagramPacket(byteArr, byteArr.length, address, port);
            socket.send(sendPacket);
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
}
