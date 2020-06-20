
package com.PhoneStoreManager.BackEnd.Xulytaikhoan;

public class TaiKhoan {
    private String TenTaiKhoan;
    private String MatKhau;
    private String MaNV;
    private String MaQuyen;

    public TaiKhoan(String TenTaiKhoan, String MatKhau, String MaNV, String MaQuyen) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNV = MaNV;
        this.MaQuyen = MaQuyen;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }
    
}
