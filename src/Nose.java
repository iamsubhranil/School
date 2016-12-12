import java.awt.*;
import javax.swing.*;
class Nose{

    int x;
    int y;
    Graphics2D g;
    int r;
    Color c;
    JPanel cp;
    public Nose(Graphics2D gg,int xx,int yy,int rr,Color cr,JPanel cp2){
        g = gg;
        x = xx;
        y = yy;
        r = rr;
        c = cr;
        cp = cp2;
    }
    
    public void drawNose(){
        int y1 = y+(7*r/16);
        int x1 = x+(r/2);
        
        int x2 = x+(3*r/8);
        int y2 = y+(5*r/8);
        
        int x3 = x+(5*r/8);
        int y3 = y2;
        
        g.setColor(c);
        
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x3,y3);
        g.drawLine(x3,y3,x1,y1);
    }
}