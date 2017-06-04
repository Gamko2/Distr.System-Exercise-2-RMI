package distr_exer2_rmi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Schedule extends UnicastRemoteObject implements ScheduleInterface {

    public Schedule() throws RemoteException {}
    private List<Lesson> lessons = new ArrayList<Lesson>();

    @Override
    public void addLesson(Lesson lesson) throws RemoteException {
        lessons.add(lesson);
    }

    @Override
    public void removeLesson(Lesson lesson) throws RemoteException {
         lessons.remove(lesson);
    }

    @Override
    public List<Lesson> getAllLessons() throws RemoteException {
        return lessons;
    }

    @Override
    public int getFreeTime(String day) throws RemoteException {
          int lessonCount=0;
       for (Lesson lesson:lessons){
           if (lesson.getDay().equals(day)){
               lessonCount++;
           }
       }
       return 10-lessonCount;
    }

    @Override
    public void saveToFile(String filename) throws RemoteException  {
             FileWriter fw= null;
        try {
            fw = new FileWriter(filename);
                 try (BufferedWriter bw = new BufferedWriter(fw)) {
                     for (Lesson lesson: getAllLessons()){
                         bw.write(lesson.toString());
                         bw.write("\r\n");
                     }    }
        } catch (IOException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}