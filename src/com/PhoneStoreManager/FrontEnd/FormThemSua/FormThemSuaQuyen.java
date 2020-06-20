
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaQuyen extends javax.swing.JFrame {
    private int row = 0;
    // Dành cho thêm quyền
    public FormThemSuaQuyen(String MaQuyen) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        txtMaQuyen.setText(MaQuyen);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        initcheckbox();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    // Dành cho sửa quyền
    public FormThemSuaQuyen(Quyen q, int i){
        initComponents();
        row = i;
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        btnThemSua.setText("Sửa");
        
        txtMaQuyen.setText(q.getMaQuyen());
        txtMaQuyen.setEditable(false);
        txtTenQuyen.setText(q.getTenQuyen());
        String[] s = q.getChiTietQuyen().split("\\s");
        String temp = "";
        for (String item : s) {
            temp = item.replace("ql", "");
            temp = temp.replace("xem", "");
            switch(temp){
                case "BanHang":{
                    checkboxBanHang.setSelected(true);
                    break;
                }
                case "NhapHang":{
                    checkboxNhapHang.setSelected(true);
                    break;
                }
                case "SanPham":{
                    checkboxSanPham.setSelected(true);
                    if(item.contains("xem")){
                        comboSanPham.setSelectedIndex(0);
                    }
                    else{
                        comboSanPham.setSelectedIndex(1);
                    }
                    break;
                }
                case "LoaiSanPham":{
                    checkboxLoaiSanPham.setSelected(true);
                    if(item.contains("xem")){
                        comboLoaiSanPham.setSelectedIndex(0);
                    }
                    else{
                        comboLoaiSanPham.setSelectedIndex(1);
                    }
                    break;
                }
                case "HoaDon":{
                    checkboxHoaDon.setSelected(true);
                    if(item.contains("xem")){
                        comboHoaDon.setSelectedIndex(0);
                    }
                    else{
                        comboHoaDon.setSelectedIndex(1);
                    }
                    break;
                }
                case "KhuyenMai":{
                    checkboxKhuyenMai.setSelected(true);
                    if(item.contains("xem")){
                        comboKhuyenMai.setSelectedIndex(0);
                    }
                    else{
                        comboKhuyenMai.setSelectedIndex(1);
                    }
                    break;
                }
                case "NhanVien":{
                    checkboxNhanVien.setSelected(true);
                    if(item.contains("xem")){
                        comboNhanVien.setSelectedIndex(0);
                    }
                    else{
                        comboNhanVien.setSelectedIndex(1);
                    }
                    break;
                }
                case "KhachHang":{
                    checkboxKhachHang.setSelected(true);
                    if(item.contains("xem")){
                        comboKhachHang.setSelectedIndex(0);
                    }
                    else{
                        comboKhachHang.setSelectedIndex(1);
                    }
                    break;
                }
                case "PhieuNhap":{
                    checkboxPhieuNhap.setSelected(true);
                    if(item.contains("xem")){
                        comboPhieuNhap.setSelectedIndex(0);
                    }
                    else{
                        comboPhieuNhap.setSelectedIndex(1);
                    }
                    break;
                }
                case "NCC":{
                    checkboxNCC.setSelected(true);
                    if(item.contains("xem")){
                        comboNCC.setSelectedIndex(0);
                    }
                    else{
                        comboNCC.setSelectedIndex(1);
                    }
                    break;
                }
                case "TaiKhoan":{
                    checkboxTaiKhoan.setSelected(true);
                    if(item.contains("xem")){
                        comboTaiKhoan.setSelectedIndex(0);
                    }
                    else{
                        comboTaiKhoan.setSelectedIndex(1);
                    }
                    break;
                }
                default: break;
            }
        }
        
        initcheckbox();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void initcheckbox(){
        if(!checkboxBanHang.isSelected()){
            comboBanHang.setEnabled(false);
        }
        if(!checkboxNhapHang.isSelected()){
            comboNhapHang.setEnabled(false);
        }
        if(!checkboxSanPham.isSelected()){
            comboSanPham.setEnabled(false);
        }
        if(!checkboxLoaiSanPham.isSelected()){
            comboLoaiSanPham.setEnabled(false);
        }
        if(!checkboxHoaDon.isSelected()){
            comboHoaDon.setEnabled(false);
        }
        if(!checkboxKhuyenMai.isSelected()){
            comboKhuyenMai.setEnabled(false);
        }
        if(!checkboxNhanVien.isSelected()){
            comboNhanVien.setEnabled(false);
        }
        if(!checkboxKhachHang.isSelected()){
            comboKhachHang.setEnabled(false);
        }
        if(!checkboxPhieuNhap.isSelected()){
            comboPhieuNhap.setEnabled(false);
        }
        if(!checkboxNCC.isSelected()){
            comboNCC.setEnabled(false);
        }
        if(!checkboxTaiKhoan.isSelected()){
            comboTaiKhoan.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        txtMaQuyen = new javax.swing.JTextField();
        txtTenQuyen = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        checkboxBanHang = new javax.swing.JCheckBox();
        comboBanHang = new javax.swing.JComboBox<>();
        checkboxNhapHang = new javax.swing.JCheckBox();
        comboNhapHang = new javax.swing.JComboBox<>();
        checkboxSanPham = new javax.swing.JCheckBox();
        comboSanPham = new javax.swing.JComboBox<>();
        checkboxLoaiSanPham = new javax.swing.JCheckBox();
        comboLoaiSanPham = new javax.swing.JComboBox<>();
        checkboxHoaDon = new javax.swing.JCheckBox();
        comboTaiKhoan = new javax.swing.JComboBox<>();
        checkboxKhuyenMai = new javax.swing.JCheckBox();
        comboHoaDon = new javax.swing.JComboBox<>();
        checkboxNhanVien = new javax.swing.JCheckBox();
        comboKhuyenMai = new javax.swing.JComboBox<>();
        checkboxKhachHang = new javax.swing.JCheckBox();
        comboNhanVien = new javax.swing.JComboBox<>();
        checkboxNCC = new javax.swing.JCheckBox();
        comboPhieuNhap = new javax.swing.JComboBox<>();
        checkboxPhieuNhap = new javax.swing.JCheckBox();
        comboKhachHang = new javax.swing.JComboBox<>();
        checkboxTaiKhoan = new javax.swing.JCheckBox();
        comboNCC = new javax.swing.JComboBox<>();
        btnThemSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMaQuyen.setBackground(new java.awt.Color(240, 240, 240));
        txtMaQuyen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaQuyen.setText("Q7");
        txtMaQuyen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Mã quyền"));

        txtTenQuyen.setBackground(new java.awt.Color(240, 240, 240));
        txtTenQuyen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenQuyen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tên quyền"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết quyền"));

        checkboxBanHang.setText("Bán hàng");
        checkboxBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxBanHangActionPerformed(evt);
            }
        });

        comboBanHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán hàng" }));

        checkboxNhapHang.setText("Nhập hàng");
        checkboxNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxNhapHangActionPerformed(evt);
            }
        });

        comboNhapHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhập hàng" }));

        checkboxSanPham.setText("Sản phẩm");
        checkboxSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSanPhamActionPerformed(evt);
            }
        });

        comboSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxLoaiSanPham.setText("Loại sản phẩm");
        checkboxLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxLoaiSanPhamActionPerformed(evt);
            }
        });

        comboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxHoaDon.setText("Hóa Đơn");
        checkboxHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxHoaDonActionPerformed(evt);
            }
        });

        comboTaiKhoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxKhuyenMai.setText("Khuyến mãi");
        checkboxKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxKhuyenMaiActionPerformed(evt);
            }
        });

        comboHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxNhanVien.setText("Nhân viên");
        checkboxNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxNhanVienActionPerformed(evt);
            }
        });

        comboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxKhachHang.setText("Khách hàng");
        checkboxKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxKhachHangActionPerformed(evt);
            }
        });

        comboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxNCC.setText("Nhà cung cấp");
        checkboxNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxNCCActionPerformed(evt);
            }
        });

        comboPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxPhieuNhap.setText("Phiếu nhập");
        checkboxPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPhieuNhapActionPerformed(evt);
            }
        });

        comboKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        checkboxTaiKhoan.setText("Tài khoản");
        checkboxTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxTaiKhoanActionPerformed(evt);
            }
        });

        comboNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chỉ xem", "Xem và quản lý" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkboxTaiKhoan)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(checkboxNhapHang)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkboxSanPham)
                                .addComponent(checkboxLoaiSanPham)
                                .addComponent(checkboxHoaDon)
                                .addComponent(checkboxKhuyenMai)
                                .addComponent(checkboxNhanVien)
                                .addComponent(checkboxKhachHang)
                                .addComponent(checkboxNCC)
                                .addComponent(checkboxPhieuNhap))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(checkboxBanHang)
                            .addGap(73, 73, 73)
                            .addComponent(comboBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxBanHang)
                    .addComponent(comboBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxNhapHang)
                    .addComponent(comboNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxSanPham))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxLoaiSanPham)
                    .addComponent(comboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxHoaDon)
                    .addComponent(comboHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxKhuyenMai)
                    .addComponent(comboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxNhanVien)
                    .addComponent(comboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxKhachHang)
                    .addComponent(comboKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxPhieuNhap)
                    .addComponent(comboPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxNCC)
                    .addComponent(comboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxTaiKhoan)
                    .addComponent(comboTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))); // NOI18N
        btnThemSua.setText("Thêm");
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnMainLayout.createSequentialGroup()
                                .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnMainLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnThemSua)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxBanHangActionPerformed
        comboBanHang.setEnabled(checkboxBanHang.isSelected());
    }//GEN-LAST:event_checkboxBanHangActionPerformed

    private void checkboxNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxNhapHangActionPerformed
        comboNhapHang.setEnabled(checkboxNhapHang.isSelected());
    }//GEN-LAST:event_checkboxNhapHangActionPerformed

    private void checkboxSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSanPhamActionPerformed
        comboSanPham.setEnabled(checkboxSanPham.isSelected());
    }//GEN-LAST:event_checkboxSanPhamActionPerformed

    private void checkboxLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxLoaiSanPhamActionPerformed
        comboLoaiSanPham.setEnabled(checkboxLoaiSanPham.isSelected());
    }//GEN-LAST:event_checkboxLoaiSanPhamActionPerformed

    private void checkboxHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxHoaDonActionPerformed
        comboHoaDon.setEnabled(checkboxHoaDon.isSelected());
    }//GEN-LAST:event_checkboxHoaDonActionPerformed

    private void checkboxKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxKhuyenMaiActionPerformed
        comboKhuyenMai.setEnabled(checkboxKhuyenMai.isSelected());
    }//GEN-LAST:event_checkboxKhuyenMaiActionPerformed

    private void checkboxNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxNhanVienActionPerformed
        comboNhanVien.setEnabled(checkboxNhanVien.isSelected());
    }//GEN-LAST:event_checkboxNhanVienActionPerformed

    private void checkboxKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxKhachHangActionPerformed
        comboKhachHang.setEnabled(checkboxKhachHang.isSelected());
    }//GEN-LAST:event_checkboxKhachHangActionPerformed

    private void checkboxPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxPhieuNhapActionPerformed
        comboPhieuNhap.setEnabled(checkboxPhieuNhap.isSelected());
    }//GEN-LAST:event_checkboxPhieuNhapActionPerformed

    private void checkboxNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxNCCActionPerformed
        comboNCC.setEnabled(checkboxNCC.isSelected());
    }//GEN-LAST:event_checkboxNCCActionPerformed

    private void checkboxTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxTaiKhoanActionPerformed
        comboTaiKhoan.setEnabled(checkboxTaiKhoan.isSelected());
    }//GEN-LAST:event_checkboxTaiKhoanActionPerformed

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String MaQuyen = txtMaQuyen.getText().trim();
        String TenQuyen = txtTenQuyen.getText().trim();
        String ChiTietQuyen = "";
        if(checkboxBanHang.isSelected()){
            ChiTietQuyen += "qlBanHang ";
        }
        if(checkboxNhapHang.isSelected()){
            ChiTietQuyen += "qlNhapHang ";
        }
        if(checkboxSanPham.isSelected()){
            ChiTietQuyen += ((comboSanPham.getSelectedIndex() == 0) ? "xemSanPham " : "qlSanPham ");
        }
        if(checkboxLoaiSanPham.isSelected()){
            ChiTietQuyen += ((comboLoaiSanPham.getSelectedIndex() == 0) ? "xemLoaiSanPham " : "qlLoaiSanPham ");
        }
        if(checkboxHoaDon.isSelected()){
            ChiTietQuyen += ((comboHoaDon.getSelectedIndex() == 0) ? "xemHoaDon " : "qlHoaDon ");
        }
        if(checkboxKhuyenMai.isSelected()){
            ChiTietQuyen += ((comboKhuyenMai.getSelectedIndex() == 0) ? "xemKhuyenMai " : "qlKhuyenMai ");
        }
        if(checkboxNhanVien.isSelected()){
            ChiTietQuyen += ((comboNhanVien.getSelectedIndex() == 0) ? "xemNhanVien " : "qlNhanVien ");
        }
        if(checkboxKhachHang.isSelected()){
            ChiTietQuyen += ((comboKhachHang.getSelectedIndex() == 0) ? "xemKhachHang " : "qlKhachHang ");
        }
        if(checkboxPhieuNhap.isSelected()){
            ChiTietQuyen += ((comboPhieuNhap.getSelectedIndex() == 0) ? "xemPhieuNhap " : "qlPhieuNhap ");
        }
        if(checkboxNCC.isSelected()){
            ChiTietQuyen += ((comboNCC.getSelectedIndex() == 0) ? "xemNCC " : "qlNCC ");
        }
        if(checkboxTaiKhoan.isSelected()){
            ChiTietQuyen += ((comboTaiKhoan.getSelectedIndex() == 0) ? "xemTaiKhoan " : "qlTaiKhoan ");
        }
        
        ChiTietQuyen = ChiTietQuyen.trim();
        if(btnThemSua.getText().equals("Sửa")){
            if(TenQuyen.equals("")){
                JOptionPane.showMessageDialog(this, "Sửa thất bại. Hãy kiểm tra lại tên quyền..!");
                return;
            }
            QuanlyquyenBUS qlquyen = new QuanlyquyenBUS();
            if(qlquyen.repaireQuyen(MaQuyen, TenQuyen, ChiTietQuyen)){
                GiaoDienGUI.tb.setValueRow(MaQuyen, new String[]{Integer.toString(row),MaQuyen, TenQuyen, ChiTietQuyen});
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
            this.dispose();
        }
        else{
            if(MaQuyen.equals("")){
                JOptionPane.showMessageDialog(this, "Thêm thất bại. Hãy kiểm tra lại mã quyền..!");
                return;
            }
            else{
                if(!Pattern.matches("Q[\\d]{1,}", MaQuyen)){
                    JOptionPane.showMessageDialog(this, "Thêm thất bại. Mã quyền sai quy tắc..!");
                    return;
                }
            }
            if(TenQuyen.equals("")){
                JOptionPane.showMessageDialog(this, "Thêm thất bại. Hãy kiểm tra lại tên quyền..!");
                return;
            }
            Quyen q = QuanlyquyenBUS.getQuyen(MaQuyen);
            if(q != null){
                JOptionPane.showMessageDialog(this, "Thêm thất bại. Mã quyền đã tồn tại..!");
                return;
            }
            QuanlyquyenBUS qlquyen = new QuanlyquyenBUS();
            q = new Quyen(MaQuyen, TenQuyen, ChiTietQuyen);
            if(qlquyen.addQuyen(q)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount() + 1), MaQuyen, TenQuyen, ChiTietQuyen
                });
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.JCheckBox checkboxBanHang;
    private javax.swing.JCheckBox checkboxHoaDon;
    private javax.swing.JCheckBox checkboxKhachHang;
    private javax.swing.JCheckBox checkboxKhuyenMai;
    private javax.swing.JCheckBox checkboxLoaiSanPham;
    private javax.swing.JCheckBox checkboxNCC;
    private javax.swing.JCheckBox checkboxNhanVien;
    private javax.swing.JCheckBox checkboxNhapHang;
    private javax.swing.JCheckBox checkboxPhieuNhap;
    private javax.swing.JCheckBox checkboxSanPham;
    private javax.swing.JCheckBox checkboxTaiKhoan;
    private javax.swing.JComboBox<String> comboBanHang;
    private javax.swing.JComboBox<String> comboHoaDon;
    private javax.swing.JComboBox<String> comboKhachHang;
    private javax.swing.JComboBox<String> comboKhuyenMai;
    private javax.swing.JComboBox<String> comboLoaiSanPham;
    private javax.swing.JComboBox<String> comboNCC;
    private javax.swing.JComboBox<String> comboNhanVien;
    private javax.swing.JComboBox<String> comboNhapHang;
    private javax.swing.JComboBox<String> comboPhieuNhap;
    private javax.swing.JComboBox<String> comboSanPham;
    private javax.swing.JComboBox<String> comboTaiKhoan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnMain;
    private javax.swing.JTextField txtMaQuyen;
    private javax.swing.JTextField txtTenQuyen;
    // End of variables declaration//GEN-END:variables
}
