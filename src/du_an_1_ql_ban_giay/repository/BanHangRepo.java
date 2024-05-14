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
  
}
