/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_sorted_queue;

/**
 *
 * @author admin
 */
public class LinkedListSortedQueueTest {
    
    public static void main (String[] args)
    {
        SortedQueue<Integer> sq = new LinkedListSortedQueue();
        
        for (int i=90; i>=10; i = i - 10)
        {
            sq.insert(i);
        }
        System.out.println(sq);
        
        try
        {
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(sq);
        
        for (int i=100 ; i<=900; i=i+100)
        {
            sq.insert(i);
        }
        System.out.println(sq);
        
        try
        {
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(sq);
        
        for (int i=5 ; i<=915; i=i+10)
        {
            sq.insert(i);
        }
        System.out.println(sq);
        
        int size = sq.getSize();
        for (int i=0; i<size;i++)
        {
                try
            {
                System.out.println(sq.dequeue());
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(sq);
        
        sq.insert(5);
        sq.insert(4);
        sq.insert(6);
        sq.insert(5);
        System.out.println(sq);
        
        sq.clear();
        System.out.println(sq);
        
        sq.insert(5);
        sq.insert(4);
        sq.insert(3);
        sq.insert(6);
        System.out.println(sq);
        
        
        
        
        
        
    }
}
