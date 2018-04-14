/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this nodelate file, choose Tools | nodelates
 * and open the nodelate in the editor.
 */
package implementing_map;

/**
 *
 * @author admin
 * @param <K>
 * @param <V>
 * #FIX ROOT CASE, and FIX SIZE COUNTER
 */
public class BSTMap<K extends Comparable,V> implements Map<K,V> {
    
    private TreeNode<KeyValuePair<K,V>> root;
    private int size;
    
    public BSTMap()
    {
        root = null;
        size = 0;
    }

    @Override
    public void define(K key, V value) {
        
        if (size==0)
        {
            root = new TreeNode(new KeyValuePair(key,value));
            size++;
            return;
        }
     
        TreeNode<KeyValuePair<K,V>> node = root;
        TreeNode<KeyValuePair<K,V>> parent;
        
        while(true)
        {
            if (key.compareTo(node.getValue().getKey())>0)
            {
                if (node.getRight()==null)
                {
                    node.setRight(new TreeNode(new KeyValuePair(key,value)));
                    size++;
                    return;
                }
                node = node.getRight();
            }
            
            else if(key.compareTo(node.getValue().getKey())<0)
            {
                if (node.getLeft()==null)
                {
                    node.setLeft(new TreeNode(new KeyValuePair(key,value)));
                    size++;
                    return;
                }
                node = node.getLeft();
            }
            
            else
            {
                node.getValue().setValue(value);
                return;
            }
        } 
    }

    @Override
    public V getValue(K key) {
        
        TreeNode<KeyValuePair<K,V>> node = root;
        
        while(true)
        {
            if (node == null)
            {
                return null;
            }
            
            if (key.compareTo(node.getValue().getKey())>0)
            {
                node = node.getRight();
            }
            
            else if (key.compareTo(node.getValue().getKey())<0)
            {
                node = node.getLeft();
            }
            
            else
            {
                return node.getValue().getValue();
            }
        }
    }

    @Override
    public V remove(K key) {
        
        TreeNode<KeyValuePair<K,V>> node = root;
        TreeNode<KeyValuePair<K,V>> parent = root;
        
         while(true)
        {
            if (node==null)
            {
                // nothing to remove :(
                return null;
            }   
            
            if (key.compareTo(node.getValue().getKey())>0)
            {
                if (node.getRight()==null)
                {
                    return null;
                }
                
                else if (node.getRight().getValue().getKey().compareTo(key)==0)
                {
                    parent = node;
                }
                
                node = node.getRight();
            }
            
            else if(key.compareTo(node.getValue().getKey())<0)
            {
                if (node.getLeft()==null)
                {
                    return null;
                }
                
                else if (node.getLeft().getValue().getKey().compareTo(key)==0)
                {
                    parent = node;
                }
                
                node = node.getLeft();
            }
            
            else
            {
                // remove node found!!!
                break;
            }
        }
        
        V val = node.getValue().getValue();
        size--;
         
        if (node==root)
        {
            // root has no child
            if (node.getRight()==null && node.getLeft()==null)
            {
                root = null;
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
            }
            
            // root has two children
            else
            {
                TreeNode<KeyValuePair<K,V>> temp = node.getRight();
                        
                while (temp.getLeft()!=null)
                {
                    if (temp.getLeft().getLeft()==null)
                    {
                        parent = temp;
                    }
                
                    temp = temp.getLeft();
                }
            
                                               
                node.getValue().setKey(temp.getValue().getKey());
                node.getValue().setValue(temp.getValue().getValue());
            
                // if temp has child on the right branch, or doesnt
                // esli on ne dvinulsya nikuda(situaciya s parentom izmenitsya)
                if (node.getRight()==temp)
                {
                    node.setRight(temp.getRight());
                }
            
                else
                {
                    parent.setLeft(temp.getRight());
                }
            }
            
            return val;
        }
         
        //no child case
        if (node.getRight()==null && node.getLeft()==null)
        {
            if (parent.getRight()==node)
            {
                parent.setRight(null);
            }
             
            else if (parent.getLeft()==node)
            {
                parent.setLeft(null);
            }
            
            return node.getValue().getValue();
        }
        
        //child on the right branch
        if (node.getRight()!=null && node.getLeft()==null)
        {
            if (parent.getRight()==node)
            {
                parent.setRight(node.getRight());
            }
             
            else if (parent.getLeft()==node)
            {
                parent.setLeft(node.getRight());
            }
            
            return node.getValue().getValue();
        }
        
        //child on the left branch
        else if (node.getRight()==null && node.getLeft()!=null)
        {
            if (parent.getRight()==node)
            {
                parent.setRight(node.getLeft());
            }
             
            else if (parent.getLeft()==node)
            {
                parent.setLeft(node.getLeft());
            }
            
            return node.getValue().getValue();
        }
        
        // child on both of the branches
        else
        {
            TreeNode<KeyValuePair<K,V>> temp = node.getRight();
                        
            while (temp.getLeft()!=null)
            {
                if (temp.getLeft().getLeft()==null)
                {
                    parent = temp;
                }
                
                temp = temp.getLeft();
            }
                                               
            node.getValue().setKey(temp.getValue().getKey());
            node.getValue().setValue(temp.getValue().getValue());
            
            // if temp has child on the right branch, or doesnt
            // esli on ne dvinulsya nikuda(situaciya s parentom izmenitsya)
            if (node.getRight()==temp)
            {
                node.setRight(temp.getRight());
            }
            
            else
            {
                parent.setLeft(temp.getRight());
            }
            
            return val;
        }
        
        
        
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        
        if (size==0)
        {
            throw new Exception("map is empty");
        }
        
        KeyValuePair<K,V> result = new KeyValuePair(root.getValue().getKey(),root.getValue().getValue());
        remove(root.getValue().getKey());
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
        return "["+toStringHelper(root)+"]"+"   size:"+size;
    }
    
     private String toStringHelper(TreeNode<KeyValuePair<K,V>> node)
    {
        if (node == null)
        {
            return "";
        }
        
        return toStringHelper(node.getLeft())+" "+node.getValue()+" "+
                toStringHelper(node.getRight());
    }
    
}
