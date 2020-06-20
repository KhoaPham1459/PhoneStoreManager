
package com.PhoneStoreManager.BackEnd.Quanlyphieunhap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QuanlyphieunhapBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập", "Tổng tiền"};
    public static String[] getHeaders = {"STT", "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập", "Tổng tiền"};
    private static ArrayList<PhieuNhap> list;
    private QuanlyphieunhapDAO qlpnDAO = new QuanlyphieunhapDAO();

    public QuanlyphieunhapBUS() {
        if(list == null){
            list = qlpnDAO.SelectPhieuNhap();
        }
        else{
            if(list.size() <= 0){
                list = qlpnDAO.SelectPhieuNhap();
            }
        }
    }
    
    public static PhieuNhap getPhieuNhap(String Mapn){
        for(PhieuNhap q: list){
            if(q.getMaPN().equals(Mapn)){
                return q;
            }
        }
        return null;
    }

    public static ArrayList<PhieuNhap> getDSPN() {
        return list;
    }
    
    public static String MaPNnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(PhieuNhap q: list){
            s = q.getMaPN();
            s = s.trim();
            s = s.replace("PN", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "PN" + max;
    }
    
    public boolean repairePhieuNhap(String MaPN, String MaNCC, String MaNV, LocalDate NgayNhap, LocalTime GioNhap, long TongTien){
        if(qlpnDAO.repairPhieuNhap(MaPN, MaNCC, MaNV, NgayNhap, GioNhap, TongTien)){
            for(PhieuNhap q: list){
                if(q.getMaPN().equals(MaPN)){
                    q.setMaNV(MaNV);
                    q.setMaNCC(MaNCC);
                    q.setMaNV(MaNV);
                    q.setNgayNhap(NgayNhap);
                    q.setGioNhap(GioNhap);
                    q.setTongTien(TongTien);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deletePhieuNhap(String Mapn){
        if(qlpnDAO.deletePhieuNhap(Mapn)){
            int i = 0;
            for(PhieuNhap q: list){
                if(q.getMaPN().equals(Mapn)){
                    list.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addPhieuNhap(PhieuNhap q){
        if(qlpnDAO.addPhieuNhap(q)){
            list.add(q);
            return true;
        }
        return false;
    }
    
    public Boolean updateTongTien(String _mapn, long _tongTien) {
        Boolean success = qlpnDAO.updateTongTien(_mapn, _tongTien);
        if (success) {
            for (PhieuNhap q: list) {
                if (q.getMaPN().equals(_mapn)) {
                    q.setTongTien(_tongTien);
                }
            }
            return true;
        }
        return false;
    }
    
    public static ArrayList<PhieuNhap> SearchPhieuNhap(String s, String type){
        ArrayList<PhieuNhap> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(PhieuNhap q: list){
                    if(q.getMaPN().toLowerCase().contains(s) || q.getMaNCC().toLowerCase().contains(s) || q.getMaNV().toLowerCase().contains(s) || 
                            q.getNgayNhap().toString().contains(s) || q.getGioNhap().toString().contains(s) ||
                            Long.toString(q.getTongTien()).contains(s)) {
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã phiếu nhập":{
                for(PhieuNhap q: list){
                    if(q.getMaPN().toLowerCase().contains(s) ){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã nhà cung cấp":{
                for(PhieuNhap q: list){
                    if(q.getMaNCC().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã nhân viên":{
                for(PhieuNhap q: list){
                    if(q.getMaNV().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Ngày nhập":{
                for(PhieuNhap q: list){
                    if(q.getNgayNhap().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Giờ nhập":{
                for(PhieuNhap q: list){
                    if(q.getGioNhap().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tổng tiền":{
                for(PhieuNhap q: list){
                    if(Long.toString(q.getTongTien()).contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            
            default:break;
        }
        if(list.size() > 0) return list;
        return null;
    }
    
    public boolean UpdateTongTien(String MaPN, long TongTien){
        boolean t = qlpnDAO.updateTongTien(MaPN, TongTien);
        if (t) {
            for (PhieuNhap hd : list) {
                if (hd.getMaPN().equals(MaPN)) {
                    hd.setTongTien(TongTien);
                }
            }
            return true;
        }
        return false;
    }
    
    public static ArrayList<PhieuNhap> SearchPNFromDate(int yearfrom, int monthfrom, int dayfrom, int yearto, int monthto, int dayto){
        if(yearfrom < 0 || monthfrom < 0 || dayfrom < 0 || yearto < 0 || monthto < 0 || dayto < 0){
            return null;
        }
        
        if(!CompareDate(yearfrom, monthfrom, dayfrom, yearto, monthto, dayto)){
            return null;
        }
        ArrayList<PhieuNhap> list = new ArrayList<>();
        String[] s;
        int y ,m , d;
        for(PhieuNhap q : list){
            s = q.getNgayNhap().toString().split("-");
            y = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            d = Integer.parseInt(s[2]);
            if(CompareDate(yearfrom, monthfrom, dayfrom, y, m, d) && CompareDate(y, m, d, yearto, monthto, dayto)){
                list.add(q);
            }
        }
        if(list.size() <= 0) return null;
        return list;
    }
    
    public static ArrayList<PhieuNhap> SearchPhieuNhapsTongTienFromTo(long from, long to){
        if(from > to) return null;
        ArrayList<PhieuNhap> list = new ArrayList<>();
        for(PhieuNhap q: list){
            if(from <= q.getTongTien() && q.getTongTien() <= to){
                list.add(q);
            }
        }
        if(list.size() <= 0) return null;
        return list;
    }
    
    private static boolean CompareDate(int y1, int m1, int d1, int y2, int m2, int d2){
        if(y1 < y2) return true;
        if(y1 > y2) return false;
        if(m1 < m2) return true;
        if(m1 > m2) return false;
        if(d1 < d2) return true;
        if(d1 > d2) return false;
        return true;
    }
}
