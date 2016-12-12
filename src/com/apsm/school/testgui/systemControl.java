package com.apsm.school.testgui;

import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.visual.*;

/**
 * All runtime controls can be customized or obtained here. This is a modified
 * version of controlPanel.
 *
 * @author Subhranil
 * @version 1.6(03042015)
 */
public class systemControl {

    JPanel cp;
    mainFrame mf;

    /**
     * Constructor for objects of class systemControl
     *
     * @param mf
     */
    public systemControl(mainFrame mf) {
        this.mf = mf;
        cp = new JPanel();

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JTextArea jt = UICore.createNewTextArea(30);
        jt.setText("Choose an option to continue");

        JLabel jl0 = UICore.createNewLabel("Other options", 25, "l3");

        JButton jb1 = createSpecialisedButton("Close this window", 22);
        jb1.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
            windowManager.loadSavedWindow();
        });
        JLabel jl1 = UICore.createNewLabel("General options", 25, "l0");

        JButton jb2 = createSpecialisedButton("Head in to the teacher's room", 22);
        jb2.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });
        JButton jb3 = createSpecialisedButton("Checkout available subjects", 22);
        jb3.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });
        JButton jb4 = createSpecialisedButton("Roam around classes", 22);
        jb4.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });
        JLabel jl2 = UICore.createNewLabel("User options", 25, "l1");

        JButton jb5 = createSpecialisedButton("Switch to another school", 22);
        jb5.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });
        JButton jb6 = createSpecialisedButton("Change the get up", 22);
        jb6.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });

        JButton jb61 = createSpecialisedButton("Return to home", 22);
        jb61.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });

        JButton jb7 = createSpecialisedButton("Sign out", 22);
        jb7.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.getSystemShortcut().opStat(true);
        });
        JLabel jl3 = UICore.createNewLabel("System options", 25, "l2");

        JButton jb8 = createSpecialisedButton("Close Asterisk", 22);
        jb8.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.removeSS();
            new doEndJob(mf, 0);
        });

        JButton jb9 = createSpecialisedButton("Restart Asterisk", 22);
        jb9.addActionListener((ActionEvent evt) -> {
            windowManager.delWindow();
            windowManager.removeSS();
            new doEndJob(mf, 1);
        });

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(jt)
                .addComponent(jl1)
                .addComponent(jb2)
                .addComponent(jb3)
                .addComponent(jb4)
                .addComponent(jl2)
                .addComponent(jb5)
                .addComponent(jb6)
                .addComponent(jb61)
                .addComponent(jb7)
                .addComponent(jl3)
                .addComponent(jb8)
                .addComponent(jb9)
                .addComponent(jl0)
                .addComponent(jb1));

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(jt)
                .addComponent(jl1)
                .addComponent(jb2)
                .addComponent(jb3)
                .addComponent(jb4)
                .addComponent(jl2)
                .addComponent(jb5)
                .addComponent(jb6)
                .addComponent(jb61)
                .addComponent(jb7)
                .addComponent(jl3)
                .addComponent(jb8)
                .addComponent(jb9)
                .addComponent(jl0)
                .addComponent(jb1));

        gl.linkSize(0, jt, jl1, jl2, jl3, jl0);
        visualData.disableSpecialTransitions();
        windowManager.setWindow(cp);
        mf.getContentPane().add(cp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        updateContent();
    }

    /**
     *
     */
    public void updateContent() {
        Object[] o = cp.getComponents();
        UIManager.put("Button.select", visualData.getColors()[0]);
        for (Object o1 : o) {
            if (o1.getClass() == JButton.class) {
                JButton jb1 = (JButton) o1;
                jb1.setBackground(visualData.getColors()[0]);
                jb1.setForeground(visualData.getColors()[2]);
                jb1.setBorder(BorderFactory.createLineBorder(visualData.getColors()[0], 1));
            }
        }
    }

    /**
     *
     * @param text
     * @param fz
     * @return
     */
    public JButton createSpecialisedButton(String text, int fz) {
        JButton jb1 = UICore.createNewButton(text, fz);
        jb1.setBackground(visualData.getColors()[0]);
        jb1.setBorder(BorderFactory.createLineBorder(visualData.getColors()[0], 1));
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                jb1.setForeground(jb1.getForeground().darker());
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                jb1.setForeground(jb1.getForeground().brighter());
            }

        });
        return jb1;
    }
}
