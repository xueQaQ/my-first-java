package com.bittch.data.sort;


/**
 * 从数列中挑出一个元素，称为"基准"（pivot）。
 * 重新排序数列，所有比基准值小的元素摆放在基准前面，
 * 所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
 * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。
 * 这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
public class QuickSort {
    public static void sort(int[] a,int low,int high){
        //已经排完
        if (low >= high){
            return;
        }
        int left = low;
        int right = high;
        //保证基准值
        int pivot = a[left];
        while (left < right){
            //从后向前找到比基准小的元素
            while (left < right && a[right] > pivot){
                right --;
                a[left] = a[right];
                //从后往前找到比基准大的元素
                while (left < right && a[left] <= pivot){
                    left++;
                    a[right] = a[left];
                }
                //防止基准值，准备分治递归快排
            }
            a[left] = pivot;
            sort(a,low,left -1);
            sort(a,left+1,high);
        }
    }

}
