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
public class BSTSetTwoMethodsTest {
    
    public static void main (String[] args)
    {
        Set<Integer> set = new BSTSet();
        
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
        
        set.add(12);
        set.add(7);
        set.add(2);
        set.add(-8);
        set.add(5);
        System.out.println(set);
        
        set.clear();
        System.out.println(set);
        
        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);
        
    }
}
