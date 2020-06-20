
package com.PhoneStoreManager.BackEnd.Quanlychitiethoadon;

import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonDAO;
import java.util.ArrayList;

public class QuanlychitiethoadonBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã sản phẩm", "Số lượng", "Đơn giá"};
    public static String[] getHeaders = {"STT", "Mã sản phẩm", "Số lượng", "Đơn giá"};
    private static ArrayList<ChiTietHoaDon> a;
    private QuanlychitiethoadonDAO qlcthdDAO = new QuanlychitiethoadonDAO();

    public QuanlychitiethoadonBUS() {
        if(a == null){
            a = qlcthdDAO.SelectChiTietHoaDon();
        }
        else{
            if(a.size() <= 0){
                a = qlcthdDAO.SelectChiTietHoaDon();
            }
        }
    }
    
    public static ArrayList<ChiTietHoaDon> getChiTietHoaDon(String MaHD){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        for(ChiTietHoaDon q: a){
            if(q.getMaHD().equals(MaHD)){
                list.add(q);
            }
        }
        if(list.size() <= 0) return null;
        return list;
    }

    public static ArrayList<ChiTietHoaDon> getDSCTHD() {
        return a;
    }
    
    public boolean repaireChiTietHoaDon(String MaHD, String MaSP, int SoLuong, long DonGia){
        if(qlcthdDAO.repairChiTietHoaDon(MaHD, MaSP, SoLuong,  DonGia)){
            for(ChiTietHoaDon q: a){
                if(q.getMaHD().equals(MaHD) && q.getMaSP().equals(MaSP)){
                    q.setMaSP(MaSP);
                    q.setSoLuong(SoLuong);
                    q.setDonGia(DonGia);
                    return UpdateTongTien(MaHD);
                }
            }
        }
        return false;
    }
    
    public boolean UpdateTongTien(String MaHD){
        long tong = 0;
        for(ChiTietHoaDon cthd : a){
            if(cthd.getMaHD().equals(MaHD)){
                tong += (long)(cthd.getSoLuong() * cthd.getDonGia());
            }
        }
        QuanlyhoadonDAO qlhdDAO = new QuanlyhoadonDAO();
        return qlhdDAO.UpdateTongTien(MaHD, tong);
    }
    
    public boolean deleteKM(String MaHD, String MaSP){
        if(qlcthdDAO.deleteChiTietHoaDon(MaHD, MaSP)){
            int i = 0;
            for(ChiTietHoaDon q: a){
                if(q.getMaHD().equals(MaHD) && q.getMaSP().equals(MaSP)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addChiTietHoaDon(ChiTietHoaDon q){
        if(qlcthdDAO.addChiTietHoaDon(q)){
            a.add(q);
            return true;
        }
        return false;
    }
    
//    public static ArrayList<ChiTietHoaDon> SearchChiTietHoaDon(String s, String type){
//        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
//        s = s.toLowerCase();
//        switch(type){
//            case "Tất cả":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getMacthd().toLowerCase().contains(s) || q.getMaKH().toLowerCase().contains(s) || q.getMaKM().toLowerCase().contains(s) || 
//                            q.getMaNV().toLowerCase().contains(s) || q.getNgayLap().toString().contains(s) || q.getGioLap().toString().contains(s) ||
//                            Long.toString(q.getTongTien()).contains(s)) {
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Mã hóa đơn":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getMacthd().toLowerCase().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Mã nhân viên":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getMaNV().toLowerCase().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Mã khách hàng":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getMaKH().toLowerCase().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Mã khuyến mãi":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getMaKM().toLowerCase().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Ngày lập":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getNgayLap().toString().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Giờ lập":{
//                for(ChiTietHoaDon q: a){
//                    if(q.getGioLap().toString().contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            case "Tổng tiền":{
//                for(ChiTietHoaDon q: a){
//                    if(Long.toString(q.getTongTien()).contains(s)){
//                        list.add(q);
//                    }
//                }
//                break;
//            }
//            
//            default:break;
//        }
//        if(list.size() > 0) return list;
//        return null;
//    }
}
