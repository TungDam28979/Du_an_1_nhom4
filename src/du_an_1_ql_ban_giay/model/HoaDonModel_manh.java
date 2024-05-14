package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDonModel_manh {

    private int maHD;
    private String tenKH;
    private String sdt;
    private String diaChi;
    private BigDecimal donGia;//Tổng giá trị đơn đó
    private String trangThai;//TTHĐ
    private Date ngayTao;
    private String tenNguoiTao;

    public HoaDonModel_manh() {
    }

    public HoaDonModel_manh(int maHD, String tenKH, String sdt, BigDecimal donGia, String trangThai, Date ngayTao, String diaChi, String tenNguoiTao) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.diaChi = diaChi;
        this.tenNguoiTao = tenNguoiTao;
    }

    public String getTenNguoiTao() {
        return tenNguoiTao;
    }

    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    //Tiền Đưa + CK
    private int tienDua;
    private int ck;

    public int getTienDua() {
        return tienDua;
    }

    public void setTienDua(int tienDua) {
        this.tienDua = tienDua;
    }

    public int getCk() {
        return ck;
    }

    public void setCk(int ck) {
        this.ck = ck;
    }

}
