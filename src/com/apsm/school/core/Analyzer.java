package com.apsm.school.core;
import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author Subhra
 */
public class Analyzer implements Serializable{
    static Period[][][][]periods;
    static classLevel[][]classes;
    static Subject [] subjects;
    static Teacher [] teachers;
    static long totstu = 0;
    static School sh;

    /**
     *
     * @param j
     */
    public static void addTotStu(long j){
        totstu = totstu+j;
    }

    /**
     *
     * @return
     */
    public static long getTotStu(){
        return totstu;
    }

    /**
     *
     * @param s
     */
    public static void loadSchool(School s){
        setClass(s.getClasses());
        setSubjects(s.getSubjects());
        setTeachers(s.getTeachers());
        setPeriods(s.getPeriods());
        sh = s;
    }
    
    /**
     *
     * @return
     */
    public static School getSchool(){
        School sh2 = new School(getTotalClass(),getTotalPeriods(),getTotalTeachers(),getSubjects(),dataStore.getSchoolName());
        return sh2;
    }

    /**
     *
     * @param p
     */
    public static void setPeriods(Period[][][][]p){
        periods = p;
    }

    /**
     *
     * @param c
     */
    public static void setClass(classLevel[][]c){
        classes = c;
    }

    /**
     *
     * @param s
     */
    public static void setSubjects(Subject [] s){
        subjects = s;
    }

    /**
     *
     * @param t
     */
    public static void setTeachers(Teacher [] t){
        teachers = t;
    }

    /**
     *
     * @return
     */
    public static Period [][][][] getTotalPeriods(){
        return periods;
    }

    /**
     *
     * @return
     */
    public static classLevel[][] getTotalClass(){
        return classes;
    }

    /**
     *
     * @return
     */
    public static Teacher[] getTotalTeachers(){
        return teachers;
    }

    /**
     *
     * @return
     */
    public static Subject [] getSubjects(){
        return subjects;
    }
}