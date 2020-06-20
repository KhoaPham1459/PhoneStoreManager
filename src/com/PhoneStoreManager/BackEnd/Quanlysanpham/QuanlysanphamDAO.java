
package com.PhoneStoreManager.BackEnd.Quanlysanpham;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlysanphamDAO {
    private ConnectDB qlspDAO;

    public QuanlysanphamDAO() {
        qlspDAO = new ConnectDB();
        System.out.println("Database Sản Phẩm");
    }
    
    public ArrayList<SanPham> SelectSanPham(){
//        qlspDAO = new ConnectDB();
        qlspDAO.OpenDB();
        String sql = "SELECT * FROM sanpham";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlspDAO.SelectSQL(sql);
        ArrayList<SanPham> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    String MaSP = res.getString("MaSP");
                    String MaLSP = res.getString("MaLSP");
                    String TenSP = res.getString("TenSP");
                    long DonGia = res.getLong("DonGia");
                    int SoLuong = res.getInt("SoLuong");
                    String HinhAnh = res.getString("HinhAnh");
                    int TrangThai = res.getInt("TrangThai");
                    
                    a.add(new SanPham(MaSP, MaLSP, TenSP, DonGia, SoLuong, HinhAnh, TrangThai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlysanphamDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng sanpham");
            } finally{
                qlspDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addSanPham(SanPham q){
        String sql = "INSERT INTO sanpham VALUES('" + q.getMaSP() + "','" + q.getMaLSP()+ "','" + q.getTenSP()+ "','" + q.getDonGia() + "','"
                + q.getSoLuong() + "','" + q.getHinhAnh() + "','" + q.getTrangThai()+"');";
        System.out.println("---SQL: " + sql);
        qlspDAO.OpenDB();
        boolean t = qlspDAO.UpdateSQL(sql);
        qlspDAO.CloseDB();
        return t;
    }
    
    public boolean deleteSanPham(String MaSP){
        String sql = "DELETE FROM sanpham WHERE MaSP = '" + MaSP + "'";
        System.out.println("---SQL: " + sql);
        qlspDAO.OpenDB();
        boolean t = qlspDAO.UpdateSQL(sql);
        qlspDAO.CloseDB();
        return t;
    }
    
    public boolean repairSanPham(String MaSP, String MaLSP, String TenSP, long DonGia, int SoLuong, String HinhAnh, int TrangThai){
        String sql = "UPDATE sanpham SET MaLSP = '" + MaLSP + "', TenSP = '" + TenSP + "', DonGia = '" + DonGia + "', SoLuong = '" + SoLuong
                + "', HinhAnh ='" + HinhAnh + "', TrangThai = '" + TrangThai +"' WHERE MaSP = '" + MaSP + "'";
        System.out.println("---SQL: " + sql);
        qlspDAO.OpenDB();
        boolean t = qlspDAO.UpdateSQL(sql);
        qlspDAO.CloseDB();
        return t;
    }
    
    public Boolean updateSoLuong(String MaSP, int SoLuong) {
        qlspDAO = new ConnectDB();
        Boolean ok = qlspDAO.UpdateSQL("Update SanPham Set "
                + "SoLuong='" + SoLuong
                + "' where MaSP='" + MaSP + "'");
        qlspDAO.CloseDB();
        return ok;
    }
    
    public void close(){
        qlspDAO.CloseDB();
    }
}
