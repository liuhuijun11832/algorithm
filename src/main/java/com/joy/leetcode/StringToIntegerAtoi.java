package com.joy.leetcode;

import java.util.HashSet;

/**
 * 字符串转数字
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        StringToIntegerAtoi aaaa = new StringToIntegerAtoi();
        System.out.println(aaaa.myAtoi("    -42"));
        System.out.println(aaaa.myAtoi("4193 with words"));
        System.out.println(aaaa.myAtoi(" with words 20010"));
    }

    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0, symbol = 1;
        while (index < s.length()){
            char c = s.charAt(index++);
            if(c == ' '){
                if(sb.length() == 0){
                    continue;
                }else{
                    break;
                }
            }
            if(c == '-'){
                if(sb.length() == 0){
                    symbol = -1;
                }else{
                    break;
                }
            }
            if (Character.isDigit(c)) {
                sb.append(c);
            }else if(sb.length() > 0 || Character.isLetter(c)){
                break;
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        if(symbol == 1){
            if(sb.length() > String.valueOf(Integer.MAX_VALUE).length()){
                return Integer.MAX_VALUE;
            }else if(sb.length() == String.valueOf(Integer.MAX_VALUE).length()){
                if(Integer.parseInt(sb.substring(0, sb.length() - 1)) > (Integer.MAX_VALUE/10)){
                    return Integer.MAX_VALUE;
                }else if(Integer.parseInt(sb.substring(0, sb.length() - 1)) == (Integer.MAX_VALUE/10)){
                    if(Integer.MAX_VALUE % 10 < Integer.parseInt(Character.toString(s.charAt(s.length()-1))) ){
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }else {
            if(sb.length() > String.valueOf(Integer.MIN_VALUE).length() - 1){
                return Integer.MIN_VALUE;
            }else if(sb.length() == String.valueOf(Integer.MIN_VALUE).length() - 1){
                if(Integer.parseInt(sb.substring(0, sb.length() - 2)) > (Integer.MIN_VALUE/10)){
                    return Integer.MIN_VALUE;
                }else if(Integer.parseInt(sb.substring(0, sb.length() - 2)) == (Integer.MIN_VALUE/10)){
                    if(Integer.MIN_VALUE % 10 < Integer.parseInt(Character.toString(s.charAt(s.length()-1))) ){
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }
        return Integer.parseInt(sb.toString()) * symbol;
    }

}
