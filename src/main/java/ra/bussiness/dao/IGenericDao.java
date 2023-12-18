package ra.bussiness.dao;

import java.util.List;

public interface IGenericDao <U,T , E>{
    List<U> findAll();
    T findById(E id);
    void save(T t);  // vừa thêm mới vừa cập nhập
    void delete(E id);
}
