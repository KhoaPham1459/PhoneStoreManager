
package com.PhoneStoreManager.BackEnd.Xulytaikhoan;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class XulyTaiKhoanDAO {
    private ConnectDB xltkConnect;

    public XulyTaiKhoanDAO() {
        xltkConnect = new ConnectDB();
        System.out.println("Database Tài khoản");
    }
    
    public ArrayList<TaiKhoan> SelectTaiKhoan(){
//        xltkConnect = new ConnectDB();
        xltkConnect.OpenDB();
        ArrayList<TaiKhoan> a = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM taikhoan";
            System.out.println("---SQL: " + sql);
            ResultSet res = xltkConnect.SelectSQL(sql);
            if(res != null){
                while(res.next()){
                    String ten = res.getString("TenTaiKhoan");
                    String pass = res.getString("MatKhau");
                    String manv = res.getString("MaNV");
                    String maquyen = res.getString("MaQuyen");

                    a.add(new TaiKhoan(ten, pass, manv, maquyen));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng tài khoản");
        } finally{
            xltkConnect.CloseDB();
        }
        return a;
    }
    
    public boolean addTaiKhoan(TaiKhoan tk){
//        xltkConnect = new ConnectDB();
        xltkConnect.OpenDB();
        String sql = "INSERT INTO taikhoan VALUES('" + tk.getTenTaiKhoan() + "', '" + tk.getMatKhau() +
                "', '" + tk.getMaNV() + "', '" + tk.getMaQuyen()+"');";
        System.out.println("---SQL: " + sql);
        boolean t = xltkConnect.UpdateSQL(sql);
        return t;
    }
    
    public boolean deleteTaiKhoan(String username){
//        xltkConnect = new ConnectDB();
        xltkConnect.OpenDB();
        String sql = "DELETE FROM taikhoan WHERE TenTaiKhoan = '" + username + "'";
        System.out.println("---SQL: " + sql);
        boolean t = xltkConnect.UpdateSQL(sql);
        return t;
    }
    
    public boolean repairTaiKhoan(String username, String pass, String maNV, String maQuyen){
//        xltkConnect = new ConnectDB();
        xltkConnect.OpenDB();
        String sql = "UPDATE taikhoan SET MatKhau = '" + pass + "', MaNV = '" + maNV + "', MaQuyen = '" + maQuyen + "' WHERE"
                + " TenTaiKhoan = '" + username + "'";
        System.out.println("---SQL: " + sql);
        boolean t = xltkConnect.UpdateSQL(sql);
        return t;
    }
    
    public void close(){
        xltkConnect.CloseDB();
    }
}
