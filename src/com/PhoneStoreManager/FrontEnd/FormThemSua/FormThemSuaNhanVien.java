
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaNhanVien extends javax.swing.JFrame {
    private int row = -1;

    public FormThemSuaNhanVien(NhanVien nv, int row) {
        initComponents();
        ImageIcon logo = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png"));
        setIconImage(logo.getImage());
        this.setLocationRelativeTo(null);
        this.setTitle("Sửa thông tin nhân viên");
        
        txtMaNV.setText(nv.getMaNV());
        txtMaNV.setEditable(false);
        
        txtTenNV.setText(nv.getTenNV());
        String[] d = nv.getNgaySinh().split("-");
        txtDate.setDate(new Date(Integer.parseInt(d[0])-1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[2])));
        
        txtDiaChi.setText(nv.getDiaChi());
        txtSDT.setText(nv.getSDT());
        if(nv.getTrangThai() == 1){
            btnConLam.setSelected(true);
        }
        else{
            btnHetLam.setSelected(true);
        }
        
        this.row = row;
        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public FormThemSuaNhanVien(String MaNV) {
        initComponents();
        ImageIcon logo = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"));
        setIconImage(logo.getImage());
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")));
        btnThemSua.setText("Thêm");
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm thông tin nhân viên");
        
        txtMaNV.setText(MaNV);
        btnConLam.setSelected(true);
//        btnConLam.setEnabled(false);
        btnHetLam.setEnabled(false);
        
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        labelTen = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        labelNgaySinh = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        labelDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        labelSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        labelTrangThai = new javax.swing.JLabel();
        btnThemSua = new javax.swing.JButton();
        btnConLam = new javax.swing.JRadioButton();
        btnHetLam = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaNV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelMaNV.setText("Mã nhân viên: ");

        labelTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTen.setText("Tên nhân viên:");

        labelNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNgaySinh.setText("Ngày sinh:");

        labelDiaChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDiaChi.setText("Địa chỉ:");

        labelSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSDT.setText("Số điện thoại:");

        labelTrangThai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTrangThai.setText("Trạng thái:");

        btnThemSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png"))); // NOI18N
        btnThemSua.setText("Sửa");
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        btnTrangThai.add(btnConLam);
        btnConLam.setText("Còn làm");

        btnTrangThai.add(btnHetLam);
        btnHetLam.setText("Hết làm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelMaNV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(txtDiaChi)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConLam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHetLam)))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConLam)
                    .addComponent(btnHetLam))
                .addGap(31, 31, 31)
                .addComponent(btnThemSua)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String type = btnThemSua.getText();
        if(type.equals("Sửa")){
            boolean t = true;
            
            // Mã nhân viên
            String MaNV = txtMaNV.getText().trim();
            
            // Kiểm tra tên nhân viên
            String TenNV = txtTenNV.getText().trim();
            if(TenNV.equals("")){
                t = false;
            }
            
            // Kiểm tra ngày sinh
            String Dateborn = "";
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
                Dateborn = sdf.format(txtDate.getDate());
            }
            catch(Exception e){
                Dateborn = "";
            }
            if(Dateborn.equals("")){
                t = false;
            }
            
            // Kiểm tra Địa chỉ
            String DiaChi = txtDiaChi.getText().trim();
            if(DiaChi.equals("")){
                t = false;
            }
            
            // Kiểm tra SDT
            String SDT = txtSDT.getText().trim();
            if(SDT.equals("")){
                t = false;
            }
            if(SDT.length() > 11 || SDT.length() < 10){
                t = false;
            }
            
            String TrangThai = "";
            if(btnConLam.isSelected()){
                TrangThai = "Còn làm";
            }
            else if(btnHetLam.isSelected()){
                TrangThai = "Hết làm";
            }
            else {
                t = false;
            }
            
            if(!t){
                JOptionPane.showMessageDialog(this, "Sửa thông tin thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            QuanlynhanvienBUS qlnv = new QuanlynhanvienBUS();
            if (qlnv.repairNhanVien(MaNV, TenNV, Dateborn, DiaChi, SDT, (TrangThai.equals("Còn làm")) ? 1 : 0)){
                GiaoDienGUI.tb.setValueRow(MaNV, new String[]{Integer.toString(row), MaNV, TenNV, Dateborn, DiaChi, SDT, TrangThai});

                JOptionPane.showMessageDialog(this, "Sửa thành công");
            }
            else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
            
            this.dispose();
        } else if(type.equals("Thêm")){
            boolean t = true;
            
            // Kiểm tra Mã nhân viên
            String MaNV = txtMaNV.getText().trim();
            if(MaNV.equals("")){
                t = false;
            }
            else{
                if(!Pattern.matches("NV[\\d]{1,}", MaNV)){
                    t = false;
                }
            }
            
            // Kiểm tra tên nhân viên
            String TenNV = txtTenNV.getText().trim();
            if(TenNV.equals("")){
                t = false;
            }
            
            // Kiểm tra ngày sinh
            String Dateborn = "";
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
                Dateborn = sdf.format(txtDate.getDate());
            }
            catch(Exception e){
                Dateborn = "";
            }
            if(Dateborn.equals("")){
                t = false;
            }
            
            // Kiểm tra Địa chỉ
            String DiaChi = txtDiaChi.getText().trim();
            if(DiaChi.equals("")){
                t = false;
            }
            
            // Kiểm tra SDT
            String SDT = txtSDT.getText().trim();
            if(SDT.equals("")){
                t = false;
            }
            if(SDT.length() > 11 || SDT.length() < 10){
                t = false;
            }
            
            String TrangThai = "";
            if(btnConLam.isSelected()){
                TrangThai = "Còn làm";
            }
            else if(btnHetLam.isSelected()){
                TrangThai = "Hết làm";
            }
            else {
                t = false;
            }
            
            if(!t){
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            QuanlynhanvienBUS qlnv = new QuanlynhanvienBUS();
            NhanVien nv = qlnv.getNhanVien(MaNV);
            if(nv != null){
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại. Mã nhân viên đã tồn tại..!");
                return;
            }
            
            nv = new NhanVien(MaNV, TenNV, Dateborn, DiaChi, SDT, (TrangThai.equals("Còn làm")) ? 1 : 0);
            if(qlnv.addNhanVien(nv)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount()+1), MaNV, TenNV, Dateborn, DiaChi, SDT, TrangThai
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
    private javax.swing.JRadioButton btnConLam;
    private javax.swing.JRadioButton btnHetLam;
    private javax.swing.JButton btnThemSua;
    private javax.swing.ButtonGroup btnTrangThai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDiaChi;
    private javax.swing.JLabel labelMaNV;
    private javax.swing.JLabel labelNgaySinh;
    private javax.swing.JLabel labelSDT;
    private javax.swing.JLabel labelTen;
    private javax.swing.JLabel labelTrangThai;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
