
package du_an_1_ql_ban_giay.model;


public class GetChucVu {
    
    private static int id;
    private static String Manv;
    private static String matkhau;
    private static int chucvu;

    public static String getManv() {
        return Manv;
    }

    public static void setManv(String Manv) {
        GetChucVu.Manv = Manv;
    }

    public static String getMatkhau() {
        return matkhau;
    }

    public static void setMatkhau(String matkhau) {
        GetChucVu.matkhau = matkhau;
    }

    public static int getChucvu() {
        return chucvu;
    }

    public static void setChucvu(int chucvu) {
        GetChucVu.chucvu = chucvu;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        GetChucVu.id = id;
    }

}
