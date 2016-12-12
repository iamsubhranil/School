package com.apsm.school.core;
import java.util.Random;
class Girl{
    public Human createGirl(String name,String surName,String height){
        Human h = new Human();
        h.setName(name);
        h.setSex("Female");
        h.setSurName(surName);
        h.setHeight(height);
        return h;
    }

    public Human createRandomGirl(){
        String [] names = {"Tina","Ayantika","Sreeparna","Titli","Tithi","Neha","Sreyan","Diya","Nirupama",
                "Sree","Tista","Poushani","Manashi","Sompurna","Ankita","Keya","Payel","Piyali","Songhomitra",
                "Priti","Soumali","Tiasa","Piu","Ishika","Diyanka","Diptosree"
            };
        String [] titles = {"Mukherjee","Roy","Chowdhury","Pal","Das","Mondal","Mohanta","Biswas","Mahapatra",
                "Laha","Pramanik","Dey","Saha","Bhattacharya","Chakrabarty","Chatterjee","Ghosh","Sarkar"};
        Random r = new Random();
        int nameNo = r.nextInt(names.length);
        int titleNo = r.nextInt(titles.length);
        String name = names[nameNo];
        String surName = titles[titleNo];
        int h1 = 0;
        while(h1<4){
            h1 = r.nextInt(5);}
        int h2 = r.nextInt(12);
        String height = h1+"'"+h2+"\"";
        Human h = new Human();
        h.setName(name);
        h.setSex("Female");
        h.setSurName(surName);
        h.setHeight(height);
        return h;
    }
}