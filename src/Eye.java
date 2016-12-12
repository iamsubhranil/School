import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
class Eye{
    Graphics2D gd;
    int x1;
    int y1;
    int r;
    int i;
    int rex;
    int rey;
    int lex;
    int ley;
    int er;
    Color c;
    JPanel cp;
    boolean alreadyBlinking = false;
    public Eye(Graphics2D g,int x,int y,int r2,Color cr,JPanel cp2){
        gd = g;
        x1 = x;
        y1 = y;
        r = r2;
        c = cr;
        cp = cp2;
        rex = x1+(r/4);
        rey = y1+(r/4);
        er = r/10;
        lex = rex+(r/2)-er;
        ley = rey;
    }

    public void drawEyes(){
        gd.setColor(c);
        gd.drawOval(rex,rey,er,er);
        gd.fillOval(rex,rey,er,er);
        gd.drawOval(lex,ley,er,er);
        gd.fillOval(lex,ley,er,er);
    }

    public void blink(Graphics2D gg){
        gd = gg;
        b b2 = new b();
        b2.start();
    }

    public void blinkStat(){

        cp.repaint();
        gd.setColor(c);
        QuadCurve2D oel = new QuadCurve2D.Float(rex,rey+i,rex+(er/2),rey+er,rex+er,rey+i);
        gd.draw(oel);
        gd.fill(oel);
        QuadCurve2D oer = new QuadCurve2D.Float(lex,ley+i,lex+(er/2),ley+er,lex+er,rey+i);
        gd.draw(oer);
        gd.fill(oer);
        
        cp.repaint();
        System.out.println("Blinking...");
    }
    
    public boolean isBlinking(){
        return alreadyBlinking;
    }

    class b extends Thread{
        public void run(){
            while(i<21){
                alreadyBlinking = true;
                i++;
                try{
                    Thread.sleep(100);
                    blinkStat();
                }
                catch(Exception j){}
            }
            drawEyes();
            alreadyBlinking = false;
        }
    }
}