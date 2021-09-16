package com.cs.CodeTop;


import java.util.HashSet;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-15 11:16
 * @description: 寻找重复数
 *
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 **/
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate test = new FindDuplicate();
        test.findDuplicate1(new int[]{2,3,3,4,3});
    }

    //原地置换 时间复杂度O(n)，空间复杂度O(1)
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //必须是while不能是if
            while (nums[i] - 1 != i){
                if (nums[i] == nums[nums[i] - 1]){
                    return nums[i];
                }else {
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }

            }
        }
        return -1;
    }

    //二分法
    public int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;//因为有n+1个整数,right = n = nums.length - 1
        // int res = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length ; i++) {
                if (nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                left = mid + 1;
            }else {
                right = mid;
                // res = mid;
            }
        }
        return right;
    }

    //二进制
    public int findDuplicate3(int[] nums) {
        //
        return 0;
    }

    //快慢指针 Floyd判圈算法
    //将题目建模为环形链表Ⅱ
    public int findDuplicate4(int[] nums) {
        //一个Node里有val和next指向，在这里val就是index，next就是nums[i]
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    //哈希表 时间复杂度O(n)，空间复杂度O(n)
    public int findDuplicate5(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length;  i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
