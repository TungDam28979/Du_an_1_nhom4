/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package du_an_1_ql_ban_giay.utility;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBConnect {
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = """
            jdbc:sqlserver://localhost:1433;databaseName=DB_DA1_Final;
            encrypt=true;trustServerCertificate=true;""";
    private static final String user = "sa";
    private static final String password = "123";

    //Phần sẽ chạy trước cả hàm main
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi Driver");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Lỗi kết nối ");
            e.printStackTrace();
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection cn = getConnection();
        System.out.println(cn != null ? "Kết nối thành công" : "Kết nối thất bại");
    }
    
}
