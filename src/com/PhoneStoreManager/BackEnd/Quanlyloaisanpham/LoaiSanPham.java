
package com.PhoneStoreManager.BackEnd.Quanlyloaisanpham;

public class LoaiSanPham {
    private String MaLSP;
    private String TenLSP;
    private String Mota;

    public LoaiSanPham(String MaLSP, String TenLSP, String Mota) {
        this.MaLSP = MaLSP;
        this.TenLSP = TenLSP;
        this.Mota = Mota;
    }

    public String getMaLSP() {
        return MaLSP;
    }

    public String getTenLSP() {
        return TenLSP;
    }

    public String getMota() {
        return Mota;
    }

    public void setMaLSP(String MaLSP) {
        this.MaLSP = MaLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.TenLSP = TenLSP;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
}
