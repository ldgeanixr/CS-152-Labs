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
public class ArrayIntQueue implements IntQueue {
    
    private int[] values;
    private int size;
    private int front;
    private int back;
    private int max;
    
    
    public ArrayIntQueue ()
    {
        max = 5;
        values = new int[max];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(int value) {

            /**
             * increases the capacity if out of space
             */
            if ((back==max && front==0)||(back%max==front)) // esli net mesta
            {
                int[] temp = new int[max*2];
                
                for (int i=0, trash = front; i!=size; i++,trash++ )
                {
                    temp[i] = values[trash%max];
                    
                }
                
                values = temp;
                max = max * 2;
            }
           
                values[back%max]=value;
                back++;
                size++;
 
    }

    @Override
    public int dequeue() throws Exception {
        
        if (size!=0)
        {
            int result = values[front%max];
            front++;
            size--;
            return result;
        }
        
        else
        {
            throw new Exception("Queue is EMPTY");
        }
        
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        max = 5;
        values = new int[max];
        size = 0;
        front = 0;
        back = 0;
    }
    
    @Override
    public String toString()
    {
        String str = "front[";
        for(int i=0, trash = front; i<size;i++, trash++)
        {
            str = str +" "+ values[trash%max];
        }
        str = str +" ]back       size = "+size;
        
        return str;
    }
    
}
