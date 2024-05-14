package du_an_1_ql_ban_giay.ModelBanHang;

import java.util.Date;

public class hinhThucThanhToan {

    private int id_HTTT;
    private String tenHinhThucThanhToan; //Chuyển khoản / tiền mặt
    private String moTa;
    private int trangThai; //Đang áp dụng / dừng áp dụng
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;

    public hinhThucThanhToan() {
    }

    public hinhThucThanhToan(int id_HTTT, String tenHinhThucThanhToan, String moTa, int trangThai, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua) {
        this.id_HTTT = id_HTTT;
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId_HTTT() {
        return id_HTTT;
    }

    public void setId_HTTT(int id_HTTT) {
        this.id_HTTT = id_HTTT;
    }

    public String getTenHinhThucThanhToan() {
        return tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    @Override
    public String toString() {
        return tenHinhThucThanhToan;
    }

}
