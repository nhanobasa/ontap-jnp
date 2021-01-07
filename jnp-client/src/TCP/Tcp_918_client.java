/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class Tcp_918_client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1110);

            String str = "B17dcat136;918";

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            // Gui msv;macauhoi
            oos.writeUTF(str);            
            oos.flush();

            // Nhan ve object
            Customer918 customer918 = (Customer918) ois.readObject();
            System.out.println(customer918);

            String name = customer918.getName();
            String date = customer918.getDayOfBirth();
            String username = "";

            customer918.setName(chTen(name));
            customer918.setDayOfBirth(chDate(date));
            customer918.setUserName(genUsername(name));

            System.out.println(customer918);
            oos.writeObject(customer918);
            oos.flush();

            ois.close();
            oos.close();
            socket.close();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Tcp_918_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String chTen(String str) {
        String res = "";
        int idx = str.lastIndexOf(" ") + 1;
        String hoDem = str.substring(0, idx);
        String ten = str.substring(idx);

        ten = ten.toUpperCase();
        String hd2 = "";
        for (int i = 0; i < hoDem.length(); i++) {
            if (i == 0 || hoDem.charAt(i - 1) == ' ') {
                hd2 += Character.toUpperCase(hoDem.charAt(i));
            } else {
                hd2 += hoDem.charAt(i);
            }
        }
        res += ten + ", " + hd2;
        return res;
    }

    private static String chDate(String date) {
        String[] strArr = date.split("-");
        return strArr[1] + "/" + strArr[0] + "/" + strArr[2];
    }

    private static String genUsername(String name) {
        String[] strArr = name.split(" ");
        String username = strArr[strArr.length - 1];
        for (int i = 0; i < strArr.length - 1; i++) {
            username += strArr[i].charAt(0);
        }
        return username;
    }
}
