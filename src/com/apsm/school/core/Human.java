package com.apsm.school.core;

/**
 *
 * @author Subhra
 */
public class Human implements java.io.Serializable{
    private String name = "";
    private String surName = "";
    private String height = "";
    private String Sex = "";

    /**
     *
     * @param n
     */
    public void setName(String n){
        name = n;
    }

    /**
     *
     * @param s
     */
    public void setSurName(String s){
        surName = s;
    }

    /**
     *
     * @param h
     */
    public void setHeight(String h){
        height = h;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex){
        Sex = sex;
    }

    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return
     */
    public String getSurName(){
        return surName;
    }

    /**
     *
     * @return
     */
    public String getHeight(){
        return height;
    }

    /**
     *
     * @return
     */
    public String getSex(){
        return Sex;
    }

    /**
     *
     * @return
     */
    public boolean isBoy(){
        if(Sex.equals("Male")){
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean isGirl(){
        if(Sex.equals("Female")){
            return true;
        }
        return false;
    }

    /**
     *
     * @param h
     * @return
     */
    public boolean equals(Human h){
        if(h.getName().equals(name)){
            if(h.getSurName().equals(surName)){
                if(h.getHeight().equals(height)){
                    if(h.getSex().equals(Sex)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String toString(){
        return name+" "+surName+" "+Sex+" "+height;
    }
}