/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_and_queue_practice;

import queue.ArrayIntQueue;
import queue.IntQueue;
import stack.IntStack;
import stack.ArrayIntStack;

/**
 *
 * @author admin
 */
public class  ReverseStack{
    
    public static void reverseStack(IntStack toRev)
    {
        IntQueue que = new ArrayIntQueue();
        int size = toRev.getSize();
        
        for(int i=0; i<size;i++)
        { 
            try
            {
                que.enqueue(toRev.pop());
            } catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        
        for(int i=0; i<size;i++)
        {
            try
            {
               toRev.push(que.dequeue()); 
            } catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }   
        }
         
    }
    
    public static void main (String[] args)
       {
            IntStack toRev = new ArrayIntStack();
            
            for (int i=0; i<=18; i++)
            {
                toRev.push(i);
            }
            
            reverseStack(toRev);
            
            System.out.println(toRev);
       }
}
