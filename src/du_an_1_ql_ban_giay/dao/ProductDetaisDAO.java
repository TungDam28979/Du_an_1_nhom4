package du_an_1_ql_ban_giay.dao;

<<<<<<< HEAD
import du_an_1_ql_ban_giay.model.Ispct;
import du_an_1_ql_ban_giay.model.IspctInsert;
=======
>>>>>>> 12bff6c2505223ff31948d4d495c4aa776698a1b
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
=======
import model.Ispct;
import model.IspctInsert;
>>>>>>> 12bff6c2505223ff31948d4d495c4aa776698a1b

public class ProductDetaisDAO {

    String updateSL_Ton_When_Insert_HDCT = """
                                             update tbl_spct
                                             set soLuong = ?
                                             where id = ?""";

    public int updateSL_Ton_When_Insert_HDCT(int id, int SLupdate) {
        return JDBCHelper.update(updateSL_Ton_When_Insert_HDCT, SLupdate, id);
    }//Cập nhật lại SL SPCT khi inset HĐCT.

    //Thực hiện đếm số bản ghi của SPCT dựa theo tên SP mà chưa bị xóa.
    String Count_So_Ban_Ghi_Cua_SPCT = """
   SELECT COUNT(*) AS SoLuongBanGhi
   FROM tbl_spct
   WHERE ID_tenGiay = (SELECT ID FROM tbl_tenGiay WHERE tenGiay = ? ) and tbl_spct.xoaMem = 0 ;""";

