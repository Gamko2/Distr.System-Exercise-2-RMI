/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr.exer1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marc
 * @version 1.0
 * @since 2017-05-16
 */

/**
 * The class just represents a schedule and some basic functionalities what a schedule should do
 * @author Marc
 */
public class Schedule {
   private List<Lesson> lessons = new ArrayList<Lesson>();
    
   /**
    * 
    * @param lesson A lesson is added to the schedule 
    */
   public void addLesson(Lesson lesson){
       lessons.add(lesson);
   }
   
   /**
    * 
    * @param lesson A specific lesson is removed the schedule
    */
   public void removeLesson(Lesson lesson){
       lessons.remove(lesson);
   }
   
   /**
    * 
    * @return This returns all lessons that are currently contained in the schedule 
    */
   public List<Lesson> getAllLessons(){
       return lessons;
   }
   /**
    * 
    * @param day
    * @return It calculates the amount of free hours of a specific day 
    */
   public int getFreeTime(String day){
       int lessonCount=0;
       for (Lesson lesson:lessons){
           if (lesson.getDay().equals(day)){
               lessonCount++;
           }
       }
       return 10-lessonCount;
   }
   
   /**
    * This saves the current schedule in a Text File. 
    * @param filename
    * @throws IOException if you dont have the permission to write in the targeted directory
    */
   public void saveToFile(String filename) throws IOException{
     FileWriter fw= new FileWriter(filename);
     BufferedWriter bw = new BufferedWriter(fw);
     for (Lesson lesson: getAllLessons()){
         bw.write(lesson.toString());
         bw.write("\r\n");
     }
     bw.close();
   }
   
}

