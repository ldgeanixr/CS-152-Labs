/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_queue;

/**
 *
 * @author admin
 */
public class Palindrome {
    
    public static boolean isPalindrome(Queue<Character> q) throws Exception
    {
        int size = q.getSize();
        boolean flag = true;
        char[] character = new char[size];
        
        for (int i=0; i<size; i++)
        {
            character[i] = q.dequeue();
        }
        
        for (int i=0; i<size/2; i++)
        {
            if (character[i]!=character[size-i-1])
            {
                flag=false;
                break;
            }
        }
        
        for (int i=0; i<size; i++)
        {
            q.enqueue(character[i]);
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
