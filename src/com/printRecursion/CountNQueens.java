package com.printRecursion;

public class CountNQueens {
    public static void main(String[] args) {
      boolean[][] board=new boolean[4][4];
        System.out.println(countNQueens(board,0));
    }

    public  static int countNQueens(boolean[][]board,int row){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board[row].length;col++){
            if(isItSafe(board,row,col)){
                   board[row][col]=true;
                   count=count+countNQueens(board,row+1);
                   board[row][col]=false;
            }
        }
        return count;

    }

    private static boolean isItSafe(boolean[][] board, int row, int col) {
        //Horizontal Checking
        for(int i=row;i>=0;i--)
        {
            if(board[i][col])
                return false;
        }

        //Diagnol left
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j])
                return false;
        }

        //Diagnol Right
        for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j])
                return false;
        }


    return true;
    }



}
