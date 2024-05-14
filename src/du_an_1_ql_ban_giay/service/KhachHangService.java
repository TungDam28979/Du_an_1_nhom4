package du_an_1_ql_ban_giay.service;

import du_an_1_ql_ban_giay.model.KhachHang;
import du_an_1_ql_ban_giay.utility.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangService {

    String sql = null;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<KhachHang> getAll() {
        sql = "SELECT maKH, hoTen, gioiTinh, soDT, email, diaChi FROM [dbo].[tbl_khachHang]"
                + "where id != 1 ";
        List<KhachHang> listkh = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("maKH"), rs.getString("hoTen"), rs.getBoolean("gioiTinh"), rs.getString("soDT"), rs.getString("email"), rs.getString("diaChi"));
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH(String maKH) {
        sql = "SELECT maKH, hoTen, gioiTinh, soDT, email, diaChi FROM [dbo].[tbl_khachHang] WHERE maKH = ?";
        KhachHang kh = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString("maKH"), rs.getString("hoTen"), rs.getBoolean("gioiTinh"), rs.getString("soDT"), rs.getString("email"), rs.getString("diaChi"));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getKH_ToThemNhanhBanHang(String maKH) {//Mạnh Thêm
        sql = "SELECT id, maKH, hoTen, gioiTinh, soDT, email, diaChi FROM [dbo].[tbl_khachHang] WHERE maKH = ?";
        KhachHang kh = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setId(rs.getInt("ID"));
                kh.setMaKH(rs.getString("maKH"));
                kh.setName(rs.getString("hoTen"));
            }
            return kh;
        } catch (SQLException e) {
            return null;
        }
    }

    public KhachHang get_TTKH_In_HD(int maHD) {//Mạnh Thêm
        sql = """
              SELECT kh.id, kh.maKH, kh.hoTen, kh.gioiTinh, soDT, email, diaChi , hd.tienThua , 
              Sum( tt.soTienThanhToan) as N'tongTienTra' , hd.tongGiaTriHoaDon
              from tbl_khachHang  kh
              inner join tbl_hoaDon hd on kh.ID = hd.ID_khachHang
              inner join tbl_thanhToan tt on tt.id_hoaDon = hd.ID
              where hd.ID = ?
              group by kh.id, kh.maKH, kh.hoTen, kh.gioiTinh, soDT, email,
              diaChi , hd.tienThua , hd.tongGiaTriHoaDon
              """;
        KhachHang kh = new KhachHang();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setMaKH(rs.getString("maKH"));
                kh.setName(rs.getString("hoTen"));
                kh.setGender(rs.getBoolean("gioiTinh"));
                kh.setPhone(rs.getString("soDT"));
                kh.setEmail(rs.getString("email"));
                kh.setAddress(rs.getString("diaChi"));
                kh.setTienThua(rs.getInt("tienThua"));
                kh.setTongTienTra(rs.getInt("tongTienTra"));
                kh.setTongGTHD(rs.getInt("tongGiaTriHoaDon"));
            }
            return kh;
        } catch (SQLException e) {
            return null;
        }
    }

    public int insertKH(KhachHang kh) {
        sql = "INSERT INTO [dbo].[tbl_khachHang] (maKH, hoTen, gioiTinh, soDT, email, diaChi, nguoiTao, nguoiSua, ngayTao, ngaySua) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getName());
            ps.setObject(3, kh.isGender());
            ps.setObject(4, kh.getPhone());
            ps.setObject(5, kh.getEmail());
            ps.setObject(6, kh.getAddress());
            ps.setObject(7, kh.getCreateBy());
            ps.setObject(8, kh.getUpdateBy());
            ps.setObject(9, kh.getCreateAt());
            ps.setObject(10, kh.getUpdateAt());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateKH(KhachHang kh, String id) {
        sql = "UPDATE [dbo].[tbl_khachHang] SET hoTen = ?, gioiTinh = ?, soDT = ?, email = ?, diaChi = ? WHERE maKH = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getName());
            ps.setObject(2, kh.isGender());
            ps.setObject(3, kh.getPhone());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getAddress());
            ps.setObject(6, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<KhachHang> findIDKH(String IDKH) {
        sql = "SELECT maKH, hoTen, gioiTinh, soDT, email, diaChi FROM [dbo].[tbl_khachHang] WHERE maKH = ?";
        List<KhachHang> listkh = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, IDKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("ID"), rs.getString("HoTen"), rs.getBoolean("GioiTinh"), rs.getString("SoDT"), rs.getString("Email"), rs.getString("DiaChi"));
                listkh.add(kh);
            }
            return listkh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public KhachHang getTT_KH_BY_ID(int id) {//Mạnh Viết ( Truy ra KH từ ID ) ở bán hàng
        sql = "SELECT maKH, hoTen, gioiTinh, soDT, email, diaChi FROM [dbo].[tbl_khachHang]"
                + "where id = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);//Thiết lập tham số.
            rs = ps.executeQuery();
            KhachHang kh;
            while (rs.next()) {
                kh = new KhachHang(rs.getString("maKH"), rs.getString("hoTen"), rs.getBoolean("gioiTinh"), rs.getString("soDT"), rs.getString("email"), rs.getString("diaChi"));
                return kh;
            }
        } catch (SQLException e) {
            return null;
        }
        System.out.println("Ko tìm thấy thông tin khách hàng theo id");
        return null;

    }

}
