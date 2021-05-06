package CheckInfor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckAcount {


    public static final String CHECK_ACCOUNT ="^[A-Za-z]\\\\w{5,29}$";
    public static final String CHECK_ID_RANDOM = "\\d{4}-\\d{4}";
    public static final Pattern CHECK_GMAIL = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$",Pattern.CASE_INSENSITIVE);
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
    public static boolean checkEmail(String email){
        Matcher matcher = CHECK_GMAIL.matcher(email);
        return matcher.find();
    }
}
