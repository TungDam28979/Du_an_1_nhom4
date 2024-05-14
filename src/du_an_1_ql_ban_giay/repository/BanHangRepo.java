/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.repository;

import du_an_1_ql_ban_giay.model.BanHang;
import du_an_1_ql_ban_giay.utility.DBConnect;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class BanHangRepo {
  public ArrayList<BanHang> getsanpham() {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String getsp = """
                           select sp.ID,tg.tenGiay,th.tenThuongHieu,kc.kichCo,ms.tenMauSac,sp.soLuong,sp.giaBan from tbl_spct as sp 
                           join tbl_tenGiay as tg on sp.ID_tenGiay=tg.ID
                           join tbl_thuongHieu as th on sp.ID_thuongHieu = th.id
                           join tbl_kichCo as kc on sp.ID_kichCo=kc.ID
                           join tbl_mauSac as ms on sp.ID_mauSac=ms.ID""";
            PreparedStatement ps = con.prepareStatement(getsp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setIdsanpham(rs.getInt(1));
                bh.setTensp(rs.getString(2));
                bh.setThuonghieusp(rs.getString(3));
                bh.setSizesp(rs.getInt(4));
                bh.setMausp(rs.getString(5));
                bh.setSoluong(rs.getInt(6));
                bh.setGiasp(rs.getBigDecimal(7));
                list.add(bh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
<<<<<<< HEAD

    public ArrayList<BanHang> getmasanpham(int ma) {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String get = """
                         select tg.tenGiay,th.tenThuongHieu,kc.kichCo,ms.tenMauSac,sp.giaBan from tbl_spct as sp 
                         join tbl_tenGiay as tg on sp.ID_tenGiay=tg.ID
                         join tbl_thuongHieu as th on sp.ID_thuongHieu = th.id
                         join tbl_kichCo as kc on sp.ID_kichCo=kc.ID
                         join tbl_mauSac as ms on sp.ID_mauSac=ms.ID where sp.ID = ?""";
            PreparedStatement ps = con.prepareStatement(get);
            ps.setInt(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setTensp(rs.getString(1));
                bh.setThuonghieusp(rs.getString(2));
                bh.setSizesp(rs.getInt(3));
                bh.setMausp(rs.getString(4));
                bh.setGiasp(rs.getBigDecimal(5));
                list.add(bh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int taodon() {
        BanHang bh = new BanHang();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO tbl_HOADON(Trangthai,Ngaytao) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setDate(2, new Date(new java.util.Date().getTime()));
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Map<String, Object> getIdNT() {
        try {
            Map map = new HashMap();
            Connection con = DBConnect.getConnection();
            String sql = """
                         SELECT TOP 1 id, ngaytao
                         FROM tbl_hoaDon
                         ORDER BY id DESC""";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setIdhoadon(rs.getInt(1));
                bh.setNgaytao(rs.getDate(2));
                map.put("ma", rs.getInt(1));
                map.put("ngaytao", rs.getDate(2));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public ArrayList<BanHang> getphieugiamgia() {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "Select phieugiamgia, giatri from tbl_voucher";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setPhieugiamgia(rs.getString(1));
                bh.setGiatriphieugiamgia(rs.getFloat(2));
                list.add(bh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Float getgiatrigiamgia(String tenvoucher) {

        try {
            Connection con = DBConnect.getConnection();
            String sql = "select giatri from tbl_voucher where phieuGiamGia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenvoucher);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getFloat(1);
            }
            return null;
        } catch (Exception e) {
            System.out.println("cc");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BanHang> timkiemsp(String key) {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String get1 = """
                          select sp.ID,tg.tenGiay,th.tenThuongHieu,kc.kichCo,ms.tenMauSac,sp.soLuong,sp.giaBan from tbl_spct as sp 
                          join tbl_tenGiay as tg on sp.ID_tenGiay=tg.ID
                          join tbl_thuongHieu as th on sp.ID_thuongHieu = th.id
                          join tbl_kichCo as kc on sp.ID_kichCo=kc.ID
                          join tbl_mauSac as ms on sp.ID_mauSac=ms.ID 
                          where sp.ID= ? """;
            PreparedStatement ps = con.prepareStatement(get1);
            ps.setInt(1, Integer.parseInt(key));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh1 = new BanHang();
                bh1.setIdsanpham(rs.getInt(1));
                bh1.setTensp(rs.getString(2));
                bh1.setThuonghieusp(rs.getString(3));
                bh1.setSizesp(rs.getInt(4));
                bh1.setMausp(rs.getString(5));
                bh1.setSoluong(rs.getInt(6));
                bh1.setGiasp(rs.getBigDecimal(7));
                list.add(bh1);
            }

        } catch (Exception e) {
            try {
                Connection con = DBConnect.getConnection();
                String get2 = """
                              select sp.ID,tg.tenGiay,th.tenThuongHieu,kc.kichCo,ms.tenMauSac,sp.soLuong,sp.giaBan from tbl_spct as sp 
                              join tbl_tenGiay as tg on sp.ID_tenGiay=tg.ID
                              join tbl_thuongHieu as th on sp.ID_thuongHieu = th.id
                              join tbl_kichCo as kc on sp.ID_kichCo=kc.ID
                              join tbl_mauSac as ms on sp.ID_mauSac=ms.ID 
                              where tg.tenGiay like ? """;
                PreparedStatement ps = con.prepareStatement(get2);
                ps.setString(1, "%" + key + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    BanHang bh2 = new BanHang();
                    bh2.setIdsanpham(rs.getInt(1));
                    bh2.setTensp(rs.getString(2));
                    bh2.setThuonghieusp(rs.getString(3));
                    bh2.setSizesp(rs.getInt(4));
                    bh2.setMausp(rs.getString(5));
                    bh2.setSoluong(rs.getInt(6));
                    bh2.setGiasp(rs.getBigDecimal(7));
                    list.add(bh2);
                }
            } catch (Exception p) {
                p.printStackTrace();

            }
        }
        return list;
    }

    public ArrayList<BanHang> getcboThuonghieu() {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "Select tenThuongHieu from tbl_thuongHieu";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setThuonghieusp(rs.getString(1));
                list.add(bh);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BanHang> getthuonghieu(String tenth) {
        ArrayList<BanHang> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String sql = """
                         select sp.ID,tg.tenGiay,th.tenThuongHieu,kc.kichCo,ms.tenMauSac,sp.soLuong,sp.giaBan from tbl_spct as sp 
                                                 join tbl_tenGiay as tg on sp.ID_tenGiay=tg.ID
                                                 join tbl_thuongHieu as th on sp.ID_thuongHieu = th.id
                                                 join tbl_kichCo as kc on sp.ID_kichCo=kc.ID
                                                 join tbl_mauSac as ms on sp.ID_mauSac=ms.ID 
                                                 where th.tenThuongHieu = ? """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tenth);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BanHang bh = new BanHang();
                bh.setIdsanpham(rs.getInt(1));
                bh.setTensp(rs.getString(2));
                bh.setThuonghieusp(rs.getString(3));
                bh.setSizesp(rs.getInt(4));
                bh.setMausp(rs.getString(5));
                bh.setSoluong(rs.getInt(6));
                bh.setGiasp(rs.getBigDecimal(7));
                list.add(bh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean AddDetailBill(int BillId, int ProductId, int quantity) {

        try {
            BigDecimal price = BigDecimal.ZERO;
            String sql1 = "select giaBan from tbl_spct where tbl_spct.ID = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, ProductId);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                price = rs.getBigDecimal(1);
            }

            String sql = "insert into tbl_hoaDonChiTiet(ID_hoaDon, ID_sanPham, soLuong, donGia) values (?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, BillId);
            ps.setInt(2, ProductId);
            ps.setInt(3, quantity);
            ps.setBigDecimal(4, price);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
=======
>>>>>>> 12bff6c2505223ff31948d4d495c4aa776698a1b
  
}
