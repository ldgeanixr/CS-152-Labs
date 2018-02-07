/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_sorted_queue;

/**
 *
 * @author admin
 * @param <T>
 */
public class LinkedListSortedQueue<T extends Comparable> 
        implements SortedQueue<T> {

    private int size;
    private Node<T> front;
            
    @Override
    public void insert(T value) {
        
        Node<T> newNode = new Node(value);
        Node<T> tempFront = front;
        
        if (size==0)
        {
            front = newNode;
        } 
        
        else {
            
            // newNode goes before front
            if (value.compareTo(front.getValue()) <= 0)
            {
                newNode.setLink(front);
                front = newNode;
            }
            
            // newNode goes somewhere in the middle
            else if (value.compareTo(front.getValue())>0)
            {
                
                for (; tempFront.getLink()!=null;)
                {
                   if (value.compareTo(tempFront.getLink().getValue())>0)
                  {
                      tempFront = tempFront.getLink();
                  }
                   
                  else
                   {
                      newNode.setLink(tempFront.getLink());
                      tempFront.setLink(newNode);
                      size++;
                      return;
                   }
                }
                
                tempFront.setLink(newNode);
            }
            
        }
        
        size++;     
    }

    @Override
    public T dequeue() throws Exception {
        
        if (size==0)
        {
            throw new Exception("SortedQueue is empty");
        }
        
        T result = front.getValue();
        front = front.getLink();
        size--;
        return result;     
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
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
