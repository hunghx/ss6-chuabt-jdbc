package ra.present;

import ra.bussiness.daoIpl.StudentDao;
import ra.bussiness.util.InputMethods;
import ra.bussiness.util.Validate;

public class Test {
    private static final StudentDao studentDao = new StudentDao();
    public static void main(String[] args) {
        System.out.println(studentDao.calTotalStudentByClassId(2));
    }
}
