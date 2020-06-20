
package com.PhoneStoreManager.BackEnd.Quanlynhanvien;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class QuanlynhanvienBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Trạng thái"};
    public static String[] getHeaders = {"STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Trạng thái"};
    private static ArrayList<NhanVien> a;
    private QuanlynhanvienDAO qlnvDAO = new QuanlynhanvienDAO();

    public QuanlynhanvienBUS() {
        if(a == null){
            a = qlnvDAO.SelectNhanVien();
        }
        else{
            if(a.size() <= 0){
                a = qlnvDAO.SelectNhanVien();
            }
        }
    }
    
    public static NhanVien getNhanVien(String MaNV){
        for(NhanVien nv: a){
            if(nv.getMaNV().equals(MaNV)){
                return nv;
            }
        }
        return null;
    }

    public static ArrayList<NhanVien> getDSNV() {
        return a;
    }
    
    public static ArrayList<NhanVien> SearchNhanVien(String s, String type){
        ArrayList<NhanVien> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(NhanVien nv: a){
                    if(nv.getMaNV().toLowerCase().contains(s) || nv.getTenNV().toLowerCase().contains(s) || nv.getNgaySinh().toLowerCase().contains(s) || nv.getDiaChi().toLowerCase().contains(s)
                            || nv.getSDT().toLowerCase().contains(s) || ((nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm").toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Mã nhân viên":{
                for(NhanVien nv: a){
                    if(nv.getMaNV().toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Tên nhân viên":{
                for(NhanVien nv: a){
                    if(nv.getTenNV().toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Ngày sinh":{
                for(NhanVien nv: a){
                    if(nv.getNgaySinh().toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Địa chỉ":{
                for(NhanVien nv: a){
                    if(nv.getDiaChi().toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Số điện thoại":{
                for(NhanVien nv: a){
                    if(nv.getSDT().toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            case "Trạng thái":{
                for(NhanVien nv: a){
                    if(((nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm").toLowerCase().contains(s)){
                        list.add(nv);
                    }
                }
                break;
            }
            default: break;
        }
        
        if(list.size() > 0) return list;
        return null;
    }
    
    public static ArrayList<NhanVien> SearchNVAge(int ag1, int ag2){
        if(ag1 > ag2) return null;
        GregorianCalendar cal = new GregorianCalendar();
        ArrayList<NhanVien> list = new ArrayList<>();
        
        int year = cal.get(Calendar.YEAR);
        String[] s;
        for(NhanVien nv: a){
            s = nv.getNgaySinh().split("-");
//            System.out.println(year - Integer.parseInt(s[0]));
            if(ag1 <= (year - Integer.parseInt(s[0])) && (year - Integer.parseInt(s[0])) <= ag2){
                list.add(nv);
            }
        }
        if(list.size() > 0) return list;
        return null;
    }
    
    public static ArrayList<NhanVien> SearchNVFromDate(int yearfrom, int monthfrom, int dayfrom, int yearto, int monthto, int dayto){
        if(yearfrom < 0 || monthfrom < 0 || dayfrom < 0 || yearto < 0 || monthto < 0 || dayto < 0){
            return null;
        }
        
        if(!CompareDate(yearfrom, monthfrom, dayfrom, yearto, monthto, dayto)){
            return null;
        }
        ArrayList<NhanVien> list = new ArrayList<>();
        int year = 0, month = 0, day = 0;
        String[] s;
        for(NhanVien nv: a){
            s = nv.getNgaySinh().split("-");
            year = Integer.parseInt(s[0]);
            month = Integer.parseInt(s[1]);
            day = Integer.parseInt(s[2]);
            if(CompareDate(yearfrom, monthfrom, dayfrom, year, month, day) && CompareDate(year, month, day, yearto, monthto, dayto)){
                list.add(nv);
            }
        }
        
        if(list.size() > 0) return list;
        return null;
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
    
    public static String MaNVnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(NhanVien nv: a){
            s = nv.getMaNV();
            s = s.trim();
            s = s.replace("NV", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "NV" + max;
    }
    
    public void duoiNhanVien(String MaNV){
        if(qlnvDAO == null){
            qlnvDAO = new QuanlynhanvienDAO();
        }
        qlnvDAO.updateTrangThaiNhanVien(MaNV);
        for(NhanVien nv: a){
            if(nv.getMaNV().equals(MaNV)){
                nv.setTrangThai(0);
                break;
            }
        }
    }
    
    public boolean repairNhanVien(String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT, int TrangThai){
        if(qlnvDAO.repairNhanVien(MaNV, TenNV, NgaySinh, DiaChi, SDT, TrangThai)){
            for(NhanVien nv: a){
                if(nv.getMaNV().equals(MaNV)){
                    nv.setTenNV(TenNV);
                    nv.setNgaySinh(NgaySinh);
                    nv.setDiaChi(DiaChi);
                    nv.setSDT(SDT);
                    nv.setTrangThai(TrangThai);
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean addNhanVien(NhanVien nv){
        if(qlnvDAO.addNhanVien(nv)){
            a.add(nv);
            return true;
        }
        return false;
    }
}
