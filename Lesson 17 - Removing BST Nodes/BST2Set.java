/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_tree;

/**
 *
 * @author admin
 * @param <T>
 */
public class BST2Set<T extends Comparable> implements Set<T> {

    private OnOffTreeNode<T> root;
    private int size;
    
    @Override
    public void add(T value) {
        if (size==0)
        {
            root = new OnOffTreeNode(value);
            size++;
            return;
        }
        
        if (contains(value))
        {
            return;
        }
        
        OnOffTreeNode<T> node = root;
        size++;
        
        while (1==1) // "infinite" iteration
        {
            // onTheRight?       
            if (value.compareTo(node.getValue())>0)
            {
                if (node.getRight()==null)
                {
                    node.setRight(new OnOffTreeNode(value));
                    return;
                }
                    node = node.getRight();
            }
            //onTheLeft?
            else if (value.compareTo(node.getValue())<0)
            {
                if (node.getLeft()==null)
                {
                    node.setLeft(new OnOffTreeNode(value));
                    return;
                }
                    node = node.getLeft();
            }
            
            else
            {
                    node.setActive(true);
                    return;
            }
        }
        
        
    }

    @Override
    public boolean contains(T value) {
        
        OnOffTreeNode<T> node = root;
        
        while (node!=null)
        {
            
            if (value.compareTo(node.getValue())>0)
            {
                node = node.getRight();
            } 
            else if (value.compareTo(node.getValue())<0)
            {
                node = node.getLeft();
            }
            else
            {
                if (node.getActive()==true)
                {
                   return true; 
                }
                
                else
                {
                    return false;
                }
                
            }
        }
        
        return false;
        
    }

    @Override
    public boolean remove(T value) {
        if (size==0)
        {
            return false;
        }
        
        if (!contains(value))
        {
            return false;
        }
        
        OnOffTreeNode<T> node = root;
        size--;
        
        while (1==1)
        {
            if (node.getValue().compareTo(value)==0)
            {
                node.setActive(false);
                return true;
            }
            
            else if (value.compareTo(node.getValue())>0)
            {
                node = node.getRight();
            } 
            
            else if (value.compareTo(node.getValue())<0)
            {
                node = node.getLeft();
            }   
        }
    
    }

    @Override
    public T removeAny() throws Exception {
       
        if (size==0)
        {
            throw new Exception("EMPTY SET");
        }
        
        T value = removeAnyHelper(root);
        remove(value);
        return value;
    }
    

    private T removeAnyHelper(OnOffTreeNode<T> node)
    {
        if (node==null)
        {
            return null;
        }
        
        if (node.getActive()==true)
        {
            return node.getValue();
        }
        
        T temp = removeAnyHelper(node.getRight());
        
        if (temp==null)
        {
            return removeAnyHelper(node.getLeft());
        }
        
        return temp;
          
    }
    

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    
    @Override
    public String toString()
    {
        return toStringHelper(root)+"      size:"+size;
    }
    
    private String toStringHelper(OnOffTreeNode<T> node)
    {
        if (node==null)
        {
            return "";
        }
        
        if (node.getActive()==false)
        {
            return toStringHelper(node.getLeft())+""+ toStringHelper(node.getRight());
        }
        
        else
        {
            return toStringHelper(node.getLeft())+" "+ node.getValue()+" "+ toStringHelper(node.getRight());
        }
    }
    
}
