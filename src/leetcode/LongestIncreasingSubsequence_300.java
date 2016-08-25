package leetcode;

/**
 * Created by sjh on 2016/8/25.
 * 经典的LIS问题，最长递增子序列
 * 废话少说，直接上DP！
 */
public class LongestIncreasingSubsequence_300 {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] h = new int[nums.length];
        h[0] = nums[0];
        int right = 0;
        for(int i = 1; i < nums.length; i++){
            int l = 0;
            int r = right;
            while(l <= r){
                int m = (l+r)/2;
                if(h[m] < nums[i]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            h[l] = nums[i];
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int maxLength = lengthOfLIS(nums);
        System.out.println("The max length: " + maxLength);
    }
}
