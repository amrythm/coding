package Strings;

import java.util.HashMap;

//Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
//
//For example:
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
public class ExcelSheetColumnNumber {

    public static void main(String args[]) {
        String s = "ZYZZ";
        int l = s.length();

        System.out.println(columnNumber(s,l));
    }

    public static double columnNumber(String s, int l) {

        if(s == null)
            return  0;

        double res =0;

        for (int i = 0; i<l; i++) {
            int m = s.charAt(i) - 64;
            res = res + Math.pow(26,l-i-1)*m;
        }
        return res;
    }
}

