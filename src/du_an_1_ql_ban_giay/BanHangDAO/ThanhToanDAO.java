package du_an_1_ql_ban_giay.BanHangDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import du_an_1_ql_ban_giay.model.ThanhToanModel;
import du_an_1_ql_ban_giay.utility.JDBCHelper;

public class ThanhToanDAO {

    public ThanhToanDAO() {
    }

    String sql = null;

    public int insertThanhToan(ThanhToanModel tt) {//Thực hiện insert khi thanh toán hóa đơn.
        sql = """
              insert into tbl_thanhToan ( id_hoaDon , id_HTTT , soTienThanhToan ) 
              values ( ? , ? , ? )""";
        return JDBCHelper.update(sql,
                tt.getId_hoaDon(),
                tt.getId_HTTT(),
                tt.getSoTienThanhToan()
        );
    }

    public List<ThanhToanModel> selectBySQL(String sql, Object... args) {
        List<ThanhToanModel> listTTModel = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                ThanhToanModel tt = new ThanhToanModel();
                tt.setId(rs.getInt("ID"));
                tt.setId_hoaDon(rs.getInt("id_hoaDon"));
                tt.setId_HTTT(rs.getInt("id_HTTT"));
                tt.setSoTienThanhToan(rs.getBigDecimal("soTienThanhToan"));
                listTTModel.add(tt);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HDCT_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn danh sách thanh toán");
        }
        return listTTModel;
    }
}
