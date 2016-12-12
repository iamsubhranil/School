package com.apsm.school.testgui;

import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import javax.swing.*;
import java.io.*;
/**
 * Whenever a new user is created or a new school is created, it needs to be saved in main database otherwise
 * the respective will be unavailble on next restart. This class saves database when is called in an requirement.
 * 
 * @author Subhranil
 * @version 1.5(01042015)
 */
public class saveInNeed
{
    mainFrame mf;
    ImmidiateSaving is;
    /**
     * Constructor for objects of class saveInNedd
     * @param mf2
     * @param is
     */
    public saveInNeed(mainFrame mf2,ImmidiateSaving is)
    {
        mf = mf2;
        this.is = is;
        JPanel cp = new JPanel(null);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(25);
        jt.setText("Please wait while we enlist the changes in our database. Any type of interruption, by"+
            " any means, will lead to a unrecoverable database corruption.");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(jt));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(jt));
            
        
        mf.getContentPane().add(cp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        visualData.disableSpecialTransitions();
        windowManager.setWindow(cp);
        save s = new save();
        s.start();
    }

    /**
     *
     */
    public synchronized void no(){
        notify();
    }

    class save extends Thread{
        public synchronized void run(){
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
            //no();
            is.doNext();
            //windowManager.delWindow();
        }
    }
}
