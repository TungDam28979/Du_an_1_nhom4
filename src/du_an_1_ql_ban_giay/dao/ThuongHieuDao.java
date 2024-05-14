package du_an_1_ql_ban_giay.dao;

import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import du_an_1_ql_ban_giay.model.AkichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import du_an_1_ql_ban_giay.model.BchatLieu;
import du_an_1_ql_ban_giay.model.FthuongHieu;

public class ThuongHieuDao {

    String SELECT_ALL_BY_SQL = """
                               select * from tbl_ThuongHieu
                               where tbl_thuongHieu.trangThai = N'Đang áp dụng'
                               order by [ngayTao] desc""";
    //Thực hiện truy vấn thương hiệu với ngày tạo thương hiệu giảm dần ( Để cho Thương hiệu vừa tạo lên đầu ) 
    String Insert_ThuongHieu_BY_SQL = """
                                      insert into tbl_ThuongHieu ( [tenThuongHieu] , [trangThai] , nguoiTao ) 
                                      values 
                                      (?  , ? , ? )""";
    //Thêm thương hiệu với trạng thái là "Đang Áp Dụng"
    String Update_ThuongHieu_BY_SQL = """
                                      update tbl_ThuongHieu 
                                      set [tenThuongHieu] = ?, nguoiSua = ?
                                      where id = ?""";
    //Update lại thương hiệu với Tên Thuong Hiệu và trạng thái

    String DELETE_TH_BY_ID = """
                            UPDATE tbl_thuongHieu 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    //Thực hiện truy vấn tất cả thương hiệu theo ngày tạo giảm dần
    public void insert(FthuongHieu e) {
        JDBCHelper.update(Insert_ThuongHieu_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(FthuongHieu e) {
        JDBCHelper.update(Update_ThuongHieu_BY_SQL,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public List<FthuongHieu> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public int delete(int id) {
        return JDBCHelper.update(DELETE_TH_BY_ID, id);
    }

    public FthuongHieu selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<FthuongHieu> selectBySQL(String sql, Object... args) {
        List<FthuongHieu> listThuongHieu = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                FthuongHieu th = new FthuongHieu();
                th.setId(rs.getInt("id"));
                th.setName(rs.getString("tenThuongHieu"));
                th.setStatus(rs.getString("trangThai"));
                th.setCreate_by(rs.getInt("nguoiTao"));
                th.setUpdate_by(rs.getInt("nguoiSua"));
                th.setCreate_at(rs.getDate("ngayTao"));
                th.setUpdate_at(rs.getDate("ngaySua"));
                listThuongHieu.add(th);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listThuongHieu;
    }

}//end life
