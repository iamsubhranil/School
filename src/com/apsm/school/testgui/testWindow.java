package com.apsm.school.testgui;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author Subhra
 */
public class testWindow{
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JTextArea textarea1;
    mainFrame mf;
    //Constructor 

    /**
     *
     * @param mnf
     */
        public testWindow(mainFrame mnf){
        
        //windowManager.getCP().disableAppSpecificButton(this);
        mf = mnf;
        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setBackground(new Color(255,255,255));

        GroupLayout gp = new GroupLayout(contentPane);
        contentPane.setLayout(gp);
        gp.setAutoCreateGaps(true);
        gp.setAutoCreateContainerGaps(true);

        button1 = UICore.createNewButton("Habituated Handler",22);
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    login(evt);
                }
            });

        button2 = UICore.createNewButton("Newbie",22);
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    nwusr(evt);
                }
            });

        textarea1 = UICore.createNewTextArea(22);
        textarea1.setText("Hi pal, welcome to your own school. A place "+
            "where you are the master of your students. A "+
            "place where scolding is always one sided. Let us "+
            "know if you are an old good administrator or just "+
            "a newbie to this profession.");
        
        gp.setHorizontalGroup(gp.createParallelGroup(GroupLayout.Alignment.LEADING) 
            .addComponent(textarea1)
            .addGroup(gp.createSequentialGroup()
                .addComponent(button1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(button2))
        );

        //adding components to contentPane panel
        gp.setVerticalGroup(gp.createSequentialGroup()
            .addComponent(textarea1)   
            .addGroup(gp.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(button1)
                
                .addComponent(button2))
        );
        //adding panel to JFrame and seting of window position and close operation
        
        
        mnf.getContentPane().add(contentPane,"Center");
        mnf.pack();
        
        mf.setLocationRelativeTo(null);
        
        
        windowManager.setWindow(contentPane);
    }

    //Method actionPerformed for button1
    private void login (ActionEvent evt) {
        //TODO
        windowManager.delWindow();
        mf.pack();
        new testLoader(mf);
    }

    //Method actionPerformed for button2
    private void nwusr (ActionEvent evt) {
        //TODO
        windowManager.delWindow();
        mf.pack();
        new testUser(mf);
        
    }

}