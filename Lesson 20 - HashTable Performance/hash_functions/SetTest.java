/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_functions;

/**
 *
 * @author admin
 */
public class SetTest {
    
    public static void tester(HashTableSet<Integer> set)
    {
        for (int i=0; i<100; ++i)
        {
            set.add(i);
        }
        
        System.out.println(set);
        System.out.println(set.getLoadFactor());
    }
    
    public static void main (String[] args)
    {
        BSTHashTableSet<Integer> set1 = new BSTHashTableSet(10);
        LLQHashTableSet<Integer> set2 = new LLQHashTableSet(10);
        
        tester(set1);
        tester(set2);
    }
    
}
