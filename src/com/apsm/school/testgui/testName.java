package com.apsm.school.testgui;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Subhra
 */
public class testName{
    private JMenuBar menuBar;
    private JButton Proceed;
    private JButton button1;
    private JLabel label1;
    private JTextField schlnm;
    private JTextArea textarea1;
    private JTextArea textarea2;
    String ter1 = "You're joking we guess. Name your school so that "+
                  "students around the world can join it seeing its "+
                  "flawless performance through years. ";
    String ter2 = "Note that this name has already given to some schools. "+
                  "Now we don't have any problem with this if you don't.";
    static mainFrame mf;
    //Constructor 

    /**
     *
     * @param mm
     */
        public testName(mainFrame mm){
        
        mf = mm;

        mf.setTitle("testName");

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,300));
        contentPane.setBackground(new Color(255,255,255));

        GroupLayout gl = new GroupLayout(contentPane);
        contentPane.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        Proceed = new JButton();
        Proceed.setBounds(311,354,131,40);
        Proceed.setBackground(new Color(255,255,255));
        Proceed.setForeground(new Color(0,0,0));
        Proceed.setEnabled(true);
        Proceed.setFont(new Font("Segoe UI Light",0,22));
        Proceed.setText("Proceed");
        Proceed.setVisible(true);
        Proceed.setName("btn1");
        //Set action for button click
        //Call defined method
        Proceed.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    cntnu(evt);
                }
            });

        button1 = new JButton();
        button1.setBounds(82,354,103,40);
        button1.setBackground(new Color(255,255,255));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("Segoe UI Light",0,22));
        button1.setText("Back");
        button1.setVisible(true);
        button1.setName("btn2");
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    bk(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(13,177,150,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("Segoe UI Light",0,22));
        label1.setText("School name :");
        label1.setVisible(true);
        label1.setName("lbl1");

        schlnm = new JTextField();
        schlnm.setBounds(157,177,300,35);
        schlnm.setBackground(new Color(255,255,255));
        schlnm.setForeground(new Color(0,0,0));
        schlnm.setEnabled(true);
        schlnm.setFont(new Font("Segoe UI Light",0,22));
        schlnm.setText("");
        schlnm.setVisible(true);
        schlnm.setName("txt1");
        
        textarea1 = new JTextArea();
        textarea1.setBounds(13,8,477,129);
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEnabled(true);
        textarea1.setFont(new Font("Segoe UI Light",0,22));
        textarea1.setText(dataStore.getName()+", give your school a good name so that "+
        "learning never stops here.");
        textarea1.setLineWrap(true);
        textarea1.setWrapStyleWord(true);
        textarea1.setBorder(BorderFactory.createBevelBorder(2));
        textarea1.setEditable(false);
        textarea1.setVisible(true);
        textarea1.setName("texta1");
        
        textarea2 = new JTextArea();
        textarea2.setBounds(14,238,470,100);
        textarea2.setBackground(new Color(255,255,255));
        textarea2.setForeground(new Color(0,0,0));
        textarea2.setEnabled(true);
        textarea2.setFont(new Font("Segoe UI Light",0,20));
        textarea2.setText("");
        textarea2.setEditable(false);
        textarea2.setLineWrap(true);
        textarea2.setWrapStyleWord(true);
        textarea2.setBorder(BorderFactory.createBevelBorder(2));
        textarea2.setVisible(true);
        textarea2.setName("texta2");
        //adding components to co
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
        .addGroup(gl.createParallelGroup()
        .addComponent(textarea1)
        .addGroup(gl.createSequentialGroup()
        .addComponent(label1)
        .addComponent(schlnm))
        .addComponent(textarea2)
        .addGroup(gl.createSequentialGroup()
        .addComponent(button1)
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
        .addComponent(Proceed))));
        
        gl.linkSize(1,label1,schlnm);
        
        gl.setVerticalGroup(gl.createSequentialGroup()
        .addComponent(textarea1)
        .addGroup(gl.createParallelGroup()
        .addComponent(label1)
        .addComponent(schlnm))
        .addComponent(textarea2)
        .addGroup(gl.createParallelGroup()
        .addComponent(button1)
        .addComponent(Proceed)));
        //adding panel to JFrame and seting of window position and close operation
        mf.getContentPane().add(contentPane,"Center");
        mf.pack();
        
        mf.setLocationRelativeTo(null);
        windowManager.setWindow(contentPane);
    }

    //Method actionPerformed for Proceed
    private void cntnu (ActionEvent evt) {
        //TODO
        boolean er1 = schlnm.getText().equals("");
        if(er1){
            textarea2.setText(ter1);
        }
        else{
            dataStore.setSchool(schlnm.getText());
            windowManager.delWindow();
            //new configGUI();
            new schoolBuilder(mf);
        }
        
    }

    //Method actionPerformed for button1
    private void bk (ActionEvent evt) {
        //TODO
        windowManager.delWindow();
        new testUser(mf);
    }

    private void animate(JPanel cp){
        Object [] jc = cp.getComponents();
        for(int h = 0;h<jc.length;h++){
            if(jc[h].getClass()==JButton.class){
                JButton jb = (JButton)jc[h];
                System.out.println(jb.getText());
            }
        }
    }
    
    /**
     *
     * @param jb
     */
    public void animateButton(JButton jb){
        String text = jb.getText();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new testName(mf);
                }
            });
    }

}