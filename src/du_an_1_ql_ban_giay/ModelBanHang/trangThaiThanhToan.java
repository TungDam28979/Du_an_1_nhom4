package du_an_1_ql_ban_giay.ModelBanHang;

import java.util.Date;

public class trangThaiThanhToan {

    private int id;
    private String tenTrangThaiThanhToan; //Thành công/thất bại
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;
    private int xoaMem;

    public trangThaiThanhToan() {
    }

    public trangThaiThanhToan(int id, String tenTrangThaiThanhToan, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua, int xoaMem) {
        this.id = id;
        this.tenTrangThaiThanhToan = tenTrangThaiThanhToan;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.xoaMem = xoaMem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTrangThaiThanhToan() {
        return tenTrangThaiThanhToan;
    }

    public void setTenTrangThaiThanhToan(String tenTrangThaiThanhToan) {
        this.tenTrangThaiThanhToan = tenTrangThaiThanhToan;
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

    public int getXoaMem() {
        return xoaMem;
    }

    public void setXoaMem(int xoaMem) {
        this.xoaMem = xoaMem;
    }

}
