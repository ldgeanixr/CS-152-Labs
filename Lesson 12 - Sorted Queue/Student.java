/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_sorted_queue;

/**
 *
 * @author admin
 */
public class Student implements Comparable  {
    
    private int id;
    private String name;

    public Student (int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public int compareTo(Object o)
    {
        
        // typecasting is used so id of stud could be a(?)
        Student stud = (Student) o;
        
        // Casted to an object type since primitives types dont have compareTo
        // stud.id and stud.getID (same) (?)
        return ((Integer)id).compareTo(stud.id);
        
        // name is a String which is of object type
        //return name.compareTo(stud.name);
    }
    

    
    public int getID()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString(){
        return "ID: "+id+"    Name: "+name;
    }

    
}
