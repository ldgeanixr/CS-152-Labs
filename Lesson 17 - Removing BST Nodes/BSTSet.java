/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_tree;


/**
 *  THIS CLASS IS THE NEW IMPLEMENTATION OF REMOVE AND REMOVEANY METHODS
 * 20.03.2018
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
      
      if (value.compareTo(node.getValue())>0)
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
        
        if (size==0)
        {
            return false;
        }
        
        if (!contains(value))
        {
            return false;
        }
        
        TreeNode<T> node = root;
        TreeNode<T> parent = root;
        size--;
        
        // searching for the node to remove
        while (node.getValue().compareTo(value)!=0)
        {
            if (value.compareTo(node.getValue())>0)
            {
               //keepig reference to the parent node
                if (node.getRight().getValue().compareTo(value)==0)
                {
                    parent = node;
                }
                
                node = node.getRight();
            }
            
            else
            {
                // keeping reference to the parent node
                if (node.getLeft().getValue().compareTo(value)==0)
                {
                    parent = node;
                }
                node = node.getLeft();
            }
        }
        
        // what if it is root? that has no parents
        if (node == root)
        {
            // root has no child
            if (node.getRight()==null && node.getLeft()==null)
            {
                root = null;
                //return true;
            }
            
            // root has one child on the left
            else if (node.getLeft()!=null && node.getRight()==null)
            {
                root = root.getLeft();
                //return true;
            }
            
            // root has one child on the right
            else if (node.getRight()!=null && node.getLeft()==null)
            {
                root = root.getRight();
                /**
                // trying to replace it with some safe value
                node = node.getRight();
                
                while (node.getLeft()!=null)
                {
                    if (node.getLeft().getLeft()==null)
                    {
                        parent = node;
                    }
                    
                    node = node.getLeft();
                }
                
                //root's new value
                root.setValue(node.getValue());
                
                // bothering whether this safe value node has children
                if (node.getRight()==null)
                {
                    parent.setLeft(null);
                    //return true;
                }
                
                else //if (node.getRight()!=null)
                {
                    parent.setLeft(node.getRight());
                    //return true;
                }
                */
            }
            
            //root has 2 children
            else if (node.getRight()!=null && node.getLeft()!=null)
            {
                // trying to replace it with some safe value
                node = node.getRight();
                
                while (node.getLeft()!=null)
                {
                    if (node.getLeft().getLeft()==null)
                    {
                        parent = node;
                    }
                    
                    node = node.getLeft();
                }
                
                //root's new value
                root.setValue(node.getValue());
                
                // bothering whether this safe value node has children
                if (node.getRight()==null)
                {
                    if (node == root.getRight())   // this was made to fix the case with removing 11
                    {
                        root.setRight(null);
                    }
                    
                    else
                    {
                        parent.setLeft(null);
                    }
                    
                    //return true;
                }
                
                else //if (node.getRight()!=null)
                {
                    if (node == root.getRight())   // this was made to fix the case with removing 11
                    {
                        root.setRight(node.getRight());
                    }
                    
                    else
                    {
                       parent.setLeft(node.getRight()); 
                    }
                    
                    //return true;
                }
            }
            
            return true;
 
        }
        
        // not root cases
        else
        {
            // no child case
            if (node.getRight()==null && node.getLeft()==null)
            {
                if (parent.getRight()==node)
                {
                    parent.setRight(null);
                    //return true;
                }
                
                else //if (parent.getLeft()==node)
                {
                    parent.setLeft(null);
                    //return true;
                }
            }
            
            // one child on the left
            else if (node.getLeft()!=null && node.getRight()==null)
            {
                if (parent.getRight()==node)
                {
                    parent.setRight(node.getLeft());
                    //return true;
                }
                
                else //if (parent.getLeft()==node)
                {
                    parent.setLeft(node.getLeft());
                    //return true;
                }
            }
            
            // one child on the right
            else if (node.getLeft()==null && node.getRight()!=null)
            {
                if (parent.getRight()==node)
                {
                    parent.setRight(node.getRight());
                    //return true;
                }
                
                else //if (parent.getLeft()==node)
                {
                    parent.setLeft(node.getRight());
                    //return true;
                }
                
                return true;
            }
            
            // two child case
            else
            {
                TreeNode<T> tempNode = node;
                node = node.getRight();
                
                while (node.getLeft()!=null)
                {
                    if (node.getLeft().getLeft()==null) // .getLeft() added
                    {
                        parent = node;
                    }
                    
                    node = node.getLeft();
                }
                
                tempNode.setValue(node.getValue());
                
                // bothering whether this safe value node has children
                if (node.getRight()==null)
                {
                    parent.setLeft(null); // setLeft instead of setRight
                    //return true;
                }
                
                else //if (node.getRight()!=null)
                {
                    parent.setLeft(node.getRight());
                    //return true;
                }
                
            }
           
            return true;
        }
    }

    @Override
    public T removeAny() throws Exception {
        
        if (size==0)
        {
            throw new Exception("EMPTY SET");
        }
        
        T value = root.getValue();
        remove(value);
        
        return value;
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
