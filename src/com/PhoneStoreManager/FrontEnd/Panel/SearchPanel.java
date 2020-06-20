
package com.PhoneStoreManager.FrontEnd.Panel;

import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.KhachHang;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.QuanlykhachhangBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.KhuyenMai;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.PhieuNhap;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.QuanlyphieunhapBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.TaiKhoan;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.XulyTaiKhoanBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import static com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI.tb;
import com.PhoneStoreManager.FrontEnd.GiaoDien.Table;
import com.PhoneStoreManager.FrontEnd.GiaoDien.myTableCellRenderer;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel{
    public JComboBox<String> ComboBoxSearch;
    public JTextField txtSearch;
    private String type = "";

    public SearchPanel(String type) {
        init();
        this.type = type;
        if(!type.equals("GIAODIEN")){
            int w = 350;
            int h = 100;
            setSize(w, h);
//            setBackground(new Color(240,240,240));
            float wcom = (float)(0.425*getSize().width);
            float hcom = (float)(0.34*getSize().height);
            float ycom = (float)(0.4*getSize().height);
            ComboBoxSearch.setBounds((int)(0.05*getSize().width), (int)ycom, (int)wcom, (int)hcom);
            txtSearch.setBounds((int)(0.1*getSize().width+wcom), (int)ycom, (int)wcom, (int)hcom);
        }
    }
    
    private void init(){
        ComboBoxSearch = new JComboBox<>();
        txtSearch = new JTextField();
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm"));
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel4Layout);
        this.add(ComboBoxSearch);
        this.add(txtSearch);
    }
    public void setSizePanel(int x, int y){
        int w = 400;
        int h = 100;
        this.setBounds(x, y, w, h);
        float wcom = (float)(0.425*getSize().width);
        float hcom = (float)(0.34*getSize().height);
        float ycom = (float)(0.4*getSize().height);
        ComboBoxSearch.setBounds((int)(0.05*getSize().width), (int)ycom, (int)wcom, (int)hcom);
        txtSearch.setBounds((int)(0.1*getSize().width+wcom), (int)ycom, (int)wcom, (int)hcom);
        
    }
    
    public void setComboBox(String[] s){
        ComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(s));
    }
    
    
    // Thiết lập phần chức năng search cho Nhân viên
    public void EventSearchNhanVienforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "-------------------Tìm kiếm: " + s;

        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<NhanVien> searchDSNV = QuanlynhanvienBUS.SearchNhanVien(s, type);
        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlynhanvienBUS.getHeaders);
        if(searchDSNV != null){
            int i = 0;
            for(NhanVien nv: searchDSNV){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi()
                , nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }
        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho Quyền
    public void EventSearchQuyenforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<Quyen> list = QuanlyquyenBUS.SearchQuyen(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlyquyenBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(Quyen q: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void EventSearchTaiKhoanforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<TaiKhoan> list = XulyTaiKhoanBUS.SearchTaiKhoan(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(XulyTaiKhoanBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(TaiKhoan tk: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getMaNV(), tk.getMaQuyen()});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho NCC
    public void EventSearchNCCforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<NCC> list = QuanlyNCCBUS.SearchNCC(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlyNCCBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(NCC q: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), q.getMaNCC(), q.getTenNCC(), q.getDiaChi(), q.getSDT(), q.getFax()});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho KhachHang
    public void EventSearchKhachHangforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<KhachHang> list = QuanlykhachhangBUS.SearchKhachHang(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlykhachhangBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(KhachHang q: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i) ,q.getMaKH(), q.getTenKH(), q.getDiaChi(), q.getSDT(), (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho LSP
    public void EventSearchLSPforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<LoaiSanPham> list = QuanlyloaisanphamBUS.SearchLSP(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlyloaisanphamBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(LoaiSanPham q: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void EventSearchKhuyenMaiforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<KhuyenMai> list = QuanlykhuyenmaiBUS.SearchKhuyenMai(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlykhuyenmaiBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            LocalDate today = LocalDate.now();
            String[] day = today.toString().split("-");
            String[] kt;
            String[] bd;
            
            for(KhuyenMai q: list){
                ++i;
                kt = q.getNgayKT().toString().split("-");
                bd = q.getNgayBD().toString().split("-");
                String trangthai = "Đang diễn ra";
                if(today.toString().equals(q.getNgayKT().toString())){
                    trangthai = "Đã kết thúc";
                }
                else{
                    if(!(QuanlykhuyenmaiBUS.CompareDate(day[0], day[1], day[2], kt[0], kt[1], kt[2]) && 
                            QuanlykhuyenmaiBUS.CompareDate(bd[0], bd[1], bd[2], day[0],day[1], day[2]))){
                        if(QuanlykhuyenmaiBUS.CompareDate(day[0], day[1], day[2], bd[0],bd[1], bd[2])){
                            trangthai = "Chưa diễn ra";
                        }
                        else{
                            trangthai = "Đã kết thúc";
                        }
                    }
                }
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), q.getMaKM(), q.getTenKM(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDieuKienKM())), Integer.toString(q.getPhanTramKM()),
                q.getNgayBD().toString(), q.getNgayKT().toString(), trangthai});
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho SP
    public void EventSearchSPforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<SanPham> list = QuanlysanphamBUS.SearchSanPham(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlysanphamBUS.getHeaders);
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setMaxWidth(120);
        tb.jTable1.getColumn("Hình ảnh").setMinWidth(95);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(SanPham q: list){
                ++i;
                ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + q.getHinhAnh()));
                Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imgScaled));
                tb.addRow(new Object[]{Integer.toString(i), q.getMaSP(), q.getMaLSP(), q.getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())),
                QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())), label, (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"
                });
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(60);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho Hóa Đơn
    public void EventSearchHoaDonforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<HoaDon> list = QuanlyhoadonBUS.SearchHoaDon(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlyhoadonBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(HoaDon q: list){
                ++i;
                tb.addRow(new Object[]{Integer.toString(i), q.getMaHD(), q.getMaNV(), q.getMaKH(), q.getMaKM(), q.getNgayLap(), q.getGioLap(), 
                    QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))
                });
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    // Thiết lập chức năng search cho Phiếu Nhập
    public void EventSearchPhieuNhapforGiaoDien(){
        String s = txtSearch.getText().trim();
        String kq_timkiem = "---------- Tìm kiếm: " + s;
        String type = ComboBoxSearch.getSelectedItem().toString().trim();
        ArrayList<PhieuNhap> list = QuanlyphieunhapBUS.SearchPhieuNhap(s, type);

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setHeaders(QuanlyphieunhapBUS.getHeaders);
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);

        if(list != null){
            int i = 0;
            for(PhieuNhap q: list){
                ++i;
                tb.addRow(new Object[]{Integer.toString(i), q.getMaPN(), q.getMaNCC(), q.getMaNV(), q.getNgayNhap(), q.getGioNhap(), 
                    QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))
                });
            }
            kq_timkiem += " ------------- Tìm thấy";
        }
        else{
            kq_timkiem += " ------------- Không tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
}
