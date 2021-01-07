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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nhani
 */
public class Udp_803_client {

    private static DatagramPacket receivePacket;
    private static DatagramPacket sendPacket;

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 1108;

        DatagramSocket socket = new DatagramSocket();
        String s = "B17dcat136;803";
        // Gui ma sinh vien
        sendData(s, socket, address, port);
        // Nhan de bai

        String res = receiveData(socket);
        System.out.println(s);
        // lay de bai
        res = res.split(";")[1];

        // Xu ly du lieu
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            if (c == 0) {
                break;
            }
            if (hm.containsKey(c)) {
                hm.replace(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }

        int max = 0;
        char c = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + ":" + val);
            if (max < val) {
                max = val;
                c = key;
            }
        }
        socket.close();
    }

    private static void sendData(String s, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            byte[] byteArr = new byte[1024];
            byteArr = s.getBytes();

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
