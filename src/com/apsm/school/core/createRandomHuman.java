package com.apsm.school.core;
import java.util.Random;
class createRandomHuman{
    public Human createHuman(){
        Random r2 = new Random();
        int choice = r2.nextInt(2);
        Human h = new Human();
        Boy newBoy = new Boy();
        Girl newGirl = new Girl();
        if(choice==1){
            h = newBoy.createRandomBoy();
        }
        else if(choice==0){
            h = newGirl.createRandomGirl();
        }
        return h;
    }
}