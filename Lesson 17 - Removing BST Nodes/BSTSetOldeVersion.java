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
public class BSTSetOldeVersion<T extends Comparable> implements Set<T> {
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSetOldeVersion()
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
        
        size--;
        
        TreeNode<T> node = root;
        TreeNode<T> parent = root;
        boolean isOnRight = true;
        
        //Searching for remove node
        while (node.getValue().compareTo(value)!=0)
        {
            // onTheRight?       
            if (value.compareTo(node.getValue())>0)
            {
                //Setting parent node, if the next node is gonna be the remove value
                //Parent node is only used when the next node is the remove node
                if (node.getRight().getValue().compareTo(value)==0)
                {
                    parent = node;
                    isOnRight = true; 
                }
                node = node.getRight();
            }
            //onTheLeft?
            else
            {
                //Setting parent node, if the next node is gonna be the remove value
                if (node.getLeft().getValue().compareTo(value)==0)
                {
                    parent = node;
                    isOnRight = false;
                }
                node = node.getLeft();
            }
        }
        
        //What if remove node is the root
        if (value.compareTo(root.getValue())==0)
        {
            //Case 1: no child already considered
            
            //Case 2: 1 child
            // child is on the left subtree
             if (node.getRight()==null && node.getLeft()!=null)
            {
                root = root.getLeft();
            }
            //child is on the right subtree
            else if (node.getRight()!=null && node.getLeft()==null)
            {
            //setting parent node to the child of the remove node
                root = root.getRight();
            }
            
            //Case 3: 2 children
            else //if (node.getRight()!=null && node.getLeft()!=null)
            {
            // go to the right subtree and find the smallest value
            // by moving to the end of the left subtree
            node = node.getRight();
            
            // another reference for the node that comes before
            // remove node, so I could promote the child of the remove node 
            TreeNode<T> temp = root;
            
            //least value found
                while (node.getLeft()!=null)
                {
                    if (node.getLeft().getLeft()==null)
                    {
                    // Grandparent of the child whose parent is the least value node
                    temp = node;
                    }
                    node = node.getLeft();
                }
            
                //inserting the found smallest value to the remove node's value
                    root.setValue(node.getValue());
                
            
                // checking whether this node has the right subtree
                if (node.getRight()!=null)
                {
                    if (temp==root)
                    {
                        temp.setRight(node.getRight());
                        return true;
                    }
                    
                    temp.setLeft(node.getRight());
                    return true;
                }
            
                else
                {
                    if (temp==root)
                    {
                        temp.setRight(null);
                        return true;
                    }
                       temp.setLeft(null);
                       return true;
                }
            
            
            }
        }
        
        //Checking for child cases of the remove node
        
        //Case1: No child
        if (node.getRight()==null && node.getLeft()==null)
        {
            //nullifying parent's right subtree
            if (isOnRight)
            {
                parent.setRight(null);
                return true;
            }
            //nullifying parent's left subtree
            else
            {
                parent.setLeft(null);
                return true;
            }
        }
        
        //Case2: One child
        
        // child is on the left subtree
        else if (node.getRight()==null && node.getLeft()!=null)
        {
            //setting parent node to the child of the remove node
            if (isOnRight)
            {
                parent.setRight(node.getLeft());
                return true;
            }
            
            else
            {
                parent.setLeft(node.getLeft());
                return true;
            }
                
        }
        //child is on the right subtree
        else if (node.getRight()!=null && node.getLeft()==null)
        {
            //setting parent node to the child of the remove node
            if (isOnRight)
            {
                parent.setRight(node.getRight());
                return true;
            }
            
            else
            {
                parent.setLeft(node.getRight());
                return true;
            }
        }
        
        //Case3: Two children
        else //if (node.getRight()!=null && node.getLeft()!=null)
        {
            // go to the right subtree and find the smallest value
            // by moving to the end of the left subtree
            node = node.getRight();
            
            // another reference for the node that comes before
            // remove node, so I could promote the child of the remove node 
            TreeNode<T> temp = root;
            
            //least value found
            while (node.getLeft()!=null)
            {
                if (node.getLeft().getLeft()==null)
                {
                    // Grandparent of the child whose parent is the least value node
                    temp = node;
                }
                node = node.getLeft();
            }
            
            //inserting the found smallest value to the remove node's value
            if (isOnRight)
            {
                parent.getRight().setValue(node.getValue());
            }
            
            else
            {
                parent.getLeft().setValue(node.getValue());
            }
            
            // checking whether this node has the right subtree
            if (node.getRight()!=null)
            {
                temp.setLeft(node.getRight());
                return true;
            }
            
            else
            {
                temp.setLeft(null);
                return true;
            }
            
            
        }

    
    }

    @Override
    public T removeAny() throws Exception { // finish (removing the root doesnt work properly!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11)
            T result = root.getValue();
            remove(result);
            return result;
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

