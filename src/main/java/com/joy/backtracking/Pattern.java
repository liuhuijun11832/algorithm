package com.joy.backtracking;

/**
 * 正则表达式
 *
 * @author Joy
 * @date 2022-12-26
 */
public class Pattern {

    private boolean matched = false;

    /**
     * 正则表达式
     */
    private char[] pattern;

    /**
     * 正则表达式长度
     */
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen){
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen){
        if (matched) {
            return;
        }
        if(pj == plen){
            if(ti == tlen){
                matched = true;
                return;
            }
        }
        if(pattern[pj] == '*'){
            for (int i = 0; i < tlen - ti; i++) {
                // *匹配0或多个，所以从文本传的当前位置往后尝试
                rmatch(ti + i, pj + 1, text, tlen);
            }
        }else if(pattern[pj] == '?'){
            // 匹配0个的情况
            rmatch(ti, pj + 1, text, tlen);
            // 匹配1个的情况
            rmatch(ti + 1, pj + 1, text, tlen);
        }else if(ti < tlen && pattern[pj] == text[ti]){
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}
