
package com.PhoneStoreManager.BackEnd.Quanlyloaisanpham;

import java.util.ArrayList;

public class QuanlyloaisanphamBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã loại", "Tên loại", "Mô tả"};
    public static String[] getHeaders = {"STT", "Mã loại", "Tên loại", "Mô tả"};
    private static ArrayList<LoaiSanPham> a;
    private QuanlyloaisanphamDAO qllspDAO = new QuanlyloaisanphamDAO();

    public QuanlyloaisanphamBUS() {
        if(a == null){
            a = qllspDAO.SelectLSP();
        }
        else{
            if(a.size() <= 0){
                a = qllspDAO.SelectLSP();
            }
        }
    }
    
    public static LoaiSanPham getLSP(String MaLSP){
        for(LoaiSanPham q: a){
            if(q.getMaLSP().equals(MaLSP)){
                return q;
            }
        }
        return null;
    }

    public static ArrayList<LoaiSanPham> getDSLSP() {
        return a;
    }
    
    public static String MaLSPnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(LoaiSanPham q: a){
            s = q.getMaLSP();
            s = s.trim();
            s = s.replace("LSP", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "LSP" + max;
    }
    
    public boolean repaireLSP(String MaLSP, String TenLSP, String Mota){
        if(qllspDAO.repairLSP(MaLSP, TenLSP, Mota)){
            for(LoaiSanPham q: a){
                if(q.getMaLSP().equals(MaLSP)){
                    q.setTenLSP(TenLSP);
                    q.setMota(Mota);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteLSP(String MaLSP){
        if(qllspDAO.deleteLSP(MaLSP)){
            int i = 0;
            for(LoaiSanPham q: a){
                if(q.getMaLSP().equals(MaLSP)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public boolean addLSP(LoaiSanPham q){
        if(qllspDAO.addLSP(q)){
            a.add(q);
            return true;
        }
        return false;
    }
    
    public static ArrayList<LoaiSanPham> SearchLSP(String s, String type){
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(LoaiSanPham q: a){
                    if(q.getMaLSP().toLowerCase().contains(s) || q.getTenLSP().toLowerCase().contains(s) || q.getMota().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã loại":{
                for(LoaiSanPham q: a){
                    if(q.getMaLSP().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tên loại":{
                for(LoaiSanPham q: a){
                    if(q.getTenLSP().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mô tả":{
                for(LoaiSanPham q: a){
                    if(q.getMota().toLowerCase().contains(s)){
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
}
