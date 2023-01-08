package com.Recurrsion;

import java.util.ArrayList;

public class MazePaths {
    public static void main(String[] args) {
        System.out.println(getMazePathsD(0,0,2,2));
    }

    public static ArrayList<String> getMazePaths(int curr, int curc, int endr, int endc){

        if(curr==endr && curc==endc){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }


        if(curr>endr || curc>endc){
            ArrayList<String> res=new ArrayList<>();
            return res;
        }

        ArrayList<String> myresult=new ArrayList<>();
        //horizontal Traversal
        ArrayList<String> recursive_horizontal_result=getMazePaths(curr,curc+1,endr,endc);

        for(String val:recursive_horizontal_result){
            myresult.add("H"+val);
        }

        //vertical Traversal
        ArrayList<String> recursive_vertical_result=getMazePaths(curr+1,curc,endr,endc);

        for(String val:recursive_vertical_result){
            myresult.add("V"+val);
        }

        return myresult;
    }


    public static ArrayList<String> getMazePathsD(int curr, int curc, int endr, int endc){

        if(curr==endr && curc==endc){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }


        if(curr>endr || curc>endc){
            ArrayList<String> res=new ArrayList<>();
            return res;
        }

        ArrayList<String> myresult=new ArrayList<>();
        //horizontal Traversal
        ArrayList<String> recursive_horizontal_result=getMazePathsD(curr,curc+1,endr,endc);

        for(String val:recursive_horizontal_result){
            myresult.add("H"+val);
        }

        //vertical Traversal
        ArrayList<String> recursive_vertical_result=getMazePathsD(curr+1,curc,endr,endc);

        for(String val:recursive_vertical_result){
            myresult.add("V"+val);
        }

        //Diagnol Traversal
        ArrayList<String> recursive_diagnol_result=getMazePathsD(curr+1,curc+1,endr,endc);

        for(String val:recursive_diagnol_result){
            myresult.add("D"+val);
        }

        return myresult;
    }

}
