/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import linked_list_queue.LinkedListQueue;

/**
 *
 * @author admin
 */
public class LLQueueMap<K,V> implements Map<K,V> {
    
    private LinkedListQueue<KeyValuePair<K,V>> pairs;
    
    public LLQueueMap()
    {
        pairs = new LinkedListQueue();
    }

    @Override
    public void define(K key, V value) {
             
        for (int i=0; i<pairs.getSize(); ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.dequeue();
                pairs.enqueue(temp);
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            
            if (temp.getKey().equals(key)) // reference equal
            {
                temp.setValue(value);
                return;
            }
        }
        
        pairs.enqueue(new KeyValuePair(key,value));
    }

    @Override
    public V getValue(K key) {
        
        
        for (int i=0; i<pairs.getSize(); ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.dequeue();
                pairs.enqueue(temp);
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            if (temp.getKey().equals(key)) // reference equal
            {
                return temp.getValue();
            }  
        }
        
        return null;
    }

    @Override
    public V remove(K key) {

        for (int i=0; i<pairs.getSize(); ++i)
        {
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = pairs.dequeue();
            } catch(Exception ex)
            {
                /// will not happen
            }
            
            if (temp.getKey().equals(key))
            {
                return temp.getValue();
            }
            
            else
            {
                pairs.enqueue(temp);
            }
        }
        
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (pairs.getSize()==0)
        {
            throw new Exception("Empty Map");
        }
        
        return pairs.dequeue();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue();
    }
    
    @Override
    public String toString()
    {
        //return pairs.toString();
        String str = "[";
        
        for (int i=0 ; i< pairs.getSize(); ++i)
        {
            KeyValuePair temp = null;
            
            try
            {
                temp = pairs.dequeue();
                pairs.enqueue(temp);
            }catch(Exception ex){}
            
            if (i==0)
            {
                str = str+temp;
                continue;
            }
            
            str = str+","+temp;
        }
        
        str = str +"]  size:"+pairs.getSize();
        
        return str;
    }
    
}
