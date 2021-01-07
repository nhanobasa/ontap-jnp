package TCP;


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nhani
 */
public class SoLanXhClient {
    public static void main(String[] args) {
        
        String str = " Qnc8d5xakjAAdasfWW";
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hm.containsKey(c)) {
                hm.replace(c, hm.get(c)+1);               
            }else{
                hm.put(c, 1);
            }
        }
        int max = 0;       
        char c = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();            
            System.out.println(key + ":" + val);
            if (max < val) {
                max = val;                
                c = key;
                
            }
        }                
        String kq = c +":";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                kq += String.valueOf(i) + ",";
            }
        }
        System.out.println("Result: " + kq);                
    }
}
