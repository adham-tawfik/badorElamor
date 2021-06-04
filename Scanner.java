package pack;
//import ReservedWord;

public class Scanner {
    static StringBuilder result = new StringBuilder();

    static String getToken2(String string) {
        char[] chars = string.toCharArray();
        StringBuilder checker = new StringBuilder();
//        StringBuilder result = new StringBuilder();
        boolean isReserved = false;
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isDigit(chars[i])) {
                if (i != string.length()-1 && Character.isDigit(chars[i+1]))
                    continue;
                 result.append("Number");
            }
            else if (Character.isAlphabetic(chars[i])) {
                checker.append(chars[i]);
                if (i != string.length()-1 && !Character.isAlphabetic(chars[i+1])) {
                    String str = checker.toString();
                    for (ReservedWord r : ReservedWord.values()) {
                        if (str.contains(r.toString())) {
                            result.append(" Reserved word ");
                            isReserved = true;
                            break;
                        }
                    }
                    if (!isReserved)
                         result.append(" Identifier ");
                    checker.delete(0, checker.length()-1);
                    isReserved = false;
                }
            }
            else if (chars[i] == '+')
                 result.append(" Addition operator ");
            else if (chars[i] == '-')
                 result.append(" Subtract operator ");
            else if (chars[i] == '*')
                 result.append(" Multiplication operator ");
            else if (chars[i] == '/')
                 result.append(" Division operator ");
            else if (chars[i] == '=' && chars[i-1] != ':')
                 result.append(" Equal operator ");
            else if (chars[i] == ':' && chars[i+1] == '=')
                 result.append(" Assign operation ");
            else if (chars[i] == '<')
                 result.append(" Less than operation ");
            else if (chars[i] == '>')
                 result.append(" Greater than operation ");
            else if (chars[i] == '(')
                 result.append(" Open bracket ");
            else if (chars[i] == ')')
                 result.append(" Closed bracket ");
            else if (chars[i] == ';')
                result.append(" semi colon ");
        }
        System.out.println("result length: " + result.length());
        return result.toString();
    }
}
