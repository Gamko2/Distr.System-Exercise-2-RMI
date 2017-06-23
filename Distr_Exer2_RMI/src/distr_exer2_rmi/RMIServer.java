/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

/**
 *@Version 1.0
 * @author Marc
 * @since 06.06.2017
 * The Server creates a new schedule and does the RMI Binding.
 */
public class RMIServer  {
    public static void main (String[] argv) {
        
        try {
            LocateRegistry.createRegistry(1099);
            System.setSecurityManager(new RMISecurityManager());
 
			   ScheduleInterface schedule = new Schedule();			   		   
			   Naming.rebind("rmi://localhost/Schedule", schedule);
 
			   System.out.println("Schedule Server is ready.");
			   }catch (Exception e) {
				   System.out.println("Schedule Server failed: " + e);
				}
		   }
}
    

