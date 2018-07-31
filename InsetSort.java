package com.bittch.data.sort;


/**
 * 基本思想
 * 通常人们整理桥牌的方法是一张一张的来，
 * 将每一张牌插入到其他已经有序的牌中的适当位置。
 * 在计算机的实现中，为了要给插入的元素腾出空间，
 * 我们需要将其余所有元素在插入之前都向右移动一位。
 *
 * 算法描述
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 *
 * 从第一个元素开始，该元素可以认为已经被排序
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 将新元素插入到该位置后
 * 重复步骤2~5
 *
 */
public class InsetSort {
    public static void sort(int[] temp){

        for (int i = 0; i < temp.length - 1; i++){
            for (int j = i + 1; j > 0; j--){
                if (temp[j] < temp[j-1]){
                    int change = temp[j];
                    temp[j] = temp[j-1];
                    temp[j-1] = change;
                }
            }

        }
    }

//    public static void sort2(int[] temp){
//        for (int i= 1; i < temp.length; i++){
//            int num = temp[i];
//            int j;
//            for (j = i;j > 0 && num < temp[j]; j--){
//                temp[j] = temp[j -1];
//            }
//            temp[j] = num;
//        }
//    }

    public static void main(String[] args) {
        int[] x = new int[]{2,3,4,1,5,78,34,9};
        sort(x);
        for (int i = 0;i < x.length; i++){

            System.out.println(x[i]);
        }
    }
}
