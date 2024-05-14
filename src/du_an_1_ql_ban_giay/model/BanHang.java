/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Tran Viet Vuong
 */
public class BanHang {
     private int idsanpham;
    private String tensp;
    private String thuonghieusp;
    private int sizesp;
    private String mausp;
    private int soluong;
    private BigDecimal giasp;
    
    private int idhdct;
    private int idhoadon;
    private String tenkhachhang;
    private String sodienthoai;
    private String phieugiamgia;
    private Date ngaytao;
    private int hinhthucthanhtoan;
    private String tenphieugiamgia;
    private float giatriphieugiamgia;
        
    public BanHang() {
    }

    public BanHang(int idsanpham, String tensp, String thuonghieusp, int sizesp, String mausp, int soluong, BigDecimal giasp) {
        this.idsanpham = idsanpham;
        this.tensp = tensp;
        this.thuonghieusp = thuonghieusp;
        this.sizesp = sizesp;
        this.mausp = mausp;
        this.soluong = soluong;
        this.giasp = giasp;
    }

    public BanHang(int idhoadon, String tenkhachhang, String sodienthoai, String phieugiamgia, Date ngaytao, int hinhthucthanhtoan) {
        this.idhoadon = idhoadon;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.phieugiamgia = phieugiamgia;
        this.ngaytao = ngaytao;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public int getIdhdct() {
        return idhdct;
    }

    public void setIdhdct(int idhdct) {
        this.idhdct = idhdct;
    }

    public String getTenphieugiamgia() {
        return tenphieugiamgia;
    }

    public void setTenphieugiamgia(String tenphieugiamgia) {
        this.tenphieugiamgia = tenphieugiamgia;
    }

    public float getGiatriphieugiamgia() {
        return giatriphieugiamgia;
    }

    public void setGiatriphieugiamgia(float giatriphieugiamgia) {
        this.giatriphieugiamgia = giatriphieugiamgia;
    }
    
    

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getThuonghieusp() {
        return thuonghieusp;
    }

    public void setThuonghieusp(String thuonghieusp) {
        this.thuonghieusp = thuonghieusp;
    }

    public int getSizesp() {
        return sizesp;
    }

    public void setSizesp(int sizesp) {
        this.sizesp = sizesp;
    }

    public String getMausp() {
        return mausp;
    }

    public void setMausp(String mausp) {
        this.mausp = mausp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getGiasp() {
        return giasp;
    }

    public void setGiasp(BigDecimal giasp) {
        this.giasp = giasp;
    }

    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getPhieugiamgia() {
        return phieugiamgia;
    }

    public void setPhieugiamgia(String phieugiamgia) {
        this.phieugiamgia = phieugiamgia;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(int hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }
    
}
