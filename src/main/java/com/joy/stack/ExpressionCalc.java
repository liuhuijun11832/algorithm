package com.joy.stack;

/**
 * 表达式计算
 *
 * @author Joy
 * @date 2022-11-24
 */
public class ExpressionCalc {

    private ArrayStack operator = new ArrayStack(10);

    private ArrayStack num = new ArrayStack(10);

    private ArrayStack brackets = new ArrayStack(10);

    public int calc(String expression) {
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i++);
            if (c == '+'
                || c == '-'
                || c == '*'
                || c == '/') {
                String symbol = operator.peek();
                // 如果本次运算符栈的优先级小于等于上一个运算符，则执行上一个操作
                if ((c == '+' || c == '-') && !"".equals(symbol)) {
                    calculate();
                }
                operator.push(String.valueOf(c));
            }else {
                num.push(String.valueOf(c));
            }
        }
        calculate();
        return Integer.parseInt(num.pop());
    }

    private void calculate(){
        String pop1;
        String pop2;
        int r = 0;
        while (!"".equals(pop1 = num.pop()) && !"".equals(pop2 = num.pop())){
            String ope = operator.pop();
            if("*".equals(ope)){
                r = Integer.parseInt(pop1) * Integer.parseInt(pop2);
            }else if("/".equals(ope)){
                r = Integer.parseInt(pop2) / Integer.parseInt(pop1);
            }else if("+".equals(ope)){
                r = Integer.parseInt(pop1) + Integer.parseInt(pop2);
            }else{
                r = Integer.parseInt(pop2) - Integer.parseInt(pop1);
            }
            num.push(r + "");
        }
        num.push(r + "");
    }

    public static class ArrayStack {

        private String[] data;

        private int dataCount;

        private int capacity;

        public ArrayStack(int capacity) {
            this.data = new String[capacity];
            this.capacity = capacity;
        }

        public boolean push(String c) {
            if (dataCount == capacity) {
                return false;
            }
            data[dataCount++] = c;
            return true;
        }

        public String pop() {
            if (dataCount == 0) {
                return "";
            }
            String temp = data[dataCount-1];
            dataCount--;
            return temp;
        }

        public String peek(){
            if (dataCount == 0) {
                return "";
            }
            return data[dataCount - 1];
        }
    }

    public static void main(String[] args) {
        ExpressionCalc expres = new ExpressionCalc();
        System.out.println(expres.calc("1+1+2*3+6*5+9"));
    }

}
