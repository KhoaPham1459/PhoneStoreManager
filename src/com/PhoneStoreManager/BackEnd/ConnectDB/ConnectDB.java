
package com.PhoneStoreManager.BackEnd.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectDB {
    static int countConnection = 0;
    static int countQuery = 0;
    static int countUpdate = 0;
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet res = null;
    
    private String ipAddress = "jdbc:mysql://localhost:3306/";
    private String name_DB = null;
    private String username = null;
    private String pass = null;

    public ConnectDB() {
        CheckDrive();
        name_DB = "quanlycuahangdienthoai";
        username = "root";
        pass = "";
        OpenDB();
    }
    
    public ConnectDB(String name_DB) {
        CheckDrive();
        this.name_DB = name_DB;
    }
    
    public ConnectDB(String name_DB, String username, String pass){
        CheckDrive();
        this.name_DB = name_DB;
        this.username = username;
        this.pass = pass;
        OpenDB();
    }
    
    private void CheckDrive(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "-- ERROR! Không tìm thấy Driver mySQL");
        }
    }
    
    public void OpenDB(){
        try {
            String url = ipAddress + name_DB + "?useUnicode=true&characterEncoding=UTF-8";
            if(!checkConnect()){
                conn = DriverManager.getConnection(url, username, pass);
                stmt = conn.createStatement();
            }
            System.out.println("Kết nối thành công Database!!! ");
        } catch (Exception e) {
            System.out.println((char)27 + "[31m"  + "--Error: " + e.toString() + "** Không thể kết nối Database!!! ");
        }
    }
    
    public void CloseDB(){
        try{
            if(conn != null){
                conn.close();
                conn = null;
            }
            if(stmt != null){
                stmt.close();
                stmt = null;
            }
            System.out.println("Đã đóng Database!!");
        }
        catch(Exception e){
            System.out.println((char)27 + "[31m"  + "--Không thể đóng Database!!");
        }
    }
    
    public void loginDB(String user_Name, String pass) {
        this.username = user_Name;
        this.pass = pass;
        OpenDB();
    }
    
    public ResultSet SelectSQL(String sql){
        if(checkConnect()){
            try{
                res = stmt.executeQuery(sql);
                countQuery++;
                System.out.println(countQuery + ": Success Query! " + sql);
                return res;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "-- ERROR! Không thể lấy dữ liệu từ " + name_DB + "\n" + e.getLocalizedMessage());
                System.out.println((char)27 + "[31m"  + "--Lấy Database thất bại!!" + " " + e.toString());
                return null;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "-- ERROR! Chưa thiết lập kết nối tới '" + name_DB + "'. Vui lòng đăng nhập để thiết lập kết nối!");
        }
        return null;
    }
    
    public boolean UpdateSQL(String sql){
        if(checkConnect()){
            try{
                stmt.execute(sql);
                countUpdate++;
                System.out.println(countUpdate + ": Success Update! " + sql);
                return true;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "-- ERROR! Không thể ghi dữ liệu xuống " + name_DB + "\n" + e.getLocalizedMessage());
                System.out.println((char)27 + "[31m"  + "--Update Database thất bại!!" + " " + e.toString());
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "-- ERROR! Chưa thiết lập kết nối tới '" + name_DB + "'. Vui lòng đăng nhập để thiết lập kết nối!");
        }
        return false;
    }
    
    private Boolean checkConnect() {
        if (conn == null || stmt == null) {
            return false;
        }
        return true;
    }
}
