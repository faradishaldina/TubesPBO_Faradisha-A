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
public class Train {
    private int idtrain;
    private String trainname;
    private String departuretime;
    private int ticketprice;
    private String origin;
    private String destination;
    
    public Train(){
    }
    
    public Train(String trainname, String departuretime, int ticketprice, String origin, String destination){
    this.trainname = trainname;
    this.departuretime = departuretime;
    this.ticketprice = ticketprice;
    this.origin = origin;
    this.destination = destination;
    }

    public int getIdtrain() {
        return idtrain;
    }

    public void setIdtrain(int idtrain) {
        this.idtrain = idtrain;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public int getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(int ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String toString(){
        return trainname;
    }
    
    public Train getById(int id){
        Train train = new Train();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM train " + " WHERE idtrain = '" + id + "'");
        try {
            while(rs.next()){
                train = new Train();
                train.setIdtrain(rs.getInt("idtrain"));
                train.setTrainname(rs.getString("trainname"));
                train.setDeparturetime(rs.getString("departuretime"));
                train.setTicketprice(rs.getInt("ticketprice"));
                train.setOrigin(rs.getString("origin"));
                train.setDestination(rs.getString("destination"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return train;
    }
    
    public ArrayList<Train> getAll(){
        ArrayList<Train> ListKategori = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM train");
        try {
            while(rs.next()){
                Train train = new Train();
                train.setIdtrain(rs.getInt("idtrain"));
                train.setTrainname(rs.getString("trainname"));
                train.setDeparturetime(rs.getString("departuretime"));
                train.setTicketprice(rs.getInt("ticketprice"));
                train.setOrigin(rs.getString("origin"));
                train.setDestination(rs.getString("destination"));
                ListKategori.add(train);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ListKategori;
    }
    public ArrayList<Train> search(String keyword) {
        ArrayList<Train> ListKategori = new ArrayList();
 
        String sql = "SELECT * FROM train WHERE "
        + " trainname LIKE '%" + keyword + "%' "
        + " OR departuretime LIKE '%" + keyword + 
       "%' "
        + " OR idtrain LIKE '%" + keyword + "%' "
        + " OR ticketprice LIKE '%" + keyword + 
       "%' "
        + " OR origin LIKE '%" + keyword + 
       "%' "
        + " OR destination LIKE '%" + keyword 
       + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);
 
        try {
        while(rs.next()) {
            Train train = new Train();
                train.setIdtrain(rs.getInt("idtrain"));
                train.setTrainname(rs.getString("trainname"));
                train.setDeparturetime(rs.getString("departuretime"));
                train.setTicketprice(rs.getInt("ticketprice"));
                train.setOrigin(rs.getString("origin"));
                train.setDestination(rs.getString("destination"));
                ListKategori.add(train);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ListKategori;
        }
    public void save(){
        if(getById(idtrain).getIdtrain()==0){
            String SQL = "INSERT INTO train (trainname, departuretime, ticketprice, origin, destination) "
                    + "VALUES (" 
                    + " '" + this.trainname + "', "
                    + " '" + this.departuretime + "', "
                    + " '" + this.ticketprice + "', "
                    + " '" + this.origin + "', "
                    + " '" + this.destination + "' "
                    + " )";
                    this.idtrain = DBHelper.insertQueryGetId(SQL);
                    
        } else {
            String SQL = "UPDATE train SET "
            + " trainname = '" + this.trainname +"',"
            + " departuretime = '" + this.departuretime +"', "
            + " ticketprice = '" + this.ticketprice + "', "
            + " origin = '" + this.origin +"', "
            + " destination = '" + this.destination + "' "
            + " WHERE idtrain = '" + this.idtrain + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM train WHERE idtrain = '" + 
        this.idtrain + "'";
        DBHelper.executeQuery(SQL);
 }
    
}
