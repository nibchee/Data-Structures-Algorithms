package com.Recurrsion;

import java.util.ArrayList;

public class BoardPaths {
    public static void main(String[] args) {


    }

    public static ArrayList<String> getBoardPath(int cur, int end){

        if(cur==end){
            ArrayList<String> br=new ArrayList<>();
            br.add(" ");
            return br;
        }

        if(cur>end){
            ArrayList<String> br=new ArrayList<>();
            return br;
        }
        ArrayList<String> mr=new ArrayList<>();
        for(int dice=1;dice<=6;dice++){
            ArrayList<String> rr=getBoardPath(cur+dice,end);

            for(String rrs:rr){
                mr.add(dice+rrs);
            }
        }
return mr;
    }



}
