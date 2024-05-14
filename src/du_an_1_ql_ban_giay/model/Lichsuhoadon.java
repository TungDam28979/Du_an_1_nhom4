/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Lichsuhoadon {

    private int mahoadon;
    private String tennhanvien;
    private String tenkhachhang;
    private int soluong;
    private BigDecimal dongia;
    private Date ngaytao;
    private Date ngaygiao;
    private Date ngaynhan;

    public Lichsuhoadon() {
    }

    public Lichsuhoadon(int mahoadon, String tennhanvien, String tenkhachhang, int soluong, BigDecimal dongia, Date ngaytao, Date ngaygiao, Date ngaynhan) {
        this.mahoadon = mahoadon;
        this.tennhanvien = tennhanvien;
        this.tenkhachhang = tenkhachhang;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ngaytao = ngaytao;
        this.ngaygiao = ngaygiao;
        this.ngaynhan = ngaynhan;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(Date ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public Date getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(Date ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public String Thanhtien() {
         BigDecimal soluongm = new BigDecimal(soluong);
        BigDecimal tt = soluongm.multiply(dongia);
        DecimalFormat currencyFormat = new DecimalFormat("###,###.##"+" VND");
        String formattedValue = currencyFormat.format(tt);

        return formattedValue;
    }
}
