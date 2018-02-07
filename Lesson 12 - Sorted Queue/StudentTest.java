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
public class StudentTest {
    
    public static void main (String[] args) throws Exception
    {
        SortedQueue<Student> stud = new LinkedListSortedQueue();
        
        Student akzhol = new Student(201558346, "Akzhol");
        Student nazira = new Student(201699256, "Nazira");
        Student arsen = new Student(201499256, "Arsen");
        Student abilmansur = new Student(201798565,"Abilmansur");
        Student aizere = new Student (201845785, "Aizere");
        
        stud.insert(akzhol);
        stud.insert(nazira);
        stud.insert(arsen);
        stud.insert(abilmansur);
        stud.insert(aizere);
        
        System.out.println(stud.dequeue());
        System.out.println(stud.dequeue());
        System.out.println(stud.dequeue());
        System.out.println(stud.dequeue());
        System.out.println(stud.dequeue());
 
    }
    
  
}
