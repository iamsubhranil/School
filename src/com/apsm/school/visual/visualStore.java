package com.apsm.school.visual;

import java.awt.*;
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
public class visualStore{

    /**
     *
     */
    public static void saveCurrentScheme(){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            File f = new File("Database\\visuals");
            int l = 0;
            if(f.isDirectory()){
                l = f.list().length;
            }
            else{
                f.mkdir();
            }
            File toSave = new File("Database\\visuals\\visual"+l+".xml");
            StreamResult result = new StreamResult(toSave);
            Color [] cols = visualData.getColors();
            boolean trans = visualData.getTransitionState();
            String nm = visualData.getCurrentScheme().getName();
            String fnt = visualData.getCurrentScheme().getFont();
            Element r1 = doc.createElement("colordetails");
            doc.appendChild(r1);

            Element cnm = doc.createElement("schemename");
            cnm.appendChild(doc.createTextNode(nm));
            r1.appendChild(cnm);

            Element te = doc.createElement("transitionenable");
            te.appendChild(doc.createTextNode(trans+""));
            r1.appendChild(te);

            Element fn = doc.createElement("fontfamilyname");
            fn.appendChild(doc.createTextNode(fnt));
            r1.appendChild(fn);

            for(int i = 0;i<cols.length;i++){
                Element th = doc.createElement("color");
                th.setAttribute("position",i+"");
                saveColor(th,doc,cols[i]);
                r1.appendChild(th);
            }
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            doc = docBuilder.newDocument();

            Element lastused = doc.createElement("lastused");
            doc.appendChild(lastused);

            Element visualId = doc.createElement("scheme");
            visualId.appendChild(doc.createTextNode(toSave.getName()));
            lastused.appendChild(visualId);

            result = new StreamResult(new File("Database\\lastused.xml"));
            source = new DOMSource(doc);
            transformer.transform(source, result);
        }
        catch(Exception h){
            System.out.println(h);
            h.printStackTrace();
        }
    }

    /**
     *
     */
    public static void loadAllSchemes(){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            File f = new File("Database\\visuals");
            String [] vnm = f.list();
            for(int i = 0;i<vnm.length;i++){
                File f2 = new File(f+"\\"+vnm[i]);
                visualData.addScheme(loadScheme(f2,docBuilder));
            }
        }
        catch(Exception h){
            h.printStackTrace();
        }
    }

    /**
     *
     */
    public static void loadLastUsed(){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            File f = new File("Database\\lastused.xml");
            Document d = docBuilder.parse(f);
            Element re = d.getDocumentElement();
            NodeList nle = re.getChildNodes();
            String fnm = nle.item(0).getChildNodes().item(0).getNodeValue();
            File f2 = new File("Database\\visuals\\"+fnm);
            Scheme ts = loadScheme(f2,docBuilder);
            visualData.setCurrentScheme(ts);
        }
        catch(Exception j){}
    }

    /**
     *
     * @param f
     * @param db
     * @return
     */
    public static Scheme loadScheme(File f,DocumentBuilder db){
        try{
            Document d = db.parse(f);
            Element e = d.getDocumentElement();
            NodeList nle = e.getChildNodes();
            String [] dt = new String[3];
            for(int i = 0;i<3;i++){

                dt[i] = nle.item(i).getChildNodes().item(0).getNodeValue();

            }
            String nm = dt[0];
            boolean tr = false;
            String fnm = dt[2];
            if(dt[1].equals("true")){
                tr = true;
            }
            Color [] cls = new Color[nle.getLength()-2];
            int cnt = 0;
            for(int j = 3;j<nle.getLength();j++){
                NodeList clist = nle.item(j).getChildNodes();
                String [] cval = new String[3];
                for(int g = 0;g<clist.getLength();g++){
                    cval[g] = clist.item(g).getChildNodes().item(0).getNodeValue();
                }
                cls[cnt] = makeColorFromString(cval);
                cnt++;
            }
            Scheme s = new Scheme(nm,cls,tr,fnm);
            return s;
        }
        catch(Exception j){
            j.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param p
     * @return
     * @throws NumberFormatException
     */
    public static Color makeColorFromString (String [] p) throws NumberFormatException{
        int r = Integer.parseInt(p[0]);
        int g = Integer.parseInt(p[1]);
        int b = Integer.parseInt(p[2]);

        return new Color(r,g,b);
    }

    /**
     *
     * @param re
     * @param d
     * @param c
     */
    public static void saveColor(Element re,Document d,Color c){
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();

        Element r1 = d.createElement("red");
        r1.appendChild(d.createTextNode(r+""));
        re.appendChild(r1);

        Element g1 = d.createElement("green");
        g1.appendChild(d.createTextNode(g+""));
        re.appendChild(g1);

        Element b1 = d.createElement("blue");
        b1.appendChild(d.createTextNode(b+""));
        re.appendChild(b1);
    }
}