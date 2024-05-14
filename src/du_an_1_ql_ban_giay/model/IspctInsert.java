package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;
import java.util.Date;

public class IspctInsert {

    private int id_SPCT;
    //id_Các thuộc tính
    private int id_thuongHieu; //1
    private int id_kichThuoc;  //2
    private int id_mauSac;     //3
    private int id_chatLieu;   //4
    private int id_deGiay;     //5
    private int id_dayGiay;    //6
    private int id_tenGiay;    //7

    private int id_anh;
    //JTextFields
    private int soLuong;
    private BigDecimal giaBan;
    private String moTa;
    //
    private String maQR;  //Mã QR 

    private String trangThai; //Dựa vào SL > 0 ? "Còn Hàng"  : "Hết Hàng"

    //trình theo dõi SPCT
    private int create_by;
    private int update_by;
    private Date create_at;
    private Date update_at;
    private int deleted;

    public IspctInsert() {
    }

    public IspctInsert(int id_SPCT, int id_thuongHieu, int id_kichThuoc, int id_mauSac, int id_chatLieu, int id_deGiay, int id_dayGiay, int id_tenGiay, int id_anh, int soLuong, BigDecimal giaBan, String moTa, String maQR, String trangThai, int create_by, int update_by, Date create_at, Date update_at, int deleted) {
        this.id_SPCT = id_SPCT;
        this.id_thuongHieu = id_thuongHieu;
        this.id_kichThuoc = id_kichThuoc;
        this.id_mauSac = id_mauSac;
        this.id_chatLieu = id_chatLieu;
        this.id_deGiay = id_deGiay;
        this.id_dayGiay = id_dayGiay;
        this.id_tenGiay = id_tenGiay;
        this.id_anh = id_anh;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.maQR = maQR;
        this.trangThai = trangThai;
        this.create_by = create_by;
        this.update_by = update_by;
        this.create_at = create_at;
        this.update_at = update_at;
        this.deleted = deleted;
    }

    public int getId_SPCT() {
        return id_SPCT;
    }

    public void setId_SPCT(int id_SPCT) {
        this.id_SPCT = id_SPCT;
    }

    public int getId_thuongHieu() {
        return id_thuongHieu;
    }

    public void setId_thuongHieu(int id_thuongHieu) {
        this.id_thuongHieu = id_thuongHieu;
    }

    public int getId_kichThuoc() {
        return id_kichThuoc;
    }

    public void setId_kichThuoc(int id_kichThuoc) {
        this.id_kichThuoc = id_kichThuoc;
    }

    public int getId_mauSac() {
        return id_mauSac;
    }

    public void setId_mauSac(int id_mauSac) {
        this.id_mauSac = id_mauSac;
    }

    public int getId_chatLieu() {
        return id_chatLieu;
    }

    public void setId_chatLieu(int id_chatLieu) {
        this.id_chatLieu = id_chatLieu;
    }

    public int getId_deGiay() {
        return id_deGiay;
    }

    public void setId_deGiay(int id_deGiay) {
        this.id_deGiay = id_deGiay;
    }

    public int getId_dayGiay() {
        return id_dayGiay;
    }

    public void setId_dayGiay(int id_dayGiay) {
        this.id_dayGiay = id_dayGiay;
    }

    public int getId_tenGiay() {
        return id_tenGiay;
    }

    public void setId_tenGiay(int id_tenGiay) {
        this.id_tenGiay = id_tenGiay;
    }

    public int getId_anh() {
        return id_anh;
    }

    public void setId_anh(int id_anh) {
        this.id_anh = id_anh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaQR() {
        return maQR;
    }

    public void setMaQR(String maQR) {
        this.maQR = maQR;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getCreate_by() {
        return create_by;
    }

    public void setCreate_by(int create_by) {
        this.create_by = create_by;
    }

    public int getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(int update_by) {
        this.update_by = update_by;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
 
    

}//end life
