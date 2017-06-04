/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distr_exer2_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

/**
 *
 * @author Marc
 */
public interface LessonInterface extends Remote{
    void setTitle(String title)throws RemoteException;
     String getTitle()throws RemoteException;
     String getDay()throws RemoteException;
     void setDay(String day)throws RemoteException;
     void setStartTime(LocalTime startTime)throws RemoteException;
     LocalTime getStartTime()throws RemoteException;
     String toString();
     boolean equals (Object other);
    
    
    
}
