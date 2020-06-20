
package com.PhoneStoreManager.BackEnd.Quanlychitiethoadon;

public class ChiTietHoaDon {
    private String MaHD;
    private String MaSP;
    private int SoLuong;
    private long DonGia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHD, String MaSP, int SoLuong, long DonGia) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(long DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public long getDonGia() {
        return DonGia;
    }
}
