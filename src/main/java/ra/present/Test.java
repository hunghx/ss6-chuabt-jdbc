package ra.present;

import ra.bussiness.model.Student;

public class Test {
    public static void main(String[] args) {
        Student s= new Student();
        s.setId(1L);
        s.setFirstName("Hung");
        System.out.println(s);
    }
}
