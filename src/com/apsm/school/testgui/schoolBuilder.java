package com.apsm.school.testgui;

import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import com.apsm.school.s;
import javax.swing.*;
import java.awt.event.*;
class schoolBuilder implements ImmidiateSaving{
    mainFrame mf;
    schoolBuilder schb;
    public schoolBuilder(mainFrame mf1){
        mf = mf1;
        schb = this;
        JPanel cp = new JPanel();

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea hdg = UICore.createNewTextArea(25);
        hdg.setText("That's all we need to know right know."+
            " Hold your nerves quite longer until we finish"+
            " building up a school for you. A school has many "+
            "functions you know. Wrapping all of them up in a single "+
            "package is not an easy task at all. You'll "+
            "be notified when we'll finish ours.");

        JButton svbtn = UICore.createNewButton("Save & continue",25);
        svbtn.setVisible(false);
        svbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    //storageCreator.save();
                    User u = dataStore.getCurrentUser();
                    School s = Analyzer.getSchool();
                    u.addSchool(s);
                    if(premitiveData.hasUser(u.getUserName())){
                        premitiveData.updateUser(u);
                    }
                    else{
                        premitiveData.addUser(u);}
                    dataStore.refreshLocalStore();
                    windowManager.delWindow();
                    new saveInNeed(mf,schb);
                }
            });
        JButton dsbtn = UICore.createNewButton("Discard",25);
        dsbtn.setVisible(false);
        dsbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    windowManager.delWindow();
                    new testName(mf);
                }
            });
        JLabel sublb1 = UICore.createNewLabel("a",20,"l1");

        JLabel sublb2 = UICore.createNewLabel("a",20,"l2");

        JLabel label1 = UICore.createNewLabel("a",20,"l3");

        JLabel prcn = UICore.createNewLabel("a",20,"l4");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(hdg)

            .addComponent(sublb2)
            .addComponent(prcn)
            .addComponent(sublb1)
            .addComponent(label1)

            .addGroup(gl.createSequentialGroup()
                .addComponent(dsbtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(svbtn))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(hdg)

            .addComponent(sublb2)
            .addComponent(prcn)
            .addComponent(sublb1)
            .addComponent(label1)

            .addGroup(gl.createParallelGroup()
                .addComponent(dsbtn)
                .addComponent(svbtn))
        );

        gl.linkSize(0, hdg, label1, sublb1, sublb2, prcn);

        mf.getContentPane().add(cp, "Center");
        mf.pack();
        windowManager.setWindow(cp);
        createSchedule csh = new createSchedule();
        csh.setElements(sublb1,sublb2,prcn,label1,svbtn,dsbtn);
        csh.strt();

    }

    @Override
    public void doNext(){
        windowManager.delWindow();
        new classViewer(mf);
    }
}