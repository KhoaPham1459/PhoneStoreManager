
package com.PhoneStoreManager.WorkWithExcel;

import com.PhoneStoreManager.BackEnd.QuanlyNCC.NCC;
import com.PhoneStoreManager.BackEnd.QuanlyNCC.QuanlyNCCBUS;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.HoaDon;
import com.PhoneStoreManager.BackEnd.Quanlyhoadon.QuanlyhoadonBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.KhachHang;
import com.PhoneStoreManager.BackEnd.Quanlykhachhang.QuanlykhachhangBUS;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.KhuyenMai;
import com.PhoneStoreManager.BackEnd.Quanlykhuyenmai.QuanlykhuyenmaiBUS;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.NhanVien;
import com.PhoneStoreManager.BackEnd.Quanlynhanvien.QuanlynhanvienBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.QuanlyquyenBUS;
import com.PhoneStoreManager.BackEnd.Quanlyquyen.Quyen;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.QuanlysanphamBUS;
import com.PhoneStoreManager.BackEnd.Quanlysanpham.SanPham;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.TaiKhoan;
import com.PhoneStoreManager.BackEnd.Xulytaikhoan.XulyTaiKhoanBUS;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.LoaiSanPham;
import com.PhoneStoreManager.BackEnd.Quanlyloaisanpham.QuanlyloaisanphamBUS;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;

public class XuatExcel {
    private FileDialog fd;

    public XuatExcel() {
        JFrame cc = new JFrame();
        cc.setLocationRelativeTo(null);
        cc.setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")).getImage());
        fd = new FileDialog(cc, "Xuất Excel", FileDialog.SAVE);
    }
    
    private String getFile(){
        fd.setFile("untitled.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if(url.equals("")){
            return null;
        }
        if(url.equals("null")){
            return null;
        }
        if(url.equals("nullnull")){
            return null;
        }
        return url;
    }
    
