package ra.bussiness.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Format {
    public static final SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
    public static Date convertToDate(String str){
        while (true){
            try {
               Date date =  spf.parse(str);
                return date;
            } catch (ParseException e) {
                System.err.println("Định dạng không hợp lệ");
            }
        }

    }
}
