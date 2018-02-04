/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author admin
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
    
    private T[] values; 
    private int size;
    private int front;
    private int back;
    private int max;
    
    
    public ArrayQueue ()
    {
        max = 2;
        values = (T[])new Object[max];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(T value) {

            /**
             * increases the capacity if out of space
             */
            if ((back==max && front==0)||(back%max==front)) // esli net mesta
            {
                T[] temp = (T[])new Object[max*2];
                
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
    public T dequeue() throws Exception {
        
        if (size!=0)
        {
            T result = values[front%max];
            values[front%max] = null; // to cut it from the array(Garbage coll.)
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
        values = (T[])new Object[max];
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
