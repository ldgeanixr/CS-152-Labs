/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_functions;

import linked_list_queue.LinkedListQueue;

/**
 *
 * @author admin
 * @param <T>
 */
public class LLQHashTableSet<T> implements HashTableSet<T>{
    
    private LinkedListQueue<T>[] buckets;
    private int size;
    
    public LLQHashTableSet(int k)
    {
        buckets = new LinkedListQueue[k];
        size = 0;
    }

    @Override
    public void add(T value) {
        if (contains(value))
        {
            return;
        }
        
        //int x = (value.hashCode()>=0)?value.hashCode()%buckets.length:value.hashCode()*(-1)%buckets.length;
        int x = Math.abs(value.hashCode())%buckets.length;
        ++size;
        
        if (buckets[x]==null)
        {
            buckets[x] = new LinkedListQueue();
        }
        
        
            buckets[x].enqueue(value);
        
        
        
        
    }

    @Override
    public boolean contains(T value) {
        if (size==0)
        {
            return false;
        }
        

        //hashcode of the "value"
        //int x = (value.hashCode()>=0)?(value.hashCode())%buckets.length:value.hashCode()*(-1)%buckets.length;
        int x = Math.abs(value.hashCode())%buckets.length;
        
        if (buckets[x]==null)
        {
            return false;
        }
        
        for (int i=0; i<buckets[x].getSize(); ++i)
        {
            T temp = null;
            
            try
            {
                temp = buckets[x].dequeue();
                buckets[x].enqueue(temp);
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            
            //if (temp.hashCode()==value.hashCode()) 
            if (value.equals(temp))
            {
                return true;
            }
            
        }
        
        return false;
        }

    @Override
    public boolean remove(T value) {
        if (size==0 || !contains(value))
        {
            return false;
        }
        
        //int x = (value.hashCode()>=0)?value.hashCode()%buckets.length:value.hashCode()*(-1)%buckets.length;
        int x = Math.abs(value.hashCode())%buckets.length;;
        
        for (int i=0; i<buckets[x].getSize(); ++i)
        {
            T temp = null;
            
            try
            {
                temp = buckets[x].dequeue();
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
            if (!value.equals(temp))
            {
                buckets[x].enqueue(temp);
            }
            
            else
            {
                --size;
                break;
            }
        }
        
        return true;
       
    }

    @Override
    public T removeAny() throws Exception {
        
        if (size==0)
        {
            throw new Exception("empty set");
        }
            
        T result = null;
        for (int i=0; i<buckets.length; i++)
        {
            if (buckets[i]!=null && buckets[i].getSize()!=0)
            {
                --size;
                result = buckets[i].dequeue();
                break;
             }
        }
        
        return result;
   }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = (LinkedListQueue<T>[])new LinkedListQueue[buckets.length];
        size = 0;
    }
    
    @Override
    public String toString() 
    {
        String str = "[ ";
        for (int i=0; i<buckets.length; ++i)
        {
            for (int j=0; i<buckets[i].getSize(); ++j)
            {
                T temp = null; // variable might not be initialized
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
