/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Version 1.0
 * @author Marc
 * @Since 06.06.2017
 * The RMICLient can read the given Input and act according to the Input with the correct function.
 */
public class RMIClient {
    public static LocalTime convertStringtoLocalTime(String time){
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
             LocalTime startTime=LocalTime.parse(time,formatter);
             return startTime;
        }
    public static void main (String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        
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
                            /*schedule.getFreeTime("montag");*/
                                System.out.println("Lesson added");
                            break;
                            
                            case "schedule.removeLesson":
                            LocalTime time2=convertStringtoLocalTime(commands[3]);
                            schedule.removeLesson(new Lesson(commands[1],commands[2],time2));
                            System.out.println("Lesson removed");
                            break;
                            
                            case "schedule.getAllLessons":
                            String all="";
                            for (LessonInterface lesson: schedule.getAllLessons()){
                            all= all+lesson.toString();   
                                                                        }
                            System.out.println(all);
                            break;  
                            
                            case "schedule.getFreeTime":
                            System.out.println(String.valueOf(schedule.getFreeTime()));
                            break;
                            
                            case "schedule.exit":
                            schedule.saveToFile("log.txt");
                            running=false;
                            break;
                            default:
                            System.out.println("Invalid command");
                            break;
                            }
                        }
			                
 
			}catch (ExportException e){
				System.out.println("ScheduleClient exception: " + e);
				}
		}

}
