package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class Period implements java.io.Serializable{
        private Subject subject = new Subject();
        private Teacher teacher = new Teacher();
        private classLevel ofClass = new classLevel();
        private int shift = 0;

    /**
     *
     * @param s
     */
    public void setSubject(Subject s){
            subject = s;
        }

    /**
     *
     * @param t
     */
    public void setTeacher(Teacher t){
            teacher = t;
        }

    /**
     *
     * @param o
     */
    public void setClass(classLevel o){
            ofClass = o;
        }

    /**
     *
     * @param s
     */
    public void setShift(int s){
            shift = s;
        }

    /**
     *
     * @return
     */
    public Teacher getTeacher(){
            return teacher;
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
    public classLevel getClassLevel(){
            return ofClass;
        }

    /**
     *
     * @return
     */
    public int getShift(){
            return shift;
        }

    /**
     *
     * @param p
     * @return
     */
    public boolean equals(Period p){
            if(subject.equals(p.getSubject())){
                if(teacher.equals(p.getTeacher())){
                    if(ofClass.equals(p.getClassLevel())){
                        return true;
                    }
                }
            }
            return false;
        }
}