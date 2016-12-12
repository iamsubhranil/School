package com.apsm.school.testgui;

import java.util.Properties;
import java.util.Set; 

import com.sun.management.*;
import java.lang.management.ManagementFactory; 

/**
 *
 * @author Subhra
 */
public class OSInfo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for(Object obj : keySet){
            System.out.println(obj.toString()+" => "+System.getProperty(obj.toString())+"\n");
        }
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(  
                OperatingSystemMXBean.class);  
        System.out.println(osBean.getProcessCpuLoad()*100);  

        // What % load the overall system is at, from 0.0-1.0  
        System.out.println(osBean.getSystemCpuLoad()*100); 

        long total = Runtime.getRuntime().totalMemory()/1024/1024;
        long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        
        System.out.println(total+" "+(used/1024/1024));
    }

}