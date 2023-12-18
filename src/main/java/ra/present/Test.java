package ra.present;

import ra.bussiness.util.InputMethods;
import ra.bussiness.util.Validate;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hẫy nập vào email");
        String email = InputMethods.getString();
        if (!Validate.validated(email)){
            System.err.println("Email không đúng định dang");
        }

    }
}
