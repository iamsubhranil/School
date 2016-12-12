package com.apsm.school.visual;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 *
 * @author Subhra
 */
public class Animate extends Thread{
    int sec;
    int p1;
    int p2;
    int cnt = 0;
    int cw = 0;
    Thread th;
    boolean st = false;
    JPanel cp2;

    public synchronized void run(){
        Dimension d = cp2.getSize();
        p1 = (int)d.getHeight();
        p2 = (int)d.getWidth();
        Object [] ob = cp2.getComponents();
        LayoutManager l1 = cp2.getLayout();
        cp2.setLayout(null);
        cp2.removeAll();
        cp2.repaint();
        cw = ob.length;
        for(int i = 0;i<ob.length;i++){
            boolean skip = false;
            if(ob[i].getClass()==JButton.class){
                JButton jb = (JButton)ob[i];
                cp2.add(jb);
                decideButtonAni(jb);
            }
            else if(ob[i].getClass()==JTextArea.class){
                JTextArea ja = (JTextArea)ob[i];
                cp2.add(ja);
                animateTA at = new animateTA();
                at.setTA(ja);
                at.start();
            }
            else if(ob[i].getClass()==JTextField.class){
                JTextField jt = (JTextField)ob[i];
                cp2.add(jt);
                animateTX atx = new animateTX();
                atx.setJT(jt);
                atx.start();
            }
            else if(ob[i].getClass()==JLabel.class){
                JLabel jl = (JLabel)ob[i];
                cp2.add(jl);
                animateL al = new animateL();
                al.setJL(jl);
                al.start();
            }
            else if(ob[i].getClass()==JComboBox.class){
                JComboBox jc = (JComboBox)ob[i];
                cp2.add(jc);
                animateJC ajc = new animateJC();
                ajc.setJC(jc);
                ajc.start();
            }
            else {
                skip = true;
                cp2.add((JComponent)ob[i]);
                not();
                noti();
            }
            try{
                if(!skip){
                    wait();
                    Thread.sleep(100);}
            }
            catch(Exception h){}
        }
        if(cnt<ob.length){
            try{
                wait();
            }
            catch(Exception h){}
        }
        cp2.setLayout(l1);
        cp2.repaint();
    }

    /**
     *
     * @param cp
     * @param t
     */
    public void setElements(JPanel cp,int t){
        cp2 = cp;
        sec = t;
    }

    /**
     *
     * @param j
     */
    public void decideButtonAni(JButton j){
        Point loc = j.getLocation();
        int distanceFromRight = p2-(int)loc.getX();
        int distanceFromLeft = (int)loc.getX();
        if(distanceFromRight>distanceFromLeft){
            animateBHL abv = new animateBHL();
            abv.setB(j);
            abv.start();
        }
        else if(distanceFromLeft==distanceFromRight){
            Random r = new Random();
            int c = r.nextInt(2);
            if(c==0){
                animateBHL abv = new animateBHL();
                abv.setB(j);
                abv.start();
            }
            else{
                animateBHR abv = new animateBHR();
                abv.setB(j);
                abv.start();
            }
        }
        else{
            animateBHR abv = new animateBHR();
            abv.setB(j);
            abv.start();
        }
    }

    /**
     *
     */
    public synchronized void not(){
        notify();
    }

    class animateJCM extends Thread{
        JCheckBox jt;

        public void setJC(JCheckBox j){
            jt = j;
        }

        public void run(){
            Dimension sz = jt.getSize();
            int w = (int)sz.getWidth();
            for(int h = 0;h<w;h++){
                jt.setSize(h,(int)sz.getHeight());
                try{
                    Thread.sleep((sec*1000)/(int)sz.getWidth());
                }
                catch(Exception hh){}
            }
            not();
            noti();
        }
    }

    class animateJC extends Thread{
        JComboBox jt;

        public void setJC(JComboBox j){
            jt = j;
        }

        public void run(){
            Dimension sz = jt.getSize();
            int w = (int)sz.getWidth();
            for(int h = 0;h<w;h++){
                jt.setSize(h,(int)sz.getHeight());
                try{
                    Thread.sleep((sec*1000)/(int)sz.getWidth());
                }
                catch(Exception hh){}
            }
            not();
            noti();
        }
    }

    class animateL extends Thread{
        JLabel jl;
        Dimension old;
        public void setJL(JLabel l){
            jl = l;
            old = jl.getSize();
            jl.setSize((int)old.getWidth()+10,(int)old.getHeight());
        }

