/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.rmi.Naming;

/**
 *
 * @author Marc
 */
public class RMIClient {
    public static void main (String[] args) {
		ScheduleInterface schedule;
		try {
			schedule = (ScheduleInterface)Naming.lookup("rmi://localhost/Schedule");
			                 System.out.println(schedule.getFreeTime("montag")); 
 
			}catch (Exception e) {
				System.out.println("ScheduleClient exception: " + e);
				}
		}

}
