package com.apsm.school.testgui;

import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import javax.swing.*;
import java.io.*;
class baseReader{
    mainFrame mf;
    JLabel jl;
    public baseReader(mainFrame m){
        mf = m;

        JPanel cp = new JPanel(null);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(25);
        jt.setText(dataStore.getName()+", keep patience until we gather up all the nuts and butters "+
            "of "+dataStore.getSchoolName()+".");

        jl = UICore.createNewLabel("",23,"l0");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(jt)
            .addComponent(jl));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(jt)
            .addComponent(jl));

        mf.getContentPane().add(cp, "Center");
        mf.pack();

        mf.setLocationRelativeTo(null);
        visualData.disableSpecialTransitions();
        windowManager.setWindow(cp);

        gl.linkSize(1,jt,jl);
        gl.linkSize(0,jt,jl);

        load l1 = new load();
        l1.start();
    }

    class load extends Thread{
        public void run(){
            //storageLoader sl = new storageLoader();
            //sl.startLoading();
            
            School s = dataStore.getCurrentUser().getSchool(dataStore.getSchoolName());
            Analyzer.loadSchool(s);
            windowManager.delWindow();
            new classViewer(mf);
        }
    }
}