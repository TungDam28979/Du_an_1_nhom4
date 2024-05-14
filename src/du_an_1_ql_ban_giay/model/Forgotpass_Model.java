/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.model;

/**
 *
 * @author Admin
 */
public class Forgotpass_Model {

    private String user;
    private String matkhau;
    private String email;

    public Forgotpass_Model() {
    }

    public Forgotpass_Model(String user, String matkhau) {
        this.user = user;
        this.matkhau = matkhau;
    }

    public Forgotpass_Model(String user, String matkhau, String email) {
        this.user = user;
        this.matkhau = matkhau;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
