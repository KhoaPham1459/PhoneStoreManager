
package com.PhoneStoreManager.BackEnd.Quanlyquyen;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlyquyenDAO {
    private ConnectDB qlquyenDAO;

    public QuanlyquyenDAO() {
        qlquyenDAO = new ConnectDB();
        System.out.println("Database Quyền");
    }
    
    public ArrayList<Quyen> SelectQuyen(){
//        qlquyenDAO = new ConnectDB();
        qlquyenDAO.OpenDB();
        String sql = "SELECT * FROM phanquyen";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlquyenDAO.SelectSQL(sql);
        ArrayList<Quyen> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    String MaQuyen = res.getString("MaQuyen");
                    String TenQuyen = res.getString("TenQuyen");
                    String ChiTietQuyen = res.getString("ChiTietQuyen");
                    
                    a.add(new Quyen(MaQuyen, TenQuyen, ChiTietQuyen));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyquyenDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng phanquyen");
            } finally{
                qlquyenDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addQuyen(Quyen q){
        String sql = "INSERT INTO phanquyen VALUES('" + q.getMaQuyen() + "','" + q.getTenQuyen() + "','" + q.getChiTietQuyen() + "');";
        System.out.println("---SQL: " + sql);
        qlquyenDAO.OpenDB();
        boolean t = qlquyenDAO.UpdateSQL(sql);
        qlquyenDAO.CloseDB();
        return t;
    }
    
    public boolean deleteQuyen(String MaQuyen){
        String sql = "DELETE FROM phanquyen WHERE MaQuyen = '" + MaQuyen + "'";
        System.out.println("---SQL: " + sql);
        qlquyenDAO.OpenDB();
        boolean t = qlquyenDAO.UpdateSQL(sql);
        qlquyenDAO.CloseDB();
        return t;
    }
    
    public boolean repairQuyen(String MaQuyen, String TenQuyen, String ChiTietQuyen){
        String sql = "UPDATE phanquyen SET TenQuyen = '" + TenQuyen + "', ChiTietQuyen = '" + ChiTietQuyen + "' WHERE MaQuyen = '" + MaQuyen + "'";
        System.out.println("---SQL: " + sql);
        qlquyenDAO.OpenDB();
        boolean t = qlquyenDAO.UpdateSQL(sql);
        qlquyenDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qlquyenDAO.CloseDB();
    }
}
