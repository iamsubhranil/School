import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
class Mouth{
    int x;
    int y;
    Graphics2D g;
    int r;
    Color c;
    JPanel cp;
    public Mouth(Graphics2D gg,int xx,int yy,int rr,Color cc,JPanel cp2){
        g = gg;
        x = xx;
        y = yy;
        c = cc;
        r = rr;
        cp = cp2;
    }
    
    public void drawMouth(){
        int lmx = x+(3*r/8);
        int lmy = y+(6*r/8);
        
        int mmx = x+(r/2);
        int mmy = y+(9*r/10);
        
        int rmx = lmx+(r/4);
        int rmy = lmy;
        
        g.setColor(c);
        QuadCurve2D d = new QuadCurve2D.Float(lmx,lmy,mmx,mmy,rmx,rmy);
        g.draw(d);
        g.drawLine(lmx,lmy,rmx,rmy);
    }
}