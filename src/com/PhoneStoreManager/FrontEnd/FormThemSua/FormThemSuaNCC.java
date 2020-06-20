
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaNCC extends javax.swing.JFrame {
    private int row = 0;
    public FormThemSuaNCC(String MaNCC) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Thêm nhà cung cấp");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaNCC.setText(MaNCC);
    }
    
    public FormThemSuaNCC(NCC ncc, int k){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sửa nhà cung cấp");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaNCC.setText(ncc.getMaNCC());
        txtTenNCC.setText(ncc.getTenNCC());
        txtDiachi.setText(ncc.getDiaChi());
        txtSDT.setText(ncc.getSDT());
        txtFax.setText(ncc.getFax());
        
        txtMaNCC.setEditable(false);
        btnThemSua.setText("Sửa");
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        row = k;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMaNCC = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        labelTenNCC = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        labelDiachi = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        labelSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        labelFax = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        btnThemSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaNCC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaNCC.setText("Mã nhà cung cấp");

        txtMaNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelTenNCC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTenNCC.setText("Tên nhà cung cấp");

        txtTenNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelDiachi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelDiachi.setText("Địa chỉ");

        txtDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelSDT.setText("Số điện thoại");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelFax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelFax.setText("Fax");

        txtFax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtSDT))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFax, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtFax))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTenNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMaNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiachi)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String type = btnThemSua.getText();
        String MaNCC = txtMaNCC.getText().trim();
        String TenNCC = txtTenNCC.getText().trim();
        String Diachi = txtDiachi.getText().trim();
        String SDT = txtSDT.getText().trim();
        String Fax = txtFax.getText().trim();
        if(type.equals("Thêm")){
            boolean t = true;
            if(MaNCC.equals("")) t = false;
            if(TenNCC.equals("")) t = false;
            if(Diachi.equals("")) t = false;
            if(SDT.equals("")) t = false;
            if(Fax.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            if(!Pattern.matches("NCC[\\d]{1,}", MaNCC)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã nhà cung cấp sai quy tắc..!");
                return;
            }
            
            NCC ncc = QuanlyNCCBUS.getNCC(MaNCC);
            if(ncc != null){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã nhà cung cấp đã tồn tại..!");
                return;
            }
            
            QuanlyNCCBUS qlncc = new QuanlyNCCBUS();
            ncc = new NCC(MaNCC, TenNCC, Diachi, SDT, Fax);
            
            if(qlncc.addNCC(ncc)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount() + 1), MaNCC, TenNCC, Diachi, SDT, Fax
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
            if(TenNCC.equals("")) t = false;
            if(Diachi.equals("")) t = false;
            if(SDT.equals("")) t = false;
            if(Fax.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            QuanlyNCCBUS qlncc = new QuanlyNCCBUS();
            if(qlncc.repaireNCC(MaNCC, TenNCC, Diachi, SDT, Fax)){
                GiaoDienGUI.tb.setValueRow(MaNCC, new String[]{
                    Integer.toString(row), MaNCC, TenNCC, Diachi, SDT, Fax
                });
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed
//
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
//            java.util.logging.Logger.getLogger(FormThemSuaNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaNCC("thiện").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.JLabel labelDiachi;
    private javax.swing.JLabel labelFax;
    private javax.swing.JLabel labelMaNCC;
    private javax.swing.JLabel labelSDT;
    private javax.swing.JLabel labelTenNCC;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
