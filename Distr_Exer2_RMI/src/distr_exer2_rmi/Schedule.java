package distr_exer2_rmi;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Schedule extends UnicastRemoteObject implements ScheduleInterface {

    public Schedule() throws RemoteException {}
    private List<LessonInterface> lessons = new ArrayList<LessonInterface>();

    @Override
    public void addLesson(LessonInterface lesson) throws RemoteException {
        lessons.add(lesson);
    }

    @Override
    public void removeLesson(LessonInterface lesson) throws RemoteException {
         for (int i=0; i<lessons.size();i++){
             if (lesson.equals(lessons.get(i))){
                 lessons.remove(i);
                 return;
             }
         }
    }

    @Override
    public List<LessonInterface> getAllLessons() throws RemoteException {
        return lessons;
    }

    @Override
    public String getFreeTime() throws RemoteException{
      return String.valueOf(getFreeTime("Monday")+getFreeTime("Tuesday")+getFreeTime("Wednesday")+getFreeTime("Thursday")+getFreeTime("Friday"));
    }
    
    public int getFreeTime(String day) throws RemoteException {
          int lessonCount=0;
       for (LessonInterface lesson:lessons){
           if (lesson.getDay().equals(day)){
               lessonCount++;
           }
       }
       return 10-lessonCount;
    }

    @Override
    public void saveToFile(String filename) throws RemoteException  {
     
         FileOutputStream fileOut= null;
        try {
            fileOut = new FileOutputStream ("/schedule.ser");
            ObjectOutputStream out= new ObjectOutputStream (fileOut);
            out.writeObject(this); 
            out.close();
            System.out.printf("Serialized data is saved in /schedule.ser");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
        
           
        
       
     }
    }

