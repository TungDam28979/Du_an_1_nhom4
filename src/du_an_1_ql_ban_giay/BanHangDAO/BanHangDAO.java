package du_an_1_ql_ban_giay.BanHangDAO;

import ModelBanHang.HoaDonBanHang;
import du_an_1_ql_ban_giay.dao.ProductDetaisDAO;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BanHangDAO {

    String update_ID_KH = """
                         update tbl_hoaDon
                          set  ID_khachHang = ?
                          where ID = ?""";

    public int update_ID_KH(int id_HD, int id_KH) {
        return JDBCHelper.update(update_ID_KH, id_KH, id_HD);
    }

    String updateTongGTHD = """
                            update tbl_hoaDon
                            set tongGiaTriHoaDon = ? , thanhToan = ?
                            where ID = ?""";

    public int update_TongGTHD(int maHD, BigDecimal tongGTHD, BigDecimal thanhTien) {
        return JDBCHelper.update(updateTongGTHD,
                tongGTHD,
                thanhTien,
                maHD
        );//Cập nhật lại tổng giá trị hóa đơn theo id_Hóa Đơn
    }

    final String get_ListHD_By_Status = """
     select  * from tbl_hoaDon   hd
         left join tbl_nhanVien nv on hd.ID_nhanVien = nv.ID 
         left join tbl_trangThaiHoaDon tthd on hd.ID_trangThaiHoaDon = tthd.id
         where tthd.id = 1""";//Lấy danh sách hóa đơn với trạng thái chờ thanh toán ( 1 ) 

    final String getTT_HD_TaiQuay_By_ID = """
        select hd.* from tbl_hoaDon  hd
        where hd.ID =  ?                                                                                                                                                       
      """;
    String delete_HD_By_ID = """
                                delete tbl_hoaDon  
                                  where ID = 	 ?
                               """;

    final String tao_HD = """
    insert into tbl_hoaDon ( ID_nhanVien ,ID_khachHang,loaiHoaDon,ID_trangThaiHoaDon,tongGiaTriHoaDon,thanhToan,tienThua,giamGiaHD , nguoiTao )
        values ( ? , ? , ? , ? , ? , ? , ? , ? , ?);                                                        
        """;//Tạo hóa đơn với các thông số ID_NV | ID_KH | ID_TrangThaiHoaDon. || loại hóa đơn , Tổng Giá trị hóa đơn , thành tiền , tiền thừa  , giảm giá hóa đơn , người tạo.
    //Tạo hóa đơn với các thông số ID_NV | ID_KH |  

    public int insert(HoaDonBanHang e) {
        return JDBCHelper.update(tao_HD,
                e.getId_nhanVien(),
                e.getId_khachHang(),
                e.getLoaiHoaDon(),//Tại quầy
                e.getId_trangThaiHoaDon(), //Chờ thanh toán -- Thanh toán thành công -- hủy thanh toán.
                e.getTongGiaTriHD(),//Sum(hdct.donGia = hdct.sl * hdct.giaBan)
                e.getThanhToan(),//Số tiền thanh toán = 0 (thanh toán = tongGTHĐ - giamGiaHD)
                e.getTienThua(),//(tiên đưa + tiền ck) - thanh toán.
                e.getGiamGiaHD(),//Dựa vào voucher.
                e.getNguotTao()//Nv tạo đơn
        );
    }

    public int updateTrangThaiHoaDon_TienThua(int idHD, String tienThua, int httt) {
        String sql = """
              update tbl_hoaDon 
               set ID_trangThaiHoaDon = 2, tienThua = ? 
               , ID_ThanhToan = ? 
               where ID = ?
                     """;
        return JDBCHelper.update(sql, tienThua, httt, idHD);
    }

    public void delete_HD_By_ID(int idHD) {
        JDBCHelper.update(delete_HD_By_ID, idHD);
    }

    public List<HoaDonBanHang> select_HD_By_Status() {//truy vấn danh sách hóa đơn : Trạng thái chờ thanh toán.
        if (!selectBySQL(get_ListHD_By_Status).isEmpty() && selectBySQL(get_ListHD_By_Status) != null) {
            return selectBySQL(get_ListHD_By_Status);
        }
        return null;
    }

    public HoaDonBanHang selectTT_HD_TaiQuay_ById(int id_HD) {
        List<HoaDonBanHang> listHDBH = selectBySQL(getTT_HD_TaiQuay_By_ID, id_HD);
        if (listHDBH != null && !listHDBH.isEmpty()) {
            return listHDBH.get(0);
        }
        System.out.println("Ko truy vấn ra TT_HD_TaiQuay_By_ID");
        return null;
    }

    public List<HoaDonBanHang> selectBySQL(String sql, Object... args) {
        List<HoaDonBanHang> listHDBH = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HoaDonBanHang hd = new HoaDonBanHang();
                hd.setId(rs.getInt("ID")); // 1
                hd.setId_khachHang(rs.getInt("ID_khachHang")); // 2
                hd.setId_nhanVien(rs.getInt("ID_nhanVien"));// 3
                hd.setId_thanhToan(rs.getInt("ID_ThanhToan"));// 4
                hd.setId_voucher(rs.getInt("ID_voucher"));// 5
                hd.setId_trangThaiHoaDon(rs.getInt("ID_trangThaiHoaDon"));// 6
                hd.setTrangThaiThanhToan(rs.getInt("ID_TrangThaiThanhToan"));// 7
                hd.setLoaiHoaDon(rs.getString("loaiHoaDon"));// 8
                hd.setTongGiaTriHD(rs.getBigDecimal("tongGiaTriHoaDon"));// 9
                hd.setGiamGiaHD(rs.getBigDecimal("giamGiaHD"));// 10
                hd.setThanhToan(rs.getBigDecimal("thanhToan"));// 11
                hd.setTienThua(rs.getBigDecimal("tienThua"));// 12
                hd.setTenNguoiNhan(rs.getString("tenNguoiNhan"));// 13
                hd.setSoDTNguoiNhan(rs.getString("sdtNguoiNhan"));// 14
                hd.setDiaChiNguoiNhan(rs.getString("diaChiNguoiNhan"));// 15
                hd.setTenNguoiShip(rs.getString("nguoiShip"));// 16
                hd.setSoDTShip(rs.getString("sdtNguoiShip"));// 17
                hd.setPhiShip(rs.getBigDecimal("phiShip"));// 18
                hd.setGhiChu(rs.getString("ghiChuShip"));// 19
                hd.setNgayMuonNhanHang(rs.getDate("ngayMuonNhanHang"));// 20
                hd.setNguotTao(rs.getInt("nguoiTao"));// 21
                hd.setNguoiSua(rs.getInt("nguoiSua"));// 22
                hd.setNgayTao(rs.getDate("ngayTao"));// 23
                hd.setNgaySua(rs.getDate("ngaySua"));// 24
                listHDBH.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDBH;
    }

}
