/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_tables;

/**
 *
 * @author admin
 */
public class LLQHashTableSetTEST {
    
    public static void main (String[] args)
    {
        Set<Integer> set = new LLQHashTableSet(10);
        
        try
        {
            System.out.println(set.removeAny());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        for (int i=1; i<=20; ++i)
        {
            set.add(i);
        }
        System.out.println(set);
        
        
        for (int i=2; i<=20; i=i+2)
        {
            set.remove(i);
        }
        System.out.println(set);
        
        System.out.println(set.remove(10));  //false
        System.out.println(set.remove(100));  // false
        System.out.println(set);
        
        for (int i=1; i<=30; ++i)
        {
            set.add(i);
        }
        System.out.println(set); 
        
        for (int i=0; i<10; i++)
        {
            try
            {
                System.out.println(set.removeAny());
                System.out.println(set); 
            } catch (Exception ex)
            {    
                System.out.println(ex.getMessage());
            }
        }
        
        set.clear();
        System.out.println(set);
        
        for (int i=51; i<=80; i=i+2)
        {
            set.add(i);
        }
        System.out.println(set); 
        
    }
}
