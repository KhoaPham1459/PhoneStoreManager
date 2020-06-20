
package com.PhoneStoreManager.BackEnd.Quanlyhoadon;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class QuanlyhoadonBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập", "Giờ lập", "Tổng tiền"};
    public static String[] getHeaders = {"STT", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi", "Ngày lập", "Giờ lập", "Tổng tiền"};
    private static ArrayList<HoaDon> a;
    private QuanlyhoadonDAO qlhdDAO = new QuanlyhoadonDAO();

    public QuanlyhoadonBUS() {
        if(a == null){
            a = qlhdDAO.SelectHoaDon();
        }
        else{
            if(a.size() <= 0){
                a = qlhdDAO.SelectHoaDon();
            }
        }
    }
    
    public static HoaDon getHoaDon(String MaHD){
        for(HoaDon q: a){
            if(q.getMaHD().equals(MaHD)){
                return q;
            }
        }
        return null;
    }

    public static ArrayList<HoaDon> getDSHD() {
        return a;
    }
    
    public static String MaHDnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(HoaDon q: a){
            s = q.getMaHD();
            s = s.trim();
            s = s.replace("HD", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "HD" + max;
    }
    
    public boolean repaireHoaDon(String MaHD, String MaNV, String MaKH, String MaKM, LocalDate NgayLap, LocalTime GioLap, long TongTien){
        if(qlhdDAO.repairHoaDon(MaHD, MaNV, MaKH, MaKM, NgayLap, GioLap, TongTien)){
            for(HoaDon q: a){
                if(q.getMaHD().equals(MaHD)){
                    q.setMaNV(MaNV);
                    q.setMaKH(MaKH);
                    q.setMaKM(MaKM);
                    q.setNgayLap(NgayLap);
                    q.setGioLap(GioLap);
                    q.setTongTien(TongTien);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteKM(String MaHD){
        if(qlhdDAO.deleteHoaDon(MaHD)){
            int i = 0;
            for(HoaDon q: a){
                if(q.getMaHD().equals(MaHD)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addHoaDon(HoaDon q){
        if(qlhdDAO.addHoaDon(q)){
            a.add(q);
            return true;
        }
        return false;
    }
    
    public static ArrayList<HoaDon> SearchHoaDon(String s, String type){
        ArrayList<HoaDon> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(HoaDon q: a){
                    if(q.getMaHD().toLowerCase().contains(s) || q.getMaKH().toLowerCase().contains(s) || q.getMaKM().toLowerCase().contains(s) || 
                            q.getMaNV().toLowerCase().contains(s) || q.getNgayLap().toString().contains(s) || q.getGioLap().toString().contains(s) ||
                            Long.toString(q.getTongTien()).contains(s)) {
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã hóa đơn":{
                for(HoaDon q: a){
                    if(q.getMaHD().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã nhân viên":{
                for(HoaDon q: a){
                    if(q.getMaNV().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã khách hàng":{
                for(HoaDon q: a){
                    if(q.getMaKH().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã khuyến mãi":{
                for(HoaDon q: a){
                    if(q.getMaKM().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Ngày lập":{
                for(HoaDon q: a){
                    if(q.getNgayLap().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Giờ lập":{
                for(HoaDon q: a){
                    if(q.getGioLap().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tổng tiền":{
                for(HoaDon q: a){
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
    
    public boolean UpdateTongTien(String MaHD, long TongTien){
        boolean t = qlhdDAO.UpdateTongTien(MaHD, TongTien);
        if (t) {
            for (HoaDon hd : a) {
                if (hd.getMaHD().equals(MaHD)) {
                    hd.setTongTien(TongTien);
                }
            }
            return true;
        }
        return false;
    }
    
    public static ArrayList<HoaDon> SearchHDFromDate(int yearfrom, int monthfrom, int dayfrom, int yearto, int monthto, int dayto){
        if(yearfrom < 0 || monthfrom < 0 || dayfrom < 0 || yearto < 0 || monthto < 0 || dayto < 0){
            return null;
        }
        
        if(!CompareDate(yearfrom, monthfrom, dayfrom, yearto, monthto, dayto)){
            return null;
        }
        ArrayList<HoaDon> list = new ArrayList<>();
        String[] s;
        int y ,m , d;
        for(HoaDon q : a){
            s = q.getNgayLap().toString().split("-");
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
    
    public static ArrayList<HoaDon> SearchHoaDonTongTienFromTo(long from, long to){
        if(from > to) return null;
        ArrayList<HoaDon> list = new ArrayList<>();
        for(HoaDon q: a){
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
