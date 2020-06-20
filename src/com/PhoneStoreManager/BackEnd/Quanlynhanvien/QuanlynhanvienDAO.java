
package com.PhoneStoreManager.BackEnd.Quanlynhanvien;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlynhanvienDAO {
    private ConnectDB qlnvDAO;

    public QuanlynhanvienDAO() {
        qlnvDAO = new ConnectDB();
        System.out.println("Database Nhân viên");
    }
    
    public ArrayList<NhanVien> SelectNhanVien(){
        String sql = "SELECT * FROM nhanvien";
        ArrayList<NhanVien> a = new ArrayList<>();
//        qlnvDAO = new ConnectDB();
        System.out.println("---SQL: " + sql);
        qlnvDAO.OpenDB();
        ResultSet res = qlnvDAO.SelectSQL(sql);
        if(res != null){
            try {
                while(res.next()){
                    String MaNV = res.getString("MaNV");
                    String TenNV = res.getString("TenNV");
                    String NgaySinh = res.getString("NgaySinh");
                    String DiaChi = res.getString("DiaChi");
                    String SDT = res.getString("SDT");
                    int TrangThai = res.getInt("TrangThai");
                    a.add(new NhanVien(MaNV, TenNV, NgaySinh, DiaChi, SDT, TrangThai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlynhanvienDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng nhanvien");
            } finally{
                qlnvDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addNhanVien(NhanVien nv){
//        qlnvDAO = new ConnectDB();
        qlnvDAO.OpenDB();
        String sql = "INSERT INTO nhanvien VALUES('" + nv.getMaNV() + "','" + nv.getTenNV() + "','" + nv.getNgaySinh() + "','" +
                nv.getDiaChi() + "','" + nv.getSDT() + "','" + nv.getTrangThai() + "');";
        System.out.println("---SQL: " + sql);
        boolean t = qlnvDAO.UpdateSQL(sql);
        qlnvDAO.CloseDB();
        return t;
    }
    
    public boolean repairNhanVien(String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT, int TrangThai){
//        qlnvDAO = new ConnectDB();
        qlnvDAO.OpenDB();
        String sql = "UPDATE nhanvien SET TenNV = '" + TenNV + "', NgaySinh = '" + NgaySinh + "', DiaChi = '" + DiaChi + "', SDT = '" +
                SDT + "', TrangThai = '" + TrangThai +"' WHERE MaNV = '" + MaNV + "'";
        System.out.println("---SQL: " + sql);
        boolean t = qlnvDAO.UpdateSQL(sql);
        qlnvDAO.CloseDB();
        return t;
    }
    
    public boolean updateTrangThaiNhanVien(String MaNV){
//        qlnvDAO = new ConnectDB();
        qlnvDAO.OpenDB();
        String sql = "UPDATE nhanvien SET TrangThai = '" + 0 + "' WHERE MaNV = '" + MaNV + "'";
        System.out.println("---SQL: " + sql);
        boolean t = qlnvDAO.UpdateSQL(sql);
        qlnvDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qlnvDAO.CloseDB();
    }
}
