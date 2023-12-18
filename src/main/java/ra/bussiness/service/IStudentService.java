package ra.bussiness.service;

import ra.bussiness.model.Student;
import ra.bussiness.model.StudentDto;

import java.util.List;

public interface IStudentService {
    List<StudentDto> findAll();
    Student findById(Long id);
    void add(Student s);
    void update(Student s);
    void delete(Long id);
}
