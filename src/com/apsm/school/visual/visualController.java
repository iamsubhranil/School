package com.apsm.school.visual;
import com.apsm.school.testgui.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 *
 * @author Subhra
 */
public class visualController{
    Color bc = Color.WHITE;
    Color hdfc = Color.BLACK;
    Color txtfc = Color.BLACK;
    Color btfc = Color.BLACK;
    Color btbc = Color.WHITE;
    Color inbc = Color.WHITE;
    Color infc = Color.BLACK;
    boolean trans;
    JButton prevbtn;
    JButton hdclr;
    JButton fntclr;
    JButton bcclr;
    JButton bttxt;
    JButton btbk;
    JButton intxt;
    JButton inbk;
    JButton okbtn;
    visualController vc;
    JPanel pcp;
    JLabel smpl;
    JLabel albl;
    JTextField jtxt;
    static mainFrame mf2;
    boolean ani = visualData.getTransitionState();

    /**
     *
     * @param mf
     */
    public visualController(mainFrame mf){
        vc = this;
        mf2 = mf;
        JPanel cp = new JPanel(null);
        cp.setBackground(Color.WHITE);

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String [] fnts = ge.getAvailableFontFamilyNames();

        JLabel fslclbl = UICore.createNewLabel("Font : ",22,"l15");
        JComboBox fcb = UICore.createNewCom(22);
        for(int i = 0;i<fnts.length;i++){
            fcb.addItem(fnts[i]);
        }
        fcb.setSelectedItem(UICore.getFontName());
        fcb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    okbtn.setEnabled(true);}
                });
        JLabel mainlbl = UICore.createNewLabel("  Setting up your visuals",30,"l1");
        JLabel namelbl = UICore.createNewLabel("Theme name : ",22,"l11");
        String cor = visualData.getFileName();
        String fnm = cor.replace("visual","Theme ");
        JLabel nmfld = UICore.createNewLabel(fnm.replace(".data",""),22,"l12");
        JLabel bclbl = UICore.createNewLabel("Background color : ",22,"l2");
        JLabel hdlbl = UICore.createNewLabel("Heading font color : ",22,"l3");
        JLabel fntlbl = UICore.createNewLabel("Window text color : ",22,"l10");
        JLabel bttxtlbl = UICore.createNewLabel("Button text color : ",22,"l4");
        JLabel btbclbl = UICore.createNewLabel("Button background color : ",22,"l6");
        JLabel inbclbl = UICore.createNewLabel("Input field background color : ",22,"l8");
        JLabel infclbl = UICore.createNewLabel("Input field text color : ",22,"l9");
        JCheckBox trcb1 = UICore.createNewCheckBox("Enable transitions",22);
        trcb1.setSelected(ani);
        trcb1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(ani){
                        ani = false;
                    }
                    else{
                        ani = true;
                        doAni();
                    }

                    okbtn.setEnabled(true);
                }
            });
        JLabel prevwlbl = UICore.createNewLabel("Preview : ",23,"l5");

        JButton bkbtn = UICore.createNewButton("Back",22);
        bkbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {

                    windowManager.delWindow();
                    windowManager.loadSavedWindow();

                }
            });
        okbtn = UICore.createNewButton("Save",22);
        okbtn.setEnabled(false);
        okbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    UICore.setFont((String)fcb.getSelectedItem());
                    visualData.setColors(bc,hdfc,txtfc,infc,inbc,btfc,btbc,ani,(String)fcb.getSelectedItem());
                    visualData.saveForUse();
                    windowManager.delWindow();
                    windowManager.loadSavedWindow();
                }
            });

        prevbtn = UICore.createNewButton("Button",22);

        iniButtons();

        smpl = UICore.createNewLabel("This is the heading",25,"l7");
        albl = UICore.createNewLabel("Window text : ",22,"l8");

        jtxt = UICore.createNewTextField(22);
        jtxt.setText("Input field text");

        pcp = new JPanel(null);
        pcp.setBackground(bc);

        BorderLayout bl = new BorderLayout();
        pcp.setLayout(bl);
        pcp.add(smpl, BorderLayout.PAGE_START);
        pcp.add(albl, "West");
        pcp.add(jtxt, "Center");
        pcp.add(prevbtn, BorderLayout.PAGE_END);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl.createSequentialGroup()
                .addComponent(mainlbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(fslclbl)
                .addComponent(fcb))
            .addGroup(gl.createSequentialGroup()
                .addComponent(namelbl)
                .addComponent(nmfld)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(bclbl)
                .addComponent(bcclr))
            .addGroup(gl.createSequentialGroup()
                .addComponent(hdlbl)
                .addComponent(hdclr)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(fntlbl)
                .addComponent(fntclr))
            .addGroup(gl.createSequentialGroup()
                .addComponent(infclbl)
                .addComponent(intxt)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(inbclbl)
                .addComponent(inbk))
            .addGroup(gl.createSequentialGroup()
                .addComponent(bttxtlbl)
                .addComponent(bttxt)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(btbclbl)
                .addComponent(btbk))
            .addComponent(trcb1)
            .addComponent(prevwlbl)
            .addComponent(pcp)
            .addGroup(gl.createSequentialGroup()
                .addComponent(bkbtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addComponent(okbtn))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mainlbl)
                .addComponent(fslclbl)
                .addComponent(fcb)
            )
            .addGroup(gl.createParallelGroup()
                .addComponent(namelbl)
                .addComponent(nmfld)
                .addComponent(bclbl)
                .addComponent(bcclr))
            .addGroup(gl.createParallelGroup()
                .addComponent(hdlbl)
                .addComponent(hdclr)
                .addComponent(fntlbl)
                .addComponent(fntclr))
            .addGroup(gl.createParallelGroup()
                .addComponent(infclbl)
                .addComponent(intxt)
                .addComponent(inbclbl)
                .addComponent(inbk))
            .addGroup(gl.createParallelGroup()
                .addComponent(bttxtlbl)
                .addComponent(bttxt)
                .addComponent(btbclbl)
                .addComponent(btbk))
            .addComponent(trcb1)
            .addComponent(prevwlbl)
            .addComponent(pcp)
            .addGroup(gl.createParallelGroup()
                .addComponent(bkbtn)
                .addComponent(okbtn))
        );

        gl.linkSize(1,bttxt,btbk,hdclr,bcclr);
        gl.linkSize(0,hdlbl,infclbl,bttxtlbl,bclbl);
        mf.getContentPane().add(cp,"Center");

        mf.pack();

        mf.setLocationRelativeTo(null);
        windowManager.setWindow(cp);
        col();
        
    }

    /**
     *
     */
    public void col(){
        Color [] colors = visualData.getColors();
        updateAll(colors[1],1);
        updateAll(colors[0],2);
        updateAll(colors[5],3);
        updateAll(colors[6],4);
        updateAll(colors[2],5);
        updateAll(colors[3],7);
        updateAll(colors[4],6);
    }

    /**
     *
     */
    public void iniButtons(){
        fntclr = UICore.createNewButton("   ",10);
        fntclr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,5);

                }
            });

        hdclr = UICore.createNewButton("   ",10);
        hdclr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,1);

                }
            });

        Border bd = BorderFactory.createLineBorder(Color.WHITE);
        bcclr = UICore.createNewButton("         ",10);
        bcclr.setBorder(bd);
        bcclr.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,2);
                }
            });

        bttxt = UICore.createNewButton("   ",10);
        bttxt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,3);
                }
            });

        btbk = UICore.createNewButton("   ",10);
        btbk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,4);
                }
            });

        inbk = UICore.createNewButton("   ",10);
        inbk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,6);

                }
            });

        intxt = UICore.createNewButton("   ",10);
        intxt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ColorChooser cc = new ColorChooser();
                    cc.main();
                    cc.setElements(vc,7);
                    okbtn.setEnabled(true);
                }
            });
    }

    /**
     *
     * @param b
     */
    public void enableSave(boolean b){
        okbtn.setEnabled(b);
    }

    /**
     *
     */
    public void doAni(){
        if(ani){
            Animate a = new Animate();
            a.setElements(pcp,3);
            a.start();
        }
    }

    /**
     *
     * @param c
     * @param type
     */
    public void updateAll(Color c,int type){
        if(type==1){
            hdfc = c;
            hdclr.setBackground(hdfc);
            smpl.setForeground(hdfc);
        }
        else if(type==2){
            bc = c;
            pcp.setBackground(bc);
            bcclr.setBackground(bc);
        }
        else if(type==3){
            btfc = c;
            bttxt.setBackground(btfc);
            prevbtn.setForeground(btfc);
        }
        else if(type==4){
            btbc = c;
            btbk.setBackground(btbc);
            prevbtn.setBackground(btbc);
        }
        else if(type==5){
            txtfc = c;
            albl.setForeground(txtfc);
            fntclr.setBackground(txtfc);
        }
        else if(type==6){
            inbc = c;
            inbk.setBackground(inbc);
            jtxt.setBackground(inbc);
            Border bd = BorderFactory.createLineBorder(inbc);
            jtxt.setBorder(bd);
        }
        else if(type==7){
            infc = c;
            intxt.setBackground(infc);
            jtxt.setForeground(infc);
        }
    }

    /**
     *
     */
    public static void show(){
        if(mf2==null){
            mf2 = new mainFrame();
            windowManager.setMainFrame(mf2);
        }
        new visualController(mf2);
    }

    /**
     *
     * @param text
     * @param fontSize
     * @return
     */
    public JColorChooser createNewColorChooser(String text,int fontSize){
        final JColorChooser tcc = new JColorChooser(Color.BLACK);
        tcc.getSelectionModel().addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e) {
                    Color newColor = tcc.getColor();
                }
            });
        tcc.setBorder(BorderFactory.createTitledBorder(
                text));

        tcc.setFont(new Font("Segoe UI Light",0,fontSize));
        return tcc;
    }

}