package com.Generic;

import java.util.Comparator;

public class Genric
{
    public static void main(String[] args) {


        Car[] cars=new Car[5];

        cars[0]=new Car(1000,100,"Red");
        cars[1]=new Car(2000,20,"Yellow");
        cars[2]=new Car(1000,300,"Green");
        cars[3]=new Car(500,40,"Orange");
        cars[4]=new Car(300,500,"Golden");

        bubbleSort(cars,new CarSpeedComparator());
        display(cars);
        System.out.println();
        bubbleSort(cars,new CarPriceComparator());
        display(cars);
        System.out.println();
        bubbleSort(cars,new CarStringComparator());
        display(cars);
    }


    public static <T> void display(T[] arr){
        for(T val:arr){
            System.out.println(val+" ");
        }
    }


    public static <T extends Comparable<T>>  void bubbleSort(T[] arr, Comparator<T>comarator){
        for(int counter=0;counter<arr.length-1;counter++){
            for(int j=0;j<arr.length-1-counter;j++){
                if(comarator.compare(arr[j],arr[j+1])>0){
                    T temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }


}
