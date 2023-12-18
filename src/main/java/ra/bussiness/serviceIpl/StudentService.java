package ra.bussiness.serviceIpl;

import ra.bussiness.dao.IStudentDao;
import ra.bussiness.daoIpl.StudentDao;
import ra.bussiness.model.Student;
import ra.bussiness.model.StudentDto;
import ra.bussiness.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private static final IStudentDao studentDao = new StudentDao();
    @Override
    public List<StudentDto> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public void add(Student s) {
        studentDao.save(s);
    }

    @Override
    public void update(Student s) {
        studentDao.save(s);
    }

    @Override
    public void delete(Long id) {
        studentDao.delete(id);
    }
}
