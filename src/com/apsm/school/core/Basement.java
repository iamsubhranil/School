package com.apsm.school.core;

import java.io.*;
import com.apsm.school.visual.*;

/**
 *
 * @author Subhra
 */
public class Basement implements Serializable{
    User [] users = new User[0];
    Scheme [] schemes = new Scheme[0];
    Scheme lastused;
    
    /**
     *
     * @param u
     * @param s
     * @param lst
     */
    public Basement(User [] u,Scheme [] s,Scheme lst){
        users = u;
        schemes = s;
        lastused = lst;
    }
    
    /**
     *
     */
    public void applyData(){
        premitiveData.setUsers(users);
        visualData.loadAllSchemes(schemes);
        visualData.setCurrentScheme(lastused);
    }
}