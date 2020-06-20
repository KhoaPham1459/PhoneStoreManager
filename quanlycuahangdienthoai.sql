-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2020 lúc 08:46 AM
-- Phiên bản máy phục vụ: 10.4.8-MariaDB
-- Phiên bản PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlycuahangdienthoai`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD2', 'SP6', 10, 20000000),
('HD2', 'SP1', 2, 20000000),
('HD1', 'SP1', 1, 20000000),
('HD3', 'SP4', 1, 15000000),
('HD3', 'SP6', 1, 20000000),
('HD1', 'SP2', 10, 8200000),
('HD1', 'SP3', 11, 15000000),
('HD4', 'SP1', 3, 20000000),
('HD5', 'SP23', 1, 19900000),
('HD5', 'SP4', 3, 3900000),
('HD6', 'SP4', 1, 3900000),
('HD6', 'SP3', 1, 7900000),
('HD6', 'SP8', 5, 23000000),
('HD6', 'SP10', 2, 23900000),
('HD7', 'SP10', 1, 23900000),
('HD7', 'SP12', 2, 7900000),
('HD7', 'SP16', 3, 11900000),
('HD7', 'SP17', 1, 5600000),
('HD8', 'SP15', 1, 5500000),
('HD8', 'SP16', 1, 11900000),
('HD9', 'SP10', 1, 23900000),
('HD9', 'SP1', 1, 20000000),
('HD10', 'SP13', 1, 7900000),
('HD10', 'SP5', 10, 25700000),
('HD10', 'SP6', 10, 6500000),
('HD11', 'SP1', 1, 20000000),
('HD11', 'SP10', 1, 23900000),
('HD11', 'SP11', 2, 15900000),
('HD12', 'SP15', 2, 5500000),
('HD12', 'SP17', 1, 5600000),
('HD12', 'SP12', 1, 7900000),
('HD12', 'SP16', 5, 11900000),
('HD13', 'SP5', 1, 25700000),
('HD13', 'SP6', 1, 6500000),
('HD13', 'SP8', 3, 23000000),
('HD14', 'SP23', 49, 19900000),
('HD15', 'SP10', 1, 23900000),
('HD15', 'SP1', 2, 20000000),
('HD15', 'SP18', 1, 24000000),
('HD15', 'SP19', 1, 13000000),
('HD16', 'SP1', 20, 20000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL,
  `DonGia` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN1', 'SP8', 2, 23000000),
('PN1', 'SP24', 10, 25000000),
('PN2', 'SP3', 35, 7900000),
('PN3', 'SP1', 5, 20000000),
('PN4', 'SP14', 1, 5500000),
('PN4', 'SP12', 1, 7900000),
('PN4', 'SP1', 1, 20000000),
('PN4', 'SP7', 1, 15400000),
('PN5', 'SP15', 1, 5500000),
('PN5', 'SP14', 1, 5500000),
('PN5', 'SP11', 1, 15900000),
('PN5', 'SP1', 1, 20000000),
('PN6', 'SP10', 1, 23900000),
('PN6', 'SP15', 10, 5500000),
('PN6', 'SP17', 5, 5600000),
('PN7', 'SP21', 100, 8000000),
('PN7', 'SP22', 10, 39000000),
('PN8', 'SP16', 10, 11900000),
('PN9', 'SP1', 10, 20000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` date NOT NULL,
  `GioLap` time NOT NULL,
  `TongTien` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaNV`, `MaKH`, `MaKM`, `NgayLap`, `GioLap`, `TongTien`) VALUES
('HD1', 'NV2', 'KH2', 'KM2', '2019-04-18', '22:45:52', 267000000),
('HD10', 'NV23', 'KH16', 'KM1', '2019-04-24', '22:16:58', 329900000),
('HD11', 'NV12', 'KH22', 'KM1', '2019-04-25', '13:20:37', 75700000),
('HD12', 'NV12', 'KH19', 'KM3', '2019-04-26', '17:59:11', 84000000),
('HD13', 'NV12', 'KH14', 'KM1', '2019-04-26', '18:58:06', 101200000),
('HD14', 'NV12', 'KH19', 'KM3', '2019-05-01', '14:14:27', 975100032),
('HD15', 'NV12', 'KH15', 'KM5', '2019-05-05', '15:12:27', 100900000),
('HD16', 'NV12', 'KH1', 'KM4', '2019-05-10', '11:21:12', 400000000),
('HD2', 'NV1', 'KH1', 'KM1', '2019-04-18', '23:15:36', 240000000),
('HD3', 'NV1', 'KH1', 'KM1', '2019-04-19', '18:44:34', 35000000),
('HD4', 'NV1', 'KH1', 'KM1', '2019-04-21', '12:13:48', 60000000),
('HD5', 'NV15', 'KH1', 'KM1', '2019-04-24', '03:18:01', 31600000),
('HD6', 'NV15', 'KH7', 'KM1', '2019-04-24', '03:21:35', 174600000),
('HD7', 'NV15', 'KH13', 'KM1', '2019-04-24', '03:22:30', 81000000),
('HD8', 'NV15', 'KH3', 'KM1', '2019-04-24', '11:29:50', 17400000),
('HD9', 'NV15', 'KH12', 'KM1', '2019-04-24', '21:43:30', 43900000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('KH1', 'Trần Văn Hoàng', 'TP HCM', '0123456789', 1),
('KH10', 'Trần Ngọc Hải', 'Kiên Giang', '0905271941', 1),
('KH11', 'Nguyễn Xuân Diệu', 'TP HCM', '0301279552', 0),
('KH12', 'Trần Thanh Thiện', 'Hà Nội', '0123617389', 0),
('KH13', 'Huỳnh Minh Mẫn', 'An Giang', '0389230581', 1),
('KH14', 'Trần Xuân An', 'Long An', '0972136531', 1),
('KH15', 'Nguyễn Thị Xuân', 'TP HCM', '0702571936', 1),
('KH16', 'Huỳnh Anh Thư', 'Bến Tre', '0892383623', 0),
('KH17', 'Trần Thanh Nhã', 'TP HCM', '0702397442', 1),
('KH18', 'Huỳnh Nhựt Trường', 'TP HCM', '0120982736', 1),
('KH19', 'Trần Ngọc Hà', 'TP HCM', '0702843627', 1),
('KH2', 'Nguyễn Thiên Hữu', 'Huế', '0126461589', 0),
('KH20', 'Trần Thị Hoài Anh', 'TP HCM', '0126729137', 1),
('KH21', 'Nguyễn Văn Thắng', 'Kiên Giang', '0723812935', 1),
('KH22', 'Huỳnh Lê Diệu Hân', 'Hà Nội', '0306279178', 0),
('KH23', 'Nguyễn Ngọc Thiện', 'Bình Định', '0364117408', 1),
('KH3', 'Phan Thanh Tùng', 'Hà Nội', '0952612771', 1),
('KH4', 'Trần Thanh Sơn', 'Hải Phòng', '0120617231', 1),
('KH5', 'Trần Thanh Thái', 'Bến Tre', '0912385524', 0),
('KH6', 'Nguyễn Hồng Nhung', 'Huế', '0967263941', 1),
('KH7', 'Từ Ngọc Cảnh', 'Sóc Trăng', '0306172915', 1),
('KH8', 'Nguyễn Thiên Phụng', 'Vũng Tàu', '0703167293', 1),
('KH9', 'Nguyễn Diệu Ái', 'TP HCM', '0805178293', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenKM` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DieuKienKM` bigint(20) NOT NULL,
  `PhanTramKM` int(11) NOT NULL,
  `NgayBD` date DEFAULT NULL,
  `NgayKT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `DieuKienKM`, `PhanTramKM`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'Không khuyến mãi', 0, 0, '2019-04-01', '2021-04-30'),
