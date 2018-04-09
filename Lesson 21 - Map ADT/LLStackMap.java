/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import linked_list_stack.LinkedListStack;

/**
 *
 * @author admin
 */
public class LLStackMap<K,V> implements Map<K,V> {
    
    private LinkedListStack<KeyValuePair<K,V>> pairs;
    
    public LLStackMap()
    {
        pairs = new LinkedListStack();
    }

    @Override
    public void define(K key, V value) {
        if (pairs.getSize()==0)
        {
            pairs.push(new KeyValuePair(key,value));
            return;
        }
        
        LinkedListStack<KeyValuePair<K,V>> tempStack = new LinkedListStack();
        int size = pairs.getSize();
        boolean flag = false;
        
        for (int i=0; i<size; ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.pop();
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            
            if (temp.getKey().equals(key) && !flag) // reference equal
            {
                temp.setValue(value);
                flag = true;
            }
                tempStack.push(temp);
        }
        
        pairs = tempStack;
        
        if (!flag)
        {
            pairs.push(new KeyValuePair(key,value));
        }
        
    }

    @Override
    public V getValue(K key) {
        
        LinkedListStack<KeyValuePair<K,V>> tempStack = new LinkedListStack();
        V val = null;
        int size = pairs.getSize();
        
        
        for (int i=0; i<size; ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.pop();
                tempStack.push(temp);
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            if (temp.getKey().equals(key)) // reference equal
            {
                val = temp.getValue();
            }    
        }
        
        pairs = tempStack;
        
        return val;
    }

    @Override
    public V remove(K key) {
        LinkedListStack<KeyValuePair<K,V>> tempStack = new LinkedListStack();
        V val = null;
        int size = pairs.getSize();
        
        for (int i=0; i<size; ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.pop();
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            if (temp.getKey().equals(key)) // reference equal
            {
                val = temp.getValue();
                continue;
            } 
            
            tempStack.push(temp);
        }
        
        pairs = tempStack;
        
        return val;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        return pairs.pop();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack();
    }
    
    public String toString()
    {
        String str = "[";
        LinkedListStack<KeyValuePair<K,V>> tempStack = new LinkedListStack();
        int size = pairs.getSize();
        
        for (int i=0; i<size; ++i)
        {

            KeyValuePair temp = null;
            
            try
            {
                temp = pairs.pop();
                tempStack.push(temp);
            }catch(Exception ex){}
            
            if (i==0)
            {
                str = str+temp;
                continue;
            }
            
            str = str+","+temp;
        }
        
        pairs = tempStack;
        
        str = str +"]  size:"+pairs.getSize();
        
        return str;
        
    }
    
}
