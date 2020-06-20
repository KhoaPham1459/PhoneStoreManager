
package com.PhoneStoreManager.BackEnd.Quanlychitiethoadon;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlychitiethoadonDAO {
    private ConnectDB qlcthdDAO;

    public QuanlychitiethoadonDAO() {
        qlcthdDAO = new ConnectDB();
        System.out.println("Database Chi Tiết Hóa Đơn");
    }
    
    public ArrayList<ChiTietHoaDon> SelectChiTietHoaDon(){
        qlcthdDAO.OpenDB();
        String sql = "SELECT * FROM Chitiethoadon";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlcthdDAO.SelectSQL(sql);
        ArrayList<ChiTietHoaDon> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    ChiTietHoaDon cthd = new ChiTietHoaDon();
                    cthd.setMaHD(res.getString("MaHD"));
                    cthd.setMaSP(res.getString("MaSP"));
                    cthd.setSoLuong(res.getInt("SoLuong"));
                    cthd.setDonGia(res.getLong("DonGia"));
                    a.add(cthd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlychitiethoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng chitiethoadon");
            } finally{
                qlcthdDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addChiTietHoaDon(ChiTietHoaDon cthd){
        qlcthdDAO.OpenDB();
        boolean t = qlcthdDAO.UpdateSQL("INSERT INTO Chitiethoadon(MaHD,MaSP,SoLuong,DonGia) VALUES ('" 
                + cthd.getMaHD()+ "','" 
                + cthd.getMaSP()+ "','" 
                + cthd.getSoLuong()+ "','" 
                + cthd.getDonGia()+ "');");
        qlcthdDAO.CloseDB();
        return t;
    }
    
    public boolean deleteChiTietHoaDon(String MaHD, String MaSP){
        qlcthdDAO.OpenDB();
        boolean t = qlcthdDAO.UpdateSQL("DELETE FROM Chitiethoadon WHERE "
                + "MaHD='" + MaHD
                + "' AND MaSP='" + MaSP + "';");
        qlcthdDAO.CloseDB();
        return t;
    }
    
    public Boolean deleteAll(String MaHD) {
        qlcthdDAO.OpenDB();
        boolean t = qlcthdDAO.UpdateSQL("DELETE FROM Chitiethoadon WHERE MaHD='" + MaHD + "';");
        qlcthdDAO.CloseDB();
        return t;
    }
    
    public boolean repairChiTietHoaDon(ChiTietHoaDon ct){
        qlcthdDAO.OpenDB();
        boolean t = qlcthdDAO.UpdateSQL("UPDATE Chitiethoadon set "
                + "SoLuong='" + ct.getSoLuong()
                + "', DonGia='" + ct.getDonGia()
                + "' WHERE MaHD='" + ct.getMaHD()+ "' AND MaSP='" + ct.getMaSP()+ "';");
        qlcthdDAO.CloseDB();
        return t;
    }
    
    public boolean repairChiTietHoaDon(String MaHD, String MaSP, int SoLuong, long DonGia){
        ChiTietHoaDon cthd = new ChiTietHoaDon(MaHD, MaSP, SoLuong, DonGia);
        return repairChiTietHoaDon(cthd);
    }
    
    public void close(){
        qlcthdDAO.CloseDB();
    }
}