    public int getCountDB_SPCT_ByNameSP(String nameSPCT) {
        try {
            //Thực hiện truy vấn ra 5 đối tượng dựa vào số trang nào.
            ResultSet rs = JDBCHelper.query(Count_So_Ban_Ghi_Cua_SPCT, nameSPCT);
            rs.next();
            return rs.getInt("SoLuongBanGhi");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;//Số bản ghi là 0 khi không có SPCT cho đối tượng SP này.
    }

    //Thực hiện lấy 5 đối tượng dựa theo trang đang được chọn
    String get5ObjectToTrang = """
    SELECT spct.id, tbl_TenGiay.tenGiay, tbl_ThuongHieu.tenThuongHieu, tbl_ChatLieu.TenCL,
           tbl_Anh.TenAnh, spct.xoaMem, tbl_DayGiay.TenDayGiay, tbl_DeGiay.loaiDeGiay,
           tbl_KichCo.kichCo, tbl_MauSac.tenMauSac, spct.soLuong, spct.giaBan,
           spct.moTa, spct.QRcode, spct.[trangThai], spct.[nguoiTao], spct.[nguoiSua],
           spct.[ngayTao], spct.[ngaySua]
    FROM tbl_SPCT spct
    INNER JOIN tbl_ThuongHieu ON spct.id_ThuongHieu = tbl_ThuongHieu.id
    INNER JOIN tbl_ChatLieu ON spct.id_ChatLieu = tbl_ChatLieu.id
    INNER JOIN tbl_DayGiay ON spct.id_DayGiay = tbl_DayGiay.id 
    INNER JOIN tbl_DeGiay ON spct.id_DeGiay = tbl_DeGiay.id
    INNER JOIN tbl_KichCo ON spct.id_KichCo = tbl_KichCo.id
    INNER JOIN tbl_MauSac ON spct.id_MauSac = tbl_MauSac.id
    INNER JOIN tbl_TenGiay ON spct.id_TenGiay = tbl_TenGiay.id
    Left join tbl_Anh ON spct.id_Anh = tbl_Anh.id
    where tbl_tenGiay.tenGiay = ? and spct.xoaMem = 0
    order by spct.ID asc
    OFFSET  (  (?*5) - 5 )  
    rows fetch next 5 rows only
    """;

    public List<Ispct> get5Object_ByTrang(String tenGiay, int trang) {//Thực hiện truy vấn ra 5 bản ghi ở số trang tuyền vào. 
        return selectBySQL(get5ObjectToTrang, tenGiay, trang);
    }

    public String SELECT_ALL_SPCT_BY_SQL = """
    select spct.id ,  tbl_TenGiay.tenGiay , tbl_ThuongHieu.tenThuongHieu  , tbl_ChatLieu.TenCL , 
        tbl_Anh.TenAnh ,  spct.xoaMem ,
        tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac  , 
        spct.soLuong , spct.giaBan 	, spct.moTa  , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
        spct.[nguoiSua] , spct.[ngayTao] , spct.[ngaySua]
        from tbl_SPCT spct
    inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
    inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
    inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
    inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
    inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
    inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
    inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
    left join tbl_Anh on spct.id_Anh = tbl_Anh.id
    where spct.xoaMem = 0                                                                               
    order by spct.[ngayTao] desc""";
    //Truy vấn tất cả SPCT  theo create_at ( Giảm dần ) 

    String SELECT_SPCT_BY_NAME_SP = """
      select spct.id  ,  tbl_TenGiay.TenGiay , tbl_ThuongHieu.tenThuongHieu , tbl_ChatLieu.TenCL , 
           tbl_Anh.TenAnh ,  spct.xoaMem ,
           tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay  , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac , 
           spct.nguoiSua, spct.ngayTao , spct.ngaySua ,
           spct.soLuong  , spct.giaBan , spct.moTa  , spct.QRcode , spct.trangThai , spct.nguoiTao  
           from tbl_SPCT spct
           inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
           inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
           inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
           inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
           inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
           inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
           inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
           left join tbl_Anh on spct.id_Anh = tbl_Anh.id
           where tbl_TenGiay.TenGiay =  ? and spct.xoaMem = 0
           order by spct.ngayTao desc""";
    //Truy vấn SPCT theo Name giày với creat_at giảm dần.

    String Insert_SPCT_BY_SQL = """
    INSERT INTO [dbo].[tbl_SPCT] 
    (id_ChatLieu, id_DayGiay, id_DeGiay, id_KichCo, id_MauSac, 
    id_TenGiay, id_ThuongHieu, id_Anh, [soLuong], [giaBan],
    [moTa], [QRCode], [trangThai], [nguoiTao], [xoaMem])
    VALUES 
    (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";

    String Upadte_SPCT_BY_SQL = """
     UPDATE tbl_SPCT
    SET
        id_ChatLieu = ?, id_DayGiay = ?,  id_DeGiay = ?,   id_KichCo = ?,   id_MauSac = ?,   
        id_TenGiay = ?,  id_ThuongHieu = ?,id_Anh = ?,      quantiy = ?,    price = ?,   
        description = ?,  QRcode = ?,      Status = ?,  Update_by = ?
    WHERE id = ?; """;

    String SELECT_One_SPCT_To_ThemNhanh = """
  select spct.id  ,  tbl_tenGiay.tenGiay  , tbl_ThuongHieu.tenThuongHieu , tbl_ChatLieu.TenCL, 
  tbl_Anh.TenAnh ,  spct.[xoaMem] ,
  tbl_DayGiay.TenDayGiay , tbl_DeGiay.loaiDeGiay  , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac  , 
  spct.soLuong , spct.giaBan\t, spct.moTa , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
  spct.[nguoiSua] , spct.[ngayTao]  , spct.[ngaySua] 
  from tbl_SPCT spct
  inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
  inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
  inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
  inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
  inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
  inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
  inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
  left join tbl_Anh on spct.id_Anh = tbl_Anh.id
  where spct.id = ?
  order by spct.[ngayTao] desc""";

    String Update_SPCT_For_UpdateNhanh = """
            UPDATE tbl_SPCT
            SET
            id_ThuongHieu = ? , id_KichCo = ? , id_MauSac =? , id_ChatLieu = ? , 
            id_DeGiay = ? , id_DayGiay = ? , giaBan =? , soLuong =? ,
            id_Anh =?, moTa =?, nguoiSua = ? , QRCode = ? 
            where id = ?
                                         """;
    //ID_Tên_SP + ID_SPCT + tên ảnh của SPCT có SL lớn nhất

    String Select_Image_SPCT_BY_iDSP = """
       SELECT TOP 1 
           spct.id ,
           tg.TenGiay ,
           cll.TenCL ,
           dg.TenDayGiay ,
           deg.loaiDeGiay ,
           kc.kichCo ,
           ms.tenMauSac ,
           TH.tenThuongHieu ,
           anh.TenAnh ,
           anh.[trangThai] ,
           anh.[ngayTao] ,
           anh.[NguoiTao] ,
           anh.ngaySua ,
           anh.nguoiSua ,
           spct.soLuong ,
           spct.giaBan ,
           spct.moTa ,
           spct.QRcode,
           spct.trangThai ,
           spct.[ngayTao] ,
           spct.[nguoiTao] ,
           spct.ngaySua  ,
           spct.[nguoiSua]  ,
            spct.[xoaMem]   
       FROM
           tbl_SPCT spct
       INNER JOIN tbl_TenGiay tg ON spct.id_TenGiay = tg.id
       LEFT JOIN tbl_ChatLieu cll ON spct.id_ChatLieu = cll.id
       LEFT JOIN tbl_DayGiay dg ON spct.id_DayGiay = dg.id
       LEFT JOIN tbl_DeGiay deg ON spct.id_DeGiay = deg.id
       LEFT JOIN tbl_KichCo kc ON spct.id_KichCo = kc.id
       LEFT JOIN tbl_MauSac ms ON spct.id_MauSac = ms.id
       LEFT JOIN tbl_ThuongHieu th ON spct.id_ThuongHieu = th.id
       LEFT JOIN tbl_Anh anh ON spct.id_Anh = anh.id
       where id_TenGiay = ?
       ORDER BY spct.soLuong DESC;""";

    String select_ALL_CTSP_By_Status_And_Deleted = """
            select spct.id ,  tbl_TenGiay.tenGiay , tbl_ThuongHieu.tenThuongHieu  , tbl_ChatLieu.TenCL , 
                        tbl_Anh.TenAnh ,  spct.xoaMem ,
                        tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac  , 
                        spct.soLuong , spct.giaBan 	, spct.moTa  , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
                        spct.[nguoiSua] , spct.[ngayTao] , spct.[ngaySua]
                        from tbl_SPCT spct
                        inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
                        inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
                        inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
                        inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
                        inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
                        inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
                        inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
                        left join tbl_Anh on spct.id_Anh = tbl_Anh.id
                        where spct.xoaMem = 0  and tbl_TenGiay.trangThai = N'Đang Kinh Doanh' and spct.soLuong > 0 
     """;//truy vấn tất cả SPCT cho bán hàng ( Đang kinh doanh + Chưa bị xóa ).

    public List<Ispct> getALL_SPCT_For_BanHang() {
        List<Ispct> listSPCT = selectBySQL(select_ALL_CTSP_By_Status_And_Deleted);
        if (listSPCT != null) {
            return selectBySQL(select_ALL_CTSP_By_Status_And_Deleted);
        } else {
            System.out.println("không còn SPCT để bán hàng.");
            return null;
        }
    }

    String updateXoaMem = """
                          update tbl_spct
                          set xoaMem = ?
                          where id = ? """;

    public int updateXoaMem(Ispct spct) {
        return JDBCHelper.update(updateXoaMem,
                spct.getDeleted(),
                spct.getId()
        );
    }

    public int insert(IspctInsert e) {//Thực hiện Insert cho IspctInsert ( SPCT ) 
        return JDBCHelper.update(Insert_SPCT_BY_SQL,
                e.getId_chatLieu(),
                e.getId_dayGiay(),
                e.getId_deGiay(),
                e.getId_kichThuoc(),
                e.getId_mauSac(),
                e.getId_tenGiay(),
                e.getId_thuongHieu(),
                e.getId_anh(),
                e.getSoLuong(),
                e.getGiaBan(),
                e.getMoTa(),
                e.getMaQR(),
                e.getTrangThai(),
                e.getCreate_by(),
                e.getDeleted()
        );
    }

    public int update(IspctInsert e) {//Thực hiện update cho IspctInsert ( SPCT ) 
        return JDBCHelper.update(Update_SPCT_For_UpdateNhanh,
                e.getId_thuongHieu(),
                e.getId_kichThuoc(),
                e.getId_mauSac(),
                e.getId_chatLieu(),
                e.getId_deGiay(),
                e.getId_dayGiay(),
                e.getGiaBan(),
                e.getSoLuong(),
                e.getId_anh(),
                e.getMoTa(),
                e.getUpdate_by(),
                e.getMaQR(),
                e.getId_SPCT()
        );
    }

    public int update_ChoThemNhanh(IspctInsert e) {//Thực hiện update cho IspctInsert ( SPCT ) 
        return JDBCHelper.update(Upadte_SPCT_BY_SQL,
                e.getId_chatLieu(),
                e.getId_dayGiay(),
                e.getId_deGiay(),
                e.getId_kichThuoc(),
                e.getId_mauSac(),
                e.getId_tenGiay(),
                e.getId_thuongHieu(),
                e.getId_anh(),
                e.getSoLuong(),
                e.getGiaBan(),
                e.getMoTa(),
                e.getMaQR(),
                e.getTrangThai(),
                e.getUpdate_by(),
                e.getId_SPCT()
        );
    }

    //Update id_anh của spct dựa vào id_SPCT
    String update_ID_Anh_For_SPCT = """
                                    update tbl_spct
                                    set ID_anh = ? 
                                    where ID = ? """;

    public int updateAnhForSPCT(IspctInsert e) {
        int rowupdate = JDBCHelper.update(update_ID_Anh_For_SPCT,
                e.getId_anh(),
                e.getId_SPCT()
        );
        System.out.println("ID_ANH _ BenDao " + e.getId_anh());
        System.out.println("ID_SPCT Ben DAO : " + e.getId_SPCT());
        System.out.println("số dòng bị ảnh hưởng bởi Update " + rowupdate);
        return rowupdate;//số dòng thực hiện cập nhật. 1 là có 0 là không
    }

    public List<Ispct> selectAll() {//đag dùng cho rdo_chọn tất cả trog UI SP
        return selectBySQL(SELECT_ALL_SPCT_BY_SQL);
    }

    public List<Ispct> selectAll_By_ID_MaHD(int maHD) {//Dùng cho truy vấn trong HĐ
        String sql = """
                      select 
                     spct.id , tbl_TenGiay.tenGiay , tbl_ThuongHieu.tenThuongHieu  , tbl_KichCo.kichCo ,
                     tbl_MauSac.tenMauSac , hdct.soLuong as N'soLuong' ,  hdct.giaTienTra as N'giaBan',
                     tbl_ChatLieu.TenCL , tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay ,   
                     tbl_Anh.TenAnh,spct.moTa  , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
                     spct.[nguoiSua] , spct.[ngayTao] , spct.[ngaySua], spct.xoaMem
                     from tbl_SPCT spct
                     inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
                     inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
                     inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
                     inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
                     inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
                     inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
                     inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
                     left join tbl_Anh on spct.id_Anh = tbl_Anh.id
                     inner join tbl_hoaDonChiTiet hdct on hdct.ID_sanPhamChiTiet = spct.ID
                     inner join tbl_hoaDon hd on hd.ID = hdct.ID_hoaDon
                         where spct.xoaMem = 0  and    hd.ID = ?
                     SELECT * FROM tbl_hoaDonChiTiet	
                    """;
        return selectBySQL(sql, maHD);
    }
    
    public Ispct selectById_To_ThemNhanh(int id_SPCT) {
        List<Ispct> one_spct = selectBySQL(SELECT_One_SPCT_To_ThemNhanh, id_SPCT);
        if (!one_spct.isEmpty()) {
            return one_spct.get(0);
        }
        System.out.println("Ko truy vấn ra đối tượng nào trong danh sách dựa theo ID_SPCT trên ( 194 )");
        return null;
    }

    //truy vấn tên ảnh của SPCT dựa vào ID_SP
    public Ispct select_SPCT_To_LayNameAnh_ById__SP(int idSP) {
        List<Ispct> one_spct = selectBySQL(Select_Image_SPCT_BY_iDSP, idSP);
        if (one_spct != null && !one_spct.isEmpty()) {
            return one_spct.get(0);
        }
//        System.out.println("Ko truy vấn ra đối tượng nào trong danh sách dựa theo ID_SPCT trên ( 264 )");
        return null;
    }

    //truy vấn SPCT dựa vào tên Giày
    public List<Ispct> select_ALL_SPCT_By_Name(String tenGiay) {
        return selectBySQL(SELECT_SPCT_BY_NAME_SP, tenGiay);
    }

    //Lọc
    String sql = null;

    public List<Ispct> getALL_SPCT_For_BanHang_By_Color(String color) {
        sql = """
              select spct.id ,  tbl_TenGiay.tenGiay , tbl_ThuongHieu.tenThuongHieu  , tbl_ChatLieu.TenCL , 
                                      tbl_Anh.TenAnh ,  spct.xoaMem ,
                                      tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac  , 
                                      spct.soLuong , spct.giaBan \t, spct.moTa  , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
                                      spct.[nguoiSua] , spct.[ngayTao] , spct.[ngaySua]
                                      from tbl_SPCT spct
                                      inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
                                      inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
                                      inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
                                      inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
                                      inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
                                      inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
                                      inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
                                      left join tbl_Anh on spct.id_Anh = tbl_Anh.id
                                      where spct.xoaMem = 0  and tbl_TenGiay.trangThai = N'Đang Kinh Doanh' and spct.soLuong > 0 and tbl_mauSac.tenMauSac = ?""";
        List<Ispct> listSPCT = selectBySQL(sql, color);
        if (listSPCT != null) {
            return selectBySQL(sql, color);
        } else {
            System.out.println("không còn SPCT để bán hàng.");
            return null;
        }
    }

    public List<Ispct> getALL_SPCT_For_BanHang_By_Size(int size) {
        sql = """
                select spct.id ,  tbl_TenGiay.tenGiay , tbl_ThuongHieu.tenThuongHieu  , tbl_ChatLieu.TenCL , 
                      tbl_Anh.TenAnh ,  spct.xoaMem ,
                      tbl_DayGiay.TenDayGiay  , tbl_DeGiay.loaiDeGiay , tbl_KichCo.kichCo , tbl_MauSac.tenMauSac  , 
                      spct.soLuong , spct.giaBan 	, spct.moTa  , spct.QRcode  , spct.[trangThai]  , spct.[nguoiTao]  , 
                      spct.[nguoiSua] , spct.[ngayTao] , spct.[ngaySua]
                      from tbl_SPCT spct
                      inner join tbl_ThuongHieu on spct.id_ThuongHieu = tbl_ThuongHieu.id
                      inner join tbl_ChatLieu on spct.id_ChatLieu = tbl_ChatLieu.id
                      inner join tbl_DayGiay on spct.id_DayGiay = tbl_DayGiay.id 
                      inner join tbl_DeGiay on spct.id_DeGiay = tbl_DeGiay.id
                      inner join tbl_KichCo on spct.id_KichCo = tbl_KichCo.id
                      inner join tbl_MauSac on spct.id_MauSac = tbl_MauSac.id
                      inner join tbl_TenGiay on spct.id_TenGiay = tbl_TenGiay.id
                      left join tbl_Anh on spct.id_Anh = tbl_Anh.id
                      where spct.xoaMem = 0  and tbl_TenGiay.trangThai = N'Đang Kinh Doanh' and spct.soLuong > 0 and tbl_kichCo.kichCo = ?""";
        List<Ispct> listSPCT = selectBySQL(sql, size);
        if (listSPCT != null) {
            return selectBySQL(sql, size);
        } else {
            System.out.println("không còn SPCT để bán hàng.");
            return null;
        }
    }

    public List<Ispct> selectBySQL(String sql, Object... args) {
        List<Ispct> listProdetails = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                Ispct prodetails = new Ispct();
                prodetails.setId(rs.getInt("id"));//ID_SPCT
                prodetails.setNamechatLieu(rs.getString("TenCL"));
                prodetails.setNamedayGiay(rs.getString("TenDayGiay"));
                prodetails.setNamedeGiay(rs.getString("loaiDeGiay"));
                prodetails.setNamekichCo(rs.getString("kichCo"));
                prodetails.setNamemauSac(rs.getString("tenMauSac"));
                prodetails.setNametenGiay(rs.getString("tenGiay"));
                prodetails.setNamethuongHieu(rs.getString("tenThuongHieu"));
                prodetails.setNameanh(rs.getString("tenAnh"));
                prodetails.setSoLuong(rs.getInt("soLuong"));
                prodetails.setGiaBan(rs.getBigDecimal("giaBan"));
                prodetails.setMoTa(rs.getString("MoTa"));
                prodetails.setMaQR(rs.getString("QRcode"));
                prodetails.setTrangThai(rs.getString("trangThai"));
                prodetails.setCreate_by(rs.getInt("nguoiTao"));
                prodetails.setUpdate_by(rs.getInt("nguoiSua"));
                prodetails.setCreate_at(rs.getDate("ngayTao"));
                prodetails.setUpdate_at(rs.getDate("ngaySua"));
                prodetails.setDeleted(rs.getInt("xoaMem"));
                listProdetails.add(prodetails);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProdetails;
    }

}//end life
