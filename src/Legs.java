import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Legs{
    int x;
    int y;
    int r;
    Color c;
    JPanel cp;
    Graphics2D g;

    public Legs(Graphics2D gg,int xx,int yy,int rr,Color cr,JPanel cp2){
        g = gg;
        x = xx;
        y = yy;
        r = rr;
        c = cr;
        cp = cp2;
    }
    
    public void drawLegs(){
        int lx1 = x;
        int ly1 = y+(2*r);
        
        int lx2 = lx1;
        int ly2 = ly1+(r);
        
        int ler = (r/10);
        
        int lx3 = lx2+ler;
        int ly3 = ly2;
        
        int lx4 = lx3;
        int ly4 = ly1-(r/10);
        
        int mlx1 = lx4+(r/10);
        int mly1 = ly4;
         
        int rx3 = mlx1;
        int ry3 = ly4+(r/10);;
        
        int rx2 = rx3+(r/10);
        int ry2 = ly2;
        
        int rx1 = rx2;
        int ry1 = ry2-(r*2);
        
        g.drawLine(lx1,ly1,lx2,ly2);
        g.drawLine(lx2,ly2,lx3,ly3);
        g.drawLine(lx3,ly3,mlx1,mly1);
        g.drawLine(mlx1,mly1,rx3,ry3);
        g.drawLine(rx3,ry3,rx2,ry2);
        g.drawLine(rx2,ry2,rx1,ry1);
    }
}