/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.BackEnd.PriceFormatter;
import com.PhoneStoreManager.BackEnd.Quanlychitiethoadon.ChiTietHoaDon;
import com.PhoneStoreManager.BackEnd.Quanlychitiethoadon.QuanlychitiethoadonBUS;
import com.PhoneStoreManager.BackEnd.QuanLyChiTietPN.ChiTietPhieuNhap;
import com.PhoneStoreManager.BackEnd.QuanLyChiTietPN.QuanLyChiTietPhieuNhapBUS;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.KhachHang;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.QuanlykhachhangBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.KhuyenMai;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.PhieuNhap;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.QuanlyphieunhapBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.LoginGUI;
import com.PhoneStoreManager.FrontEnd.GiaoDien.Table;
import com.PhoneStoreManager.FrontEnd.MyButton.MoreButton;
import com.PhoneStoreManager.FrontEnd.MyButton.RefreshButton;
import com.PhoneStoreManager.FrontEnd.MyButton.SuaButton;
import com.PhoneStoreManager.FrontEnd.MyButton.ThemButton;
import com.PhoneStoreManager.FrontEnd.MyButton.XoaButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author DELL
 */
public class FormHang extends JPanel {
    
    ChonSanPhamPanel target;

    public FormHang() {

    }

    public void addChiTiet(String MaSP, int SoLuong) {

    }
    
    public void setTarget(ChonSanPhamPanel target) {
        this.target = target;
    }
    
}

class PhieuNhapHang extends FormHang {

    QuanLyChiTietPhieuNhapBUS qlctpn = new QuanLyChiTietPhieuNhapBUS();
    QuanlyphieunhapBUS qlpnBUS = new QuanlyphieunhapBUS();
    QuanlysanphamBUS qlspBUS = new QuanlysanphamBUS();
    QuanlyNCCBUS qlnccBUS = new QuanlyNCCBUS();
    QuanlynhanvienBUS qlnvBUS = new QuanlynhanvienBUS();

    NhanVien nhanVien;
    NCC NCC;

    JTextField txMaPhieuNhap = new JTextField(20);
    JTextField txNhanVien = new JTextField(17);
    JTextField txNhaCC = new JTextField(17);
    JTextField txNgayLap = new JTextField(20);
    JTextField txGioLap = new JTextField(20);
    JTextField txTongTien = new JTextField(20);

    JComboBox<String> btnChonNhanVien =new JComboBox<>();
    JComboBox<String>  btnChonNhaCC = new JComboBox<>();

    Table tbChiTietPhieuNhap = new Table();
    XoaButton btnXoa = new XoaButton();
    SuaButton btnSua = new SuaButton();
    RefreshButton btnRefresh = new RefreshButton();

    JButton btnNhapHang = new JButton("Nhập hàng");
    JButton btnHuy = new JButton("Hủy");

    ArrayList<ChiTietPhieuNhap> dsctpn = new ArrayList<>();

    public PhieuNhapHang(int _x, int _y, int _width, int _height) {
        this.setBounds(_x, _y, _width, _height);
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(new FlowLayout());

        // =============== panel input =================
        int plIP_height = _height/2;
        JPanel plInput = new JPanel();
        plInput.setPreferredSize(new Dimension(_width - 10, plIP_height));
        plInput.setBackground(new Color(240, 240, 240));
        plInput.setLayout(new FlowLayout());

        // btn
        btnChonNhaCC = new JComboBox<>();
        QuanlyNCCBUS.getDSNCC().forEach((t) -> {
                btnChonNhaCC.addItem(t.getMaNCC());
            });
        btnChonNhaCC.setPreferredSize(new Dimension(30, 30));
        btnChonNhaCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txNhaCC.setText(btnChonNhaCC.getSelectedItem().toString());
            }
        });
        

        btnChonNhanVien.setPreferredSize(new Dimension(30, 30));
        QuanlynhanvienBUS.getDSNV().forEach((t) -> {
                btnChonNhanVien.addItem(t.getMaNV());
            });
        
        btnChonNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txNhanVien.setText(btnChonNhanVien.getSelectedItem().toString());
            }
        });
