package com.apsm.school.testgui;

import javax.swing.*;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import java.awt.event.*;
class testChoose{
    mainFrame mf2;
    public testChoose(mainFrame mf){
        JPanel jp = new JPanel(null);

        GroupLayout gl = new GroupLayout(jp);
        jp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(25);
        jt.setText(dataStore.getName()+", choose your school you want to head in.");

        JLabel jl = UICore.createNewLabel("School : ",22,"l0");

        JComboBox jcb = UICore.createNewCom(20);

        String [] sc = dataStore.getSchoolNames();
        for(int i = 0;i<sc.length;i++){
            jcb.addItem(sc[i]);
        }

        JButton jb1 = UICore.createNewButton("Go",22);
        jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    dataStore.setSchool((String)jcb.getSelectedItem());
                    windowManager.delWindow();
                    new baseReader(mf);
                    if(sc.length>1){
                    } 
                }
            });

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(jt)
            .addGroup(gl.createSequentialGroup()
                .addComponent(jl)
                .addComponent(jcb))
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb1)));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(jt)
            .addGroup(gl.createParallelGroup()
                .addComponent(jl)
                .addComponent(jcb))
            .addGroup(gl.createParallelGroup()
                .addComponent(jb1)));

        mf.getContentPane().add(jp, "Center");
        mf.pack();
        
        mf.setLocationRelativeTo(null);
        windowManager.setWindow(jp);
    }
}