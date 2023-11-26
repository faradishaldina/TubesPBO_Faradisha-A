/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author faradisha
 */
public class Records {
    private int idrecords;
    private Passenger passenger = new Passenger();
    private Train train = new Train();
    private Ticket ticket = new Ticket();
    private Reservation reservation = new Reservation();
    private Transaction transaction = new Transaction();

    public int getIdrecords() {
        return idrecords;
    }

    public void setIdrecords(int idrecords) {
        this.idrecords = idrecords;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
    public Records(){}
    public Records (Train train, Passenger passenger, Ticket ticket, Reservation reservation, Transaction transaction){
        this.train = train;
        this.passenger = passenger;
        this.ticket = ticket;
        this.reservation = reservation;
        this.transaction = transaction;
    }
    
}
