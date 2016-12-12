package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class Subject implements java.io.Serializable{
    private String subjectName = "";
    private Teacher [] teachers = new Teacher[0];
    private Period [] periods = new Period[0];

    /**
     *
     * @param p
     */
    public void setPeriods(Period [] p){
        periods = p;
    }

    /**
     *
     * @param n
     */
    public void setSubjectName(String n){
        subjectName = n;
    }

    /**
     *
     * @param t
     */
    public void setTeachers(Teacher [] t){
        teachers = t;
    }

    /**
     *
     * @param t
     */
    public void addTeacher(Teacher t){
        Teacher [] temp = new Teacher[teachers.length+1];
        for(int i = 0;i<teachers.length;i++){
            temp[i] = teachers[i];
        }
        temp[temp.length-1] = t;
        teachers = temp;
    }
    
    /**
     *
     * @param p
     */
    public void addPeriod(Period p){
        Period [] temp = new Period[periods.length+1];
        for(int i = 0;i<periods.length;i++){
            temp[i] = periods[i];
        }
        temp[temp.length-1] = p;
        periods = temp;
    }

    /**
     *
     * @return
     */
    public Teacher[] getTeachers(){
        return teachers;
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
    public String getSubjectName(){
        return subjectName;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public boolean equals(Subject s){
        if(s.getSubjectName().equals(subjectName)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return "subject="+subjectName;
    }
}