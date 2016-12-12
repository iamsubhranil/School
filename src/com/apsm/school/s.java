package com.apsm.school;

import com.apsm.school.core.*;
import java.io.*;

/**
 *
 * @author Subhra
 */
public class s implements Serializable{

    /**
     *
     * @param s
     */
    
    public static void main(String [] args){
        read();
    }
    public static void main(User s){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Users.ser"));
            
            oos.writeObject(s);
            oos.close();
        }
        catch(IOException h){
            h.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public static Object read(){
        try{
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Database\\basement.ser"));
            Object a1= oos.readObject();
            
            oos.close();
            System.out.println(a1);
            System.out.println(a1.getClass());
            ((Basement)a1).applyData();
            return a1;
        }
        catch(IOException | ClassNotFoundException h){
            h.printStackTrace();
        }
        return null;
    }
}