('KM2', 'Giảm giá nhân ngày 30/4', 5000000, 30, '2019-04-28', '2019-05-02'),
('KM3', 'Giảm giá 1/5', 2000000, 10, '2019-04-25', '2019-05-02'),
('KM4', 'Giảm giá tết', 15000000, 20, '2019-04-24', '2019-12-01'),
('KM5', 'Khuyến mãi xả hàng', 1000000, 50, '2019-05-05', '2019-05-06'),
('KM6', 'Khuyến mãi mùa hè', 15000000, 20, '2020-07-01', '2020-08-06'),
('KM7', 'Khuyến mãi mùa hè 2', 5000000, 5, '2020-05-01', '2020-12-07');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MaLSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenLSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `Mota` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MaLSP`, `TenLSP`, `Mota`) VALUES
('LSP1', 'Apple', 'Các sản phẩm của Apple'),
('LSP10', 'Nokia', 'san pham cua nokia'),
('LSP2', 'Oppo', 'Camara Selphi cuc chat tu Oppo'),
('LSP3', 'SamSung', 'Khuyen mai lon tu SamSung'),
('LSP4', 'Phillip', 'Các sản phẩm tuyệt đẹp đến từ phillip'),
('LSP5', 'Nokia', 'Các sản phẩm đến từ thương hiệu Nokia'),
('LSP6', 'Blackbery', 'BlackBery is the best'),
('LSP7', 'Huawei', 'Các sản phẩm đến từ thương hiệu Huawei'),
('LSP8', 'Vivo', 'Các sản phẩm đến từ Vivo'),
('LSP9', 'Xiaomi', 'Các sản phẩm đến từ thương hiệu Xiaomi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNCC` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Fax` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SDT`, `Fax`) VALUES
('NCC1', 'Cty Samsung', 'TP HCM', '0123456789', '4598-8789-8789-7897'),
('NCC2', 'Cty Thương Mại Công Nghệ', 'Hà Nội', '0120728815', '3672-1782-3923-6091'),
('NCC3', 'Cty Di Động Trường Sơn', 'TP HCM', '0703192738', '2364-2974-2384-2394'),
('NCC4', 'Cty Viễn Thông Thành Đạt', 'TP HCM', '0501239237', '9823-6738-6739-6766'),
('NCC5', 'Thế Giới Công Nghệ', 'Bình Dương', '0801729329', '1830-7288-8900-7712'),
('NCC6', 'Cty TNHH Hoàng Bá', 'Long An', '0303676818', '7623-9812-3876-2834'),
('NCC7', 'Cty Di Động Thành Tiến', 'Hà Nội', '0989140736', '1873-1738-8736-4761'),
('NCC8', 'Cty Toàn Thắng', 'TP HCM', '0120628918', '8127-9382-1974-2983');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNV` text COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NgaySinh`, `DiaChi`, `SDT`, `TrangThai`) VALUES
('NV1', 'Nguyễn Ngọc Thiện', '2000-05-08', 'Bình Định', '0364117408', 1),
('NV10', 'Nguyễn Tuyến Đạt', '2000-02-19', 'HCM', '01262368193', 1),
('NV11', 'Phan Thị Hồng Trinh', '1993-12-11', 'Nghệ An', '0366227168', 1),
('NV12', 'Phan Văn Tài', '1989-06-15', 'Kiên Giang', '0981578293', 1),
('NV13', 'Lê Công Huynh', '1991-09-12', 'Sóc Trăng', '0977232173', 1),
('NV14', 'Lê Hồng Hoa', '1992-08-13', 'TP HCM', '0805126735', 1),
('NV15', 'Nguyễn Thị My', '1992-12-30', 'Hà Nội', '0703689147', 1),
('NV16', 'Trương Thị Hồng Huệ', '1992-11-28', 'TP HCM', '0825719263', 1),
('NV17', 'Nguyễn Thành Trung', '1992-01-16', 'Thanh Hoá', '0123691368', 1),
('NV18', 'Nguyễn Thị Cẩm Duyên', '1995-11-03', 'TP HCM', '0120984178', 1),
('NV19', 'Lê Thanh Quang', '1995-04-19', 'Huế', '0956146728', 1),
('NV2', 'Trần Văn Hi', '1999-04-05', 'TP HCM', '0123456489', 1),
('NV20', 'Nguyễn Hùng Bá', '1997-02-14', 'Hải Phòng', '0702536184', 1),
('NV21', 'Huỳnh Công Thành', '1996-11-20', 'Long An', '0709123175', 1),
('NV22', 'Huỳnh Thị Hồng Hương', '1994-11-27', 'TP HCM', '0912635198', 1),
('NV23', 'Phan Yến Hân', '1996-03-14', 'Bến Tre', '0123671823', 1),
('NV24', 'Trương Thanh Dũng', '1997-10-28', 'Đồng Tháp', '0981237651', 1),
('NV25', 'Nguyễn Tấn Thông', '2000-05-31', 'HCM', '0364117408', 1),
('NV26', 'Hồ Thị Thơm', '2000-05-31', 'Bình Định', '0364117408', 1),
('NV27', 'Nguyển Trương Thanh Trúc', '2002-05-12', 'Bình Định', '0364117408', 1),
('NV3', 'Nguyễn Bá Được', '1998-04-05', 'Hà Nội', '0128456786', 1),
('NV4', 'Trần Văn Hoàng', '1999-11-12', 'TP HCM', '01207764668', 1),
('NV5', 'Lê Thanh Tú', '1991-04-11', 'Hải Phòng', '0367756753', 1),
('NV6', 'Nguyễn Hải Âu', '1992-04-24', 'Huế', '0364198226', 1),
('NV7', 'Hoàng Thanh Hùng', '1989-11-13', 'Long An', '0276886265', 1),
('NV8', 'Trịnh Văn Công', '1990-07-16', 'Tiền Giang', '0392656931', 1),
('NV9', 'Dương Thanh Hồng', '1991-12-03', 'Vũng Tàu', '0977268398', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenQuyen` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ChiTietQuyen` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`MaQuyen`, `TenQuyen`, `ChiTietQuyen`) VALUES
('Q1', 'Quản lý', 'xemSanPham xemLoaiSanPham xemHoaDon qlNhanVien qlKhachHang xemPhieuNhap xemNCC qlTaiKhoan qlQuyen'),
('Q2', 'Nhân viên Bán hàng', 'qlBanHang xemSanPham xemLoaiSanPham xemHoaDon xemNhanVien xemKhachHang'),
('Q3', 'Phụ Bán Hàng', 'qlBanHang xemSanPham xemKhuyenMai xemKhachHang'),
('Q4', 'Admin', 'qlBanHang qlNhapHang qlSanPham qlLoaiSanPham qlHoaDon qlKhuyenMai qlNhanVien qlKhachHang qlPhieuNhap qlNCC qlTaiKhoan qlQuyen'),
('Q5', 'Nhân viên Nhập hàng', 'qlNhapHang xemSanPham xemLoaiSanPham xemNhanVien qlPhieuNhap qlNCC');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNCC` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` date NOT NULL,
  `GioNhap` time NOT NULL,
  `TongTien` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `GioNhap`, `TongTien`) VALUES
