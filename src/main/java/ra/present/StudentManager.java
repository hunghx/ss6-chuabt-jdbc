package ra.present;

import ra.bussiness.model.Student;
import ra.bussiness.service.IStudentService;
import ra.bussiness.serviceIpl.StudentService;
import ra.bussiness.util.Format;
import ra.bussiness.util.InputMethods;

import java.util.Date;
import java.util.List;

public class StudentManager {
    private static final IStudentService studentService = new StudentService();
    public static void main(String[] args) {
        while (true) {
            System.out.println("=======================Menu=======================");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên theo id");
            System.out.println("4. Xóa Sinh viên");
            System.out.println("5. Thoát chng trình");

            System.out.println("-----------Nhập lựa chọn của bạn-----------");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    displayAllStudent();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nập không hợp lệ");
                    break;
            }
        }
    }
    //chuc nang hiển thị
    private static void displayAllStudent(){
        List<Student> students = studentService.findAll();
        if (students.isEmpty()){
            System.err.println("Danh sách trống");
            return;
        }
        for (Student s: students){
            System.out.println(s);
        }
    }
    // thêm mới
    private static void addNewStudent(){
        System.out.println("Nhập số lươg sinh viên cần thêm");
        int count = InputMethods.getInteger();
        for (int i = 1; i <=count ; i++) {
            System.out.println("------Nhập thông tin cho sv thứ "+i+"--------");
            System.out.println("Nhập Họ ");
            String lastName  = InputMethods.getString();
            System.out.println("Nhập tên ");
            String firstName  = InputMethods.getString();
            System.out.println("Nhập Ngày sinh ");
            Date date  = Format.convertToDate(InputMethods.getString());
            System.out.println("Nhập giơi tính ");
            Boolean sex = InputMethods.getBoolean();
            Student  s = new Student(null,lastName,firstName,date,sex);
            studentService.add(s);
        }
        System.out.println("Thêm mới thành công "+count+" sinh viên");
    }
}
