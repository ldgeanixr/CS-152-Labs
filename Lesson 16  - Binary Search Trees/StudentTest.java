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
public class StudentTest {
    
    public static void main (String[] args)
    {
        Set<Student> setStud = new BSTSet();
        
        
        System.out.println(setStud);
        
        Student s1 = new Student (1, "Akzhol");
        Student s2 = new Student (2, "Aidyn");
        Student s3 = new Student (3, "Abylai");
        Student s4 = new Student (4, "Marat");
        Student s5 = new Student (5, "Kanat");
        
        setStud.add(s1);
        setStud.add(s2);
        setStud.add(s3);
        setStud.add(s4);
        setStud.add(s5);
        System.out.println(setStud);
        


        

        
        setStud.add(new Student(2, "Aidyn"));
        setStud.add(new Student(3, "Abylai"));
        System.out.println(setStud);
        
        setStud.add(new Student(6, "Alyam"));
        setStud.add(new Student(7, "Shama"));
        setStud.add(new Student(8, "Nurda"));
        System.out.println(setStud);
        
        
        setStud.clear();
        System.out.println(setStud);
        
        setStud.add(new Student(9, "Alibi"));
        setStud.add(new Student(10, "Nurtay"));
        System.out.println(setStud);
        
    }
}
