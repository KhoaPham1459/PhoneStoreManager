
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlykhachhang.KhachHang;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.QuanlykhachhangBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaKhachHang extends javax.swing.JFrame {
    private int row;
    
    public FormThemSuaKhachHang(String MaKH) {
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Thêm khách hàng");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaKH.setText(MaKH);
        checkboxHien.setSelected(true);
        checkboxAn.setEnabled(false);
    }
    
    public FormThemSuaKhachHang(KhachHang KH, int k){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sửa khách hàng");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        System.out.println(KH.getMaKH());
        txtMaKH.setText(KH.getMaKH());
        txtTenKH.setText(KH.getTenKH());
        txtDiachi.setText(KH.getDiaChi());
        txtSDT.setText(KH.getSDT());
        if(KH.getTrangThai() == 1){
            checkboxHien.setSelected(true);
        }
        else{
            checkboxAn.setSelected(true);
        }
        
        txtMaKH.setEditable(false);
        btnThemSua.setText("Sửa");
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        row = k;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupHienAn = new javax.swing.ButtonGroup();
        labelMaKH = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        labelMaKH1 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        labelMaKH2 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        labelMaKH3 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        labelMaKH4 = new javax.swing.JLabel();
        checkboxHien = new javax.swing.JCheckBox();
        checkboxAn = new javax.swing.JCheckBox();
        btnThemSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaKH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKH.setText("Mã khách hàng");

        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaKH1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKH1.setText("Tên khách hàng");

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaKH2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKH2.setText("Địa chỉ");

        txtDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaKH3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKH3.setText("Số điện thoại");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaKH4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKH4.setText("Trạng thái");

        btnGroupHienAn.add(checkboxHien);
        checkboxHien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkboxHien.setText("Hiện");

        btnGroupHienAn.add(checkboxAn);
        checkboxAn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        checkboxAn.setText("Ẩn");

        btnThemSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))); // NOI18N
        btnThemSua.setText("Thêm");
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelMaKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMaKH3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMaKH4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkboxHien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkboxAn))
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKH3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKH4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxHien)
                    .addComponent(checkboxAn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String MaKH = txtMaKH.getText().trim();
        String TenKH = txtTenKH.getText().trim();
        String Diachi = txtDiachi.getText().trim();
        String SDT = txtSDT.getText().trim();
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
            if(MaKH.equals("")) t = false;
            if(TenKH.equals("")) t = false;
            if(Diachi.equals("")) t = false;
            if(SDT.equals("")) t = false;
            if(TrangThai.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            if(!Pattern.matches("KH[\\d]{1,}", MaKH)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã khách hàng sai quy tắc..!");
            }
            
            KhachHang KH = QuanlykhachhangBUS.getKhachHang(MaKH);
            if(KH != null){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã khách hàng đã tồn tại..!");
                return;
            }
            QuanlykhachhangBUS qlkh = new QuanlykhachhangBUS();
            KH = new KhachHang(MaKH, TenKH, Diachi, SDT, (TrangThai.equals("Hiện")) ? 1 : 0);
            if(qlkh.addKhachHang(KH)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount()+1), MaKH, TenKH, Diachi, SDT, TrangThai
                });
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
            this.dispose();
        }
        else{
            boolean t = true;
            if(TenKH.equals("")) t = false;
            if(Diachi.equals("")) t = false;
            if(SDT.equals("")) t = false;
            if(TrangThai.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            QuanlykhachhangBUS qlkh = new QuanlykhachhangBUS();
            if(qlkh.repairKhachHang(MaKH, TenKH, Diachi, SDT, (TrangThai.equals("Hiện")) ? 1 : 0)){
                GiaoDienGUI.tb.setValueRow(MaKH, new String[]{Integer.toString(row), MaKH, TenKH, Diachi, SDT, TrangThai});
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed

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
//            java.util.logging.Logger.getLogger(FormThemSuaKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaKhachHang("thiện").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupHienAn;
    private javax.swing.JButton btnThemSua;
    private javax.swing.JCheckBox checkboxAn;
    private javax.swing.JCheckBox checkboxHien;
    private javax.swing.JLabel labelMaKH;
    private javax.swing.JLabel labelMaKH1;
    private javax.swing.JLabel labelMaKH2;
    private javax.swing.JLabel labelMaKH3;
    private javax.swing.JLabel labelMaKH4;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
