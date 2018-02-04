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
public class Merge {
    
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
    
    public static IntStack merge(IntStack s1, IntStack s2) throws Exception
    {
        int first = s1.pop(), second = s2.pop();
        int size = (s1.getSize()>s2.getSize())?s1.getSize():s2.getSize();
        
        IntStack tempStk = new ArrayIntStack();
        
        for (int i=0; i<size*size; i++)
        {
 
            if (first>=second)
            {
                tempStk.push(second);
                try
                {
                    second = s2.pop();
                } catch(Exception ex)
                {
                    for (;i<=size*size;i++)
                    {
                        try
                        {
                           tempStk.push(first); 
                            first = s1.pop();
                        } catch (Exception s1ex)
                        {
                            break;
                        }  
                    }
                    break;
                }   
            }
            
            else
            {
                tempStk.push(first);
                try{
                    first = s1.pop();
                }catch (Exception ex)
                {
                    for (;i<=size*size;i++)
                    {
                        try
                        {
                            tempStk.push(second);
                            second = s2.pop();
                        }catch (Exception s2ex)
                        {
                            break;
                        }
                        
                    }
                    break;
                }
            }
        }
        
        return tempStk;
    }
    
    public static void main (String[] args) throws Exception
    {
        IntStack stk1 = new ArrayIntStack();
        IntStack stk2 = new ArrayIntStack();
        
//        for (int i=1; i<10; i = i + 2)
//        {
//            stk1.push(i); // stk1 odd
//            stk2.push(i-1); // stk2 even
//        }
        stk1.push(0);
        stk1.push(2);
        stk1.push(7);
        stk1.push(8);
        stk2.push(3);
        stk2.push(4);
        stk2.push(5);
        stk2.push(6);
        
        
        
        reverseStack(stk1);
        reverseStack(stk2);
        
        System.out.println(stk1);
        System.out.println(stk2);
        
        IntStack sortMergeStack = merge(stk1, stk2);
        System.out.println(sortMergeStack);
        System.out.println ("stk1 "+stk1);
        System.out.println ("stk2 "+stk2);
        
    }
}
