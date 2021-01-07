/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author nhani
 */
public class UdpUtils {
    public static void sendObject(Object data, DatagramSocket datagramSocket, String host, int port) throws IOException{
        if (datagramSocket != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            
            oos.writeObject(data);
            oos.flush();
            
            InetAddress address = InetAddress.getByName(host);
            byte[] byteArr = baos.toByteArray();
            
            DatagramPacket datagramPacket = new DatagramPacket(byteArr, byteArr.length, address, port );           
            datagramSocket.send(datagramPacket);
            oos.close();
            baos.close();
        }
    }
    
    public static Object receiveObject(DatagramSocket datagramSocket) throws IOException, ClassNotFoundException{
        Object resObject;
        if (datagramSocket != null) {
            byte[] byteArr = new byte[1024];
            
            DatagramPacket receivePacket = new DatagramPacket(byteArr, byteArr.length);
            datagramSocket.receive(receivePacket);
            
            ByteArrayInputStream bais= new ByteArrayInputStream(byteArr);
            ObjectInputStream ois = new ObjectInputStream(bais);
            
            resObject = ois.readObject();            
            return resObject;
        }
        return null;       
    }
}
