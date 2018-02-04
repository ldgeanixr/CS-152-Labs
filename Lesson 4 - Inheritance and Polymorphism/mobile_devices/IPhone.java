/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile_devices;

/**
 *
 * @author Akzhol Nabiolla
 */
public class IPhone extends MobileDevices {
    
    private int version;
    private String name; // what does it mean to be final?
    
    public IPhone ()
    {
        super("IPhone", "medium");
        name = "iPhone";
        version = 10;
    }
    
    public void sizeOfPhone()
    {
        System.out.println("Medium size");
    }
    
    @Override
    public void saySth ()
    {
        System.out.println("IPhone is expensive");
    }
    
    @Override
    public void doSth ()
    {
        System.out.println("Siri Activated");
    }
    
    public void iOs ()
    {
        System.out.println("10.5");
    }
    
    @Override
    public String toString()
    {
        return "Name and version: "+name+" "+version;
    }
    
}
