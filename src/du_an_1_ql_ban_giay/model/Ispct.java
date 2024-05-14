package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;
import java.util.Date;
    
public class Ispct {
    
    private int id;
    private String NamechatLieu;
    private String NamedayGiay;
    private String NamedeGiay;
    private String NamekichCo;
    private String NamemauSac;
    private String NametenGiay;
    private String NamethuongHieu;
    private String Nameanh;
    private int soLuong;
    private BigDecimal giaBan;
    private String moTa;
    private String maQR;

    private String trangThai;
    private int create_by;
    private int update_by;
    private Date create_at;
    private Date update_at;
    private int deleted;

    public Ispct() {
    }

    public Ispct(int id, String NamechatLieu, String NamedayGiay, String NamedeGiay, String NamekichCo, String NamemauSac, String NametenGiay, String NamethuongHieu, String Nameanh, int soLuong, BigDecimal giaBan, String moTa, String maQR, String trangThai, int create_by, int update_by, Date create_at, Date update_at, int deleted) {
        this.id = id;
        this.NamechatLieu = NamechatLieu;
        this.NamedayGiay = NamedayGiay;
        this.NamedeGiay = NamedeGiay;
        this.NamekichCo = NamekichCo;
        this.NamemauSac = NamemauSac;
        this.NametenGiay = NametenGiay;
        this.NamethuongHieu = NamethuongHieu;
        this.Nameanh = Nameanh;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamechatLieu() {
        return NamechatLieu;
    }

    public void setNamechatLieu(String NamechatLieu) {
        this.NamechatLieu = NamechatLieu;
    }

    public String getNamedayGiay() {
        return NamedayGiay;
    }

    public void setNamedayGiay(String NamedayGiay) {
        this.NamedayGiay = NamedayGiay;
    }

    public String getNamedeGiay() {
        return NamedeGiay;
    }

    public void setNamedeGiay(String NamedeGiay) {
        this.NamedeGiay = NamedeGiay;
    }

    public String getNamekichCo() {
        return NamekichCo;
    }

    public void setNamekichCo(String NamekichCo) {
        this.NamekichCo = NamekichCo;
    }

    public String getNamemauSac() {
        return NamemauSac;
    }

    public void setNamemauSac(String NamemauSac) {
        this.NamemauSac = NamemauSac;
    }

    public String getNametenGiay() {
        return NametenGiay;
    }

    public void setNametenGiay(String NametenGiay) {
        this.NametenGiay = NametenGiay;
    }

    public String getNamethuongHieu() {
        return NamethuongHieu;
    }

    public void setNamethuongHieu(String NamethuongHieu) {
        this.NamethuongHieu = NamethuongHieu;
    }

    public String getNameanh() {
        return Nameanh;
    }

    public void setNameanh(String Nameanh) {
        this.Nameanh = Nameanh;
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

}
