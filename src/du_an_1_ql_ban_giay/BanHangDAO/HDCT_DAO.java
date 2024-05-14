package du_an_1_ql_ban_giay.BanHangDAO;

import ModelBanHang.HDCTBanHang;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HDCT_DAO {

    String get_ID_HDCT_BY_ID_HD_And_SPCT = """
       select * from tbl_hoaDonChiTiet
       where ID_hoaDon = ? and ID_sanPhamChiTiet = ?""";//Lấy ra ID_HĐCT theo ID_HĐ vs ID_SPCT.

    public int get_ID_HDCT_BY_ID_HD_And_SPCT(int ID_HĐ, int ID_SPCT) {
        try {
            ResultSet rs = JDBCHelper.query(get_ID_HDCT_BY_ID_HD_And_SPCT, ID_HĐ, ID_SPCT);
            rs.next();
            return rs.getInt("ID"); //Lấy ra ID_HĐCT
        } catch (SQLException ex) {
            Logger.getLogger(HDCT_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ko truy ra đc ID_HĐCT theo ID_HĐ vs ID_SPCT");
        return 0;
    }

    String get_TongGTHD_IN_Table_HDCT_BY_ID_HD = """
     select sum( hdct.donGia ) as N'tongGiaTriHoaDon' 
     from tbl_hoaDon hd
     inner join tbl_hoaDonChiTiet  hdct on hd.ID = hdct.ID_hoaDon
     where hd.ID = ?""";

    public BigDecimal get_TongGTHD_IN_Table_HDCT_BY_ID_HD(int idHD) {//Lấy ra tổng giá trị hóa đơn để cập nhật cho SP.
        try {
            ResultSet rs = JDBCHelper.query(get_TongGTHD_IN_Table_HDCT_BY_ID_HD, idHD);
            rs.next();
            return rs.getBigDecimal("tongGiaTriHoaDon");
        } catch (SQLException ex) {
            Logger.getLogger(HDCT_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ko lấy đc tổng GTHĐ của Hóa Đơn ( HĐCT_DAO )");
        return null;
    }
    String getTT_HDCT_Fill_GioHang_By_ID_HD = """
      select * from tbl_hoaDonChiTiet hdct
      inner join tbl_hoaDon hd on hdct.ID_hoaDon = hd.ID
      where hd.ID = ? """;

    //Lấy tất cả thông tin HĐCT theo ID_HĐ fill lên giỏ hàng
    public List<HDCTBanHang> getTT_HDCT_Fill_GioHang_By_ID_HD(int idHD) {
        return selectBySQL(getTT_HDCT_Fill_GioHang_By_ID_HD, idHD);
    }

    //Lấy SL spct theo id để update SL
    String getSL_SPCT_IN_HĐCT_ToUpdate = """
           select * from tbl_hoaDonChiTiet
           where id = ?""";

    public int getSL_SPCT_IN_HĐCT(int id_HĐCT) {
        List<HDCTBanHang> listHDCT = selectBySQL(getSL_SPCT_IN_HĐCT_ToUpdate, id_HĐCT);
        int SL_SPCT = listHDCT.get(0).getSoLuongSP();
        return SL_SPCT;
    }

    //chek xem trong HDDCT có spct này chưa.
    String check_ID_SPCT_exists_on_HDCT = """
                                         select * from tbl_hoaDonChiTiet
                                          where ID_hoaDon = ? and ID_sanPhamChiTiet = ?""";
    String insert_HĐCT = """
                         insert tbl_hoaDonChiTiet ( ID_hoaDon , ID_sanPhamChiTiet ,soLuong , giaTienTra , donGia ) 
                         values (? , ? , ? , ? , ?)""";

    String update_HĐCT = """
                         update tbl_hoaDonChiTiet 
                         set soLuong = ?  , donGia = ?
                         where ID = ?""";//Update SL , thành tiền của HĐCT theo id_HĐCT

    public int insert(HDCTBanHang e) {
        return JDBCHelper.update(insert_HĐCT,
                e.getId_hd(),
                e.getId_ctsp(),
                e.getSoLuongSP(),
                e.getGiaTienTra(),
                e.getDonGia()
        );
    }

    public int update(HDCTBanHang e) {//Thêm SPCT --> update lại SL + giá tiền trả.
        return JDBCHelper.update(update_HĐCT,
                e.getSoLuongSP(),
                e.getDonGia(),//= giá bán SP * SL 
                e.getId()
        );
    }
    String delete_HDCT_By_ID_HD = """
                                  delete tbl_hoaDonChiTiet
                                  where ID_hoaDon = ?
                               """;
    String delete_HDCT_By_ID_SPCT = """
                                 delete tbl_hoaDonChiTiet
                                    where ID_sanPhamChiTiet = ?
                               """;

    public int delete_HDCT_By_ID_HD(int id_HD) {
        return JDBCHelper.update(delete_HDCT_By_ID_HD, id_HD);
    }

    public int delete_HDCT_By_ID_SPCT(int id_SPCT) {
        return JDBCHelper.update(delete_HDCT_By_ID_SPCT, id_SPCT);
    }

    public List<HDCTBanHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public HDCTBanHang check_TonTai_HĐCT_By_IDHĐ_ID_SPCT(int maHD, int maSPCT) {
        List<HDCTBanHang> listHDCT = selectBySQL(check_ID_SPCT_exists_on_HDCT, maHD, maSPCT);
        if (listHDCT != null && !listHDCT.isEmpty()) {
            return listHDCT.get(0);
        } else {
            return null;
        }
    }

    public List<HDCTBanHang> selectBySQL(String sql, Object... args) {
        List<HDCTBanHang> listHDCT = new ArrayList<>();

        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HDCTBanHang hdct = new HDCTBanHang();
                hdct.setId(rs.getInt("ID"));
                hdct.setId_hd(rs.getInt("ID_hoaDon"));
                hdct.setId_ctsp(rs.getInt("ID_sanPhamChiTiet"));
                hdct.setSoLuongSP(rs.getInt("soLuong"));
                hdct.setGiaTienTra(rs.getBigDecimal("giaTienTra"));
                hdct.setDonGia(rs.getBigDecimal("donGia"));
                listHDCT.add(hdct);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HDCT_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn danh sách HĐCT");
        }
        return listHDCT;
    }

}
