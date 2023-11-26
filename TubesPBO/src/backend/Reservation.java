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
public class Reservation {
    private int idreservation;
    private Passenger passenger = new Passenger();
    private Train train = new Train();
    private String departuredate;
    private String bookingdate;

    public int getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
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

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }
    
    public String toString(){
        return bookingdate;
    }
    
    public Reservation(){}
    
    public Reservation(Passenger passenger, Train train, String departuredate, String bookingdate){
        this.passenger=passenger;
        this.train=train;
        this.departuredate=departuredate;
        this.bookingdate=bookingdate;
    }
    
    public Reservation getById(int id){
        Reservation reservation = new Reservation();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                            + "    r.idreservation AS idreservation, "
                            + "    r.departuredate AS departuredate, "
                            + "    r.bookingdate AS bookingdate, "
                            + "    p.idpassenger AS idpassenger, "
                            + "    p.passengername AS passengername, "
                            + "    p.address AS address, "
                            + "    p.gender AS gender, "
                            + "    p.phone AS phone, "
                            + "    t.idtrain AS idtrain, "
                            + "    t.trainname AS trainname, "
                            + "    t.departuretime AS departuretime, "
                            + "    t.ticketprice AS ticketprice, "
                            + "    t.origin AS origin, "
                            + "    t.destination AS destination "
                            + "    FROM reservation r "
                            + "    INNER JOIN passenger p "
                            + "    ON p.idpassenger = r.idpassenger "
                            + "    INNER JOIN train t "
                            + "    ON t.idtrain = r.idtrain "
                            + "    WHERE idreservation = '" + id +"'");
        
        try {
            while(rs.next()){
                reservation = new Reservation();
                reservation.setIdreservation(rs.getInt("idreservation"));
                reservation.getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                reservation.getPassenger().setPassengername(rs.getString("passengername"));
                reservation.getPassenger().setAddress(rs.getString("address"));
                reservation.getPassenger().setGender(rs.getString("gender"));
                reservation.getPassenger().setPhone(rs.getString("phone"));
                reservation.getTrain().setIdtrain(rs.getInt("idtrain"));
                reservation.getTrain().setTrainname(rs.getString("trainname"));
                reservation.getTrain().setDeparturetime(rs.getString("departuretime"));
                reservation.getTrain().setTicketprice(rs.getInt("ticketprice"));
                reservation.getTrain().setOrigin(rs.getString("origin"));
                reservation.getTrain().setDestination(rs.getString("destination"));
                reservation.setDeparturedate(rs.getString("departuredate"));
                reservation.setBookingdate(rs.getString("bookingdate"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return reservation;
    }
    
    public ArrayList<Reservation> getAll(){
        ArrayList<Reservation> ListReservation = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                            + "    r.idreservation AS idreservation, "
                            + "    r.departuredate AS departuredate, "
                            + "    r.bookingdate AS bookingdate, "
                            + "    p.idpassenger AS idpassenger, "
                            + "    p.passengername AS passengername, "
                            + "    p.address AS address, "
                            + "    p.gender AS gender, "
                            + "    p.phone AS phone, "
                            + "    t.idtrain AS idtrain, "
                            + "    t.trainname AS trainname, "
                            + "    t.departuretime AS departuretime, "
                            + "    t.ticketprice AS ticketprice, "
                            + "    t.origin AS origin, "
                            + "    t.destination AS destination "
                            + "    FROM reservation r "
                            + "    INNER JOIN passenger p "
                            + "    ON p.idpassenger = r.idpassenger "
                            + "    INNER JOIN train t "
                            + "    ON t.idtrain = r.idtrain ");
        
        try {
            while(rs.next()){
                Reservation reservation = new Reservation();
                reservation.setIdreservation(rs.getInt("idreservation"));
                reservation.getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                reservation.getPassenger().setPassengername(rs.getString("passengername"));
                reservation.getPassenger().setAddress(rs.getString("address"));
                reservation.getPassenger().setGender(rs.getString("gender"));
                reservation.getPassenger().setPhone(rs.getString("phone"));
                reservation.getTrain().setIdtrain(rs.getInt("idtrain"));
                reservation.getTrain().setTrainname(rs.getString("trainname"));
                reservation.getTrain().setDeparturetime(rs.getString("departuretime"));
                reservation.getTrain().setTicketprice(rs.getInt("ticketprice"));
                reservation.getTrain().setOrigin(rs.getString("origin"));
                reservation.getTrain().setDestination(rs.getString("destination"));
                reservation.setDeparturedate(rs.getString("departuredate"));
                reservation.setBookingdate(rs.getString("bookingdate"));
                ListReservation.add(reservation);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return ListReservation;
    }
    
    public ArrayList<Reservation> search(String keyword){
        ArrayList<Reservation> ListReservation = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                            + "    r.idreservation AS idreservation, "
                            + "    r.departuredate AS departuredate, "
                            + "    r.bookingdate AS bookingdate, "
                            + "    p.idpassenger AS idpassenger, "
                            + "    p.passengername AS passengername, "
                            + "    p.address AS address, "
                            + "    p.gender AS gender, "
                            + "    p.phone AS phone, "
                            + "    t.idtrain AS idtrain, "
                            + "    t.trainname AS trainname, "
                            + "    t.departuretime AS departuretime, "
                            + "    t.ticketprice AS ticketprice, "
                            + "    t.origin AS origin, "
                            + "    t.destination AS destination "
                            + "    FROM reservation r "
                            + "    INNER JOIN passenger p "
                            + "    ON p.idpassenger = r.idpassenger "
                            + "    INNER JOIN train t "
                            + "    ON t.idtrain = r.idtrain "
                            + "    WHERE r.departuredate LIKE '%" + keyword + "%' "
                            + "    OR r.idreservation LIKE '%" + keyword + "%' "
                            + "    OR r.bookingdate LIKE '%" + keyword + "%' "
                            + "    OR p.passengername LIKE '%" + keyword + "%' "
                            + "    OR t.trainname LIKE '%" + keyword + "%' ");
        
         try {
            while(rs.next()){
                Reservation reservation = new Reservation();
                reservation.setIdreservation(rs.getInt("idreservation"));
                reservation.getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                reservation.getPassenger().setPassengername(rs.getString("passengername"));
                reservation.getPassenger().setAddress(rs.getString("address"));
                reservation.getPassenger().setGender(rs.getString("gender"));
                reservation.getPassenger().setPhone(rs.getString("phone"));
                reservation.getTrain().setIdtrain(rs.getInt("idtrain"));
                reservation.getTrain().setTrainname(rs.getString("trainname"));
                reservation.getTrain().setDeparturetime(rs.getString("departuretime"));
                reservation.getTrain().setTicketprice(rs.getInt("ticketprice"));
                reservation.getTrain().setOrigin(rs.getString("origin"));
                reservation.getTrain().setDestination(rs.getString("destination"));
                reservation.setDeparturedate(rs.getString("departuredate"));
                reservation.setBookingdate(rs.getString("bookingdate"));
                ListReservation.add(reservation);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return ListReservation;       
    }
    
    public void save(){
        if(getById(idreservation).getIdreservation()==0){
            String SQL = "INSERT INTO reservation (idpassenger, idtrain, departuredate, bookingdate) VALUES ("
                    +"         '" + this.getPassenger().getIdpassenger() + "', "
                    +"         '" + this.getTrain().getIdtrain() + "', "
                    +"         '" + this.departuredate + "', "
                    +"         '" + this.bookingdate + "' "
                    +"         )";
            this.idreservation = DBHelper.insertQueryGetId(SQL);
        
        } else {
            String SQL = "UPDATE reservation SET "
                    +" idpassenger = '" + this.getPassenger().getIdpassenger() + "', "
                    +" idtrain = '" + this.getTrain().getIdtrain() + "', "
                    +" departuredate = '" + this.departuredate + "', "
                    +" bookingdate = '" + this.bookingdate + "' "
                    +" WHERE idreservation = '" + this.idreservation + "'";
            DBHelper.executeQuery(SQL);
        }
    }
        
    public void delete(){
        String SQL = "DELETE FROM reservation WHERE idreservation = '" +this.idreservation + "'";
        DBHelper.executeQuery(SQL);
    }
        
}
    

