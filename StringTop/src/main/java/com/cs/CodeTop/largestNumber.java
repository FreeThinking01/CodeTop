package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-12 15:37
 * @description: 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 **/
public class largestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        largestNumber demo = new largestNumber();
        String s = demo.largestNumber(nums);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        if(strs[0].equals("0")){
            return "0";
        }
        return sb.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = partation(strs, left, right);
        quickSort(strs, left, mid - 1);
        quickSort(strs, mid + 1, right);
    }

    private int partation(String[] strs, int left, int right) {
        int i = left + 1, j = right;
        while (true){
            while ((strs[i] + strs[left]).compareTo(strs[left] + strs[i]) >= 0){
                if(i == right){
                    break;
                }
                i++;
            }
            while ((strs[j] + strs[left]).compareTo(strs[left] + strs[j]) <= 0){
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

    public void swap(String[] nums, int i, int j){
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
