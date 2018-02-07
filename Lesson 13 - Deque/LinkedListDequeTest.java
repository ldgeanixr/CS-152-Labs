/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_deque;

/**
 *
 * @author admin
 */
public class LinkedListDequeTest {
    
    public static void main (String[] args)
    {
        Deque<Integer> dq = new LinkedListDeque();
        
        try
        {
            dq.popFromBack();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            dq.popFromFront();
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(dq);
        
        //Pushes 5 items to the front of the deque
        for (int i = 50; i<55; i++)
        {
            dq.pushToFront(i);
            System.out.println(dq);
        }
        
        //Pops the 5 items from the front of the deque
        try
        {
            for (int i=0; i<5; i++)
            {
                System.out.println(dq.popFromFront());
                System.out.println(dq);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //Pushes 6 items to the front of the deque
        for (int i = 55; i<61; i++)
        {
            dq.pushToFront(i);
            System.out.println(dq);
        }
        
        //Pops the 6 items from the back of the deque
        try
        {
            for (int i=0; i<6; i++)
            {
                System.out.println(dq.popFromBack());
                System.out.println(dq);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //Pushes 7 items to the back of the deque
        for (int i = 61; i<68; i++)
        {
            dq.pushToBack(i);
            System.out.println(dq);
        }
        
        //Pops the 7 items from the back of the deque
        try
        {
            for (int i=0; i<7; i++)
            {
                System.out.println(dq.popFromBack());
                System.out.println(dq);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //Pushes 8 items to the back of the deque
        for (int i = 68; i<76; i++)
        {
            dq.pushToBack(i);
            System.out.println(dq);
        }
        
        //Pops the 8 items from the front of the deque
        try
        {
            for (int i=0; i<8; i++)
            {
                System.out.println(dq.popFromFront());
                System.out.println(dq);
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        //Pushes an item to the front, and then to the back, and print the contents and resulting size
        for (int i = 0; i<10; i++)
        {
            dq.pushToFront(18);
            dq.pushToBack(19);
        }
        System.out.println(dq);
                    

        
        //Pops an item from the front, and then from the back, and print the contents and resulting size
        try
        {
            for (int i=0; i<8; i++)
            {
                System.out.println(dq.popFromFront());
                System.out.println(dq.popFromBack());
            }
        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(dq);
        
        dq.clear();
        System.out.println(dq);
        
        dq.pushToFront(0);
        dq.pushToFront(9);
        dq.pushToFront(5);
        dq.pushToFront(7);
        dq.pushToFront(7);
        dq.pushToFront(8);
        dq.pushToBack(8);
        dq.pushToBack(5);
        dq.pushToBack(2);
        dq.pushToBack(5);
        dq.pushToBack(1);
        System.out.println(dq);
        

        
        
    }
}
