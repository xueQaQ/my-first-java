package com.bittch.data.sort;

/**
 * 基本思想
 * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，
 * 则它不会被移动。选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，
 * 因此对 n个元素的表进行排序总共进行至多 n-1 次交换。
 * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
 *
 * 算法描述
 * 从未排序序列中，找到关键字最小的元素
 * 如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
 * 重复1、2步，直到排序结束。
 */
public class SelectionSort {
    public static void sort(int[] temp){
        for(int i = 0; i < temp.length; i++){
            int min = i;
            for (int j = i + 1;j < temp.length; j++){
                if (temp[j] < temp[min]){
                    min = j;
                }
            }
            if(min != i){
                int change = temp[i];
                temp[i] = temp[min];
                temp[min] = change;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{2,3,4,1,5,78,34,9};
        sort(x);
        for (int i = 0;i < x.length; i++){

            System.out.println(x[i]);
        }
    }

}
