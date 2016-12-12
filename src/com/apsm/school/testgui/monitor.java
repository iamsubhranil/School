package com.apsm.school.testgui;

import com.apsm.school.visual.*;
import javax.swing.*;
import java.awt.*;
import com.sun.management.*;
import java.lang.management.ManagementFactory; 

/**
 *
 * @author Subhra
 */
public class monitor{
    double pu;
    JLabel jl1;
    JLabel jl3;
    OperatingSystemMXBean osBean;

    /**
     *
     * @param mf
     */
    public monitor(mainFrame mf){
        JPanel cp = new JPanel();

        GroupLayout gl = new GroupLayout(cp);
        cp.setLayout(gl);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel jl = UICore.createNewLabel("Processor usage : ",25,"l0");

        jl1 = UICore.createNewLabel("",25,"l1");

        JLabel jl2 = UICore.createNewLabel("RAM usage : ",25,"l2");

        jl3 = UICore.createNewLabel("",25,"l3");

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addComponent(jl)
            .addComponent(jl1)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addComponent(jl2)
            .addComponent(jl3)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
            .addComponent(jl)
            .addComponent(jl1)
            .addComponent(jl2)
            .addComponent(jl3)
        );

        mf.getContentPane().add(cp, BorderLayout.PAGE_END);
        mf.pack();
        visualData.updateContentPane(cp);
        osBean = ManagementFactory.getPlatformMXBean(  
            OperatingSystemMXBean.class); 
        pu = osBean.getSystemCpuLoad()*100;
        ref r = new ref();
        r.start();
    }

    class ref extends Thread{
        public void run(){
            int i = 0;
            while(i==0){
                pu = osBean.getSystemCpuLoad()*100;
                String p = String.format("%.0f",pu);
                long total = Runtime.getRuntime().totalMemory();
                long used  = total-Runtime.getRuntime().freeMemory();
                float prcn = used*100/total;
                String r = String.format("%.2f",prcn);
                jl1.setText(p+" %");
                jl3.setText(r+" %");
                try{
                    Thread.sleep(1000);
                }
                catch(Exception j){}
            }
        }
    }
}