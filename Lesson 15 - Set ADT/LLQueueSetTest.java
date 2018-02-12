/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_project;

/**
 *
 * @author admin
 */
public class LLQueueSetTest {
    
    public static void main (String[] args)
    {
//        Set<Integer> set = new LLQueueSet();
//        
//        System.out.println(set);
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        System.out.println(set);
//        set.add(2);
//        set.add(3);
//        set.add(3);
//        
//        System.out.println(set);
//        System.out.println(set.contains(3));
//        System.out.println(set.contains(2));
//        System.out.println(set.contains(1));
//        System.out.println(set.contains(4));
//        set.remove(1);
//        System.out.println(set);
//        set.remove(2);
//        System.out.println(set);
//        set.remove(3);
//        System.out.println(set);
//        
//        set.clear();
//        System.out.println(set);
//        
        
        
//        Set<Student> stdSet = new LLQueueSet();
//        
//        Student aq = new Student (1, "Akzhol");
//        Student aid = new Student (2, "Aidyn");
//        Student abl = new Student (3, "Abylai");
//        Student aq2 = new Student (1, "Akzhol");
//        
//        System.out.println(stdSet);
//        stdSet.add(aq);
//        stdSet.add(aid);
//        stdSet.add(abl);
//        stdSet.add(aq2);
//        System.out.println(stdSet);
        
        Set<Student> setStud = new LLQueueSet();
        
        try
        {
            System.out.println(setStud.removeAny());
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
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
        
        setStud.remove(new Student(5, "Kanat"));
        System.out.println(setStud);
        
        setStud.remove(new Student(2, "Akzhol"));
        System.out.println(setStud);
        
        setStud.add(new Student(2, "Aidyn"));
        setStud.add(new Student(3, "Abylai"));
        System.out.println(setStud);
        
        setStud.add(new Student(6, "Alyam"));
        setStud.add(new Student(7, "Shama"));
        setStud.add(new Student(8, "Nurda"));
        System.out.println(setStud);
        
        try
        {
            System.out.println(setStud.removeAny());
            System.out.println(setStud.removeAny());
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        setStud.clear();
        System.out.println(setStud);
        
        setStud.add(new Student(9, "Alibi"));
        setStud.add(new Student(10, "Nurtay"));
        System.out.println(setStud);
        
        
        
        
        
        

        
        
        
        
        
    }
} 
