package com.Backtracking;

public class D1_Queen_Premutation {

    public static void main(String[] args) {
        boolean board[]=new boolean[4];
        queen_Premutation(board,2,0,"");
    }

    public static void queen_Premutation(boolean board[],int total_queens,int queen_placed_so_Far,String ans){

        //base case
        if(total_queens==queen_placed_so_Far){
            System.out.println(ans);
        }


        for(int i=0;i<board.length;i++){

            //As Only Queen has to be placed only once so
            if(!board[i]){
            //Put your Queen so mark it as true
            board[i]=true;
            //Call for next Queen Placement
            queen_Premutation(board,total_queens,queen_placed_so_Far+1,ans+"Q"+queen_placed_so_Far+"B"+i+" ");

            //After getting Placed remove it i.e mark it as false
            board[i]=false;
            }
        }

    }
}
