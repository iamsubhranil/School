package com.apsm.school.visual;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import com.apsm.school.testgui.UICore;

/**
 *
 * @author Subhra
 */
public class visualData{
    static Color bcclr = Color.WHITE;
    static Color hdclr = Color.BLACK;
    static Color txtclr = hdclr;
    static Color infcclr = hdclr;
    static Color inbcclr = bcclr;
    static Color btbcclr = bcclr;
    static Color btfcclr = hdclr;
    static boolean trans = true;
    static boolean spt = true;
    static String fnm;
    static Color [] df = {bcclr,hdclr,txtclr,infcclr,inbcclr,btbcclr,btfcclr};
    static String schnm = "Default";
    static String font = "Seoge UI Light";
    static Scheme sh = new Scheme(schnm,df,trans,font);
    static Scheme [] shs = new Scheme[0];

    /**
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @param g
     * @param t
     * @param fn
     */
    public static void setColors(Color a,Color b,Color c,Color d,Color e,Color f,Color g,boolean t,String fn){
        bcclr = a;
        hdclr = b;
        txtclr = c;
        infcclr = d;
        inbcclr = e;
        btfcclr = f;
        btbcclr = g;
        trans = t;
        font = fn;
        Color [] cols = {a,b,c,d,e,f,g};
        sh = new Scheme("name",cols,t,font);
        UICore.setFont(font);
    }
    
    /**
     *
     * @param s
     */
    public static void addScheme(Scheme s){
        Scheme [] tmp = new Scheme[shs.length+1];
        for(int i = 0;i<shs.length;i++){
            tmp[i] = shs[i];
        }
        tmp[shs.length] = s;
        shs = tmp;
    }
    
    /**
     *
     * @param s
     */
    public static void loadAllSchemes(Scheme [] s){
        shs = s;
    }
    
    /**
     *
     * @return
     */
    public static Scheme [] getAllSchemes(){
        return shs;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static Scheme addNewScheme(Scheme s){
        for(int i = 0;i<shs.length;i++){
            if(shs[i].equals(s)){
                return shs[i];
            }
        }
        addScheme(s);
        return s;
    }
    
    /**
     *
     * @param s
     */
    public static void setCurrentScheme(Scheme s){
        sh = s;
        Color [] cl = sh.getColors();
        boolean tr = sh.getTransition();
        schnm = s.getName();
        font = s.getFont();
        setColors(cl[0],cl[1],cl[2],cl[3],cl[4],cl[5],cl[6],tr,font);
    }
    
    /**
     *
     * @return
     */
    public static Scheme getCurrentScheme(){
        return sh;
    }
    
    /**
     *
     * @return
     */
    public static boolean getTransitionState(){
        return trans;
    }

    /**
     *
     */
    public static void disableSpecialTransitions(){
        spt=false;
    }

    /**
     *
     * @return
     */
    public static Color[] getColors(){
        Color [] colors = {bcclr,hdclr,txtclr,infcclr,inbcclr,btfcclr,btbcclr};
        return colors; 
    }

    /**
     *
     * @param cp
     */
    public static void updateContentPane(JPanel cp){
        Object [] ob = cp.getComponents();
        cp.setBackground(bcclr);
        for(int i = 0;i<ob.length;i++){
            if(ob[i].getClass()==JButton.class){
                JButton jb = (JButton)ob[i];
                jb.setForeground(btfcclr);
                jb.setBackground(btbcclr);
            }
            else if(ob[i].getClass()==JTextArea.class){
                JTextArea ja = (JTextArea)ob[i];
                ja.setBackground(bcclr);
                ja.setForeground(hdclr);
            }
            else if(ob[i].getClass()==JTextField.class){
                JTextField jt = (JTextField)ob[i];
                Border bd = BorderFactory.createLineBorder(inbcclr);
                
                jt.setBackground(inbcclr);
                jt.setForeground(infcclr);
                jt.setBorder(bd);
            }
            else if(ob[i].getClass()==JPasswordField.class){
                JPasswordField jt = (JPasswordField)ob[i];
                Border bd = BorderFactory.createLineBorder(inbcclr);
                
                jt.setBackground(inbcclr);
                jt.setForeground(infcclr);
                jt.setBorder(bd);
            }
            else if(ob[i].getClass()==JLabel.class){
                JLabel jl = (JLabel)ob[i];
                jl.setForeground(txtclr);
                jl.setBackground(bcclr);
            }
            else if(ob[i].getClass()==JComboBox.class){
                JComboBox jc = (JComboBox)ob[i];
                jc.setBackground(inbcclr);
                jc.setForeground(infcclr);
            }
            else if(ob[i].getClass()==JCheckBox.class){
                JCheckBox jc = (JCheckBox)ob[i];
                jc.setBackground(bcclr);
                jc.setForeground(txtclr);
            }
        }
        if(trans && spt){
            Animate a1 = new Animate();
            a1.setElements(cp,3);
            a1.start();
        }
        else{
            spt = true;
        }
        
    }
    
    /**
     *
     */
    public static void saveForUse(){
        visualStore.saveCurrentScheme();
    }
    
    /**
     *
     * @return
     */
    public static String getFileName(){
        return schnm;
    }
}