package du_an_1_ql_ban_giay.dao;

import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import model.AkichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HdeGiay;
public class DeGiayDao {

    String SELECT_ALL_BY_SQL = """
                                select * from tbl_deGiay
                                where tbl_deGiay.trangThai = N'Đang áp dụng'
                               order by [ngayTao] desc""";
    String Insert_DeGiay_BY_SQL = """
                                 insert into tbl_DeGiay ( [loaiDeGiay]  , [trangThai] , nguoiTao ) 
                                  values 
                                  ( ? , ? , ? )""";
    String Update_DeGiay_BY_SQL = """
                                  update tbl_DeGiay
                                  set [loaiDeGiay] = ? , nguoiSua = ?
                                  where id = ?""";
    String DELETE_DeGiay_BY_ID = """
                             UPDATE tbl_deGiay 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    public void insert(HdeGiay e) {
        JDBCHelper.update(Insert_DeGiay_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(HdeGiay e) {
        JDBCHelper.update(Update_DeGiay_BY_SQL,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public int delete(int id) {
        return JDBCHelper.update(DELETE_DeGiay_BY_ID, id);
    }

    public List<HdeGiay> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public HdeGiay selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HdeGiay> selectBySQL(String sql, Object... args) {
        List<HdeGiay> listDeGiay = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HdeGiay dg = new HdeGiay();
                dg.setId(rs.getInt("id"));
                dg.setName(rs.getString("loaiDeGiay"));
                dg.setStatus(rs.getString("trangThai"));
                dg.setCreate_by(rs.getInt("nguoiTao"));
                dg.setUpdate_by(rs.getInt("nguoiSua"));
                dg.setCreate_at(rs.getDate("ngayTao"));
                dg.setUpdate_at(rs.getDate("ngaySua"));
                listDeGiay.add(dg);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DeGiayDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDeGiay;
    }

}//end life
