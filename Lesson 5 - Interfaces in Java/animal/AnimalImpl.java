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
public class AnimalImpl implements Animal {

     private int age;
     private int maxAge = 7;
     protected boolean isAlive = true;
     private String animal;
    
     
    public AnimalImpl(String animal)
    {
        this.animal = animal;
    }
    
    @Override
    public String animalKind() {
        return animal;
    }

    @Override
    public int getAge() {
       return age;
    }

    @Override
    public boolean canEat(String food) {
        if(food.equals("Food"))
        {
            return true;
        } 
        return false;
    }

    @Override
    public void ageOneYear() {
        age++;
        
        if (age > maxAge)
        {
            isAlive = false;
        }
        
        else
        {
            isAlive = true;
        }
    }
    
    @Override
    public boolean isAlive()
    {
        return isAlive;
    }
    

    @Override
    public void feed(String food) throws Exception
    {
        if (food.equals("Food"))
        {
            System.out.println("MUNCH, MUNCH");
        }
        
        else
        {
            throw new Exception("can't feed");
        }
    }

    @Override
    public String makeSound() {
         switch (this.animal) {
             case "cat":
                 return "Meow Meow";
          
             case "pig":
                 return "Hru Hru";
                 
             default:
                 return "Gav Gav";
                 
         }
    }

    @Override
    public boolean protectHouse() {
       
        if (animal.equals("dog"))
        {
            return true;
        }
        
        return false;
    }

    
    
}
