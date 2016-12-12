package com.apsm.school.testgui;

import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import javax.swing.*;
import com.apsm.school.s;
class classViewer{
    mainFrame mf;
    public classViewer(mainFrame m){
        mf = m;

        JPanel cp = new JPanel();

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JButton jb1 = UICore.createNewButton("I",25);

        JButton jb2 = UICore.createNewButton("II",25);

        JButton jb3 = UICore.createNewButton("III",25);

        JButton jb4 = UICore.createNewButton("IV",25);

        JButton jb5 = UICore.createNewButton("V",25);

        JButton jb6 = UICore.createNewButton("VI",25);

        JButton jb7 = UICore.createNewButton("VII",25);

        JButton jb8 = UICore.createNewButton("VIII",25);

        JButton jb9 = UICore.createNewButton("IX",25);

        JButton jb10 = UICore.createNewButton("X",25);

        JButton jb11 = UICore.createNewButton("XI",25);

        JButton jb12 = UICore.createNewButton("XII",25);

        JTextArea jt = UICore.createNewTextArea(35);
        jt.setText("Classes of "+dataStore.getSchoolName());

        JLabel el1 = UICore.createNewLabel("      ",35,"l0");

        JLabel el2 = UICore.createNewLabel("      ",35,"l1");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(el1)
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb3))
            .addComponent(jt)
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb6))
            .addComponent(el2)
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb9))
            .addGroup(gl.createSequentialGroup()
                .addComponent(jb10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb11)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb12)));

        gl.setVerticalGroup(gl.createParallelGroup()

            .addGroup(gl.createSequentialGroup()
                .addComponent(el1)
                .addComponent(jb1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb10))
            .addGroup(gl.createSequentialGroup()
                .addComponent(jt)
                .addComponent(jb2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb11)
            )
            .addGroup(gl.createSequentialGroup()
                .addComponent(el2)
                .addComponent(jb3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(jb12)
            ));

        gl.linkSize(0,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12);
        gl.linkSize(1,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12);
        
        gl.linkSize(0,jt,el1,el2);
        gl.linkSize(1,jt,el1,el2);
        
        mf.getContentPane().add(cp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        windowManager.setWindow(cp);
        //s.main(u);
    }
}