
package com.PhoneStoreManager.FrontEnd.FormThemSua;

import com.PhoneStoreManager.FrontEnd.Panel.AgeSearch;
import com.PhoneStoreManager.FrontEnd.Panel.DateSearch;
import com.PhoneStoreManager.FrontEnd.Panel.SearchPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class NewClass extends JFrame{
    private JButton btnLamMoi;
    private JButton btnChon;
    private JPanel pnmain;
    private JPanel pnSouth;
    private JPanel pnNorth;
    private JTable tb;
    private SearchPanel pnSearch;
    private DateSearch pnDateSearch;
    private AgeSearch pnAgeSearch;
    private DefaultTableModel model;
    private JScrollPane JS;

    public NewClass() {
        setIconImage((new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/signs-1.png"))).getImage());
        Font font = new Font("Tahoma", 1, 12);
        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/internet.png")));
        btnLamMoi.setFont(font);
        btnChon = new JButton("Chọn");
        btnChon.setIcon(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/correct.png")));
        btnChon.setFont(font);
        init();
        
        sort();
        tb.setFont(new Font("Segoe UI", 0, 16));
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void init(){
        setSize(1100, 600);
        pnSouth = new JPanel();
        pnSouth.setBackground(Color.red);
        
        pnSouth.add(btnChon, BorderLayout.CENTER);
        pnSouth.add(btnLamMoi, BorderLayout.CENTER);
        
        tb = new JTable();
        JS = new JScrollPane(tb);
        model = (DefaultTableModel) tb.getModel();
        tb.setRowHeight(35);
        
        model.setColumnIdentifiers(new String[]{"STT", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", 
                "Địa chỉ", "Số điện thoại", "Trạng Thái"});
//        tb.setSize(getSize().width, getSize().height-pnSouth.getSize().height);
        
        pnNorth = new JPanel();
        pnNorth.setBackground(Color.pink);
        pnNorth.add(new JButton("Thiện"), BorderLayout.CENTER);
//        pnAgeSearch = new AgeSearch();
//        pnSearch = new SearchPanel();
//        pnDateSearch = new DateSearch();
//        pnNorth.add(pnSearch, BorderLayout.CENTER);
//        pnNorth.add(pnDateSearch, BorderLayout.CENTER);
//        pnNorth.add(pnAgeSearch, BorderLayout.CENTER);
        add(pnSouth, BorderLayout.SOUTH);
        add(JS, BorderLayout.CENTER);
        add(pnNorth, BorderLayout.NORTH);
    }
    
    private void sort(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tb.setRowSorter(sorter);
    }
    
//    https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
    public void resizeColumnWidth() {
        final TableColumnModel columnModel = tb.getColumnModel();
        for (int column = 0; column < tb.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < tb.getRowCount(); row++) {
                TableCellRenderer renderer = tb.getCellRenderer(row, column);
                Component comp = tb.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            width += 15;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
////        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
    public static void main(String[] args){
        new NewClass().setVisible(true);
    }
}
