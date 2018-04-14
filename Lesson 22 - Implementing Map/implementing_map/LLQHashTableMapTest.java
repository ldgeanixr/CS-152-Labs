/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementing_map;

/**
 *
 * @author admin
 */
public class LLQHashTableMapTest {
    
    public static void main(String[] args)
    {
        HashTableMap<Integer, String> map = new LLQHashTableMap(10);
        
        try
        {
            System.out.println(map.removeAny());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(map);
        
        
        map.define(2,"B");
        map.define(1,"A");
        map.define(4,"D");
        map.define(5,"E");
        map.define(3,"C");
        System.out.println(map);
        
        System.out.println(map.remove(3));
        System.out.println(map);
        
        System.out.println(map.remove(6));
        System.out.println(map);
        
        map.define(5,"G");
        map.define(4,"F");
        System.out.println(map);
        
        map.define(7,"I");
        map.define(6,"H");
        map.define(8,"J");
        System.out.println(map);
        
        
        try
        {
            System.out.println(map.removeAny());
            System.out.println(map.removeAny());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(map);
        
        map.clear();
        System.out.println(map);
        
//        map.define(9,"K");
        map.define(10,"L");
        // BAG OCCURED HERE:
        // when key == number of buckets
        System.out.println(map);
        
//        map.clear();
    }
}
