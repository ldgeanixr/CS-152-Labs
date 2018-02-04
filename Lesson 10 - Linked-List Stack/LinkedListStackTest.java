/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_stack;

/**
 *
 * @author admin
 */
public class LinkedListStackTest {
    
    public static void main (String[] args) 
    {
        Stack<Integer> stk = new LinkedListStack();
        
        try{
            System.out.println(stk.pop());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        for (int i=1; i<=12; i++)
        {
            stk.push(i);
        }
        System.out.println(stk);
        
        try{
            System.out.println(stk.pop());
            System.out.println(stk.pop());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(stk);
        
        stk.clear();
        System.out.println(stk);
        
        for (int i=100; i<122; i++)
        {
            stk.push(i);
        }
        System.out.println(stk);
    }
}
