package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-02-28 22:48
 * @description:
 **/
public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers demo = new GetLeastNumbers();
        int[] nums = {3,2,1};
        int[] res = demo.getLeastNumbers(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    int[] res = null;
    public int[] getLeastNumbers(int[] arr, int k) {
        res = new int[k];
        sort(arr, 0, arr.length - 1 ,k);
        return res;
    }
    private void sort(int[] nums, int left, int right, int k){
        if(left > right){
            return;
        }
        int j = partition(nums, left, right);
        if(j == k - 1){
            for(int i = 0; i < k; i++){
                res[i] = nums[i];
            }
        }else if(j < k - 1){
            sort(nums, j + 1, right, k);
        }else{
            sort(nums, left, j - 1, k);
        }
    }
    private int partition(int[] nums, int left, int right){
        int i = left, j = right + 1;
        while(true){
            while(nums[++i] < nums[left]){
                if(i == right){
                    break;
                }
            }
            while(nums[--j] > nums[left]){
                if(j == left){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
