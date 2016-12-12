package com.apsm.school.visual;

import java.awt.*;

/**
 *
 * @author Subhra
 */
public class Scheme implements java.io.Serializable{
    String name;
    Color [] cols;
    boolean trans;
    String font;

    /**
     *
     * @param name
     * @param cols
     * @param trans
     * @param font
     */
    public Scheme(String name,Color [] cols,boolean trans,String font){
        this.name = name;
        this.cols = cols;
        this.trans = trans;
        this.font = font;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @return
     */
    public String getFont(){
        return font;
    }
    
    /**
     *
     * @return
     */
    public Color[] getColors(){
        return cols;
    }
    
    /**
     *
     * @return
     */
    public boolean getTransition(){
        return trans;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public boolean equals(Scheme s){
        Color [] nc = s.getColors();
        int mccnt = 0;
        for(int i = 0;i<nc.length;i++){
            if(cols[i]==nc[i]){
                mccnt++;
            }
        }
        if(mccnt==cols.length){
            return true;
        }
        return false;
    }
}