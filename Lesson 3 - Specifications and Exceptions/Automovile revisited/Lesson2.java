package lesson2;

// @author Akzhol Nabiolla


public class Lesson2 {


    public static void main(String[] args) {
        
        Automobile car1 = new Automobile("car1");
        Automobile car2 = new Automobile("car2");
        
       
        //car1.startCar();
        car2.startCar();
        
        try
        {
            car1.pressGasPedal();
            car1.pressGasPedal();
            car1.pressGasPedal();
            car1.pressGasPedal();
            car1.pressGasPedal();
            car1.pressGasPedal();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        try
        {
            car2.pressGasPedal();
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println(car1);
        System.out.println(car2);  
        
        car1.pressBrake();
        car2.shutDown();
        
        System.out.println(car1);
        System.out.println(car2); 
    }
    
}
