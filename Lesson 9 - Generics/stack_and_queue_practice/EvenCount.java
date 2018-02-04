/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_and_queue_practice;

import stack.ArrayStack;
import stack.Stack;

/**
 *
 * @author admin
 */
public class EvenCount {
    
    public static int evenCount(Stack<Integer> stk)
    {
        Stack<Integer> temp = new ArrayStack();
        
        int count=0, size = stk.getSize(), element;
        
        for (int i=0; i<size; i++)
        {
            try
            {
                element = stk.pop();
                temp.push(element);
                
//                System.out.println(stk);
//                System.out.println(temp);
                
                if (element%2==0)
                {   
                    count++;
                }
                
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        
    }
        
        for (int i=0; i<size; i++)
        {
            try
            {
                stk.push(temp.pop());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
        
        return count;
    }
    
    public static void main (String[] args)
    {
     
        Stack<Integer> stk = new ArrayStack();
        Stack<Integer> temp = new ArrayStack();
        
        for (int i=1; i<=10; i++)
        {
            stk.push(i);
        }
        
        System.out.println(evenCount(stk));
       
        
        System.out.println(stk);
    }
    
}
