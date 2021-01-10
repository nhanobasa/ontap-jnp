/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author nhani
 */
public class tcp_911_client {
    static int UCLN(int a, int b) {
        if(b==0) return a;
        return UCLN(b, (a%b));
    }
    
    public static void main(String[] args) {
        DataInputStream dis;
        DataOutputStream dos;
        String str = "B17DCAT136";
        int a, b, ucln, bcnn, tong, tich;
        
        try {
            Socket socket = new Socket("localhost", 1110);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            
            dos.writeUTF(str);
            
            a = dis.readInt();
            b = dis.readInt();
            
            ucln = UCLN(a, b);
            if (ucln != 0) bcnn = (a * b) / ucln;
            else bcnn = 0;
            tong = a + b;
            tich = a * b;

            dos.writeInt(ucln);
            dos.writeInt(bcnn);
            dos.writeInt(tong);
            dos.writeInt(tich);
            dis.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
        }
    }
}
