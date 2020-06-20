
package com.PhoneStoreManager.BackEnd.Quanlynhanvien;

public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String NgaySinh;
    private String DiaChi;
    private String SDT;
    private int TrangThai;

    public NhanVien(String MaNV, String TenNV, String NgaySinh, String DiaChi, String SDT, int TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
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
}
