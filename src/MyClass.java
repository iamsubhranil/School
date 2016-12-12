import javax.swing.*;
import java.awt.*;
class MyClass extends JFrame{
    JLabel [][] points;
    JPanel cp;
    public MyClass(){
        setTitle("New Window");
        setSize(600,600);
        
        cp = new JPanel(null);
        cp.setBackground(Color.WHITE);
        cp.setPreferredSize(new Dimension(500,400));
        
        add(cp);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        
        points = new JLabel[500][400];
        iniPoints();
    }
    
    public void iniPoints(){
        for(int i = 0;i<500;i=i+5){
            for(int j = 0;j<400;j=j+5){
                points[i][j] = new JLabel();
                points[i][j].setBounds(i,j,60,60);
                points[i][j].setFont(new Font("Segoe UI Light",1,60));
                points[i][j].setText(".");
                points[i][j].setForeground(Color.BLACK);
                points[i][j].setBackground(Color.BLACK);
                points[i][j].setVisible(true);
                points[i][j].setEnabled(true);
                cp.add(points[i][j]);
                cp.repaint();
            }
        }
        
        points[200][100].setForeground(Color.WHITE);
        points[200][105].setForeground(Color.WHITE);
        points[200][110].setForeground(Color.WHITE);
    }
    
}