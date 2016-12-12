package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.core.*;
import com.apsm.school.visual.windowManager;
/**
 * If the user want to delete his one or more schools, he can do it here. However, the deletation process will be
 * irreversible.
 * 
 * @author Subhranil
 * @version 1.5(30032015)
 */
public class schoolRemover implements ImmidiateSaving
{

    mainFrame mf;
    JComboBox jcb;
    /**
     * Constructor for objects of class schoolRemover
     * @param mf1
     */
    public schoolRemover(mainFrame mf1)
    {
        mf  = mf1;

        JPanel cp = new JPanel(null);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(25);
        jt.setText("Looks like you've got bored with them. No problem, do whatever you want."+
            " Just remember, it is an irreversible process.");

        JLabel jl = UICore.createNewLabel("School : ",22,"l0");

        jcb = UICore.createNewCom(20);

        String [] sc = dataStore.getSchoolNames();
        try{
            for(int i = 0;i<sc.length;i++){
                jcb.addItem(sc[i]);
            }
        }
        catch(Exception f){}

        JButton jb1 = UICore.createNewButton("Delete",22);
        jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    performDeletation();
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

        mf.getContentPane().add(cp, "Center");
        mf.pack();

        mf.setLocationRelativeTo(null);
        windowManager.setWindow(cp);
    }

    /**
     *
     */
    public void performDeletation(){
        String snm = (String)jcb.getSelectedItem();
        User cu = dataStore.getCurrentUser();
        cu.deleteSchool(cu.getSchool(snm));
        windowManager.delWindow();
        saveInNeed svn = new saveInNeed(mf,this);
    }
    
    /**
     *
     */
    public void doNext(){
        windowManager.delWindow();
        new decisionChooser(mf);
    }
}
