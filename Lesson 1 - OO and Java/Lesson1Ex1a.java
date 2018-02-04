/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1ex1a;

/**
 *
 * @author Akzhol Nabiolla
 */
public class Lesson1Ex1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int l, w, h;
        
        l = 5;
        w = 5;
        h = 5;
        
        System.out.println("The volume: "+l*w*h+" and the surface area: "+2*(l*w+w*h+l*h));
        
        double r;
        r=5.0;
        System.out.println("The area is "+ 3.14*r*r+" and the circumference: "+2*3.14*r);
        
        System.out.println ("   /\\   | /  4  4 7777" );
        System.out.println ("  /__\\  |/   4444   77");
        System.out.println (" /    \\ | \\     4    7"  );
    }
    
}
