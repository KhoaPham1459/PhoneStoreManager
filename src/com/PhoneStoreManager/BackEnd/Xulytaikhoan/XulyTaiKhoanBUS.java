
package com.PhoneStoreManager.BackEnd.Xulytaikhoan;

import java.util.ArrayList;

public class XulyTaiKhoanBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Tên tài khoản", "Mã nhân viên", "Mã quyền"};
    public static String[] getHeaders = {"STT", "Tên tài khoản", "Mã nhân viên", "Mã quyền"};
    private static ArrayList<TaiKhoan> a;
    private XulyTaiKhoanDAO xltkDAO = new XulyTaiKhoanDAO();

    public XulyTaiKhoanBUS() {
        if(a == null){
            a = xltkDAO.SelectTaiKhoan();
        }
        else{
            if(a.size() <= 0){
                a = xltkDAO.SelectTaiKhoan();
            }
        }
    }
    
    public static TaiKhoan getTaiKhoan(String tentk, String pass){
        for (TaiKhoan tk : a) {
            if (tk.getTenTaiKhoan().equals(tentk) && tk.getMatKhau().equals(pass)) {
                return tk;
            }
        }
        return null;
    }
    
    public static TaiKhoan getTaiKhoan(String tentk){
        for (TaiKhoan tk : a) {
            if (tk.getTenTaiKhoan().equals(tentk)) {
                return tk;
            }
        }
        return null;
    }

    public static ArrayList<TaiKhoan> getDSTaiKhoan() {
        return a;
    }
    
    public boolean addTaiKhoan(TaiKhoan tk){
        if(xltkDAO.addTaiKhoan(tk)){
            a.add(tk);
            return true;
        }
        return false;
    }
    
    public boolean repairTaiKhoan(String TenTaiKhoan, String MatKhau, String MaNV, String MaQuyen){
        if(xltkDAO.repairTaiKhoan(TenTaiKhoan, MatKhau, MaNV, MaQuyen)){
            for(TaiKhoan tk : a){
                if(tk.getTenTaiKhoan().equals(TenTaiKhoan)){
                    tk.setMaNV(MaNV);
                    tk.setMaQuyen(MaQuyen);
                    tk.setMatKhau(MatKhau);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteTaiKhoan(String TenTaiKhoan){
        if(xltkDAO.deleteTaiKhoan(TenTaiKhoan)){
            int i = 0;
            for(TaiKhoan tk : a){
                if(tk.getTenTaiKhoan().equals(TenTaiKhoan)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public static ArrayList<TaiKhoan> SearchTaiKhoan(String s, String type){
        ArrayList<TaiKhoan> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(TaiKhoan tk: a){
                    if(tk.getTenTaiKhoan().toLowerCase().contains(s) || tk.getMaNV().toLowerCase().contains(s)
                            || tk.getMaQuyen().toLowerCase().contains(s)){
                        list.add(tk);
                    }
                }
                break;
            }
            case "Tên tài khoản":{
                for(TaiKhoan tk: a){
                    if(tk.getTenTaiKhoan().toLowerCase().contains(s)){
                        list.add(tk);
                    }
                }
                break;
            }
            case "Mã nhân viên":{
                for(TaiKhoan tk: a){
                    if(tk.getMaNV().toLowerCase().contains(s)){
                        list.add(tk);
                    }
                }
                break;
            }
            case "Mã quyền":{
                for(TaiKhoan tk: a){
                    if(tk.getMaQuyen().toLowerCase().contains(s)){
                        list.add(tk);
                    }
                }
                break;
            }
            default: break;
        }
        
        if(list.size() > 0) return list;
        return null;
    }
    
}
