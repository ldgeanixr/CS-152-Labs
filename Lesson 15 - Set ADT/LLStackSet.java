/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_project;

import linked_list_stack.LinkedListStack;
import linked_list_stack.Stack;

/**
 *
 * @author admin
 */
public class LLStackSet<T> implements Set<T> {
    
    Stack<T> stk = new LinkedListStack();

    @Override
    public void add(T value) {
        if (!contains(value))
        {
            stk.push(value);
        }
     }

    @Override
    public boolean contains(T value) {
      int size = stk.getSize();
      Stack<T> tempStk = new LinkedListStack();
       T tempVal = null;
       boolean flag = false;
      
      for (int i=0; i<size; i++)
      {  
          try
          {
              tempVal = stk.pop();
              tempStk.push(tempVal);
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
          if (tempVal.equals(value))
          {
              flag = true;
          }    
      }
      
      stk = tempStk;
      tempStk = null;
      
      return flag;
      
    }

    @Override
    public boolean remove(T value) {
      int size = stk.getSize();
      Stack<T> tempStk = new LinkedListStack();
      T tempVal = null;
      boolean flag = false;
      
      for (int i=0; i<size; i++)
      {
          try
          {
              tempVal = stk.pop();
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
          if (tempVal.equals(value))
          {
              flag = true;
          } else
          {
              tempStk.push(tempVal);
          }
          
      }
      
      stk = tempStk;
      tempStk = null;
      
      return flag;
    }

    @Override
    public T removeAny() throws Exception {
      if (stk.getSize()==0)
      {
          throw new Exception("Set is Empty");
      }
      
      return stk.pop();
      
    }

    @Override
    public int getSize() {
       return stk.getSize();
    }

    @Override
    public void clear() {
       stk.clear();
    }
    
    @Override
    public String toString ()
    {
        T temp = null;
        String str ="[ ";
        int size = getSize();
        Stack<T> tempS = new LinkedListStack();
        
      for (int i=0; i<size; i++)
      {
          
          try
          {
              temp = stk.pop();
              tempS.push(temp);
          } catch (Exception ex)
          {
              System.out.println(ex.getMessage());
          }
          
          str = str+temp+" ";
      }
      
      stk = tempS;
      
      str = str+"]" +"      size: "+size;
      
      return str;
    }
}
