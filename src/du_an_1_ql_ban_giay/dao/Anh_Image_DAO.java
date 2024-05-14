package du_an_1_ql_ban_giay.dao;

import java.util.ArrayList;
import java.util.List;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.sql.*;
import du_an_1_ql_ban_giay.model.Anh_Image;
import du_an_1_ql_ban_giay.utility.DBConnect;

public class Anh_Image_DAO implements DA1_DAO<Anh_Image, String> {

    String SELECT_ID_ANH_BY_ID_SPCT = """
                                      insert into tbl_anh ( TenAnh , TrangThai  , NguoiTao ) 
                                      values ( ? , ? , ? )""";

    @Override
    public void insert(Anh_Image e) {
        JDBCHelper.update(SELECT_ID_ANH_BY_ID_SPCT,
                e.getTenAnh(),
                e.getTrangThai(),
                e.getNguoiTao()
        );
    }

    @Override
    public void update(Anh_Image e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Anh_Image> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Anh_Image selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String SELECT_ID_ANH_BY_NAME_ANH = """
                                       select ID	, TenAnh , NguoiSua , NguoiTao
                                        from tbl_anh 
                                        where TenAnh  = ? ;""";

    public int selectIDByNameAnh(String tenAnh) {//Lấy ra id ảnh từ tên ảnh
        List<Anh_Image> listAnh = selectBySQL(SELECT_ID_ANH_BY_NAME_ANH, tenAnh);
        if (listAnh != null && !listAnh.isEmpty()) {
            return listAnh.get(0).getId();
        }
        System.out.println("không truy vấn ra được id_Anh theo tên ảnh");
        return 0;
    }

    //ID / chucVu , nguoiTao , nguoiSua , maNV , hoTen.
    @Override
    public List<Anh_Image> selectBySQL(String sql, Object... args) {
        List<Anh_Image> listProd = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Anh_Image a = new Anh_Image();
                a.setId(rs.getInt("ID"));
                a.setTenAnh(rs.getString("TenAnh"));
                a.setNguoiSua(rs.getInt("nguoiSua"));
                a.setNguoiTao(rs.getInt("nguoiTao"));
                listProd.add(a);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn danh sách Ảnh");
        }
        return listProd;
    }
}
