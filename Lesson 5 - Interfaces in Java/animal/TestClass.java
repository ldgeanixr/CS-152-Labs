/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author admin
 */
public class TestClass {
    
    
    public static void main (String[] args)
    {
        Animal pig = new Pig("pig");
        Animal dog = new Dog("dog");
        Animal cat = new Cat("cat");
        
        
        for (int i=0;i<6;i++)
        {
            dog.ageOneYear();
        }
        
        System.out.println(dog.animalKind());
        System.out.println(dog.getAge());
        dog.ageOneYear();
        dog.ageOneYear();
        System.out.println(dog.getAge());
        System.out.println(dog.isAlive()+"\n");
        
        
        System.out.println(dog.canEat("Whiskas"));
        System.out.println(dog.canEat("Meat"));
        try
        {
            dog.feed("Whiskas");
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            dog.feed("Meat");
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\n"+dog.makeSound());
        System.out.println(cat.makeSound());
        System.out.println(pig.makeSound()+"\n");

        
        System.out.println(dog.protectHouse());
        System.out.println(cat.protectHouse()+"\n");
        
        System.out.println(dog);
        System.out.println(cat);
        
        
    }
}
