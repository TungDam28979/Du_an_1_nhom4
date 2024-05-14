package ModelBanHang;

import java.math.BigDecimal;
import java.util.Date;

public class thanhToan {
//1 hóa đơn có nhiều lần thanh toán. Thành toán bảng tiền mặt và thanh toán bằng CK

    private int id;
    private int id_hoaDon;
    private int id_HTTT;
    private BigDecimal soTienThanhToan;
    private String maGiaoDich;
    private String moTa;
    private String trangThai; //Trạng thái của thanh toán. Thanh toán thành công // thanh toán thất bại
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTaoThanhToan;//Ý chỉ thời gian thực hiện thanh toán.
    private Date ngaySua;

    public thanhToan() {
    }

    public thanhToan(int id, int id_hoaDon, int id_HTTT, BigDecimal soTienThanhToan, String maGiaoDich, String moTa, String trangThai, int nguoiTao, int nguoiSua, Date ngayTaoThanhToan, Date ngaySua) {
        this.id = id;
        this.id_hoaDon = id_hoaDon;
        this.id_HTTT = id_HTTT;
        this.soTienThanhToan = soTienThanhToan;
        this.maGiaoDich = maGiaoDich;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTaoThanhToan = ngayTaoThanhToan;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hoaDon() {
        return id_hoaDon;
    }

    public void setId_hoaDon(int id_hoaDon) {
        this.id_hoaDon = id_hoaDon;
    }

    public int getId_HTTT() {
        return id_HTTT;
    }

    public void setId_HTTT(int id_HTTT) {
        this.id_HTTT = id_HTTT;
    }

    public BigDecimal getSoTienThanhToan() {
        return soTienThanhToan;
    }

    public void setSoTienThanhToan(BigDecimal soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgayTaoThanhToan() {
        return ngayTaoThanhToan;
    }

    public void setNgayTaoThanhToan(Date ngayTaoThanhToan) {
        this.ngayTaoThanhToan = ngayTaoThanhToan;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
    

}
