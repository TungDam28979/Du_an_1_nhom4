package model;

import java.util.Date;

public class KhachHang {

    private int id;
    private String maKH;
    private String name;
    private boolean gender;
    private String phone;
    private String email;
    private String address;
    private int createBy;
    private int updateBy;
    private Date createAt;
    private Date updateAt;

    public KhachHang() {
    }

    public KhachHang(String name, boolean gender, String phone, String email, String address) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public KhachHang(String maKH, String name, boolean gender, String phone, String email, String address) {
        this.maKH = maKH;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public KhachHang(int id, String maKH, String name, boolean gender, String phone, String email, String address, int createBy, int updateBy, Date createAt, Date updateAt) {
        this.id = id;
        this.maKH = maKH;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    //---Thêm cho phần hóa đơn ( tiền thừa + tổng tiền + tiền phải trả của HĐ ) của khách hàng
    private int tienThua;
    private int tongTienTra;
    private int tongGTHD;

    public int getTongGTHD() {
        return tongGTHD;
    }

    public void setTongGTHD(int tongGTHD) {
        this.tongGTHD = tongGTHD;
    }

    public int getTienThua() {
        return tienThua;
    }

    public void setTienThua(int tienThua) {
        this.tienThua = tienThua;
    }

    public int getTongTienTra() {
        return tongTienTra;
    }

    public void setTongTienTra(int tongTienTra) {
        this.tongTienTra = tongTienTra;
    }

}
