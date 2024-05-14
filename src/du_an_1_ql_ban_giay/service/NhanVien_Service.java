/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import du_an_1_ql_ban_giay.model.NhanVien;
import du_an_1_ql_ban_giay.utility.DBConnect;
import du_an_1_ql_ban_giay.utility.JDBCHelper;

/**
 *
 * @author Admin
 */
public class NhanVien_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<NhanVien> getAll(boolean deleted) {
        sql = "SELECT maNhanVien, chucVu, hoTen, gioiTinh, ngaySinh, soDT, email, diaChi FROM tbl_nhanVien WHERE deleted = ? ORDER BY ngayTao DESC";
        List<NhanVien> listnv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, deleted);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getBoolean(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
                listnv.add(nv);
            }
            return listnv;
        } catch (SQLException e) {
            return null;
        }
    }

    public NhanVien getNV(String maNV) {
        sql = "SELECT maNhanVien, chucVu, hoTen, gioiTinh, ngaySinh, soDT, email, diaChi,  FROM tbl_nhanVien WHERE maNhanVien = ?";
        NhanVien nv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien(rs.getString(1), rs.getBoolean(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien getNV_BY_ID(int ID_NV) {//Truy vấn MaNV theo ID_NV ( Mạnh ghi -- đừng xóa )
        sql = """
                select * from tbl_nhanVien
                where id = ?""";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID_NV);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("ID"));
                nv.setMaNV(rs.getString("maNhanvien"));
                nv.setChucVu(rs.getBoolean("chucVu"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                nv.setSdt(rs.getString("soDT"));
                nv.setEmail(rs.getString("email"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setNguoiTao(rs.getInt("nguoiTao"));
                nv.setNguoiSua(rs.getInt("nguoiSua"));
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgaySua(rs.getDate("ngaySua"));
                nv.setDeleted(rs.getBoolean("deleted"));
                return nv;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public List<NhanVien> getNVPT_ChoHoaDon() {
        sql = """
                select nv.ID , nv.hoTen from tbl_nhanVien nv
                inner join tbl_hoaDon hd on  hd.ID_nhanVien = nv.ID
                group by nv.ID , nv.hoTen""";
        List<NhanVien> listnv = new ArrayList();
        try {
            rs = JDBCHelper.query(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("ID"));
                nv.setHoTen(rs.getString("hoTen"));
                listnv.add(nv);
            }
            return listnv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_Service.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int insertNV(NhanVien nv) {
        sql = "INSERT INTO tbl_nhanVien (maNhanVien, chucVu, hoTen, gioiTinh, ngaySinh,"
                + "soDT, email, matKhau, diaChi, nguoiTao, nguoiSua, ngayTao, ngaySua, deleted) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.isChucVu());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.isGioiTinh());
            java.util.Date date = nv.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            // Chuyển đổi java.util.Date thành java.sql.Timestamp
            ps.setDate(5, sqlDate);
            ps.setObject(6, nv.getSdt());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getMatKhau());
            ps.setObject(9, nv.getDiaChi());
            ps.setObject(10, nv.getNguoiTao());
            ps.setObject(11, nv.getNguoiSua());
            java.util.Date currentDate = new java.util.Date();
            sqlDate = new java.sql.Date(currentDate.getTime());
            ps.setDate(12, sqlDate);
            ps.setObject(13, nv.getNgaySua());
            ps.setObject(14, true);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateNV(String maNV, NhanVien nv) {
        sql = "UPDATE tbl_nhanVien SET chucVu = ?, hoTen = ?, gioitinh = ?, ngaySinh = ?, soDT = ?, email= ?, diaChi = ?"
                + ", nguoiTao = ?, nguoiSua = ?, ngayTao = ?, ngaySua = ? WHERE maNhanVien = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.isChucVu());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.isGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getSdt());
            ps.setObject(6, nv.getEmail());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getNguoiTao());
            ps.setObject(9, nv.getNguoiSua());
            ps.setObject(10, nv.getNgayTao());
            ps.setObject(11, nv.getNgaySua());
            ps.setObject(12, maNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateTrangThai(String maNV, boolean isDeleted) {
        sql = "UPDATE tbl_nhanVien SET deleted = ? WHERE maNhanVien = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, isDeleted);
            ps.setObject(2, maNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public NhanVien getTT_NV_BY_ID(int idNV) {//Mạnh viết (lấy TT_NV_BY_ID ) cho bán hàng
        sql = """
                select * from tbl_nhanVien
                where id =?""";
        NhanVien nv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idNV);
            rs = ps.executeQuery();
            rs.next();//di chuyển để lấy đối obj
            nv = new NhanVien();
            nv.setId(rs.getInt("ID"));
            nv.setMaNV(rs.getString("maNhanVien"));
            nv.setChucVu(rs.getBoolean("chucVu"));
            nv.setHoTen(rs.getString("hoTen"));
            nv.setGioiTinh(rs.getBoolean("gioiTinh"));
            nv.setNgaySinh(rs.getDate("ngaySinh"));
            nv.setSdt(rs.getString("soDT"));
            nv.setEmail(rs.getString("email"));
            nv.setMatKhau(rs.getString("matKhau"));
            nv.setDiaChi(rs.getString("diaChi"));
            nv.setNguoiTao(rs.getInt("nguoiTao"));
            nv.setNguoiSua(rs.getInt("nguoiSua"));
            nv.setNgayTao(rs.getDate("ngayTao"));
            nv.setNgaySua(rs.getDate("ngaySua"));
            nv.setDeleted(rs.getBoolean("deleted"));
            return nv;
        } catch (SQLException e) {
            return null;
        }
    }
}
