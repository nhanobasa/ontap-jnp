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
public class Udp_936_client {

    private static DatagramPacket rPacket;
    private static DatagramSocket socket;
    private static DatagramPacket sPacket;
    public static void main(String[] args) throws SocketException, IOException {
        socket = new DatagramSocket();
        String data = "B17dcat136;936";
        sendData(data);
        
        //Nhan de bai
        data = receiveData().trim();
        System.out.println(data);
        // Xu ly du lieu
        String[] strArr = data.split(";");
        
        String reqId =strArr[0].trim();
        String str1 = strArr[1].trim();
        String str2 = strArr[2].trim();
        String strOut = "";
        for (int i = 0; i < str1.length(); i++) {
            String c = str1.charAt(i) + "";
            if (!str2.contains(c)) {
                strOut += c;
            }
        }
        
        // Gui ket qua
        String kq = reqId+";"+strOut;
        System.out.println("ket qua: "+ kq);
        sendData(kq);
    }

    private static String receiveData() throws IOException {
        byte[] b = new byte[1024];
        rPacket = new DatagramPacket(b, b.length);
        socket.receive(rPacket);
        return new String(rPacket.getData());
    }

    private static void sendData(String data) throws UnknownHostException, IOException {
        byte[] b = data.getBytes();        
        sPacket = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 1108);
        socket.send(sPacket);
    }
}
