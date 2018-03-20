/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_tree;

/**
 *
 * @author admin
 */
public class BST2SetTest {
    
    public static void main (String[] args)
    {
        Set<Integer> set = new BST2Set();
        
        set.add(5);
        set.add(12);
        set.add(3);
        set.add(6);
        set.add(14);
        set.add(2);
        set.add(-6);
        set.add(8);
        set.add(0);
        System.out.println(set);
        
        set.add(14);
        set.add(-6);
        set.add(5);
        System.out.println(set);
        
        System.out.println(set.contains(12)); //true
        System.out.println(set.contains(7));//false
        System.out.println(set.contains(2));//true
        System.out.println(set.contains(-8));//false
        System.out.println(set.contains(5));//true
        System.out.println(set);
        
        set.remove(0);
        set.remove(6);
        set.remove(3);
        System.out.println(set);
        
        set.add(6);
        set.add(13);
        set.add(99);
        set.add(11);
        System.out.println(set);
        
        set.remove(12);
        System.out.println(set);
        
        set.remove(5);
        System.out.println(set);
        
        // not working, internet solution
        try
        {
            System.out.println(set.removeAny());
            System.out.println(set);
            System.out.println(set.removeAny());
            System.out.println(set);
            System.out.println(set.removeAny());
            System.out.println(set);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        set.clear();
        System.out.println(set);
        
        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);
    }
}
