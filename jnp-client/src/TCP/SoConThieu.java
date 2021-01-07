/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nhani
 */
public class SoConThieu {
    public static void main(String[] args) {
        String res = "id999;20; 2, 3, 5, 6, 5, 11, 19";        
        // Xu ly
        res = res.trim();
        int length = Integer.parseInt(res.split(";")[1].trim());
        Set<Integer> set = new HashSet<>();        
        String strNum  = res.split(";")[2].trim();
        System.out.println(strNum);               
        
        String[] strArr = strNum.split(",");       
        for (String strArr1 : strArr) {
            int num = Integer.parseInt(strArr1.trim());
            set.add(num);
        }
        
        String kq = res.split(";")[0].trim()+";";
        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                kq+= i + ", ";
            }
        }
        
        System.out.println(kq);
    }
}
