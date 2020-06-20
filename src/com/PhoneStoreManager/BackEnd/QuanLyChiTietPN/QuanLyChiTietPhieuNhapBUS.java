
package com.PhoneStoreManager.BackEnd.QuanLyChiTietPN;

import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.QuanlyphieunhapDAO;
import java.util.ArrayList;

public class QuanLyChiTietPhieuNhapBUS {

    public static String[] getComboboxSearch = {"Tất cả", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"};
    public static String[] getHeaders = {"STT", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"};
    private static ArrayList<ChiTietPhieuNhap> b;
    private QuanLyChiTietPhieuNhapDAO qlctpnDAO = new QuanLyChiTietPhieuNhapDAO();

    public QuanLyChiTietPhieuNhapBUS() {
        if(b == null){
            b = qlctpnDAO.SelectChiTietPhieuNhap();
        }
        else{
            if(b.size() <= 0){
                b = qlctpnDAO.SelectChiTietPhieuNhap();
            }
        }
    }
    
    public static ArrayList<ChiTietPhieuNhap> getChiTietPhieuNhap(String MaPN){
        ArrayList<ChiTietPhieuNhap> list = new ArrayList<>();
        for(ChiTietPhieuNhap q: b){
            if(q.getMaPN().equals(MaPN)){
                list.add(q);
            }
        }
        if(list.size() <= 0) return null;
        return list;
    }
    
    public static ArrayList<ChiTietPhieuNhap> getDSCTPN() {
        return b;
    }
    
    public boolean repaireChiTietPhieuNhap(String MaPN, String MaSP, int SoLuong, long DonGia){
        if(qlctpnDAO.repairChiTietPhieuNhap(MaPN, MaSP, SoLuong, DonGia)){
            for(ChiTietPhieuNhap q: b){
                if(q.getMaPN().equals(MaPN) && q.getMaSP().equals(MaSP)){
                    q.setMaSP(MaSP);
                    q.setSoLuong(SoLuong);
                    q.setDonGia(DonGia);
                    return UpdateTongTien(MaPN);
                }
            }
        }
        return false;
    }
    
    public boolean UpdateTongTien(String MaPN){
        long tong = 0;
        for(ChiTietPhieuNhap ctpn : b){
            if(ctpn.getMaPN().equals(MaPN)){
                tong += (long)(ctpn.getSoLuong() * ctpn.getDonGia());
            }
        }
        QuanlyphieunhapDAO qlpnDAO = new QuanlyphieunhapDAO();
        return qlpnDAO.updateTongTien(MaPN, tong);
    }
    
    
    public boolean addChiTietPhieuNhap(ChiTietPhieuNhap q){
        if(qlctpnDAO.addChiTietHoaDon(q)){
            b.add(q);
            return true;
        }
        return false;
    }
}
