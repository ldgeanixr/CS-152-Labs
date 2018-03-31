/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_queue;

/**
 *
 * @author admin
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T> {
    
    private Node<T> front;
    private Node<T> back;
    private int size;

    
    
    public LinkedListQueue ()
    {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {

           if (size==0)
           {
               front = new Node(value);
               back = front;
               size++;
           }
           
           else
           {
               Node<T> tempFront = new Node(value);
               back.setLink(tempFront);
               back = tempFront;
               size++;
           }  
 
    }

    @Override
    public T dequeue() throws Exception {
        if (size==0)
        {
            throw new Exception("Queue is empty");
        }
        
        if (size==1)
        {
            T result = front.getValue();
            front = null;
            back = null;
            size--;
            return result;
        }
        
        else
        {
            T result = front.getValue();
            front = front.getLink();
            size--;
            return result;
        }
        
        
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public String toString()
    {
        Node<T> temp = front;
        String str = "front[";
        
        for (int i=0; i<size; i++)
        {
            str = str +" "+ temp.getValue();
            temp = temp.getLink();
        }
        
        str = str+"]back          Size = "+size;
        
        return str;
    }
    
}
