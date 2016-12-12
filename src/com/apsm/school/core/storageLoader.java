package com.apsm.school.core;


import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Subhra
 */
public class storageLoader{
    File mainDir = new File("Database\\"+dataStore.getUserName()+"\\"+dataStore.getSchoolName());
    classLevel [][] clss;
    Teacher [] tchrs;
    Subject [] subjs;
    Period [][][][] prds;
    JLabel jl;
    boolean en = false;

    /**
     *
     * @param l
     */
    public void setDetails(JLabel l){
        jl = l;
        en = true;
    }
    
    /**
     *
     */
    public void loadStudents(){
        File sFile = new File(mainDir+"\\studentdb.xml");
        NodeList clsList = readDataFromFile(sFile,"classes","class");
        clss = new classLevel[12][4];
        String [] secs = {"A","B","C","D"};
        if(en){
            jl.setText("Loading students");
        }
        for(int y = 0;y<clsList.getLength();y++){
            Element sece = (Element)clsList.item(y);
            NodeList n2 = sece.getChildNodes();
            for(int z = 0;z<n2.getLength();z++){
                clss[y][z] = new classLevel();
                clss[y][z].setSection(secs[z]);
                clss[y][z].setStandard(y);
                NodeList n3 = ((Element)n2.item(z)).getChildNodes();
                NodeList n4 = ((Element)n3.item(0)).getChildNodes();
                Student [] stu = new Student[n4.getLength()];
                for(int a = 0;a<n4.getLength();a++){
                    stu[a] = new Student();
                    stu[a].setClass(clss[y][z]);
                    int ha = clss[y][z].getDesirableAge();
                    stu[a].setAge(ha);
                    NodeList dataList = n4.item(a).getChildNodes();
                    String [] data = new String[dataList.getLength()];
                    for(int b = 0;b<dataList.getLength();b++){
                        String val = dataList.item(b).getChildNodes().item(0).getNodeValue();
                        data[b] = val;
                    }
                    stu[a] = makeStudent(data);
                    stu[a].setClass(clss[y][z]);
                }
                clss[y][z].regStudents(stu);
            }
        }
        Analyzer.setClass(clss);
    }

    /**
     *
     */
    public void loadTeachers(){
        if(en){
            jl.setText("Loading teachers");
        }
        File tFile = new File(mainDir+"\\teacherdb.xml");
        NodeList rl = readDataFromFile(tFile,"teachers","teacher");
        tchrs = new Teacher[rl.getLength()];
        for(int a  = 0;a<rl.getLength();a++){
            Element tl = (Element)rl.item(a);
            NodeList dl = tl.getChildNodes();
            String [] dta = new String[dl.getLength()];
            for(int h = 0;h<dl.getLength();h++){
                String val = dl.item(h).getChildNodes().item(0).getNodeValue();
                dta[h] = val;
            }
            Human th = createHuman(dta[0].split(" ")[0],dta[0].split(" ")[1],dta[3],dta[1]);
            tchrs[a] = new Teacher();
            tchrs[a].setTeacherCore(th);
            tchrs[a].setAge(Integer.parseInt(dta[2]));
        }
    }

    /**
     *
     */
    public void loadSubjects(){
        if(en){
            jl.setText("Loading subjects");
        }
        File sFile = new File(mainDir+"\\subjectdb.xml");
        NodeList sl = readDataFromFile(sFile,"subjects","subject");
        subjs = new Subject[sl.getLength()];
        String [] snm = new String[sl.getLength()];
        for(int k = 0;k<sl.getLength();k++){
            NodeList sd = sl.item(k).getChildNodes();
            subjs[k] = new Subject();
            for(int y = 0;y<1;y++){
                snm[k] = sd.item(y).getChildNodes().item(0).getNodeValue();
            }
            subjs[k].setSubjectName(snm[k]);
            for(int z = 1;z<sl.getLength();z++){
                Node currentItem = sd.item(z);
                String key = currentItem.getAttributes().getNamedItem("id").getNodeValue();
                int tid = Integer.parseInt(key);
                subjs[k].addTeacher(tchrs[tid]);
                tchrs[tid].setSubject(subjs[k]);
            }
        }
        Analyzer.setSubjects(subjs);
        Analyzer.setTeachers(tchrs);
    }
    
