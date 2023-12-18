package ra.bussiness.daoIpl;

import ra.bussiness.dao.IStudentDao;
import ra.bussiness.model.Student;
import ra.bussiness.util.ConnectDB;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("SELECT * from Student");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setSex(rs.getBoolean("sex"));
                s.setBirthDay(rs.getDate("birthday"));
                list.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn); // đóng kết nôi
        }
        return list;
    }

    @Override
    public Student findById(Long id) {
        Student s = null;
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("SELECT * from Student where id = ?");
            // set tham số
            call.setLong(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setSex(rs.getBoolean("sex"));
                s.setBirthDay(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn); // đóng kết nối
        }
        return s;
    }

    @Override
    public void save(Student student) {
        Connection conn = ConnectDB.openConnection();
        CallableStatement call = null;
        try {
            if (student.getId() == null) {
                // chức năng thêm mới
                call = conn.prepareCall("insert into student(last_name, first_name, birthday, sex) value (?,?,?,?)");
                call.setString(1, student.getLastName());
                call.setString(2, student.getFirstName());
                call.setDate(3, new Date(student.getBirthDay().getTime())); // date trong mysql tương thích với java.sql.Date trong java
                call.setBoolean(4, student.getSex());
            } else {
                // chức năng cập nhật
                call = conn.prepareCall("update  student set last_name =?, first_name=?, birthday=?, sex=? where id = ?");
                call.setString(1, student.getLastName());
                call.setString(2, student.getFirstName());
                call.setDate(3, new Date(student.getBirthDay().getTime())); // date trong mysql tương thích với java.sql.Date trong java
                call.setBoolean(4, student.getSex());
                call.setLong(5, student.getId());
            }
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn); // đóng kết nối
        }
    }

    @Override
    public void delete(Long id) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("delete  from student where id = ?");
            call.setLong(1, id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn); // đóng kết nối
        }
    }
}
