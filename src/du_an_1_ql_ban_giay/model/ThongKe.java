/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.model;

import java.math.BigDecimal;

/**
 *
 * @author cuong
 */
public class ThongKe {
    private Integer id_sp;
    private BigDecimal giasp;
    private Integer soluongdaban;
    private BigDecimal doanhthu;

    public ThongKe() {
    }

    public ThongKe(int id_sp, BigDecimal giasp, int soluongdaban, BigDecimal doanhthu) {
        this.id_sp = id_sp;
        this.giasp = giasp;
        this.soluongdaban = soluongdaban;
        this.doanhthu = doanhthu;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public BigDecimal getGiasp() {
        return giasp;
    }

    public void setGiasp(BigDecimal giasp) {
        this.giasp = giasp;
    }

    public int getSoluongdaban() {
        return soluongdaban;
    }

    public void setSoluongdaban(int soluongdaban) {
        this.soluongdaban = soluongdaban;
    }

    public BigDecimal getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(BigDecimal doanhthu) {
        this.doanhthu = doanhthu;
    }
    

}
