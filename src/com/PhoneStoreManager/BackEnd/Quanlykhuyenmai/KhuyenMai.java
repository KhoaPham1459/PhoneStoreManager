
package com.PhoneStoreManager.BackEnd.Quanlykhuyenmai;

import java.time.LocalDate;

public class KhuyenMai {
    private String MaKM;
    private String TenKM;
    private long DieuKienKM;
    private int PhanTramKM;
    private LocalDate NgayBD, NgayKT;

    public KhuyenMai(String MaKM, String TenKM, long DieuKienKM, int PhanTramKM, LocalDate NgayBD, LocalDate NgayKT) {
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.DieuKienKM = DieuKienKM;
        this.PhanTramKM = PhanTramKM;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
    }

    public String getMaKM() {
        return MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public long getDieuKienKM() {
        return DieuKienKM;
    }

    public int getPhanTramKM() {
        return PhanTramKM;
    }

    public LocalDate getNgayBD() {
        return NgayBD;
    }

    public LocalDate getNgayKT() {
        return NgayKT;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public void setDieuKienKM(long DieuKienKM) {
        this.DieuKienKM = DieuKienKM;
    }

    public void setPhanTramKM(int PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public void setNgayBD(LocalDate NgayBD) {
        this.NgayBD = NgayBD;
    }

    public void setNgayKT(LocalDate NgayKT) {
        this.NgayKT = NgayKT;
    }
}
