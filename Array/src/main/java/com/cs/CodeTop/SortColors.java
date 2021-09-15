package com.cs.CodeTop;


/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 要求仅使用常数空间
 */
public class SortColors {
    //方法一 ： 因为只有三种元素，可以利用下桶排序，用三个变量记录元素个数即可
    //需要扫描两次
    public void sortColors1(int[] nums) {
        int nums_0 = 0, nums_1 = 0, nums_2 = 0;
        for (int num : nums) {
            if (num == 0) {
                nums_0++;
            } else if (num == 1) {
                nums_1++;
            } else {
                nums_2++;
            }
        }
        int index = 0;
        while (nums_0 > 0) {
            nums[index++] = 0;
            nums_0--;
        }
        while (nums_1 > 0) {
            nums[index++] = 1;
            nums_1--;
        }
        while (nums_2 > 0) {
            nums[index++] = 2;
            nums_2--;
        }
    }

    //方法二 单指针
    //需要扫描两次
    public void sortColors2(int[] nums) {
        int index = 0;
        //第一次遍历把0都放在前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }
        //第二次遍历把1放在前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    //方法三 双指针
    //需要扫描一次 一个指针指向0，一个指针指向1
    public void sortColors3(int[] nums) {
        int index0 = 0, index1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[index1];
                nums[index1++] = tmp;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[index0];
                nums[index0] = tmp;
                if (index0 < index1) {
                    tmp = nums[i];
                    nums[i] = nums[index1];
                    nums[index1] = tmp;
                }
                index0++;
                index1++;
            }
        }
    }

    //方法四 双指针
    //需要扫描一次 一个指针指向0，一个指针指向2 有快排的切分partition思想
    public void sortColors4(int[] nums) {
        int index0 = 0, index2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < index2) {
                int tmp = nums[i];
                nums[i] = nums[index2];
                nums[index2--] = tmp;
            }
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[index0];
                nums[index0++] = tmp;
            }
        }
    }
}
