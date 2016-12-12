package com.apsm.school.core;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

/**
 *
 * @author Subhra
 */
public class storageCreator{
    static PrintWriter w1;
    static File mainDir;
    static long tot = 0;
    static boolean fn = false;
    static Teacher [] teachers = new Teacher[0];

    /**
     *
     */
    public static void save(){

        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(new File("user.xml"));

            String name = dataStore.getName();
            String username = dataStore.getUserName();
            String sex = dataStore.getSex();
            String pass = dataStore.getPass();
            String school = dataStore.getSchoolName();

            File f0 = new File("Database\\"+username);
            f0.mkdir();
            
            File f01 = new File(f0+"\\"+school);
            mainDir = f01;
            if(f01.isDirectory()){
                delPrev(f01);
            }
            f01.mkdir();

            DOMSource source = new DOMSource(doc);
            if(premitiveData.hasUser(username) || !premitiveData.hasUser(username)){
                Element r1 = doc.createElement("user");
                doc.appendChild(r1);
                Element r2 = doc.createElement("username");
                r2.appendChild(doc.createTextNode(username));
                r1.appendChild(r2);
                Element r3 = doc.createElement("canonicalname");
                r3.appendChild(doc.createTextNode(name));
                r1.appendChild(r3);
                Element r4 = doc.createElement("sex");
                r4.appendChild(doc.createTextNode(sex));
                r1.appendChild(r4);
                Element r5 = doc.createElement("password");
                r5.appendChild(doc.createTextNode(pass));
                r1.appendChild(r5);
                source = new DOMSource(doc);
                result = new StreamResult(new File(f0+"\\user.xml"));
                transformer.transform(source, result);
            }

            File sf = new File(f0+"\\schools.xml");
            if(!sf.exists()){
                doc = docBuilder.newDocument();

                Element se = doc.createElement("schools");
                doc.appendChild(se);
                source = new DOMSource(doc);
                result = new StreamResult(new File(f0+"\\schools.xml"));
                transformer.transform(source, result);
            }

            if(!dataStore.hasSchool(school) || dataStore.hasSchool(school)){
                doc = docBuilder.parse(new FileInputStream(new File(f0+"\\schools.xml")));

                Node rootNode = doc.getFirstChild();
                Element sche = doc.createElement("school");
                sche.appendChild(doc.createTextNode(school));
                rootNode.appendChild(sche);

                source = new DOMSource(doc);
                result = new StreamResult(new File(f0+"\\schools.xml"));
                transformer.transform(source, result);
            }

            if(premitiveData.hasUser(username) || !premitiveData.hasUser(username)){
                File bsf = new File("Database\\base.xml");
                Node rootNode = null;
                if(bsf.exists()){
                    doc = docBuilder.parse(new FileInputStream(new File("Database\\base.xml")));

                    rootNode = doc.getFirstChild();}
                else{
                    doc = docBuilder.newDocument();
                    rootNode = doc.createElement("users");
                    doc.appendChild(rootNode);
                }
                Element sche = doc.createElement("user");
                sche.appendChild(doc.createTextNode(username));
                rootNode.appendChild(sche);

                source = new DOMSource(doc);
                result = new StreamResult(new File("Database\\base.xml"));
                transformer.transform(source, result);
            }

            long distot = 0;
            doc = docBuilder.newDocument();
            classLevel [][] classes = Analyzer.getTotalClass();
            Element root = doc.createElement("classes");
            doc.appendChild(root);
            for(int i = 0;i<12;i++){
                Element clslvl = doc.createElement("class");
                root.appendChild(clslvl);
                clslvl.setAttribute("id",i+"");
                for(int y = 0;y<4;y++){
                    Element sectn = doc.createElement("section");
                    clslvl.appendChild(sectn);
                    sectn.setAttribute("id",i+" "+y);
                    Student [] ss = classes[i][y].getStudents();
                    Element studn = doc.createElement("students");
                    sectn.appendChild(studn);
                    for(int o = 0;o<ss.length;o++){
                        Element indvs = doc.createElement("student");
                        studn.appendChild(indvs);
                        indvs.setAttribute("id",distot+"");
                        Student ts = ss[o];
                        storeStudent(ss[o],indvs,doc);
                        distot++;
                    }
                }
            }
            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            source = new DOMSource(doc);
            result = new StreamResult(new File(mainDir+"\\studentdb.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            Subject [] subjects = Analyzer.getSubjects();
            int tcnt = 0;
            int scnt = 0;

            doc = docBuilder.newDocument();

            DocumentBuilderFactory docFactory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder2 = docFactory2.newDocumentBuilder();
            Document doc2 = docBuilder2.newDocument();

            Element rsub = doc.createElement("subjects");
            doc.appendChild(rsub);

            Element rtchr = doc2.createElement("teachers");
            doc2.appendChild(rtchr);
            for(int b = 0;b<subjects.length;b++){
                Teacher [] teachers = subjects[b].getTeachers();
                String subnm = subjects[b].getSubjectName();
                Element sub = doc.createElement("subject");
                rsub.appendChild(sub);
                sub.setAttribute("id",b+"");
                Element sbnm = doc.createElement("subjectname");
                sbnm.appendChild(doc.createTextNode(subnm));
                sub.appendChild(sbnm);
                for(int u = 0;u<teachers.length;u++){

                    Teacher tt = teachers[u];
                    Element tch = doc2.createElement("teacher");
                    rtchr.appendChild(tch);
                    tch.setAttribute("id",tcnt+"");

                    String tnm = tt.getTeacherCore().getName()+" "+tt.getTeacherCore().getSurName();
                    String h8 = tt.getTeacherCore().getHeight();
                    String ag = tt.getAge()+"";
                    String sx = tt.getTeacherCore().getSex();
                    String [] ds = {"name","height","age","sex"};
                    String [] dat = {tnm,h8,ag,sx};
                    storeElement(ds,dat,tch,doc2);

                    Element stub = doc.createElement("teacher");
                    sub.appendChild(stub);
                    stub.setAttribute("id",tcnt+"");

                    tcnt++;
                }

            }
            source = new DOMSource(doc);
            result = new StreamResult(new File(mainDir+"\\subjectdb.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            source = new DOMSource(doc2);
            result = new StreamResult(new File(mainDir+"\\teacherdb.xml"));
            transformer.transform(source, result);

            Period [][][][] periods = Analyzer.getTotalPeriods();

            doc = docBuilder.newDocument();

            Element rp = doc.createElement("periods");
            doc.appendChild(rp);
            for(int p1 = 0;p1<12;p1++){
                Element c1 = doc.createElement("class");
                rp.appendChild(c1);
                c1.setAttribute("id",p1+"");
                for(int p2 = 0;p2<4;p2++){
                    Element c2 = doc.createElement("section");
                    c2.setAttribute("id",p2+"");
                    c1.appendChild(c2);
                    for(int p3 = 0;p3<6;p3++){
                        Element c3 = doc.createElement("day");
                        c3.setAttribute("id",p3+"");
                        c2.appendChild(c3);
                        for(int p4 = 0;p4<7;p4++){
                            Element c4 = doc.createElement("period");
                            c4.setAttribute("id",p4+"");
                            c3.appendChild(c4);
                            Period ps = periods[p1][p2][p3][p4];
                            int sid = getSubjectId(ps.getSubject(),subjects);
                            int tid = getTeacherId(ps.getTeacher(),ps.getSubject());
                            Element c5 = doc.createElement("subject");
                            c5.setAttribute("id",sid+"");
                            c4.appendChild(c5);
                            Element c6 = doc.createElement("teacher");
                            c6.setAttribute("id",tid+"");
                            c4.appendChild(c6);
                        }
                    }
                }
            }

            source = new DOMSource(doc);
            result = new StreamResult(new File(mainDir+"\\perioddb.xml"));
            transformer.transform(source, result);

            String [] fls = mainDir.list();

            doc = docBuilder.newDocument();

            Element ce = doc.createElement("checksum");
            doc.appendChild(ce);

            for(int i = 0;i<fls.length;i++){
                File f = new File(mainDir+"\\"+fls[i]);
                String nm = f.getName();
                long size = f.length();

                Element nmel = doc.createElement("filename");
                ce.appendChild(nmel);
                nmel.appendChild(doc.createTextNode(nm));

                Element szel = doc.createElement("filesize");
                ce.appendChild(szel);
                szel.appendChild(doc.createTextNode(size+""));
            }

            source = new DOMSource(doc);
            result = new StreamResult(new File(mainDir+"\\checksum.xml"));
            transformer.transform(source, result);

            fn = true;
            //new disClass();
        }
        catch(Exception j){
            System.out.println(j.getMessage());
            j.printStackTrace();
        }
    }

    /**
     *
     * @param s
     * @param ss
     * @return
     */
    public static int getSubjectId(Subject s,Subject [] ss){
        int st = 0;
        for(st = 0;st<ss.length;st++){
            if(ss[st].equals(s)){
                return st;
            }
        }
        return st;
    }

    /**
     *
     * @param t
     * @param s
     * @return
     */
    public static int getTeacherId(Teacher t,Subject s){

        int tc = 0;
        for(tc = 0;tc<s.getTeachers().length;tc++){
            Teacher tt = s.getTeachers()[tc];
            if(tt.equals(t)){
                return tc;
            }
        }
        return tc;
    }

    /**
     *
     * @param s
     * @param e
     * @param d
     */
    public static void storeStudent (Student s,Element e,Document d){
        String nm1 = s.getStudentCore().getName();
        String nm2 = s.getStudentCore().getSurName();
        int ag = s.getAge();
        String sh8 = s.getStudentCore().getHeight();
        String fnm = s.getParentFather().getName()+" "+s.getParentFather().getSurName();
        String fh8 = s.getParentFather().getHeight();
        String mnm = s.getParentMother().getName()+" "+s.getParentMother().getSurName();
        String mh8 = s.getParentMother().getHeight();
        String ssex = s.getStudentCore().getSex();
        String [] des = {"firstname","lastname","age","sex","height","fathername","fatherheight","mothername","motherheight"};
        String [] data = {nm1,nm2,ag+"",ssex,sh8,fnm,fh8,mnm,mh8};
        storeElement(des,data,e,d);
    }

    /**
     *
     * @param des
     * @param data
     * @param e
     * @param d
     */
    public static void storeElement(String [] des,String [] data,Element e,Document d){
        for(int i = 0;i<des.length;i++){
            Element d1 = d.createElement(des[i]);
            d1.appendChild(d.createTextNode(data[i]));
            e.appendChild(d1);
        }
    }

    /**
     *
     * @param f
     */
    public static void delPrev(File f){
        String [] fs = f.list();
        for(int j = 0;j<fs.length;j++){
            File f2 = new File(f+"\\"+fs[j]);
            if(f2.isDirectory()){
                delPrev(f2);
            }
            else{
                f2.delete();
            }
        }
        f.delete();
    }

}