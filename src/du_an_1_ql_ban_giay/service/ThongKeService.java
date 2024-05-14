/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.service;

import du_an_1_ql_ban_giay.model.ThongKe;
import du_an_1_ql_ban_giay.utility.DBConnect;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author cuong
 */
public class ThongKeService {
     String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<ThongKe> getAll() {
        sql = "SELECT ID_sanPhamChiTiet, s.giaban,h.soluong,donGia\n" +
"FROM tbl_hoaDonChiTiet h\n" +
"JOIN tbl_spct s ON h.ID_sanPhamChiTiet = s.id where xoamem = 0;";
        List<ThongKe> listsv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // ps.setObject(1, deleted);
            rs = ps.executeQuery();

            while (rs.next()) {
                ThongKe x = new ThongKe(rs.getInt(1), rs.getBigDecimal(2), rs.getInt(3), rs.getBigDecimal(4));
                listsv.add(x);
            }
            return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public List<ThongKe> spbanchaynhat() {
        sql = "SELECT ID_sanPhamChiTiet, s.giaban,h.soluong,donGia\n" +
"FROM tbl_hoaDonChiTiet h\n" +
"JOIN tbl_spct s ON h.ID_sanPhamChiTiet = s.id where xoamem = 0 order by h.soLuong desc;";
        List<ThongKe> listsv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // ps.setObject(1, deleted);
            rs = ps.executeQuery();

            while (rs.next()) {
                ThongKe x = new ThongKe(rs.getInt(1), rs.getBigDecimal(2), rs.getInt(3), rs.getBigDecimal(4));
                listsv.add(x);
            }
            return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
         public List<ThongKe> spbancham() {
        sql = "SELECT ID_sanPhamChiTiet, s.giaban,h.soluong,donGia\n" +
"FROM tbl_hoaDonChiTiet h\n" +
"JOIN tbl_spct s ON h.ID_sanPhamChiTiet = s.id where xoamem = 0 order by h.soLuong asc;";
        List<ThongKe> listsv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // ps.setObject(1, deleted);
            rs = ps.executeQuery();

            while (rs.next()) {
                ThongKe x = new ThongKe(rs.getInt(1), rs.getBigDecimal(2), rs.getInt(3), rs.getBigDecimal(4));
                listsv.add(x);
            }
            return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
