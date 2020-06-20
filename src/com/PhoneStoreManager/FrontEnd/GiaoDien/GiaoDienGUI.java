
package com.PhoneStoreManager.FrontEnd.GiaoDien;

import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import com.PhoneStoreManager.BackEnd.Quanlychitiethoadon.QuanlychitiethoadonBUS;
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
import com.PhoneStoreManager.BackEnd.QuanLyChiTietPN.QuanLyChiTietPhieuNhapBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.TaiKhoan;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.XulyTaiKhoanBUS;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormChon;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaKhachHang;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaKhuyenMai;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaLSP;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaNCC;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaNhanVien;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaQuyen;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaSanPham;
import com.PhoneStoreManager.FrontEnd.FormThemSua.FormThemSuaTaiKhoan;
import com.PhoneStoreManager.FrontEnd.Panel.SearchFromTo;
import com.PhoneStoreManager.FrontEnd.Panel.DateSearch;
import com.PhoneStoreManager.FrontEnd.Panel.DateSearch;
import com.PhoneStoreManager.FrontEnd.Panel.SearchPanel;
import com.PhoneStoreManager.FrontEnd.FormThemSua.BanHangForm;

import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import com.PhoneStoreManager.WorkWithExcel.XuatExcel;
import com.privatejgoodies.common.base.Strings;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaoDienGUI extends javax.swing.JFrame {
    private int px = 0;
    private int py = 0;
    public static Table tb;
    public static int tb_y = 0;
    public static int tb_x = 0;
    public static int tb_w = 0;
    public static int tb_h = 0;
    private QuanlynhanvienBUS qlnvBUS = new QuanlynhanvienBUS();
    private XulyTaiKhoanBUS xltkBUS = new XulyTaiKhoanBUS();
    private QuanlyquyenBUS qlquyenBUS = new QuanlyquyenBUS();
    private QuanlyNCCBUS qlNCCBUS = new QuanlyNCCBUS();
    private QuanlykhachhangBUS qlkhBUS = new QuanlykhachhangBUS();
    private QuanlyloaisanphamBUS qllspBUS = new QuanlyloaisanphamBUS();
    private QuanlykhuyenmaiBUS qlKMBUS = new QuanlykhuyenmaiBUS();
    private QuanlysanphamBUS qlspBUS = new QuanlysanphamBUS();
    private QuanlyhoadonBUS qlhd = new QuanlyhoadonBUS();
    private QuanlychitiethoadonBUS qlcthd = new QuanlychitiethoadonBUS();
    private QuanlyphieunhapBUS qlpn =new QuanlyphieunhapBUS();
    private QuanLyChiTietPhieuNhapBUS qlctpnbus =new QuanLyChiTietPhieuNhapBUS();
    
    public GiaoDienGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/phone.png"));
        setIconImage(logo.getImage());
        initChucNang();
        
        JLabel cc = new JLabel("Chào " + LoginGUI.currentNhanVien.getTenNV());
        cc.setFont(new Font("Tahoma", Font.BOLD, 18));
        cc.setBounds(400, 250, 500, 100);
        pnContentContainer.removeAll();
        pnContentContainer.add(cc);
        pnContentContainer.validate();
    }
    
    
    private void initChucNang(){
        String s = LoginGUI.currentQuyen.getChiTietQuyen();
        s += " ThongKe CongCu CaiDat";
        String[] words = s.split("\\s");
        int x = 0, y = 0, w = 109, h = 70;
        pnMenuContainer = new JPanel();
        pnContentContainer = new JPanel();
//        pnContentContainer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseDragged(java.awt.event.MouseEvent evt) {
//                pnTitleMouseDragged(evt);
//            }
//        });
//        pnContentContainer.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                pnTitleMousePressed(evt);
//            }
//        });

        pnMenuContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnMenuContainer.setBorder(BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        GroupLayout jPanel3Layout = new GroupLayout(pnMenuContainer);
        pnMenuContainer.setLayout(jPanel3Layout);

        pnContentContainer.setBackground(new Color(255, 255, 255));
        GroupLayout jPanel4Layout = new GroupLayout(pnContentContainer);
        pnContentContainer.setLayout(jPanel4Layout);
        if(words.length <= 8){
            pnMenuContainer.setBounds(0, pnTitle.getSize().height, w, getHeight()-pnTitle.getSize().height);
            pnContentContainer.setBounds(pnMenuContainer.getSize().width, pnTitle.getSize().height, getWidth()-pnMenuContainer.getSize().width, getHeight()-pnTitle.getSize().height);
            
        }
        else{
            pnMenuContainer.setBounds(0, pnTitle.getSize().height, w*2, getHeight()-pnTitle.getSize().height);
            pnContentContainer.setBounds(pnMenuContainer.getSize().width, pnTitle.getSize().height, getWidth()-pnMenuContainer.getSize().width, getHeight()-pnTitle.getSize().height);
        }
//        System.out.println(words.length);
        pnBodyContainer.add(pnMenuContainer);
        pnBodyContainer.add(pnContentContainer);
        for(int i = 0; i < words.length; i++){
            words[i] = words[i].replace("ql", "");
            words[i] = words[i].replace("xem", "");
            initComponent(words[i], x, y, w, h);
            if(i < 7){
                y += h + 17;
            }
            else if(i == 7){
                y = 0;
                x += w;
            }
            else{
                y += h + 17;
            }
        }
    }
    
//    public TextField getNCCTextField(TextField txtField){
//        return txtField;
//    }

    private void initComponent(String s, int x, int y, int width, int height){
        switch(s){
            case "BanHang":{
                btnBanHang = new javax.swing.JButton();
                btnBanHang.setBounds(x, y, width, height);
                btnBanHang.setBackground(new java.awt.Color(255, 255, 255));
                btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/shop1.png"))); // NOI18N
                
                btnBanHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bán hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnBanHangMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnBanHangMouseExited(evt);
                    }
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        btnBanHangMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnBanHang);
                break;
            }
            case "NhapHang":{
                btnNhapHang = new javax.swing.JButton();
                btnNhapHang.setBounds(x, y, width, height);
                btnNhapHang.setBackground(new java.awt.Color(255, 255, 255));
                btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/nhap1.png"))); // NOI18N
                
                btnNhapHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnNhapHangMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnNhapHangMouseExited(evt);
                    }
                    
                    
                });

                pnMenuContainer.add(btnNhapHang);
                break;
            }
            case "SanPham":{
                btnSanPham = new javax.swing.JButton();
                btnSanPham.setBounds(x, y, width, height);
                btnSanPham.setBackground(new java.awt.Color(255, 255, 255));
                btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/smartphone1.png"))); // NOI18N
                
                btnSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnSanPhamMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnSanPhamMouseExited(evt);
                    }
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        btnSanPhamMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnSanPham);
                break;
            }
            case "LoaiSanPham":{
                btnLoaiSanPham = new javax.swing.JButton();
                btnLoaiSanPham.setBounds(x, y, width, height);
                btnLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
                btnLoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/type1.png"))); // NOI18N
                
                btnLoaiSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnLoaiSanPhamMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnLoaiSanPhamMouseExited(evt);
                    }
                    @Override
                    public void mousePressed(MouseEvent evt){
                        btnLoaiSanPhamMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnLoaiSanPham);
                break;
            }
            case "HoaDon":{
                btnHoaDon = new javax.swing.JButton();
                btnHoaDon.setBounds(x, y, width, height);
                btnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
                btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/hoadon1.png"))); // NOI18N
                
                btnHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnHoaDonMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnHoaDonMouseExited(evt);
                    }
                    public void mousePressed(MouseEvent evt){
                        btnHoaDonMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnHoaDon);
                break;
                
            }
            case "KhuyenMai":{
                btnKhuyenMai = new javax.swing.JButton();
                btnKhuyenMai.setBounds(x, y, width, height);
                btnKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
                btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/gift1.png"))); // NOI18N
                
                btnKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khuyến mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnKhuyenMaiMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnKhuyenMaiMouseExited(evt);
                    }
                    public void mousePressed(MouseEvent evt){
                        btnKhuyenMaiMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnKhuyenMai);
                break;
            }
            case "NhanVien":{
                btnNhanVien = new javax.swing.JButton();
                btnNhanVien.setBounds(x, y, width, height);
                btnNhanVien.setBackground(new java.awt.Color(255, 255, 255));
                btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/staff1.png"))); // NOI18N
                
                btnNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnNhanVienMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnNhanVienMouseExited(evt);
                    }
                    public void mousePressed(java.awt.event.MouseEvent evt){
                        btnNhanVienMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnNhanVien);
                break;
            }
            case "KhachHang":{
                btnKhachHang = new javax.swing.JButton();
                btnKhachHang.setBounds(x, y, width, height);
                btnKhachHang.setBackground(new java.awt.Color(255, 255, 255));
                btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/customer1.png"))); // NOI18N
                
                btnKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnKhachHangMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnKhachHangMouseExited(evt);
                    }
                    @Override
                    public void mousePressed(MouseEvent evt){
                        btnKhachHangMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnKhachHang);
                break;
            }
            case "PhieuNhap":{
                btnPhieuNhap = new javax.swing.JButton();
                btnPhieuNhap.setBounds(x, y, width, height);
                btnPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
                btnPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/phieunhap1.png"))); // NOI18N
                
                btnPhieuNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnPhieuNhapMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnPhieuNhapMouseExited(evt);
                    }
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        btnPhieuNhapMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnPhieuNhap);
                break;
            }
            case "NCC":{
                btnNCC = new javax.swing.JButton();
                btnNCC.setBounds(x, y, width, height);
                btnNCC.setBackground(new java.awt.Color(255, 255, 255));
                btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/NCC1.png"))); // NOI18N
                
                btnNCC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà cung cấp", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnNCC.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnNCCMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnNCCMouseExited(evt);
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent evt){
                        btnNCCMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnNCC);
                break;
            }
            case "TaiKhoan":{
                btnTaiKhoan = new javax.swing.JButton();
                btnTaiKhoan.setBounds(x, y, width, height);
                btnTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
                btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/key1.png"))); // NOI18N
                
                btnTaiKhoan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tài khoản", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnTaiKhoanMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnTaiKhoanMouseExited(evt);
                    }
                    public void mousePressed(MouseEvent evt){
                        btnTaiKhoanMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnTaiKhoan);
                break;
            }
            case "Quyen":{
                btnQuyen = new javax.swing.JButton();
                btnQuyen.setBounds(x, y, width, height);
                btnQuyen.setBackground(new java.awt.Color(255, 255, 255));
                btnQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/permission1.png"))); // NOI18N
                
                btnQuyen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quyền", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnQuyenMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnQuyenMouseExited(evt);
                    }
                    public void mousePressed(MouseEvent evt){
                        btnQuyenMousePressed(evt);
                    }
                });
                pnMenuContainer.add(btnQuyen);
                break;
            }
            case "ThongKe":{
                btnThongKe = new javax.swing.JButton();
                btnThongKe.setBounds(x, y, width, height);
                btnThongKe.setBackground(new java.awt.Color(255, 255, 255));
                btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/thongke1.png"))); // NOI18N
                
                btnThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống kê", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnThongKeMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnThongKeMouseExited(evt);
                    }
                });
                pnMenuContainer.add(btnThongKe);
                break;
            }
            case "CongCu":{
                btnCongCu = new javax.swing.JButton();
                btnCongCu.setBounds(x, y, width, height);
                btnCongCu.setBackground(new java.awt.Color(255, 255, 255));
                btnCongCu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/tool1.png"))); // NOI18N
                
                btnCongCu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Công cụ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnCongCu.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnCongCuMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnCongCuMouseExited(evt);
                    }
                });
                pnMenuContainer.add(btnCongCu);
                break;
            }
            case "CaiDat":{
                btnCaiDat = new javax.swing.JButton();
                btnCaiDat.setBounds(x, y, width, height);
                btnCaiDat.setBackground(new java.awt.Color(255, 255, 255));
                btnCaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/setting1.png"))); // NOI18N
                
                btnCaiDat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cài đặt", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_BOTTOM));
                btnCaiDat.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnCaiDatMouseEntered(evt);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnCaiDatMouseExited(evt);
                    }
                });
                pnMenuContainer.add(btnCaiDat);
                break;
            }
            default: break;
        }
    }
    
    private void themChucNangButton(){
        pnContentContainer.removeAll();
        pnContentContainer.invalidate();
        pnContentContainer.repaint();
        Font font = new Font("Tahoma", 1, 12);
        // Nút Thêm
        btnThem = new JButton();
        btnThem.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")));
        btnThem.setText("Thêm");
        btnThem.setFont(font);
        
        // Nút Xóa
        btnXoa = new JButton();
        btnXoa.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/button-delete.png")));
        btnXoa.setText("Xóa");
        btnXoa.setFont(font);
        
        // Nút Sửa
        btnSua = new JButton();
        btnSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        btnSua.setText("Sửa");
        btnSua.setFont(font);
        
        // Nút Xuất Excel
        btnXuatExcel = new JButton();
        btnXuatExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setFont(font);
        
        // Nút Nhập Excel
        btnNhapExcel = new JButton();
        btnNhapExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setFont(font);
        
        // Nút Làm Mới
        btnLamMoi = new JButton();
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFont(font);
        
        // Thêm Panel Tìm Kiếm
        pnSearch = new SearchPanel("GIAODIEN");
        
        // Thêm Panel tìm kiếm Ngày Sinh
        pnDateSearch = new DateSearch("GIAODIEN");
        
        // Thêm Panel tìm tuổi
        pnAgeSearch = new SearchFromTo("GIAODIEN", "Tuổi");
        
        // Thêm Table
        tb = new Table();
        tb.setRowHeigth(35);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBodyContainer = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        labelPower = new javax.swing.JLabel();
        lbMinimize = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnBodyContainer.setBackground(new java.awt.Color(242, 241, 239));
        pnBodyContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        pnBodyContainer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnBodyContainer.setPreferredSize(new java.awt.Dimension(1235, 658));

        pnTitle.setBackground(new java.awt.Color(51, 204, 255));
        pnTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 102, 102)));
        pnTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnTitleMouseDragged(evt);
            }
        });
        pnTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnTitleMousePressed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Phone Store Manager");

        labelPower.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/power.png"))); // NOI18N
        labelPower.setToolTipText("Thoát");
        labelPower.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPowerMouseClicked(evt);
            }
        });

        lbMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/minimize11.1.png"))); // NOI18N
        lbMinimize.setToolTipText("Thu nhỏ");
        lbMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinimizeMouseClicked(evt);
            }
        });

        lbLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/logout1.png"))); // NOI18N
        lbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbLogoutMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 578, Short.MAX_VALUE)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(373, 373, 373)
                .addComponent(lbMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPower)
                .addContainerGap())
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTitleLayout.createSequentialGroup()
                        .addComponent(lbMinimize)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelPower, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTitle)
                        .addComponent(lbLogout)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBodyContainerLayout = new javax.swing.GroupLayout(pnBodyContainer);
        pnBodyContainer.setLayout(pnBodyContainerLayout);
        pnBodyContainerLayout.setHorizontalGroup(
            pnBodyContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBodyContainerLayout.setVerticalGroup(
            pnBodyContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyContainerLayout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(680, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBodyContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBodyContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelPowerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPowerMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelPowerMouseClicked

    private void lbMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbMinimizeMouseClicked

    private void lbLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMousePressed
        new LoginGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbLogoutMousePressed

    private void pnTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitleMouseDragged
        setLocation(getLocation().x + evt.getX() - px, getLocation().y + evt.getY() - py);
    }//GEN-LAST:event_pnTitleMouseDragged

    private void pnTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnTitleMousePressed
        px = evt.getX();
        py = evt.getY();
    }//GEN-LAST:event_pnTitleMousePressed

//    button ban hang 
    private void btnBanHangMouseEntered(java.awt.event.MouseEvent evt) {                                        
        btnBanHang.setBackground(new java.awt.Color(51, 204, 255));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/shop2.png")));
    }                                       

    private void btnBanHangMouseExited(java.awt.event.MouseEvent evt) {                                       
        btnBanHang.setBackground(new java.awt.Color(255, 255, 255));
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/shop1.png")));
    } 
    
    private void btnBanHangMousePressed(java.awt.event.MouseEvent evt){
        BanHangForm bh = new BanHangForm(pnContentContainer.getWidth(), pnContentContainer.getHeight());
        
        bh.setVisible(true);
        lbTitle.setText("Bán hàng");
        
        pnContentContainer.add(bh);
        pnContentContainer.validate();
    }

//    button nhap hang
    private void btnNhapHangMouseExited(java.awt.event.MouseEvent evt) {                                        
        btnNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/nhap1.png")));
    }                                       

    private void btnNhapHangMouseEntered(java.awt.event.MouseEvent evt) {                                         
        btnNhapHang.setBackground(new java.awt.Color(51, 204, 255));
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/nhap2.png")));
    }                                        

    // button san pham
    private void btnSanPhamMouseEntered(java.awt.event.MouseEvent evt) {                                        
        btnSanPham.setBackground(new java.awt.Color(51, 204, 255));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/smartphone2.png")));
    }                                       

    private void btnSanPhamMouseExited(java.awt.event.MouseEvent evt) {                                       
        btnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/smartphone1.png")));
    }         
    
//    https://www.programcreek.com/java-api-examples/?class=javax.swing.JPanel&method=removeAll           Example 2
    private void btnSanPhamMousePressed(java.awt.event.MouseEvent evt) {
        themChucNangButton();
        lbTitle.setText("SẢN PHẨM");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        
        // Nút thêm SP
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaSP = QuanlysanphamBUS.MaSPnotHave();
                new FormThemSuaSanPham(MaSP).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa SP
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa sản phẩm này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaSP = tb.LayMaSPTaiTable(i).toString();
                    if(qlspBUS.deleteSanPham(MaSP)){
                        tb.removeRow(MaSP);
                        JOptionPane.showMessageDialog(rootPane, "Xóa sản phẩm thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa sản phẩm thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn sản phẩm cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa SP
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaSP = tb.LayMaSPTaiTable(i).toString();
                    SanPham q = QuanlysanphamBUS.getSanPham(MaSP);
                    new FormThemSuaSanPham(q, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn sản phẩm cần sữa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel SP
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelSanPham();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel SP
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới SP
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlspBUS.getHeaders);
                tb.jTable1.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
                tb.jTable1.getColumn("Hình ảnh").setMaxWidth(120);
                tb.jTable1.getColumn("Hình ảnh").setMinWidth(95);
                int i = 0;
                for(SanPham q: qlspBUS.getDSSP()){
                    ++i;
                    ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + q.getHinhAnh()));
                    Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                    JLabel label = new JLabel();
                    label.setIcon(new ImageIcon(imgScaled));
                    tb.addRow(new Object[]{Integer.toString(i), q.getMaSP(), q.getMaLSP(), q.getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())),
                    QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())), label, (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"
                    });
                }
                tb.setRowHeigth(60);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        
        // Thêm Panel tìm kiếm SP
        x = (pnContentContainer.getSize().width - 400 - 600)/2; y = h;
        pnSearch.setComboBox(qlspBUS.getComboboxSearch);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSoLuongSearch.txtFrom.setText("");
                pnSoLuongSearch.txtTo.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnSearch.EventSearchSPforGiaoDien();
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSoLuongSearch.txtFrom.setText("");
                pnSoLuongSearch.txtTo.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnSearch.EventSearchSPforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        x = x + pnSearch.getSize().width;
        
        //Them Panel tìm kiếm số lượng sản phẩm
        pnSoLuongSearch = new SearchFromTo("GIAODIEN", "Số Lượng");
        pnSoLuongSearch.setSizePanel(x, y);
        pnSoLuongSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnSearch.txtSearch.setText("");
                pnSoLuongSearch.SearchSoLuongSanPham();
            }
        });
        x = x + pnSoLuongSearch.getSize().width;
        
        // Them Panel tìm kiếm Đơn giá
        pnDonGiaSearch = new SearchFromTo("GIAODIEN", "Đơn giá");
        pnDonGiaSearch.setSizePanel(x, y);
        pnDonGiaSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSoLuongSearch.txtFrom.setText("");
                pnSoLuongSearch.txtTo.setText("");
                pnSearch.txtSearch.setText("");
                pnDonGiaSearch.SearchDonGiaSanPham();
            }
        });
        
        // Thêm Table SP
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height-tb_y;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlspBUS.getHeaders);
        tb.jTable1.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
        tb.jTable1.getColumn("Hình ảnh").setMaxWidth(120);
        tb.jTable1.getColumn("Hình ảnh").setMinWidth(95);
        tb.setRowHeigth(60);
        int i = 0;
        for(SanPham q: qlspBUS.getDSSP()){
            ++i;
            ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + q.getHinhAnh()));
            Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(imgScaled));
            tb.addRow(new Object[]{Integer.toString(i), q.getMaSP(), q.getMaLSP(), q.getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())),
            QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())), label, (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"
            });
        }
