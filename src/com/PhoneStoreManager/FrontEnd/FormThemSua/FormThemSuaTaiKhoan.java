
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.TaiKhoan;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.XulyTaiKhoanBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormThemSuaTaiKhoan extends javax.swing.JFrame {
    private int row = 0;
    public FormThemSuaTaiKhoan() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Thêm tài khoản");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public FormThemSuaTaiKhoan(TaiKhoan tk, int k) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Sửa tài khoản");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        txtTenTaiKhoan.setText(tk.getTenTaiKhoan());
        txtMaNV.setText(tk.getMaNV());
        txtMaQuyen.setText(tk.getMaQuyen());
        txtMatKhau.setText(tk.getMatKhau());
        btnThemSua.setText("Sửa");
        txtTenTaiKhoan.setEditable(false);
        row = k;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTenTaiKhoan = new javax.swing.JLabel();
        txtTenTaiKhoan = new javax.swing.JTextField();
        labelMatKhau = new javax.swing.JLabel();
        labelMaNV = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        labelMaQuyen = new javax.swing.JLabel();
        labelMoreNV = new javax.swing.JLabel();
        txtMaQuyen = new javax.swing.JTextField();
        labelMoreMaQuyen = new javax.swing.JLabel();
        btnThemSua = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTenTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTenTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTenTaiKhoan.setText("Tên tài khoản");

        labelMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMatKhau.setText("Mật khẩu");

        labelMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMaNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMaNV.setText("Mã nhân viên");

        labelMaQuyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMaQuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMaQuyen.setText("Mã quyền");

        labelMoreNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMoreNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMoreNV.setText("...");
        labelMoreNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelMoreNV.setPreferredSize(new java.awt.Dimension(14, 15));
        labelMoreNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelMoreNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelMoreNVMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMoreNVMousePressed(evt);
            }
        });

        labelMoreMaQuyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMoreMaQuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMoreMaQuyen.setText("...");
        labelMoreMaQuyen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelMoreMaQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelMoreMaQuyenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelMoreMaQuyenMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMoreMaQuyenMousePressed(evt);
            }
        });

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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMaQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(labelMoreNV, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(labelMoreMaQuyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelTenTaiKhoan)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(txtMatKhau))
                        .addGap(2, 2, 2)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(btnThemSua)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMoreNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMoreMaQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(btnThemSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelMoreNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreNVMouseExited
        labelMoreNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_labelMoreNVMouseExited

    private void labelMoreNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreNVMouseEntered
        labelMoreNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 115, 232)));
    }//GEN-LAST:event_labelMoreNVMouseEntered

    private void labelMoreMaQuyenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreMaQuyenMouseEntered
        labelMoreMaQuyen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 115, 232)));
    }//GEN-LAST:event_labelMoreMaQuyenMouseEntered

    private void labelMoreMaQuyenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreMaQuyenMouseExited
        labelMoreMaQuyen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_labelMoreMaQuyenMouseExited

    private void labelMoreNVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreNVMousePressed
        new FormChon("ChonNhanVien").setVisible(true);
    }//GEN-LAST:event_labelMoreNVMousePressed

    private void labelMoreMaQuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMoreMaQuyenMousePressed
        new FormChon("ChonMaQuyen").setVisible(true);
    }//GEN-LAST:event_labelMoreMaQuyenMousePressed

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String type = btnThemSua.getText();
        String TenTaiKhoan = txtTenTaiKhoan.getText().trim();
        String MatKhau = txtMatKhau.getText().trim();
        String MaQuyen = txtMaQuyen.getText().trim();
        String MaNV = txtMaNV.getText().trim();
        if(type.equals("Sửa")){
            boolean t = true;
            if(MatKhau.equals("")) t = false;
            if(MaNV.equals("")) t = false;
            if(MaQuyen.equals("")) t = false;
            if(!t){
                JOptionPane.showMessageDialog(this, "Sửa tài khoản thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            NhanVien nv = QuanlynhanvienBUS.getNhanVien(MaNV);
            if(nv == null){
                JOptionPane.showMessageDialog(this, "Sửa tài khoản thất bại. Mã nhân viên không tồn tại..!");
                return;
            }
            Quyen q = QuanlyquyenBUS.getQuyen(MaQuyen);
            if(q == null){
                JOptionPane.showMessageDialog(this, "Sửa tài khoản thất bại. Mã quyền không tồn tại..!");
                return;
            }
            
            XulyTaiKhoanBUS xltkBUS = new XulyTaiKhoanBUS();
            if(xltkBUS.repairTaiKhoan(TenTaiKhoan, MatKhau, MaNV, MaQuyen)){
                GiaoDienGUI.tb.setValueRow(TenTaiKhoan, new String[]{Integer.toString(row), TenTaiKhoan, MatKhau, MaNV, MaQuyen});
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
            this.dispose();
        }
        else{
            boolean t = true;
            if(TenTaiKhoan.equals("")) t = false;
            if(MatKhau.equals("")) t = false;
            if(MaNV.equals("")) t = false;
            if(MaQuyen.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            TaiKhoan tk = XulyTaiKhoanBUS.getTaiKhoan(TenTaiKhoan);
            if(tk != null){
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại. Tài khoản đã tồn tại..!");
                return;
            }
            NhanVien nv = QuanlynhanvienBUS.getNhanVien(MaNV);
            if(nv == null){
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại. Mã nhân viên không tồn tại..!");
                return;
            }
            Quyen q = QuanlyquyenBUS.getQuyen(MaQuyen);
            if(q == null){
                JOptionPane.showMessageDialog(this, "Thêm tài khoản thất bại. Mã quyền không tồn tại..!");
                return;
            }
            tk = new TaiKhoan(TenTaiKhoan, MatKhau, MaNV, MaQuyen);
            XulyTaiKhoanBUS xltkBUS = new XulyTaiKhoanBUS();
            if(xltkBUS.addTaiKhoan(tk)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount()+1), TenTaiKhoan, MatKhau, MaNV, MaQuyen
                });
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed

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
//            java.util.logging.Logger.getLogger(FormThemSuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaTaiKhoan("").setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.JLabel labelMaNV;
    private javax.swing.JLabel labelMaQuyen;
    private javax.swing.JLabel labelMatKhau;
    private javax.swing.JLabel labelMoreMaQuyen;
    private javax.swing.JLabel labelMoreNV;
    private javax.swing.JLabel labelTenTaiKhoan;
    public static javax.swing.JTextField txtMaNV;
    public static javax.swing.JTextField txtMaQuyen;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
