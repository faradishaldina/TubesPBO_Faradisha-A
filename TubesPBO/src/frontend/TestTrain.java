/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;
import backend.*;
/**
 *
 * @author faradisha
 */
public class TestTrain {
    public static void main(String[] args){
        Train train1 = new Train("Tawang Alun", "17:45", 58000, "Malang", "Probolinggo");
        Train train2 = new Train("Penataran Dhoho", "12:30", 30000, "Malang", "Surabaya");
        Train train3 = new Train("Sriwijaya", "09.58", 109000, "Malang", "Pasar Senen");
        
        for(Train train : new Train().getAll()){
            System.out.println("==============================================");
            System.out.println("Train Name\t\t= " + train.getTrainname());
            System.out.println("Departure Time\t\t= " + train.getDeparturetime());
            System.out.println("Ticket Price\t\t= Rp." + train.getTicketprice());
            System.out.println("Origin\t\t= " + train.getOrigin());
            System.out.println("Destination\t\t= " + train.getDestination());
            
            System.out.println("==============================================");
        }
 
 // test search
 for(Train train : new Train().search("Tawang Alun")) {
 System.out.println("=================== SEARCH TRAIN =================");
 System.out.println("==============================================");
            System.out.println("Train Name\t\t= " + train.getTrainname());
            System.out.println("Departure Time\t\t= " + train.getDeparturetime());
            System.out.println("Ticket Price\t\t= Rp." + train.getTicketprice());
            System.out.println("Origin\t\t= " + train.getOrigin());
            System.out.println("Destination\t\t= " + train.getDestination());
 
        }
    }
}
