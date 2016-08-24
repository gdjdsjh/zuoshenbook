package zuoclass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sjh on 2016/8/24.
 * 左神第二季第一课第一题(Leetcode problem 354 Russian Doll Envelopes)
 * [[a1,b1],[a2,b2],[a3,b3]]
 * 甲中的a值必须大于乙中的a值，甲中的b值也必须大于乙中的b值，此时方可把二元组甲放在二元组乙上面
 * 求最多可以垒几个？
 * 方法：
 * a先从小到大排序，当a相同时，b按从大到小排序
 * 建一个h数组，遍历b更新h数组的值
 * 更新规则：在h数组中找比当前值大的第一个数，如果有更新之，如果找不到，右边界向右拓展一格，添入当前值
 * h[i]的意义是长度为i+1的时候的末尾数字的最小值是多少。
 * 由于a先从小到大排序了，所以后面的值a肯定是符合要求的，所以就看b怎么更新了
 * 由于b是按从大到小排列的，所以当a相同的时候按照上述的更新规则去更新h数组长度是不会变的（因为后续的b比现在的小嘛，顶多更新值而不会增加长度）
 * 比如：[2,3],[5,5],[6,7],[6,4] 这么排序，去更新h不会有问题（4比7小，不会导致长度边长，这是正确的）
 * 但这么排就有问题了[2,3],[5,5],[6,4],[6,7]，后面两个a相等，b后面的大，就会使长度变长，但其实这样就不对了。
 *
 * 其实后面的过程是求最长递增子序列的过程（DP）  时间复杂度O（N*logN）,遍历为N，每个值用二分法找正确位置（logN）
 */
public class ZuoClass_S2_C1_1 {
    public int solution(int[][] nums){
        if(nums == null || nums.length ==0 || nums[0] == null || nums[0].length != 2){
            return 0;
        }

        Dot[] dots = new Dot[nums.length];
        for (int i = 0; i < nums.length; i++){
            dots[i] = new Dot(nums[i][0], nums[i][1]);
        }
        Arrays.sort(dots, new DotComparator());

        int[] h = new int[nums.length];
        h[0] = dots[0].h;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for(int i = 1; i < dots.length; i++){
            l = 0;
            r = right;
            while (l <= r){//开始二分法找第一个大于当前数的位置
                m = (l+r)/2;
                if(dots[i].h > h[m]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            right = Math.max(right, l);//跳出while循环的时候l为要放入的位置，right边界为right和l的较大者
            h[l] = dots[i].h;//更新l位置上的值为dots[i].h 因为二分法找到的l位置就是应该放入的位置（要么替换，要么是边界向右扩展添入该值）
        }
        return right + 1;//长度为右边界索引位置+1
    }

    public static void main(String[] args) {
        int[][] test = { { 4, 3 }, { 1, 2 }, { 5, 7 }, { 5, 3 }, { 1, 1 }, { 4, 9 } };
        System.out.println(new ZuoClass_S2_C1_1().solution(test));
    }



    public static class Dot{
        public int w;
        public int h;

        public Dot(int w, int h){
            this.w = w;
            this.h = h;
        }
    }


    public static class DotComparator implements Comparator<Dot>{

        @Override
        public int compare(Dot o1, Dot o2) {
            if(o1.w == o2.w){
                if(o1.h == o2.h){
                    return 0;
                }else if(o1.h < o2.h){
                    return 1;//因为b要从大到小排序，所以这里倒一下
                }else{
                    return -1;
                }
            }else if(o1.w < o2.w){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
