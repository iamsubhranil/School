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
public class testUser {

    private JMenuBar menuBar;
    private final JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    JTextField nmfld;
    JTextField pwdfld;
    private JComboBox sexbox;
    private JTextArea statare;
    private JTextArea textarea1;
    JTextField usrnmfld;
    private String sex = "Male";
    private String ter3 = "Salute your brilliant ideas. But alas, you are second on this "
            + "way. Take a different username.";
    private String ter1 = "You can't be a human without a name. Jokes apart. Share "
            + "us your name.";
    private String ter2 = "We know you have a good name. But we are not that much "
            + "eligble to zero on you by it. Provide an unique username.";
    private String ter4 = "Sorry to say. But this world is not as much good as you "
            + "are. Extend your password length to atleast 6 characters.";

    static mainFrame mf1;
    //Constructor 

    /**
     *
     * @param mf
     */
    public testUser(mainFrame mf) {

        mf.setTitle("testUser");
        mf1 = mf;

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setBackground(new Color(255, 255, 255));

        GroupLayout gl = new GroupLayout(contentPane);
        contentPane.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        button1 = UICore.createNewButton("Back", 20);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bk(evt);
            }
        });

        button2 = UICore.createNewButton("Proceed", 20);
        //Set action for button click
        //Call defined method
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cntnu(evt);
            }
        });

        label2 = UICore.createNewLabel("Enter your name : ", 20, "l0");

        label3 = UICore.createNewLabel("Choose your username : ", 20, "l1");

        label4 = UICore.createNewLabel("Choose your password : ", 20, "l2");

        label5 = UICore.createNewLabel("Your sex : ", 20, "l3");

        nmfld = UICore.createNewTextField(20);

        pwdfld = UICore.createNewTextField(20);

        sexbox = UICore.createNewCom(20);
        sexbox.addItem("Male");
        sexbox.addItem("Female");
        sexbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {

                sex = (String) sexbox.getSelectedItem();

            }
        });

        statare = UICore.createNewTextArea(20);

        textarea1 = UICore.createNewTextArea(22);
        textarea1.setText("Looks like you've grown quite interest in paying "
                + "them back. No problem, we are here to fulfill "
                + "your prerequisites. Give us a couple of minutes to "
                + "have the formalities completed. Moreover, we'll "
                + "remember you next time you login. Just choose "
                + "Habituated Handler from then on and you'll get "
                + "your school untouched.");

        usrnmfld = UICore.createNewTextField(20);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(textarea1)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(label2)
                        .addComponent(nmfld))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(label3)
                        .addComponent(usrnmfld))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(label4)
                        .addComponent(pwdfld))
                .addGroup(gl.createSequentialGroup()
                        .addComponent(label5)
                        .addComponent(sexbox))
                .addComponent(statare)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(button1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2)));

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(textarea1)
                .addGroup(gl.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(nmfld))
                .addGroup(gl.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(usrnmfld))
                .addGroup(gl.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(pwdfld))
                .addGroup(gl.createParallelGroup()
                        .addComponent(label5)
                        .addComponent(sexbox))
                .addComponent(statare)
                .addGroup(gl.createParallelGroup()
                        .addComponent(button1)
                        .addComponent(button2)));

        gl.linkSize(1, nmfld, usrnmfld, pwdfld, label2);
        gl.linkSize(1, sexbox, label5);

        //adding panel to JFrame and seting of window position and close operation
        mf.getContentPane().add(contentPane, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        try {
            windowManager.setWindow(contentPane);
        } catch (NullPointerException h) {
            System.out.println(h);
        }

        setdata();
    }

    //Method actionPerformed for button1
    private void bk(ActionEvent evt) {
        dataStore.setUser("");
        dataStore.setName("");
        dataStore.setSex("");
        dataStore.setPass("");
        dataStore.setSchools(new String[0]);
        dataStore.setSchool("");
        windowManager.delWindow();
        new testWindow(mf1);
    }

    private void setdata() {
        String s1 = dataStore.getName();
        if (s1 != null) {
            nmfld.setText(s1);
            usrnmfld.setText(dataStore.getUserName());
            pwdfld.setText(dataStore.getPass());
            sexbox.setSelectedItem(dataStore.getSex());
        }
    }

    //Method actionPerformed for button2
    private void cntnu(ActionEvent evt) {
        //TODO
        String name = nmfld.getText();
        String usrname = usrnmfld.getText();
        String pwd = pwdfld.getText();
        boolean er1 = (name.equals(""));
        boolean er2 = (usrname.equals(""));
        boolean er3 = premitiveData.hasUser(usrname);
        boolean er4 = (pwd.length() < 6);
        if (er1) {
            statare.setText(ter1);
        } else if (er2) {
            statare.setText(ter2);
        } else if (er3) {
            statare.setText(ter3);
        } else if (er4) {
            statare.setText(ter4);
        } else {
            statare.setText("You are a perfect performer.");
            dataStore.setName(name);
            dataStore.setUser(usrname);
            dataStore.setPass(pwd);
            dataStore.setSex(sex);
            windowManager.delWindow();
            new testName(mf1);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new testUser(mf1);
            }
        });
    }

}
