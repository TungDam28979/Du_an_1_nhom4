package du_an_1_ql_ban_giay.model;

import java.util.Date;

public class HoaDonKH {

    private int id;
    private String idKH;
    private String idNV;
    private int idPGG;
    private int idHTTT;
    private String name;
    private String phone;
    private String address;
    private Date ngayNNH;
    private boolean trangThai;
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;
    private double thanhTien;

    public HoaDonKH() {
    }

    public HoaDonKH(int id, String address, Date ngayNNH) {
        this.id = id;
        this.address = address;
        this.ngayNNH = ngayNNH;
    }

    public HoaDonKH(String address, double thanhTien, Date ngayNNH) {
        this.address = address;
        this.thanhTien = thanhTien;
        this.ngayNNH = ngayNNH;
    }

    public HoaDonKH(int id, String idKH, String idNV, int idPGG, int idHTTT, String name, String phone, String address, Date ngayNNH, boolean trangThai, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idPGG = idPGG;
        this.idHTTT = idHTTT;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.ngayNNH = ngayNNH;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public int getIdPGG() {
        return idPGG;
    }

    public void setIdPGG(int idPGG) {
        this.idPGG = idPGG;
    }

    public int getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(int idHTTT) {
        this.idHTTT = idHTTT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayNNH() {
        return ngayNNH;
    }

    public void setNgayNNH(Date ngayNNH) {
        this.ngayNNH = ngayNNH;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
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
}
