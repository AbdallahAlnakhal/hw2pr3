/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class account {

    int id;
    int user_id;
    int account_number;
    String username;
    String currency;
    int balance;
    String creation_date;

    public account(int id, int account_number, String username, String currency, int balance, String creation_date) {
        this.id = id;

        this.account_number = account_number;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creation_date = creation_date;
    }

    public account(int account_number, String username, String currency, int balance, String creation_date) {
        this.id = id;

        this.account_number = account_number;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public int save() throws SQLException, ClassNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO ACCOUNTS (ID, USER_ID,ACCOUNT_NUMBER,USERNAME,CURRENCY,BALANCE ,CREATION_DATE) VALUES ( ?,?, ?, ?,?,? ,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setInt(2, this.getUser_id());
        ps.setInt(3, this.getAccount_number());
        ps.setString(4, this.getUsername());
        ps.setString(5, this.getCurrency());
        ps.setInt(6, this.getBalance());
        ps.setString(7, now.toString());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(
                    " Account was added successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public int Update() throws SQLException {

        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE ACCOUNTS SET  ACCOUNT_NUMBER=? ,USERNAME=? ,CURRRENCY=? ,BALANCE=? ,CREATION_DATE=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getAccount_number());
        ps.setString(2, this.getUsername());
        ps.setString(3, this.getCurrency());
        ps.setInt(4, this.getBalance());
        ps.setString(5, this.getCreation_date());
        ps.setInt(6, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with id : " + this.getId() + " was updated successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;

    }

    public static ArrayList<account> getAllAccount() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<account> accc = new ArrayList<>();
        String sql = "SELECT * FROM accounts ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            account acc = new account(rs.getInt(1), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
            acc.setId(rs.getInt(1));
            accc.add(acc);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return accc;
    }
}
