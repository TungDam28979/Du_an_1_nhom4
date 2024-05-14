package ModelBanHang;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class HoaDonBanHang {

    private int id; //id hóa dơn
    private int id_nhanVien;
    private int id_khachHang;
    private int id_thanhToan; //dựa vào đây biết được nó thanh toán loại nào ( tiền mặt/CK ) với giá trị là bao nhiêu ( mã giao dịch --Nếu có ).
    private int id_voucher;
    private int id_trangThaiHoaDon;//Chờ thanh toán mặc định khi tạo hóa đơn //Khi giao hàng thì trạng thái là thanh toán / thanh toán khi nhận hàng.
    private int trangThaiThanhToan; //Thanh toán trước/Thanh toán khi nhận hàng. ( Khi giao hàng )
    //--------------------
    private String loaiHoaDon; //Tại quầy / giao hàng
    private Date ngayTao; //Ngày tạo hóa đơn ( Mặc định là thời gian hóa đơn đc tạo ).
    private BigDecimal tongGiaTriHD; //Bằng giá sản phẩm * số lượng 
    private BigDecimal giamGiaHD;      //Số tiền giảm bằng voucher.
    private BigDecimal thanhToan; //Tiền khách phải thanh toán sau khi trừ đi các khuyến mãi
    private BigDecimal tienThua; //Tiền thừa của khách hàng sau khi thanh toán
    //-------------------
    private String tenNguoiNhan; //Tên người nhận hàng khi ship
    private String soDTNguoiNhan; //SĐT người nhận hàng
    private String diaChiNguoiNhan;//Địa chỉ nhận hàng
    private String tenNguoiShip;//Tên nhân viên ship hàng
    private String soDTShip;//SĐT nhân viên ship hàng.
    private BigDecimal phiShip;//Số tiền phí giao hàng.
    private String ghiChu; //Khi chú khi ship hàng
    private Date ngayMuonNhanHang; //Ngày mà khách hàng muốn nhận hàng.Và cx là ngày KH nhận đc hàng.
    private int nguotTao; //Người tạo hóa đơn. 
    private int nguoiSua;//Người sửa hóa đơn.
    private Date ngaySua;//Ngày sửa hóa đơn.

    //tiên khách đưa và tiền khách chuyển khoảng
    private BigDecimal tienKhachDua;
    private BigDecimal tienKhachCK;

    public HoaDonBanHang(int id, int id_nhanVien, int id_khachHang, int id_thanhToan, int id_voucher, int id_trangThaiHoaDon, int trangThaiThanhToan, String loaiHoaDon, Date ngayTao, BigDecimal tongGiaTriHD, BigDecimal giamGiaHD, BigDecimal thanhToan, BigDecimal tienThua, String tenNguoiNhan, String soDTNguoiNhan, String diaChiNguoiNhan, String tenNguoiShip, String soDTShip, BigDecimal phiShip, String ghiChu, Date ngayMuonNhanHang, int nguotTao, int nguoiSua, Date ngaySua, BigDecimal tienKhachDua, BigDecimal tienKhachCK) {
        this.id = id;
        this.id_nhanVien = id_nhanVien;
        this.id_khachHang = id_khachHang;
        this.id_thanhToan = id_thanhToan;
        this.id_voucher = id_voucher;
        this.id_trangThaiHoaDon = id_trangThaiHoaDon;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.loaiHoaDon = loaiHoaDon;
        this.ngayTao = ngayTao;
        this.tongGiaTriHD = tongGiaTriHD;
        this.giamGiaHD = giamGiaHD;
        this.thanhToan = thanhToan;
        this.tienThua = tienThua;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDTNguoiNhan = soDTNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.tenNguoiShip = tenNguoiShip;
        this.soDTShip = soDTShip;
        this.phiShip = phiShip;
        this.ghiChu = ghiChu;
        this.ngayMuonNhanHang = ngayMuonNhanHang;
        this.nguotTao = nguotTao;
        this.nguoiSua = nguoiSua;
        this.ngaySua = ngaySua;
        this.tienKhachDua = tienKhachDua;
        this.tienKhachCK = tienKhachCK;
    }

    public BigDecimal getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(BigDecimal tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public BigDecimal getTienKhachCK() {
        return tienKhachCK;
    }

    public void setTienKhachCK(BigDecimal tienKhachCK) {
        this.tienKhachCK = tienKhachCK;
    }

    public static String generateCode() {
        Random random = new SecureRandom();
        StringBuilder code = new StringBuilder(CODE_LENGTH);//Dùng để nối các ký tự gen ra. Vs độ dài ước lượng được xác định. 

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());//sinh ra 1 số ngẫu nhiên từ 0 --> CHARACTERS.length() - 1.
            code.append(CHARACTERS.charAt(randomIndex));//trả về ký tự tại randomIndex và thêm ký tự này vào code.
        }

        return "HD-" + code.toString();
    }
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 5;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(int id, int id_nhanVien, int id_khachHang, int id_thanhToan, int id_voucher, int id_trangThaiHoaDon, int trangThaiThanhToan, String loaiHoaDon, Date ngayTao, BigDecimal tongGiaTriHD, BigDecimal giamGiaHD, BigDecimal thanhToan, BigDecimal tienThua, String tenNguoiNhan, String soDTNguoiNhan, String diaChiNguoiNhan, String tenNguoiShip, String soDTShip, BigDecimal phiShip, String ghiChu, Date ngayMuonNhanHang, int nguotTao, int nguoiSua, Date ngaySua) {
        this.id = id;
        this.id_nhanVien = id_nhanVien;
        this.id_khachHang = id_khachHang;
        this.id_thanhToan = id_thanhToan;
        this.id_voucher = id_voucher;
        this.id_trangThaiHoaDon = id_trangThaiHoaDon;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.loaiHoaDon = loaiHoaDon;
        this.ngayTao = ngayTao;
        this.tongGiaTriHD = tongGiaTriHD;
        this.giamGiaHD = giamGiaHD;
        this.thanhToan = thanhToan;
        this.tienThua = tienThua;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDTNguoiNhan = soDTNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.tenNguoiShip = tenNguoiShip;
        this.soDTShip = soDTShip;
        this.phiShip = phiShip;
        this.ghiChu = ghiChu;
        this.ngayMuonNhanHang = ngayMuonNhanHang;
        this.nguotTao = nguotTao;
        this.nguoiSua = nguoiSua;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_nhanVien() {
        return id_nhanVien;
    }

    public void setId_nhanVien(int id_nhanVien) {
        this.id_nhanVien = id_nhanVien;
    }

    public int getId_khachHang() {
        return id_khachHang;
    }

    public void setId_khachHang(int id_khachHang) {
        this.id_khachHang = id_khachHang;
    }

    public int getId_thanhToan() {
        return id_thanhToan;
    }

    public void setId_thanhToan(int id_thanhToan) {
        this.id_thanhToan = id_thanhToan;
    }

    public int getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(int id_voucher) {
        this.id_voucher = id_voucher;
    }

    public int getId_trangThaiHoaDon() {
        return id_trangThaiHoaDon;
    }

    public void setId_trangThaiHoaDon(int id_trangThaiHoaDon) {
        this.id_trangThaiHoaDon = id_trangThaiHoaDon;
    }

    public int getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(int trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongGiaTriHD() {
        return tongGiaTriHD;
    }

    public void setTongGiaTriHD(BigDecimal tongGiaTriHD) {
        this.tongGiaTriHD = tongGiaTriHD;
    }

    public BigDecimal getGiamGiaHD() {
        return giamGiaHD;
    }

    public void setGiamGiaHD(BigDecimal giamGiaHD) {
        this.giamGiaHD = giamGiaHD;
    }

    public BigDecimal getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(BigDecimal thanhToan) {
        this.thanhToan = thanhToan;
    }

    public BigDecimal getTienThua() {
        return tienThua;
    }

    public void setTienThua(BigDecimal tienThua) {
        this.tienThua = tienThua;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSoDTNguoiNhan() {
        return soDTNguoiNhan;
    }

    public void setSoDTNguoiNhan(String soDTNguoiNhan) {
        this.soDTNguoiNhan = soDTNguoiNhan;
    }

    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }

    public String getTenNguoiShip() {
        return tenNguoiShip;
    }

    public void setTenNguoiShip(String tenNguoiShip) {
        this.tenNguoiShip = tenNguoiShip;
    }

    public String getSoDTShip() {
        return soDTShip;
    }

    public void setSoDTShip(String soDTShip) {
        this.soDTShip = soDTShip;
    }

    public BigDecimal getPhiShip() {
        return phiShip;
    }

    public void setPhiShip(BigDecimal phiShip) {
        this.phiShip = phiShip;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayMuonNhanHang() {
        return ngayMuonNhanHang;
    }

    public void setNgayMuonNhanHang(Date ngayMuonNhanHang) {
        this.ngayMuonNhanHang = ngayMuonNhanHang;
    }

    public int getNguotTao() {
        return nguotTao;
    }

    public void setNguotTao(int nguotTao) {
        this.nguotTao = nguotTao;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

}
