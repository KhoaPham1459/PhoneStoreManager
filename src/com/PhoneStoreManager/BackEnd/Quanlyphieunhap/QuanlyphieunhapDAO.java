
package com.PhoneStoreManager.BackEnd.Quanlyphieunhap;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlyphieunhapDAO {
    private ConnectDB qlpnDAO;

    public QuanlyphieunhapDAO() {
        qlpnDAO = new ConnectDB();
        System.out.println("Database Phiếu Nhập");
    }
    
    public ArrayList<PhieuNhap> SelectPhieuNhap(){
        qlpnDAO.OpenDB();
        String sql = "SELECT * FROM phieunhap";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlpnDAO.SelectSQL(sql);
        ArrayList<PhieuNhap> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    PhieuNhap pn = new PhieuNhap();
                    pn.setMaPN(res.getString("MaPN"));
                    pn.setMaNCC(res.getString("MaNCC"));
                    pn.setMaNV(res.getString("MaNV"));
                    pn.setNgayNhap(res.getDate("NgayNhap").toLocalDate());
                    pn.setGioNhap(res.getTime("GioNhap").toLocalTime());
                    pn.setTongTien(res.getLong("TongTien"));
                    a.add(pn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyphieunhapDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng phieunhap");
            } finally{
                qlpnDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addPhieuNhap(PhieuNhap pn){
        qlpnDAO.OpenDB();
        boolean t = qlpnDAO.UpdateSQL("INSERT INTO phieunhap(MaPN,MaNCC,MaNV,NgayNhap,GioNhap,TongTien) VALUES ('" 
                + pn.getMaPN()+ "','" 
                + pn.getMaNCC()+ "','" 
                + pn.getMaNV()+ "','" 
                + pn.getNgayNhap()+ "','" 
                + pn.getGioNhap()+ "','" 
                + pn.getTongTien() + "');");
        qlpnDAO.CloseDB();
        return t;
    }
    
    public boolean deletePhieuNhap(String MaPN){
        qlpnDAO.OpenDB();
        if (!qlpnDAO.UpdateSQL("DELETE FROM phieunhap WHERE Mapn='" + MaPN + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua phiếu nhập truoc !!!");
            return false;
        }
        qlpnDAO.CloseDB();
        return true;
    }
    
    public boolean repairPhieuNhap(PhieuNhap pn){
        qlpnDAO.OpenDB();
        boolean t = qlpnDAO.UpdateSQL("UPDATE phieunhap SET "
                + "MaNCC='" + pn.getMaNCC()
                + "', MaNV='" + pn.getMaNV()
                + "', NgayNhap='" + pn.getNgayNhap()
                + "', GioNhap='" + pn.getGioNhap()
                + "', TongTien='" + pn.getTongTien() 
                + "' WHERE MaPN='" + pn.getMaPN()+ "';");
        qlpnDAO.CloseDB();
        return t;
    }
    public Boolean updateTongTien(String MaPN, long TongTien) {
        qlpnDAO.OpenDB();
        boolean t = qlpnDAO.UpdateSQL("UPDATE phieunhap SET "
                + "TongTien='" + TongTien
                + "' WHERE MaPN='" + MaPN+ "';");
        qlpnDAO.CloseDB();
        return t;
    }
    
    public boolean repairPhieuNhap(String MaPN, String MaNCC, String MaNV, LocalDate NgayNhap, LocalTime GioNhap, long TongTien){
        PhieuNhap pn = new PhieuNhap(MaPN, MaNCC, MaNV, NgayNhap, GioNhap, TongTien);
        return repairPhieuNhap(pn);
    }
    
    public void close(){
        qlpnDAO.CloseDB();
    }
}
