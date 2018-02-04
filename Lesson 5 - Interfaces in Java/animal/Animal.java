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
public interface Animal {
    
    /**
     * returns the kind of animal
     * @return the kind of animal
     */
    public String animalKind();
    
    /**
     * return the age of animal
     * @return the age of animal
     */
    public int getAge();
    
    /**
     * returns true if and only if the animal
     * can eat the given food
     * @param food the name of food
     * @return whether or not the animal can eat the given food
     */
    public boolean canEat (String food);
    
    /**
     * increment the age by one year
     */
    public void ageOneYear();
    
    /**
     * 
     * @return whether animal is alive or not
     */
    public boolean isAlive();
    
    /**
     * attempts to feed the animal with the food
     * @param food to be given
     * @throws Exception if animal can't eat this food
     */
    public void feed(String food) throws Exception;
    
    /**
     * returns the sound that given animal makes
     * @return 
     */
    public String makeSound();
    
    /**
     * returns whether or not the given animal can protect
     * the house from thieves
     * @return boolean value of whether house could be protected by this 
     * animal or not
     */
    public boolean protectHouse();
}
