package du_an_1_ql_ban_giay.dao;

import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import model.AkichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BchatLieu;

public class ChatLieuDAO {

    String SELECT_ALL_BY_SQL = """
                                select * from tbl_chatLieu
                                where tbl_chatLieu.trangThai = N'Đang áp dụng'
                               order by [ngayTao] desc""";
    String INSERT_ALL_BY_SQL = """
                               insert into tbl_ChatLieu ( TenCL , trangThai  , nguoiTao ) 
                               values 
                               ( ? , ? , ? )""";
    String UPDATE_BY_SQL = """
                           update tbl_ChatLieu
                           set TenCL = ? , nguoiSua = ?
                           where id = ? """;
    String DELETE_CL_BY_ID = """
                            UPDATE tbl_chatLieu 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    public void insert(BchatLieu e) {
        JDBCHelper.update(INSERT_ALL_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(BchatLieu e) {
        JDBCHelper.update(UPDATE_BY_SQL,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public List<BchatLieu> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public int delete(int id) {//cập nhật lại trạng thái theo id.
        return JDBCHelper.update(DELETE_CL_BY_ID, id);
    }

    public BchatLieu selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<BchatLieu> selectBySQL(String sql, Object... args) {
        List<BchatLieu> listKichCo = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                BchatLieu cl = new BchatLieu();
                cl.setId(rs.getInt("id"));
                cl.setName(rs.getString("TenCL"));
                cl.setStatus(rs.getString("trangThai"));
                cl.setCreate_by(rs.getInt("nguoiTao"));
                cl.setUpdate_by(rs.getInt("nguoiSua"));
                cl.setCreate_at(rs.getDate("ngayTao"));
                cl.setUpdate_at(rs.getDate("ngaySua"));
                listKichCo.add(cl);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKichCo;
    }

}//end life
