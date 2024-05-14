package du_an_1_ql_ban_giay.dao;

import java.util.List;

//Khuôn mẫu tạo ra các lớp DAO đại diện cho mỗi loại đối tượng (.) model.
public interface DA1_DAO<E, K> {

    /*
    1.phương thức này chèn một đối tượng kiểu E vào csdl
     */
    void insert(E e);

    /*
    2.phương thức cập nhật một đối tượng E vào csdl.
     */
    void update(E e);

    //3.Xóa một đối tượng trong bảng theo Primary key.
    void delete(K k);

    /*
    4.Lấy ra một danh sách các đối tượng kiểu E khỏi csdl.
     */
    List<E> selectAll();

    /*
    6.Lấy ra một đối tượng kiểu E dựa vào khóa biểu K cho trước. 
     */
    E selectById(K k);

    /*
    5.Lấy ra một danh sách các đối tượng kiểu E từ CSDL theo một câu lệnh 
    SQL cho trước và tham số truyền vào.
     */
    List<E> selectBySQL(String sql, Object... args);

}
