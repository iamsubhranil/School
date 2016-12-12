package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.visual.*;
import java.util.*;
import java.text.*;
/**
 * This is the shortcut icon used to access the control panel. However to add some extra spice, a mini calender
 * is show along with the option button.
 * 
 * @author Subhranil
 * @version 1.6(03042015)
 */
public class sysShortcut
{
    mainFrame mf;
    JLabel tlbl;
    JLabel dlbl;
    JPanel cp;
    JButton op;
    /**
     * Constructor for objects of class sysShortcut
     * @param mf
     */
    public sysShortcut(mainFrame mf)
    {
        this.mf = mf;
        cp = new JPanel();

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        op = UICore.createNewButton("Options",25);
        op.setBackground(visualData.getColors()[0]);
        op.setForeground(visualData.getColors()[2]);
        op.setBorder(BorderFactory.createLineBorder(visualData.getColors()[0],1));
        op.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt){
                    op.setForeground(op.getForeground().darker());
                }

                public void mouseExited(MouseEvent evt){
                    op.setForeground(op.getForeground().brighter());
                }

            });
        op.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    windowManager.saveWindow();
                    windowManager.delWindow();
                    new systemControl(mf);
                    op.setEnabled(false);
                }
            });
        tlbl = UICore.createNewLabel("Wait",30,"l0");

        dlbl = UICore.createNewLabel("Wait",25,"l1");

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(tlbl)
            .addGroup(gl.createSequentialGroup()
                .addComponent(dlbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(op)));

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(tlbl)
            .addGroup(gl.createParallelGroup()
                .addComponent(dlbl)
                .addComponent(op)));
        windowManager.setSS(this,cp);
        mf.getContentPane().add(cp, "South");
        mf.pack();
        mf.setLocationRelativeTo(null);
        time t = new time();
        t.start();
    }
    
    /**
     *
     * @param b
     */
    public void opStat(boolean b){
        op.setEnabled(b);
    }

    /**
     *
     */
    public void updateAll(){
        visualData.disableSpecialTransitions();
        visualData.updateContentPane(cp);
        op.setBackground(visualData.getColors()[0]);
        op.setForeground(visualData.getColors()[2]);
        op.setBorder(BorderFactory.createLineBorder(visualData.getColors()[0],1));
    }

    class time extends Thread{
        public void run(){
            int i = 0;
            while(i==0){
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                tlbl.setText(sdf.format(d));
                sdf = new SimpleDateFormat("EEEE',' MMMMM dd");
                dlbl.setText(sdf.format(d));
                try{
                    Thread.sleep(1000);
                }
                catch(Exception h){}
            }
        }
    }
}
