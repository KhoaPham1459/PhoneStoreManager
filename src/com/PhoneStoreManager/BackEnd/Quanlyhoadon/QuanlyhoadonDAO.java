
package com.PhoneStoreManager.BackEnd.Quanlyhoadon;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlyhoadonDAO {
    private ConnectDB qlhdDAO;

    public QuanlyhoadonDAO() {
        qlhdDAO = new ConnectDB();
        System.out.println("Database Hóa Đơn");
    }
    
    public ArrayList<HoaDon> SelectHoaDon(){
        qlhdDAO.OpenDB();
        String sql = "SELECT * FROM hoadon";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlhdDAO.SelectSQL(sql);
        ArrayList<HoaDon> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(res.getString("MaHD"));
                    hd.setMaNV(res.getString("MaNV"));
                    hd.setMaKH(res.getString("MaKH"));
                    hd.setMaKM(res.getString("MaKM"));
                    hd.setNgayLap(res.getDate("NgayLap").toLocalDate());
                    hd.setGioLap(res.getTime("GioLap").toLocalTime());
                    hd.setTongTien(res.getLong("TongTien"));
                    a.add(hd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyhoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng hoadon");
            } finally{
                qlhdDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addHoaDon(HoaDon hd){
        qlhdDAO.OpenDB();
        boolean t = qlhdDAO.UpdateSQL("INSERT INTO hoadon(MaHD,MaNV,MaKH,MaKM,NgayLap,GioLap,TongTien) VALUES ('" 
                + hd.getMaHD()+ "','" 
                + hd.getMaNV()+ "','" 
                + hd.getMaKH()+ "','" 
                + hd.getMaKM()+ "','" 
                + hd.getNgayLap() + "','" 
                + hd.getGioLap() + "','" 
                + hd.getTongTien() + "');");
        qlhdDAO.CloseDB();
        return t;
    }
    
    public boolean deleteHoaDon(String MaHD){
        qlhdDAO.OpenDB();
        if (!qlhdDAO.UpdateSQL("DELETE FROM hoadon WHERE MaHD='" + MaHD + "';")) {
            JOptionPane.showMessageDialog(null, "Vui long xoa het chi tiet cua hoa don truoc !!!");
            return false;
        }
        qlhdDAO.CloseDB();
        return true;
    }
    
    public boolean repairHoaDon(HoaDon hd){
        qlhdDAO.OpenDB();
        boolean t = qlhdDAO.UpdateSQL("UPDATE hoadon SET "
                + "MaNV='" + hd.getMaNV()
                + "', MaKH='" + hd.getMaKH()
                + "', MaKM='" + hd.getMaKM()
                + "', NgayLap='" + hd.getNgayLap() 
                + "', GioLap='" + hd.getGioLap() 
                + "', TongTien='" + hd.getTongTien() 
                + "' WHERE MaHD='" + hd.getMaHD()+ "';");
        qlhdDAO.CloseDB();
        return t;
    }
    
    public boolean UpdateTongTien(String MaHD, long TongTien){
        qlhdDAO.OpenDB();
        boolean t = qlhdDAO.UpdateSQL("UPDATE hoadon SET "
                + "TongTien='" + TongTien
                + "' WHERE MaHD='" + MaHD+ "';");
        qlhdDAO.CloseDB();
        return t;
    }
    
    public boolean repairHoaDon(String MaHD, String MaNV, String MaKH, String MaKM, LocalDate NgayLap, LocalTime GioLap, long TongTien){
        HoaDon hd = new HoaDon(MaHD, MaNV, MaKH, MaKM, NgayLap, GioLap, TongTien);
        return repairHoaDon(hd);
    }
    
    public void close(){
        qlhdDAO.CloseDB();
    }
}
