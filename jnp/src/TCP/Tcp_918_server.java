/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nhani
 */
public class Tcp_918_server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customer918 customer = new Customer918(913, "", "nguyen van hai duong", "10-11-1999", "");

        ServerSocket ss = new ServerSocket(1110);
        System.out.println("Server da san sang");

        while (true) {
            Socket server = ss.accept();
            System.out.println("Server da ket noi!");
            ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(server.getInputStream());

            // Nhan ma sinh vien va ma cau hoi
            String str = ois.readUTF();
            System.out.println(str);
            oos.writeObject(customer);
            oos.flush();

            customer = (Customer918) ois.readObject();
            System.out.println(customer);

        }
    }

}
