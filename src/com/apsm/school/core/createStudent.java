package com.apsm.school.core;

import java.io.*;
class createStudent{
    private classLevel ofClass;
    public void setClass(classLevel o){
        ofClass = o;
    }

    public Student newStudent(){
        
        createRandomHuman newHuman = new createRandomHuman();
        Human h = newHuman.createHuman();
        
        String surName = h.getSurName();
        Boy newBoy = new Boy();
        Girl newGirl = new Girl();
        Human parentFather = newBoy.createRandomBoy();
        parentFather.setSurName(surName);
        Human parentMother = newGirl.createRandomGirl();
        parentMother.setSurName(surName);
        
        int studentAge = ofClass.getDesirableAge();
        
        Student newStudent = new Student();
        newStudent.setStudentCore(h);
        newStudent.setParentFather(parentFather);
        newStudent.setParentMother(parentMother);
        newStudent.setClass(ofClass);   
        newStudent.setAge(studentAge);
        
        return newStudent;
    }
    
    

}