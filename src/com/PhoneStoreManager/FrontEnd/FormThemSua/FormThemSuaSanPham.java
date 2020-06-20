
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import static com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI.tb;
import java.awt.FileDialog;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormThemSuaSanPham extends javax.swing.JFrame {
    private int row = 0;
    private String url = "";
    private String img = "";
    public FormThemSuaSanPham(String MaSP) {
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Thêm sản phẩm");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaSP.setText(MaSP);
        checkboxHien.setSelected(true);
        checkboxAn.setSelected(false);
    }
    
    public FormThemSuaSanPham(SanPham sp, int k){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sửa sản phẩm");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaSP.setText(sp.getMaSP());
        txtMaLSP.setText(sp.getMaLSP());
        txtTenSP.setText(sp.getTenSP());
        txtDonGia.setText(Long.toString(sp.getDonGia()));
        txtSoLuong.setText(Integer.toString(sp.getSoLuong()));
        txtTenFileAnh.setText(sp.getHinhAnh());
        img = sp.getHinhAnh();
        if(sp.getTrangThai() == 1){
            checkboxHien.setSelected(true);
        }
        else{
            checkboxAn.setSelected(true);
        }
        
        txtMaSP.setEditable(false);
        btnThemSua.setText("Sửa");
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        row = k;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelMaSP = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        labelMaLSP = new javax.swing.JLabel();
        txtMaLSP = new javax.swing.JTextField();
        labelChonMaLSP = new javax.swing.JLabel();
        labelTenSP = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        labelDonGia = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        labelSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        labelTenFileAnh = new javax.swing.JLabel();
        txtTenFileAnh = new javax.swing.JTextField();
        labelforder = new javax.swing.JLabel();
        labelTrangThai = new javax.swing.JLabel();
        checkboxHien = new javax.swing.JCheckBox();
        checkboxAn = new javax.swing.JCheckBox();
        btnThemSua = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaSP.setText("Mã sản phẩm");
        labelMaSP.setToolTipText("");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaLSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaLSP.setText("Mã loại sản phẩm");
        labelMaLSP.setToolTipText("");

        txtMaLSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelChonMaLSP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelChonMaLSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChonMaLSP.setText("...");
        labelChonMaLSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelChonMaLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelChonMaLSPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelChonMaLSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelChonMaLSPMouseExited(evt);
            }
        });

        labelTenSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTenSP.setText("Tên sản phẩm");
        labelTenSP.setToolTipText("");

        txtTenSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelDonGia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelDonGia.setText("Đơn giá");
        labelDonGia.setToolTipText("");

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDonGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyTyped(evt);
            }
        });

        labelSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSoLuong.setText("Số lượng");
        labelSoLuong.setToolTipText("");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        labelTenFileAnh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTenFileAnh.setText("Tên file ảnh");
        labelTenFileAnh.setToolTipText("");

        txtTenFileAnh.setEditable(false);
        txtTenFileAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelforder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelforder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/folder.png"))); // NOI18N
        labelforder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelforder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelforderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelforderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelforderMouseExited(evt);
            }
        });

        labelTrangThai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTrangThai.setText("Trạng thái");
        labelTrangThai.setToolTipText("");

        buttonGroup1.add(checkboxHien);
        checkboxHien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkboxHien.setText("Hiện");

        buttonGroup1.add(checkboxAn);
        checkboxAn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkboxAn.setText("Ẩn");

        btnThemSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))); // NOI18N
        btnThemSua.setText("Thêm");
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        jLabel2.setText("VND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelChonMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTenFileAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenFileAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkboxHien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(checkboxAn)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelforder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChonMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenFileAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenFileAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelforder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxHien)
                    .addComponent(checkboxAn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelforderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelforderMouseEntered
        labelforder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,204,255)));
    }//GEN-LAST:event_labelforderMouseEntered

    private void labelforderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelforderMouseExited
        labelforder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_labelforderMouseExited

    private void labelforderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelforderMouseClicked
        FileDialog fd = new FileDialog(this);
        fd.setTitle("Chọn ảnh");
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename != null) {
            if(filename.contains(".png") || filename.contains(".jpg")){
                txtTenFileAnh.setText(filename);
                url = fd.getDirectory() + fd.getFile();
                System.out.println(fd.getDirectory() + fd.getFile());
            }
        }
    }//GEN-LAST:event_labelforderMouseClicked

    private void labelChonMaLSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChonMaLSPMouseEntered
        labelChonMaLSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,204,255)));
    }//GEN-LAST:event_labelChonMaLSPMouseEntered

    private void labelChonMaLSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChonMaLSPMouseExited
        labelChonMaLSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
    }//GEN-LAST:event_labelChonMaLSPMouseExited

    private void txtDonGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonGiaKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDonGiaKeyTyped

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSoLuongKeyTyped

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String MaSP = txtMaSP.getText().trim();
        String MaLSP = txtMaLSP.getText().trim();
        String TenSP = txtTenSP.getText().trim();
        String DonGia = txtDonGia.getText().trim();
        String SoLuong = txtSoLuong.getText().trim();
        String TenAnh = txtTenFileAnh.getText().trim();
        String TrangThai = "";
        if(checkboxHien.isSelected()){
            TrangThai = "Hiện";
        }
        else if(checkboxAn.isSelected()){
            TrangThai = "Ẩn";
        }
        String type = btnThemSua.getText();
        if(type.equals("Thêm")){
            boolean t = true;
            if(MaSP.equals("")) t = false;
            if(MaLSP.equals("")) t = false;
            if(TenSP.equals("")) t = false;
            if(DonGia.equals("")) t = false;
            if(SoLuong.equals("")) t = false;
            if(TenAnh.equals("")) t = false;
            if(TrangThai.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            if(!Pattern.matches("SP[\\d]{1,}", MaSP)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã sản phẩm sai quy tắc..!");
                return;
            }
            
            if(!Pattern.matches("LSP[\\d]{1,}", MaLSP)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã loại sản phẩm sai quy tắc..!");
                return;
            }
            
            if(!Pattern.matches("[\\d]{1,}", DonGia)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Đơn giá phải là số..!");
                return;
            }
            
            if(!Pattern.matches("[\\d]{1,}", SoLuong)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Đơn giá phải là số..!");
                return;
            }
            
            if(Long.parseLong(DonGia) == 0){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Đơn giá phải lớn hơn không..!");
                return;
            }
            
            if(Long.parseLong(SoLuong) == 0){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Số lượng phải lớn hơn không..!");
                return;
            }
            
            SanPham sp = QuanlysanphamBUS.getSanPham(MaSP);
            if(sp != null){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã sản phẩm đã tồn tại..!");
                return;
            }
            sp = new SanPham(MaSP, MaLSP, TenSP, Long.parseLong(DonGia), Integer.parseInt(SoLuong), TenAnh, (TrangThai.equals("Hiện")) ? 1: 0);
            QuanlysanphamBUS qlsp = new QuanlysanphamBUS();
            if(qlsp.addSanPham(sp)){
                if(SaveImg(TenAnh)){
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
                    return;
                }
                ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + TenAnh));
                Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imgScaled));
                tb.addRow(new Object[]{Integer.toString(GiaoDienGUI.tb.getRowCount()+1), MaSP, MaLSP, TenSP, QuanlykhuyenmaiBUS.ToCurrent(DonGia),
                    QuanlykhuyenmaiBUS.ToCurrent(SoLuong), label, TrangThai
                });
                
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
            this.dispose();
        }
        else{
            boolean t = true;
            if(MaLSP.equals("")) t = false;
            if(TenSP.equals("")) t = false;
            if(DonGia.equals("")) t = false;
            if(SoLuong.equals("")) t = false;
            if(TenAnh.equals("")) t = false;
            if(TrangThai.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            if(!Pattern.matches("LSP[\\d]{1,}", MaLSP)){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Mã loại sản phẩm sai quy tắc..!");
                return;
            }
            
            if(!Pattern.matches("[\\d]{1,}", DonGia)){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Đơn giá phải là số..!");
                return;
            }
            
            if(!Pattern.matches("[\\d]{1,}", SoLuong)){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Đơn giá phải là số..!");
                return;
            }
            
            if(Long.parseLong(DonGia) == 0){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Đơn giá phải lớn hơn không..!");
                return;
            }
            
            if(Long.parseLong(SoLuong) == 0){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Số lượng phải lớn hơn không..!");
                return;
            }
            QuanlysanphamBUS qlsp = new QuanlysanphamBUS();
            if(qlsp.repairSanPham(MaSP, MaLSP, TenSP, Long.parseLong(DonGia), Integer.parseInt(SoLuong), TenAnh, (TrangThai.equals("Hiện"))? 1 : 0)){
                if(SaveImg(TenAnh) && DeleteAnh(img)){
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
                    return;
                }
                ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + TenAnh));
                Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imgScaled));
                GiaoDienGUI.tb.setValueRow(MaSP, new Object[]{
                    Integer.toString(row), MaSP, MaLSP, TenSP, QuanlykhuyenmaiBUS.ToCurrent(DonGia),
                    QuanlykhuyenmaiBUS.ToCurrent(SoLuong), label, TrangThai
                });
                
                
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed

    private boolean SaveImg(String url2){
        if(url.equals("")) return false;
        File source = new File(url);
        File dest = new File("src/com/PhoneStoreManager/image/product/" + url2);
 
        InputStream is = null;
        OutputStream os = null;
        boolean t = true;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
             
            while ((length = is.read(buffer)) > 0) {
                 
                os.write(buffer, 0, length);
            }
            t = true;
        } catch (Exception e) {
            t = false;
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                t = false;
                e.printStackTrace();
            }
        }
        return t;
    }
    
    private boolean DeleteAnh(String anh){
        boolean t = true;
        try {
            File file = new File("src/com/PhoneStoreManager/image/product/" + anh);
            if (file.delete()) {
                t = true;
            } else {
                t = false;
            }
        } catch (Exception e) {
            t = false;
            e.printStackTrace();
        }
        return t;
    }
    
    private void labelChonMaLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelChonMaLSPMouseClicked
        new FormChon("ChonMaLoaiSanPham").setVisible(true);
    }//GEN-LAST:event_labelChonMaLSPMouseClicked
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaSanPham("").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkboxAn;
    private javax.swing.JCheckBox checkboxHien;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelChonMaLSP;
    private javax.swing.JLabel labelDonGia;
    private javax.swing.JLabel labelMaLSP;
    private javax.swing.JLabel labelMaSP;
    private javax.swing.JLabel labelSoLuong;
    private javax.swing.JLabel labelTenFileAnh;
    private javax.swing.JLabel labelTenSP;
    private javax.swing.JLabel labelTrangThai;
    private javax.swing.JLabel labelforder;
    private javax.swing.JTextField txtDonGia;
    public static javax.swing.JTextField txtMaLSP;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenFileAnh;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
