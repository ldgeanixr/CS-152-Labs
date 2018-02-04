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
public class MobileDevices {

    private String type;
    private String size;
    private String name;
    
    public MobileDevices (String name)
    {
       this.name = name;
       type = "Not Assigned";
       size = "Not Assigned";
    }
    
    public MobileDevices(String type, String size)
    {
        this.type = type;
        this.size = size;
    }
    
    public void saySth()
    {
        System.out.println("Mobile Devices are bad");
    }
    
    public void doSth()
    {
        System.out.println("Mobile Device Manufactured");
    }
    
    public String getName()
    {
        return type;
    }
    
    /**
     * method that only belongs to MobileDevices Class
     */
    public void uniqueMethod()
    {
        System.out.println("This method belongs to MobileDevices");
    }
    
    /**
     * 
     * @return string value
     */
    @Override
    public String toString ()
    {
        return "Type: "+type+" Size: "+size;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MobileDevices oldPhone = new GalaxyNote();
        
        System.out.println(oldPhone.getName()); // method is inherited
        oldPhone.doSth(); // it uses the method of MobileDevices (no doSth in the GalaxyNote)
        oldPhone.saySth(); // overriden
        //oldPhone.android();   can't call this method, because
        //oldPhone.sizeOfPhone();
        oldPhone.uniqueMethod(); // method of 
        
        System.out.println(oldPhone+"\n\n"); // NOT OVERRIDEN
        
        
        
        MobileDevices newPhone = new IPhone();
        
        System.out.println(newPhone.getName());
        newPhone.doSth();
        newPhone.saySth();
        //newPhone.sizeOfPhone();
        newPhone.uniqueMethod();
        //newPhone.iOs();
        
        System.out.println(newPhone+"\n\n");
        
        
        MobileDevices mobDev = new MobileDevices("Nokia xPressMusic", "small");
        
        System.out.println(mobDev.getName());
        mobDev.doSth();
        mobDev.saySth();
        mobDev.uniqueMethod();
        
        System.out.println(mobDev+"\n\n");
        
 
//        GalaxyNote samsung = new GalaxyNote();
//        samsung.saySth();
//        samsung.android();
        
        
    }
    
}