//        btnChonNhanVien.setEnabled(false);

        // set border
        txMaPhieuNhap.setBorder(BorderFactory.createTitledBorder("Mã phiếu nhập:"));
        txNhanVien.setBorder(BorderFactory.createTitledBorder("Nhân viên:"));
        txNgayLap.setBorder(BorderFactory.createTitledBorder("Ngày lập:"));
        txGioLap.setBorder(BorderFactory.createTitledBorder("Giờ lập:"));
        txNhaCC.setBorder(BorderFactory.createTitledBorder("Nhà cung cấp:"));
        txTongTien.setBorder(BorderFactory.createTitledBorder("Tổng tiền (triệu vnd):"));

        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txMaPhieuNhap.setFont(f);
        txNhanVien.setFont(f);
        txNgayLap.setFont(f);
        txGioLap.setFont(f);
        txNhaCC.setFont(f);
        txMaPhieuNhap.setFont(f);
        txTongTien.setFont(f);

        // set Text
//        if (LoginForm.nhanVienLogin != null) {
//            nhanVien = LoginForm.nhanVienLogin;
//            txNhanVien.setText(nhanVien.getTenNV() + " (" + nhanVien.getMaNV() + ")");
//        }

//        txMaPhieuNhap.setText(qlpnBUS.get());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                txNgayLap.setText(LocalDate.now().toString());
                txGioLap.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                if (txNhanVien.getText().equals("")
                        || txNhaCC.getText().equals("")
                        || txTongTien.getText().equals("")
                        || txTongTien.getText().equals("0")) {
                    btnNhapHang.setEnabled(false);
                } else {
                    btnNhapHang.setEnabled(true);
                }
            }
        }, 0, 1000);

        // set editable
        txMaPhieuNhap.setEditable(false);
        txNhanVien.setEditable(false);
        txNhaCC.setEditable(false);
        txNgayLap.setEditable(false);
        txGioLap.setEditable(false);
        txTongTien.setEditable(false);

        // add to panel
        plInput.add(txMaPhieuNhap);
        plInput.add(txTongTien);
        plInput.add(txNhaCC);
        plInput.add(btnChonNhaCC);
        plInput.add(txNhanVien);
        plInput.add(btnChonNhanVien);
        plInput.add(txNgayLap);
        plInput.add(txGioLap);

        this.add(plInput);

        // =============== panel các sản phẩm đã chọn ==================
        int plSP_height = _height/2;
        JPanel plSanPham = new JPanel();
        plSanPham.setPreferredSize(new Dimension(_width - 10, plSP_height));
        plSanPham.setBackground(new Color(250, 250, 29));
        plSanPham.setLayout(new BorderLayout());

        int plBtn_height = 50;
        JPanel plButtonChiTiet = new JPanel();
        plButtonChiTiet.setLayout(new FlowLayout(FlowLayout.CENTER));
        plButtonChiTiet.setBackground(new Color(220, 220, 220));
        plButtonChiTiet.setPreferredSize(new Dimension(_width - 10, plBtn_height));

        btnXoa.addActionListener((ae) -> {
            btnXoaOnClick();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaOnClick();
        });
        btnRefresh.addActionListener((ae) -> {
            setDataToTable(dsctpn, tbChiTietPhieuNhap);
        });

        plButtonChiTiet.add(btnXoa);
        plButtonChiTiet.add(btnSua);
        plButtonChiTiet.add(btnRefresh);

        tbChiTietPhieuNhap.setPreferredSize(new Dimension(_width - 10, plSP_height - plBtn_height));
        tbChiTietPhieuNhap.setHeaders(new String[]{"STT", "Mã", "Tên", "Số lượng", "Đơn giá", "Thành tiền"});
