/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search_tree;

/**
 *
 * @author admin
 */
public class Student implements Comparable {


    
    private int id;
    private String name;    
    
    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Student)
        {
            Student sobj = (Student)obj;
            
            return id == sobj.getId() && name.equals(sobj.name);
        }
        
        return false;
    }
    

    @Override
    public int compareTo(Object obj)
    {
        Student stud = (Student) obj;
        
        return name.compareTo(stud.getName());
    }
    
    @Override
    public String toString()
    {
        return "Name: "+name+" ID: "+id;
    }
}
