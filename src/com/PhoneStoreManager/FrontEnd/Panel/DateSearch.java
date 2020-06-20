
package com.PhoneStoreManager.FrontEnd.Panel;

import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.PhieuNhap;
import com.PhoneStoreManager.BackEnd.Quanlyphieunhap.QuanlyphieunhapBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import com.PhoneStoreManager.FrontEnd.GiaoDien.Table;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DateSearch extends JPanel{
    public JDateChooser dateFrom;
    public JDateChooser dateTo;
    public JButton btnTim;
    
    public DateSearch(String type) {
        init();
        if(!type.equals("GIAODIEN")){
            setSize(400, 100);
//            setBackground(new Color(240,240,240));
            float wcom = (float)(0.4*getSize().width);
            float hcom = (float)(0.7*getSize().height);
            float ycom = (float)(0.2*getSize().height);
            float xcom = (float)(0.01*getSize().width);

            dateFrom.setBounds((int)xcom, (int)ycom, (int)wcom, (int)hcom);
            xcom += dateFrom.getSize().getWidth();
            dateTo.setBounds((int)xcom, (int)ycom, (int)wcom, (int)hcom);
            xcom += dateTo.getSize().width;
            btnTim.setBounds((int)(xcom), (int)(ycom*2), (int)(wcom*0.4), (int)(hcom*0.5));
        }
    }
    
    private void init(){
        dateFrom = new JDateChooser();
        dateTo = new JDateChooser();
        btnTim = new JButton();
        Color white = new Color(255, 255, 255);
        setBackground(white);
        dateFrom.setBackground(white);
        dateTo.setBackground(white);
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0,0,0)),"Ngày sinh"));
        dateFrom.setBorder(BorderFactory.createTitledBorder("Từ"));
        dateTo.setBorder(BorderFactory.createTitledBorder("Đến"));
        btnTim.setText("Tìm");
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        add(dateFrom);
        add(dateTo);
        add(btnTim);
    }
    
    public void setSizePanel(int x, int y){
        this.setBounds(x, y, 400, 100);
        float wcom = (float)(0.425*getSize().width);
        float hcom = (float)(0.7*getSize().height);
        float ycom = (float)(0.2*getSize().height);
        float xcom = (float)(0.01*getSize().width);
        
        dateFrom.setBounds((int)xcom, (int)ycom, (int)wcom, (int)hcom);
        xcom += dateFrom.getSize().getWidth();
        dateTo.setBounds((int)xcom, (int)ycom, (int)wcom, (int)hcom);
        xcom += dateTo.getSize().width;
        btnTim.setBounds((int)(xcom), (int)(ycom*2), (int)(wcom*0.3), (int)(hcom*0.5));
    }
    
    // Chức năng tìm kiếm theo ngày sinh cho nhân viên
    public void SearchDateBornNhanVien(){
        String DateFrom = "";
        String DateTo = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
        if(dateFrom.getDate() != null){
            DateFrom = sdf.format(dateFrom.getDate());
        }
        if(dateTo.getDate() != null){
            DateTo = sdf.format(dateTo.getDate());
        }

        String kq_timkiem = "----From: " + DateFrom + " To: " + DateTo + " ---------- ";

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

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        String[] header = {"STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", 
        "Địa chỉ", "Số điện thoại", "Trạng Thái"};
        GiaoDienGUI.tb.setHeaders(header);

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
    
    // Chức năng tìm kiếm theo ngày sinh cho hóa đơn
    public void SearchDateForHoaDon(){
        String DateFrom = "";
        String DateTo = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
        if(dateFrom.getDate() != null){
            DateFrom = sdf.format(dateFrom.getDate());
        }
        if(dateTo.getDate() != null){
            DateTo = sdf.format(dateTo.getDate());
        }

        String kq_timkiem = "----From: " + DateFrom + " To: " + DateTo + " ---------- ";

        ArrayList<HoaDon> list;
        if(DateFrom.equals("") || DateTo.equals("")){
            list = QuanlyhoadonBUS.SearchHDFromDate(-1, -1, -1, -1, -1, -1);
        }
        else{
            String[] s1 = DateFrom.split("-");
            String[] s2 = DateTo.split("-");
            list = QuanlyhoadonBUS.SearchHDFromDate(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), Integer.parseInt(s2[0]),
                    Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
        }

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
                GiaoDienGUI.tb.addRow(new Object[]{Integer.toString(i),q.getMaHD(), q.getMaNV(), q.getMaKH(), q.getMaKM(), q.getNgayLap(), q.getGioLap(), QuanlykhuyenmaiBUS.ToCurrent(Long.toString(q.getTongTien()))});
            }
            kq_timkiem += "Đã tìm thấy";
        }

        GiaoDienGUI.tb.setRowHeigth(35);
        GiaoDienGUI.tb.resizeColumnWidth();
        GiaoDienGUI.pnContentContainer.add(GiaoDienGUI.tb);
        GiaoDienGUI.pnContentContainer.validate();
        System.out.println(kq_timkiem);
    }
    
    public void SearchDateForPhieuNhap(){
        String DateFrom = "";
        String DateTo = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd", Locale.getDefault());
        if(dateFrom.getDate() != null){
            DateFrom = sdf.format(dateFrom.getDate());
        }
        if(dateTo.getDate() != null){
            DateTo = sdf.format(dateTo.getDate());
        }

        String kq_timkiem = "----From: " + DateFrom + " To: " + DateTo + " ---------- ";

        ArrayList<PhieuNhap> list;
        if(DateFrom.equals("") || DateTo.equals("")){
            list = QuanlyphieunhapBUS.SearchPNFromDate(-1, -1, -1, -1, -1, -1);
        }
        else{
            String[] s1 = DateFrom.split("-");
            String[] s2 = DateTo.split("-");
            list = QuanlyphieunhapBUS.SearchPNFromDate(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]), Integer.parseInt(s2[0]),
                    Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
        }

        GiaoDienGUI.pnContentContainer.remove(GiaoDienGUI.tb);
        GiaoDienGUI.tb = new Table();
        GiaoDienGUI.tb.setBound(GiaoDienGUI.tb_x, GiaoDienGUI.tb_y, GiaoDienGUI.tb_w, GiaoDienGUI.tb_h);
        GiaoDienGUI.tb.setHeaders(QuanlyhoadonBUS.getHeaders);

        if(list == null){
            kq_timkiem += "Không tìm thấy";
        }
        else{
            int i = 0;
            for(PhieuNhap q: list){
                ++i;
                GiaoDienGUI.tb.addRow(new Object[]{Integer.toString(i),q.getMaPN(), q.getMaNCC(), q.getMaNV(), q.getNgayNhap(), q.getGioNhap(), q.getTongTien()});
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
