
package com.PhoneStoreManager.BackEnd.Quanlykhachhang;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlykhachhangDAO {
    private ConnectDB qlkhDAO;

    public QuanlykhachhangDAO() {
        qlkhDAO = new ConnectDB();
        System.out.println("Database Khách Hàng");
    }
    
    public ArrayList<KhachHang> SelectKhachHang(){
        String sql = "SELECT * FROM khachhang";
        ArrayList<KhachHang> a = new ArrayList<>();
//        qlkhDAO = new ConnectDB();
        System.out.println("---SQL: " + sql);
        qlkhDAO.OpenDB();
        ResultSet res = qlkhDAO.SelectSQL(sql);
        if(res != null){
            try {
                while(res.next()){
                    String MaKH = res.getString("MaKH");
                    String TenKH = res.getString("TenKH");
                    String DiaChi = res.getString("DiaChi");
                    String SDT = res.getString("SDT");
                    int TrangThai = res.getInt("TrangThai");
                    a.add(new KhachHang(MaKH, TenKH, DiaChi, SDT, TrangThai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlykhachhangDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng khachhang");
            } finally{
                qlkhDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addKhachHang(KhachHang KH){
//        qlkhDAO = new ConnectDB();
        qlkhDAO.OpenDB();
        String sql = "INSERT INTO khachhang VALUES('" + KH.getMaKH() + "','" + KH.getTenKH() + "','" +
                KH.getDiaChi() + "','" + KH.getSDT() + "','" + KH.getTrangThai() + "');";
        System.out.println("---SQL: " + sql);
        boolean t = qlkhDAO.UpdateSQL(sql);
        qlkhDAO.CloseDB();
        return t;
    }
    
    public boolean repairKhachHang(String MaKH, String TenKH, String DiaChi, String SDT, int TrangThai){
//        qlkhDAO = new ConnectDB();
        qlkhDAO.OpenDB();
        String sql = "UPDATE khachhang SET TenKH = '" + TenKH + "', DiaChi = '" + DiaChi + "', SDT = '" +
                SDT + "', TrangThai = '" + TrangThai +"' WHERE MaKH = '" + MaKH + "'";
        System.out.println("---SQL: " + sql);
        boolean t = qlkhDAO.UpdateSQL(sql);
        qlkhDAO.CloseDB();
        return t;
    }
    
    public boolean updateTrangThaiKhachHang(String MaKH){
//        qlkhDAO = new ConnectDB();
        qlkhDAO.OpenDB();
        String sql = "UPDATE khachhang SET TrangThai = '" + 0 + "' WHERE MaKH = '" + MaKH + "'";
        System.out.println("---SQL: " + sql);
        boolean t = qlkhDAO.UpdateSQL(sql);
        qlkhDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qlkhDAO.CloseDB();
    }
}
