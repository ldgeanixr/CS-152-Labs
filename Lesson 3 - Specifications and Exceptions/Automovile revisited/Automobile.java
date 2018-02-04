
package lesson2;

// @author Akzhol Nabiolla

public class Automobile {
     private boolean engineRunning;
     private double speed;
     private String carType;
     private int maxSpeed = 50;
     
     /**
      * sets the initial value of the @param car
      * @param type type of car
      */
     public Automobile (String type){  
         engineRunning = false;
         speed = 0.0;
         carType = type;
     }
     
     /**
      * Turn on the engine 
      */
     public void startCar() {
         engineRunning = true;
     }
     
     /**
      * Attempts to increase the speed. Throws an exception if the maximum
      * speed is reached or the engine is turned off
      * 
      * @throws Exception 
      */
     public void pressGasPedal() throws Exception{
         if (engineRunning)
         {
             if (speed==maxSpeed)
             {
                 throw new Exception("Can't go beyond speed limit (50km/h)");
             }
             
             else
             {
                 speed = speed + 10.0;
             }
             
         }
         
         else
         {
             throw new Exception("Engine is not running ERROR");
         }
         
     }
     
     /**
      * Stops the car, and sets the speed to 0
      */
     public void pressBrake()
     {
         speed = 0.0; 
     }
     
     /**
      * Turn offs the engine
      */
     public void shutDown(){
         engineRunning = false;
     }
     
     /**
      * Returns the string representation of an object
      * @return 
      */
     @Override
     public String toString(){
         return "Type: "+ carType + " Engine running: " + engineRunning + " Speed: " + speed;
     }
     
}
     
