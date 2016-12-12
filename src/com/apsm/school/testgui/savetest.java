package com.apsm.school.testgui;

import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import java.io.*;
/**
 * Database saving method is written in here. Other classes can call it when needed.
 * 
 * @author Subhranil
 * @version 1.5(01042015)
 */
public class savetest
{
    // instance variables - replace the example below with your own
    
    /**
     *
     */
        

    public static void save(){
        User [] us = premitiveData.getUsers();
        Scheme [] sh = visualData.getAllSchemes();
        Scheme s = visualData.getCurrentScheme();
        Basement bs = new Basement(us,sh,s);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database\\basement.ser"));
            oos.writeObject(bs);
            oos.close();
        }
        catch(Exception h){
            h.printStackTrace();
        }
        windowManager.delWindow();
    }

}
