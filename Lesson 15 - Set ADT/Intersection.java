/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_project;

/**
 *
 * @author admin
 */
public class Intersection {
    
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2)
    {
        int size = (set1.getSize()<set2.getSize())?set1.getSize():set2.getSize();
        
        Set<Integer> intrsct = new LLQueueSet();
        
        if (size==0)
        {
            return intrsct;
        }
        
        int temp;
        
        if (set1.getSize()<set2.getSize())
        {
            size = set1.getSize();
            
            for (int i=0; i<size; i++)
            {
                try
                {
                    temp = set1.removeAny();
                    set1.add(temp);
                    
                    if (set2.contains(temp))
                    {
                        intrsct.add(temp);
                    }
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
            }
            
        } else
        {
            size = set2.getSize();
            
            for (int i=0; i<size; i++)
            {
                try
                {
                    temp = set2.removeAny();
                    set2.add(temp);
                    
                    if (set1.contains(temp))
                    {
                        intrsct.add(temp);
                    }
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
            }
        }
        
        return intrsct;
    }
    
    
    public static void main (String[] args)
    {
        Set<Integer> set1 = new LLQueueSet();
        set1.add(8);
        set1.add(33);
        set1.add(5);
        
        Set<Integer> set2 = new LLQueueSet();
        set2.add(1);
        set2.add(33);
        set2.add(5);
        set2.add(2);
        
        Set<Integer> set3 = new LLQueueSet();
        set3.add(16);
        set3.add(45);
        set3.add(3);
        set3.add(-18);
        
        Set<Integer> set4 = new LLQueueSet();
        
        System.out.println(intersection(set1, set2));
        System.out.println(intersection(set3, set2));
        System.out.println(intersection(set4, set2)); // empty set parameter
        
        
        
    }
}
