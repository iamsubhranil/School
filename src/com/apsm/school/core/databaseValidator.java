package com.apsm.school.core;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Subhra
 */
public class databaseValidator{

    /**
     *
     */
    public void checkUsersAndLoad(){
        File f = new File("Database\\base.xml");
        if(f.exists()){
            String [] us = readDataFromFile(f,"users","user");
            for(int y = 0;y<us.length;y++){
                readUserDetails(us[y]);
            }
        }
    }

    /**
     *
     * @param user
     */
    public void readUserDetails(String user){
        File f = new File("Database\\"+user+"\\user.xml");
        User u = new User();
        u.setUserName(user);
        if(f.exists()){
            File f2 = new File("Database\\"+user+"\\schools.xml");
            if(f2.exists()){
                String [] sch = readDataFromFile(f2,"schools","school");
                boolean allok = false;
                for(int i = 0;i<sch.length;i++){
                    allok = checkSchool(sch[i],u);
                    if(allok==false){
                        break;
                    }
                }
                if(allok){
                    String [] ud = readDataFromFile(f,"user","username");
                    String [] cm = readDataFromFile(f,"user","canonicalname");
                    String [] sex = readDataFromFile(f,"user","sex");
                    String [] pwd = readDataFromFile(f,"user","password");
                    u.setName(cm[0]);
                    u.setSex(sex[0]);
                    u.setPasskey(pwd[0]);
                    u.setSchools(sch);
                    premitiveData.addUser(u);
                }
            }
        }
    }

    /**
     *
     * @param s
     * @param u
     * @return
     */
    public boolean checkSchool(String s,User u){
        File dir = new File("Database\\"+u.getUserName()+"\\"+s);
        boolean allok = false;
        if(dir.isDirectory()){
            File f1 = new File(dir+"\\checksum.xml");
            File f2 = new File(dir+"\\studentdb.xml");
            File f3 = new File(dir+"\\perioddb.xml");
            File f4 = new File(dir+"\\teacherdb.xml");
            File f5 = new File(dir+"\\subjectdb.xml");
            File [] fs = {f3,f2,f5,f4};
            String [] csum = readDataFromFile(f1,"checksum","filesize");
            String [] fnm = readDataFromFile(f1,"checksum","filename");

            for(int i = 0;i<fnm.length;i++){
                long fsg = Long.parseLong(csum[i]);
                if(fs[i].getName().equals(fnm[i]) && fs[i].length()==fsg){
                    allok = true;
                }
                else{
                    allok = false;
                    break;
                }
            }
        }
        return allok;
    }

    /**
     *
     * @param f
     * @param d1
     * @param d2
     * @return
     */
    public String[] readDataFromFile(File f,String d1,String d2){
        String [] sch = new String[0];
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);
            Element rootEle = doc.getDocumentElement();
            if(rootEle.getNodeName().equals(d1)){
                NodeList ulist = rootEle.getElementsByTagName(d2);
                if(ulist!=null && ulist.getLength()>0){
                    sch = new String[ulist.getLength()];
                    for(int i = 0;i<ulist.getLength();i++){
                        Element e1 = (Element)ulist.item(i);
                        String u2 = e1.getChildNodes().item(0).getNodeValue();
                        sch[i] = u2;
                    }

                }
            }
        }
        catch(Exception h){
            h.printStackTrace();
        }
        return sch;
    }

}