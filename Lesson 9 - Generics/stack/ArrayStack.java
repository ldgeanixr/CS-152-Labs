/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author admin
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size;
    private int max = 2;
  
     
    public ArrayStack()
    {
        values = (T[])new Object[max];
        size = 0;
   
    }
    
    
    @Override
    public void push(T value) {
        if (size<max)
        {
            values[size] = value;
            size++;
        }
        
        else
        {
            
            T[] newvals = (T[])new Object[2*max];
            
            for(int j=0; j<size;j++)
            {
                newvals[j] = values[j];
            }
            
            newvals[size] = value;
            
            values = newvals;
            max = max * 2;
            size++;
            
        }
        
    }

    @Override
    public T pop() throws Exception {
        if (size>0)
        {
            T result = values[size-1];
            values[size-1] = null; // Garbage collection, efficiency 
            size--;
            return result;
        }
        
        else
        {
            throw new Exception("No Element to POP");
        }
        
        
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[])new Object[2];
        max = 2;
        size = 0;
    }
    
    @Override
    public String toString()
    {
        String string = "bottom[ ";
        
        for (int i=0; i<size;i++)
        {
            if (i==size-1)
            {
                string = string + values[i]+" ";
                break;
            }
            
            string = string + values[i]+", ";
        }
        
        string = string+"]top";
        
        return string;
    }
    
}