//        tbChiTietPhieuNhap.setColumnsWidth(new double[]{1, 2, 3, 2.2, 2.5, 3});
//        tbChiTietPhieuNhap.setAlignment(0, JLabel.CENTER);
//        tbChiTietPhieuNhap.setAlignment(1, JLabel.CENTER);
//        tbChiTietPhieuNhap.setAlignment(3, JLabel.CENTER);
//        tbChiTietPhieuNhap.setAlignment(4, JLabel.RIGHT);
//        tbChiTietPhieuNhap.setAlignment(5, JLabel.RIGHT);

        plSanPham.add(tbChiTietPhieuNhap, BorderLayout.CENTER);
        plSanPham.add(plButtonChiTiet, BorderLayout.SOUTH);

        this.add(plSanPham);

        // ============= panel Thanh toán ==============
        int plTT_height = _height - plIP_height - plSP_height - 20;
        JPanel plThanhToan = new JPanel();
        plThanhToan.setLayout(new FlowLayout(FlowLayout.RIGHT));
        plThanhToan.setPreferredSize(new Dimension(_width - 10, plTT_height));
        plThanhToan.setBackground(new Color(0, 0, 0));

        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_cancel_30px_1.png")));
        btnNhapHang.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_us_dollar_30px.png")));

        btnHuy.addActionListener((ae) -> {
            btnHuyOnClick();
        });
        btnNhapHang.addActionListener((ae) -> {
            btnNhapHangOnClick();
        });

        plThanhToan.add(btnHuy);
        plThanhToan.add(btnNhapHang);

        this.add(plThanhToan);
    }

    private void btnHuyOnClick() {
        clear();
    }

    private void btnNhapHangOnClick() {
        PhieuNhap pn = new PhieuNhap(
                txMaPhieuNhap.getText(),
                NCC.getMaNCC(),
                nhanVien.getMaNV(),
                LocalDate.parse(txNgayLap.getText()),
                LocalTime.parse(txGioLap.getText()),
                Long.parseLong(txTongTien.getText()));
        qlpnBUS.addPhieuNhap(pn);

        for (ChiTietPhieuNhap ct : dsctpn) {
            qlctpn.addChiTietPhieuNhap(ct);
        }
        
//        int reply = JOptionPane.showConfirmDialog(getRootPane(),
//                        "Nhập hàng thành công, bạn có muốn IN PHIẾU NHẬP?", "Thành công",
//                        JOptionPane.YES_NO_OPTION);
//        if(reply == JOptionPane.OK_OPTION) {
//            new WritePDF().writePhieuNhap(txMaPhieuNhap.getText());
//        }
        txMaPhieuNhap.setText(qlpnBUS.MaPNnotHave()); // lấy mã cho phiếu nhập mới
        clear();
        this.target.refreshAll();
    }

    private void btnXoaOnClick() {
        int i = tbChiTietPhieuNhap.getTable().getSelectedRow();
        if (i >= 0 && i < dsctpn.size()) {
            dsctpn.remove(i);
            setDataToTable(dsctpn, tbChiTietPhieuNhap);
        }
    }

    private void btnSuaOnClick() {
        int i = tbChiTietPhieuNhap.getTable().getSelectedRow();
        if (i >= 0 && i < dsctpn.size()) {
            ChiTietPhieuNhap ct = dsctpn.get(i);
            this.target.showInfo(ct.getMaSP(), ct.getSoLuong());

            dsctpn.remove(i);
            setDataToTable(dsctpn, tbChiTietPhieuNhap);
        }
    }

    public void clear() {
        txNhaCC.setText("");
        txTongTien.setText("");
        dsctpn.clear();
        setDataToTable(dsctpn, tbChiTietPhieuNhap);
    }

    @Override
    public void addChiTiet(String masp, int soluong) {
        SanPham sp = qlspBUS.getSanPham(masp);

        Boolean daCo = false; // check xem trong danh sách chi tiết hóa đơn đã có sản phẩm này chưa
        for (ChiTietPhieuNhap ctpn : dsctpn) {
            if (ctpn.getMaSP().equals(sp.getMaSP())) {
                int tongSoLuong = soluong + ctpn.getSoLuong();
                ctpn.setSoLuong(tongSoLuong); // có rồi thì thay đổi số lượng
                daCo = true;
            }
        }

        if (!daCo) { // nếu chưa có thì thêm mới
            ChiTietPhieuNhap ctpn = new ChiTietPhieuNhap(qlpnBUS.MaPNnotHave(), masp, soluong, sp.getDonGia());
            dsctpn.add(ctpn);
        }

        // cập nhật lại table
        setDataToTable(dsctpn, tbChiTietPhieuNhap);
    }

    public void setDataToTable(ArrayList<ChiTietPhieuNhap> arr, Table t) {
        t.clear();
        float tongtien = 0;
        int stt = 1;
        for (ChiTietPhieuNhap ctpn : arr) {
            String masp = ctpn.getMaSP();
            SanPham sp = qlspBUS.getSanPham(masp);
            String tensp = sp.getTenSP();
            int soluong = ctpn.getSoLuong();
            float dongia = ctpn.getDonGia();
            float thanhtien = soluong * dongia;

            t.addRow(new String[]{
                String.valueOf(stt),
                masp,
                tensp,
                String.valueOf(soluong),
                PriceFormatter.format(dongia),
                PriceFormatter.format(thanhtien)
            });
            stt++;
            tongtien += thanhtien;
        }

        // check khuyến mãi
        t.addRow(new String[]{"", "", "", "", "", ""});
        t.addRow(new String[]{"", "", "", "", "Tổng tiền", PriceFormatter.format(tongtien)});
        txTongTien.setText(String.valueOf(tongtien));
    }
    
}

