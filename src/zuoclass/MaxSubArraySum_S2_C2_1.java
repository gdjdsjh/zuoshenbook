package zuoclass;

/**
 * Created by sjh on 2016/8/29.
 * 求数组当中子数组的最大和
 */
public class MaxSubArraySum_S2_C2_1 {
    public static int maxSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int cur = 0;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            cur += arr[i];
            res = Math.max(cur, res);
            cur = cur < 0? 0:cur;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = { 3, -1, 2, 1, -6, 5, 2, 3, -2, 7 };
        int[] arr = { -3, -1, -2, -1, -6, -5, -2, -3, -2, -7 };
        System.out.println(maxSum(arr));
    }
}
