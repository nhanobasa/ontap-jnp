/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Tcp_913_client {
    private static Student student;
    public static void main(String[] args) {
        ObjectInputStream ois;
        ObjectOutputStream oos;        
        
        Socket socket;        
        String host = "2.tcp.ngrok.io";
        int port = 17780;
        
        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            String str = "B17DCAT136;913";
            oos.writeUTF(str);
            oos.flush();
            
            student = (Student) ois.readObject();
            System.out.println(student);
            setGpa();
            
            oos.writeObject(student);
            oos.flush();
            
            oos.close();
            ois.close();
            socket.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Tcp_913_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Tcp_913_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void setGpa() {
        if (3.7 <= student.getGpa() && student.getGpa() <= 4) {
            student.setGpaLetter("A");
        }
        if (3.0 <= student.getGpa() && student.getGpa() <= 3.7) {
            student.setGpaLetter("B");
        }
        if (2.0 <= student.getGpa() && student.getGpa() <= 3.0) {
            student.setGpaLetter("C");
        }
        if (1.0 <= student.getGpa() && student.getGpa() <= 2.0) {
            student.setGpaLetter("D");
        }
        if (0 <= student.getGpa() && student.getGpa() <= 1.0) {
            student.setGpaLetter("F");
        }
    }
}
