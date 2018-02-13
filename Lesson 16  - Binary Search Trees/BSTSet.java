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
public class BSTSet<T extends Comparable> implements Set<T> {
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSet()
    {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size==0)
        {
            root = new TreeNode(value);
            size++;
            return;
        }
        
        if (contains(value))
        {
            return;
        }
        
        addHelper(root, value);
    }
    
    private void addHelper(TreeNode<T> node, T value)
    {
      
      if (value.compareTo(node.getValue())>=0)
      {
          if (node.getRight()==null)
          {
              node.setRight(new TreeNode(value));
              size++;
              return;
          }
          addHelper(node.getRight(), value);
      } else
      {
          if (node.getLeft()==null)
          {
              node.setLeft(new TreeNode(value));
              size++;
              return;
          }
          addHelper(node.getLeft(), value);
      }
      
    }

    @Override
    public boolean contains(T value) {
           return containsHelper(root, value); 
    }
    
    private boolean containsHelper(TreeNode<T> node, T value)
    {
        if (node == null)
        {
            return false;
        }
        
        if (value.compareTo(node.getValue())>0)
        {
            return containsHelper(node.getRight(), value);
        } 
        else if (value.compareTo(node.getValue())<0)
        {
            return containsHelper(node.getLeft(), value);
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean remove(T value) {
            return false; // to be modified
    }

    @Override
    public T removeAny() throws Exception {
            T temp = null;
            return temp;// to be modified
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
        return toStringHelper(root)+"   size:"+size;
    }
    
    private String toStringHelper(TreeNode<T> node)
    {
        if (node == null)
        {
            return "";
        }
        
        return toStringHelper(node.getLeft())+" "+node.getValue()+" "+
                toStringHelper(node.getRight());
    }
}
