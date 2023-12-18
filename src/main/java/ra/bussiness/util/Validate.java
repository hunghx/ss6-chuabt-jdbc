package ra.bussiness.util;

import java.util.regex.Pattern;

public class Validate {
    public static boolean validated(String email){
        // pattern
        final   String pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        return Pattern.compile(pattern,Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }
}
