/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.Serializable;

/**
 *
 * @author nhani
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 20151107;
    
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;

    public Student(int id, String code, float gpa, String gpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public float getGpa() {
        return gpa;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", gpaLetter=" + gpaLetter + '}';
    }
    
    
    
    
}
