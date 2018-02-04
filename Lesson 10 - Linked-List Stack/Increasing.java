/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list_stack;

/**
 *
 * @author admin
 */
public class Increasing {

    public static boolean isIncreasing(Stack<Double> st) throws Exception
    {
        Stack<Double> temp = new LinkedListStack();
        
        double x, y;
        boolean flag = true;
        
        int size = st.getSize();
        
        x = st.pop();
        y = st.pop();
        
        
        for (int i = 0; i<size-3; i++)
        {
            if (x>=y)
            {
                x=y;
                y=st.pop();
                temp.push(y);
            }
            
            else
            {
                flag = false; 
                break;
            }
        }
        
        size = temp.getSize();
        for (int i=0; i<size;i++)
        {
            st.push(temp.pop());
        }
        
        
        return flag;
    }
    

    
    public static void main (String[] args) throws Exception
    {
        Stack<Double> stk = new LinkedListStack();
        Stack<Double> temp = new LinkedListStack();
        

        for (double i=1.1; i<=8.3; i+=1.2)
        {
            stk.push(i);
            temp.push(i);
        }

        
        System.out.println(isIncreasing(stk));
        stk = temp;
        System.out.println(stk);
    }
}
