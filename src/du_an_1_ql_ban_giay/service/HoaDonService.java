package du_an_1_ql_ban_giay.service;

import du_an_1_ql_ban_giay.utility.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import du_an_1_ql_ban_giay.model.HoaDonKH;

public class HoaDonService {

    String sql = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<HoaDonKH> getAll() {
        sql = "SELECT diaChiNguoiNhan, (soLuong*donGia) AS N'thanhTien', ngayMuonNhanHang "
                + "FROM tbl_hoaDon JOIN tbl_hoaDonChiTiet "
                + "ON tbl_hoaDonChiTiet.ID_hoaDon = tbl_hoaDon.ID"
                + "where tbl_hoaDon.ID_trangThaiHoaDon =2 ";
        List<HoaDonKH> listhd = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonKH hd = new HoaDonKH(rs.getString("diaChiNguoiNhan"), rs.getDouble("thanhTien"), rs.getDate("ngayMuonNhanHang"));
                listhd.add(hd);
            }
            return listhd;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<HoaDonKH> getHD(int idKH) {
        sql = ""
                + "SELECT diaChiNguoiNhan, (soLuong*donGia) AS N'thanhTien', ngayMuonNhanHang "
                + "FROM tbl_hoaDon JOIN tbl_hoaDonChiTiet "
                + "ON tbl_hoaDonChiTiet.ID_hoaDon = tbl_hoaDon.ID"
                + " WHERE ID_khachHang = ?";
        List<HoaDonKH> listhd = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonKH hd = new HoaDonKH(rs.getString("diaChiNguoiNhan"), rs.getDouble("thanhTien"), rs.getDate("ngayMuonNhanHang"));
                listhd.add(hd);
            }
            return listhd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
