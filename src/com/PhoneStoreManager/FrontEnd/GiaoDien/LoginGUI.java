
package com.PhoneStoreManager.FrontEnd.GiaoDien;

import com.PhoneStoreManager.BackEnd.Duytridangnhap.Duytridangnhap;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.XulyTaiKhoanBUS;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.TaiKhoan;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginGUI extends javax.swing.JFrame {

    private boolean userfocus = false;
    private boolean passfocus = false;
    
    public static TaiKhoan currentUser;
    public static NhanVien currentNhanVien;
    public static Quyen currentQuyen;
    
    public Duytridangnhap user_duytri;
    
    public LoginGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        txtusername.setBackground(new Color(0,0,0,0));
        txtpass.setBackground(new Color(0,0,0,0));
        user_duytri = new Duytridangnhap();
        initduytridangnhap();
        ImageIcon logo = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/phone.png"));
        setIconImage(logo.getImage());
    }
    
    private void initduytridangnhap(){
        if(!user_duytri.getUsername().equals("")){
            XulyTaiKhoanBUS xltkBUS = new XulyTaiKhoanBUS();
            TaiKhoan tk = xltkBUS.getTaiKhoan(user_duytri.getUsername().trim());
            if(tk != null){
                QuanlynhanvienBUS qlnvBUS = new QuanlynhanvienBUS();
                NhanVien nv = qlnvBUS.getNhanVien(tk.getMaNV());
                if(nv != null){
                    currentUser = tk;
                    currentNhanVien = nv;
                    QuanlyquyenBUS qlquyenBUS = new QuanlyquyenBUS();
                    currentQuyen = qlquyenBUS.getQuyen(tk.getMaQuyen());
                    CheckBoxDuyTriDangNhap.setSelected(true);
                    txtusername.setText(tk.getTenTaiKhoan());
                    txtpass.setText(tk.getMatKhau());
                    userfocus = true;
                    passfocus = true;
                    return;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelclose = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelpass = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelusername1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtpass = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        CheckBoxDuyTriDangNhap = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/cancel11.png"))); // NOI18N
        labelclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelcloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelcloseMouseExited(evt);
            }
        });
        jPanel1.add(labelclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/minimize1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        labelpass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelpass.setText("Mật khẩu:");
        jPanel1.add(labelpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        txtusername.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        txtusername.setForeground(new java.awt.Color(102, 102, 102));
        txtusername.setText("Username");
        txtusername.setBorder(null);
        txtusername.setOpaque(false);
        txtusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusernameFocusGained(evt);
            }
        });
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 360, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 360, 10));

        labelusername1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelusername1.setText("Tên đăng nhập:");
        labelusername1.setToolTipText("");
        jPanel1.add(labelusername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 350, 10));

        txtpass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtpass.setForeground(new java.awt.Color(51, 51, 51));
        txtpass.setText("password");
        txtpass.setBorder(null);
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassFocusGained(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 360, 40));

        btnlogin.setBackground(new java.awt.Color(5, 11, 231));
        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Đăng nhập");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 180, 50));

        CheckBoxDuyTriDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxDuyTriDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(CheckBoxDuyTriDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Duy trì đăng nhập");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 320, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/login.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelcloseMouseClicked

    private void labelcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcloseMouseEntered
        labelclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/cancel12.png")));
    }//GEN-LAST:event_labelcloseMouseEntered

    private void labelcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelcloseMouseExited
        labelclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/cancel11.png")));
    }//GEN-LAST:event_labelcloseMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/minimize12.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/minimize1.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
    }//GEN-LAST:event_txtusernameActionPerformed

    private void CheckBoxDuyTriDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxDuyTriDangNhapActionPerformed
    }//GEN-LAST:event_CheckBoxDuyTriDangNhapActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        XulyTaiKhoanBUS xltkBUS = new XulyTaiKhoanBUS();
        TaiKhoan tk = xltkBUS.getTaiKhoan(txtusername.getText().trim(), txtpass.getText().trim());
        if(tk != null){
            if(CheckBoxDuyTriDangNhap.isSelected()){
                user_duytri.write(tk.getTenTaiKhoan());
            }
            QuanlynhanvienBUS qlnvBUS = new QuanlynhanvienBUS();
            NhanVien nv = qlnvBUS.getNhanVien(tk.getMaNV());
            if(nv != null){
                currentUser = tk;
                currentNhanVien = nv;
                QuanlyquyenBUS qlquyenBUS = new QuanlyquyenBUS();
                currentQuyen = qlquyenBUS.getQuyen(tk.getMaQuyen());
                new GiaoDienGUI().setVisible(true);
                this.dispose();
            }
        }else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu sai!");
        }
    }//GEN-LAST:event_btnloginActionPerformed

    private void txtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusGained
        if(!userfocus) txtusername.setText("");
        userfocus = true;
    }//GEN-LAST:event_txtusernameFocusGained

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
        if(!passfocus) txtpass.setText("");
        passfocus = true;
    }//GEN-LAST:event_txtpassFocusGained

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxDuyTriDangNhap;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelclose;
    private javax.swing.JLabel labelpass;
    private javax.swing.JLabel labelusername1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
