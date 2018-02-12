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
public class Subset {
    
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2)
    {
        if (set1.getSize()==0)
        {
            return true;
        }
        
        if (set1.getSize()>set2.getSize())
        {
            return false;
        }
        
        int size = set1.getSize();
        int tempV;
        boolean flag = true;
        Set<Integer> tempS = new LLStackSet();
        
        for (int i=0; i<size; i++)
        {
            try
            {
              tempV = set1.removeAny();
              tempS.add(tempV);
              
              if(flag)
            {
                if (!set2.contains(tempV))
                {
                    flag = false;
                }
            }
              
            } catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
        
        for (int i=0; i<size; i++)
        {
            try
            {
                set1.add(tempS.removeAny());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
        return flag;
    }
    
    public static void main (String[] args)
    {
        Set<Integer> set1 = new LLStackSet();
        Set<Integer> set2 = new LLStackSet();
        Set<Integer> set3 = new LLStackSet();
        Set<Integer> set4 = new LLStackSet();
        Set<Integer> set5 = new LLStackSet();
        Set<Integer> set6 = new LLStackSet();
        
        set1.add(-12);
        
        set2.add(8);
        set2.add(33);
        set2.add(5);
        
        set3.add(1);
        set3.add(33);
        set3.add(5);
        set3.add(2);
        
        set4.add(22);
        set4.add(33);
        set4.add(1);
        set4.add(5);
        set4.add(-12);
        set4.add(2);
        set4.add(8);
        
        set5.add(22);
        set5.add(33);
        set5.add(100);
        
        System.out.println(isSubset(set1, set4));
        System.out.println(isSubset(set2, set4));
        System.out.println(isSubset(set3, set4));
        System.out.println(isSubset(set5, set4));
        System.out.println(isSubset(set6, set4)); // empty subset
        
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set4);
        System.out.println(set5);
        
    }
}
