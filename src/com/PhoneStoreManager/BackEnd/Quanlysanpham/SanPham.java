
package com.PhoneStoreManager.BackEnd.Quanlysanpham;

public class SanPham {
    private String MaSP;
    private String MaLSP;
    private String TenSP;
    private long DonGia;
    private int SoLuong;
    private String HinhAnh;
    private int TrangThai;

    public SanPham(String MaSP, String MaLSP, String TenSP, long DonGia, int SoLuong, String HinhAnh, int TrangThai) {
        this.MaSP = MaSP;
        this.MaLSP = MaLSP;
        this.TenSP = TenSP;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getMaLSP() {
        return MaLSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public long getDonGia() {
        return DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
}
