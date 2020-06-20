
package com.PhoneStoreManager.BackEnd.Quanlyloaisanpham;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlyloaisanphamDAO {
    private ConnectDB qllspDAO;
    
    public QuanlyloaisanphamDAO() {
        qllspDAO = new ConnectDB();
        System.out.println("Database Loại Sản Phẩm");
    }
    
    public ArrayList<LoaiSanPham> SelectLSP(){
//        qllspDAO = new ConnectDB();
        qllspDAO.OpenDB();
        String sql = "SELECT * FROM loaisanpham";
        System.out.println("---SQL: " + sql);
        ResultSet res = qllspDAO.SelectSQL(sql);
        ArrayList<LoaiSanPham> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    String MaLSP = res.getString("MaLSP");
                    String TenLSP = res.getString("TenLSP");
                    String Mota = res.getString("Mota");
                    
                    a.add(new LoaiSanPham(MaLSP, TenLSP, Mota));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyloaisanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng loaisanpham");
            } finally{
                qllspDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addLSP(LoaiSanPham q){
        String sql = "INSERT INTO loaisanpham VALUES('" + q.getMaLSP() + "','" + q.getTenLSP() + "','" + q.getMota() + "');";
        System.out.println("---SQL: " + sql);
        qllspDAO.OpenDB();
        boolean t = qllspDAO.UpdateSQL(sql);
        qllspDAO.CloseDB();
        return t;
    }
    
    public boolean deleteLSP(String MaLSP){
        String sql = "DELETE FROM loaisanpham WHERE MaLSP = '" + MaLSP + "'";
        System.out.println("---SQL: " + sql);
        qllspDAO.OpenDB();
        boolean t = qllspDAO.UpdateSQL(sql);
        qllspDAO.CloseDB();
        return t;
    }
    
    public boolean repairLSP(String MaLSP, String TenLSP, String Mota){
        String sql = "UPDATE loaisanpham SET TenLSP = '" + TenLSP + "', Mota = '" + Mota + "' WHERE MaLSP = '" + MaLSP + "'";
        System.out.println("---SQL: " + sql);
        qllspDAO.OpenDB();
        boolean t = qllspDAO.UpdateSQL(sql);
        qllspDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qllspDAO.CloseDB();
    }
}
