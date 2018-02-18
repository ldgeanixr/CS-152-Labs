/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_queue;

import linked_list_stack.LinkedListStack;
import linked_list_stack.Stack;

/**
 *
 * @author admin
 */
public class Palindrome {
    
    public static boolean isPalindrome(Queue<Character> q) throws Exception
    {
        Stack<Character> s = new LinkedListStack();
        
        int size = q.getSize();
        
        if (size==0)
        {
            return true;
        }
        
        boolean flag = false;
        
        for (int i=0; i<size; i++)
        {
            char temp = q.dequeue();
            s.push(temp);
            q.enqueue(temp);
        }
        
        for (int i=0; i<(size/2); i++)
        {
            char temp = q.dequeue();
            if (temp == s.pop())
            {
                flag = true;
            }
            
            q.enqueue(temp);
        }
        
        for (int i=0; i<size-size/2; i++)
        {
            q.enqueue(q.dequeue());
        }

        return flag;    
    }
    
    public static void main (String[] args) throws Exception
    {
        Queue<Character> word = new LinkedListQueue();
        
        for (char i='A'; i<'I'; i++)
        {
            word.enqueue(i);
        }
        
        System.out.println(isPalindrome(word));
        System.out.println(word);
        word.clear();
        
        word.enqueue('A');
        word.enqueue('K');
        word.enqueue('Z');
        word.enqueue('H');
        word.enqueue('O');
        word.enqueue('L');
        word.enqueue('O');
        word.enqueue('H');
        word.enqueue('Z');
        word.enqueue('K');
        word.enqueue('A');
        
        
        System.out.println(isPalindrome(word));
        System.out.println(word);
        word.clear();   
    }
}
