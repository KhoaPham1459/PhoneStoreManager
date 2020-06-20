
package com.PhoneStoreManager.BackEnd.Quanlyphieunhap;

import java.time.LocalDate;
import java.time.LocalTime;

public class PhieuNhap {
    private String MaPN;
    private String MaNCC;
    private String MaNV;
    private LocalDate NgayNhap;
    private LocalTime GioNhap;
    private long TongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(String MaPN, String MaNCC, String MaNV, LocalDate NgayNhap, LocalTime GioNhap, long TongTien) {
        this.MaPN = MaPN;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.GioNhap = GioNhap;
        this.TongTien = TongTien;
    }

    public String getMaPN() {
        return MaPN;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public LocalDate getNgayNhap() {
        return NgayNhap;
    }

    public LocalTime getGioNhap() {
        return GioNhap;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayNhap(LocalDate NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setGioNhap(LocalTime GioNhap) {
        this.GioNhap = GioNhap;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }
    
}
