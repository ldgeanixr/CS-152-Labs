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
    /**
     * Sets the clock parameters if hours is less than 24
     * and greater than or equal to 0, minutes and seconds are 
     * less than 60, and greater or equal to 0.
     * If any of the above parameters are not in range, clock is 
     * set to midnight and the exception is thrown.
     * @param h hours to set
     * @param m minutes to set
     * @param s seconds to set
     * @throws Exception when h,m or s are not in range
     */
    public Clock(int h, int m, int s) throws Exception {
        
        if ((h<24&&h>=0)&& (m>=0 && m<60)&&(s>=0 && s<60))
        {
            hours = h; minutes = m; seconds = s;
        }
        
        else
        {
            hours = 0;
            minutes = 0;
            seconds = 0;
            
            throw new Exception("Not in range error");
        }
        
    }

    // Reset method
    /**
     * Resets the clock to midnight
     */
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }

    /**
     * checks whether it's morning or evening
     * @return the boolean value
     */
    public boolean isMorning() {
        return hours > 12;
    }

    /**
     * Makes a clock to tick (adding 1 second)
     */
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
    
    /**
     * Current value of the hours is being returned
     * @return hours
     */
    public int getHours ()
    {
        
        return hours;
    }
    
    
    /**
     * Current value of the minutes is being returned
     * @return minutes
     */
    public int getMinutes ()
    {
        return minutes;
    }
    
    /**
     * Current value of the seconds is being returned
     * @return seconds
     */
    public int getSeconds ()
    {
        return seconds;
    }
    
    /**
     * Sets the value of hour if param>=0 && param<24, otherwise
     * does not change anything and throws an exception   
     * @param hours
     * @throws Exception if hours is not in range
     */
    public void setHours (int hours) throws Exception
    {
        if (hours>=0 && hours<24)
        {
           this.hours = hours; 
        }
        
        else
        {
            throw new Exception("Hours not in range error");
        }
        
        
    }
    
    /**
     * Sets the value of minutes if param>=0 && param<60, otherwise
     * does not change anything and throws an exception   
     * @param minutes
     * @throws Exception if minutes is not in range
     */
    public void setMinutes (int minutes) throws Exception
    {
        if (minutes>=0 && minutes<60)
        {
            this.minutes = minutes;
        }
        
        else
        {
            throw new Exception("Minutes not in range error");
        }
        
    }
    
    /**
     * Sets the value of seconds if param>=0 && param<60, otherwise
     * does not change anything and throws an exception   
     * @param seconds
     * @throws Exception if seconds is not in range
     */
    public void setSeconds (int seconds) throws Exception
    {
        if (seconds >=0 && seconds <60)
        {
            this.seconds = seconds;
        }
        
        else
        {
            throw new Exception("Seconds not in range error");
        }
        
    }
    
    /**
     * 
     * @return the string representation of an object
     */
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
        
}
    

