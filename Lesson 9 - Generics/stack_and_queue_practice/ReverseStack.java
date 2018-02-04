/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_and_queue_practice;

import queue.ArrayQueue;
import queue.Queue;
import stack.Stack;
import stack.ArrayStack;

/**
 *
 * @author admin
 */
public class  ReverseStack{
    
    public static void reverseStack(Stack<Integer> toRev)
    {
        Queue que = new ArrayQueue();
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
               toRev.push((int)que.dequeue()); 
            } catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
         
    }
    
    public static void main (String[] args)
       {
            Stack<Integer> toRev = new ArrayStack();
            
            for (int i=0; i<=18; i++)
            {
                toRev.push(i);
            }
            System.out.println(toRev);
            reverseStack(toRev);
            
            System.out.println(toRev);
       }
}
