package du_an_1_ql_ban_giay.BanHangDAO;

import du_an_1_ql_ban_giay.model.HoaDonModel_manh;
import du_an_1_ql_ban_giay.utility.JDBCHelper;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HoaDonDAO {

    String sql = null;
    ResultSet rs = null;

    public List<HoaDonModel_manh> getListHD() {//Lấy hóa đơn fill lên bảng + thanh toán thành công.
        sql = """
         select hd.ID ,kh.hoTen , kh.soDT  , hd.tongGiaTriHoaDon 
                 , tthd.tenTTHD , hd.ngayTao , nv.hoTen  as N'tenNV'
       	from tbl_hoaDon hd
       	inner join tbl_hoaDonChiTiet hdct on hdct.ID_hoaDon = hd.ID
       	inner join tbl_trangThaiHoaDon tthd on tthd.id = hd.ID_trangThaiHoaDon
       	right join tbl_nhanVien nv on nv.ID = hd.ID_nhanVien
       	LEFT join tbl_khachHang kh on kh.ID = hd.ID_khachHang
       		where hd.ID_trangThaiHoaDon = 2
       		group by hd.ID , kh.hoTen , kh.soDT
       		, hd.tongGiaTriHoaDon  , tthd.tenTTHD , hd.ngayTao , nv.hoTen
              """;
        List<HoaDonModel_manh> listHD = selectBySQL(sql);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonModel_manh> getListHD_By_HTTT_1And2(int httt) {//fill hóa đơn cho cbb httt
        sql = """
            select hd.ID ,kh.hoTen , kh.soDT  , hd.tongGiaTriHoaDon 
                , tthd.tenTTHD , hd.ngayTao , nv.hoTen  as N'tenNV'
                from tbl_hoaDon hd
                inner join tbl_hoaDonChiTiet hdct on hdct.ID_hoaDon = hd.ID
                inner join tbl_trangThaiHoaDon tthd on tthd.id = hd.ID_trangThaiHoaDon
                right join tbl_nhanVien nv on nv.ID = hd.ID_nhanVien
                LEFT join tbl_khachHang kh on kh.ID = hd.ID_khachHang
                LEFT join tbl_thanhToan tt on tt.id_hoaDon = hd.ID
                where hd.ID_trangThaiHoaDon = 2 and tt.id_HTTT = ?
                group by hd.ID , kh.hoTen , kh.soDT
                , hd.tongGiaTriHoaDon  , tthd.tenTTHD , hd.ngayTao , nv.hoTen
              """;
        List<HoaDonModel_manh> listHD = selectBySQL(sql, httt);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonModel_manh> getListHD_By_HTTT_3(int httt) {//fill hóa đơn cho cbb httt
        sql = """
            select hd.ID ,kh.hoTen , kh.soDT  , hd.tongGiaTriHoaDon 
            	, tthd.tenTTHD , hd.ngayTao , nv.hoTen  as N'tenNV'
            	from tbl_hoaDon hd
            	inner join tbl_trangThaiHoaDon tthd on tthd.id = hd.ID_trangThaiHoaDon
            	inner join tbl_nhanVien nv on nv.ID = hd.ID_nhanVien
            	LEFT join tbl_khachHang kh on kh.ID = hd.ID_khachHang
            	INNER  join tbl_thanhToan tt on tt.id_hoaDon = hd.ID
            	where hd.ID_trangThaiHoaDon = 2 and hd.ID_ThanhToan =  ?
            	group by hd.ID , kh.hoTen , kh.soDT
            	, hd.tongGiaTriHoaDon  , tthd.tenTTHD , hd.ngayTao , nv.hoTen
              """;
        List<HoaDonModel_manh> listHD = selectBySQL(sql, httt);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }

    public List<HoaDonModel_manh> getListHD_By_NVPT(String nvpt) {
        sql = """
            select hd.ID ,kh.hoTen , kh.soDT  , hd.tongGiaTriHoaDon 
                    , tthd.tenTTHD , hd.ngayTao , nv.hoTen  as N'tenNV'
          	from tbl_hoaDon hd
          	inner join tbl_hoaDonChiTiet hdct on hdct.ID_hoaDon = hd.ID
          	inner join tbl_trangThaiHoaDon tthd on tthd.id = hd.ID_trangThaiHoaDon
          	right join tbl_nhanVien nv on nv.ID = hd.ID_nhanVien
          	LEFT join tbl_khachHang kh on kh.ID = hd.ID_khachHang
          	LEFT join tbl_thanhToan tt on tt.id_hoaDon = hd.ID
          		where hd.ID_trangThaiHoaDon = 2 and nv.hoTen = ?
          		group by hd.ID , kh.hoTen , kh.soDT
          		, hd.tongGiaTriHoaDon  , tthd.tenTTHD , hd.ngayTao , nv.hoTen
              """;
        List<HoaDonModel_manh> listHD = selectBySQL(sql, nvpt);
        return (!listHD.isEmpty() && listHD != null) ? listHD : null;
    }
    
    

    public int getTienMatByIDHD(int maHD, int httt) {
        sql = """
              select tt.soTienThanhToan 
              from tbl_hoaDon hd 
              inner join tbl_thanhToan tt on tt.id_hoaDon = hd.ID
              where hd.ID = ? and tt.id_HTTT = ? """;
        try {
            rs = JDBCHelper.query(sql, maHD, httt);
            int tienThanhToan = 0;
            while (rs.next()) {
                tienThanhToan = rs.getInt("soTienThanhToan");
            }
            rs.close();
            return tienThanhToan;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public List<HoaDonModel_manh> selectBySQL(String sql, Object... args) {
        List<HoaDonModel_manh> listHD = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JDBCHelper.query(sql, args); // Biến để lưu trữ ResultSet được trả về từ phương thức JDBCHelper.query.
            ResultSetMetaData rsmd = rs.getMetaData();
//          để lấy ResultSetMetaData của ResultSet.
//          ResultSetMetaData cung cấp thông tin về các cột trong ResultSet.
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                HoaDonModel_manh hd = new HoaDonModel_manh();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    switch (columnName) {//Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                        case "ID" ->
                            hd.setMaHD(rs.getInt(i));
                        case "hoTen" ->
                            hd.setTenKH(rs.getString(i));
                        case "soDT" ->
                            hd.setSdt(rs.getString(i));
                        case "tongGiaTriHoaDon" ->
                            hd.setDonGia(rs.getBigDecimal(i));
                        case "tenTTHD" ->
                            hd.setTrangThai(rs.getString(i));
                        case "ngayTao" ->
                            hd.setNgayTao(rs.getDate(i));
                        case "tenNV" ->
                            hd.setTenNguoiTao(rs.getString(i));
                    }
                    // Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                }
                listHD.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonModel_manh.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi truy vấn danh sách hóa đơn");
        } finally {
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet thủ công
                }
            } catch (SQLException ex) {
                // Xử lý lỗi nếu đóng ResultSet thất bại
            }
        }
        return listHD;
    }

}
