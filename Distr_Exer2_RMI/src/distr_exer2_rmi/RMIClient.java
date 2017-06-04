/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Marc
 */
public class RMIClient {
    public static LocalTime convertStringtoLocalTime(String time){
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");
             LocalTime startTime=LocalTime.parse(time,formatter);
             return startTime;
        }
    public static void main (String[] args) {
        
		ScheduleInterface schedule;
		try {
			schedule = (ScheduleInterface)Naming.lookup("rmi://localhost/Schedule");
                        boolean running=true;
                        while (running){
                           BufferedReader input = new BufferedReader(
                            new InputStreamReader(System.in));
                            String in=input.readLine();
                            String[] commands=in.split(" ");
                            switch (commands[0]){
                            case "schedule.addLesson":
                            LocalTime time=convertStringtoLocalTime(commands[3]);    
                            schedule.addLesson(new Lesson(commands[1],commands[2],time));
                                System.out.println("Lesson added");
                            break;
                            }
                        }
			                 System.out.println(schedule.getFreeTime("montag")); 
 
			}catch (Exception e) {
				System.out.println("ScheduleClient exception: " + e);
				}
		}

}
