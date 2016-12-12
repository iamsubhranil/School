package com.apsm.school.core;

import com.apsm.school.visual.*;
import java.io.*;
class makeBasementFromDatabase{
    public static void make(){
        databaseValidator dv = new databaseValidator();
        dv.checkUsersAndLoad();
        System.out.println("Please wait..");
        User [] us = premitiveData.getUsers();
        for(int i = 0;i<us.length;i++){
            dataStore.loadUser(us[i]);
            String [] schs = dataStore.getSchoolNames();
            System.out.println(us[i].getUserName()+"\n");
            for(int j = 0;j<schs.length;j++){
                dataStore.setSchool(schs[j]);
                storageLoader sl = new storageLoader();
                sl.startLoading();
                us[i].addSchool(Analyzer.getSchool());
                try{
                System.out.println(us[i].getSchool(Analyzer.getSchool().getName()).getName());}
                catch(Exception g){
                    System.out.println(g.getMessage());
                }
            }
        }
        visualStore.loadAllSchemes();
        Scheme [] ss = visualData.getAllSchemes();
        visualStore.loadLastUsed();
        Scheme s = visualData.getCurrentScheme();
        Basement bs = new Basement(us,ss,s);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basement.ser"));

            oos.writeObject(bs);
            oos.close();
        }
        catch(Exception h){
            h.printStackTrace();
        }
        System.out.println("Done!");
    }
}