package com.apsm.school.testgui;

import java.io.*;
import com.apsm.school.core.*;
import com.apsm.school.visual.*;
import javax.swing.*;
import javax.swing.GroupLayout.*;
import java.util.*;
class doEndJob{

    SequentialGroup sg1;
    ParallelGroup pg1;
    JLabel [] lts;
    JLabel [] dts;
    String [] letters = {"A","B","C","D","E","F","G",
            "I","J","K","L","M","N","O",
            "P","Q","R","S","T","U","V",
            "W","X","Y","Z","a","b","c","d","e","f","g","h","i","j"
        ,"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","."};
    aJob [] aj;
    boolean [] isc;
    boolean cmp = false;
    int st = 0;
    mainFrame mf;
    public doEndJob(mainFrame mf,int s){
        this.mf = mf;
        JPanel cp = new JPanel(null);
        st = s;
        GroupLayout gp = new GroupLayout(cp);
        cp.setLayout(gp);
        gp.setAutoCreateGaps(true);
        gp.setAutoCreateContainerGaps(true);

        sg1 = gp.createSequentialGroup();

        pg1 = gp.createParallelGroup();

        gp.setHorizontalGroup(
            gp.createParallelGroup()
            .addGroup(sg1)
        );

        gp.setVerticalGroup(gp.createSequentialGroup()
            .addGroup(pg1));

        iniL();

        mf.getContentPane().add(cp, "Center");
        mf.pack();
        mf.setLocationRelativeTo(null);
        visualData.disableSpecialTransitions();
        windowManager.setWindow(cp);

        startAll();
    }

    public void iniL(){
        String ss = "";
        if(st==1){
            ss = "Restarting";
        }
        else{
            ss = "Closing";
        }
        String text = ss+" Asterisk....";
        lts = new JLabel[text.length()];
        aj = new aJob[lts.length];
        isc = new boolean[lts.length+1];
        isc[0] = true;
        for(int i = 0;i<text.length();i++){
            lts[i] = UICore.createNewLabel(text.charAt(i)+"",45,"l"+i);
            sg1.addComponent(lts[i]);
            pg1.addComponent(lts[i]);
            aj[i] = new aJob();
            aj[i].setLabel(lts[i],i+1);
            isc[i+1] = false;
        }
        dts = new JLabel[4];
        for(int j = 0;j<4;j++){
            dts[j] = UICore.createNewLabel(".",45,"l"+(j+17));
            //sg1.addComponent(dts[j]);
            //pg1.addComponent(dts[j]);
        }
    }

    public void startAll(){
        make m = new make();
        m.start();
        for(int h = 0;h<aj.length;h++){
            aj[h].start();
        }
    }

    class make extends Thread{
        public void run(){
            User [] us = premitiveData.getUsers();
            Scheme [] sh = visualData.getAllSchemes();
            Scheme s = visualData.getCurrentScheme();
            Basement bs = new Basement(us,sh,s);
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database\\basement.ser"));

                oos.writeObject(bs);
                oos.close();
            }
            catch(Exception h){
                h.printStackTrace();
            }
            cmp = true;
            if(isc[lts.length]==true){
                try{
                    Thread.sleep(2000);
                    if(st==1){
                        windowManager.delWindow();
                        new testBoot(mf,1);
                    }
                    else{
                        System.exit(0);
                    }
                }
                catch(Exception g){}
            }
        }
    }

    class aJob extends Thread{
        JLabel l;
        int n;
        public void setLabel(JLabel j,int a){
            l = j;
            n = a;
        }

        public synchronized void run(){
            int cnt = 0;
            Random r = new Random();
            int i = 0;
            String ft = l.getText();
            while(!ft.equals(letters[i]) || cnt<10 || isc[n-1]==false){
                i = r.nextInt(letters.length);
                l.setText(letters[i]);
                cnt++;

                try{
                    Thread.sleep(1);
                }
                catch(Exception h){}

            }
            isc[n] = true;
            if(isc[lts.length]==true && cmp==true){
                try{
                    Thread.sleep(2000);
                    if(st==1){
                        windowManager.delWindow();
                        new testBoot(mf,1);
                    }
                    else{
                        System.exit(0);
                    }
                }
                catch(Exception g){}
            }
        }
    }
}