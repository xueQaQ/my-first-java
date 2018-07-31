package com.bittch.data.sort;

public class QuickSort3 {
    public static void sortThreeWay(int[] a,int lo,int hi){
        if(lo >= hi){
            return;
        }
        int v = a[lo],lt = lo, i = lo + 1, gt = hi;
        while (i <= gt){
            if (a[i] < v){
                swap(a, i++, lt++);
            }else if (a[i] > v){
                swap(a,i,gt--);
            }else {
                i++;
            }
        }
        sortThreeWay(a,lo,lt -1);
        sortThreeWay(a,gt+1,hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t =a[i];
        a[i] = a[j];
        a[j] = t;

    }
}
