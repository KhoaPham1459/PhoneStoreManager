
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.KhuyenMai;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormThemSuaKhuyenMai extends javax.swing.JFrame {
    private int row = 0;
    public FormThemSuaKhuyenMai(String MaKM) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Thêm khuyến mãi");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaKM.setText(MaKM);
    }
    
    public FormThemSuaKhuyenMai(KhuyenMai km, int k) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sửa khuyến mãi");
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        txtMaKM.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtDieuKienKM.setText(Long.toString(km.getDieuKienKM()));
        txtPhanTramKM.setText(Integer.toString(km.getPhanTramKM()));
        String[] ss = km.getNgayBD().toString().split("-");
        txtNgayBD.setDate(new Date(Integer.parseInt(ss[0])-1900, Integer.parseInt(ss[1])-1, Integer.parseInt(ss[2])));
        ss = km.getNgayKT().toString().split("-");
        txtNgayKT.setDate(new Date(Integer.parseInt(ss[0])-1900, Integer.parseInt(ss[1])-1, Integer.parseInt(ss[2])));
        
        txtMaKM.setEditable(false);
        btnThemSua.setText("Sửa");
        btnThemSua.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/edit-tools.png")));
        row = k;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMaKM = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        labelTenKM = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        labelDieuKienKM = new javax.swing.JLabel();
        txtDieuKienKM = new javax.swing.JTextField();
        labelPhanTramKM = new javax.swing.JLabel();
        txtPhanTramKM = new javax.swing.JTextField();
        labelNgayBD = new javax.swing.JLabel();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        labelNagyKT = new javax.swing.JLabel();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        btnThemSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMaKM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelMaKM.setText("Mã khuyến mãi");

        labelTenKM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTenKM.setText("Tên khuyến mãi");

        labelDieuKienKM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelDieuKienKM.setText("Điều kiện khuyến mãi");

        txtDieuKienKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDieuKienKMKeyTyped(evt);
            }
        });

        labelPhanTramKM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPhanTramKM.setText("Phần trăm khuyến mãi");

        txtPhanTramKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhanTramKMKeyTyped(evt);
            }
        });

        labelNgayBD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNgayBD.setText("Ngày bắt đầu");

        labelNagyKT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNagyKT.setText("Ngày kết thúc");

        btnThemSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))); // NOI18N
        btnThemSua.setText("Thêm");
        btnThemSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSuaActionPerformed(evt);
            }
        });

        jLabel1.setText("%");

        jLabel2.setText("VND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNagyKT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelDieuKienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(txtDieuKienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPhanTramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhanTramKM, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDieuKienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDieuKienKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhanTramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhanTramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNagyKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnThemSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSuaActionPerformed
        String MaKM = txtMaKM.getText().trim();
        String TenKM = txtTenKM.getText().trim();
        String DieuKienKM = txtDieuKienKM.getText().trim();
        String PhanTramKM = txtPhanTramKM.getText().trim();
        String NgayBD = "";
        String NgayKT = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
        if(txtNgayBD.getDate() != null){
            NgayBD = sdf.format(txtNgayBD.getDate());
        }
        if(txtNgayKT.getDate() != null){
            NgayKT = sdf.format(txtNgayKT.getDate());
        }
        String type = btnThemSua.getText();
        if(type.equals("Thêm")){
            boolean t = true;
            if(MaKM.equals("")) t = false;
            if(TenKM.equals("")) t = false;
            if(DieuKienKM.equals("")) t = false;
            if(PhanTramKM.equals("")) t = false;
            if(NgayBD.equals("")) t = false;
            if(NgayKT.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            if(!Pattern.matches("KM[\\d]{1,}", MaKM)){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã khuyến mãi sai quy tắc..!");
                return;
            }
            
            LocalDate today = LocalDate.now();
            String[] day = today.toString().split("-");
            String[] kt = NgayKT.split("-");
            String[] bd = NgayBD.split("-");
            if(!QuanlykhuyenmaiBUS.CompareDate(bd[0], bd[1], bd[2], kt[0], kt[1], kt[2])){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Lỗi nhập ngày bắt đầu và ngày kết thúc..!");
                return;
            }
            
            KhuyenMai km = QuanlykhuyenmaiBUS.getKhuyenMai(MaKM);
            if(km != null){
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại. Mã khuyến mãi đã tồn tại..!");
                return;
            }
            
            QuanlykhuyenmaiBUS qlkm = new QuanlykhuyenmaiBUS();
            km = new KhuyenMai(MaKM, TenKM, Long.parseLong(DieuKienKM), Integer.parseInt(PhanTramKM), LocalDate.parse(NgayBD), LocalDate.parse(NgayKT));
            
            if(qlkm.addKhuyenMai(km)){
                String trangthai = "Đang diễn ra";
                if(today.toString().equals(NgayKT)){
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
                GiaoDienGUI.tb.addRow(new String[]{
                    Integer.toString(GiaoDienGUI.tb.getRowCount() + 1), MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT, trangthai
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
            if(TenKM.equals("")) t = false;
            if(DieuKienKM.equals("")) t = false;
            if(PhanTramKM.equals("")) t = false;
            if(NgayBD.equals("")) t = false;
            if(NgayKT.equals("")) t = false;
            
            if(!t){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Hãy kiểm tra lại các trường dữ liệu..!");
                return;
            }
            
            LocalDate today = LocalDate.now();
            String[] day = today.toString().split("-");
            String[] kt = NgayKT.split("-");
            String[] bd = NgayBD.split("-");
            if(!QuanlykhuyenmaiBUS.CompareDate(bd[0], bd[1], bd[2], kt[0], kt[1], kt[2])){
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại. Lỗi nhập ngày bắt đầu và ngày kết thúc..!");
                return;
            }
            
            QuanlykhuyenmaiBUS qlkm = new QuanlykhuyenmaiBUS();
            if(qlkm.repaireKhuyenMai(MaKM, TenKM, Long.parseLong(DieuKienKM), Integer.parseInt(PhanTramKM), LocalDate.parse(NgayBD), LocalDate.parse(NgayKT))){
                String trangthai = "Đang diễn ra";
                if(today.toString().equals(NgayKT)){
                    trangthai = "Đã kết thúc";
                }
                else{
                    if(!(QuanlykhuyenmaiBUS.CompareDate(day[0], day[1], day[2], kt[0], kt[1], kt[2]) && QuanlykhuyenmaiBUS.CompareDate(bd[0], bd[1], bd[2], day[0],day[1], day[2]))){
                        if(QuanlykhuyenmaiBUS.CompareDate(day[0], day[1], day[2], bd[0],bd[1], bd[2])){
                            trangthai = "Chưa diễn ra";
                        }
                        else{
                            trangthai = "Đã kết thúc";
                        }
                    }
                }
                GiaoDienGUI.tb.setValueRow(MaKM, new String[]{
                    Integer.toString(row), MaKM, TenKM, DieuKienKM, PhanTramKM, NgayBD, NgayKT, trangthai
                });
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnThemSuaActionPerformed

    private void txtDieuKienKMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDieuKienKMKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDieuKienKMKeyTyped

    private void txtPhanTramKMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhanTramKMKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPhanTramKMKeyTyped

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
//            java.util.logging.Logger.getLogger(FormThemSuaKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemSuaKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemSuaKhuyenMai("Thiện").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelDieuKienKM;
    private javax.swing.JLabel labelMaKM;
    private javax.swing.JLabel labelNagyKT;
    private javax.swing.JLabel labelNgayBD;
    private javax.swing.JLabel labelPhanTramKM;
    private javax.swing.JLabel labelTenKM;
    private javax.swing.JTextField txtDieuKienKM;
    private javax.swing.JTextField txtMaKM;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtPhanTramKM;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
