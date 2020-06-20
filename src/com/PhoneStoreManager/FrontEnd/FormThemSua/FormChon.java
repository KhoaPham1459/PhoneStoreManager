
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.Quanlychitiethoadon.ChiTietHoaDon;
import com.PhoneStoreManager.BackEnd.Quanlychitiethoadon.QuanlychitiethoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.PhieuNhap;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.QuanlyphieunhapBUS;
import com.PhoneStoreManager.BackEnd.QuanLyChiTietPN.ChiTietPhieuNhap;
import com.PhoneStoreManager.BackEnd.QuanLyChiTietPN.QuanLyChiTietPhieuNhapBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.FrontEnd.Panel.SearchFromTo;
import com.PhoneStoreManager.FrontEnd.Panel.DateSearch;
import com.PhoneStoreManager.FrontEnd.Panel.SearchPanel;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class FormChon extends JFrame{
    private JButton btnLamMoi;
    private JButton btnChon;
    private JPanel pnmain;
    private JPanel pnSouth;
    private JPanel pnNorth;
    private JTable tb;
    private SearchPanel pnSearch;
    private DateSearch pnDateSearch;
    private SearchFromTo pnAgeSearch;
    private SearchFromTo pnSoLuongSearch;
    private SearchFromTo pnThanhTienSearch;
    private DefaultTableModel model;
    private JScrollPane JS;
    private Object[] s = null;

    public FormChon(String type) {
        setIconImage((new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))).getImage());
        Font font = new Font("Tahoma", 1, 12);
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setFont(font);
        btnChon = new JButton("Chọn");
        btnChon.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/correct.png")));
        btnChon.setFont(font);
        pnSouth = new JPanel();
        pnSouth.add(btnChon, BorderLayout.CENTER);
        pnSouth.add(btnLamMoi, BorderLayout.CENTER);
        pnSouth.setBackground(Color.white);
        switch(type){
            case "ChonNhanVien":{
                initChonNhanVien();
                break;
            }
            case "ChonMaQuyen":{
                initChonMaQuyen();
                break;
            }
            case "ChonMaLoaiSanPham":{
                initChonLoaiSanPham();
                break;
            }

            default: break;
        }
        
        sort();
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    int colum = tb.getSelectedColumn();
                    if(colum >= 0){
                        if(s == null){
                            s = new Object[]{tb.getValueAt(row, colum), Integer.toString(row), Integer.toString(colum)};
                        }
                        else{
                            tb.setValueAt(s[0], Integer.parseInt(s[1].toString()), Integer.parseInt(s[2].toString()));
                            s = null;
                        }
                    }
                }
            }
        });
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public FormChon(HoaDon hd) {
        setIconImage((new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/view.png"))).getImage());
        setTitle("Chi tiết hóa đơn " + hd.getMaHD());
        setSize(1100, 500);
        Font font = new Font("Tahoma", 1, 12);
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setFont(font);
        pnSouth = new JPanel();
        pnSouth.add(btnLamMoi, BorderLayout.CENTER);
        pnSouth.setBackground(Color.white);
        
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        String[] header = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"};
        model.setColumnIdentifiers(header);
        tb.setRowHeight(35);
        JS = new JScrollPane(tb);
        
        ArrayList<ChiTietHoaDon> list = QuanlychitiethoadonBUS.getChiTietHoaDon(hd.getMaHD());
        int i = 0;
        for(ChiTietHoaDon q: list){
            ++i;
            model.addRow(new Object[]{
                Integer.toString(i), q.getMaSP(), QuanlysanphamBUS.getSanPham(q.getMaSP()).getTenSP(), QuanlykhuyenmaiBUS.ToCurrent(Integer.toString(q.getSoLuong()))
                    , QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia())), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getDonGia()*q.getSoLuong()))
            });
        }
        
        sort();
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    int colum = tb.getSelectedColumn();
                    if(colum >= 0){
                        if(s == null){
                            s = new Object[]{tb.getValueAt(row, colum), Integer.toString(row), Integer.toString(colum)};
                        }
                        else{
                            tb.setValueAt(s[0], Integer.parseInt(s[1].toString()), Integer.parseInt(s[2].toString()));
                            s = null;
                        }
                    }
                }
            }
        });
        
        pnSearch = new SearchPanel("CHON");
        pnSearch.setPreferredSize(new Dimension(pnSearch.getSize().width, pnSearch.getSize().height));
        pnSearch.setComboBox(QuanlychitiethoadonBUS.getHeaders);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        pnSoLuongSearch = new SearchFromTo("CHỌN", "Số lượng");
        pnSoLuongSearch.setPreferredSize(new Dimension(pnSoLuongSearch.getSize().width, pnSoLuongSearch.getSize().height));
        pnSoLuongSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        pnThanhTienSearch = new SearchFromTo("CHỌN", "Thành tiền");
        pnThanhTienSearch.setPreferredSize(new Dimension(pnThanhTienSearch.getSize().width, pnThanhTienSearch.getSize().height));
        pnThanhTienSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        pnNorth = new JPanel();
        pnNorth.add(pnSearch, BorderLayout.CENTER);
        pnNorth.add(pnSoLuongSearch, BorderLayout.CENTER);
        pnNorth.add(pnThanhTienSearch, BorderLayout.CENTER);
        pnNorth.setBackground(Color.white);
        
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public FormChon(PhieuNhap pn) {
        setIconImage((new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/view.png"))).getImage());
        setTitle("Chi tiết phiếu nhập " + pn.getMaPN());
        setSize(1100, 500);
        Font font = new Font("Tahoma", 1, 12);
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setFont(font);
        pnSouth = new JPanel();
        pnSouth.add(btnLamMoi, BorderLayout.CENTER);
        pnSouth.setBackground(Color.white);
        
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        String[] header = {"STT", "Mã phiếu nhập", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"};
        model.setColumnIdentifiers(header);
        tb.setRowHeight(35);
        JS = new JScrollPane(tb);
        
        ArrayList<ChiTietPhieuNhap> list = QuanLyChiTietPhieuNhapBUS.getChiTietPhieuNhap(pn.getMaPN());
        int i = 0;
        for(ChiTietPhieuNhap t: list){
            ++i;
            model.addRow(new Object[]{
                Integer.toString(i), t.getMaPN(), t.getMaSP(), QuanlysanphamBUS.getSanPham(t.getMaSP()).getTenSP(), Integer.toString(t.getSoLuong()), Long.toString(t.getDonGia()), Long.toString(t.getDonGia()*t.getSoLuong())
            });
        }
        
        sort();
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tb.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    int colum = tb.getSelectedColumn();
                    if(colum >= 0){
                        if(s == null){
                            s = new Object[]{tb.getValueAt(row, colum), Integer.toString(row), Integer.toString(colum)};
                        }
                        else{
                            tb.setValueAt(s[0], Integer.parseInt(s[1].toString()), Integer.parseInt(s[2].toString()));
                            s = null;
                        }
                    }
                }
            }
        });
        
        pnSearch = new SearchPanel("CHON");
        pnSearch.setPreferredSize(new Dimension(pnSearch.getSize().width, pnSearch.getSize().height));
        pnSearch.setComboBox(QuanLyChiTietPhieuNhapBUS.getHeaders);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        pnSoLuongSearch = new SearchFromTo("CHỌN", "Số lượng");
        pnSoLuongSearch.setPreferredSize(new Dimension(pnSoLuongSearch.getSize().width, pnSoLuongSearch.getSize().height));
        pnSoLuongSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        pnThanhTienSearch = new SearchFromTo("CHỌN", "Thành tiền");
        pnThanhTienSearch.setPreferredSize(new Dimension(pnThanhTienSearch.getSize().width, pnThanhTienSearch.getSize().height));
        pnThanhTienSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        pnNorth = new JPanel();
        pnNorth.add(pnSearch, BorderLayout.CENTER);
        pnNorth.add(pnSoLuongSearch, BorderLayout.CENTER);
        pnNorth.add(pnThanhTienSearch, BorderLayout.CENTER);
        pnNorth.setBackground(Color.white);
        
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    private void initChonNhanVien(){
        setTitle("Chọn nhân viên");
        setSize(1200, 600);
        
        TaoLaiTableNhanVien();
        
        ArrayList<NhanVien> list = QuanlynhanvienBUS.getDSNV();
        int i = 0;
        for(NhanVien nv: list){
            ++i;
            model.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
        }
        resizeColumnWidth();
        
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(JS);
                repaint();
                TaoLaiTableNhanVien();

                ArrayList<NhanVien> list = QuanlynhanvienBUS.getDSNV();
                int i = 0;
                for(NhanVien nv: list){
                    ++i;
                    model.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
                }
                tb.setFont(new Font("Segoe UI", 0, 16));
                tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
                resizeColumnWidth();
                sort();
                add(JS, BorderLayout.CENTER);
                validate();
            }
        });
        
        btnChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    FormThemSuaTaiKhoan.txtMaNV.setText(LayMaNhanVienTrenTable(row));
                    dispose();
                }
            }
        });
        
        pnNorth = new JPanel();
        pnAgeSearch = new SearchFromTo("CHON", "Tuổi");
        pnAgeSearch.setPreferredSize(new Dimension(pnAgeSearch.getSize().width, pnAgeSearch.getSize().height));
        pnAgeSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnSearch.txtSearch.setText("");
                String age1 = pnAgeSearch.txtFrom.getText().trim();
                String age2 = pnAgeSearch.txtTo.getText().trim();
                ArrayList<NhanVien> list;
                if(Pattern.matches("[\\d]{1,}", age1) && Pattern.matches("[\\d]{1,}", age2)){
                    list = QuanlynhanvienBUS.SearchNVAge(Integer.parseInt(age1), Integer.parseInt(age2));
                }
                else{
                    list = null;
                }
                remove(JS);
                repaint();
                TaoLaiTableNhanVien();
                if(list != null){
                    int i = 0;
                    for(NhanVien nv: list){
                        ++i;
                        model.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
                    }
                }
                tb.setFont(new Font("Segoe UI", 0, 16));
                tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
                resizeColumnWidth();
                sort();
                add(JS, BorderLayout.CENTER);
                validate();
            }
        });
        
        pnSearch = new SearchPanel("CHON");
        pnSearch.setPreferredSize(new Dimension(pnSearch.getSize().width, pnSearch.getSize().height));
        pnSearch.setComboBox(QuanlynhanvienBUS.getComboboxSearch);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e){
                SearchNhanVien();
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchNhanVien();
                pnDateSearch.dateFrom.setDate(null);
                pnDateSearch.dateTo.setDate(null);
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
            }
        });
        
        pnDateSearch = new DateSearch("CHON");
        pnDateSearch.setPreferredSize(new Dimension(pnDateSearch.getSize().width, pnDateSearch.getSize().height));
        pnDateSearch.btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnAgeSearch.txtFrom.setText("");
                pnAgeSearch.txtTo.setText("");
                pnSearch.txtSearch.setText("");
                String DateFrom = "";
                String DateTo = "";

                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
                if(pnDateSearch.dateFrom.getDate() != null){
                    DateFrom = sdf.format(pnDateSearch.dateFrom.getDate());
                }
                if(pnDateSearch.dateTo.getDate() != null){
                    DateTo = sdf.format(pnDateSearch.dateTo.getDate());
                }
                ArrayList<NhanVien> list;
                if(DateFrom.equals("") || DateTo.equals("")){
                    list = QuanlynhanvienBUS.SearchNVFromDate(-1, -1, -1, -1, -1, -1);
                }
                else{
                    String[] s1 = DateFrom.split("-");
                    String[] s2 = DateTo.split("-");
                    list = QuanlynhanvienBUS.SearchNVFromDate(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]),
                            Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
                }
                
                remove(JS);
                repaint();
                TaoLaiTableNhanVien();
                if(list != null){
                    int i = 0;
                    for(NhanVien nv: list){
                        ++i;
                        model.addRow(new String[]{Integer.toString(i) ,nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
                    }
                }
                tb.setFont(new Font("Segoe UI", 0, 16));
                tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
                resizeColumnWidth();
                sort();
                add(JS, BorderLayout.CENTER);
                validate();
            }
        });
        resizeColumnWidth();
        pnNorth.add(pnSearch, BorderLayout.CENTER);
        pnNorth.add(pnDateSearch, BorderLayout.CENTER);
        pnNorth.add(pnAgeSearch, BorderLayout.CENTER);
        pnNorth.setBorder(BorderFactory.createLineBorder(Color.black));
        pnNorth.setBackground(Color.white);
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
    }
    
    
    
    private void initChonMaQuyen(){
        setTitle("Chọn mã quyền");
        setSize(700, 500);
        TaoLaiTableMaQuyen();
        
        ArrayList<Quyen> list = QuanlyquyenBUS.getDSQuyen();
        int i = 0;
        for(Quyen q: list){
            ++i;
            model.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
        }
        resizeColumnWidth();
        
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(JS);
                repaint();
                TaoLaiTableMaQuyen();

                ArrayList<Quyen> list = QuanlyquyenBUS.getDSQuyen();
                int i = 0;
                for(Quyen q: list){
                    ++i;
                    model.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
                }
                resizeColumnWidth();
                sort();
                tb.setFont(new Font("Segoe UI", 0, 16));
                tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
                add(JS, BorderLayout.CENTER);
                validate();
            }
        });
        
        btnChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    FormThemSuaTaiKhoan.txtMaQuyen.setText(LayMaQuyenTrenTable(row));
                    dispose();
                }
            }
        });
        
        pnSearch = new SearchPanel("CHON");
        pnSearch.setPreferredSize(new Dimension(pnSearch.getSize().width, pnSearch.getSize().height));
        pnSearch.setComboBox(QuanlyquyenBUS.getComboboxSearch);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                SearchQuyen();
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchQuyen();
            }
        });
        
        pnNorth = new JPanel();
        pnNorth.add(pnSearch, BorderLayout.CENTER);
        pnNorth.setBorder(BorderFactory.createLineBorder(Color.black));
        pnNorth.setBackground(Color.white);
        
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
    }
    
    private void initChonLoaiSanPham(){
        setTitle("Chọn loại sản phẩm");
        setSize(700, 500);
        TaoLaiTableLoaiSanPham();
        
        ArrayList<LoaiSanPham> list = QuanlyloaisanphamBUS.getDSLSP();
        int i = 0;
        for(LoaiSanPham q: list){
            ++i;
            model.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
        }
        resizeColumnWidth();
        
        btnLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(JS);
                repaint();
                TaoLaiTableLoaiSanPham();

                ArrayList<LoaiSanPham> list = QuanlyloaisanphamBUS.getDSLSP();
                int i = 0;
                for(LoaiSanPham q: list){
                    ++i;
                    model.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
                }
                resizeColumnWidth();
                sort();
                tb.setFont(new Font("Segoe UI", 0, 16));
                tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
                add(JS, BorderLayout.CENTER);
                validate();
            }
        });
        
        btnChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tb.getSelectedRow();
                if(row >= 0){
                    FormThemSuaSanPham.txtMaLSP.setText(LayMaLSPTrenTable(row));
                    dispose();
                }
            }
        });
        
        pnSearch = new SearchPanel("CHON");
        pnSearch.setPreferredSize(new Dimension(pnSearch.getSize().width, pnSearch.getSize().height));
        pnSearch.setComboBox(QuanlyloaisanphamBUS.getComboboxSearch);
        pnSearch.txtSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent e){
                SearchLSP();
            }
        });
        pnSearch.ComboBoxSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchLSP();
            }
        });
        
        pnNorth = new JPanel();
        pnNorth.add(pnSearch, BorderLayout.CENTER);
        pnNorth.setBorder(BorderFactory.createLineBorder(Color.black));
        pnNorth.setBackground(Color.white);
        
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
    }
    
    private void sort(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tb.setRowSorter(sorter);
    }
    
    private void SearchNhanVien(){
        String type = pnSearch.ComboBoxSearch.getSelectedItem().toString().trim();
        String s = pnSearch.txtSearch.getText().trim();
        ArrayList<NhanVien> list = QuanlynhanvienBUS.SearchNhanVien(s, type);
        remove(JS);
        repaint();
        TaoLaiTableNhanVien();
        if(list != null){
            int i = 0;
            for(NhanVien nv: list){
                ++i;
                model.addRow(new String[]{Integer.toString(i), nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getDiaChi()
        , nv.getSDT(), (nv.getTrangThai() == 1) ? "Còn làm" : "Hết làm"});
            }
        }
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        resizeColumnWidth();
        sort();
        add(JS, BorderLayout.CENTER);
        validate();
    }
    
    private void SearchQuyen(){
        String type = pnSearch.ComboBoxSearch.getSelectedItem().toString().trim();
        String s = pnSearch.txtSearch.getText().trim();
        ArrayList<Quyen> list = QuanlyquyenBUS.SearchQuyen(s, type);
        remove(JS);
        repaint();
        TaoLaiTableMaQuyen();
        if(list != null){
            int i = 0;
            for(Quyen q: list){
                ++i;
                model.addRow(new String[]{Integer.toString(i), q.getMaQuyen(), q.getTenQuyen(), q.getChiTietQuyen()});
            }
        }
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        resizeColumnWidth();
        sort();
        add(JS, BorderLayout.CENTER);
        validate();
    }
    
    private void SearchLSP(){
        String type = pnSearch.ComboBoxSearch.getSelectedItem().toString().trim();
        String s = pnSearch.txtSearch.getText().trim();
        ArrayList<LoaiSanPham> list = QuanlyloaisanphamBUS.SearchLSP(s, type);
        remove(JS);
        repaint();
        TaoLaiTableLoaiSanPham();
        if(list != null){
            int i = 0;
            for(LoaiSanPham q: list){
                ++i;
                model.addRow(new String[]{Integer.toString(i), q.getMaLSP(), q.getTenLSP(), q.getMota()});
            }
        }
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        resizeColumnWidth();
        sort();
        add(JS, BorderLayout.CENTER);
        validate();
    }
    
    private void TaoLaiTableNhanVien(){
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        tb.setRowHeight(35);
        model.setColumnIdentifiers(QuanlynhanvienBUS.getHeaders);
        JS = new JScrollPane(tb);
    }
     private void TaoLaiTablePhieuNhap(){
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        tb.setRowHeight(35);
        model.setColumnIdentifiers(QuanlyphieunhapBUS.getHeaders);
        JS = new JScrollPane(tb);
    }
    
    private void TaoLaiTableMaQuyen(){
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        model.setColumnIdentifiers(QuanlyquyenBUS.getHeaders);
        tb.setRowHeight(35);
        JS = new JScrollPane(tb);
    }
    
