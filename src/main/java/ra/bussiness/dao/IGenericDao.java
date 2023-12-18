package ra.bussiness.dao;

import java.util.List;

public interface IGenericDao <T , E>{
    List<T> findAll();
    T findById(E id);
    void save(T t);  // vừa thêm mới vừa cập nhập
    void delete(E id);
}
