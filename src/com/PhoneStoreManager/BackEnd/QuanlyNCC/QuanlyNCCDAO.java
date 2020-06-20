
package com.PhoneStoreManager.BackEnd.QuanlyNCC;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlyNCCDAO {
    private ConnectDB qlNCCDAO;

    public QuanlyNCCDAO() {
        qlNCCDAO = new ConnectDB();
        System.out.println("Database NCC");
    }
    
    public ArrayList<NCC> SelectNCC(){
//        qlquyenDAO = new ConnectDB();
        qlNCCDAO.OpenDB();
        String sql = "SELECT * FROM nhacungcap";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlNCCDAO.SelectSQL(sql);
        ArrayList<NCC> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    String MaNCC = res.getString("MaNCC");
                    String TenNCC = res.getString("TenNCC");
                    String DiaChi = res.getString("DiaChi");
                    String SDT = res.getString("SDT");
                    String Fax = res.getString("Fax");
                    
                    a.add(new NCC(MaNCC, TenNCC, DiaChi, SDT, Fax));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyNCCDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng nhacungcap");
            } finally{
                qlNCCDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addNCC(NCC ncc){
        String sql = "INSERT INTO nhacungcap VALUES('" + ncc.getMaNCC() + "','" + ncc.getTenNCC() + "','" + ncc.getDiaChi() + "','" + ncc.getSDT()
                + "','"+ ncc.getFax() + "');";
        System.out.println("---SQL: " + sql);
        qlNCCDAO.OpenDB();
        boolean t = qlNCCDAO.UpdateSQL(sql);
        qlNCCDAO.CloseDB();
        return t;
    }
    
    public boolean deleteNCC(String MaNCC){
        String sql = "DELETE FROM nhacungcap WHERE MaNCC = '" + MaNCC + "'";
        System.out.println("---SQL: " + sql);
        qlNCCDAO.OpenDB();
        boolean t = qlNCCDAO.UpdateSQL(sql);
        qlNCCDAO.CloseDB();
        return t;
    }
    
    public boolean repairNCC(String MaNCC, String TenNCC, String DiaChi, String SDT, String Fax){
        String sql = "UPDATE nhacungcap SET TenNCC = '" + TenNCC + "', DiaChi = '" + DiaChi + "', SDT = '" + SDT + "', Fax = '" + Fax
                +"' WHERE MaNCC = '" + MaNCC + "'";
        System.out.println("---SQL: " + sql);
        qlNCCDAO.OpenDB();
        boolean t = qlNCCDAO.UpdateSQL(sql);
        qlNCCDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qlNCCDAO.CloseDB();
    }
}
