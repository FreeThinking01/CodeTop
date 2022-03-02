package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-01 10:26
 * @description: 数组排成最小的数
 **/
public class MinNumber {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        MinNumber demo = new MinNumber();
        String res = demo.minNumber(nums);
        System.out.println(res);
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
    private void quickSort(String[] strs, int left, int right){
        if(left >= right){
            return;
        }
        int j = partation(strs, left, right);
        quickSort(strs, left, j);
        quickSort(strs, j + 1, right);
    }
    private int partation(String[] strs, int left, int right){
        int i = left + 1, j = right;
        while(true){
            while((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0){
                if(i == right){
                    break;
                }
                i++;
            }
            while((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0){

                if(j == left){
                    break;
                }
                j--;
            }
            if(i >= j){
                break;
            }
            swap(strs, i, j);
        }
        swap(strs, left, j);
        return j;
    }
    private void swap(String[] strs, int i, int j){
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
