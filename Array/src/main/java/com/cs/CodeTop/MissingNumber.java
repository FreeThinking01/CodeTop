package com.cs.CodeTop;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
* */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0,1,3};
        MissingNumber test = new MissingNumber();
        int missingNumber = test.missingNumber(nums);
        System.out.println(missingNumber);
    }

    //方法1 快速排序 时间复杂度O(nlog(n)) 空间复杂度O(log(n))

    //方法2 哈希表 时间复杂度O(n) 空间复杂度O(n)

    //方法3 位运算 利用异或 相同为0，不同为1 所以将所有索引和索引上的数字进行异或
    //即[0,n]共n + 1个数字和给定的数组中n个数字异或
    public int missingNumber(int[] nums) {
        int missingNumber = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }

    //方法4 数学 等差数列求和（高斯公式）
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return n * (n - 1) / 2 - sum;
    }


}
