import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import com.apsm.school.visual.*;
class starter extends JFrame{
    Graphics2D mg;
    int i = 0;
    Eye e;
    Nose n;
    Mouth m;
    Body b;
    Legs l;
    int x1;
    int y1;
    int r;
    Color cr = Color.BLACK;
    customPanel cp;
    boolean initialised = false;
    public starter(){
        setTitle("Intro");
        setSize(550,500);
        setLocation(600,100);
        x1 = 50;
        y1 = 40;
        r = 100;
        cp = new customPanel();
        cp.setPreferredSize(new Dimension(500,400));
        cp.setBackground(Color.WHITE);
        cp.repaint();
        add(cp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }

    class customPanel extends JPanel{
        public customPanel() {

            setBorder(BorderFactory.createLineBorder(Color.black));

            addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        x1 = e.getX();
                        y1 = e.getY();
                        repaint();
                    }
                });

            addMouseMotionListener(new MouseAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        x1 = e.getX();
                        y1 = e.getY();
                        repaint();
                    }
                });

        }

        public synchronized void paintComponent(Graphics g){
            super.paintComponent(g);
            mg = (Graphics2D)g;
            e = new Eye(mg,x1,y1,r,cr,cp);
            n = new Nose(mg,x1,y1,r,cr,cp);
            m = new Mouth(mg,x1,y1,r,cr,cp);
            b = new Body(mg,x1,y1,r,cr,cp);
            l = new Legs(mg,x1,y1,r,cr,cp);

            mg.setColor(cr);
            mg.drawOval(x1+5,y1,r-10,r);
            
            
            e.drawEyes();
            n.drawNose();
            m.drawMouth();
            b.drawBody();
            l.drawLegs();

            notify();
        }
    }

    class move extends Thread{
        public void run(){
            while(x1<500 && y1<400){
                cp.repaint();
                x1++;
                y1++;
                try{
                    cr = Color.BLACK;
                    cp.repaint();
                    Thread.sleep(10);

                }
                catch(Exception j){}
            }
        }
    }

}