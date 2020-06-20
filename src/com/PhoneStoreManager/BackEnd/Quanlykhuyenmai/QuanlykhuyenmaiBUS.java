
package com.PhoneStoreManager.BackEnd.Quanlykhuyenmai;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuanlykhuyenmaiBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã KM", "Tên KM", "Điều kiện KM", "Phần trăm KM", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"};
    public static String[] getHeaders = {"STT", "Mã KM", "Tên KM", "Điều kiện KM", "Phần trăm KM", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"};
    private static ArrayList<KhuyenMai> a;
    private QuanlykhuyenmaiDAO qlKMDAO = new QuanlykhuyenmaiDAO();

    public QuanlykhuyenmaiBUS() {
        if(a == null){
            a = qlKMDAO.SelectKhuyenMai();
        }
        else{
            if(a.size() <= 0){
                a = qlKMDAO.SelectKhuyenMai();
            }
        }
    }
    
    public static KhuyenMai getKhuyenMai(String MaKM){
        for(KhuyenMai q: a){
            if(q.getMaKM().equals(MaKM)){
                return q;
            }
        }
        return null;
    }

    public static ArrayList<KhuyenMai> getDSKM() {
        return a;
    }
    
    public static String MaKMnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(KhuyenMai q: a){
            s = q.getMaKM();
            s = s.trim();
            s = s.replace("KM", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "KM" + max;
    }
    
    public boolean repaireKhuyenMai(String MaKM, String TenKM, long DieuKienKM, int PhanTramKM, LocalDate NgayBD, LocalDate NgayKT){
        if(qlKMDAO.repairKhuyenMai(MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT)){
            for(KhuyenMai q: a){
                if(q.getMaKM().equals(MaKM)){
                    q.setTenKM(TenKM);
                    q.setDieuKienKM(DieuKienKM);
                    q.setPhanTramKM(PhanTramKM);
                    q.setNgayBD(NgayBD);
                    q.setNgayKT(NgayKT);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteKM(String MaKM){
        if(qlKMDAO.deleteKhuyenMai(MaKM)){
            int i = 0;
            for(KhuyenMai q: a){
                if(q.getMaKM().equals(MaKM)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addKhuyenMai(KhuyenMai q){
        if(qlKMDAO.addKhuyenMai(q)){
            a.add(q);
            return true;
        }
        return false;
    }
    
    public static ArrayList<KhuyenMai> SearchKhuyenMai(String s, String type){
        ArrayList<KhuyenMai> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(KhuyenMai q: a){
                    if(q.getMaKM().toLowerCase().contains(s) || q.getTenKM().toLowerCase().contains(s) || ToCurrent(Long.toString(q.getDieuKienKM())).contains(s)
                            || Integer.toString(q.getPhanTramKM()).contains(s) || q.getNgayBD().toString().toLowerCase().contains(s) ||
                            q.getNgayKT().toString().toLowerCase().contains(s)) {
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã KM":{
                for(KhuyenMai q: a){
                    if(q.getMaKM().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tên KM":{
                for(KhuyenMai q: a){
                    if(q.getTenKM().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Điều kiện KM":{
                for(KhuyenMai q: a){
                    if(ToCurrent(Long.toString(q.getDieuKienKM())).contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Phần trăm KM":{
                for(KhuyenMai q: a){
                    if(Integer.toString(q.getPhanTramKM()).contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Ngày bắt đầu":{
                for(KhuyenMai q: a){
                    if(q.getNgayBD().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Ngày kết thúc":{
                for(KhuyenMai q: a){
                    if(q.getNgayKT().toString().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Trạng thái":{
                LocalDate today = LocalDate.now();
                String[] day = today.toString().split("-");
                String[] kt;
                String[] bd;
                String trangthai;
                for(KhuyenMai q: a){
                    if(today.toString().equals(q.getNgayKT().toString())){
                        trangthai = "Đã kết thúc";
                    }
                    else{
                        kt = q.getNgayKT().toString().split("-");
                        bd = q.getNgayBD().toString().split("-");
                        trangthai = "Đang diễn ra";
                        if(!(CompareDate(day[0], day[1], day[2], kt[0], kt[1], kt[2]) && CompareDate(bd[0], bd[1], bd[2], day[0],day[1], day[2]))){
                            if(CompareDate(day[0], day[1], day[2], bd[0],bd[1], bd[2])){
                                trangthai = "Chưa diễn ra";
                            }
                            else{
                                trangthai = "Đã kết thúc";
                            }
                        }
                    }
                    if(trangthai.toLowerCase().contains(s)){
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
    
    public static boolean CompareDate(String y11, String m11, String d11, String y22, String m22, String d22){
        int y1 = Integer.parseInt(y11);
        int m1 = Integer.parseInt(m11);
        int d1 = Integer.parseInt(d11);
        int y2 = Integer.parseInt(y22);
        int m2 = Integer.parseInt(m22);
        int d2 = Integer.parseInt(d22);
        if(y1 < y2) return true;
        if(y1 > y2) return false;
        if(m1 < m2) return true;
        if(m1 > m2) return false;
        if(d1 < d2) return true;
        if(d1 > d2) return false;
        return true;
    }
    
    public boolean KetThucKM(String MaKM){
        LocalDate today = LocalDate.now();
        if(qlKMDAO == null){
            qlKMDAO = new QuanlykhuyenmaiDAO();
        }
        boolean t = qlKMDAO.updateNgayKT(MaKM, today);
        if(t){
            for(KhuyenMai q: a){
                if(q.getMaKM().equals(MaKM)){
                    q.setNgayKT(today);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static String ToCurrent(String s){
        char[] ch = s.toCharArray();
        String ss = "";
        int j = 0;
        for(int i = ch.length-1; i >= 0; --i){
            ++j;
            ss = ch[i] + ss;
            if(j == 3 && i >= 1){
                j = 0;
                ss = "." + ss;
            }
        }
        return ss;
    }
}
