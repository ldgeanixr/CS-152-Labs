/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_stack;

/**
 *
 * @author admin
 */
public class LinkedListStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;
    
    public LinkedListStack()
    {
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        
        if (size==0) 
        {
            top = new Node(value);
            size++;
            return;
        }
        
        Node<T> temp = new Node(value);
        temp.setLink(top);
        top = temp;
        
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0)
        {
            throw new Exception("Stack is empty");
        }
        
        T val = top.getValue();
        top = top.getLink();
        size--;
        return val;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    @Override
    public String toString()
    {
        Node<T> temp = top;
        String str = "top[";
        
        for (int i=0; i<size; i++)
        {
            str = str +" "+ temp.getValue();
            temp = temp.getLink();
        }
        
        str = str+"]bot          Size = "+size;
        
        return str;
    }
    
    
}
