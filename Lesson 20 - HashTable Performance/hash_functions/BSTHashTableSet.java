/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash_functions;

/**
 *
 * @author admin
 * @param <T>
 */
public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T>{
    
    private BSTSet<T>[] buckets;
    private int size;

    public BSTHashTableSet(int k)
    {
        size = 0;
        buckets = new BSTSet[k];
    }
    @Override
    public void add(T value) {
        
        int x = Math.abs(value.hashCode())%buckets.length;
        
        if (contains(value))
        {
            return;
        }
        
        if (buckets[x]==null)
        {
            buckets[x] = new BSTSet();
        }
        
        buckets[x].add(value);
        size++;
     
    }

    @Override
    public boolean contains(T value) {
        
        int x = Math.abs(value.hashCode())%buckets.length;
        
        if (size==0 || buckets[x]==null)
        {
            return false;
        }
        
        if (buckets[x].contains(value))
        {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean remove(T value) {
        
        int x = Math.abs(value.hashCode())%buckets.length;
        
        if (!buckets[x].contains(value))
        {
            return false;
        }
        
        buckets[x].remove(value);
        --size;
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0)
        {
            throw new Exception("EMPTY SET");
        }
        
        --size;
        T result = null; // how to solve "might not have been initialized"
        
        for (int i=0; i<buckets.length; ++i)
        {
            if (buckets[i].getSize()!=0)
            {
                result = buckets[i].removeAny();
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
        size = 0;
        buckets = new BSTSet[buckets.length];
    }
    
    @Override
    public String toString()
    {
        String str = "[ ";
        
        for (int i=0; i<buckets.length; ++i)
        {
            if (buckets[i]==null)
            {
                continue;
            }
             str = str + toStringHelper(buckets[i].getRoot())+" ";
        }
        
        str = str +"]  Size:"+size;
        
        return str;
    }
    
    // purpose of this method is to properly print out the contents of a set
    private String toStringHelper(TreeNode<T> set)
    {
        if (set == null)
        {
            return "";
        }
        
        return toStringHelper(set.getLeft())+" "+set.getValue()+" "+
                toStringHelper(set.getRight());
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
        String str ="Size:"+size+"\n";
        
        for (int i=0; i<buckets.length; ++i)
        {
            str = str + buckets[i]+"\n";
        }
        
        return str;   
    }
    
}
