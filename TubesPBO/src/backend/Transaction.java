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
public class Transaction {
    private int idtransaction;
    private String paydate;
    private int qtyticket;
    private int ticketprice;
    private int totalpay;
    private Reservation reservation = new Reservation();

    public int getIdtransaction() {
        return idtransaction;
    }

    public void setIdtransaction(int idtransaction) {
        this.idtransaction = idtransaction;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public int getQtyticket() {
        return qtyticket;
    }

    public void setQtyticket(int qtyticket) {
        this.qtyticket = qtyticket;
    }

    public int getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(int ticketprice) {
        this.ticketprice = ticketprice;
    }

    public int getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(int totalpay) {
        this.totalpay = totalpay;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    public Transaction(){}
    
    public Transaction(String paydate, int qtyticket, int ticketprice, int totalpay, Reservation reservation){
        this.paydate = paydate;
        this.qtyticket = qtyticket;
        this.ticketprice = ticketprice;
        this.totalpay = totalpay;
        this.reservation = reservation;
    }
    
    public Transaction getById(int id){
        Transaction transaction = new Transaction();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                        + "     t3.idtransaction AS idtransaction, "
                        + "     t3.paydate AS paydate, "
                        + "     t3.qtyticket AS qtyticket, "
                        + "     t3.ticketprice AS ticketprice, "
                        + "     t3.totalpay AS totalpay, "
                        + "     r.idreservation AS idreservation, "
                        + "     r.idpassenger AS idpassenger, "
                        + "     r.idtrain AS idtrain, "
                        + "     r.departuredate AS departuredate, "
                        + "     r.bookingdate AS bookingdate "
                        + "     FROM transaction t3 "
                        + "     LEFT JOIN reservation r ON r.idreservation = t3.idreservation "
                        + "     WHERE t3.idtransaction = '" + id + "'");
        
        try {
            while(rs.next()){
                transaction = new Transaction();
                transaction.setIdtransaction(rs.getInt("idtransaction"));
                transaction.setPaydate(rs.getString("paydate"));
                transaction.setQtyticket(rs.getInt("qtyticket"));
                transaction.setTicketprice(rs.getInt("ticketprice"));
                transaction.setTotalpay(rs.getInt("totalpay"));
                transaction.getReservation().setIdreservation(rs.getInt("idreservation"));
                transaction.getReservation().getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                transaction.getReservation().getTrain().setIdtrain(rs.getInt("idtrain"));
                transaction.getReservation().setDeparturedate(rs.getString("departuredate"));
                transaction.getReservation().setBookingdate(rs.getString("bookingdate"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return transaction;
    }
    
    public ArrayList<Transaction> getAll(){
        ArrayList<Transaction> ListTransaction = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                        + "     t3.idtransaction AS idtransaction, "
                        + "     t3.paydate AS paydate, "
                        + "     t3.qtyticket AS qtyticket, "
                        + "     t3.ticketprice AS ticketprice, "
                        + "     t3.totalpay AS totalpay, "
                        + "     r.idreservation AS idreservation, "
                        + "     r.idpassenger AS idpassenger, "
                        + "     r.idtrain AS idtrain, "
                        + "     r.departuredate AS departuredate, "
                        + "     r.bookingdate AS bookingdate "
                        + "     FROM transaction t3 "
                        + "     LEFT JOIN reservation r ON r.idreservation = t3.idreservation ");
         try {
            while(rs.next()){
                Transaction transaction = new Transaction();
                transaction.setIdtransaction(rs.getInt("idtransaction"));
                transaction.setPaydate(rs.getString("paydate"));
                transaction.setQtyticket(rs.getInt("qtyticket"));
                transaction.setTicketprice(rs.getInt("ticketprice"));
                transaction.setTotalpay(rs.getInt("totalpay"));
                transaction.getReservation().setIdreservation(rs.getInt("idreservation"));
                transaction.getReservation().getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                transaction.getReservation().getTrain().setIdtrain(rs.getInt("idtrain"));
                transaction.getReservation().setDeparturedate(rs.getString("departuredate"));
                transaction.getReservation().setBookingdate(rs.getString("bookingdate"));
                
                ListTransaction.add(transaction);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaction;        
    }
    
    public ArrayList<Transaction> search(String keyword){
        ArrayList<Transaction> ListTransaction = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT" 
                        + "     t3.idtransaction AS idtransaction, "
                        + "     t3.paydate AS paydate, "
                        + "     t3.qtyticket AS qtyticket, "
                        + "     t3.ticketprice AS ticketprice, "
                        + "     t3.totalpay AS totalpay, "
                        + "     r.idreservation AS idreservation, "
                        + "     r.idpassenger AS idpassenger, "
                        + "     r.idtrain AS idtrain, "
                        + "     r.departuredate AS departuredate, "
                        + "     r.bookingdate AS bookingdate "
                        + "     FROM transaction t3 "
                        + "     LEFT JOIN reservation r ON r.idreservation = t3.idreservation "
                        + "     WHERE t3.paydate LIKE '%" + keyword + "%' "
                                    + "         OR t3.idtransaction LIKE '%" + keyword + "%' "
                                    + "         OR t3.qtyticket LIKE '%" + keyword + "%' "
                                    + "         OR t3.ticketprice LIKE '%" + keyword + "%' "
                                    + "         OR t3.totalpay LIKE '%" + keyword + "%' "
                                    + "         OR r.bookingdate LIKE '%" + keyword + "%' ");
        try {
            while(rs.next()){
                Transaction transaction = new Transaction();
                transaction.setIdtransaction(rs.getInt("idtransaction"));
                transaction.setPaydate(rs.getString("paydate"));
                transaction.setQtyticket(rs.getInt("qtyticket"));
                transaction.setTicketprice(rs.getInt("ticketprice"));
                transaction.setTotalpay(rs.getInt("totalpay"));
                transaction.getReservation().setIdreservation(rs.getInt("idreservation"));
                transaction.getReservation().getPassenger().setIdpassenger(rs.getInt("idpassenger"));
                transaction.getReservation().getTrain().setIdtrain(rs.getInt("idtrain"));
                transaction.getReservation().setDeparturedate(rs.getString("departuredate"));
                transaction.getReservation().setBookingdate(rs.getString("bookingdate"));
                
                ListTransaction.add(transaction);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaction;        
    }
    
    public void save(){
        if(getById(idtransaction).getIdtransaction()==0){
            String SQL = "INSERT INTO transaction (paydate, qtyticket, ticketprice, totalpay, idreservation) VALUES ("
                + " '" + this.paydate + "', "
                + " '" + this.qtyticket + "', "
                + " '" + this.ticketprice + "', "
                + " '" + this.totalpay + "', "
                + " '" + this.getReservation().getIdreservation() + "' "
                + " )";
            this.idtransaction = DBHelper.insertQueryGetId(SQL);
        } else {
             String SQL = "UPDATE transaction SET "  
                + " paydate = '" + this.paydate + "', "
                + " qtyticket = '" + this.qtyticket + "', "
                + " ticketprice = '" + this.ticketprice + "', "
                + " totalpay = '" + this.totalpay + "', "
                + " idreservation = '" + this.getReservation().getIdreservation() + "' "
                + " WHERE idtransaction = '" + this.idtransaction + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM transaction WHERE idtransaction = '" + this.idtransaction + "'";
        DBHelper.executeQuery(SQL);
    }
    
}
