
package com.PhoneStoreManager.BackEnd.Quanlyquyen;

public class Quyen {
    private String MaQuyen;
    private String TenQuyen;
    private String ChiTietQuyen;

    public Quyen(String MaQuyen, String TenQuyen, String ChiTietQuyen) {
        this.MaQuyen = MaQuyen;
        this.TenQuyen = TenQuyen;
        this.ChiTietQuyen = ChiTietQuyen;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public String getChiTietQuyen() {
        return ChiTietQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }

    public void setChiTietQuyen(String ChiTietQuyen) {
        this.ChiTietQuyen = ChiTietQuyen;
    }
}
