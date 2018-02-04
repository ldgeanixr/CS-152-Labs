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
public class ReverseQueue {
    
    public static void reverseQueue(Queue<Integer> toRev)
    {
        Stack<Integer> stk = new ArrayStack();
        
        int size = toRev.getSize();
        for(int i=0; i<size; i++)
        {
            try{
                stk.push(toRev.dequeue());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
        
        for (int i=0; i<size; i++)
        {
            try
            {
                toRev.enqueue(stk.pop());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    public static void main (String[] args)
    {
        Queue que = new ArrayQueue();
        
        for (int i=0; i<=20; i++)
        {
            que.enqueue(i);
        }
        
        System.out.println(que);
        
        reverseQueue(que);
        
        System.out.println(que);
        
    }
}
