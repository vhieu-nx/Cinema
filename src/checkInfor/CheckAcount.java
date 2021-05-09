package checkInfor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckAcount {


    public static final String CHECK_ACCOUNT ="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    public static final String CHECK_ID_RANDOM = "\\d{4}-\\d{4}";
    public static final Pattern CHECK_GMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$"

            ,
            Pattern.CASE_INSENSITIVE);
    public static final String CHECKPHONE = "^\\(?([0-9]{3})\\)?[-]?([0-9]{3})[-]?([0-9]{4})$";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean checkAccount(String account){
         pattern = Pattern.compile(CHECK_ACCOUNT);
         matcher = pattern.matcher(account);
        return matcher.find();
    }
    public static boolean checkID(String id){
        pattern = Pattern.compile(CHECK_ID_RANDOM);
         matcher = pattern.matcher(id);
        return matcher.find();
    }
    public static boolean checkPhone(String phone) {
        pattern = Pattern.compile(CHECKPHONE);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean checkEmail(String email){
        Matcher matcher = CHECK_GMAIL.matcher(email);
        return matcher.find();
    }
}
