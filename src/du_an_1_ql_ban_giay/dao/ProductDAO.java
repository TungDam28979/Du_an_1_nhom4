/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.dao;

import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import du_an_1_ql_ban_giay.model.GtenGiay;

/**
 *
 * @author Tran Viet Vuong
 */
public class ProductDAO {
    String Count_SoBanGhiAllSP = """
                            SELECT COUNT(*) AS SoLuongBanGhi
                            from tbl_tenGiay""";

    public int getSoBanGhiAllSP() {
        try {
            ResultSet rs = JDBCHelper.query(Count_SoBanGhiAllSP);
            rs.next();
            return rs.getInt("SoLuongBanGhi");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    String getTop5SP = """
                       select * from tbl_tenGiay 
                       order by ngayTao desc
                       OFFSET  (  (?*5) - 5 )  
                       rows fetch next 5 rows only
                   """;

    //Thực hiện truy vấn top 5 sản phẩm dựa theo số trang và ngày tạo giảm dần
    public List<GtenGiay> getTop5SP(int trang) {
        return selectBySQL(getTop5SP, trang);
    }

    //Đếm số trang dựa theo trạng thái
    String CountSoBanGhi_DuaVaoTrangThai = """
                                           SELECT COUNT(*) AS SoLuongBanGhi
                                           from tbl_tenGiay
                                           where trangThai = ?;""";

    public int countSoBanGhi(String trangThai) {//truy vấn số bản ghi cho cả 2 trạng thái
        try {
            ResultSet rs = JDBCHelper.query(CountSoBanGhi_DuaVaoTrangThai, trangThai);
            rs.next();
            return rs.getInt("SoLuongBanGhi");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //------------Truy vấn top 5 sản phẩm với ngày tạo giảm dần
    String selectTop5SPtheoTrangThai = """
                                       select * from tbl_tenGiay
                                       where trangThai = ?
                                       order by ngayTao desc
                                       OFFSET  (  (?*5) - 5 )  
                                       rows fetch next 5 rows only""";

    //Thực hiện truy vấn top 5 sản phẩm dựa theo số trang và ngày tạo giảm dần
    public List<GtenGiay> getTop5SPTheoTrangThai(String trangThai, int trang) {
        return selectBySQL(selectTop5SPtheoTrangThai, trangThai, trang);
    }

    //------Để khi update SP thì nó đc lên đâu và về trang 1. 
    String selectTop5_SP_TheoTimeUpdate_GiamDan = """
                            select * from tbl_tenGiay
                            where trangThai = ?                      
                            order by ngaySua desc
                            OFFSET  (  (?*5) - 5 )  
                            rows fetch next 5 rows only""";

    public List<GtenGiay> selectTop5_SP_TheoTimeUpdate_GiamDan(String trangThai, int trang) {
        return selectBySQL(selectTop5_SP_TheoTimeUpdate_GiamDan, trangThai, trang);
    }

    //----------Dùng truy vấn tên SP cho lên combobox.
    String SELECT_ALL_SP_BY_SQL = """ 
                                  select * from tbl_TenGiay\t tg
                                  order by tg.[ngayTao] desc;""";
    // Truy vấn tất cả tên SP dựa theo giảm dần của TG tạo ra SP.

    String SELECT_SP_TrangThai_DangKinhDoanh__BY_SQL = """
                               SELECT tg.id, tg.TenGiay, COUNT(spct.id) as SoLuongSPCT, tg.[trangThai],
                                tg.[NguoiTao], tg.nguoiSua, tg.[ngayTao], tg.ngaySua
                                FROM tbl_TenGiay tg
                                LEFT JOIN tbl_SPCT spct ON tg.id = spct.id_TenGiay
                                GROUP BY tg.id, tg.TenGiay, tg.[trangThai], tg.[NguoiTao], tg.nguoiSua, tg.[ngayTao], tg.ngaySua
                                Having 	tg.trangThai = N'Đang Kinh Doanh'
                                ORDER BY SoLuongSPCT desc   """;
    //Truy vấn bảng SP CÓ SL_SPCT với ngày tạo giảm dần.

    String SELECT_TENSP_TrangThai_DungKinhDoanh_By_SQL = """
                    SELECT tg.id, tg.TenGiay, COUNT(spct.id) as SoLuongSPCT, tg.[trangThai],
                    tg.[NguoiTao], tg.nguoiSua, tg.[ngayTao], tg.ngaySua
                    FROM tbl_TenGiay tg
                    LEFT JOIN tbl_SPCT spct ON tg.id = spct.id_TenGiay
                    GROUP BY tg.id, tg.TenGiay, tg.[trangThai], tg.[NguoiTao], tg.nguoiSua, tg.[ngayTao], tg.ngaySua
                    Having \ttg.trangThai = N'D\u1eebng Kinh Doanh'
                    ORDER BY SoLuongSPCT desc;""";
    //Truy vấn bảng SP CÓ TRẠNG THÁI "Dừng Kinh Doanh" với ngày tạo giảm dẩn

    String SELECT_TENSP_GIAMDAN_CreateAt_SPCT = """
                                               SELECT tg.id, tg.tenGiay, COUNT(spct.id) AS SoLuongSPCT , tg.trangThai , tg.ngayTao , tg.nguoiTao , tg.ngaySua , tg.nguoiSua
                                               FROM tbl_TenGiay tg
                                               LEFT JOIN tbl_SPCT spct ON tg.id = spct.id_TenGiay
                                               GROUP BY tg.id, tg.tenGiay , tg.trangThai , tg.ngayTao , tg.nguoiTao , tg.ngaySua , tg.nguoiSua
                                               ORDER BY ngayTao DESC""";
    //Truy vấn tên SP có NGÀY TẠO ra  SPCT giảm dần

    String SELECT_TENSP_GIAMDAN_SL_SPCT = """
        SELECT tg.id, tg.tenGiay, COUNT(spct.id) AS SoLuongSPCT , tg.trangThai , tg.ngayTao , tg.nguoiTao , tg.ngaySua , tg.nguoiSua
        FROM tbl_TenGiay tg
        LEFT JOIN tbl_SPCT spct ON tg.id = spct.id_TenGiay
        GROUP BY tg.id, tg.tenGiay , tg.trangThai , tg.ngayTao , tg.nguoiTao , tg.ngaySua , tg.nguoiSua
        ORDER BY SoLuongSPCT DESC;""";
    //Truy vấn tên SP có số lượng SPCT giảm dần

    String SELECT_SP_BY_ID = """
                             select * from tbl_TenGiay
                             where id = ?""";
    //Thực hiện truy vấn Tên SP theo id sản phẩm.

    String INSERT_SP_SQL = """
                           insert into tbl_TenGiay (  tenGiay , [trangThai] , nguoiTao , ngaySua    )
                           values \t( ? , ? , ? , ? )""";
    //Insert tên sản phẩm ở bảng sản phẩm ( Tên SP / Trạng Thái / Người Tạo

    String UPDATE_SP_BY_ID = """
                             UPDATE [dbo].[tbl_TenGiay]
                              SET 
                                tenGiay = ?,
                              	trangThai = ? ,
                              	nguoiSua = ?,
                                ngaySua = ?
                              WHERE ID = ?  ;""";
    //Thực hiện UPDATE SP.

    String SELECT_SL_SPCT_BY_IDSP = """
                                     SELECT
                                    tg.id AS id_TenGiay,
                                    tg.tenGiay ,
                                    tg.trangThai ,
                                    COUNT(sp.id) AS SoLuongSPChiTiet 
                                    FROM
                                    tbl_TenGiay tg
                                    LEFT JOIN
                                    tbl_SPCT sp ON tg.id = sp.id_TenGiay
                                    where tg.id =  ? and sp.xoaMem = 0
                                    GROUP BY
                                    tg.id, tg.tenGiay, tg.trangThai  """;
    //Thực hiện truy vấn số lượng SPCT của giày dựa vào tham số truyền vào : Phục vụ cho việc fill SL của Sản Phẩm khi đổ dữ liệu lên bảng

    String SELECT_Create_Update_By_ID_tenSP = """
                                              SELECT tg.[tenGiay],
                                                     tg.[trangThai],
                                                     ngTao.[hoTen] AS [nguoiTao],
                                                     ngSua.[hoTen] AS [nguoiSua],
                                                     tg.[ngayTao],
                                                     tg.[ngaySua]
                                              FROM [dbo].[tbl_tenGiay] tg
                                              LEFT JOIN [dbo].[tbl_nhanVien] ngTao ON tg.[nguoiTao] = ngTao.[ID]
                                              LEFT JOIN [dbo].[tbl_nhanVien] ngSua ON tg.[nguoiSua] = ngSua.[ID]
                                              WHERE tg.[ID] = ?;
                                           """;
    //Thực hiện truy vấn ra 1 người tạo , người sửa dựa vào ID cuar 1 Sản Phẩm truyền vào.

    //Thực hiện đếm số bản ghi của bảng sản phẩm.
    public GtenGiay getCreate_Update_By_ID_tenSP(int idSP) {
        try {
            //Thực hiện truy vấn ra 1 spct có tên người tạo/sửa dựa vào ID của giày.
            ResultSet rs = JDBCHelper.query(SELECT_Create_Update_By_ID_tenSP, idSP);
            while (rs.next()) {
                GtenGiay pd = new GtenGiay();
//                pd.setId(rs.getInt("ID"));
                pd.setName(rs.getString("tenGiay"));
                pd.setStatus(rs.getString("trangThai"));
                pd.setCreateByString(rs.getString("nguoiTao"));
                pd.setUpdateByString(rs.getString("nguoiSua"));
                pd.setCreate_At(rs.getDate("ngayTao"));
                pd.setUpdate_At(rs.getDate("ngaySua"));
                return pd;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn người tạo/sửa sản phẩm.");
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null; //Là ko có sp có id_SP ntn.
    }

    public int insert(GtenGiay e) {
        return JDBCHelper.update(INSERT_SP_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_By(), //Người tạo
                e.getUpdate_At() //Ngày update = null                
        );
    }

    public int update(GtenGiay e) {
        return JDBCHelper.update(UPDATE_SP_BY_ID,
                e.getName(),
                e.getStatus(),
                e.getUpdate_By(),
                e.getUpdate_At(),
                e.getId()
        );
    }

    public int updateTest(GtenGiay e) {
        return JDBCHelper.update(UPDATE_SP_BY_ID,
                e.getName(),
                e.getStatus(),
                e.getUpdate_By(),
                e.getId()
        );
    }

    public void delete(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //truy vấn tất cả Tên SP
    public List<GtenGiay> selectAll() {
        return selectBySQL(SELECT_ALL_SP_BY_SQL);
    }

    //Truy vấn tên SP với ngày tạo giảm dần
    public List<GtenGiay> select_TenSP_Create_at_GiamDan() {
        return selectBySQL(SELECT_TENSP_GIAMDAN_CreateAt_SPCT);
    }

    //Truy vấn tên SP với SL giảm dần
    public List<GtenGiay> select_TenSP_SL_GiamDan() {
        return selectBySQL(SELECT_TENSP_GIAMDAN_SL_SPCT);
    }

    public GtenGiay selectById(String id) {
        List<GtenGiay> listTG = selectBySQL(SELECT_SP_BY_ID, id);
        if (!listTG.isEmpty()) {
            return listTG.get(0);
        }
        return null;
    }
    int i = 0;

    //Truy vấn số lượng SPCT của SP dựa theo id.
    public int select_SL_SPCT_By_IDTenGiay(int id) {
        try {
            ResultSet rs = JDBCHelper.query(SELECT_SL_SPCT_BY_IDSP, id);
            if (rs.next()) {//Cần di chuyển đến dòng mới để lấy dữ liệu
                return rs.getInt("SoLuongSPChiTiet");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;//còn ko có bản ghi thì so có SL SPCT
    }

    //truy vấn tất cả Tên SP ko có SPCT
    public List<GtenGiay> select_TenSP_CoTrangThai_DungKinhDoanh_BY_SQL() {
        return selectBySQL(SELECT_TENSP_TrangThai_DungKinhDoanh_By_SQL);
    }

    //truy vấn tất cả Tên SP có trạng đang kinh doanh với SL giảm dần
    public List<GtenGiay> select_TenSP_CoTrangThai_DangKinhDoanh_BY_SQL() {
        return selectBySQL(SELECT_SP_TrangThai_DangKinhDoanh__BY_SQL);
    }

    public List<GtenGiay> selectBySQL(String sql, Object... args) {
        List<GtenGiay> listProd = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                GtenGiay pd = new GtenGiay();
                pd.setId(rs.getInt("ID"));
                pd.setName(rs.getString("tenGiay"));
                pd.setStatus(rs.getString("trangThai"));
                pd.setCreate_By(rs.getInt("nguoiTao"));
                pd.setUpdate_By(rs.getInt("nguoiSua"));
                pd.setCreate_At(rs.getDate("ngayTao"));
                pd.setUpdate_At(rs.getDate("ngaySua"));
                listProd.add(pd);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("Lỗi truy vấn danh sách Sản Phẩm");
        }
        return listProd;
    }
    
}