class HoaDonBanHang extends FormHang {

    QuanlysanphamBUS qlspBUS = new QuanlysanphamBUS();
    QuanlykhachhangBUS qlkhBUS = new QuanlykhachhangBUS();
    QuanlynhanvienBUS qlnvBUS = new QuanlynhanvienBUS();
    QuanlykhuyenmaiBUS qlkmBUS = new QuanlykhuyenmaiBUS();
    QuanlyhoadonBUS qlhdBUS = new QuanlyhoadonBUS();
    QuanlychitiethoadonBUS qlcthd = new QuanlychitiethoadonBUS();

    NhanVien nhanVien;
    KhachHang khachHang;
    KhuyenMai khuyenMai;
    long tongThanhToan;

    JTextField txMaHoaDon = new JTextField(20);
    JTextField txNhanVien = new JTextField(17);
    JTextField txNgayLap = new JTextField(9);
    JTextField txGioLap = new JTextField(9);
    JTextField txKhachHang = new JTextField(17);
    JTextField txTongTien = new JTextField(20);
    JTextField txKhuyenMai = new JTextField(17);

    JComboBox<String> btnChonNhanVien = new JComboBox();
    JComboBox<String> btnChonKhachHang = new JComboBox();
    JComboBox<String> btnChonKhuyenMai = new JComboBox();

    Table tbChiTietHoaDon = new Table();
    XoaButton btnXoa = new XoaButton();
    SuaButton btnSua = new SuaButton();
    RefreshButton btnRefresh = new RefreshButton();

    JButton btnThanhToan = new JButton("Thanh toán");
    JButton btnHuy = new JButton("Hủy");

    ArrayList<ChiTietHoaDon> dscthd = new ArrayList<>();

    public HoaDonBanHang(int _x, int _y, int _width, int _height) {
        tongThanhToan = 0;
        this.setBounds(_x, _y, _width, _height);
        this.setBackground(new Color(0, 0, 0));
        this.setLayout(new FlowLayout());

        // =============== panel input =================
        int plIP_height = _height/3 + 2*_height/9;
        JPanel plInput = new JPanel();
        plInput.setPreferredSize(new Dimension(_width - 10, plIP_height));
        plInput.setBackground(new Color(240, 240, 240));
        plInput.setLayout(new FlowLayout());

        // btn
        btnChonKhachHang.setPreferredSize(new Dimension(30, 30));
        QuanlykhachhangBUS.getDSKH().forEach((t) -> {
                btnChonKhachHang.addItem(t.getMaKH());
            });
        
        btnChonKhachHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 txKhachHang.setText(btnChonKhachHang.getSelectedItem().toString());
            }
        });
        
        txNhanVien.setText(LoginGUI.currentNhanVien.getMaNV()+" - "+ LoginGUI.currentNhanVien.getTenNV());
        
        btnChonKhuyenMai.setPreferredSize(new Dimension(80, 30));
        QuanlykhuyenmaiBUS.getDSKM().forEach((t) -> {
                btnChonKhuyenMai.addItem(t.getMaKM());
            });
        
        btnChonKhuyenMai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txKhuyenMai.setText(btnChonKhuyenMai.getSelectedItem().toString());
                btnChonKhuyenMai.setSelectedItem(btnChonKhuyenMai.getSelectedItem());
            }
        });

        // set border
        txMaHoaDon.setBorder(BorderFactory.createTitledBorder("Mã hóa đơn:"));
        txNhanVien.setBorder(BorderFactory.createTitledBorder("Nhân viên:"));
        txNgayLap.setBorder(BorderFactory.createTitledBorder("Ngày lập:"));
        txGioLap.setBorder(BorderFactory.createTitledBorder("Giờ lập:"));
        txKhachHang.setBorder(BorderFactory.createTitledBorder("Khách hàng:"));
        txTongTien.setBorder(BorderFactory.createTitledBorder("Tổng tiền (triệu vnd):"));
        txKhuyenMai.setBorder(BorderFactory.createTitledBorder("Khuyến mãi:"));

        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txMaHoaDon.setFont(f);
        txNhanVien.setFont(f);
        txNgayLap.setFont(f);
        txGioLap.setFont(f);
        txKhachHang.setFont(f);
        txMaHoaDon.setFont(f);
        txTongTien.setFont(f);
        txKhuyenMai.setFont(f);

        // set Text
