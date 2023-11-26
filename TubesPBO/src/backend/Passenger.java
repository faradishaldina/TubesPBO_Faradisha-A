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
public class Passenger {
    private int idpassenger;
    private String passengername;
    private String address;
    private String gender;
    private String phone;
    
    public Passenger(){}
    public Passenger(String passengername, String address, String gender, String phone){
        this.passengername = passengername;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getIdpassenger() {
        return idpassenger;
    }

    public void setIdpassenger(int idpassenger) {
        this.idpassenger = idpassenger;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString(){
        return passengername;
    }
    
    public Passenger getById(int id){
        Passenger passenger = new Passenger();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM passenger " + " WHERE idpassenger = '" + id + "'");
        try{
            while(rs.next()){
                passenger = new Passenger();
                passenger.setIdpassenger(rs.getInt("idpassenger"));
                passenger.setPassengername(rs.getString("passengername"));
                passenger.setAddress(rs.getString("address"));
                passenger.setGender(rs.getString("gender"));
                passenger.setPhone(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passenger;
    }
    
     public ArrayList<Passenger> getAll() {
        ArrayList<Passenger> ListKategori = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM passenger");
        try{
            while(rs.next()){
                Passenger passenger = new Passenger();
                passenger.setIdpassenger(rs.getInt("idpassenger"));
                passenger.setPassengername(rs.getString("passengername"));
                passenger.setAddress(rs.getString("address"));
                passenger.setGender(rs.getString("gender"));
                passenger.setPhone(rs.getString("phone"));
                ListKategori.add(passenger);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
     
    public ArrayList<Passenger> search(String keyword) {
        ArrayList<Passenger> ListKategori = new ArrayList();
        
        String sql = "SELECT * FROM passenger WHERE "
                + "     idpassenger LIKE '%" + keyword + "%' "
                + "     OR passengername LIKE '%" + keyword + "%' "
                + "     OR address LIKE '%" + keyword + "%' "
                + "     OR gender LIKE '%" + keyword + "%' "
                + "     OR phone LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Passenger passenger = new Passenger();
                passenger.setIdpassenger(rs.getInt("idpassenger"));
                passenger.setPassengername(rs.getString("passengername"));
                passenger.setAddress(rs.getString("address"));
                passenger.setGender(rs.getString("gender"));
                passenger.setPhone(rs.getString("phone"));
                ListKategori.add(passenger);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public void save(){
        if(getById(idpassenger).getIdpassenger()==0){
            String SQL = "INSERT INTO passenger (passengername, address, gender, phone) VALUES("
                    + "     '" + this.passengername + "', "
                    + "     '" + this.address + "', "
                    + "     '" + this.gender + "', "
                    + "     '" + this.phone + "' "
                    + "     )";
            this.idpassenger = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE passenger SET "
                    + "     namapenumpang = '" + this.passengername +"', "
                    + "     alamat = '" + this.address + "', "
                    + "     gender = '" + this.gender +"', "
                    + "     notelepon = '" + this.phone + "' "
                    + "     WHERE idpenumpang = '" + this.idpassenger + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM passenger WHERE idpassenger = '" + this.idpassenger + "'";
        DBHelper.executeQuery(SQL);
    }
        
        
    
}
