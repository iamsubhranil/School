package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.core.dataStore;
import com.apsm.school.visual.windowManager;
/**
 * After logging in, this is the place where an user will be redirected. The user will have three options, 
 * including creating, deleting or openning a school. The specified action will be done by this class.
 * 
 * @author Subhranil
 * @version 1.5(30032015)
 */
public class decisionChooser
{
    private mainFrame mf;

    /**
     * Constructor for objects of class decisionChooser
     * @param mf1
     */
    public decisionChooser(mainFrame mf1)
    {
        mf = mf1;

        JPanel cp = new JPanel(null);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        JTextArea hdg = UICore.createNewTextArea(25);
        hdg.setText("Welcome "+dataStore.getName()+", good to see you again. Are you tired of "+
            "your old chunks? Or do you think you can handle even some more of them? "+
            "The choice is yours.");

        JButton jb1 = UICore.createNewButton("Create",23);
        jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    windowManager.delWindow();
                    new testName(mf);
                }
            });
        JButton jb2 = UICore.createNewButton("Delete",23);
        jb2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    windowManager.delWindow();
                    new schoolRemover(mf);
                }
            });
        JButton jb3 = UICore.createNewButton("Open",23);
        jb3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    windowManager.delWindow();
                    new testChoose(mf);
                }
            });
        String [] snm = dataStore.getSchoolNames();
        try{
            int n = snm.length;
            if(n==0){
                jb3.setEnabled(false);
                jb2.setEnabled(false);
            }
        }
        catch(NullPointerException h){
            jb3.setEnabled(false);
            jb2.setEnabled(false);
        }
        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(hdg)
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb2)));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(hdg)
            .addGroup(gl.createParallelGroup()
                .addComponent(jb1)
                .addComponent(jb3)
                .addComponent(jb2)));

        mf.getContentPane().add(cp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);

        windowManager.setWindow(cp);
    }

}
