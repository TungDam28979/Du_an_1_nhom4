package ModelBanHang;

import java.math.BigDecimal;
//Bản chất được hiểu giỏ hàng là 1 bản ghi để insert vào hóa đơn chi tiết.
//Giả hàng chứa các ID_SPCT và ID_HĐ để thực hiện insert vòa HĐCT.

public class GioHang {
    
    private int id;
    private int id_hoaDon;
    private int id_spct;
    private int soLuongSP;//Số lượng của 1 spct ở trong 1 hóa đơn chi tiết.
    private BigDecimal giaTienTra; //Giá tiền sản phẩm tại thời điểm bán.
    private BigDecimal donGia; // = giá tiền SPCT * SL SPCT.

    public GioHang() {
    }

    public GioHang(int id, int id_hoaDon, int id_spct, int soLuongSP, BigDecimal giaTienTra, BigDecimal donGia) {
        this.id = id;
        this.id_hoaDon = id_hoaDon;
        this.id_spct = id_spct;
        this.soLuongSP = soLuongSP;
        this.giaTienTra = giaTienTra;
        this.donGia = donGia;
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

    public int getId_spct() {
        return id_spct;
    }

    public void setId_spct(int id_spct) {
        this.id_spct = id_spct;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public BigDecimal getGiaTienTra() {
        return giaTienTra;
    }

    public void setGiaTienTra(BigDecimal giaTienTra) {
        this.giaTienTra = giaTienTra;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
    

    
    
}
