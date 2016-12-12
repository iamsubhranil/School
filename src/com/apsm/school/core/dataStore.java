package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class dataStore{
    static private String name;
    static private String sex;
    static private String pass;
    static private String username;
    static private String [] schoolName;
    static private String school;
    static private User u2;
    static private School [] schs = new School[0];

    /**
     *
     * @param u
     */
    public static void loadUser(User u){
        setName(u.getName());
        setUser(u.getUserName());
        setSex(u.getSex());
        setPass(u.getPasskey());
        setSchools(u.getAllSchools());
        setSchoolsObject(u.getSchoolsAsObject());
        u2 = u;
    }
    
    /**
     *
     */
    public static void refreshLocalStore(){
        loadUser(premitiveData.getUser(getUserName()));
    }
    
    /**
     *
     * @param s
     */
    public static void setSchoolsObject(School [] s){
        schs = s;
    }

    /**
     *
     * @param n
     */
    public static void setName(String n){
        name = n;
    }

    /**
     *
     * @return
     */
    public static User getCurrentUser(){
        User us = new User();
        us.setName(getName());
        us.setPasskey(getPass());
        us.setUserName(getUserName());
        us.setSex(getSex());
        us.setSchools(getSchoolNames());
        us.setSchoolsObject(schs);
        return us;
    }

    /**
     *
     * @param s
     */
    public static void setSex(String s){
        sex = s;
    }

    /**
     *
     * @param p
     */
    public static void setPass(String p){
        pass = p;
    }

    /**
     *
     * @param u
     */
    public static void setUser(String u){
        username = u;
    }

    /**
     *
     * @param sn
     */
    public static void setSchools(String [] sn){
        schoolName = sn;
    }

    /**
     *
     * @param s
     */
    public static void setSchool(String s){
        school = s;
    }

    /**
     *
     * @return
     */
    public static String getName(){
        return name;
    }

    /**
     *
     * @return
     */
    public static String getUserName(){
        return username;
    }

    /**
     *
     * @return
     */
    public static String getPass(){
        return pass;
    }

    /**
     *
     * @return
     */
    public static String getSex(){
        return sex;
    }

    /**
     *
     * @return
     */
    public static String getSchoolName(){
        return school;
    }

    /**
     *
     * @return
     */
    public static String [] getSchoolNames(){
        return schoolName;
    }

    /**
     *
     * @param snm
     * @return
     */
    public static boolean hasSchool(String snm){
        try{
            for(int i = 0;i<schoolName.length;i++){
                if(schoolName[i].equals(snm)){
                    return true;
                }
            }
        }
        catch(NullPointerException nlpe){}
        return false;
    }
}