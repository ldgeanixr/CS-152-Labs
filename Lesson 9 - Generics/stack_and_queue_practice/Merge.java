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
public class Merge {
    
    public static void reverseStack(Stack<Integer> toRev)
    {
        Queue<Integer> que = new ArrayQueue();
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
    
    public static Stack merge(Stack<Integer> s1, Stack<Integer> s2)
    {
        int first=0, second=0;
        int size = (s1.getSize()>s2.getSize())?s1.getSize():s2.getSize();
        
        Stack<Integer> tempStk = new ArrayStack();
        
        for (int i=0; i<size; i++)
        {
            try
            {
                first = s1.pop();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
            try
            {
                 second = s2.pop();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
            if (first>second)
            {
                tempStk.push(second);
                tempStk.push(first);
            }
            
            else
            {
                tempStk.push(first);
                tempStk.push(second);
            }
        }
        
        return tempStk;
    }
    
    public static void main (String[] args)
    {
        Stack<Integer> stk1 = new ArrayStack();
        Stack<Integer> stk2 = new ArrayStack();
        
        
//        for (int i=1; i<10; i = i + 2)
//        {
//            stk1.push(i); // stk1 odd
//            stk2.push(i-1); // stk2 even
//        }
        
        stk1.push(2);
        stk1.push(3);
        stk1.push(4);
        stk1.push(5);
        stk2.push(0);
        stk2.push(1);
        stk2.push(2);
        stk2.push(3);
        
        
        
        System.out.println(stk1);
        System.out.println(stk2);
        
        reverseStack(stk1);
        reverseStack(stk2);
        
//        System.out.println(stk1);
//        System.out.println(stk2);
        
        Stack<Integer> sortMergeStack = merge(stk1, stk2);
        System.out.println(sortMergeStack);
        
    }
}
