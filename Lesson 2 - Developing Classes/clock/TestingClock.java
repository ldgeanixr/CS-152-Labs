/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author Akzhol Nabiolla
 */
public class TestingClock {
    
    public static void main (String[] args)
    {
        Clock time = new Clock(0,0,0);
        
        time.setHours(9);
        time.setMinutes(9);
        time.setSeconds(19);
        
        
        System.out.println(time.getHours()+":"+time.getMinutes() +":"+time.getSeconds()); // input from user
        System.out.println("Is evening: "+ time.isMorning());
        //time.toSString();
        System.out.println(time);
        
        //System.out.println(time);
        
        time.tick();
         time.tick();
          time.tick();
          
          
        
        //time.toSString();
        System.out.println(time);
        
        time.setHours(5);
        time.setMinutes(5);
        time.setSeconds(5);
        
        time.tick();
         time.tick();
          time.tick();
          
          //time.toSString();
          System.out.println(time);
        
        
        
    }
}
