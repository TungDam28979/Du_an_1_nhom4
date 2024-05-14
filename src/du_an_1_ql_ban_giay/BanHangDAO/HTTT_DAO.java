package du_an_1_ql_ban_giay.BanHangDAO;

import ModelBanHang.hinhThucThanhToan;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTT_DAO {

    String getALL_HTTT = "select * from tbl_hinhThucThanhToan";

    public void insert(hinhThucThanhToan e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void update(hinhThucThanhToan e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<hinhThucThanhToan> selectAll_HTTT() {
        List<hinhThucThanhToan> listHTTT = selectBySQL(getALL_HTTT);
        if (listHTTT != null && !listHTTT.isEmpty()) {
            return selectBySQL(getALL_HTTT);
        } else {
            System.out.println("Lỗi truy vấn ra tất cả hình thức thanh toán.");
            return null;
        }
    }

    public hinhThucThanhToan selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<hinhThucThanhToan> selectBySQL(String sql, Object... args) {
        List<hinhThucThanhToan> listHTTT = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                hinhThucThanhToan hhtt = new hinhThucThanhToan();
                hhtt.setId_HTTT(rs.getInt("ID_HTTT"));//id hình thức thanh toán
                hhtt.setTenHinhThucThanhToan(rs.getString("tenHinhThucThanhToan"));
                hhtt.setMoTa(rs.getString("moTa"));
                hhtt.setTrangThai(rs.getInt("trangThai"));//Đang áp dụng/Dừng áp dụng
                hhtt.setNguoiSua(rs.getInt("nguoiTao"));
                hhtt.setNguoiSua(rs.getInt("nguoiSua"));
                hhtt.setNgayTao(rs.getDate("ngayTao"));
                hhtt.setNgaySua(rs.getDate("ngaySua"));
                listHTTT.add(hhtt);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(TrangThaiHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn hình thức thanh toán ( DAO ) ");
        }
        return listHTTT;
    }

}
