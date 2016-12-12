package com.apsm.school.core;
import java.util.Random;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Subhra
 */
public class createSchedule{
    Subject [] subjects;
    Teacher [] teachers;
    Period [][][][] p = new Period[0][0][0][0];
    private JLabel [] ps;
    private JLabel sublb1;
    private JLabel sublb2;
    private JLabel prcn;
    private JButton btn1;
    private JButton btn2;
    private JLabel pre;

    /**
     *
     * @return
     */
    public Subject[] createSubjects(){
        sublb1.setText("Initialising subjects");
        String [] subjectNames = {"Bengali","English","History","Geography","Mathematics","Physical Sc.","Life Science"};
        subjects = new Subject[7];
        for(int i = 0;i<subjectNames.length;i++){
            subjects[i] = new Subject();
            sublb2.setText("Initialising "+subjectNames[i]+"");
            subjects[i].setSubjectName(subjectNames[i]);
            prcn.setText((((i+1)/7)*100)+"% complete");
        }
        return subjects;
    }

    /**
     *
     * @param l1
     * @param l2
     * @param l3
     * @param pl
     * @param b1
     * @param b2
     */
    public void setElements(JLabel l1,JLabel l2,JLabel l3,JLabel pl,JButton b1,JButton b2){
        sublb1 = l1;
        sublb1.setText("Setting up visuals");
        sublb2 = l2;
        prcn = l3;
        btn1 = b1;
        btn2 = b2;
        pre = pl;
        prcn.setText("100% complete");
    }

    /**
     *
     * @return
     */
    public Teacher[] createTeachers(){
        subjects = createSubjects();
        sublb1.setText("Initialising teachers");
        teachers = new Teacher[(subjects.length)*14];
        int count = 0;
        int arrayNum = 0;
        for(int j = 0;j<teachers.length;j++){
            createRandomHuman newHuman = new createRandomHuman();
            Human h = newHuman.createHuman();
            teachers[j] = new Teacher();
            teachers[j].setTeacherCore(h);
            if(j==(count+14)){
                count = j;
                arrayNum++;
            }
            teachers[j].setSubject(subjects[arrayNum]);
            sublb2.setText("Organising teachers for subject "+subjects[arrayNum].getSubjectName()+"");
            prcn.setText((((j+1)*100/teachers.length))+"% complete");
            subjects[arrayNum].addTeacher(teachers[j]);
            Random r = new Random();
            int age = 0;
            while(age<28){
                age = r.nextInt(59);
            }
            teachers[j].setAge(age);
            int max = 0;
            while(max<3){
                max = r.nextInt(6);
            }
            teachers[j].setMaxClass(max);
        }
        return teachers;
    }

    /**
     *
     */
    public void strt(){
        PClass p = new PClass();
        p.start();
    }

    class PClass extends Thread{

        int sub = 0;

        public void run(){
            createPeriods();
        }

        public Period[][][][] createPeriods(){
            teachers = createTeachers();
            createClass creator = new createClass();
            creator.setEl(sublb2);
            classLevel [][] classes = new classLevel[12][4];
            Analyzer.setClass(classes);
            Analyzer.setTeachers(teachers);
            Analyzer.setSubjects(subjects);
            sublb1.setText("Configuring classes");
            prcn.setText("0% complete");
            for(int i = 0;i<12;i++){
                creator.setStandard(i+1);
                classes[i] = creator.classCreate();
                prcn.setText(((i+1)*100)/12+"% complete");
            }
            p = new Period[12][4][6][7];
            int num = 0;
            sublb1.setText("Creating periods");
            for(int i = 0;i<12;i++){
                for(int j = 0;j<4;j++){
                    for(int y = 0;y<6;y++){
                        for(int l = 0;l<7;l++){
                            p[i][j][y][l] = new Period();
                            Period thisPeriod = p[i][j][y][l];
                            classLevel thisClass = classes[i][j];
                            int subNum = new Random().nextInt(7);
                            Subject thisSub = subjects[subNum];
                            
                            while(thisClass.hasSubject(thisSub,y)){
                                subNum = new Random().nextInt(7);
                                thisSub = subjects[subNum];
                            }
                            thisClass.addSubject(thisSub,y);
                            thisPeriod.setSubject(thisSub);
                            thisPeriod.setClass(thisClass);
                            Random r = new Random();
                            int tchrNum = r.nextInt(14);
                            Teacher toEnlist = thisSub.getTeachers()[tchrNum];
                            while(checkShift(toEnlist,y,l)){
                                tchrNum = r.nextInt(14);
                                toEnlist = thisSub.getTeachers()[tchrNum];
                                
                            }

                            toEnlist.addShift(l,y);
                            thisPeriod.setShift(l);
                            thisSub.addPeriod(thisPeriod);
                            thisPeriod.setTeacher(toEnlist);
                            toEnlist.addPeriod(thisPeriod);
                            num++;
                            if(num==10){
                                num = 0;
                            }
                            sublb2.setText("Configuring periods for class "+thisClass.getStandardAlpha()+thisClass.getSection()+"");
                            prcn.setText((((l+1)*(j+1)*(i+1)*(y+1)*100)/(12*4*7*6))+"% complete");
                        }
                        
                    }
                    
                    classes[i][j].setPeriods(p[i][j]);
                }
            }
            Analyzer.setPeriods(p);
            sublb2.setText("");
            prcn.setText("");
            pre.setText("");
            sublb1.setText("School configuring completed.");
            sublb2.setText("Your school is now ready to use.");
            btn1.setVisible(true);
            btn2.setVisible(true);
            return p;
        }

        public Teacher [] addT(Teacher [] t1,Teacher t2){
            Teacher [] tmp = new Teacher[t1.length+1];
            for(int i = 0;i<t1.length;i++){
                if(t1[i].equals(t2)){
                    return t1;
                }
                else{
                    tmp[i] = t1[i];
                }
            }
            tmp[t1.length] = t2;
            t1 = tmp;
            return t1;
        }
    }

    /**
     *
     * @return
     */
    public int getRandomSubject(){
        Random r = new Random();
        int toRet = r.nextInt(7);
        return toRet;
    }

    /**
     *
     * @param t
     * @param day
     * @param shift
     * @return
     */
    public boolean checkShift(Teacher t,int day,int shift){

        boolean [][] shifts = t.getShift();
        return shifts[day][shift];

    }

    /**
     *
     * @param s
     * @param shift
     * @param num
     * @return
     */
    public Teacher getRandomTeacher(Subject s,int shift,int num){
        int c = 0;
        if(num>=6 && num<13){
            c = 1;
        }
        else if(num>=13 && num<20){
            c = 2;
        }
        else if(num>=20 && num<27){
            c = 3;
        }
        else if(num>=27 && num<34){
            c = 4;
        }else if(num>=34 && num<41){
            c = 5;
        }
        else if(num>=41 && num<48){
            c = 6;
        }
        Teacher [] avTeachers = s.getTeachers();
        return avTeachers[c];
    }
}