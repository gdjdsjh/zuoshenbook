package zuoclass;

/**
 * Created by sjh on 2016/8/29.
 * 求两个子数组最大的累加和(两个子数组不能重叠)
 */
public class MaxSumBetweenTwoSubArray_S2_C1_1 {
    public static int maxSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }

        int cur = 0;
        int res = Integer.MIN_VALUE;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            cur += arr[i];
            res = Math.max(res, cur);
            left[i] = res;
            cur = cur < 0 ? 0 : cur;
        }
        res = Integer.MIN_VALUE;//恢复初值
        cur = 0;//恢复初值
        for (int i = arr.length-1; i > -1; i--){
            cur += arr[i];
            res = Math.max(res, cur);
            right[i] = res;
            cur = cur < 0 ? 0 : cur;
        }
        res = Integer.MIN_VALUE;//恢复初值
        for (int i = 0; i < arr.length - 1; i++){
            res = Math.max(res, left[i]+right[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { -11, -10, 6, 4, 5, 3, -7, -8, 3, 6, 9, 1, -7 };
        System.out.println(maxSum(arr));
    }

    /**
     * 左神代码
     * @param arr
     * @return
     */
    public static int maxSum1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int[] h = new int[arr.length];
        h[arr.length - 1] = arr[arr.length - 1];
        int cur = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            h[i] = Math.max(h[i + 1], cur);
        }
        int res = arr[0] + h[1];
        int lmax = arr[0];
        cur = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {//从左向右结算的同时，去更新最大和，节省了求left数组的过程
            cur = cur < 0 ? 0 : cur;
            cur += arr[i];
            lmax = Math.max(lmax, cur);
            res = Math.max(res, lmax + h[i + 1]);
        }
        return res;
    }
}
