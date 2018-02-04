/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author admin
 */
public class QueueTest {
    
    public static void main (String[] args)
    {
        // IntQueue myQ = new ArrayIntQueue(); why we cant do this?
        // where is polymorhphism?
        
        ArrayIntQueue myQ = new ArrayIntQueue();
        
        try
        {
            System.out.println(myQ.dequeue());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        for (int i=0; i<8; i++)
        {
            myQ.enqueue(i);
        }
        System.out.println(myQ);
        
        for (int i=0; i<3; i++)
        {
            try
            {
                System.out.println(myQ.dequeue());
            } catch(Exception ex)
            {
               System.out.println(ex.getMessage()); 
            }
            
        }
        System.out.println(myQ);
        
        for (int i=0; i<9; i++)
        {
            myQ.enqueue(777);
            myQ.enqueue(777);
            
            try
            {
                System.out.println(myQ.dequeue());
                System.out.println(myQ.dequeue());
            } catch(Exception ex)
            {
               System.out.println(ex.getMessage()); 
            }
            
            System.out.println(myQ); 
        }
        
        myQ.clear();
        System.out.println(myQ); 
        
        for(int i=20; i<42; i++)
        {
            myQ.enqueue(i);
        }
        System.out.println(myQ); 
        
        
    }
}
