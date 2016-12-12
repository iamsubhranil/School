package com.apsm.school.core;
import java.util.Random;
class Boy{
    public Human createBoy(String name,String surName,String height){
        Human h = new Human();
        h.setName(name);
        h.setSex("Male");
        h.setSurName(surName);
        if(height.equals("random")){
            Random r = new Random();
            int h1 = 0;
            while(h1<5){
                h1 = r.nextInt(7);}
            int h2 = r.nextInt(12);
            height = h1+"'"+h2+"\"";
        }
        h.setHeight(height);
        return h;
    }

    public Human createRandomBoy(){
        String [] names = {"Subhranil","Subhra","Nil","Gaurab","Ayan",
                "Sayan","Suman","Sourodeep","Surjo","Subhankar","Arko","Arkoprava","Aniket","Joy","Tathagata",
                "Aditya","Ankit","Anirban","Biswarup",
                "Badal","Abhirup","Jit","Jeet","Kishan","Santunu"};
        String [] titles = {"Mukherjee","Roy","Chowdhury","Pal","Das","Mondal","Mohanta","Biswas","Mahapatra",
                "Laha","Pramanik","Dey","Saha","Bhattacharya","Chakrabarty","Chatterjee","Ghosh","Sarkar"};
        Random r = new Random();
        int nameNo = r.nextInt(names.length);
        int titleNo = r.nextInt(titles.length);
        String name = names[nameNo];
        String surName = titles[titleNo];
        int h1 = 0;
        while(h1<5){
            h1 = r.nextInt(7);}
        int h2 = r.nextInt(12);
        String height = h1+"'"+h2+"\"";
        Human h = new Human();
        h.setName(name);
        h.setSex("Male");
        h.setSurName(surName);
        h.setHeight(height);
        return h;
    }
}