package com.apsm.school.core;

import java.io.*;

/**
 *
 * @author Subhra
 */
public class User implements java.io.Serializable{
    String nm;
    String unm;
    String schlfl;
    String pwd;
    String sex;
    String [] schs = new String[0];
    School [] schools = new School[0];

    /**
     *
     * @param s
     */
    public void setName(String s){
        nm = s;
    }

    /**
     *
     * @param u
     */
    public void setUserName(String u){
        unm = u;
    }

    /**
     *
     * @param d
     */
    public void setSchoolFile(String d){
        schlfl = d;
    }

    /**
     *
     * @param h
     */
    public void setPasskey(String h){
        pwd = h;
    }

    /**
     *
     * @param s
     */
    public void setSex(String s){
        sex = s;
    }

    /**
     *
     * @param sh
     */
    public void setSchools(String [] sh){
        schs = sh;
    }

    /**
     *
     * @return
     */
    public String getName(){
        return nm;
    }

    /**
     *
     * @return
     */
    public String getUserName(){
        return unm;
    }

    /**
     *
     * @return
     */
    public String getSchoolFile(){
        return schlfl;
    }

    /**
     *
     * @return
     */
    public String getPasskey(){
        return pwd;
    }

    /**
     *
     * @return
     */
    public String getSex(){
        return sex;
    }

    /**
     *
     * @return
     */
    public String [] getAllSchools(){
        return schs;
    }

    /**
     *
     * @param s
     */
    public void addSchool(School s){
        School [] tmp = new School[schools.length+1];
        for(int i = 0;i<schools.length;i++){
            tmp[i] = schools[i];
        }
        tmp[schools.length] = s;
        schools = tmp;
        schs = new String[schools.length];
        for(int j = 0;j<schools.length;j++){
            schs[j] = schools[j].getName();
        }
        premitiveData.updateUser(this);
        dataStore.refreshLocalStore();
    }

    /**
     *
     * @param s
     */
    public void deleteSchool(School s){
        School [] tmp = new School[schools.length-1];
        int c = 0;
        for(int i = 0;i<schools.length;i++){
            if(!schools[i].equals(s)){
                tmp[c] = schools[i];
                c++;
            }

        }
        schools = tmp;
        schs = new String[schools.length];
        for(int j = 0;j<schools.length;j++){
            try{
                schs[j] = schools[j].getName();}
            catch(NullPointerException h){
            }
        }
        premitiveData.updateUser(this);
        dataStore.refreshLocalStore();
    }

    /**
     *
     * @param sl
     */
    public void setSchoolsObject(School [] sl){
        schools = sl;
    }

    /**
     *
     * @return
     */
    public School[] getSchoolsAsObject(){
        return schools;
    }

    /**
     *
     * @param u
     * @return
     */
    public boolean equals(User u){
        if(u.getUserName().equals(unm)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param s
     * @return
     */
    public School getSchool(String s){
        for(int y = 0;y<schools.length;y++){
            if(schools[y].getName().equals(s)){
                return schools[y];
            }
        }
        return null;
    }
}