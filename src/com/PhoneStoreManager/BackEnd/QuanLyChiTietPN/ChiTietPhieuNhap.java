/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneStoreManager.BackEnd.QuanLyChiTietPN;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhap {

    private String MaPN;
    private String MaSP;
    private int soLuong;
    private long DonGia;

    public ChiTietPhieuNhap() {

    }

    public ChiTietPhieuNhap(String MaPN, String MaSP, Integer soLuong, Long DonGia) {
        this.MaPN = MaPN;
        this.MaSP = MaSP;
        this.soLuong = soLuong;
        this.DonGia = DonGia;
    }

    public String getMaPN() {
        return MaPN;
    }

    public String getMaSP() {
        return MaSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public long getDonGia() {
        return DonGia;
    }

    public void setMaPN(String MaPN) {
        this.MaPN = MaPN;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(Long DonGia) {
        this.DonGia = DonGia;
    }

}
