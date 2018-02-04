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
public class ReverseQueue {
    
    public static void reverseQueue(IntQueue toRev)
    {
        IntStack stk = new ArrayIntStack();
        
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
        IntQueue que = new ArrayIntQueue();
        
        for (int i=0; i<=20; i++)
        {
            que.enqueue(i);
        }
        
        System.out.println(que);
        
        reverseQueue(que);
        
        System.out.println(que);
        
    }
}
