
package com.PhoneStoreManager.FrontEnd.Panel;

import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.FrontEnd.GiaoDien.GiaoDienGUI;
import com.PhoneStoreManager.FrontEnd.GiaoDien.Table;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgeSearch extends JPanel{
    public JTextField ageFrom;
    public JTextField ageTo;
    public JButton btnTim;

    public AgeSearch(String type) {
        init();
        if(!type.equals("GIAODIEN")){
            setSize(350, 100);
//            setBackground(new Color(240,240,240));
            float xcom = (float) (getSize().width*0.05);
            float ycom = (float) (getSize().height*0.3);
            float wcom = (float) (getSize().width*0.35);
            float hcom = (float) (getSize().height*0.55);

            ageFrom.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
            xcom += ageFrom.getSize().width;
            ageTo.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
            xcom += ageTo.getSize().width;
            btnTim.setBounds((int) xcom, (int) (ycom*1.45), (int) (wcom*0.6), (int) (hcom*0.7));
        }
    }
    
    private void init(){
        ageFrom = new JTextField();
        ageTo = new JTextField();
        btnTim = new JButton();
        setBackground(Color.white);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0,0,0)), "Tuổi"));
        ageFrom.setBorder(BorderFactory.createTitledBorder("Từ"));
        ageTo.setBorder(BorderFactory.createTitledBorder("Đến"));
        btnTim.setText("Tìm");
        
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        add(ageFrom);
        add(ageTo);
        add(btnTim);
    }
    
    public void setSizePanel(int x, int y){
        setBounds(x, y, 300, 100);
        
        float xcom = (float) (getSize().width*0.05);
        float ycom = (float) (getSize().height*0.3);
        float wcom = (float) (getSize().width*0.35);
        float hcom = (float) (getSize().height*0.55);
        
        ageFrom.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
        xcom += ageFrom.getSize().width;
        ageTo.setBounds((int) xcom, (int) ycom, (int) wcom, (int) hcom);
        xcom += ageTo.getSize().width;
        btnTim.setBounds((int) xcom, (int) (ycom*1.45), (int) (wcom*0.6), (int) (hcom*0.7));
    }
    
    public void SearchAgeNhanVien(){
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ag1 = ageFrom.getText().trim();
                String ag2 = ageTo.getText().trim();
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
        });
    }
}
