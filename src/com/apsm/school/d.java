package com.apsm.school;

import java.io.*;
/**
 * Write a description of class d here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class d implements Serializable
{
    // instance variables - replace the example below with your own
    static s s1;

    /**
     * Constructor for objects of class d
     */
    public d()
    {
        // initialise instance variables
        s1 = new s();
    }

    /**
     *
     */
    public static void save(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("s12.ser"));
            oos.writeObject(s1);
            oos.close();
        }
        catch(Exception h){
            System.out.println(h.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
    public static s read(){
        try{
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("s12.ser"));
            s a1= (s)oos.readObject();
            
            oos.close();
            return a1;
        }
        catch(Exception h){
            System.out.println(h.getMessage());
        }
        return null;
    }
}
