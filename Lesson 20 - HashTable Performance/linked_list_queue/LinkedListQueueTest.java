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
public class LinkedListQueueTest {
    
    public static void main (String[] args)
    {
        Queue<Integer> que = new LinkedListQueue();
        
        try
        {
            System.out.println(que.dequeue());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        for (int i=0; i<8; i++)
        {
            que.enqueue(i);
        }
        System.out.println(que);
        
        try
        {
            System.out.println(que.dequeue());
            System.out.println(que.dequeue());
            System.out.println(que.dequeue());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(que);
        
        for (int i=0; i<9; i++)
        {
            que.enqueue(77);
            que.enqueue(77);
            
              try
            {
               System.out.println(que.dequeue());
               System.out.println(que.dequeue());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
        }
        System.out.println(que);
        
        que.clear();
        System.out.println(que);
        
        for (int i=0; i<22; i++)
        {
            que.enqueue(i);
        }
        System.out.println(que);
        
    }
}
