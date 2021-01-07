/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;


/**
 *
 * @author nhani
 */
public class Udp_933_server {

    public static void main(String[] args) {
        try {
            String host = "localhost";
            int port = 1109;
            DatagramSocket server = new DatagramSocket(port);
            System.out.println("Server Started!");
            while (true) {                
                Student933 student = (Student933) UdpUtils.receiveObject(server);
                System.out.println(student.getCode());

                Student933 student1 = new Student933("281", student.getCode(), "vu qUANG hUy", null);
                UdpUtils.sendObject(student1, server, UdpUtils.receivePacket.getAddress(), UdpUtils.receivePacket.getPort());

                Student933 student2 = (Student933) UdpUtils.receiveObject(server);
                System.out.println(student2.getName() + " " + student2.getEmail());
            }
        } catch (SocketException ex) {
            Logger.getLogger(Udp_933_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udp_933_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Udp_933_server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