//        if (LoginForm.nhanVienLogin != null) {
//            nhanVien = LoginForm.nhanVienLogin;
//            txNhanVien.setText(nhanVien.getTenNV() + " (" + nhanVien.getMaNV() + ")");
//        }

        txMaHoaDon.setText(qlhdBUS.MaHDnotHave());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                txNgayLap.setText(LocalDate.now().toString());
                txGioLap.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                if (txNhanVien.getText().equals("")
                        || txKhachHang.getText().equals("")
                        || txKhuyenMai.getText().equals("")
                        || dscthd.isEmpty()) {
                    btnThanhToan.setEnabled(false);
                } else {
                    btnThanhToan.setEnabled(true);
                }
            }
        }, 0, 1000);

        // set editable
        txMaHoaDon.setEditable(false);
        txNhanVien.setEditable(false);
        txKhachHang.setEditable(false);
        txNgayLap.setEditable(false);
        txGioLap.setEditable(false);
        txTongTien.setEditable(false);
        txKhuyenMai.setEditable(false);

        // add to panel
        plInput.add(txMaHoaDon);
        plInput.add(txTongTien);
        plInput.add(txKhachHang);
        plInput.add(btnChonKhachHang);
        plInput.add(txNhanVien);
        plInput.add(btnChonNhanVien);
        plInput.add(txNgayLap);
        plInput.add(txGioLap);
        plInput.add(txKhuyenMai);
        plInput.add(btnChonKhuyenMai);

        this.add(plInput);

        // =============== panel các sản phẩm đã chọn ==================
        int plSP_height = _height/3;
        JPanel plSanPham = new JPanel();
        plSanPham.setPreferredSize(new Dimension(_width - 10, plSP_height));
        plSanPham.setBackground(new Color(250, 250, 29));
        plSanPham.setLayout(new BorderLayout());

        int plBtn_height = 50;
        JPanel plButtonChiTiet = new JPanel();
        plButtonChiTiet.setLayout(new FlowLayout(FlowLayout.CENTER));
        plButtonChiTiet.setBackground(new Color(220, 220, 220));
        plButtonChiTiet.setPreferredSize(new Dimension(_width - 10, plBtn_height));

        btnXoa.addActionListener((ae) -> {
            btnXoaOnClick();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaOnClick();
        });
        btnRefresh.addActionListener((ae) -> {
            setDataToTable(dscthd, tbChiTietHoaDon);
        });

        plButtonChiTiet.add(btnXoa);
        plButtonChiTiet.add(btnSua);
        plButtonChiTiet.add(btnRefresh);

        tbChiTietHoaDon.setPreferredSize(new Dimension(_width - 10, plSP_height - plBtn_height));
        tbChiTietHoaDon.setHeaders(new String[]{"STT", "Mã", "Tên", "Số lượng", "Đơn giá", "Thành tiền"});
