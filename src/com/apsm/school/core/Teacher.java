package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class Teacher implements java.io.Serializable{
    private Human teacherCore = new Human();
    private Period [] periods = new Period[0];
    private Subject subject = new Subject();
    private int age = 0;
    private int maxClass = 0;
    private boolean [][] shift = new boolean[7][7];

    /**
     *
     */
    public Teacher(){
        for(int i = 0;i<7;i++){
            for(int y = 0;y<7;y++){
                shift[i][y] = false;
            }
        }
    }
    
    /**
     *
     * @param s
     */
    public void setSubject(Subject s){
        subject = s;
    }

    /**
     *
     * @param h
     */
    public void setTeacherCore(Human h){
        teacherCore = h;
    }

    /**
     *
     * @param p
     */
    public void setPeriods(Period [] p){
        periods = p;
    }

    /**
     *
     * @param a
     */
    public void setAge(int a){
        age = a;
    }

    /**
     *
     * @param m
     */
    public void setMaxClass(int m){
        maxClass = m;
    }

    /**
     *
     * @param b
     */
    public void setShift(boolean [][] b){
        shift = b;
    }

    /**
     *
     * @param t
     * @param d
     */
    public void addShift(int t,int d){
        boolean [][] temp = new boolean[7][7];
        for(int i = 0;i<shift[d].length;i++){
            if(i==t){
                temp[d][i] = true;
            }
            else{
                temp[d][i] = shift[d][i];}
        }
        shift = temp;
    }

    /**
     *
     * @return
     */
    public boolean[][] getShift(){
        return shift;
    }

    /**
     *
     * @return
     */
    public Subject getSubject(){
        return subject;
    }

    /**
     *
     * @return
     */
    public Human getTeacherCore(){
        return teacherCore;
    }

    /**
     *
     * @return
     */
    public Period [] getPeriods(){
        return periods;
    }

    /**
     *
     * @return
     */
    public int getAge(){
        return age;
    }

    /**
     *
     * @return
     */
    public int getMaxClass(){
        return maxClass;
    }

    /**
     *
     * @param t
     */
    public void addPeriod(Period t){
        Period [] temp = new Period[periods.length+1];
        for(int i = 0;i<periods.length;i++){
            temp[i] = periods[i];
        }
        temp[temp.length-1] = t;
        periods = temp;
    }

    /**
     *
     * @param t
     * @return
     */
    public boolean equals(Teacher t){
        if(t.getTeacherCore().equals(teacherCore)){
            if(t.getSubject().equals(subject)){
                if(t.getAge()==age){
                    if(t.getMaxClass()==maxClass){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}