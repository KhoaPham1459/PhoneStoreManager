
package com.PhoneStoreManager.BackEnd.Quanlysanpham;

import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import java.util.ArrayList;

public class QuanlysanphamBUS {
    public static String[] getComboboxSearch = {"Tất cả", "Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Hình ảnh","Trạng thái"};
    public static String[] getHeaders = {"STT", "Mã sản phẩm", "Mã loại sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Hình ảnh","Trạng thái"};
    private static ArrayList<SanPham> a;
    private QuanlysanphamDAO qlspDAO = new QuanlysanphamDAO();

    public QuanlysanphamBUS() {
        if(a == null){
            a = qlspDAO.SelectSanPham();
        }
        else{
            if(a.size() <= 0){
                a = qlspDAO.SelectSanPham();
            }
        }
    }
    
 public ArrayList<SanPham> search(String value, String type, int soluong1, int soluong2, float gia1, float gia2, int trangthai) {
        ArrayList<SanPham> result = new ArrayList<>();

        a.forEach((sp) -> {
            if (type.equals("Tất cả")) {
                if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())
                        || sp.getMaLSP().toLowerCase().contains(value.toLowerCase())
                        || sp.getTenSP().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())
                        || String.valueOf((sp.getTrangThai() == 1 ? "Ẩn" : "Hiện")).toLowerCase().contains(value.toLowerCase())) {
                    result.add(sp);
                }
            } else {
                switch (type) {
                    case "Mã sản phẩm":
                        if (sp.getMaSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Mã loại":
                        if (sp.getMaLSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Tên":
                        if (sp.getTenSP().toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Đơn giá":
                        if (String.valueOf(sp.getDonGia()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Số lượng":
                        if (String.valueOf(sp.getSoLuong()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                    case "Trạng thái":
                        String tt = (sp.getTrangThai() == 1 ? "Ẩn" : "Hiện");
                        if (String.valueOf(tt).toLowerCase().contains(value.toLowerCase())) {
                            result.add(sp);
                        }
                        break;
                }
            }
        });

        for (int i = result.size() - 1; i >= 0; i--) {
            SanPham sp = result.get(i);
            int soluong = sp.getSoLuong();
            float gia = sp.getDonGia();
            int tt = sp.getTrangThai();
            Boolean soLuongKhongThoa = (soluong1 != -1 && soluong < soluong1) || (soluong2 != -1 && soluong > soluong2);
            Boolean giaKhongThoa = (gia1 != -1 && gia < gia1) || (gia2 != -1 && gia > gia2);
            Boolean trangThaiKhongThoa = (trangthai != -1) && tt != trangthai;

            if (soLuongKhongThoa || giaKhongThoa || trangThaiKhongThoa) {
                result.remove(i);
            }
        }

        return result;
    }
    
    public static SanPham getSanPham(String MaSP){
        for (SanPham sp : a) {
            if (sp.getMaSP().equals(MaSP)) {
                return sp;
            }
        }
        return null;
    }
    
    public static String MaSPnotHave(){
        String s = "";
        int max = 0;
        int temp = 0;
        for(SanPham q: a){
            s = q.getMaSP();
            s = s.trim();
            s = s.replace("SP", "");
            temp = Integer.parseInt(s);
            if(max < temp){
                max = temp;
            }
        }
        ++max;
        return "SP" + max;
    }

    public static ArrayList<SanPham> getDSSP() {
        return a;
    }
    
    public boolean addSanPham(SanPham sp){
        if(qlspDAO.addSanPham(sp)){
            a.add(sp);
            return true;
        }
        return false;
    }
    
    public boolean repairSanPham(String MaSP, String MaLSP, String TenSP, long DonGia, int SoLuong, String HinhAnh, int TrangThai){
        if(qlspDAO.repairSanPham(MaSP, MaLSP, TenSP, DonGia, SoLuong, HinhAnh, TrangThai)){
            for(SanPham sp : a){
                if(sp.getMaSP().equals(MaSP)){
                    sp.setMaLSP(MaLSP);
                    sp.setTenSP(TenSP);
                    sp.setDonGia(DonGia);
                    sp.setSoLuong(SoLuong);
                    sp.setHinhAnh(HinhAnh);
                    sp.setTrangThai(TrangThai);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteSanPham(String MaSP){
        if(qlspDAO.deleteSanPham(MaSP)){
            int i = 0;
            for(SanPham tk : a){
                if(tk.getMaSP().equals(MaSP)){
                    a.remove(i);
                    return true;
                }
                ++i;
            }
        }
        return false;
    }
    
    public static ArrayList<SanPham> SearchSanPham(String s, String type){
        ArrayList<SanPham> list = new ArrayList<>();
        s = s.toLowerCase();
        switch(type){
            case "Tất cả":{
                for(SanPham q: a){
                    if(q.getMaSP().toLowerCase().contains(s) || q.getMaLSP().toLowerCase().contains(s) || q.getTenSP().toLowerCase().contains(s) || 
                            QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())).contains(s) || Integer.toString(q.getSoLuong()).contains(s)
                            || q.getHinhAnh().toLowerCase().contains(s) ||((q.getTrangThai() == 1) ? "Hiện" : "Ẫn").toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã sản phẩm":{
                for(SanPham q: a){
                    if(q.getMaSP().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Mã loại sản phẩm":{
                for(SanPham q: a){
                    if(q.getMaLSP().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Tên sản phẩm":{
                for(SanPham q: a){
                    if(q.getTenSP().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Đơn giá":{
                for(SanPham q: a){
                    if(QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())).contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Số lượng":{
                for(SanPham q: a){
                    if(QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())).contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Hình ảnh":{
                for(SanPham q: a){
                    if(q.getHinhAnh().toLowerCase().contains(s)){
                        list.add(q);
                    }
                }
                break;
            }
            case "Trạng thái" :{
                for(SanPham q: a){
                    if(((q.getTrangThai() == 1) ? "Hiện" : "Ẫn").toLowerCase().contains(s)){
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
    
    public static ArrayList<SanPham> SearchSoLuongSP(int bd, int kt){
        ArrayList<SanPham> list = new ArrayList<>();
        for(SanPham q: a){
            if(bd <= q.getSoLuong() && q.getSoLuong() <= kt){
                list.add(q);
            }
        }
        if(list.size() > 0) return list;
        return null;
    }
    
    public static ArrayList<SanPham> SearchDonGiaSP(long bd, long kt){
        ArrayList<SanPham> list = new ArrayList<>();
        for(SanPham q: a){
            if(bd <= q.getDonGia()&& q.getDonGia()<= kt){
                list.add(q);
            }
        }
        if(list.size() > 0) return list;
        return null;
    }
    
    public Boolean updateSoLuong(String masp, int soluong) {
        Boolean ok = qlspDAO.updateSoLuong(masp, soluong);

        if (ok) {
            a.forEach((sp) -> {
                if (sp.getMaSP().equals(masp)) {
                    sp.setSoLuong(soluong);
                }
            });
        }

        return ok;
    }
}
