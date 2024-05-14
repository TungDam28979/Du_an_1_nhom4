<<<<<<< HEAD
package du_an_1_ql_ban_giay.model;
=======
package model;
>>>>>>> 12bff6c2505223ff31948d4d495c4aa776698a1b

import java.util.Date;

public class NhanVien {

    private int id; //Mạnh tạo -- ko xóa
    private String maNV;
    private boolean chucVu;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String sdt;
    private String email;
    private String matKhau;
    private String diaChi;
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;
    private boolean deleted;

    public NhanVien() {
    }

    public NhanVien(String maNV, boolean chucVu, String hoTen, boolean gioiTinh, Date ngaySinh, String sdt, String email, String matKhau, String diaChi, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua, boolean deleted) {
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.deleted = deleted;
    }

    public NhanVien(String maNV, boolean chucVu, String hoTen, boolean gioiTinh, Date ngaySinh, String sdt, String email, String diaChi) {
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }

    public NhanVien(int id, String maNV, boolean chucVu, String hoTen, boolean gioiTinh, Date ngaySinh, String sdt, String email, String matKhau, String diaChi, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua, boolean deleted) {
        this.id = id;//Mạnh tạo -- đừng xóa 
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.maNV,
            this.chucVu,
            this.hoTen,
            this.gioiTinh,
            this.ngaySinh,
            this.sdt,
            this.email,
            this.diaChi,};
    }
}
