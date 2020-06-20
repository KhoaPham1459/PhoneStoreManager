
package com.PhoneStoreManager.BackEnd.QuanlyNCC;

public class NCC {
    private String MaNCC;
    private String TenNCC;
    private String DiaChi;
    private String SDT;
    private String Fax;

    public NCC(String MaNCC, String TenNCC, String DiaChi, String SDT, String Fax) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Fax = Fax;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getFax() {
        return Fax;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }
    
}
