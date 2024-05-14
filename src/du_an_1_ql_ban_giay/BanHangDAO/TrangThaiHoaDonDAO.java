package du_an_1_ql_ban_giay.BanHangDAO;

import ModelBanHang.trangThaiHoaDon;
import java.util.ArrayList;
import java.util.List;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrangThaiHoaDonDAO {

    final String getALL_trangThaiHoaDon = "select * from tbl_trangThaiHoaDon";

    final String get_TTHD_By_ID = """
                                  select * from tbl_trangThaiHoaDon
                                  where id = ? """;

    public List<trangThaiHoaDon> selectAll() {
        return selectBySQL(getALL_trangThaiHoaDon);
    }

    public String select_TrangThaiHoaDon_ById(int id) {
        List<trangThaiHoaDon> oneListTTHD = selectBySQL(get_TTHD_By_ID, id);
        if (oneListTTHD != null && !oneListTTHD.isEmpty()) {
            return oneListTTHD.get(0).getTenTTHD();
        }
        return null;
    }

    public List<trangThaiHoaDon> selectBySQL(String sql, Object... args) {
        List<trangThaiHoaDon> listTTHD = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                trangThaiHoaDon tthd = new trangThaiHoaDon();
                tthd.setId(rs.getInt("ID"));
                tthd.setTenTTHD(rs.getString("tenTTHD"));
                tthd.setNguoiSua(rs.getInt("nguoiTao"));
                tthd.setNguoiSua(rs.getInt("nguoiSua"));
                tthd.setNgayTao(rs.getDate("ngayTao"));
                tthd.setNgaySua(rs.getDate("ngaySua"));
                tthd.setXoaMem(rs.getInt("xoaMem"));
                listTTHD.add(tthd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(TrangThaiHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn Trạng Thái Hóa Đơn ( DAO ) ");
        }

        return listTTHD;
    }

}