    /**
     *
     */
    public void loadPeriods(){
        if(en){
            jl.setText("Loading periods");
        }
        File pFile = new File(mainDir+"\\perioddb.xml");
        NodeList pl = readDataFromFile(pFile,"periods","class");
        prds = new Period[pl.getLength()][][][];
        for(int i = 0;i<pl.getLength();i++){
            NodeList cl = pl.item(i).getChildNodes();
            prds[i] = new Period[cl.getLength()][][];
            for(int j = 0;j<cl.getLength();j++){
                NodeList nl = cl.item(j).getChildNodes();
                prds[i][j] = new Period[nl.getLength()][];
                for(int k = 0;k<nl.getLength();k++){
                    NodeList ml = nl.item(k).getChildNodes();
                    prds[i][j][k] = new Period[ml.getLength()];
                    for(int m = 0;m<ml.getLength();m++){
                        NodeList dl = ml.item(m).getChildNodes();
                        String [] ids = new String[dl.getLength()];
                        for(int n = 0;n<dl.getLength();n++){
                            String key = dl.item(n).getAttributes().getNamedItem("id").getNodeValue();
                            ids[n] = key;
                        }
                        int sid = Integer.parseInt(ids[0]);
                        int tid = Integer.parseInt(ids[1]);
                        prds[i][j][k][m] = new Period();
                        prds[i][j][k][m].setSubject(subjs[sid]);
                        prds[i][j][k][m].setTeacher(tchrs[tid]);
                        prds[i][j][k][m].setClass(clss[i][j]);
                        tchrs[tid].addPeriod(prds[i][j][k][m]);
                        clss[i][j].addPeriod(prds[i][j][k][m],k,m);
                        subjs[sid].addPeriod(prds[i][j][k][m]);
                    }
                }
            }
        }
        Analyzer.setPeriods(prds);
    }
    
    /**
     *
     */
    public void startLoading(){
        loadStudents();
        loadTeachers();
        loadSubjects();
        loadPeriods();
        //new disClass();
    }

    /**
     *
     * @param s
     * @return
     */
    public Student makeStudent(String [] s){
        Student stu = new Student();
        String nm = s[0];
        String snm = s[1];
        String ag = s[2];
        String sx = s[3];
        String h8 = s[4];
        String fnm = s[5];
        String fh8 = s[6];
        String mnm = s[7];
        String mh8 = s[8];
        Human scor = createHuman(nm,snm,sx,h8);
        stu.setAge(Integer.parseInt(ag));
        stu.setStudentCore(scor);
        Human sf = createHuman(fnm.split(" ")[0],fnm.split(" ")[1],"Male",fh8);
        stu.setParentFather(sf);
        Human sm = createHuman(mnm.split(" ")[0],mnm.split(" ")[1],"Female",mh8);
        stu.setParentMother(sm);
        return stu;
    }

    /**
     *
     * @param nm
     * @param snm
     * @param sx
     * @param h8
     * @return
     */
    public Human createHuman(String nm,String snm,String sx,String h8){
        Human scor = new Human();
        scor.setName(nm);
        scor.setSurName(snm);
        scor.setSex(sx);
        scor.setHeight(h8);
        return scor;
    }

    /**
     *
     * @param f
     * @param d1
     * @param d2
     * @return
     */
    public NodeList readDataFromFile(File f,String d1,String d2){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);
            Element rootEle = doc.getDocumentElement();
            if(rootEle.getNodeName().equals(d1)){
                NodeList ulist = rootEle.getElementsByTagName(d2);
                if(ulist!=null && ulist.getLength()>0){
                    return ulist;

                }
            }
        }
        catch(Exception h){
            h.printStackTrace();
        }
        return null;
    }
}