/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementing_map;

/**
 *
 * @author admin
 * @param <K>
 * @param <V>
 */
public class BSTHashTableMap<K extends Comparable,V> implements Map<K,V> {
    
    private TreeNode<KeyValuePair<K,V>>[] root;
    private int size;
    
    public BSTHashTableMap(int k)
    {
        root = new TreeNode[k];
        size = 0;
    }

    @Override
    public void define(K key, V value) {
        int x = Math.abs(key.hashCode())%root.length;
        
        if (root[x] == null)
        {
            root[x] = new TreeNode(new KeyValuePair(key,value));
            size++;
            return;
        }
        
        TreeNode<KeyValuePair<K,V>> node = root[x];
        
        // Copy-Past from BSTMap define method
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
        
        int x = Math.abs(key.hashCode())%root.length;
        
        //From BSTMap
        TreeNode<KeyValuePair<K,V>> node = root[x];
        
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
        int x = Math.abs(key.hashCode())%root.length;
        
        //From BSTMap
        TreeNode<KeyValuePair<K,V>> node = root[x];
        TreeNode<KeyValuePair<K,V>> parent = root[x];
        
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
         
        if (node==root[x])
        {
            // root has no child
            if (node.getRight()==null && node.getLeft()==null)
            {
                root[x] = null;
            }
            
            // root has one child on the left
            else if (node.getLeft()!=null && node.getRight()==null)
            {
                root[x] = root[x].getLeft();
                //return true;
            }
            
            // root has one child on the right
            else if (node.getRight()!=null && node.getLeft()==null)
            {
                root[x] = root[x].getRight();
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
        
        for (int i=0; i<root.length; i++)
        {
            // ??? what if it is not null, but size is 0
            // remove() will nullify the root during the removal
            if (root[i]==null)
            {
                continue;
            }
            
            KeyValuePair<K,V> result = root[i].getValue();
            remove(root[i].getValue().getKey());
            return result;
        }
        
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = new TreeNode[root.length];
        size = 0;
    }
    

    @Override
    public String toString()
    {
        String str = "[ ";
        
        for (int i=0; i<root.length; ++i)
        {
             str = str + toStringHelper(root[i])+"";
        }
        
        str = str +"]  Size:"+size;
        
        return str;
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
