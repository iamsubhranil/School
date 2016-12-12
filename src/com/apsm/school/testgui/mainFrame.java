package com.apsm.school.testgui;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Subhra
 */
public class mainFrame extends JFrame {

    //Constructor 

    /**
     *
     */
        public mainFrame(){

        setTitle("mainFrame");
        setSize(100,100);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new mainFrame();
            }
        });
    }

}