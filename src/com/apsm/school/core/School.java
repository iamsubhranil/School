package com.apsm.school.core;

import java.io.*;

/**
 *
 * @author Subhra
 */
public class School implements Serializable{
    classLevel [][] cls;
    Period [][][][] ps;
    Teacher [] tchs;
    Subject [] sbs;
    String name;

    /**
     *
     * @param c
     * @param p
     * @param t
     * @param s
     * @param n
     */
    public School(classLevel [][] c,Period [][][][] p,Teacher [] t,Subject [] s,String n){
        cls = c;
        ps = p;
        tchs = t;
        sbs = s;
        name = n;
    }

    /**
     *
     * @return
     */
    public classLevel[][] getClasses(){
        return cls;
    }

    /**
     *
     * @return
     */
    public Period[][][][] getPeriods(){
        return ps;
    }

    /**
     *
     * @return
     */
    public Teacher[] getTeachers(){
        return tchs;
    }

    /**
     *
     * @return
     */
    public Subject[] getSubjects(){
        return sbs;
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
     * @param s
     * @return
     */
    public boolean equals(School s){
        boolean ret = false;
        Teacher [] st = s.getTeachers();
        Period[][][][] sp = s.getPeriods();
        if(st.length==tchs.length){
            for(int i = 0;i<tchs.length;i++){
                if(tchs[i].equals(st[i])){
                    ret = true;
                }
                else{
                    return false;
                }
            }
            for(int j = 0;j<12;j++){
                for(int k = 0;k<4;k++){
                    for(int l = 0;l<6;l++){
                        for(int m = 0;m<7;m++){
                            if(ps[j][k][l][m].equals(sp[j][k][l][m])){
                                ret = true;
                            }
                            else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        else{
            return false;
        }
        return ret;

    }
}