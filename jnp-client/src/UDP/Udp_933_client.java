/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Udp_933_client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1105;
        try {
            DatagramSocket server = new DatagramSocket();

            Student933 student = new Student933("B17dcat098");
            UdpUtils.sendObject(student, server, host, port);

            Student933 student1 = (Student933) UdpUtils.receiveObject(server);//nhan lan 1
            System.out.println(student1);

            //chuan hoa ten
            String name = student1.getName().toLowerCase().trim();
            System.out.println(name);
            
            String[] ten = name.split(" ");
            
            String chuanHoa = "";
            
            for (int i = 0; i < ten.length; i++) {
                ten[i] = ten[i].trim();
                chuanHoa+= Character.toUpperCase(ten[i].charAt(0)) + ten[i].substring(1) + " ";
            }            
            System.out.println(chuanHoa);
            student1.setName(chuanHoa);
            
            UdpUtils.sendObject(student1, server, host, port); // gui doi tuong co ten chuan hoa
            
            // Tao email
            String email = ten[ten.length - 1];
            for (int i = 0; i < ten.length-1; i++) {
                email += ten[i].charAt(0);
            }
            email+="@ptit.edu.vn";
            System.out.println(email);
            
        } catch (SocketException ex) {
            Logger.getLogger(Udp_933_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_933_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Udp_933_client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
