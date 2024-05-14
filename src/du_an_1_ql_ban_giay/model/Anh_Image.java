package du_an_1_ql_ban_giay.model;

public class Anh_Image {

    private int id;
    private String tenAnh;
    private String trangThai;
    private int nguoiSua;
    private int nguoiTao;

    public Anh_Image() {
    }

    public Anh_Image(int id, String tenAnh, String trangThai, int nguoiSua, int nguoiTao) {
        this.id = id;
        this.tenAnh = tenAnh;
        this.trangThai = trangThai;
        this.nguoiSua = nguoiSua;
        this.nguoiTao = nguoiTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

}
