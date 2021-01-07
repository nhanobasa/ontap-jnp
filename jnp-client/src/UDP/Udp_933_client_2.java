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

import java.net.SocketException;
import java.net.UnknownHostException;
import UDP.Student933;

/**
 *
 * @author nhani
 */
public class Udp_933_client_2 {

    private static DatagramSocket socket;
    private static DatagramPacket sPacket;
    private static DatagramPacket rPacket;
    public static void main(String[] args) throws SocketException, IOException, ClassNotFoundException {
        socket = new DatagramSocket();
        Student933 student = new Student933("b17dcat136");
        sendData(student);
        // Nhan doi tuong
        Student933 student2 = receiveData();
        System.out.println(student2);
        String name = student2.getName();
        
        name = chTen(name);
        student2.setName(name);
        student2.setEmail(genEmail(name));
        
        System.out.println(student2);
        sendData(student2);
        
    }

    private static void sendData(Student933 student) throws UnknownHostException, IOException{
        if (socket != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            
            oos.writeObject(student);
            oos.flush();
            
            byte[] b = baos.toByteArray();            
            sPacket = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 1109);
            socket.send(sPacket);
                        
        }        
    }
    
    private static Student933 receiveData() throws IOException, ClassNotFoundException{
        if (socket != null) {
            byte[] bytes = new byte[1024];
            rPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(rPacket);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            
            Student933 s = (Student933) ois.readObject();
            return s;
        }
        return null;
    }

    private static String chTen(String name) {
        String[] strArr = name.trim().toLowerCase().split("\\s+");
        String kq = "";
        for (String s : strArr) {
            kq+= Character.toUpperCase(s.charAt(0)) + s.substring(1) + " ";
        }
        return kq.trim();
    }

    private static String genEmail(String name) {
        String[] strArr = name.toLowerCase().split(" ");
        String email = strArr[strArr.length-1];
        for (int i = 0; i < strArr.length-1; i++) {
            email+=strArr[i].charAt(0);
        }
        return email+"@ptit.edu.vn";        
    }
}
