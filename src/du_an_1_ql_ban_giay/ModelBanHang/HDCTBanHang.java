package du_an_1_ql_ban_giay.ModelBanHang;

import java.math.BigDecimal;

public class HDCTBanHang {

    private int id;
    private int id_hd;
    private int id_ctsp;
    private int soLuongSP;//Số lượng của 1 spct ở trong 1 hóa đơn chi tiết.
    private BigDecimal giaTienTra; //Giá tiền của SP tại thời điểm nào đó.
    private BigDecimal donGia;     //Là bằng Giá tiền trả * số lượng. Để tiện cho phần thống kê.

    public HDCTBanHang() {
    }
    
    //Dùng để tạo đối tượng đầy đủ TT =))
    public HDCTBanHang(int id, int id_ctsp, int id_hd, int soLuongSP, BigDecimal giaTienTra, BigDecimal donGia) {
        this.id = id;
        this.id_ctsp = id_ctsp;
        this.id_hd = id_hd;
        this.soLuongSP = soLuongSP;
        this.giaTienTra = giaTienTra;
        this.donGia = donGia;
    }
    //Này dùng để insert
    public HDCTBanHang(int id_hd, int id_ctsp, int soLuongSP, BigDecimal giaTienTra, BigDecimal donGia) {
        this.id_hd = id_hd;
        this.id_ctsp = id_ctsp;
        this.soLuongSP = soLuongSP;
        this.giaTienTra = giaTienTra;
        this.donGia = donGia;
    }
    //Dùng để lưu giữ thông tin update
    public HDCTBanHang(int id, int soLuongSP, BigDecimal donGia) {
        this.id = id;
        this.soLuongSP = soLuongSP;
        this.donGia = donGia;
    }
   
    
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ctsp() {
        return id_ctsp;
    }

    public void setId_ctsp(int id_ctsp) {
        this.id_ctsp = id_ctsp;
    }

    public int getId_hd() {
        return id_hd;
    }

    public void setId_hd(int id_hd) {
        this.id_hd = id_hd;
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
