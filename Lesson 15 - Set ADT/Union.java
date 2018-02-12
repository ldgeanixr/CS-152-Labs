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
public class Union {
    
    public static Set<String> union(Set<String> set1, Set<String> set2)
    {
        Set<String> u = new LLQueueSet();
        String temp;
        
        int size = set1.getSize();
        
        for(int i=0; i<size; i++)
        {
            try
            {
                temp = set1.removeAny();
                set1.add(temp);
                u.add(temp);
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
        size = set2.getSize();
        
        for(int i=0; i<size; i++)
        {
            try
            {
                temp = set2.removeAny();
                set2.add(temp);
                u.add(temp);
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
        return u;
    }
    
    public static void main (String[] args)
    {
        Set<String> set1 = new LLQueueSet();
        set1.add("Larry");
        set1.add("Moe");
        set1.add("Curly");
        
        Set<String> set2 = new LLQueueSet();
        set2.add("Shemp");
        set2.add("Larry");
        set2.add("Joe");
        
        System.out.println(union(set1, set2));
        
    }
}
