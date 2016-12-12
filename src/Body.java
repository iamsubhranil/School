import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Body{
    int x;
    int y;
    int r;
    Color c;
    JPanel cp;
    Graphics2D g;

    public Body(Graphics2D gg,int xx,int yy,int rr,Color cr,JPanel cp2){
        g = gg;
        x = xx;
        y = yy;
        r = rr;
        c = cr;
        cp = cp2;
    }

    public void drawBody(){
        int lex1 = x;
        int ley1 = y+r;
        
        int lex2 = lex1;
        int ley2 = y+(2*r);
        
        int rex2 = lex1+r;
        int rey2 = ley2;
        
        int rex1 = lex1+r;
        int rey1 = ley1;
        
        g.setColor(c);
        g.drawLine(lex1,ley1+(r/5),lex2,ley2);
        g.drawLine(lex2,ley2,rex2,rey2);
        g.drawLine(rex2,rey2,rex1,rey1+(r/5));
        g.drawLine(rex1,rey1,lex1,ley1);
    }
    
}