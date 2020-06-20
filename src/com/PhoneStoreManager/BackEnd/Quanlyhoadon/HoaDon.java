
package com.PhoneStoreManager.BackEnd.Quanlyhoadon;

import java.time.LocalDate;
import java.time.LocalTime;

public class HoaDon {
    private String MaHD;
    private String MaNV;
    private String MaKH;
    private String MaKM;
    private LocalDate NgayLap;
    private LocalTime GioLap;
    private long TongTien;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, String MaKH, String MaKM, LocalDate NgayLap, LocalTime GioLap, long TongTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
        this.NgayLap = NgayLap;
        this.GioLap = GioLap;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaKM() {
        return MaKM;
    }

    public LocalDate getNgayLap() {
        return NgayLap;
    }

    public LocalTime getGioLap() {
        return GioLap;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public void setNgayLap(LocalDate NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setGioLap(LocalTime GioLap) {
        this.GioLap = GioLap;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }
}
