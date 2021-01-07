/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nhani
 */
public class SoLanXhServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8501);

            while (true) {
                Socket s = server.accept();
                System.out.println("runnning");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                bw.write("abd abc abf aaaabi  aa a a  - - -");
                bw.newLine();
                bw.flush();
                System.out.println("send the messs");
                String a = br.readLine();
                System.out.println(a);
            }

        } catch (Exception e) {
        }
    }
}