//        tbChiTietHoaDon.setColumnsWidth(new double[]{1, 2, 3, 2.2, 2.5, 3});
//        tbChiTietHoaDon.setAlignment(0, JLabel.CENTER);
//        tbChiTietHoaDon.setAlignment(1, JLabel.CENTER);
//        tbChiTietHoaDon.setAlignment(3, JLabel.CENTER);
//        tbChiTietHoaDon.setAlignment(4, JLabel.RIGHT);
//        tbChiTietHoaDon.setAlignment(5, JLabel.RIGHT);

        plSanPham.add(tbChiTietHoaDon, BorderLayout.CENTER);
        plSanPham.add(plButtonChiTiet, BorderLayout.SOUTH);

        this.add(plSanPham);

        // ============= panel Thanh toán ==============
        int plTT_height = _height - plIP_height - plSP_height - 20;
        JPanel plThanhToan = new JPanel();
        plThanhToan.setLayout(new FlowLayout(FlowLayout.RIGHT));
        plThanhToan.setPreferredSize(new Dimension(_width - 10, plTT_height));
        plThanhToan.setBackground(new Color(0, 0, 0));

        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/com/PhoneStoreManager/image/icons8_cancel_30px_1.png")));
        btnThanhToan.setIcon(new ImageIcon(this.getClass().getResource("/com/PhoneStoreManager/image/icons8_us_dollar_30px.png")));

        btnHuy.addActionListener((ae) -> {
            btnHuyOnClick();
        });
        btnThanhToan.addActionListener((ae) -> {
            btnThanhToanOnClick();
        });

        plThanhToan.add(btnHuy);
        plThanhToan.add(btnThanhToan);

        this.add(plThanhToan);
    }

    private void btnHuyOnClick() {
        clear();
    }

    private void btnThanhToanOnClick() {
        HoaDon hd = new HoaDon(
                txMaHoaDon.getText(),
                LoginGUI.currentNhanVien.getMaNV(),
                txKhachHang.getText(),
                btnChonKhuyenMai.getSelectedItem().toString(),
                LocalDate.parse(txNgayLap.getText()),
                LocalTime.parse(txGioLap.getText()),
                tongThanhToan);
        qlhdBUS.addHoaDon(hd);

        for (ChiTietHoaDon ct : dscthd) {
            qlcthd.addChiTietHoaDon(ct);
        }
        
//        int reply = JOptionPane.showConfirmDialog(getRootPane(),
//                        "Thanh toán thành công, bạn có muốn IN HÓA ĐƠN?", "Thành công",
//                        JOptionPane.YES_NO_OPTION);
//        if(reply == JOptionPane.OK_OPTION) {
//            new WritePDF().writeHoaDon(txMaHoaDon.getText());
//        }
    txMaHoaDon.setText(qlhdBUS.MaHDnotHave());
        clear();
        this.target.refreshAll();
    }

    private void btnXoaOnClick() {
        int i = tbChiTietHoaDon.getTable().getSelectedRow();
        if (i >= 0 && i < dscthd.size()) {
            dscthd.remove(i);
            setDataToTable(dscthd, tbChiTietHoaDon);
        }
    }

    private void btnSuaOnClick() {
        int i = tbChiTietHoaDon.getTable().getSelectedRow();
        if (i >= 0 && i < dscthd.size()) {
            ChiTietHoaDon ct = dscthd.get(i);
            this.target.showInfo(ct.getMaSP(), ct.getSoLuong());

            dscthd.remove(i);
            setDataToTable(dscthd, tbChiTietHoaDon);
        }
    }

    public void clear() {
        txKhachHang.setText("");
        txTongTien.setText("");
        txKhuyenMai.setText("");
        dscthd.clear();
        setDataToTable(dscthd, tbChiTietHoaDon);
    }

    @Override
    public void addChiTiet(String masp, int soluong) {
        SanPham sp = qlspBUS.getSanPham(masp);

        Boolean daCo = false; // check xem trong danh sách chi tiết hóa đơn đã có sản phẩm này chưa
        for (ChiTietHoaDon cthd : dscthd) {
            if (cthd.getMaSP().equals(sp.getMaSP())) {
                int tongSoLuong = soluong + cthd.getSoLuong();
                if (tongSoLuong > sp.getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + sp.getSoLuong() + ")");
                    return;
                }
                cthd.setSoLuong(tongSoLuong); // có rồi thì thay đổi số lượng
                daCo = true;
            }
        }

        if (!daCo) { // nếu chưa có thì thêm mới
            if (soluong > sp.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + sp.getSoLuong() + ")");
                return;
            }
            ChiTietHoaDon cthd = new ChiTietHoaDon(qlhdBUS.MaHDnotHave(), masp, soluong, sp.getDonGia());
            dscthd.add(cthd);
        }

        // cập nhật lại table
        setDataToTable(dscthd, tbChiTietHoaDon);
    }

    public void setDataToTable(ArrayList<ChiTietHoaDon> arr, Table t) {
        t.clear();
        long tongtien = 0;
        int stt = 1;
        for (ChiTietHoaDon cthd : arr) {
            String masp = cthd.getMaSP();
            SanPham sp = qlspBUS.getSanPham(masp);
            String tensp = sp.getTenSP();
            int soluong = cthd.getSoLuong();
            long dongia = cthd.getDonGia();
            long thanhtien = soluong * dongia;

            t.addRow(new String[]{
                String.valueOf(stt),
                masp,
                tensp,
                String.valueOf(soluong),
                PriceFormatter.format(dongia),
                PriceFormatter.format(thanhtien)
            });
            stt++;
            tongtien += thanhtien;
        }

        // check khuyến mãi
        t.addRow(new String[]{"", "", "", "", "", ""});
        t.addRow(new String[]{"", "", "", "", "Tổng tiền", PriceFormatter.format(tongtien)});
        if (khuyenMai != null && khuyenMai.getPhanTramKM() > 0 && khuyenMai.getDieuKienKM() <= tongtien) {
            long giaTriKhuyenMai = tongtien * khuyenMai.getPhanTramKM() / 100;
            long tongTienSauKhuyenMai = tongtien - giaTriKhuyenMai;
            tongThanhToan = tongTienSauKhuyenMai;
            t.addRow(new String[]{"", "", "", "", "Khuyến mãi", PriceFormatter.format(-giaTriKhuyenMai)});
            t.addRow(new String[]{"", "", "", "", "Còn lại", PriceFormatter.format(tongTienSauKhuyenMai)});
            txTongTien.setText(PriceFormatter.format(tongTienSauKhuyenMai));
        } else {
            tongThanhToan = tongtien;
            txTongTien.setText(PriceFormatter.format(tongtien));
        }
    }
}

