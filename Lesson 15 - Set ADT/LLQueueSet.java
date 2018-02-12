/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_project;

import linked_list_queue.LinkedListQueue;
import linked_list_queue.Node;
import linked_list_queue.Queue;

/**
 *
 * @author admin
 */
public class LLQueueSet<T> implements Set<T> {
    
    private int size;
        Queue<T> que;

    
    public LLQueueSet()
    {
        size = 0;
        que = new LinkedListQueue();
    }
    
    @Override
    public void add(T value) {
        
        if (!contains(value))
        {
            que.enqueue(value);
            size++;
        }
//        if (size==0)
//        {
//            que.enqueue(value);
//            size++;     
//        }
//            
//        else
//        {
//            boolean flag = true;
//            for (int i=0; i<size; i++)
//            {
//               
//                   T x = null;
//                try
//                {
//                    x = que.dequeue();
//                    que.enqueue(x);
//                } catch (Exception ex)
//                {
//                    System.out.println(ex.getMessage());
//                }
//               
//                    
//                
//                if (x==value)
//                {
//                    flag = false;
//                    break;
//                }
//                
//            }
//            
//            if (flag)
//            {
//                que.enqueue(value);
//                size++;
//            }
//        }
    }

    @Override
    public boolean contains(T value) {
        for (int i=0; i<size; i++)
            {
               
                T x = null;
                try
                {
                    x = que.dequeue();
                    que.enqueue(x);
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                if (x.equals(value))
                {
                    return true;
                }
                
            }
        
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value))
        {
            for (int i=0; i<size; i++)
            {
                T x = null;
                try
                {
                    x = que.dequeue();
                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                
                
                if (!x.equals(value))
                {
                    que.enqueue(x);
                }
                else
                {
                    size--;
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (size==0){
            throw new Exception("Empty Set");
        }
        
        else
        {
            T result = que.dequeue();
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
        que = new LinkedListQueue();
    }
    
    @Override
    public String toString ()
    {
        T temp = null;
        String str ="[ ";
        
      for (int i=0; i<size; i++)
      {
          
          try
          {
              temp = que.dequeue();
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
          str = str+temp+" ";
          que.enqueue(temp);
      }
      
      str = str+"]" +"      size: "+size;
      
      return str;
    }
    
}
