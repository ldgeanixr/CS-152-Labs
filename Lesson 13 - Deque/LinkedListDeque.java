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
public class LinkedListDeque<T> implements Deque<T>{

    private int size;
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    
    public LinkedListDeque()
    {
        size = 0;
        front = null;
        back = null;
    }
    
    @Override
    public void pushToFront(T value) {
        
        DoublyLinkedNode<T> temp = new DoublyLinkedNode(value);
        
        if (size==0)
        {
            front = temp;
            back = temp;
        } else
        {
            temp.setNext(front);
            front.setPrevious(temp); //////////////////////////////////////////asdasdasdasdasdasdasd
            front = temp;
        }
        
        size++;
    }

    @Override
    public void pushToBack(T value) {
        if (size==0)
        {
            pushToFront(value);
        } 
        else
        {
            DoublyLinkedNode<T> temp = new DoublyLinkedNode(value);
            
            back.setNext(temp);
            temp.setPrevious(back);
            back = temp;
            size++;
        }
       
    }

    @Override
    public T popFromFront() throws Exception {
        
        if (size==0)
        {
            throw new Exception("Deque is empty");
        }
        
        if (size==1)
        {
            T result = front.getValue();
            front = null;
            back=null;
            size--;
            return result;
        }
        
        else
        {
            T result = front.getValue();
            front = front.getNext();
            front.setPrevious(null);
            size--;
            return result;
        }
    }

    @Override
    public T popFromBack() throws Exception {
        if (size==0)
        {
            throw new Exception("Deque is empty");
        }
        
        if (size==1)
        {
            T result = back.getValue();
            back = null;
            size--;
            return result;
        }
        
        else
        {
            T result = back.getValue();
            back = back.getPrevious();
            back.setNext(null);
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
        size = 0;
        front = null;
        back = null;
    }
    
    @Override
    public String toString()
    {
        DoublyLinkedNode<T> temp = front;
        String str = "front[";
        
        for (int i=0; i<size; i++)
        {
            str = str +" "+ temp.getValue();
            if (temp.getNext()==null)
            {
                break;
            }
            temp = temp.getNext();
        }
        
        str = str+"]back          Size = "+size;
        
        return str;
    }
    
}
