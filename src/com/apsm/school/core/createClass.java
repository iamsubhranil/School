package com.apsm.school.core;
import java.util.Random;
import java.io.*;
import javax.swing.*;
class createClass{
    private int standard;
    private JLabel l2;
    public void setStandard(int stan){
        standard = stan;
    }
    
    public void setEl(JLabel lb2){
        l2 = lb2;
    }

    public classLevel[] classCreate(){
        String [] section = {"A","B","C","D"};
        classLevel [] newClass = new classLevel[4];
        long tot = 0;
        for(int f = 0;f<4;f++){
            
            newClass [f] = new classLevel();
            newClass[f].setSection(section[f]);
            newClass[f].setStandard(standard);
            l2.setText("Enlisting students in class "+newClass[f].getStandardAlpha()+section[f]);
            Random r = new Random();
            int num = 0;
            while(num<56){
                num = r.nextInt(60)+1;
            }
            tot = tot+num;
            Student [] students = new Student[num];
            for(int i = 0;i<num;i++){
                createStudent c = new createStudent();
                c.setClass(newClass[f]);
                students[i] = c.newStudent();
            }
            newClass[f].regStudents(students);
        }
        Analyzer.addTotStu(tot);
        return newClass;
    }

    public void logStudent (Student s){
        try{
        PrintWriter write = new PrintWriter(new FileWriter("studb.xml",true));
        write.println("\t<student>");
        write.println("\t<name>"+s.getStudentCore().getName()+" "+s.getStudentCore().getSurName()+"</name>");
        write.println("\t<age>"+s.getAge()+"</age>");
        write.println("\t<height>"+s.getStudentCore().getHeight()+"</height>");
        write.println("\t<fathername>"+s.getParentFather().getName()+" "+s.getParentFather().getSurName()+"</fathername>");
        write.println("\t<fatherheight>"+s.getParentFather().getHeight()+"</fatherheight>");
        write.println("\t<mothername>"+s.getParentMother().getName()+" "+s.getParentMother().getSurName()+"</mothername>");
        write.println("\t<motherheight>"+s.getParentMother().getHeight()+"</motherheight>");
        write.println("\t</student>");
        write.close();
    }
        catch(Exception h){}
    }
}