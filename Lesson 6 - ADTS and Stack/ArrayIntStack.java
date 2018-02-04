/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author admin
 */
public class ArrayIntStack implements IntStack {

    private int[] values;
    private int size;
    private int max = 5;
  
     
    public ArrayIntStack()
    {
        values = new int[max];
        size = 0;
   
    }
    
    
    @Override
    public void push(int value) {
        if (size<max)
        {
            values[size] = value;
            size++;
        }
        
        else
        {
            
            int[] newvals = new int[2*max];
            
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
    public int pop() throws Exception {
        if (size>0)
        {
            int result = values[size-1];
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
        values = new int[5];
        max = 5;
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