class ChonSanPhamPanel extends JPanel {

    QuanlyloaisanphamBUS qllspBUS = new QuanlyloaisanphamBUS();
    QuanlysanphamBUS qlspBUS = new QuanlysanphamBUS();
    Table tbSanPham = new Table();
    JTextField txTimKiem = new JTextField(30);

    JLabel lbImage = new JLabel();
    JTextField txMaSP = new JTextField(12);
    JTextField txLoaiSP = new JTextField(12);
    JTextField txTenSP = new JTextField(12);
    JTextField txDonGia = new JTextField(12);
    JTextField txSoLuong = new JTextField(7);

    RefreshButton btnRefresh = new RefreshButton();
    ThemButton btnThem = new ThemButton();

    FormHang target = new FormHang();

    public ChonSanPhamPanel(int _x, int _y, int _width, int _height) {
        this.setBounds(_x, _y, _width, _height);
        this.setBackground(new Color(59, 68, 75));
        this.setLayout(new BorderLayout());

        // panel hiển thị sản phẩm
        int plSP_height = _height - 300;
        JPanel plSanPham = new JPanel();
        plSanPham.setPreferredSize(new Dimension(_width - 10, plSP_height));
        plSanPham.setBackground(new Color(49, 49, 49));
        plSanPham.setLayout(new BorderLayout());

        JPanel plTimKiem = new JPanel();
        txTimKiem.setBorder(BorderFactory.createTitledBorder("Tìm kiếm"));
        txTimKiem.setHorizontalAlignment(JLabel.CENTER);
        addDocumentListener(txTimKiem);
        plTimKiem.add(txTimKiem);
        btnRefresh.addActionListener((ae) -> {
            refreshTable();
        });
        plTimKiem.add(btnRefresh);
        plSanPham.add(plTimKiem, BorderLayout.NORTH);

        tbSanPham.setHeaders(new String[]{"Mã", "Loại", "Tên", "Đơn giá", "Số lượng"});
//        tbSanPham.setColumnsWidth(new double[]{.5, .5, 3, 1, .5});
//        tbSanPham.setAlignment(3, JLabel.RIGHT);
//        tbSanPham.setAlignment(4, JLabel.RIGHT);
//        tbSanPham.setupSort();
        plSanPham.add(tbSanPham, BorderLayout.CENTER);

        this.add(plSanPham, BorderLayout.CENTER);

        // =========== panel chi tiết sản phẩm chọn ================
        JPanel plChiTiet = new JPanel();
        plChiTiet.setPreferredSize(new Dimension(_width - 10, 258));
        plChiTiet.setBackground(new Color(240, 240, 240));
        plChiTiet.setLayout(new BorderLayout());

        lbImage.setBackground(Color.yellow);
        lbImage.setPreferredSize(new Dimension(200, 200));
        plChiTiet.add(lbImage, BorderLayout.WEST);

        JPanel plTextField = new JPanel();
        plTextField.setLayout(new FlowLayout());
        plTextField.setBackground(new Color(240, 240, 240));
        // border
        txMaSP.setBorder(BorderFactory.createTitledBorder("Mã sản phẩm"));
        txLoaiSP.setBorder(BorderFactory.createTitledBorder("Loại sản phẩm"));
        txTenSP.setBorder(BorderFactory.createTitledBorder("Tên sản phẩm"));
        txDonGia.setBorder(BorderFactory.createTitledBorder("Đơn giá"));
        txSoLuong.setBorder(BorderFactory.createTitledBorder("Số lượng"));
        // disable
        txMaSP.setEditable(false);
        txLoaiSP.setEditable(false);
        txTenSP.setEditable(false);
        txDonGia.setEditable(false);
        // font
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        txMaSP.setFont(f);
        txLoaiSP.setFont(f);
        txTenSP.setFont(f);
        txDonGia.setFont(f);
        txSoLuong.setFont(f);
        // add to panel
        plTextField.add(txMaSP);
        plTextField.add(txLoaiSP);
        plTextField.add(txTenSP);
        plTextField.add(txDonGia);
        plTextField.add(txSoLuong);

        btnThem.addActionListener((ae) -> {
            try {
                String masp = txMaSP.getText();
                int soluong = Integer.parseInt(txSoLuong.getText());
                if (soluong > 0) {
                    this.target.addChiTiet(masp, soluong);
                } else {
                    JOptionPane.showMessageDialog(txSoLuong, "Số lượng phải là số dương!");
                    txSoLuong.requestFocus();
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(txSoLuong, "Số lượng phải là số nguyên!");
                txSoLuong.requestFocus();
            }
        });

        plChiTiet.add(plTextField, BorderLayout.CENTER);
        plChiTiet.add(btnThem, BorderLayout.SOUTH);

        this.add(plChiTiet, BorderLayout.SOUTH);

        // event
        tbSanPham.getTable().addMouseListener(new MouseAdapter() { // copy từ HienThiSanPham
            @Override
            public void mouseReleased(MouseEvent me) {
                String masp = getSelectedSanPham(0);
                if (masp != null) {
                    showInfo(masp, 1);
                }
            }
        });

        refreshAll();
    }

    public void setTarget(FormHang target) {
        this.target = target;
    }

    public void refreshTable() {
        qlspBUS.getDSSP();
        setDataToTable(qlspBUS.search("", "Tất cả", -1, -1, -1, -1, 0), tbSanPham);
    }

    public void refreshAll() {
        refreshTable();
        txMaSP.setText("");
        txLoaiSP.setText("");
        txTenSP.setText("");
        txDonGia.setText("");
        txSoLuong.setText("");
        lbImage.setIcon(null);
    }

    public void showInfo(String masp, int soluong) {
        // https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
        if (masp != null) {
            // show hình
            for (SanPham sp : qlspBUS.getDSSP()) {
                if (sp.getMaSP().equals(masp)) {
                    int w = lbImage.getWidth();
                    int h = lbImage.getHeight();
                    ImageIcon img = new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/product/" + sp.getHinhAnh()));
                    Image imgScaled = img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT);
                    lbImage.setIcon(new ImageIcon(imgScaled));

                    // show info
                    String loai = qllspBUS.getLSP(sp.getMaLSP()).getTenLSP();
                    txMaSP.setText(sp.getMaSP());
                    txTenSP.setText(sp.getTenSP());
                    txLoaiSP.setText(loai + " - " + sp.getMaLSP());
                    txDonGia.setText(PriceFormatter.format(sp.getDonGia()));
                    txSoLuong.setText(String.valueOf(soluong));
                    return;
                }
            }
        }
    }

    private void addDocumentListener(JTextField tx) {
        // https://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
        tx.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                txSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                txSearchOnChange();
            }
        });
    }

    public void txSearchOnChange() {
        setDataToTable(qlspBUS.search(txTimKiem.getText(), "Tất cả", -1, -1, -1, -1, 0), tbSanPham);
    }

    public String getSelectedSanPham(int col) {
        int i = tbSanPham.getTable().getSelectedRow();
        if (i >= 0) {
            int realI = tbSanPham.getTable().convertRowIndexToModel(i);
            return tbSanPham.getModel().getValueAt(realI, col).toString();
        }
        return null;
    }

    private void setDataToTable(ArrayList<SanPham> data, Table table) {
        table.clear();
        for (SanPham sp : data) {
            if (sp.getTrangThai() == 0) {
                table.addRow(new String[]{
                    sp.getMaSP(),
                    sp.getMaLSP(),
                    sp.getTenSP(),
                    PriceFormatter.format(sp.getDonGia()),
                    String.valueOf(sp.getSoLuong()),});
            }
        }
    }
}
