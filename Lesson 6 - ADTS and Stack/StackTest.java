/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author admin
 */
public class StackTest {
    
    public static void main (String[] args)
    {
        IntStack stack = new ArrayIntStack();
        
        try
        {
            stack.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        for (int i=0;i<12;i++)
        {
            stack.push(i*2);
        }
        
        System.out.println(stack);
        System.out.println(stack.getSize());
        
        stack.clear();
        System.out.println(stack);
        System.out.println(stack.getSize());
        
        for (int i=0;i<22;i++)
        {
            stack.push(i*2);
        }
        System.out.println(stack);
        System.out.println(stack.getSize());
        
        
        
    }
    
}
