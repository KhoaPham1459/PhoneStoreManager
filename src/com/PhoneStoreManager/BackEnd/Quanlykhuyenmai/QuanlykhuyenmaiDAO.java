
package com.PhoneStoreManager.BackEnd.Quanlykhuyenmai;

import com.PhoneStoreManager.BackEnd.ConnectDB.ConnectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanlykhuyenmaiDAO {
    private ConnectDB qlKMDAO;

    public QuanlykhuyenmaiDAO() {
        qlKMDAO = new ConnectDB();
        System.out.println("Database Khuyến Mãi");
    }
    
    public ArrayList<KhuyenMai> SelectKhuyenMai(){
//        qlKMDAO = new ConnectDB();
        qlKMDAO.OpenDB();
        String sql = "SELECT * FROM khuyenmai";
        System.out.println("---SQL: " + sql);
        ResultSet res = qlKMDAO.SelectSQL(sql);
        ArrayList<KhuyenMai> a = new ArrayList<>();
        if(res != null){
            try {
                while(res.next()){
                    String MaKM = res.getString("MaKM");
                    String TenKM = res.getString("TenKM");
                    long DieuKienKM = res.getLong("DieuKienKM");
                    int PhanTramKM = res.getInt("PhanTramKM");
                    LocalDate NgayBD = res.getDate("NgayBD").toLocalDate();
                    LocalDate NgayKT = res.getDate("NgayKT").toLocalDate();
                    
                    a.add(new KhuyenMai(MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT));
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanlykhuyenmaiDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "--ERROR! Lỗi đọc dữ liệu từ bảng khuyenmai");
            } finally{
                qlKMDAO.CloseDB();
            }
        }
        return a;
    }
    
    public boolean addKhuyenMai(KhuyenMai q){
        String sql = "INSERT INTO khuyenmai VALUES('" + q.getMaKM() + "','" + q.getTenKM() + "','" + q.getDieuKienKM() + "','" + q.getPhanTramKM()
                + "','" + q.getNgayBD() + "','" + q.getNgayKT()+ "');";
        System.out.println("---SQL: " + sql);
        qlKMDAO.OpenDB();
        boolean t = qlKMDAO.UpdateSQL(sql);
        qlKMDAO.CloseDB();
        return t;
    }
    
    public boolean deleteKhuyenMai(String MaKM){
        String sql = "DELETE FROM khuyenmai WHERE MaKM = '" + MaKM + "'";
        System.out.println("---SQL: " + sql);
        qlKMDAO.OpenDB();
        boolean t = qlKMDAO.UpdateSQL(sql);
        qlKMDAO.CloseDB();
        return t;
    }
    
    public boolean repairKhuyenMai(String MaKM, String TenKM, long DieuKienKM, int PhanTramKM, LocalDate NgayBD, LocalDate NgayKT){
        String sql = "UPDATE khuyenmai SET TenKM = '" + TenKM + "', DieuKienKM = '" + DieuKienKM + "', PhanTramKM = '"
                + PhanTramKM + "', NgayBD = '" + NgayBD + "', NgayKT = '" + NgayKT + "' WHERE MaKM = '" + MaKM + "'";
        System.out.println("---SQL: " + sql);
        qlKMDAO.OpenDB();
        boolean t = qlKMDAO.UpdateSQL(sql);
        qlKMDAO.CloseDB();
        return t;
    }
    
    public boolean updateNgayKT(String MaKM, LocalDate NgayKT){
        String sql = "UPDATE khuyenmai SET NgayKT = '" + NgayKT + "' WHERE MaKM = '" + MaKM + "'";
        System.out.println("---SQL: " + sql);
        qlKMDAO.OpenDB();
        boolean t = qlKMDAO.UpdateSQL(sql);
        qlKMDAO.CloseDB();
        return t;
    }
    
    public void close(){
        qlKMDAO.CloseDB();
    }
}
