
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaLSP extends javax.swing.JFrame {
    private int row = 0;
    
    public FormThemSuaLSP(String MaLSP) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Thêm loại sản phẩm");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaLSP.setText(MaLSP);
    }
    
    public FormThemSuaLSP(LoaiSanPham lsp, int k) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sửa loại sản phẩm");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaLSP.setText(lsp.getMaLSP());
        txtTenLSP.setText(lsp.getTenLSP());
        txtMota.setText(lsp.getMota());
        
        txtMaLSP.setEditable(false);
        btnThemSua.setText("Sửa");
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        row = k;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMaLSP = new javax.swing.JLabel();
        txtMaLSP = new javax.swing.JTextField();
        labelMaLSP1 = new javax.swing.JLabel();
        txtTenLSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        btnThemSua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaLSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaLSP.setText("Mã loại sản phẩm");

        txtMaLSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelMaLSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaLSP1.setText("Tên loại sản phẩm");

        txtTenLSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMota.setColumns(20);
        txtMota.setLineWrap(true);
        txtMota.setRows(5);
        txtMota.setWrapStyleWord(true);
        txtMota.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mô tả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setViewportView(txtMota);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelMaLSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtTenLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaLSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String type = btnThemSua.getText();
        String MaLSP = txtMaLSP.getText().trim();
        String TenLSP = txtTenLSP.getText().trim();
        String Mota = txtMota.getText().trim();
        if(type.equals("Thêm")){
            boolean t = true;
            if(MaLSP.equals("")) t = false;
            if(TenLSP.equals("")) t = false;
            if(Mota.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            if(!Pattern.matches("LSP[\\d]{1,}", MaLSP)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã loại sản phẩm sai quy tắc..!");
                return;
            }
            
            LoaiSanPham lsp = QuanlyloaisanphamBUS.getLSP(MaLSP);
            if(lsp != null){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã loại sản phẩm đã tồn tại..!");
                return;
            }
            
            QuanlyloaisanphamBUS qllsp = new QuanlyloaisanphamBUS();
            lsp = new LoaiSanPham(MaLSP, TenLSP, Mota);
            
            if(qllsp.addLSP(lsp)){
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount() + 1), MaLSP, TenLSP, Mota});
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
            this.dispose();
        }
        else{
            boolean t = true;
            if(TenLSP.equals("")) t = false;
            if(Mota.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            QuanlyloaisanphamBUS qllsp = new QuanlyloaisanphamBUS();
            if(qllsp.repaireLSP(MaLSP, TenLSP, Mota)){
                GiaoDienGUI.tb.setValueRow(MaLSP, new String[]{Integer.toString(row), MaLSP, TenLSP, Mota});
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
//            java.util.logging.Logger.getLogger(FormThemSuaLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaLSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaLSP("thiện").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMaLSP;
    private javax.swing.JLabel labelMaLSP1;
    private javax.swing.JTextField txtMaLSP;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtTenLSP;
    // End of variables declaration//GEN-END:variables
}
