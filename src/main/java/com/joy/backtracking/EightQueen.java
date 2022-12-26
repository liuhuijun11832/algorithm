package com.joy.backtracking;

/**
 * 八皇后问题
 */
public class EightQueen {

    private int[] checkerboard = new int[8];

    public static void main(String[] args) {
        EightQueen e = new EightQueen();
        e.calcQueens(0);
    }

    public void calcQueens(int row){
        if(row == 8){
            // 打印棋盘
            printQueens();
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)){
                checkerboard[row] = column;
                calcQueens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column){
        int leftUp = column - 1,rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--){
            // 判断上一行的column列是否有棋子
            if(checkerboard[i] == column){
                return false;
            }
            // 判断上一行的左对角线是否有棋子
            if(leftUp >= 0 && checkerboard[i] == leftUp){
                return false;
            }
            // 判断上一行的右对角线是否有棋子
            if(rightUp < 8 && checkerboard[i] == rightUp){
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void printQueens(){
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if(checkerboard[row] == column){
                    System.out.print("Q ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
