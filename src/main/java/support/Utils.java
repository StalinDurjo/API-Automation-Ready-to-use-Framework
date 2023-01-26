package support;

public final class Utils {
    public static String trimDoubleQuotation(String str){
        String returnString = str;
        String firstChar = String.valueOf(str.charAt(0));
        String lastChar = String.valueOf(str.charAt(str.length() - 1));

        if(str.length() > 1){
            if(firstChar.equals("\"") && lastChar.equals("\""))
                returnString = str.substring(1, str.length() -1);
        }else{
            throw new RuntimeException("trimDoubleQuotation() -> string length must greater than 1");
        }

        return returnString;
    }
}
