package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;

public class ThanhToanModel {

    private int id;
    private int id_hoaDon;
    private int id_HTTT;//Tiền mặt/CK
    private BigDecimal soTienThanhToan;

    public ThanhToanModel() {
    }

    public ThanhToanModel(int id, int id_hoaDon, int id_HTTT, BigDecimal soTienThanhToan) {
        this.id = id;
        this.id_hoaDon = id_hoaDon;
        this.id_HTTT = id_HTTT;
        this.soTienThanhToan = soTienThanhToan;
    }

    public ThanhToanModel(int id_hoaDon, int id_HTTT, BigDecimal soTienThanhToan) {
        this.id_hoaDon = id_hoaDon;
        this.id_HTTT = id_HTTT;
        this.soTienThanhToan = soTienThanhToan;
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

}
