package pack;
//import ReservedWord;

import java.util.Stack;

public class Scanner {
    static StringBuilder result = new StringBuilder();

    static int checkError(String string) {
        Stack<Character> bracket = new Stack<>();
        Stack<Character> parenthesis = new Stack<>();
        StringBuilder str = new StringBuilder();
        char[] chars = string.toCharArray();
        int i;
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == '{')
                bracket.push(chars[i]);
            else if (chars[i] == '}' && !bracket.isEmpty())
                bracket.pop();
            else if (chars[i] == '}' && bracket.isEmpty())
                return i;
//            else if (i == chars.length - 1 && !bracket.isEmpty())
//                return i;

            else if (chars[i] == '(')
                parenthesis.push(chars[i]);
            else if (chars[i] == ')' && !parenthesis.isEmpty())
                parenthesis.pop();
            else if (chars[i] == ')' && parenthesis.isEmpty())
                return i;
            else if (i == chars.length - 1 && !parenthesis.isEmpty())
                return i;

            if (Character.isDigit(chars[i])) {
                if ((i == 0 || chars[i - 1] == ' ') && Character.isAlphabetic(chars[i + 1]) )
                    return i;
            }
        }
        if (!bracket.isEmpty() || !parenthesis.isEmpty())
            return i-1;
        return -1;
    }

    static String getToken2(String string) {
        result = new StringBuilder();
        char[] chars = string.toCharArray();
        StringBuilder checker = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        int errorIndex = checkError(string);
//        StringBuilder result = new StringBuilder();
        boolean isReserved = false;
        for (int i = 0; i < string.length(); ++i) {
            if (i == errorIndex)
                return result.toString() + " error in index: " + (i + 1) + ",";
            if (chars[i] == '{') {
                for (int j = i; chars[j] != '}' /*&& (j <= errorIndex || errorIndex == -1)*/; j++) {
                    result.append(chars[j]);
                    i = j;
                    if (i == errorIndex)
                        return result.toString() + " error in index: " + (i + 1) + ",";
                    if (j < chars.length-1 && chars[j+1] == '}')
                        result.append("} , Comment ,");
                }
            }
            else if (Character.isAlphabetic(chars[i])) {
                checker.append(chars[i]);
                if (Character.isDigit(chars[i+1])) {
                    i++;
                    checker.append(chars[i]);
                }
                else if (i != string.length() - 1 && !Character.isAlphabetic(chars[i+1])) {
                    String str = checker.toString();
                    for (ReservedWord r : ReservedWord.values()) {
                        if (str.contains(r.toString())) {
                            result.append(str);
                            result.append(", Reserved word ,");
                            isReserved = true;
                            break;
                        }
                    }
                    if (!isReserved) {

                        result.append(str);
                        result.append(" , Identifier ,");
                    }
                    checker.delete(0, checker.length());
                    isReserved = false;
                }
            }
            else if (Character.isDigit(chars[i])) {
                numbers.append(chars[i]);
                if (i != string.length() - 1 && Character.isDigit(chars[i + 1]))
                    continue;
                result.append(numbers.toString());
                numbers.delete(0, numbers.length());
                result.append(", Number ,");
            }
            else if (chars[i] == '+') {
                result.append(chars[i]);
                result.append(" , Addition operator ,");
            } else if (chars[i] == '-') {
                result.append(chars[i]);
                result.append(", Subtract operator ,");
            } else if (chars[i] == '*') {
                result.append(chars[i]);
                result.append(", Multiplication operator ,");
            } else if (chars[i] == '/') {
                result.append(chars[i]);
                result.append(" , Division operator ,");
            } else if (chars[i] == '=' && chars[i - 1] != ':') {
                result.append(chars[i]);
                result.append(" , Equal operator ,");
            } else if (chars[i] == ':' && chars[i + 1] == '=') {
                result.append(chars[i]);
                result.append("=, Assign operation ,");
            } else if (chars[i] == '<') {
                result.append(chars[i]);
                result.append(", Less than operation ,");
            } else if (chars[i] == '>') {
                result.append(chars[i]);
                result.append(", Greater than operation ,");
            } else if (chars[i] == '(') {
                result.append(chars[i]);
                result.append(", Open bracket ,");
            } else if (chars[i] == ')') {
                result.append(chars[i]);
                result.append(", Closed bracket, ");
            } else if (chars[i] == ';') {
                result.append(chars[i]);
                result.append(", semi colon ,");
            }
        }
//        System.out.println("result length: " + result.length());
        return result.toString();
    }
}
