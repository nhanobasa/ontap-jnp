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
//    public static DatagramPacket receivePacket;
//    
//    public static void sendObject(Object data, DatagramSocket datagramSocket, InetAddress address, int port) throws IOException{
//        if (datagramSocket != null) {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            
//            oos.writeObject(data);
//            oos.flush();
//                        
//            byte[] byteArr = baos.toByteArray();
//            
//            DatagramPacket datagramPacket = new DatagramPacket(byteArr, byteArr.length, address, port );
//            datagramSocket.send(datagramPacket);
//            oos.close();
//            baos.close();
//            
//        }
//    }
//    
//    public static Object receiveObject(DatagramSocket datagramSocket) throws IOException, ClassNotFoundException{
//        Object resObject;
//        if (datagramSocket != null) {
//            byte[] byteArr = new byte[1024];
//            
//            receivePacket = new DatagramPacket(byteArr, byteArr.length);            
//            datagramSocket.receive(receivePacket);
//            
//            ByteArrayInputStream bais= new ByteArrayInputStream(byteArr);
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            
//            resObject = ois.readObject();            
//            return resObject;
//        }
//        return null;       
//    }
//    
//    public static void sendString(String data, DatagramSocket socket, InetAddress address, int port) throws IOException{
//        if(socket !=null){
//            byte[] byteData =  new byte[1024];
//            byteData = data.getBytes();
//            
//            DatagramPacket sendPacket = new DatagramPacket(byteData, byteData.length, address, port);
//            socket.send(sendPacket);            
//        }
//    }
//    
//    public static String receiveString(DatagramSocket socket) throws IOException{
//        if (socket != null) {
//            byte[] receiveByte = new byte[1024];
//            receivePacket = new DatagramPacket(receiveByte, receiveByte.length);
//            socket.receive(receivePacket);
//            return new String(receivePacket.getData()).trim();
//        }
//        return null;        
//    }

    public static DatagramPacket sendPacket;
    public static DatagramPacket receivePacket;
    public static ByteArrayInputStream bais;
    public static ByteArrayOutputStream baos;

    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;

    public static void sendObject(Object data, DatagramSocket socket, InetAddress address, int port) throws IOException {
        if (socket != null) {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            oos.writeObject(data);
            oos.flush();

            byte[] byteData = baos.toByteArray();
            sendPacket = new DatagramPacket(byteData, byteData.length, address, port);
            socket.send(sendPacket);

            oos.close();
            baos.close();
        }
        System.out.println("socket is null");

    }

    public static Object receiveObject(DatagramSocket socket) throws IOException, ClassNotFoundException {
        if (socket != null) {
            Object object;
            byte[] byteData = new byte[1024];
            
            receivePacket = new DatagramPacket(byteData, byteData.length);
            socket.receive(receivePacket);
                        
            
            bais = new ByteArrayInputStream(byteData);
            ois = new ObjectInputStream(bais);
            
            object = ois.readObject();
            return object;
        }
        return null;
    }
}