('PN1', 'NCC2', 'NV1', '2019-04-24', '01:25:08', 296000000),
('PN2', 'NCC3', 'NV1', '2019-04-24', '01:25:23', 276500000),
('PN3', 'NCC5', 'NV12', '2019-04-25', '17:06:52', 100000000),
('PN4', 'NCC4', 'NV12', '2019-04-26', '02:51:18', 48800000),
('PN5', 'NCC5', 'NV12', '2019-04-26', '17:54:01', 46900000),
('PN6', 'NCC8', 'NV12', '2019-04-26', '17:58:26', 106900000),
('PN7', 'NCC6', 'NV12', '2019-05-01', '14:15:27', 1190000000),
('PN8', 'NCC1', 'NV12', '2019-05-10', '11:19:10', 119000000),
('PN9', 'NCC2', 'NV12', '2019-05-10', '11:19:53', 200000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaLSP` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TenSP` varchar(70) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` bigint(20) NOT NULL,
  `SoLuong` int(10) UNSIGNED NOT NULL DEFAULT 1,
  `HinhAnh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `MaLSP`, `TenSP`, `DonGia`, `SoLuong`, `HinhAnh`, `TrangThai`) VALUES
('SP1', 'LSP1', 'IPhone X', 20000000, 90, 'iphone-xr-128gb-red-400x400.jpg', 1),
('SP10', 'LSP1', 'iPhone Xr 256GB', 23900000, 75, 'iphone-xr-256gb-white-400x400.jpg', 1),
('SP11', 'LSP2', 'OPPO R17 Pro', 15900000, 99, 'oppo-r17-pro-2-400x460.jpg', 1),
('SP12', 'LSP8', 'Vivo V15', 7900000, 257, 'vivo-v15-quanghai-400x460.jpg', 1),
('SP13', 'LSP6', 'Blackberry Evolve', 7900000, 46, 'blackberry-evolve6xvk3-640.jpg', 1),
('SP14', 'LSP7', 'Huawei Y9 (2019)', 5500000, 37, 'huawei-y9-2019-blue-400x460.jpg', 1),
('SP15', 'LSP2', 'OPPO F7', 5500000, 361, 'oppo-f7-red-mtp-400x460.jpg', 1),
('SP16', 'LSP9', 'Xiaomi Mi 8', 11900000, 51, 'xiaomi-mi-8-1-400x460-400x460.jpg', 1),
('SP17', 'LSP9', 'Xiaomi Redmi Note 6 Pro 64GB', 5600000, 68, 'xiaomi-redmi-note-6-pro-black-1-400x460.jpg', 1),
('SP18', 'LSP3', 'Samsung Galaxy Note 9 512GB', 24000000, 59, 'samsung-galaxy-note-9-512gb-blue-400x460.jpg', 1),
('SP19', 'LSP7', 'Huawei Mate 20', 13000000, 44, 'huawei-mate-20-black-400x460.jpg', 1),
('SP2', 'LSP2', 'Oppo A7', 8200000, 70, 'oppo-a7-400x460.jpg', 1),
('SP20', 'LSP8', 'Vivo Y85', 5000000, 36, 'vivo-y85-red-docquyen-400x460.jpg', 1),
('SP21', 'LSP8', 'Vivo V11', 8000000, 130, 'vivo-v11-400x460.jpg', 1),
('SP22', 'LSP1', 'iPhone Xs Max 512GB', 39000000, 55, 'iphone-xs-max-512gb-gold-400x460.jpg', 1),
('SP23', 'LSP2', 'OPPO Fid X', 19900000, 0, 'oppo-find-x-1-400x460-400x460.jpg', 1),
('SP24', 'LSP1', 'Iphone abc', 25000000, 20, 'iphone-xr-256gb-white-400x400.jpg', 1),
('SP25', 'LSP1', 'Apple 4566', 4250000, 45, 'huawei-mate-20-black-400x460.jpg', 1),
('SP3', 'LSP5', 'Nokia 8.1', 7900000, 69, 'nokia-81-silver-400x460.jpg', 1),
('SP4', 'LSP4', 'Philips S327', 2000000, 56, 'philips-s327-400-400x460.jpg', 1),
('SP5', 'LSP1', 'iPhone 8 Plus 256GB', 25700000, 167, 'iphone-8-plus-256gb-gold-400x460.jpg', 1),
('SP6', 'LSP5', 'Nokia 6.1 Plus', 6500000, 44, 'nokia-61-plus-3-400x460.jpg', 1),
('SP7', 'LSP2', 'Oppo NEO 3', 15400000, 101, 'oppo-a7-32gb-gold-400x400.jpg', 0),
('SP8', 'LSP7', 'Huawei P30 Pro', 23000000, 69, 'huawei-p30-pro-1-400x460.jpg', 1),
('SP9', 'LSP3', 'Samsung Galaxy S10+ (512GB)', 29000000, 57, 'samsung-galaxy-s10-plus-512gb-ceramic-black-400x460.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `TenTaiKhoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaQuyen` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`TenTaiKhoan`, `MatKhau`, `MaNV`, `MaQuyen`) VALUES
('admin', 'admin', 'NV1', 'Q4'),
('BaDuocSeller', 'baduoc', 'NV3', 'Q2'),
('NhanVien', 'nv', 'NV20', 'Q2'),
('quanly', 'quanly', 'NV9', 'Q1'),
('ThanhTuNH', 'thanhtu', 'NV5', 'Q5'),
('thien1', '12345', 'NV1', 'Q5'),
('TuyenDat', 'tuyendat113', 'NV10', 'Q2'),
('VanHoangAdmin', 'vanhoang', 'NV4', 'Q3'),
('VanTaiNH', 'vantai', 'NV12', 'Q5'),
('YenHanPhuBH', 'yenhan', 'NV23', 'Q3');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaHD` (`MaHD`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `MaSP` (`MaSP`),
  ADD KEY `MaPN` (`MaPN`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaKH` (`MaKH`),
  ADD KEY `MaKM` (`MaKM`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MaLSP`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `LoaiSP` (`MaLSP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenTaiKhoan`),
  ADD KEY `MaQuyen` (`MaQuyen`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `chitietphieunhap_ibfk_3` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `khuyenmai_ibfk_3` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLSP`) REFERENCES `loaisanpham` (`MaLSP`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_3` FOREIGN KEY (`MaQuyen`) REFERENCES `phanquyen` (`MaQuyen`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
