
package lesson2;

// Akzhol Nabiolla
public class Automobile {
     private boolean engineRunning;
     private double speed;
     private String carType; 
     
     public Automobile (String type){
         carType = type;
         engineRunning = false;
         speed = 0.0;
         
     }
     
     public void startCar() {
         engineRunning = true;
     }
     
     public void pressGasPedal(){
         if (engineRunning)
         {
             speed = speed + 10.0;
         }
         
     }
     
     public void pressBrake()
     {
         speed = 0.0; 
     }
     
     public void shutDown(){
         engineRunning = false;
     }
     
     
     @Override
     public String toString(){
         return "License Type: "+ carType + " Engine running: " + engineRunning + " Current Speed: " + speed;
     }
     
}
     
