/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import com.sun.security.ntlm.Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author nhani
 */
public class Tcp_913_server {

    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    public Tcp_913_server() {
        try {
            @SuppressWarnings("resource")
            ServerSocket server = new ServerSocket(1109);
            System.out.println("Server is Running..!");
            while (true) {
                socket = server.accept();
                System.out.println("New Connection...!");

                // Luu y: khoi tao oos truoc ois
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());

                System.out.println("Trao doi du lieu:");

                // Nhan ma sinh vien.
                String str = ois.readUTF();
                System.out.println("Ma Sinh vien: " + str);

                // Gui doi tuong student.
                Student student = new Student(913, "B16DCCN284", 2.7f, "");
                oos.writeObject(student);
                oos.flush();

                // Nhan ket qua client.
                student = (Student) ois.readObject();
                System.out.println(student);

                ois.close();
                oos.close();
                socket.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Tcp_913_server();
    }

}
