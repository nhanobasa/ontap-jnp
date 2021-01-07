
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nhani
 */
public class Test {

    public static void main(String[] args) {
        String data = "2020;a%bcc-c;dyh%igf-c";
        String str1 = data.split(";")[1];
        String str2 = data.split(";")[2];
        String strout = "";
        for (int i = 0; i < str1.length(); i++) {
            String c = String.valueOf(str1.charAt(i));
            if (!str2.contains(c)) {
                strout+=c;
            }
        }
        
        System.out.println(strout);
    }
}
