/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Marc
 */
public interface ScheduleInterface extends Remote{
   void addLesson(Lesson lesson) throws RemoteException;
   void removeLesson(Lesson lesson) throws RemoteException;
   List<Lesson> getAllLessons()throws RemoteException;
   int getFreeTime(String day)throws RemoteException;
   void saveToFile(String filename) throws RemoteException;
}
