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
public class MergeSort {
    
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) 
            throws Exception {
	/* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
        
        Deque<Integer> newdq = new LinkedListDeque();
        
        int num1 = d1.popFromFront();
        int num2 = d2.popFromFront();
        
        for (int i=0; ;i++)
        {
            if (num1<=num2)
            {
                newdq.pushToBack(num1);
                
                try
                {
                    num1 = d1.popFromFront();
                } catch(Exception ex)
                {
                    for (i=0; ;i++)
                    {
                        newdq.pushToBack(num2);
                        
                        try{
                            num2 = d2.popFromFront();
                        } catch (Exception rex)
                        {
                            break;
                        }
                    }
                    
                    break;
                }
            } else
            {
                newdq.pushToBack(num2);
                
                try
                {
                    num2 = d2.popFromFront();
                } catch(Exception ex)
                {
                    for (i=0; ;i++)
                    {
                        newdq.pushToBack(num1);
                        
                        try{
                            num1 = d1.popFromFront();
                        } catch (Exception d2ex)
                        {
                            break;
                        }
                    }
                    
                    break;
                }
            }
            
            
        }
        
        return newdq;
    } 


    public static Deque<Integer> mergeSort(Deque<Integer> deq1) throws Exception {
        /* Step 0:  base case???
           Step 1:  split deq into two Deques of relatively equal size
           Step 2:  pass both of these Deques into mergeSort
           Step 3:  pass the resulting Deques into merge, and return the result
        */
        
        if (deq1.getSize()==1)
        {
            return deq1;
        }
        
        Deque<Integer> deq2 = new LinkedListDeque();
        
        int size = deq1.getSize();
        for (int i=0; i<size/2 ; i++)
        {
            deq2.pushToFront(deq1.popFromBack());
        }
        
        deq1 = mergeSort(deq1);
        deq2 = mergeSort(deq2);
        
        
        return merge(deq1, deq2);
    } 
    
    public static void main (String[] args) throws Exception
    {
        Deque<Integer> dq = new LinkedListDeque();
        dq.pushToBack(10);
        dq.pushToBack(1);
        dq.pushToBack(3);
        dq.pushToBack(-5);
        dq.pushToBack(9);
        dq.pushToBack(2);
        dq.pushToBack(3);
        dq.pushToBack(4);
        dq.pushToBack(15);
        
        
        
        dq = mergeSort(dq);
        
        System.out.println(dq);
    }
}
