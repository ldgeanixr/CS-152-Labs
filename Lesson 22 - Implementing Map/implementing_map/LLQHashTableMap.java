/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementing_map;

import linked_list_queue.LinkedListQueue;

/**
 *
 * @author admin
 * @param <K>
 * @param <V>
 */
public class LLQHashTableMap<K extends Comparable,V> implements HashTableMap<K,V> {
    
    private LinkedListQueue<KeyValuePair<K,V>>[] buckets;
    private int size;
    
    public LLQHashTableMap(int k)
    {
        buckets = new LinkedListQueue[k]; // why not new LinkedListQueue[k]()
        size = 0;
    }
    
    @Override
    public void define(K key, V value) {

        int x = Math.abs(key.hashCode())%buckets.length;

        if (buckets[x]==null)
        {
            buckets[x] = new LinkedListQueue();
        }

        int sz = buckets[x].getSize(); // is it efficient to use size var?

        for (int i=0; i<sz; i++)
        {
            System.out.println("PROBLEM IS HERE");
            // copied from LLQHashTableSet(idea)
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = buckets[x].dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            
            //if (temp.hashCode()==value.hashCode()) 
            if (temp.getKey().equals(key))
            {
                temp.setValue(value);
                buckets[x].enqueue(temp);
                return;
            }
            
            buckets[x].enqueue(temp);
        }
        
        buckets[x].enqueue(new KeyValuePair(key,value));
        size++;
    }

    @Override
    public V getValue(K key) {
        int x = Math.abs(key.hashCode())%buckets.length;
        
        if (buckets[x]==null)
        {
            buckets[x] = new LinkedListQueue();
        }
        
        int sz = buckets[x].getSize(); // is it efficient to use size var?
        
        for (int i=0; i<sz; i++)
        {
            // copied from LLQHashTableSet(idea)
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = buckets[x].dequeue();
                buckets[x].enqueue(temp);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            
            //if (temp.hashCode()==value.hashCode()) 
            if (temp.getKey().equals(key))
            {
                return temp.getValue();
            }    
        }
        
        return null;
    }

    @Override
    public V remove(K key) {
        int x = Math.abs(key.hashCode())%buckets.length;
        
        if (buckets[x]==null)
        {
            buckets[x] = new LinkedListQueue();
        }
        
        int sz = buckets[x].getSize(); // is it efficient to use size var?
        
        for (int i=0; i<sz; i++)
        {
            // copied from LLQHashTableSet(idea)
            KeyValuePair<K,V> temp = null;
            
            try
            {
                temp = buckets[x].dequeue();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            
            //if (temp.hashCode()==value.hashCode()) 
            if (temp.getKey().equals(key))
            {
                size--;
                return temp.getValue();
            }
            
            buckets[x].enqueue(temp);
        }
        
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        
        if (size==0)
        {
            throw new Exception("map is empty");
        }
        
        for (int i=0; i<buckets.length; i++)
        {
            if (buckets[i]==null || buckets[i].getSize()==0)
            {
                continue;
            }
            
            size--;
            return buckets[i].dequeue();
        }
        
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[buckets.length]; // why no brackets?
        size = 0;
    }
    
    //copied from previois lesson with all of the comments that I left(+9 lines after this, one modification)
    @Override
    public String toString()
    {
        String str = "[ ";
        for (int i=0; i<buckets.length; ++i)
        {
            //added this to fix nullpointerexception
            if (buckets[i]==null)
            {
                continue;
            }
            
            for (int j=0; i<buckets[i].getSize(); ++j)
            {
                KeyValuePair<K,V> temp = null; // variable might not be initialized
                try
                {
                    temp = buckets[i].dequeue();
                    buckets[i].enqueue(temp);
                } catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                str = str+temp+" ";
            }
        }
        str = str +"]  Size:"+size;
        return str;
    }
    
    //EVERYTHING BELOW IS COPYPASTED from previous lessons
    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index<0 || index>(buckets.length-1))
        {
            throw new Exception("index not found");
        }
        
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return (double)size/buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {
        int total = 0;
        
        for (int i=0; i<buckets.length; ++i)
        {
            if (buckets[i]==null)
            {
                continue;
            }
            total = total + buckets[i].getSize();
        }
        
        double mean = (double)total/buckets.length;
        
        double diffSquareSum = 0;
        
        for (int i=0 ; i<buckets.length; ++i)
        {
            if (buckets[i]==null)
            {
                diffSquareSum = diffSquareSum + Math.pow(0-mean,2);
                continue;
            }
            diffSquareSum = diffSquareSum + Math.pow(buckets[i].getSize()-mean,2); // will I lose decimal places?            
        }
        
        return Math.sqrt((double)diffSquareSum/buckets.length); // decimal places? How does it work?
    }

    @Override
    public String bucketsToString() {
        String str = size+"\n";
        
        for (int i=0; i<buckets.length; ++i)
        {
            str = str + buckets[i]+"\n";
        }
        
        return str;
    }
    
    
    
}