//        tb.jTable1.setValueAt(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/huawei-y9-2019-blue-400x460.jpg")), 5, 6);
        tb.resizeColumnWidth();
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(pnSoLuongSearch);
        pnContentContainer.add(pnDonGiaSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnLoaiSanPhamMouseEntered(java.awt.event.MouseEvent evt) {                                            
        btnLoaiSanPham.setBackground(new java.awt.Color(51, 204, 255));
        btnLoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/type2.png")));
    }                                           

    private void btnLoaiSanPhamMouseExited(java.awt.event.MouseEvent evt) {                                           
        btnLoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnLoaiSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/type1.png")));
    }  
    
    private void btnLoaiSanPhamMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("LOẠI SẢN PHẨM");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        
        // Nút thêm LSP
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaLSP = QuanlyloaisanphamBUS.MaLSPnotHave();
                new FormThemSuaLSP(MaLSP).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa LSP
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa loại sản phẩm này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaLSP = tb.LayMaLSPTaiTable(i).toString();
                    if(qllspBUS.deleteLSP(MaLSP)){
                        tb.removeRow(MaLSP);
                        JOptionPane.showMessageDialog(rootPane, "Xóa loại sản phẩm thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa loại sản phẩm thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn loại sản phẩm cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa LSP
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaLSP = tb.LayMaLSPTaiTable(i).toString();
                    LoaiSanPham q = qllspBUS.getLSP(MaLSP);
                    new FormThemSuaLSP(q, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn loại sản phẩm cần sữa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel LSP
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelLSP();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel LSP
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới LSP
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qllspBUS.getHeaders);
                int i = 0;
                for(LoaiSanPham q: qllspBUS.getDSLSP()){
                    ++i;
                    tb.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
                }
                tb.setRowHeigth(35);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel tìm kiếm LSP
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.setComboBox(qllspBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchLSPforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchLSPforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        // Thêm Table LSP
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qllspBUS.getHeaders);
        int i = 0;
        for(LoaiSanPham q: qllspBUS.getDSLSP()){
            ++i;
            tb.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnHoaDonMouseEntered(java.awt.event.MouseEvent evt) {                                       
        btnHoaDon.setBackground(new java.awt.Color(51, 204, 255));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/hoadon2.png")));
    }                                      

    private void btnHoaDonMouseExited(java.awt.event.MouseEvent evt) {                                      
        btnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/hoadon1.png")));
    }        
    
    private void btnHoaDonMousePressed(MouseEvent evt){
        pnContentContainer.removeAll();
        pnContentContainer.repaint();
        Font font = new Font("Tahoma", 1, 12);
        lbTitle.setText("HÓA ĐƠN");
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*5)/2;
        
        // Nút Xuất Excel
        btnXuatExcel = new JButton();
        btnXuatExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setFont(font);
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelHoaDon();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel
        btnNhapExcel = new JButton();
        btnNhapExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setFont(font);
        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút InPDF
        btnInPDF = new JButton();
        btnInPDF.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/interface-pdf.png")));
        btnInPDF.setText("In PDF");
        btnInPDF.setFont(font);
        btnInPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnInPDF.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xem chi tiết
        btnXemChiTiet = new JButton();
        btnXemChiTiet.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/view.png")));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.setFont(font);
        btnXemChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaHD = tb.LayMaHoaDonTaiTable(i).toString();
                    HoaDon hd = QuanlyhoadonBUS.getHoaDon(MaHD);
                    new FormChon(hd).setVisible(true);
                }
            }
        });
        btnXemChiTiet.setBounds(x, y, w, h);
        x += w;
        
        // Nút Làm Mới
        btnLamMoi = new JButton();
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFont(font);
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlhd.getHeaders);
                int i = 0;
                for(HoaDon q: qlhd.getDSHD()){
                    ++i;
                    tb.addRow(new Object[]{Integer.toString(i), q.getMaHD(), q.getMaNV(), q.getMaKH(), q.getMaKM(), q.getNgayLap(), q.getGioLap(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))});
                }
                tb.resizeColumnWidth();
                tb.setRowHeigth(35);
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        x = (pnContentContainer.getSize().width-1100)/2;
        y = h;
        // Thêm Panel Tìm Kiếm
        pnSearch = new SearchPanel("GIAODIEN");
        pnSearch.setComboBox(QuanlyhoadonBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnSearch.EventSearchHoaDonforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnSearch.EventSearchHoaDonforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        //Them Panel Tìm kiếm ngày nhập
        x += pnSearch.getSize().width;
        pnDateSearch = new DateSearch("GIAODIEN");
        pnDateSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.txtSearch.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnDateSearch.SearchDateForHoaDon();
            }
        });
        pnDateSearch.setSizePanel(x, y);
        
        // Thêm panel Tim kiếm tổng tiền
        x += pnDateSearch.getSize().width;
        pnDonGiaSearch = new SearchFromTo("GIAODIEN", "Tổng tiền");
        pnDonGiaSearch.setSizePanel(x, y);
        pnDonGiaSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnSearch.txtSearch.setText("");
                pnDonGiaSearch.SearchTongTienHoaDon();
            }
        });
        
        // Thêm Table 
        tb = new Table();
        tb_x = 0; tb_y = pnSearch.getSize().height + btnLamMoi.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlhd.getHeaders);
        int i = 0;
        for(HoaDon q: qlhd.getDSHD()){
            ++i;
            tb.addRow(new Object[]{Integer.toString(i), q.getMaHD(), q.getMaNV(), q.getMaKH(), q.getMaKM(), q.getNgayLap(), q.getGioLap(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))});
        }
        tb.resizeColumnWidth();
        tb.setRowHeigth(35);
        
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnInPDF);
        pnContentContainer.add(btnXemChiTiet);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(pnDateSearch);
        pnContentContainer.add(pnDonGiaSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnPhieuNhapMouseEntered(java.awt.event.MouseEvent evt) {                                          
        btnPhieuNhap.setBackground(new java.awt.Color(51, 204, 255));
        btnPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/phieunhap2.png")));
    }                                         

    private void btnPhieuNhapMouseExited(java.awt.event.MouseEvent evt) {                                         
        btnPhieuNhap.setBackground(new java.awt.Color(255, 255, 255));
        btnPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/phieunhap1.png")));
    }
    //star pn
    private void btnPhieuNhapMousePressed(MouseEvent evt){
        pnContentContainer.removeAll();
        pnContentContainer.repaint();
        Font font = new Font("Tahoma", 1, 12);
        lbTitle.setText("Phiếu Nhập");
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*5)/2;
        
        // Nút Xuất Excel
        btnXuatExcel = new JButton();
        btnXuatExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setFont(font);
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelHoaDon();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel
        btnNhapExcel = new JButton();
        btnNhapExcel.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")));
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setFont(font);
        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút InPDF
        btnInPDF = new JButton();
        btnInPDF.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/interface-pdf.png")));
        btnInPDF.setText("In PDF");
        btnInPDF.setFont(font);
        btnInPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnInPDF.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xem chi tiết
        btnXemChiTiet = new JButton();
        btnXemChiTiet.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/view.png")));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.setFont(font);
        btnXemChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaPN = tb.LayMaPhieuNhapTaiTable(i).toString();
                    PhieuNhap pn = QuanlyphieunhapBUS.getPhieuNhap(MaPN);
                    new FormChon(pn).setVisible(true);
                }
            }
        });
        btnXemChiTiet.setBounds(x, y, w, h);
        x += w;
        
        // Nút Làm Mới
        btnLamMoi = new JButton();
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setFont(font);
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlpn.getHeaders);
                int i = 0;
                for(PhieuNhap q: qlpn.getDSPN()){
                    ++i;
                    tb.addRow(new Object[]{Integer.toString(i), q.getMaPN(), q.getMaNCC(), q.getMaNV(), q.getNgayNhap(), q.getGioNhap(), Long.toString(q.getTongTien())});
                }
                tb.resizeColumnWidth();
                tb.setRowHeigth(35);
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        x = (pnContentContainer.getSize().width-1100)/2;
        y = h;
        // Thêm Panel Tìm Kiếm
        pnSearch = new SearchPanel("GIAODIEN");
        pnSearch.setComboBox(QuanlyhoadonBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnSearch.EventSearchPhieuNhapforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnSearch.EventSearchPhieuNhapforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        //Them Panel Tìm kiếm ngày nhập
        x += pnSearch.getSize().width;
        pnDateSearch = new DateSearch("GIAODIEN");
        pnDateSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.txtSearch.setText("");
                pnDonGiaSearch.txtFrom.setText("");
                pnDonGiaSearch.txtTo.setText("");
                pnDateSearch.SearchDateForHoaDon();
            }
        });
        pnDateSearch.setSizePanel(x, y);
        
        // Thêm panel Tim kiếm tổng tiền
        x += pnDateSearch.getSize().width;
        pnDonGiaSearch = new SearchFromTo("GIAODIEN", "Tổng tiền");
        pnDonGiaSearch.setSizePanel(x, y);
        pnDonGiaSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnSearch.txtSearch.setText("");
                pnDonGiaSearch.SearchTongTienHoaDon();
            }
        });
        
        // Thêm Table 
        tb = new Table();
        tb_x = 0; tb_y = pnSearch.getSize().height + btnLamMoi.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlpn.getHeaders);
        int i = 0;
        for(PhieuNhap q: qlpn.getDSPN()){
                    ++i;
                    tb.addRow(new Object[]{Integer.toString(i), q.getMaPN(), q.getMaNCC(), q.getMaNV(), q.getNgayNhap(), q.getGioNhap(), Long.toString(q.getTongTien())});
                }
        tb.resizeColumnWidth();
        tb.setRowHeigth(35);
        
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnInPDF);
        pnContentContainer.add(btnXemChiTiet);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(pnDateSearch);
        pnContentContainer.add(pnDonGiaSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }
    // end pn

    private void btnKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {                                          
        btnKhuyenMai.setBackground(new java.awt.Color(51, 204, 255));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/gift2.png")));
    }                                         

    private void btnKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {                                         
        btnKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/gift1.png")));
    }            
    
    private void btnKhuyenMaiMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("KHUYẾN MÃI");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*7)/2;
        
        // Nút thêm Khuyến Mãi
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaKM = QuanlykhuyenmaiBUS.MaKMnotHave();
                new FormThemSuaKhuyenMai(MaKM).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa Khuyến Mãi
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa khuyến mãi này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaKM = tb.LayMaKhuyenMaiTaiTable(i).toString();
                    if(qlKMBUS.deleteKM(MaKM)){
                        tb.removeRow(MaKM);
                        JOptionPane.showMessageDialog(rootPane, "Xóa khuyến mãi thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa khuyến mãi thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn khuyến mãi cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa Khuyến Mãi
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaKM = tb.LayMaKhuyenMaiTaiTable(i).toString();
                    KhuyenMai q = qlKMBUS.getKhuyenMai(MaKM);
                    new FormThemSuaKhuyenMai(q, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn khuyến mãi cần sửa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Kết thúc
        btnKetThuc = new JButton();
        btnKetThuc.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/ketthuc.png")));
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFont(new Font("Tahoma", 1, 12));
        btnKetThuc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String tt = tb.LayTrangThaiKhuyenMaiTaiTable(i).toString();
                    if(tt.equals("Chưa diễn ra")){
                        JOptionPane.showMessageDialog(rootPane, "Không thể kết thúc khuyến mãi này. Khuyến mãi này chưa diễn ra.");
                        return;
                    }
                    if(tt.equals("Đã kết thúc")){
                        JOptionPane.showMessageDialog(rootPane, "Không thể kết thúc khuyến mãi này. Khuyến mãi này đã kết thúc.");
                        return;
                    }
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc kết thúc khuyến mãi này không? Dời ngày kết thúc về hôm nay?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaKM = tb.LayMaKhuyenMaiTaiTable(i).toString();
                    if(qlKMBUS.KetThucKM(MaKM)){
                        LocalDate today = LocalDate.now();
                        tb.setValueTrangThai(MaKM, "Đã kết thúc");
                        JOptionPane.showMessageDialog(rootPane, "Kết thúc khuyến mãi thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Kết thúc khuyến mãi thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn khuyến mãi cần kết thúc");
                }
                
            }
        });
        btnKetThuc.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel khuyến mãi
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelKhuyenMai();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel khuyến mãi
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới Khuyến Mãi
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //qlKMBUS = new QuanlykhuyenmaiBUS();
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlKMBUS.getHeaders);
                int i = 0;
                LocalDate today = LocalDate.now();
                String[] day = today.toString().split("-");
                String[] kt;
                String[] bd;
                for(KhuyenMai q: qlKMBUS.getDSKM()){
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
                    tb.addRow(new String[]{Integer.toString(i), q.getMaKM(), q.getTenKM(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDieuKienKM())), Integer.toString(q.getPhanTramKM()),
                        q.getNgayBD().toString(), q.getNgayKT().toString(), trangthai});
                }
                tb.setRowHeigth(35);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel tìm kiếm Khuyến Mãi
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.setComboBox(qlKMBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchKhuyenMaiforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchKhuyenMaiforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        // Thêm Table Khuyến Mãi
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlKMBUS.getHeaders);
        int i = 0;
        LocalDate today = LocalDate.now();
        String[] day = today.toString().split("-");
        String[] kt;
        String[] bd;
        for(KhuyenMai q: qlKMBUS.getDSKM()){
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
            tb.addRow(new String[]{Integer.toString(i), q.getMaKM(), q.getTenKM(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDieuKienKM())), Integer.toString(q.getPhanTramKM()),
                q.getNgayBD().toString(), q.getNgayKT().toString(), trangthai});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi); 
        pnContentContainer.add(btnKetThuc);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnNhanVienMouseEntered(java.awt.event.MouseEvent evt) {                                         
        btnNhanVien.setBackground(new java.awt.Color(51, 204, 255));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/staff2.png"))); 
    }                                        

    private void btnNhanVienMouseExited(java.awt.event.MouseEvent evt) {                                        
        btnNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/staff1.png"))); 
    }                                       
    
    private void btnNhanVienMousePressed(java.awt.event.MouseEvent evt) {
        themChucNangButton();
        lbTitle.setText("NHÂN VIÊN");
        
        int x = 110, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        // Nút Thêm Nhân Viên
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaNV = qlnvBUS.MaNVnotHave();
                new FormThemSuaNhanVien(MaNV).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xóa Nhân Viên
        btnXoa.setText("Đuổi làm");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc đuổi nhân viên này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaNV = tb.LayMaNVTaiTable(i).toString();
                    qlnvBUS.duoiNhanVien(MaNV);
                    tb.setValueTrangThai(MaNV, "Hết làm");
//                    tb.setValueAt("Hết làm", i, 6);
                } else {
                    JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn nhân viên cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút Sửa Nhân Viên
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaNV = tb.LayMaNVTaiTable(i).toString();
                    NhanVien nv = qlnvBUS.getNhanVien(MaNV);
                    new FormThemSuaNhanVien(nv, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn nhân viên cần xóa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel Nhân Viên
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelNhanVien();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel Nhân Viên
        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Làm Mới Nhân Viên
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //qlnvBUS = new QuanlynhanvienBUS();
                LamMoiTableNhanVien();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel Tìm Kiếm Nhân Viên
        x = (pnContentContainer.getSize().width - 800 - 300)/2; y = h;
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
                pnSearch.EventSearchNhanVienforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
                pnSearch.EventSearchNhanVienforGiaoDien();
            }
        });
        pnSearch.setComboBox(qlnvBUS.getComboboxSearch);
        pnSearch.setSizePanel(x, y);
        
        // Thêm Panel tìm kiếm Ngày Sinh Nhân Viên
        x = x + pnSearch.getSize().width;
        pnDateSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.txtSearch.setText("");
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
                pnDateSearch.SearchDateBornNhanVien();
            }
        });
        pnDateSearch.setSizePanel(x, y);
        
        // Thêm Panel tìm tuổi
        x += pnDateSearch.getSize().width;
        pnAgeSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.txtSearch.setText("");
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnAgeSearch.SearchTuoiNhanVien();
            }
        });
        pnAgeSearch.setSizePanel(x, y);
        
        // Thêm Table Nhân Viên
        tb_x = 0; tb_y = pnSearch.getSize().height + btnLamMoi.getSize().height;
        tb_w = pnContentContainer.getSize().width;
        tb_h = pnContentContainer.getSize().height-pnSearch.getSize().height-btnLamMoi.getSize().height-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlnvBUS.getHeaders);
        String tt = "";
        int i = 0;
        for(NhanVien nv: qlnvBUS.getDSNV()){
            ++i;
            if(nv.getTrangThai() == 1){
               tt = "Còn làm";
            }
            else{
                tt = "Hết làm";
            }
            tb.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), tt});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(tb);
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(pnDateSearch);
        pnContentContainer.add(pnAgeSearch);
        pnContentContainer.validate();
    }
    
    private void LamMoiTableNhanVien(){
        pnContentContainer.remove(tb);
        tb = new Table();
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlnvBUS.getHeaders);
        String tt = "";
        int i = 0;
        for(NhanVien nv: qlnvBUS.getDSNV()){
            ++i;
            if(nv.getTrangThai() == 1){
               tt = "Còn làm";
            }
            else{
                tt = "Hết làm";
            }
            tb.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), tt});
        }
        tb.setRowHeigth(35);
        tb.resizeColumnWidth();
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }
    
    private void LamMoiTableKhachHang(){
        pnContentContainer.remove(tb);
        tb = new Table();
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlkhBUS.getHeaders);
        String tt = "";
        int i = 0;
        for(KhachHang kh: qlkhBUS.getDSKH()){
            ++i;
            if(kh.getTrangThai() == 1){
               tt = "Hiện";
            }
            else{
                tt = "Ẩn";
            }
            tb.addRow(new String[]{Integer.toString(i) ,kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSDT(), tt});
        }
        tb.setRowHeigth(35);
        tb.resizeColumnWidth();
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }
    
    private void btnKhachHangMouseEntered(java.awt.event.MouseEvent evt) {                                          
        btnKhachHang.setBackground(new java.awt.Color(51, 204, 255));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/customer2.png")));
    }                                         

    private void btnKhachHangMouseExited(java.awt.event.MouseEvent evt) {                                         
        btnKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/customer1.png")));
    }   
    
    private void btnKhachHangMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("KHÁCH HÀNG");
        
        int x = 110, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        // Nút Thêm Khách Hàng
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaKH = qlkhBUS.MaKHnotHave();
                new FormThemSuaKhachHang(MaKH).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xóa Khách Hàng
        btnXoa.setText("Ẩn");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc ẩn khách hàng này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaKH = tb.LayMaKHTaiTable(i).toString();
                    qlkhBUS.anKhachHang(MaKH);
                    tb.setValueTrangThai(MaKH, "Ẩn");
                } else {
                    JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn khách hàng cần ẩn");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút Sửa Khách Hàng
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaKH = tb.LayMaKHTaiTable(i).toString();
                    KhachHang KH = qlkhBUS.getKhachHang(MaKH);
                    new FormThemSuaKhachHang(KH, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn khách hàng cần xóa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel Khách Hàng
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelKhachHang();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel Khách Hàng
        btnNhapExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Làm Mới Khách Hàng
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LamMoiTableKhachHang();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel Tìm Kiếm Khách Hàng
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchKhachHangforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchKhachHangforGiaoDien();
            }
        });
        pnSearch.setComboBox(qlkhBUS.getComboboxSearch);
        pnSearch.setSizePanel(x, y);
        
        // Thêm Table Khách Hàng
        tb_x = 0; tb_y = pnSearch.getSize().height + btnLamMoi.getSize().height;
        tb_w = pnContentContainer.getSize().width;
        tb_h = pnContentContainer.getSize().height-pnSearch.getSize().height-btnLamMoi.getSize().height-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        
        tb.setHeaders(qlkhBUS.getHeaders);
        String tt = "";
        int i = 0;
        for(KhachHang KH: qlkhBUS.getDSKH()){
            ++i;
            if(KH.getTrangThai() == 1){
               tt = "Hiện";
            }
            else{
                tt = "Ẩn";
            }
            tb.addRow(new String[]{Integer.toString(i) ,KH.getMaKH(), KH.getTenKH(), KH.getDiaChi(), KH.getSDT(), tt});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(tb);
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        
        pnContentContainer.add(pnSearch);
        pnContentContainer.validate();
    }

    private void btnNCCMouseEntered(java.awt.event.MouseEvent evt) {                                    
        btnNCC.setBackground(new java.awt.Color(51, 204, 255));
        btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/NCC2.png")));
    }                                   

    private void btnNCCMouseExited(java.awt.event.MouseEvent evt) {                                   
        btnNCC.setBackground(new java.awt.Color(255, 255, 255));
        btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/NCC1.png")));
    }  
    
    private void btnNCCMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("NHÀ CUNG CẤP");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        
        // Nút thêm NCC
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaNCC = QuanlyNCCBUS.MaNCCnotHave();
                new FormThemSuaNCC(MaNCC).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa NCC
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa nhà cung cấp này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaNCC = tb.LayMaNCCTaiTable(i).toString();
                    if(qlNCCBUS.deleteNCC(MaNCC)){
                        tb.removeRow(MaNCC);
                        JOptionPane.showMessageDialog(rootPane, "Xóa nhà cung cấp thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa nhà cung cấp thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn nhà cung cấp cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa NCC
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaNCC = tb.LayMaNCCTaiTable(i).toString();
                    NCC q = qlNCCBUS.getNCC(MaNCC);
                    new FormThemSuaNCC(q, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn nhà cung cấp cần sữa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel NCC
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelNCC();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel NCC
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới NCC
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //qlNCCBUS = new QuanlyNCCBUS();
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlNCCBUS.getHeaders);
                int i = 0;
                for(NCC q: qlNCCBUS.getDSNCC()){
                    ++i;
                    tb.addRow(new String[]{Integer.toString(i), q.getMaNCC(), q.getTenNCC(), q.getDiaChi(), q.getSDT(), q.getFax()});
                }
                tb.setRowHeigth(35);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel tìm kiếm NCC
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.setComboBox(qlNCCBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchNCCforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchNCCforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        // Thêm Table NCC
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlNCCBUS.getHeaders);
        int i = 0;
        for(NCC q: qlNCCBUS.getDSNCC()){
            ++i;
            tb.addRow(new String[]{Integer.toString(i), q.getMaNCC(), q.getTenNCC(), q.getDiaChi(), q.getSDT(), q.getFax()});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {                                         
        btnTaiKhoan.setBackground(new java.awt.Color(51, 204, 255));
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/key2.png")));
    }                                        

    private void btnTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {                                        
        btnTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/key1.png")));
    } 
    
    private void btnTaiKhoanMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("TÀI KHOẢN");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        
        // Nút thêm tài khoản
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormThemSuaTaiKhoan().setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa tài khoản
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa tài khoản này không?");
                    if(k != JOptionPane.YES_OPTION) return;
                    String Tentk = tb.LayTenTaiKhoanTaiTable(row).toString();
                    if(xltkBUS.deleteTaiKhoan(Tentk)){
                        tb.removeRow(Tentk);
                        JOptionPane.showMessageDialog(rootPane, "Xóa tài khoản thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa tài khoản thất bại");
                    }
                }
                else{
                    JOptionPane.showConfirmDialog(rootPane, "Bạn chưa chọn tài khoản cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa tài khoản
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    String Tentk = tb.LayTenTaiKhoanTaiTable(row).toString();
                    TaiKhoan tk = XulyTaiKhoanBUS.getTaiKhoan(Tentk);
//                    System.out.println(tk.getTenTaiKhoan()  );
                    new FormThemSuaTaiKhoan(tk, Integer.parseInt(tb.getValueSTT(row).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showConfirmDialog(rootPane, "Bạn chưa chọn tài khoản cần sửa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel Tài khoản
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelTaiKhoan();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel Tài khoản
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới Tài khoản
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(xltkBUS.getHeaders);
                int i = 0;
                for(TaiKhoan tk: xltkBUS.getDSTaiKhoan()){
                    ++i;
                    tb.addRow(new String[]{Integer.toString(i), tk.getTenTaiKhoan(), tk.getMaNV(), tk.getMaQuyen()});
                }
                tb.setRowHeigth(35);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel tìm kiếm tài khoản
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.setComboBox(xltkBUS.getComboboxSearch);
        pnSearch.setSizePanel(x, y);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchTaiKhoanforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchTaiKhoanforGiaoDien();
            }
        });
        
        // Thêm Table Tài khoản
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(xltkBUS.getHeaders);
        int i = 0;
        for(TaiKhoan tk: xltkBUS.getDSTaiKhoan()){
            ++i;
            tb.addRow(new String[]{Integer.toString(i), tk.getTenTaiKhoan(), tk.getMaNV(), tk.getMaQuyen()});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnQuyenMouseEntered(java.awt.event.MouseEvent evt) {                                      
        btnQuyen.setBackground(new java.awt.Color(51, 204, 255));
        btnQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/permission2.png")));
    }                                     

    private void btnQuyenMouseExited(java.awt.event.MouseEvent evt) {                                     
        btnQuyen.setBackground(new java.awt.Color(255, 255, 255));
        btnQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/permission1.png")));
    }
    
    private void btnQuyenMousePressed(MouseEvent evt){
        themChucNangButton();
        lbTitle.setText("QUYỀN");
        
        int x = 0, y = 0, w = 150, h = 50;
        x = (pnContentContainer.getSize().width - w*6)/2;
        
        // Nút thêm quyền
        btnThem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaQuyen = QuanlyquyenBUS.MaQuyennotHave();
                new FormThemSuaQuyen(MaQuyen).setVisible(true);
            }
        });
        btnThem.setBounds(x, y, w, h);
        x += w;
        
        // Nút xóa quyền
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    int k = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc xóa quyền này không?");
                    if(k != JOptionPane.YES_OPTION){
                        return;
                    }
                    String MaQuyen = tb.LayMaQuyenTaiTable(i).toString();
                    if(qlquyenBUS.deleteQuyen(MaQuyen)){
                        tb.removeRow(MaQuyen);
                        JOptionPane.showMessageDialog(rootPane, "Xóa quyền thành công");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Xóa quyền thất bại");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn quyền cần xóa");
                }
            }
        });
        btnXoa.setBounds(x, y, w, h);
        x += w;
        
        // Nút sửa quyền
        btnSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tb.getSelectedRow();
                if(i >= 0){
                    String MaQuyen = tb.LayMaQuyenTaiTable(i).toString();
                    Quyen q = qlquyenBUS.getQuyen(MaQuyen);
                    new FormThemSuaQuyen(q, Integer.parseInt(tb.getValueSTT(i).toString())).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn quyền cần sữa");
                }
            }
        });
        btnSua.setBounds(x, y, w, h);
        x += w;
        
        // Nút Xuất Excel quyền
        btnXuatExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new XuatExcel().xuatFileExcelQuyen();
            }
        });
        btnXuatExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút Nhập Excel quyền
        btnNhapExcel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnNhapExcel.setBounds(x, y, w, h);
        x += w;
        
        // Nút làm mới quyền
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //qlquyenBUS = new QuanlyquyenBUS();
                pnContentContainer.remove(tb);
                tb = new Table();
                tb.setBound(tb_x, tb_y, tb_w, tb_h);
                tb.setHeaders(qlquyenBUS.getHeaders);
                int i = 0;
                for(Quyen q: qlquyenBUS.getDSQuyen()){
                    ++i;
                    tb.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
                }
                tb.setRowHeigth(35);
                tb.resizeColumnWidth();
                pnContentContainer.add(tb);
                pnContentContainer.validate();
            }
        });
        btnLamMoi.setBounds(x, y, w, h);
        
        // Thêm Panel tìm kiếm quyền
        x = (pnContentContainer.getSize().width - 400)/2; y = h;
        pnSearch.setComboBox(qlquyenBUS.getComboboxSearch);
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pnSearch.EventSearchQuyenforGiaoDien();
            }
        });
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                pnSearch.EventSearchQuyenforGiaoDien();
            }
        });
        pnSearch.setSizePanel(x, y);
        
        // Thêm Table quyền
        tb_x = 0; tb_y = pnSearch.getSize().height + btnThem.getSize().height; tb_w = pnContentContainer.getSize().width; tb_h = pnContentContainer.getSize().height - tb_y-1;
        tb.setBound(tb_x, tb_y, tb_w, tb_h);
        tb.setHeaders(qlquyenBUS.getHeaders);
        int i = 0;
        for(Quyen q: qlquyenBUS.getDSQuyen()){
            ++i;
            tb.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
        }
        tb.resizeColumnWidth();
        
        pnContentContainer.add(btnThem);
        pnContentContainer.add(btnXoa);
        pnContentContainer.add(btnSua);
        pnContentContainer.add(btnXuatExcel);
        pnContentContainer.add(btnNhapExcel);
        pnContentContainer.add(btnLamMoi);
        pnContentContainer.add(pnSearch);
        pnContentContainer.add(tb);
        pnContentContainer.validate();
    }

    private void btnCongCuMouseEntered(java.awt.event.MouseEvent evt) {                                       
        btnCongCu.setBackground(new java.awt.Color(51, 204, 255));
        btnCongCu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/tool2.png")));
    }                                      

    private void btnCongCuMouseExited(java.awt.event.MouseEvent evt) {                                      
        btnCongCu.setBackground(new java.awt.Color(255, 255, 255));
        btnCongCu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/tool1.png")));
    }                                     

    private void btnCaiDatMouseEntered(java.awt.event.MouseEvent evt) {                                       
        btnCaiDat.setBackground(new java.awt.Color(51, 204, 255));
        btnCaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/setting2.png")));
    }                                      

    private void btnCaiDatMouseExited(java.awt.event.MouseEvent evt) {                                      
        btnCaiDat.setBackground(new java.awt.Color(255, 255, 255));
        btnCaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/setting1.png")));
    }                                     

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {                                        
        btnThongKe.setBackground(new java.awt.Color(51, 204, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/thongke2.png")));
    }                                       

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {                                       
        btnThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/thongke1.png")));
    }
    
    
    // Thành phần tìm kiếm
    private SearchPanel pnSearch;
    private DateSearch pnDateSearch;
    private SearchFromTo pnAgeSearch;
    private SearchFromTo pnSoLuongSearch;
    private SearchFromTo pnDonGiaSearch;
    
    // Các button theo danh mục
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnInPDF;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnKetThuc;
    
    // Button danh mục
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnCaiDat;
    private javax.swing.JButton btnCongCu;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnLoaiSanPham;
    private javax.swing.JButton btnNCC;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnPhieuNhap;
    private javax.swing.JButton btnQuyen;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThongKe;
    
    // Các panel dc thêm
    private javax.swing.JPanel pnMenuContainer;
    public static javax.swing.JPanel pnContentContainer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelPower;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbMinimize;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnBodyContainer;
    private javax.swing.JPanel pnTitle;
    // End of variables declaration//GEN-END:variables
}
