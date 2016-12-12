package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class Student implements java.io.Serializable{
    private Human studentCore;
    private Human parentFather;
    private Human parentMother;
    private int age;
    private classLevel presentClass;
    private boolean isPresent;

    /**
     *
     * @param s
     */
    public void setStudentCore(Human s){
        studentCore = s;
    }

    /**
     *
     * @param father
     */
    public void setParentFather(Human father){
        parentFather = father;
    }

    /**
     *
     * @param mother
     */
    public void setParentMother(Human mother){
        parentMother = mother;
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
     * @param c
     */
    public void setClass(classLevel c){
        presentClass = c;
    }

    /**
     *
     * @param p
     */
    public void setAttendence(boolean p){
        isPresent = p;
    }

    /**
     *
     * @return
     */
    public Human getStudentCore(){
        return studentCore;
    }

    /**
     *
     * @return
     */
    public Human getParentMother(){
        return parentMother;
    }

    /**
     *
     * @return
     */
    public Human getParentFather(){
        return parentFather;
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
    public classLevel getPresentClass(){
        return presentClass;
    }

    /**
     *
     * @return
     */
    public boolean getAttendence(){
        return isPresent;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean equals(Student s){
        if(s.getStudentCore().equals(studentCore)){
            if(s.getParentFather().equals(parentFather)){
                if(s.getParentMother().equals(parentMother)){
                    if(s.getAge()==age){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}