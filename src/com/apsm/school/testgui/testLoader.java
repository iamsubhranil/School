package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.apsm.school.visual.*;
import com.apsm.school.core.*;
class testLoader{
    mainFrame mf2;
    JPasswordField jpf;
    JTextField jt;
    JTextArea stat;
    public testLoader(mainFrame mf){
        mf2 = mf;
        JPanel cp = new JPanel(null);
        cp.setForeground(Color.WHITE);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea hdg = UICore.createNewTextArea(25);
        hdg.setText("Here you go. We have almost recognised you. Just let us be sure.");
        stat = UICore.createNewTextArea(20);
        JLabel lbl = UICore.createNewLabel("Username : ",22,"l1");
        JLabel pwdlbl = UICore.createNewLabel("Your password : ",22,"l2");
        JButton lgnbtn = UICore.createNewButton("Log in",22);
        lgnbtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    dolog(e);
                }
            });
        JButton bkbtn = UICore.createNewButton("Back",22);
        bkbtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    windowManager.delWindow();
                    new testWindow(mf2);
                }
            });
        jt = UICore.createNewTextField(22);

        jpf = new JPasswordField();
        jpf.setFont(new Font("Segoe UI Light",0,22));
        jpf.setForeground(Color.BLACK);
        jpf.setEnabled(true);
        jpf.setVisible(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(hdg)
            .addGroup(gl.createSequentialGroup()
                .addComponent(lbl)
                .addComponent(jt))
            .addGroup(gl.createSequentialGroup()
                .addComponent(pwdlbl)
                .addComponent(jpf))
            .addComponent(stat)
            .addGroup(gl.createSequentialGroup()
                .addComponent(lgnbtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(bkbtn))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(hdg)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addGroup(gl.createParallelGroup()
                .addComponent(lbl)
                .addComponent(jt))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addGroup(gl.createParallelGroup()
                .addComponent(pwdlbl)
                .addComponent(jpf))  
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addComponent(stat)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addGroup(gl.createParallelGroup()
                .addComponent(lgnbtn)
                .addComponent(bkbtn)));

        mf.getContentPane().add(cp, "Center");
        mf.pack();

        mf.setLocationRelativeTo(null);
        windowManager.setWindow(cp);
    }

    private void dolog (ActionEvent evt) {
        //TODO
        String unm = jt.getText();
        String pwd = new String(jpf.getPassword());
        if(premitiveData.hasUser(unm)){
            if(premitiveData.checkPass(unm,pwd)){
                User u = premitiveData.getUser(unm);
                dataStore.loadUser(u);
                //String [] snm = u.getAllSchools();
                //dataStore.setSchools(u.getAllSchools());
                stat.setText("You are an user.");
                windowManager.delWindow();
                //new testChoose(mf2);
                new decisionChooser(mf2);
            }
            else{
                stat.setText("Fella, you have provided wrong details.");
            }
        }
        else{
            stat.setText("Fella, you have provided wrong details.");
        }
    }

}