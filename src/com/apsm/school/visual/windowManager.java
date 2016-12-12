package com.apsm.school.visual;
import com.apsm.school.testgui.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Subhra
 */
public class windowManager{
    static JPanel jp;
    static JPanel cpcp;
    static mainFrame mf;
    static JPanel sp;
    static sysShortcut ss;
    static JPanel sscp;

    /**
     *
     */
    public static void main(){
        mf = new mainFrame();
        //new controlPanel(mf);
        new testBoot(mf,0);
        new sysShortcut(mf);
        //new systemControl(mf);
    }

    /**
     *
     * @param m
     */
    public static void setMainFrame(mainFrame m){
        mf = m;
    }

    /**
     *
     * @param p
     */
    public static void setWindow(JPanel p){
        jp = p;
        mf.pack();
        visualData.updateContentPane(jp);
    }

    /**
     *
     */
    public static void addNew(){
        new testWindow(mf);
        mf.pack();
    }

    /**
     *
     */
    public static void removeSS(){
        mf.remove(sscp);
        mf.pack();
    }
    

    /**
     *
     * @param s
     * @param c
     */
    public static void setSS(sysShortcut s,JPanel c){
        ss = s;
        sscp = c;
    }
    
    /**
     *
     * @return
     */
    public static sysShortcut getSystemShortcut(){
        return ss;
    }
    
    /**
     *
     */
    public static void delCP(){
        mf.remove(cpcp);
        mf.pack();
    }


    /**
     *
     */
    public synchronized static void delWindow(){

        mf.remove(jp);
        mf.pack();
        jp = null;
    }

    /**
     *
     */
    public static void saveWindow(){
        sp = jp;
    }

    /**
     *
     */
    public static void loadSavedWindow(){
        sp.repaint();

        visualData.disableSpecialTransitions();
        //visualData.updateContentPane(cpcp);
        //cp.updateFont();
        mf.getContentPane().add(sp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        visualData.updateContentPane(sp);
        setWindow(sp);
    }

    static class dis extends Thread{
        public void run(){
            Dimension d = jp.getPreferredSize();
            int a = (int)d.getWidth();
            for(a=a;a>0;a--){
                Dimension d2 = new Dimension(a,(int)d.getHeight());
                jp.setPreferredSize(d2);
                try{
                    Thread.sleep(5);
                }
                catch(Exception h){}
            }
        }
    }
}