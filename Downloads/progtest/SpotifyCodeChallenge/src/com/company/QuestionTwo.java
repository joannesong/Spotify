package com.company;



public class QuestionTwo {
    public static void main(String[] args) {
        System.out.println(decodeString("4[ab]"));
        System.out.println(decodeString("2[b3[a]]"));

    }

    public static String decodeString(String s) {
        if (s.length() == 0) return s;
        int counter = 0;

        int leftIndx = -1;
        int rightIndx = s.length();
        char[] sChars = s.toCharArray();

        for (int index = 0; index < sChars.length; ++index) {
            if (sChars[index] == '[') {
                if (counter == 0) leftIndx = index;
                ++counter;
            } else if (sChars[index] == ']') {
                --counter;
                if (counter == 0) {
                    rightIndx = index;
                    break;
                }
            }
        }

        if (leftIndx == -1 && rightIndx == s.length()) return s;

        int repeat = 0, firstDigitIndex = leftIndx;
        for (int i = leftIndx - 1, j = 0; i >= 0 && Character.isDigit(sChars[i]); --i, ++j) {
            repeat += (sChars[i] - '0') * Math.pow(10, j);
            firstDigitIndex = i;
        }

        StringBuilder output = new StringBuilder();
        String decodedStr = decodeString(s.substring(leftIndx + 1, rightIndx));

        output.append(s.substring(0, firstDigitIndex));

        for (int i = 0; i < repeat; ++i) output.append(decodedStr);
        output.append(decodeString(s.substring(rightIndx + 1, s.length())));

        return output.toString();
    }
}
