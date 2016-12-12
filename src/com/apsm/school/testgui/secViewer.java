package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.visual.*;
import com.apsm.school.core.*;
/**
 * After selecting a class, its sections will be displayed on this window.
 * 
 * @author Subhranil
 * @version 1.5(02042015)
 */
public class secViewer
{
    mainFrame mf;

    /**
     *
     * @param m
     */
    public secViewer(mainFrame m)
    {
        mf = m;

        JPanel cp = new JPanel(null);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(25);
        jt.setText("Sections of class ");

        JLabel tsl = UICore.createNewLabel("Total students : ",20,"l0");
        JLabel ts = UICore.createNewLabel("",20,"l1");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(jt)
            .addGroup(gl.createSequentialGroup()
                .addComponent(tsl)
                .addComponent(ts)));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(jt)
            .addGroup(gl.createParallelGroup()
                .addComponent(tsl)
                .addComponent(ts)));

        mf.getContentPane().add(cp, "Center");
        mf.pack();
    }

}
