package du_an_1_ql_ban_giay.model;

import java.util.Date;

public class GtenGiay implements interfaceModels {

    private int id; //1
    private String Name; //2
    private String Status; //3
    private int create_By; //4
    private int update_By;//5
    private Date create_At;//6
    private Date update_At;//7
    
    private String createByString;
    private String updateByString;
    
    public GtenGiay() {
    }

    public GtenGiay(int id, String Name, String Status, int create_By, int update_By, Date create_At, Date update_At) {
        this.id = id;
        this.Name = Name;
        this.Status = Status;
        this.create_By = create_By;
        this.update_By = update_By;
        this.create_At = create_At;
        this.update_At = update_At;
    }

    public GtenGiay(int id, String Name, String Status, int create_By, int update_By, Date create_At, Date update_At, String createByString, String updateByString) {
        this.id = id;
        this.Name = Name;
        this.Status = Status;
        this.create_By = create_By;
        this.update_By = update_By;
        this.create_At = create_At;
        this.update_At = update_At;
        this.createByString = createByString;
        this.updateByString = updateByString;
    }

    public String getCreateByString() {
        return createByString ;
    }

    public void setCreateByString(String createByString) {
        this.createByString = createByString;
    }

    public String getUpdateByString() {
        return updateByString;
    }

    public void setUpdateByString(String updateByString) {
        this.updateByString = updateByString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCreate_By() {
        return create_By;
    }

    public void setCreate_By(int create_By) {
        this.create_By = create_By;
    }

    public int getUpdate_By() {
        return update_By;
    }

    public void setUpdate_By(int update_By) {
        this.update_By = update_By;
    }

    public Date getCreate_At() {
        return create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public Date getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

    @Override
    public String getName_TT_Insert() {
        return Name;
    }

    @Override
    public int getId_TT_Insert() {
        return id;
    }

}
