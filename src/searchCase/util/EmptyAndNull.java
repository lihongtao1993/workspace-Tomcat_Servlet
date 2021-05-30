package searchCase.util;

public class EmptyAndNull {
    public static boolean isEmptyOrNull(String str){
        if (str == null || str.equals("")){
            return true;
        }else {
            return false;
        }
    }
}
