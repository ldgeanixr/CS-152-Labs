package lesson2;

// Akzhol Nabiolla
public class Lesson2 {


    public static void main(String[] args) {
        
        Automobile car1 = new Automobile("car1");
        Automobile car2 = new Automobile("car2");
        
       
        car1.startCar();
        car2.startCar();
        
        car1.pressGasPedal();
        car2.pressGasPedal();
        car1.pressGasPedal();
        
        System.out.println(car1);
        System.out.println(car2);  
        
        car1.pressBrake();
        car2.pressGasPedal();
        car2.shutDown();
        
        System.out.println(car1);
        System.out.println(car2); 
    }
    
}
