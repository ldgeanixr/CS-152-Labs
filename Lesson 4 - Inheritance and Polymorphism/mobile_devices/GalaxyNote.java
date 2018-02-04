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
public class GalaxyNote extends MobileDevices {
    
    private String name;
    private int version;
    
    public GalaxyNote ()
    {
        
        super("SamsungGN","small");
        
        name = "Samsung Galaxy Note";
        version = 8;
        
        
    }
    
    public void sizeOfPhone()
    {
        System.out.println("Large size");
    }
    /**
     * @Override
     */
    public void saySth ()
    {
        System.out.println("Galaxy Note is relatively cheap");
    }
    
    public void android ()
    {
        System.out.println("Oreo");
    }
    
    public String toString()
    {
        return "Type: GALAXY NOTE of LARGE SIZE";
    }
    
}
