package com.cs.CodeTop;

import java.util.*;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-29 13:29
 * @description: 前K个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 **/
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = new int[]{5,-3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3};
        TopKFrequent test = new TopKFrequent();
        int[] res = test.topKFrequent1(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //基于快速排序
    public int[] topKFrequent1(int[] nums, int k) {
        //先统计频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //将Hash表转换成元素为二维数组的数组
        ArrayList arrayList = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arrayList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        int length = arrayList.size();
        quickSort(arrayList, length - k, 0, length - 1);
        for (int i = length - k; i < length; i++) {
            int[] tmp = (int[]) arrayList.get(i);
            res[i - length + k] = tmp[0];
        }
        return res;
    }

    private void quickSort(List<int[]> list, int k, int left, int right) {
        if (left >= right){
            return;
        }
        int j = partation(list, left, right);
        if (j ==  k - 1){
            return;
        }else if (j > k - 1){
            quickSort(list, k, left, j - 1);
        }else if(j < k - 1){
            quickSort(list, k, j + 1, right);
        }
    }

    private int partation(List<int[]> list, int left, int right) {
        int i = left, j = right + 1;
        while (true){
            while (list.get(++i)[1] < list.get(left)[1]){
                if (i == right){
                    break;
                }
            }
            while (list.get(--j)[1] > list.get(left)[1]){
                if (j == left){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            Collections.swap(list, i, j);
        }
        Collections.swap(list, left, j);
        return j;
    }


//    //基于堆排序
//    public int[] topKFrequent2(int[] nums, int k) {
//
//    }
}
