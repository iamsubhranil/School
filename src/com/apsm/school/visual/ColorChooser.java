/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package com.apsm.school.visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

/* ColorChooserDemo.java requires no other files. */

/**
 *
 * @author Subhra
 */

public class ColorChooser extends JPanel
                              implements ChangeListener {

    /**
     *
     */
    protected JColorChooser tcc;

    /**
     *
     */
    protected JLabel banner;
    static Color newColor;
    static visualController vc;
    static int t;
    static JFrame frame;

    /**
     *
     */
    public ColorChooser() {
        super(new BorderLayout());



        //Set up color chooser for setting text color
        tcc = new JColorChooser();
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose color of your choice"));
        tcc.setBackground(Color.WHITE);
        
        JButton jb = createNewButton("Save",22,Color.WHITE,Color.BLACK);
        jb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    
                    vc.enableSave(true);
                    vc.updateAll(newColor,t);
                    frame.dispose();
                }
            });
        
        add(tcc, BorderLayout.CENTER);
        add(jb, BorderLayout.PAGE_END);
    }
    
    /**
     *
     * @param text
     * @param fontSize
     * @param bc
     * @param fc
     * @return
     */
    public JButton createNewButton(String text,int fontSize,Color bc,Color fc){
        JButton jb = new JButton(text);
        jb.setBackground(bc);
        jb.setForeground(fc);
        jb.setFont(new Font("Segoe UI Light",0,22));
        jb.setEnabled(true);
        jb.setVisible(true);
        return jb;
    }

    public void stateChanged(ChangeEvent e) {
        newColor = tcc.getColor();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Choose color");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ColorChooser();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     *
     * @param c
     * @param type
     */
    public static void setElements(visualController c,int type){
        vc = c;
        t = type;
    }

    /**
     *
     */
    public static void main() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
