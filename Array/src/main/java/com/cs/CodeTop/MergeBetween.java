package com.cs.CodeTop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
* */
public class MergeBetween {

    //以左端点排序
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a,int[] b)->a[0]-b[0]);
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int left = res.get(res.size() - 1)[0], right = res.get(res.size() - 1)[1];
            if(intervals[i][0] <= right){
                //需要和前一个合并
                if(intervals[i][1] > right){
                    res.get(res.size() - 1)[1] = intervals[i][1];
                }
            }else{
                //不合并
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    //以右端点排序从左到右合并(不可行)[[2,3],[4,5],[6,7],[8,9],[1,10]]
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (int[] a,int[] b)->a[1]-b[1]);
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int left = res.get(res.size() - 1)[0], right = res.get(res.size() - 1)[1];
            if(intervals[i][0] <= right){
                //需要和前一个合并
                if(intervals[i][0] < left){
                    res.get(res.size() - 1)[0] = intervals[i][0];
                }
                res.get(res.size() - 1)[1] = intervals[i][1];
            }else{
                //不合并
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //以左端点排序从左到右合并，以此类推，以右端点排序应该从有到左排序（略）

}
