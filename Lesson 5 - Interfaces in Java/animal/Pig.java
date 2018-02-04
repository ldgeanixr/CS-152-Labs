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
public class Pig extends AnimalImpl {
    
    private String animal;
    
    public Pig(String animal)
    {
        super(animal);
       // this.animal = animal;
    }

    @Override
    public boolean canEat(String food) {
        if(food.equals("PigFood"))
        {
            return true;
        } 
        return false;
    }

    @Override
    public void feed(String food) throws Exception
    {
        if (food.equals("PigFood"))
        {
            System.out.println("Hru, Hru, Tasty");
        }
        
        else
        {
            throw new Exception("can't feed");
        }
    }

    
    @Override
    public String toString ()
    {
        return "A pig whose age is "+getAge();
    }
    
}

