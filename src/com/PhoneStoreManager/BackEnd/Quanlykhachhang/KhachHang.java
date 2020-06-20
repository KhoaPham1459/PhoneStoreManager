
package com.PhoneStoreManager.BackEnd.Quanlykhachhang;

public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String DiaChi;
    private String SDT;
    private int TrangThai;

    public KhachHang(String MaKH, String TenKH, String DiaChi, String SDT, int TrangThai) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
