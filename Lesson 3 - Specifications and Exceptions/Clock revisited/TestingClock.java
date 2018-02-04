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
    try
    {
            Clock time = new Clock(0,0,0); 
            
            try
        {
            time.setHours(59);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            time.setMinutes(62);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            time.setSeconds(73);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        
        System.out.println(time.getHours()+":"+time.getMinutes() +":"+time.getSeconds());
        System.out.println("Is evening: "+ time.isMorning());
        System.out.println(time);
        
        time.tick();
         time.tick();
          time.tick();
          
          
        
        System.out.println(time);
        

        
        time.tick();
         time.tick();
          time.tick();
          
        System.out.println(time);
        
        
        
            
            
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
            
    
        
        
    }
}
