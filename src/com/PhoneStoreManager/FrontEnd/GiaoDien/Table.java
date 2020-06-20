
package com.PhoneStoreManager.FrontEnd.GiaoDien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class Table extends javax.swing.JPanel {
    public DefaultTableModel model;
    private Object[] s = null;
    
    public Table() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        clear();
        sort();
        jTable1.setFont(new Font("Segoe UI", 0, 16));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
    }
    
//    public void setColumnsWidth(double[] percentages) {
//
//        double total = 0;
//        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
//            total += percentages[i];
//        }
//
//        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
//            TableColumn column = tb.getColumnModel().getColumn(i);
//            column.setPreferredWidth((int) (getPreferredSize().width * (percentages[i] / total)));
//        }
//    }
    
    public void setBound(int x, int y, int w, int h){
        this.setBounds(x, y, w, h);
    }
    
    public void setHeaders(String[] headers){
        model.setColumnIdentifiers(headers);
    }
    
    public void setHeaders(ArrayList<String> headers){
        model.setColumnIdentifiers(headers.toArray());
    }
    
    public void addRow(String[] row){
        model.addRow(row);
    }
    
    public void addRow(Object[] row){
        model.addRow(row);
    }
    
    public void removeRow(String Ma){
        for(int i = 0; i < model.getRowCount(); ++i){
            if(model.getValueAt(i, 1).toString().equals(Ma)){
                model.removeRow(i);
                return;
            }
        }
    }
    
    public void setValueRow(String Ma, String[] data){
        for(int i = 0; i < model.getRowCount(); ++i){
            if(model.getValueAt(i, 1).toString().equals(Ma)){
                for(int j = 0; j < data.length; ++j){
                    model.setValueAt(data[j], i, j);
                }
                return;
            }
        }
    }
    
    public void setValueRow(String Ma, Object[] data){
        for(int i = 0; i < model.getRowCount(); ++i){
            if(model.getValueAt(i, 1).toString().equals(Ma)){
                for(int j = 0; j < data.length; ++j){
                    model.setValueAt(data[j], i, j);
                }
                return;
            }
        }
    }
    
    public void setValueTrangThai(String Ma, String data){
        for(int i = 0; i < model.getRowCount(); ++i){
            if(model.getValueAt(i, 1).toString().equals(Ma)){
                for(int j = 0; j < model.getColumnCount(); ++j){
                    if(model.getColumnName(j).equals("Trạng thái")){
                        model.setValueAt(data, i, j);
                        return;
                    }
                }
            }
        }
    }
    
    public Object getValueAt(int row, int column){
        return model.getValueAt(row, column);
    }
    
    public Object getValueSTT(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("STT")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object getValueHinhAnh(){
        int row = jTable1.getSelectedRow();
        if(row >= 0){
            int colum = jTable1.getSelectedColumn();
            if(colum >= 0){
                String Namecolumn = jTable1.getColumnName(colum);
                if(Namecolumn.equals("Hình ảnh")){
                    return jTable1.getValueAt(row, colum);
                }
            }
        }
        return null;
    }
    
    public Object LayMaQuyenTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã quyền")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaKhuyenMaiTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã KM")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaHoaDonTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã hóa đơn")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
        public Object LayMaPhieuNhapTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã phiếu nhập")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
     public Object LayMaSPTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã sản phẩm")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayTrangThaiKhuyenMaiTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Trạng thái")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaLSPTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã loại")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaNVTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã nhân viên")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayTenTaiKhoanTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Tên tài khoản")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaNCCTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã NCC")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public Object LayMaKHTaiTable(int row){
        for(int i = 0; i < jTable1.getColumnCount(); ++i){
            if(jTable1.getColumnName(i).equals("Mã khách hàng")){
                return jTable1.getValueAt(row, i);
            }
        }
        return null;
    }
    
    public int getSelectedRow(){
        return jTable1.getSelectedRow();
    }
    
    public JTable getTable(){
        return jTable1;
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
    
    public void clear(){
        model.setRowCount(0);
    }
    
    public int getRowCount(){
        return model.getRowCount();
    }
    
    private void sort(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
    }
    
//    https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
    public void resizeColumnWidth() {
        final TableColumnModel columnModel = jTable1.getColumnModel();
        for (int column = 0; column < jTable1.getColumnCount(); column++) {
            int width = 100; // Min width = 100
            for (int row = 0; row < jTable1.getRowCount(); row++) {
                TableCellRenderer renderer = jTable1.getCellRenderer(row, column);
                Component comp = jTable1.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            width += 100;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
////        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
    // https://www.codejava.net/java-se/swing/setting-column-width-and-row-height-for-jtable
    public void setRowHeigth(int rowHeigth){
        jTable1.setRowHeight(rowHeigth);
    }
    
    public void setRowHeigth(int row, int rowHeigth){
        jTable1.setRowHeight(row, rowHeigth);
    }
    
    public void setPreferredWidth(int column, int width){
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    
    //    public void removeRow(int row){
//        model.removeRow(row);
//    }
//    
//    public void setValueRow(int row, String[] data){
//        int i = 0;
//        for(i = 0; i < data.length; ++i){
//            model.setValueAt(data[i], row, i);
//        }
//    }
//    
//    public void setValueAt(Object ob, int row, int column){
//        model.setValueAt(ob, row, column);
//    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MSSV", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        int row = jTable1.getSelectedRow();
        if(row >= 0){
            int colum = jTable1.getSelectedColumn();
            if(colum >= 0){
                if(s == null){
                    s = new Object[]{jTable1.getValueAt(row, colum), Integer.toString(row), Integer.toString(colum)};
                }
                else{
                    jTable1.setValueAt(s[0], Integer.parseInt(s[1].toString()), Integer.parseInt(s[2].toString()));
                    s = null;
                }
            }
        }
    }//GEN-LAST:event_jTable1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
