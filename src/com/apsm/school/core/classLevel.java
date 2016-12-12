package com.apsm.school.core;
import java.util.Random;

/**
 *
 * @author Subhra
 */
public class classLevel implements java.io.Serializable{
    Student [] students = new Student[0];
    private String section;
    private int standard;
    private Period [][] periods = new Period[6][7];
    private Teacher [] teachers;
    private Subject [][] subjects = new Subject[6][];

    /**
     *
     * @param s
     */
    public void regStudents(Student [] s){
        students = s;
    }

    /**
     *
     * @param sec
     */
    public void setSection(String sec){
        section = sec;
    }

    /**
     *
     * @param stan
     */
    public void setStandard(int stan){
        standard = stan;
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
     * @param p
     */
    public void setPeriods(Period [][] p){
        periods = p;
    }
    
    /**
     *
     * @param s
     * @param d
     */
    public void addSubject(Subject s,int d){
        Subject [] ss = subjects[d];
        int g = 0;
        try{
            g = ss.length;
        }
        catch(Exception j){
        }
        Subject [] tmp = new Subject[g+1];
        for(int i = 0;i<g;i++){
            tmp[i] = ss[i];
        }
        tmp[tmp.length-1] = s;
        ss = tmp;
        subjects[d] = ss;
    }
    
    /**
     *
     * @param s
     */
    public void addStudent(Student s){
        Student [] tmp = new Student[students.length+1];
        for(int i = 0;i<students.length;i++){
            tmp[i] = students[i];
        }
        tmp[tmp.length-1] = s;
        students = tmp;
    }
    
    /**
     *
     * @param s
     * @param d
     * @return
     */
    public boolean hasSubject(Subject s,int d){
        try{
        for(int i = 0;i<subjects[d].length;i++){
            if(subjects[d][i].equals(s)){
                return true;
            }
        }}
        catch(Exception n){}
        return false;
    }
    
    /**
     *
     * @param t
     * @param d
     * @param tm
     */
    public void addPeriod(Period t,int d,int tm){
        periods[d][tm] = t;
    }

    /**
     *
     * @return
     */
    public String getStandardAlpha(){
        String toRet = "";
        switch(standard){
            case 1 : toRet = "I"; break;
            case 2 : toRet = "II"; break;
            case 3 : toRet = "III"; break;
            case 4 : toRet = "IV"; break;
            case 5 : toRet = "V"; break;
            case 6 : toRet = "VI"; break;
            case 7 : toRet = "VII"; break;
            case 8 : toRet = "VIII"; break;
            case 9 : toRet = "IX"; break;
            case 10 : toRet = "X"; break;
            case 11 : toRet = "XI"; break;
            case 12 : toRet = "XII"; break;
        }
        return toRet;
    }
    
    /**
     *
     * @return
     */
    public int getStandard(){
        return standard;
    }
    
    /**
     *
     * @return
     */
    public Teacher [] getTeachers(){
        return teachers;
    }
    
    /**
     *
     * @return
     */
    public Period[][] getPeriods(){
        return periods;
    }
    
    /**
     *
     * @return
     */
    public String getSection(){
        return section;
    }

    /**
     *
     * @param c
     * @return
     */
    public boolean equals(classLevel c){
        if(c.getStandard()==(standard)){
            if(c.getSection().equals(section)){
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public Student [] getStudents(){
        return students;
    }

    /**
     *
     * @return
     */
    public int getDesirableAge(){
        Random r = new Random();
        int age = 0;
        switch(standard){
            case 1 :
            case 2 :
            while(age<4){
                age = r.nextInt(6)+1;
                if(age>=4){
                    break;
                }
            }
            break;
            case 3 :
            case 4 :
            while(age<6){
                age = r.nextInt(8)+1;
                if(age>=6){
                    break;
                }
            }
            break;
            case 5 :
            case 6 :
            while(age<8){
                age = r.nextInt(10)+1;
                if(age>=8){
                    break;
                }
            }
            break;
            case 7 :
            case 8 :
            while(age<10){
                age = r.nextInt(13)+1;
                if(age>=10){
                    break;
                }
            }
            break;
            case 9 :
            case 10 :
            while(age<15){
                age = r.nextInt(16)+1;
                if(age>=14){
                    break;
                }
            }
            break;
            case 11 :
            case 12 :
            while(age<17){
                age = r.nextInt(19)+1;
                if(age>=15){
                    break;
                }
            }
            break;
        }
        return age;
    }
}