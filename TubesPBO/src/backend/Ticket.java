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
public class Ticket {
    private int idticket;
    private Train train = new Train();
    private String schedule;
    private String seat;
    private String classs;

    public int getIdticket() {
        return idticket;
    }

    public void setIdticket(int idticket) {
        this.idticket = idticket;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }
    public Ticket(){}
    public Ticket(Train train, String schedule, String seat, String classs){
        this.train=train;
        this.schedule=schedule;
        this.seat=seat;
        this.classs=classs;
    }
    public Ticket getById(int id){
        Ticket ticket = new Ticket();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                  + " t2.idticket AS idticket, "
                                    + " t2.schedule AS schedule, "
                                    + " t2.seat AS seat, "
                                    + " t2.classs AS classs, "
                                    + " t.idtrain AS idtrain, "
                                    + " t.trainname AS trainname, "
                                    + " t.departuretime AS departuretime, "
                                    + " t.ticketprice AS ticketprice, "
                                    + " t.origin AS origin, "
                                    + " t.destination AS destination "
                                    + " FROM ticket t2 "
                                    + " LEFT JOIN train t ON t2.idtrain = t.idtrain "
                                    + " WHERE t2.idticket = '" + id + "'" );
        try{
            while(rs.next()){
                ticket = new Ticket();
                ticket.setIdticket(rs.getInt("idticket"));
                ticket.getTrain().setIdtrain(rs.getInt("idtrain"));
                ticket.getTrain().setTrainname(rs.getString("trainname"));
                ticket.getTrain().setDeparturetime(rs.getString("departuretime"));
                ticket.getTrain().setTicketprice(rs.getInt("ticketprice"));
                ticket.getTrain().setOrigin(rs.getString("origin"));
                ticket.getTrain().setDestination(rs.getString("destination"));
                ticket.setSchedule(rs.getString("schedule"));
                ticket.setSeat(rs.getString("seat"));
                ticket.setClasss(rs.getString("classs"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }    
    return ticket;
    }
    
    public ArrayList<Ticket> getAll(){
        ArrayList<Ticket> ListTicket = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                  + " t2.idticket AS idticket, "
                                    + " t2.schedule AS schedule, "
                                    + " t2.seat AS seat, "
                                    + " t2.classs AS classs, "
                                    + " t.idtrain AS idtrain, "
                                    + " t.trainname AS trainname, "
                                    + " t.departuretime AS departuretime, "
                                    + " t.ticketprice AS ticketprice, "
                                    + " t.origin AS origin, "
                                    + " t.destination AS destination "
                                    + " FROM ticket t2 "
                                    + " LEFT JOIN train t ON t2.idtrain = t.idtrain ");
        
        try{
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setIdticket(rs.getInt("idticket"));
                ticket.getTrain().setIdtrain(rs.getInt("idtrain"));
                ticket.getTrain().setTrainname(rs.getString("trainname"));
                ticket.getTrain().setDeparturetime(rs.getString("departuretime"));
                ticket.getTrain().setTicketprice(rs.getInt("ticketprice"));
                ticket.getTrain().setOrigin(rs.getString("origin"));
                ticket.getTrain().setDestination(rs.getString("destination"));
                ticket.setSchedule(rs.getString("schedule"));
                ticket.setSeat(rs.getString("seat"));
                ticket.setClasss(rs.getString("classs"));
                ListTicket.add(ticket);
            }
        } catch (Exception e){
            e.printStackTrace();
        }    
    return ListTicket;
    }
    public ArrayList<Ticket> search(String keyword){
        ArrayList<Ticket> ListTicket = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                + " t2.idticket AS idticket, "
                                    + " t2.schedule AS schedule, "
                                    + " t2.seat AS seat, "
                                    + " t2.classs AS classs, "
                                    + " t.idtrain AS idtrain, "
                                    + " t.trainname AS trainname, "
                                    + " t.departuretime AS departuretime, "
                                    + " t.ticketprice AS ticketprice, "
                                    + " t.origin AS origin, "
                                    + " t.destination AS destination "
                                    + " FROM ticket t2 "
                                    + " LEFT JOIN train t ON t2.idtrain = t.idtrain "
                                    + " WHERE t2.schedule LIKE '%" + keyword + "%' "
                                    + " OR t2.idticket LIKE '%" + keyword + "%' "
                                    + " OR t2.seat LIKE '%" + keyword + "%' "
                                    + " OR t2.classs LIKE '%" + keyword + "%' "
                                    + " OR t.trainname LIKE '%" + keyword + "%' "
                                    + " OR t.departuretime LIKE '%" + keyword + "%' ");
        
        try{
            while(rs.next()){
                Ticket ticket = new Ticket();
                ticket.setIdticket(rs.getInt("idticket"));
                ticket.getTrain().setIdtrain(rs.getInt("idtrain"));
                ticket.getTrain().setTrainname(rs.getString("trainname"));
                ticket.getTrain().setDeparturetime(rs.getString("departuretime"));
                ticket.getTrain().setTicketprice(rs.getInt("ticketprice"));
                ticket.getTrain().setOrigin(rs.getString("origin"));
                ticket.getTrain().setDestination(rs.getString("destination"));
                ticket.setSchedule(rs.getString("schedule"));
                ticket.setSeat(rs.getString("seat"));
                ticket.setClasss(rs.getString("classs"));
                ListTicket.add(ticket);
            }
        } catch (Exception e){
            e.printStackTrace();
        }    
    return ListTicket;
    }
    
    public void save(){
        if(getById(idticket).getIdticket()==0){
            String SQL = "INSERT INTO ticket (idtrain, schedule, seat, classs) VALUES("
            + " '" + this.getTrain().getIdtrain() + "', "
                + " '" + this.schedule + "', "
                + " '" + this.seat + "', "
                + " '" + this.classs + "' "
                + " )";
            this.idticket = DBHelper.insertQueryGetId(SQL);        
        } else {
            String SQL = "UPDATE ticket SET "
                + " idtrain = '" + this.getTrain().getIdtrain() + "', "
                + " schedule = '" + this.schedule + "', "
                + " seat = '" + this.seat + "', "
                + " classs = '" + this.classs + "' "
                + " WHERE idticket = '" + this.idticket + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM ticket WHERE idticket '" + this.idticket + "'";
        DBHelper.executeQuery(SQL);
    }
}