        public void run(){
            String text = jl.getText();
            jl.setText("");
            for(int i = 0;i<(text.length());i++){
                String tx = jl.getText().replace("|","");
                jl.setText(tx+text.charAt(i)+"|");
                try{
                    Thread.sleep(83);
                }
                catch(Exception h){}
            }
            cursor();
            jl.setText(jl.getText().replace("|",""));
            jl.setSize(old);
            not();
            noti();
        }

        public void cursor(){
            String txtwith = jl.getText();
            String txtwithout = jl.getText().replace("|","");
            for(int o = 0;o<3;o++){
                try{
                    Thread.sleep(400);
                }
                catch(Exception h){}
                if(o==0){
                    jl.setText(txtwithout);
                }
                else if(o==1){
                    jl.setText(txtwith);
                }
                else{
                    jl.setText(txtwithout);
                }
            }
        }
    }

    class animateTX extends Thread{
        JTextField jt;

        public void setJT(JTextField j){
            jt = j;
        }

        public void run(){
            Dimension sz = jt.getSize();
            int w = (int)sz.getWidth();
            for(int h = 0;h<w;h++){
                jt.setSize(h,(int)sz.getHeight());
                try{
                    Thread.sleep((sec*1000)/(int)sz.getWidth());
                }
                catch(Exception hh){}
            }
            not();
            noti();
        }
    }

    private synchronized void noti(){
        try{
            cnt++;
            if(cnt==cw){
                notify();
            }}
        catch(Exception j){
            System.out.println(j);
        }
    }

    class animateBHR extends Thread{
        JButton jb;
        public void setB(JButton j){
            jb = j;
        }

        public void run(){
            Point p = jb.getLocation();
            Color cf = jb.getForeground();
            Color cb = jb.getBackground();
            Color w = new Color(255,255,255);
            int a = (int)p.getX();
            int b = 0;
            int ty = 0;
            int y = 0;
            for(y = 0;y<a+1;y++){
                Point p1 = new Point(y,(int)p.getY());
                int h2 = a;
                long prcn = (y*100/p2);
                long stan = ((sec*1000)/p2);
                long slp = stan*prcn/100;
                jb.setLocation(p1);
                try{
                    Thread.sleep(slp);
                }
                catch(Exception h){}
            }
            not();
            noti();
        }
    }

    class animateBHL extends Thread{
        JButton jb;
        public void setB(JButton j){
            jb = j;
        }

        public void run(){
            Point p = jb.getLocation();
            Color cf = jb.getForeground();
            Color cb = jb.getBackground();
            Color w = new Color(255,255,255);
            int a = (int)p.getX();
            int b = 0;
            int ty = 0;
            int y = 0;
            for(y = p2;y>a-1;y--){
                Point p1 = new Point(y,(int)p.getY());
                jb.setLocation(p1);

                long prcn = 100-(y*100/p2);
                long stan = ((sec*1000)/p2);
                long slp = stan*prcn/100;
                try{
                    Thread.sleep(slp);
                }
                catch(Exception h){}
            }
            not();
            noti();
        }
    }

    class animateBV extends Thread{
        JButton jb;
        public void setB(JButton j){
            jb = j;
        }

        public void run(){
            Point p = jb.getLocation();
            Color cf = jb.getForeground();
            Color cb = jb.getBackground();
            Color w = new Color(255,255,255);
            int a = (int)p.getY();
            int b = 0;
            int ty = 0;
            int y = 0;
            for(y = 0;y<a;y++){
                Point p1 = new Point((int)p.getX(),y);
                int h2 = a;

                jb.setLocation(p1);
                try{
                    Thread.sleep((sec*1000)/h2);
                }
                catch(Exception h){}
            }
            not();
            noti();
        }
    }

    class animateTA extends Thread{
        JTextArea jb;
        public void setTA(JTextArea j){
            jb = j;
        }

        public synchronized void run(){
            String text = jb.getText();
            jb.setText("");
            for(int i = 0;i<text.length();i++){
                String txt = jb.getText().replace("|","");
                long tm = 76;
                jb.setText(txt+text.charAt(i)+"|");
                if((text.charAt(i)+"").equals(".")){
                    cursor();
                }
                try{
                    Thread.sleep(tm);
                }
                catch(Exception h){}
            }
            not();
            noti();
        }

        public synchronized void cursor(){
            String txtwith = jb.getText();
            String txtwithout = jb.getText().replace("|","");
            for(int o = 0;o<3;o++){
                try{
                    Thread.sleep(400);
                }
                catch(Exception h){}
                if(o==0){
                    jb.setText(txtwithout);
                }
                else if(o==1){
                    jb.setText(txtwith);
                }
                else{
                    jb.setText(txtwithout);
                }
            }
        }
    }
}