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
public class Tcp_912_client {

    private static StringBuilder str1, str2;

    private static void xuly(String strDb) {
        str1 = new StringBuilder();
        str2 = new StringBuilder();
        for (int i = 0; i < strDb.length(); i++) {
            String strTemp = "";
            strTemp += strDb.charAt(i);
            if (strTemp.matches("[a-zA-z0-9]")) {
                str1.append(strTemp);
            } else {
                str2.append(strTemp);
            }
        }
    }

    public static void main(String[] args) {
        String host = "2.tcp.ngrok.io";
        int port = 18600;
        String str = "B17DCAT136;901";
        BufferedWriter bw;
        BufferedReader br;

        try {
            Socket socket = new Socket(host, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // gui ma sinh vien va ma cau hoi
            bw.write(str);
            bw.newLine();
            bw.flush();

            // nhan chuoi de bai
            str = br.readLine();
            System.out.println("debai: " + str);

            // Xu ly de lieu
            xuly(str);            
            System.out.println("str1:" + str1.toString());
            System.out.println("str2:" + str2.toString());
            bw.write(str1.toString());
            bw.newLine();
            bw.flush();
            bw.write(str2.toString());
            bw.newLine();
            bw.flush();
            
            bw.close();
            br.close();
            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Tcp_912_client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
