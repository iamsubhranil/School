package com.apsm.school.testgui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Subhra
 */
public class UICore
{
    static String font = "Segoe UI Light";
    
    /**
     *
     * @param f
     */
    public static void setFont(String f){
        font = f;
    }
    
    /**
     *
     * @return
     */
    public static String getFontName(){
        return font;
    }
    
    /**
     *
     * @param text
     * @param fontSize
     * @return
     */
    public static JButton createNewButton(String text, int fontSize)
    {
        JButton jb = new JButton(text);
        jb.setBackground(Color.WHITE);
        jb.setForeground(Color.BLACK);
        jb.setFont(new Font(font,0, 22));
        jb.setEnabled(true);
        jb.setVisible(true);
        return jb;
    }

    /**
     *
     * @param text
     * @param fontSize
     * @param nm
     * @return
     */
    public static JLabel createNewLabel(String text, int fontSize, String nm)
    {
        JLabel mainlbl = new JLabel(nm, 0);
        mainlbl.setText(text);
        mainlbl.setFont(new Font(font,0, fontSize));
        mainlbl.setForeground(Color.BLACK);
        mainlbl.setEnabled(true);
        mainlbl.setVisible(true);
        return mainlbl;
    }

    /**
     *
     * @param fontSize
     * @return
     */
    public static JComboBox createNewCom(int fontSize)
    {

        final JComboBox sexbox = new JComboBox();
        sexbox.setBounds(115, 448, 90, 35);
        sexbox.setBackground(new Color(255, 255, 255));
        sexbox.setForeground(new Color(0, 0, 0));
        sexbox.setEnabled(true);
        sexbox.setFont(new Font(font,0, fontSize));
        sexbox.setVisible(true);
        return sexbox;
    }

    /**
     *
     * @param text
     * @param fontSize
     * @return
     */
    public static JCheckBox createNewCheckBox(String text,int fontSize)
    {
        JCheckBox checkbox1 = new JCheckBox();
        checkbox1.setBackground(Color.WHITE);
        checkbox1.setForeground(Color.BLACK);
        checkbox1.setEnabled(true);
        checkbox1.setFont(new Font(font,0, 22));
        checkbox1.setText(text);
        checkbox1.setVisible(true);
        return checkbox1;
    }

    /**
     *
     * @param fontSize
     * @return
     */
    public static JTextField createNewTextField(int fontSize)
    {
        JTextField nmfld = new JTextField();
        nmfld.setBackground(new Color(255, 255, 255));
        nmfld.setForeground(new Color(0, 0, 0));
        nmfld.setEnabled(true);
        nmfld.setFont(new Font(font,0, fontSize));
        nmfld.setText("");
        nmfld.setVisible(true);
        return nmfld;
    }

    /**
     *
     * @param fontSize
     * @return
     */
    public static JTextArea createNewTextArea(int fontSize)
    {
        JTextArea statare = new JTextArea();
        statare.setBounds(9, 493, 482, 80);
        statare.setBackground(new Color(255, 255, 255));
        statare.setForeground(new Color(0, 0, 0));
        statare.setEnabled(true);
        statare.setFont(new Font(font,0, fontSize));
        statare.setText("");
        statare.setEditable(false);
        statare.setBorder(BorderFactory.createBevelBorder(2));
        statare.setVisible(true);
        statare.setLineWrap(true);
        statare.setWrapStyleWord(true);
        return statare;
    }
}