//    private void TaoLaiTableNhaCungCap(){
//        tb = new JTable();
//        model = (DefaultTableModel) tb.getModel();
//        model.setColumnIdentifiers(QuanlyNCCBUS.getHeaders);
//        tb.setRowHeight(35);
//        JS = new JScrollPane(tb);
//    }
    
    private void TaoLaiTableLoaiSanPham(){
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        model.setColumnIdentifiers(QuanlyloaisanphamBUS.getHeaders);
        tb.setRowHeight(35);
        JS = new JScrollPane(tb);
    }
    
    private void TaoLaiTableChiTietHoaDon(){
        tb = new JTable();
        model = (DefaultTableModel) tb.getModel();
        model.setColumnIdentifiers(QuanlychitiethoadonBUS.getHeaders);
        tb.setRowHeight(35);
        JS = new JScrollPane(tb);
    }
    
    private String LayMaNhanVienTrenTable(int row){
        for(int i = 0; i < tb.getColumnCount(); ++i){
            if(tb.getColumnName(i).equals("Mã nhân viên")){
                return tb.getValueAt(row, i).toString();
            }
        }
        return null;
    }
        private String LayMaPhieuNhapTrenTable(int row){
        for(int i = 0; i < tb.getColumnCount(); ++i){
            if(tb.getColumnName(i).equals("Mã phiếu nhập")){
                return tb.getValueAt(row, i).toString();
            }
        }
        return null;
    }
    
    private String LayMaQuyenTrenTable(int row){
        for(int i = 0; i < tb.getColumnCount(); ++i){
            if(tb.getColumnName(i).equals("Mã quyền")){
                return tb.getValueAt(row, i).toString();
            }
        }
        return null;
    }
    
    private String LayMaLSPTrenTable(int row){
        for(int i = 0; i < tb.getColumnCount(); ++i){
            if(tb.getColumnName(i).equals("Mã loại")){
                return tb.getValueAt(row, i).toString();
            }
        }
        return null;
    }
    
//    https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
    public void resizeColumnWidth() {
        final TableColumnModel columnModel = tb.getColumnModel();
        for (int column = 0; column < tb.getColumnCount(); column++) {
            int width = 100; // Min width
            for (int row = 0; row < tb.getRowCount(); row++) {
                TableCellRenderer renderer = tb.getCellRenderer(row, column);
                Component comp = tb.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            width += 100;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
//        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
//    
//    public static void main(String[] args){
//        new FormChon("ChonMaQuyen").setVisible(true);
//    }
}
