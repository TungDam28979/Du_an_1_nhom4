package du_an_1_ql_ban_giay.BanHangDAO;

import du_an_1_ql_ban_giay.ModelBanHang.trangThaiThanhToan;
import du_an_1_ql_ban_giay.dao.DA1_DAO;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrangThaiThanhToanDAO implements DA1_DAO<trangThaiThanhToan, String> {

    final String get_ALL_TTTT = "select * from tbl_trangThaiThanhToan";
    final String get_TTTT_By_ID = """
                                  select * from tbl_trangThaiThanhToan
                                  where id =?""";

    @Override
    public void insert(trangThaiThanhToan e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(trangThaiThanhToan e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<trangThaiThanhToan> selectAll() {
        return selectBySQL(get_ALL_TTTT);
    }

    @Override
    public trangThaiThanhToan selectById(String id) {
        List<trangThaiThanhToan> oneListTTTT = selectBySQL(get_TTTT_By_ID, id);
        if (oneListTTTT != null && !oneListTTTT.isEmpty()) {
            return oneListTTTT.get(0);
        }
        return null;
    }

    @Override
    public List<trangThaiThanhToan> selectBySQL(String sql, Object... args) {
        List<trangThaiThanhToan> listTTTT = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                trangThaiThanhToan tttt = new trangThaiThanhToan();
                tttt.setId(rs.getInt("ID"));
                tttt.setTenTrangThaiThanhToan(rs.getString("tenTrangThaiThanhToan"));
                tttt.setNguoiTao(rs.getInt("nguoiTao"));
                tttt.setNguoiSua(rs.getInt("nguoiSua"));
                tttt.setNgaySua(rs.getDate("ngaySua"));
                tttt.setNgayTao(rs.getDate("ngayTao"));
                tttt.setXoaMem(rs.getInt("xoaMem"));
                listTTTT.add(tttt);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(TrangThaiThanhToanDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn danh sách trạng thái thanh toán khi giao hàng");
        }
        return listTTTT;
    }

}
