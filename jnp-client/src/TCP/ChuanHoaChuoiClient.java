/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhani
 */
public class ChuanHoaChuoiClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1101);

            // Tao luong ky tu
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Nhan chuoi tu server
            String str = br.readLine().trim();
            System.out.println("Chuoi server: " + str);
            // xu ly
            String[] strArr = str.split(" ");
            String strResult = "";

            for (String s : strArr) {
                s = s.trim();
                if (!s.isEmpty()) {
                    s = s.toLowerCase();
                    s = s.replaceFirst(String.valueOf(s.charAt(0)), String.valueOf(Character.toUpperCase(s.charAt(0))));
                    strResult = strResult + s + " ";
                }
            }
            System.out.println("Ket qua: " + strResult);

            bw.write(strResult);
            bw.newLine();
            bw.flush();
            br.close();
            bw.close();
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ChuanHoaChuoiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
