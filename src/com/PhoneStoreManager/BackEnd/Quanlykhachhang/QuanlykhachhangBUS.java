
package com.PhoneStoreManager.BackEnd.Quanlykhachhang;

import java.util.ArrayList;

public class QuanlykhachhangBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Trạng thái"};
    public static String[] getHeaders = {"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Trạng thái"};
    private static ArrayList<KhachHang> a;
    private QuanlykhachhangDAO qlkhDAO = new QuanlykhachhangDAO();

    public QuanlykhachhangBUS() {
        if(a == null){
            a = qlkhDAO.SelectKhachHang();
        }
        else{
            if(a.size() <= 0){
                a = qlkhDAO.SelectKhachHang();
            }
        }
    }
    
    public static KhachHang getKhachHang(String MaKH){
        for(KhachHang KH: a){
            if(KH.getMaKH().equals(MaKH)){
                return KH;
            }
        }
        return null;
    }

    public static ArrayList<KhachHang> getDSKH() {
        return a;
    }
    
    public static ArrayList<KhachHang> SearchKhachHang(String s, String type){
        ArrayList<KhachHang> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(KhachHang KH: a){
                    if(KH.getMaKH().toLowerCase().contains(s) || KH.getTenKH().toLowerCase().contains(s) || KH.getDiaChi().toLowerCase().contains(s)
                            || KH.getSDT().toLowerCase().contains(s) || ((KH.getTrangThai() == 1) ? "Hiện" : "Ẩn").toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            case "Mã khách hàng":{
                for(KhachHang KH: a){
                    if(KH.getMaKH().toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            case "Tên khách hàng":{
                for(KhachHang KH: a){
                    if(KH.getTenKH().toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            case "Địa chỉ":{
                for(KhachHang KH: a){
                    if(KH.getDiaChi().toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            case "Số điện thoại":{
                for(KhachHang KH: a){
                    if(KH.getSDT().toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            case "Trạng thái":{
                for(KhachHang KH: a){
                    if(((KH.getTrangThai() == 1) ? "Hiện" : "Ẩn").toLowerCase().contains(s)){
                        list.add(KH);
                    }
                }
                break;
            }
            default: break;
        }
        
        if(list.size() > 0) return list;
        return null;
    }
    
    public static String MaKHnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(KhachHang KH: a){
            s = KH.getMaKH();
            s = s.trim();
            s = s.replace("KH", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "KH" + max;
    }
    
    public void anKhachHang(String MaKH){
        if(qlkhDAO == null){
            qlkhDAO = new QuanlykhachhangDAO();
        }
        qlkhDAO.updateTrangThaiKhachHang(MaKH);
        for(KhachHang KH: a){
            if(KH.getMaKH().equals(MaKH)){
                KH.setTrangThai(0);
                break;
            }
        }
    }
    
    public boolean repairKhachHang(String MaKH, String TenKH, String DiaChi, String SDT, int TrangThai){
        if(qlkhDAO.repairKhachHang(MaKH, TenKH,DiaChi, SDT, TrangThai)){
            for(KhachHang KH: a){
                if(KH.getMaKH().equals(MaKH)){
                    KH.setTenKH(TenKH);
                    KH.setDiaChi(DiaChi);
                    KH.setSDT(SDT);
                    KH.setTrangThai(TrangThai);
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean addKhachHang(KhachHang KH){
        if(qlkhDAO.addKhachHang(KH)){
            a.add(KH);
            return true;
        }
        return false;
    }
    
}
