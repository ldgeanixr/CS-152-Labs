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


public class Clock {
  
    // Fields
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Clock(int h, int m, int s) {
        
        if ((h<24&&h>=0)&& (m>=0 && m<60)&&(s>=0 && s<60))
        {
            hours = h; minutes = m; seconds = s;
        }
        
        else
        {
            hours = 0;
            minutes = 0;
            seconds = 0;
        }
        
    }

    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }

    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }

    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds == 60) {
            
            seconds = 0;
            
            minutes++;
            
            if (minutes == 60)
            {
                minutes = 0;
                
                hours++;
                
                if (hours==24)
                {
                    hours = 0;
                }
            }
        }
    }
    
    public int getHours ()
    {
        return hours;
    }
    
    public int getMinutes ()
    {
        return minutes;
    }
    
    public int getSeconds ()
    {
        return seconds;
    }
    
    public void setHours (int hour)
    {
        if (hour>=0 && hour<24)
        {
           hours = hour; 
        }
    }
    
    public void setMinutes (int minute)
    {
        if (minute>=0 && minute<60)
        {
            minutes = minute;
        }
        
    }
    
    public void setSeconds (int second)
    {
        if (second >=0 && second <60)
        {
            seconds = second;
        }
        
    }
    
    @Override
    public String toString ()
    {
        String str = "";
        if (hours < 10)
        {
            str = str +"0"+hours+":";
        }
        
        else
        {
            str = str + hours +":";
        }
        
        if (minutes < 10)
        {
            str = str +"0"+minutes+":";
        }
        
        else
        {
            str = str + minutes +":";
        }
        
        if (seconds < 10)
        {
            str = str +"0"+seconds;
        }
        
        else
        {
            str = str + seconds;
        }
        
        return str;
        
        
    }

//    public void toSString ()
//    {
//
//        if (hours<10)
//        {
//            System.out.print("0"+hours+":");
//        }
//        
//        else
//        {
//            System.out.print(hours+":");
//        }
//        
//        if (minutes<10)
//        {
//            System.out.print("0"+minutes+":");
//        }
//        
//        else
//        {
//            System.out.print(minutes+":");
//        }
//        
//        if (seconds<10)
//        {
//            System.out.println("0"+seconds);
//        }
//        
//        else
//        {
//            System.out.println(seconds);
//        }
//            
//    }
    
//    public String toString()
//    {
//        return hours+":"+minutes+":"+seconds;
//    }
        
}
    

