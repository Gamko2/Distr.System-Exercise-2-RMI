package distr_exer2_rmi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import distr_exer2_rmi.LessonInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Marc
 * @version 1.0
 * @since 2017-05-16
 * The class Lesson provides all necessary attributes and functions for the lesson class.
 */

public class Lesson extends UnicastRemoteObject implements LessonInterface {
    
    /**
     * 
     * @param title This sets the title to the title of the specific lesson
     */
   @Override
   public void setTitle(String title)throws RemoteException{
       this.title=title;
   } 
  /**
   * 
   * @return title This returns the title of the lesson
   */ 
   @Override
  public String getTitle()throws RemoteException{
      return title;
  }
/**
 * 
 * @return returns the day of the lesson 
 */
   @Override
    public String getDay()throws RemoteException {
        return day;
    }
/**
 * 
 * @param day sets the day that we wrote to the day of this lesson
 */
   @Override
    public void setDay(String day)throws RemoteException {
        this.day = day;
    }

    /**
     * 
     * @return Get the start time of the lesson
     */
   @Override
    public LocalTime getStartTime()throws RemoteException {
        return startTime;
    }
/**
 * 
 * @param startTime It sets the start time to the start time of the lesson
 */
   @Override
    public void setStartTime(LocalTime startTime)throws RemoteException {
        this.startTime = startTime;
    }
  
  
    
   
   private String title;
   private String day;
   private  LocalTime startTime;
   
   
/**
 * 
 * @param title Title of the lesson
 * @param day day of the lesson
 * @param startTime start time of the lesson
 * All those are the attributes a single lesson contains
     * @throws java.rmi.RemoteException
 */
    public Lesson(String title, String day, LocalTime startTime)throws RemoteException {
        this.title = title;
        this.day = day;
        this.startTime = startTime;
    }
   
   /**
    * 
    * @return the title+day+stayrttime of the lesson. 
    *
    */
  @Override
  public String toString(){
   return title +" " +day+" " +startTime;   
  }
  /**
   * Here we check if the Object w eget is a lesson. If it is then we compare if it is the same lesson as something else 
   * @param other
   * @return 
   */
  @Override
  public boolean equals (Object other){
  
      if (other!= null && other instanceof Lesson){
      Lesson compare=(Lesson)other;
      
     
    
           return title.equals(compare.title)&& day.equals(compare.day)&&startTime.equals(compare.startTime);
           
       }
       return false;
  }
      
}