    // Xuất file Excel Nhân viên
    public void xuatFileExcelNhanVien(){
        fd.setTitle("Xuất dữ liệu nhân viên ra Excel");
//        fd.setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")).getImage());
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhân viên");
            
            ArrayList<NhanVien> list = QuanlynhanvienBUS.getDSNV();
            
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            int rownum = 0;
            
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(4, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(5, CellType.STRING).setCellValue("Số điện thoại");
            row.createCell(6, CellType.STRING).setCellValue("Trạng thái");
            
            for(NhanVien nv: list){
                ++rownum;
                
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(nv.getMaNV());
                row.createCell(2, CellType.STRING).setCellValue(nv.getTenNV());
                row.createCell(3, CellType.STRING).setCellValue(nv.getNgaySinh());
                row.createCell(4, CellType.STRING).setCellValue(nv.getDiaChi());
                row.createCell(5, CellType.STRING).setCellValue(nv.getSDT());
                row.createCell(6, CellType.STRING).setCellValue(nv.getTrangThai() == 1 ? "Còn làm" : "Hết làm");
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // Xuất file Excel Quyền
    public void xuatFileExcelQuyen(){
        fd.setTitle("Xuất dữ liệu quyền ra Excel");
//        fd.setIconImage(new ImageIcon(getClass().getResource("/com/PhoneStoreManager/image/excel.png")).getImage());
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        
        try{
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Quyền");
            
            ArrayList<Quyen> list = QuanlyquyenBUS.getDSQuyen();
            
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            int rownum = 0;
            
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã quyền");
            row.createCell(2, CellType.STRING).setCellValue("Tên quyền");
            row.createCell(3, CellType.STRING).setCellValue("Chi tiết quyền");
            
            for(Quyen q: list){
                ++rownum;
                
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(q.getMaQuyen());
                row.createCell(2, CellType.STRING).setCellValue(q.getTenQuyen());
                row.createCell(3, CellType.STRING).setCellValue(q.getChiTietQuyen());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Xuất file Tài khoản
    public void xuatFileExcelTaiKhoan(){
        fd.setTitle("Xuất dữ liệu tài khoản ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            ArrayList<TaiKhoan> list = XulyTaiKhoanBUS.getDSTaiKhoan();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Tài khoản");

            int rownum = 0;

            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Tên tài khoản");
            row.createCell(2, CellType.STRING).setCellValue("Mật khẩu");
            row.createCell(3, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(4, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(5, CellType.STRING).setCellValue("Mã quyền");
            row.createCell(6, CellType.STRING).setCellValue("Tên quyền");
            
            for(TaiKhoan tk: list){
                ++rownum;
                
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(tk.getTenTaiKhoan());
                row.createCell(2, CellType.STRING).setCellValue(tk.getMatKhau());
                row.createCell(3, CellType.STRING).setCellValue(tk.getMaNV());
                row.createCell(4, CellType.STRING).setCellValue(QuanlynhanvienBUS.getNhanVien(tk.getMaNV()).getTenNV());
                row.createCell(5, CellType.STRING).setCellValue(tk.getMaQuyen());
                row.createCell(6, CellType.STRING).setCellValue(QuanlyquyenBUS.getQuyen(tk.getMaQuyen()).getTenQuyen());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Xuất file Nhà cung cấp
    public void xuatFileExcelNCC(){
        fd.setTitle("Xuất dữ liệu nhà cung cấp ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            ArrayList<NCC> list = QuanlyNCCBUS.getDSNCC();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhà cung cấp");
            int rownum = 0;
            
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhà cung cấp");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhà cung cấp");
            row.createCell(3, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(4, CellType.STRING).setCellValue("Số điện thoại");
            row.createCell(5, CellType.STRING).setCellValue("Fax");
            
            for(NCC ncc : list){
                ++rownum;
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(ncc.getMaNCC());
                row.createCell(2, CellType.STRING).setCellValue(ncc.getTenNCC());
                row.createCell(3, CellType.STRING).setCellValue(ncc.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(ncc.getSDT());
                row.createCell(5, CellType.STRING).setCellValue(ncc.getFax());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Xuất file Khách hàng
    public void xuatFileExcelKhachHang(){
        fd.setTitle("Xuất dữ liệu khách hàng ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            ArrayList<KhachHang> list = QuanlykhachhangBUS.getDSKH();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Khách hàng");
            
            int rownum = 0;
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã khách hàng");
            row.createCell(2, CellType.STRING).setCellValue("Tên khách hàng");
            row.createCell(3, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(4, CellType.STRING).setCellValue("Số điện thoại");
            row.createCell(5, CellType.STRING).setCellValue("Trạng thái");
            
            for(KhachHang kh : list){
                ++rownum;
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(kh.getMaKH());
                row.createCell(2, CellType.STRING).setCellValue(kh.getTenKH());
                row.createCell(3, CellType.STRING).setCellValue(kh.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(kh.getSDT());
                row.createCell(5, CellType.STRING).setCellValue((kh.getTrangThai() == 1) ? "Hiện" : "Ẩn");
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // xuất file Excel LSP
    public void xuatFileExcelLSP(){
        fd.setTitle("Xuất dữ liệu loại sản phẩm ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        
        try {
            ArrayList<LoaiSanPham> list = QuanlyloaisanphamBUS.getDSLSP();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Loại sản phẩm");
            
            int rownum = 0;
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã loại");
            row.createCell(2, CellType.STRING).setCellValue("Tên loại");
            row.createCell(3, CellType.STRING).setCellValue("Mô tả");
            
            for(LoaiSanPham lsp : list){
                ++rownum;
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(lsp.getMaLSP());
                row.createCell(2, CellType.STRING).setCellValue(lsp.getTenLSP());
                row.createCell(3, CellType.STRING).setCellValue(lsp.getMota());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    // Xuất file Excel Khuyến Mãi
    public void xuatFileExcelKhuyenMai(){
        fd.setTitle("Xuất dữ liệu khuyến mãi ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
         FileOutputStream outFile = null;
         try {
            ArrayList<KhuyenMai> list = QuanlykhuyenmaiBUS.getDSKM();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Khuyến mãi");
            
            int rownum = 0;
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã khuyến mãi");
            row.createCell(2, CellType.STRING).setCellValue("Tên khuyến mãi");
            row.createCell(3, CellType.NUMERIC).setCellValue("Điều kiện khuyến mãi");
            row.createCell(4, CellType.NUMERIC).setCellValue("Phần trăm khuyến mãi");
            row.createCell(5, CellType.STRING).setCellValue("Ngày bắt đầu");
            row.createCell(6, CellType.STRING).setCellValue("Ngày kết thúc");
            String DKKM = "";
            for(KhuyenMai km: list){
                ++rownum;
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(km.getMaKM());
                row.createCell(2, CellType.STRING).setCellValue(km.getTenKM());
                row.createCell(3, CellType.NUMERIC).setCellValue(km.getDieuKienKM());
                row.createCell(4, CellType.NUMERIC).setCellValue(km.getPhanTramKM());
                row.createCell(5, CellType.STRING).setCellValue(km.getNgayBD().toString());
                row.createCell(6, CellType.STRING).setCellValue(km.getNgayKT().toString());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            JOptionPane.showMessageDialog(null, "Ghi file thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
             try {
                 if(outFile != null){
                     outFile.close();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
        }
    }
    
    // Xuất file Excel Sản phẩm
    public void xuatFileExcelSanPham(){
        fd.setTitle("Xuất dữ liệu sản phẩm ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sản phẩm");
            
            ArrayList<SanPham> list = QuanlysanphamBUS.getDSSP();
            
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            int rownum = 0;
            
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã sản phẩm");
            row.createCell(2, CellType.STRING).setCellValue("Mã loại sản phẩm");
            row.createCell(3, CellType.STRING).setCellValue("Tên sản phẩm");
            row.createCell(4, CellType.NUMERIC).setCellValue("Đơn giá");
            row.createCell(5, CellType.NUMERIC).setCellValue("Số lượng");
            row.createCell(6, CellType.STRING).setCellValue("Hình ảnh");
            row.createCell(7, CellType.STRING).setCellValue("Trạng thái");
            
            for(SanPham sp: list){
                ++rownum;
                
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(sp.getMaSP());
                row.createCell(2, CellType.STRING).setCellValue(sp.getMaLSP());
                row.createCell(3, CellType.STRING).setCellValue(sp.getTenSP());
                row.createCell(4, CellType.NUMERIC).setCellValue(sp.getDonGia());
                row.createCell(5, CellType.NUMERIC).setCellValue(sp.getSoLuong());
                row.createCell(6, CellType.STRING).setCellValue(sp.getHinhAnh());
                row.createCell(7, CellType.STRING).setCellValue(sp.getTrangThai() == 1 ? "Hiện" : "Ẫn");
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // Xuất file Excel Hóa Đơn
    public void xuatFileExcelHoaDon(){
        fd.setTitle("Xuất dữ liệu hóa đơn ra Excel");
        String url = getFile();
        if(url == null){
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
            return;
        }
        
        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Hóa đơn");
            
            ArrayList<HoaDon> list = QuanlyhoadonBUS.getDSHD();
            
            if(list == null){
                JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                return;
            }
            
            int rownum = 0;
            
            Row row = sheet.createRow(rownum);
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã hóa đơn");
            row.createCell(2, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Mã khách hàng");
            row.createCell(4, CellType.STRING).setCellValue("Mã khuyến mãi");
            row.createCell(5, CellType.STRING).setCellValue("Ngày lập");
            row.createCell(6, CellType.STRING).setCellValue("Giờ lập");
            row.createCell(7, CellType.NUMERIC).setCellValue("Tổng tiền");
            
            for(HoaDon q: list){
                ++rownum;
                
                row = sheet.createRow(rownum);
                row.createCell(0, CellType.NUMERIC).setCellValue("STT");
                row.createCell(1, CellType.STRING).setCellValue(q.getMaHD());
                row.createCell(2, CellType.STRING).setCellValue(q.getMaNV());
                row.createCell(3, CellType.STRING).setCellValue(q.getMaKH());
                row.createCell(4, CellType.STRING).setCellValue(q.getMaKM());
                row.createCell(5, CellType.STRING).setCellValue(q.getNgayLap().toString());
                row.createCell(6, CellType.STRING).setCellValue(q.getGioLap().toString());
                row.createCell(7, CellType.NUMERIC).setCellValue(q.getTongTien());
            }
            
            for(int i = 0; i < rownum; ++i){
                sheet.autoSizeColumn(i);
            }
            
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);
            
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
        } finally {
            try {
                if(outFile != null){
                    outFile.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
