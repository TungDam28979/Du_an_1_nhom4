package du_an_1_ql_ban_giay.model;

import java.util.Date;

public class Canh implements interfaceModels{
    
    private int id;
    private int id_CTSP;
    private String name;//Tên ảnh
    private String status;
    private int create_by;
    private int update_by;
    private Date create_at;
    private Date update_at;
    
    public Canh() {
    }

    public Canh(int id, int id_CTSP, String name, String status, int create_by, int update_by, Date create_at, Date update_at) {
        this.id = id;
        this.id_CTSP = id_CTSP;
        this.name = name;
        this.status = status;
        this.create_by = create_by;
        this.update_by = update_by;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_CTSP() {
        return id_CTSP;
    }

    public void setId_CTSP(int id_CTSP) {
        this.id_CTSP = id_CTSP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String getName_TT_Insert() {
        return name;
    }

    @Override
    public int getId_TT_Insert() {
       return id;
    }
    
    
    
    
}
