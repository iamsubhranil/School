package com.apsm.school.testgui;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import java.io.*;

/**
 *
 * @author Subhra
 */
public class testBoot{
    JLabel label1;
    JLabel [] txt;
    JLabel [] dt;
    mainFrame mf1;
    SequentialGroup sg1;
    ParallelGroup pg1;
    boolean comp = false;
    ani a1;
    JPanel contentPane;
    JTextArea jt;
    GroupLayout gl;
    int stt = 0;
    //Constructor 

    /**
     *
     * @param mf
     * @param s
     */
        public testBoot(mainFrame mf,int s){
        stt = s;
        mf1 = mf;
        //pane with null layout
        contentPane = new JPanel(null);
        contentPane.setBackground(new Color(255,255,255));

        gl = new GroupLayout(contentPane);
        contentPane.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        label1 = UICore.createNewLabel("Verifying database",22,"l0");

        //mainlbl = UICore.createNewLabel("",22,"l1");

        //sublb1 = UICore.createNewLabel("",22,"l2");

        //sublb2 = UICore.createNewLabel("",22,"l3");

        //sublb3 = UICore.createNewLabel("",22,"l4");

        sg1 = gl.createSequentialGroup();

        pg1 = gl.createParallelGroup();

        iniL();

        jt = UICore.createNewTextArea(25);

        String user = System.getProperty("user.name");
        String os = System.getProperty("os.name");
        String osbit = System.getProperty("sun.arch.data.model");
        String arch = System.getProperty("os.arch");
        String jnm = System.getProperty("java.runtime.name");
        String jver = System.getProperty("java.version");
        String idir = System.getProperty("java.home");
        String ven = System.getProperty("java.vendor");
        String over = System.getProperty("os.version");
        String vmnm = System.getProperty("java.vm.name");
        String vmver = System.getProperty("java.vm.version");
        String vmven = System.getProperty("java.vm.vendor");
        String vminfo = System.getProperty("java.vm.info");
        String jcom = System.getProperty("sun.management.compiler");
        String asdir = System.getProperty("user.dir");
        String clsver = System.getProperty("java.class.version");
        String tzone = System.getProperty("user.timezone");

        String dis = user+", you're using a "+os+" "+osbit+" bit pc with "+arch+" based processor architecture. You have "+ven+"'s "
            +jnm+" "+jver+" installed in "+idir+". Asterisk is running on "+vmven+"'s "+vminfo+" "
            +vmnm+" "+vmver+". "+jcom+" is being used to compile Asterisk's version "+clsver
            +" class files."
            +" Asterisk is running from "+asdir+". Your current time zone is set to "+tzone+"."
            +"\nHappy schooling. :)";

        jt.setText(dis);

        //gl.setHorizontalGroup(gl.createParallelGroup()

        //.addComponent(mainlbl)
        //.addComponent(label1)
        //.addComponent(sublb1)
        //.addComponent(sublb2)
        //.addComponent(sublb3));

        //gl.linkSize(0,mainlbl,label1,sublb1,sublb2,sublb3);
        //gl.setVerticalGroup(gl.createSequentialGroup()
        //.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        //.addComponent(label1))
        //.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        //.addComponent(mainlbl))
        //.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        //.addComponent(sublb1))
        //.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        //.addComponent(sublb2))
        //.addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
        //.addComponent(sublb3)));

        gl.setHorizontalGroup(
            gl.createParallelGroup()
            .addGroup(sg1)
            .addComponent(jt)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(pg1)
            .addComponent(jt));

        visualData.disableSpecialTransitions();
        windowManager.setWindow(contentPane);
        //adding panel to JFrame and seting of window position and close operation
        mf.getContentPane().add(contentPane,"Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        stater t = new stater();
        t.start();

        a1 = new ani();
        a1.start();
    }

    /**
     *
     */
    public void iniL(){
        String f1 = "I";
        if(stt==1){
            f1 = "Rei";
        }
        String text = f1+"nitialising Asterisk";
        JLabel [] lts = new JLabel[text.length()];
        for(int i = 0;i<text.length();i++){
            lts[i] = UICore.createNewLabel(text.charAt(i)+"",45,"l"+i);
            sg1.addComponent(lts[i]);
            pg1.addComponent(lts[i]);
        }
        JLabel [] dts = new JLabel[4];
        for(int j = 0;j<4;j++){
            dts[j] = UICore.createNewLabel(".",45,"l"+(j+17));
            sg1.addComponent(dts[j]);
            pg1.addComponent(dts[j]);
        }
        txt = lts;
        dt = dts;
    }

    /**
     *
     */
    public void updateFont(){
        Object [] o = contentPane.getComponents();
        for(int i = 0;i<o.length;i++){
            try{
                JComponent jc = (JComponent)o[i];
                Font f2 = jc.getFont();
                Font f3 = new Font(UICore.getFontName(),f2.getStyle(),f2.getSize());
                jc.setFont(f3);
            }
            catch(Exception gg){
                System.out.println(gg.getMessage());
            }
        }
    }

    class stater extends Thread{
        public void run(){
            try{
                System.out.flush();
                loadBasement();
                updateFont();
                contentPane.revalidate();
                contentPane.setLayout(null);
                contentPane.setLayout(gl);

                visualData.disableSpecialTransitions();
                windowManager.setWindow(contentPane);
                mf1.pack();
                mf1.setLocationRelativeTo(null);
                //iniL();
                visualData.disableSpecialTransitions();
                visualData.updateContentPane(contentPane);
                //windowManager.getCP().updateAll();
                windowManager.getSystemShortcut().updateAll();
            }
            catch(Exception j){}
            //checkDat();
            try{
                //label1.setText("");
                //mainlbl.setText("");
                //sublb1.setText("");
                //sublb2.setText(" ");
                //sublb3.setFont(new Font("Segoe UI Light",0,40));
                //sublb3.setText("         Starting program");
                Thread.sleep(5000);
                a1.stop();
                windowManager.delWindow();
                new testWindow(mf1);
                //new systemControl(mf1);
            }
            catch(Exception hh){
                hh.printStackTrace();
            }
        }
    }

    class ani extends Thread{
        public void run(){

            for(int i = 0;i<txt.length;i++){
                Font f = txt[i].getFont();
                txt[i].setFont(new Font("Segoe UI Light",0,25));
                try{
                    Thread.sleep(100);
                    txt[i].setFont(f);
                }
                catch(Exception j){}
            }
            int cnt = 0;
            while(comp==false || cnt==0){
                for(int j = 0;j<dt.length;j++){
                    Font f = dt[j].getFont();
                    dt[j].setFont(new Font("Segoe UI Light",0,25));
                    try{
                        Thread.sleep(120);
                        dt[j].setFont(f);
                    }
                    catch(Exception p){}
                }
                cnt++;
            }
        }

    }

    /**
     *
     * @throws IOException
     */
    public void loadBasement() throws IOException{
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Database\\basement.ser"));
        try{
            Basement a1= (Basement)oos.readObject();
            oos.close();
            a1.applyData();
        }
        catch(Exception h){
            oos.close();
            //new File("Database\\basement.ser").delete();
        }
        comp = true;
    }

    /**
     *
     */
    public void checkDat(){
        databaseValidator dv = new databaseValidator();
        dv.checkUsersAndLoad();
        comp = true;
    }

}