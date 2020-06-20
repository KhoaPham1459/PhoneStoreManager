
package com.PhoneStoreManager.FrontEnd.Panel;

import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import static com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI.tb;
import com.PhoneStoreManager.FrontEnd.GiaoDien.Table;
import com.PhoneStoreManager.FrontEnd.GiaoDien.myTableCellRenderer;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchFromTo extends JPanel{
    public JTextField txtFrom;
    public JTextField txtTo;
    public JButton btnTim;

    public SearchFromTo(String type, String Title) {
        init(Title);
        if(!type.equals("GIAODIEN")){
            setSize(350, 100);
//            setBackground(new Color(240,240,240));
            float xcom = (float) (getSize().width*0.05);
            float ycom = (float) (getSize().height*0.3);
            float wcom = (float) (getSize().width*0.35);
            float hcom = (float) (getSize().height*0.55);

            txtFrom.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
            xcom += txtFrom.getSize().width;
            txtTo.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
            xcom += txtTo.getSize().width;
            btnTim.setBounds((int) xcom, (int) (ycom*1.45), (int) (wcom*0.6), (int) (hcom*0.7));
        }
    }
    
    private void init(String Title){
        txtFrom = new JTextField();
        txtFrom.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    evt.consume();
                }
            }
        });
        txtTo = new JTextField();
        txtTo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    evt.consume();
                }
            }
        });
        btnTim = new JButton();
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0,0,0)), Title));
        txtFrom.setBorder(BorderFactory.createTitledBorder("Từ"));
        txtTo.setBorder(BorderFactory.createTitledBorder("Đến"));
        btnTim.setText("Tìm");
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        add(txtFrom);
        add(txtTo);
        add(btnTim);
    }
    
    public void setSizePanel(int x, int y){
        setBounds(x, y, 300, 100);
        
        float xcom = (float) (getSize().width*0.05);
        float ycom = (float) (getSize().height*0.3);
        float wcom = (float) (getSize().width*0.35);
        float hcom = (float) (getSize().height*0.55);
        
        txtFrom.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
        xcom += txtFrom.getSize().width;
        txtTo.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
        xcom += txtTo.getSize().width;
        btnTim.setBounds((int) xcom, (int) (ycom*1.45), (int) (wcom*0.6), (int) (hcom*0.7));
    }
    
    public void SearchTuoiNhanVien(){
        String ag1 = txtFrom.getText().trim();
        String ag2 = txtTo.getText().trim();
        String pa = "[\\d]{1,}";
        ArrayList<NhanVien> list;
        if(Pattern.matches(pa, ag1) && Pattern.matches(pa, ag2)){
            int age1 = Integer.parseInt(ag1);
            int age2 = Integer.parseInt(ag2);
            list = QuanlynhanvienBUS.SearchNVAge(age1, age2);
        }
        else{
            list = null;
        }

        String kq_timkiem = "----- Age From: " + ag1 + " To " + ag2 + " ------ ";
        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlynhanvienBUS.getHeaders);

        if(list == null){
            kq_timkiem += "Không tìm thấy";
        }
        else{
            int i = 0;
            for(NhanVien nv: list){
                ++i;
                GiaoDienGUI.tb.addRow(new String[]{Integer.toString(i), nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi()
                , nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
            }
            kq_timkiem += "Đã tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void SearchSoLuongSanPham(){
        String ag1 = txtFrom.getText().trim();
        String ag2 = txtTo.getText().trim();
        String pa = "[\\d]{1,}";
        ArrayList<SanPham> list;
        if(Pattern.matches(pa, ag1) && Pattern.matches(pa, ag2)){
            int age1 = Integer.parseInt(ag1);
            int age2 = Integer.parseInt(ag2);
            list = QuanlysanphamBUS.SearchSoLuongSP(age1, age2);
        }
        else{
            list = null;
        }

        String kq_timkiem = "----- SoLuongSP From: " + ag1 + " To " + ag2 + " ------ ";
        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlysanphamBUS.getHeaders);
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setMaxWidth(120);
        tb.jTable1.getColumn("Hình ảnh").setMinWidth(95);

        if(list == null){
            kq_timkiem += "Không tìm thấy";
        }
        else{
            int i = 0;
            for(SanPham q: list){
                ++i;
                ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + q.getHinhAnh()));
                Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imgScaled));
                tb.addRow(new Object[]{Integer.toString(i), q.getMaSP(), q.getMaLSP(), q.getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())),
                QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())), label, (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"
                });
            }
            kq_timkiem += "Đã tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(60);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void SearchDonGiaSanPham(){
        String ag1 = txtFrom.getText().trim();
        String ag2 = txtTo.getText().trim();
        String pa = "[\\d]{1,}";
        ArrayList<SanPham> list;
        if(Pattern.matches(pa, ag1) && Pattern.matches(pa, ag2)){
            long age1 = Long.parseLong(ag1);
            long age2 = Long.parseLong(ag2);
            list = QuanlysanphamBUS.SearchDonGiaSP(age1, age2);
        }
        else{
            list = null;
        }

        String kq_timkiem = "----- DonGiaSP From: " + ag1 + " To " + ag2 + " ------ ";
        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlysanphamBUS.getHeaders);
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setCellRenderer(new myTableCellRenderer());
        GiaoDienGUI.tb.jTable1.getColumn("Hình ảnh").setMaxWidth(120);
        tb.jTable1.getColumn("Hình ảnh").setMinWidth(95);
        
        if(list == null){
            kq_timkiem += "Không tìm thấy";
        }
        else{
            int i = 0;
            for(SanPham q: list){
                ++i;
                ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + q.getHinhAnh()));
                Image imgScaled = img.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imgScaled));
                tb.addRow(new Object[]{Integer.toString(i), q.getMaSP(), q.getMaLSP(), q.getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())),
                QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong())), label, (q.getTrangThai() == 1) ? "Hiện" : "Ẩn"
                });
            }
            kq_timkiem += "Đã tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(60);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void SearchTongTienHoaDon(){
        String ag1 = txtFrom.getText().trim();
        String ag2 = txtTo.getText().trim();
        String pa = "[\\d]{1,}";
        ArrayList<HoaDon> list;
        if(Pattern.matches(pa, ag1) && Pattern.matches(pa, ag2)){
            long age1 = Long.parseLong(ag1);
            long age2 = Long.parseLong(ag2);
            list = QuanlyhoadonBUS.SearchHoaDonTongTienFromTo(age1, age2);
        }
        else{
            list = null;
        }

        String kq_timkiem = "----- TongTien From: " + ag1 + " To " + ag2 + " ------ ";
        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlyhoadonBUS.getHeaders);
        
        if(list == null){
            kq_timkiem += "Không tìm thấy";
        }
        else{
            int i = 0;
            for(HoaDon q: list){
                ++i;
                tb.addRow(new Object[]{Integer.toString(i), q.getMaHD(), q.getMaNV(), q.getMaKH(), q.getMaKM(), q.getNgayLap(), q.getGioLap(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))
                });
            }
            kq_timkiem += "Đã tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
}
