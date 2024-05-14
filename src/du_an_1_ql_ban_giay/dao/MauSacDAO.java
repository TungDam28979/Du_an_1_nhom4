package du_an_1_ql_ban_giay.dao;

import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import model.AkichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DmauSac;

public class MauSacDAO {

    String SELECT_ALL_BY_SQL = """
                               select * from tbl_mauSac
                                where tbl_mauSac.trangThai = N'Đang áp dụng'
                               order by [ngayTao] desc""";
    //truy vấn tất cả ms với ngày tạo giảm dần
    String Insert_MauSac_BY_SQL = """
                                  insert into tbl_MauSac ( [tenMauSac] , [trangThai] , nguoiTao ) 
                                  values 
                                  ( ? , ? , ? )""";
    String UPdate_MauSac_BY_SQL = """
                                  update tbl_MauSac
                                  set [tenMauSac] = ? , nguoiSua = ?
                                  where id = ?""";

    String DELETE_MS_BY_ID = """
                           UPDATE tbl_mauSac 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    public void insert(DmauSac e) {
        JDBCHelper.update(Insert_MauSac_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(DmauSac e) {
        JDBCHelper.update(UPdate_MauSac_BY_SQL,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public List<DmauSac> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public int delete(int id) {//cập nhật lại trạng thía theo id
        return JDBCHelper.update(DELETE_MS_BY_ID, id);
    }

    public DmauSac selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<DmauSac> selectBySQL(String sql, Object... args) {
        List<DmauSac> listMauSac = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DmauSac ms = new DmauSac();
                ms.setId(rs.getInt("id"));
                ms.setName(rs.getString("tenMauSac"));
                ms.setStatus(rs.getString("trangThai"));
                ms.setCreate_by(rs.getInt("nguoiTao"));
                ms.setUpdate_by(rs.getInt("nguoiSua"));
                ms.setCreate_at(rs.getDate("ngayTao"));
                ms.setUpdate_at(rs.getDate("ngaySua"));
                listMauSac.add(ms);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(MauSacDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMauSac;
    }

}//end life
