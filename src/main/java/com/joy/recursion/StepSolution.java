package com.joy.recursion;

/**
 * 台阶问题
 *
 * @author Joy
 * @date 2022-11-25
 */
public class StepSolution {

    public static void main(String[] args) {
        System.out.println(new StepSolution().solution(4));
    }

    private int solution(int steps){
        if(steps == 1){
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        return solution(steps - 1) + solution(steps - 2);
    }

}
