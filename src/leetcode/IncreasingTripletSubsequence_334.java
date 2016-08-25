package leetcode;

/**
 * Created by sjh on 2016/8/25.
 */
public class IncreasingTripletSubsequence_334 {
    /**
     * 自己之前还是只能想到O(n*logn)的方法，这里要求时间复杂度O(N)空间复杂度O(1)，参考了别人的方法
     * 用2个变量去维持到当前值位置的最小2个值，所以如果这样的情况下，后面的值还是不能比这两个大，那就是false
     * 就相当于到i位置的时候，肯定之前都没满足有3个递增的序列，那么就挑出当中最小的两个（当然这是在遍历过程中维护的
     * ，而且这两个最小值的顺序不一定满足原数组当中的顺序，但这不是问题，因为如果后面有值X比第二小的大，那么之前随便挑一组满足顺序的
     * 第一，第二小再加上后面那个值X，就组成了3，满足要求）
     *
     * 最小值成为1，第二小的成为2
     * 三种情况，情况2最复杂！！！
     * 情况1：依次递减的，没什么好说的，永远只更新最小值到结束，false退出
     * 情况2：有减有增，那么到某个位置i肯定会至少出现一组满足顺序的最小值和第二小值，在i之后的数只要有比1小的，就去更新1（虽然和2顺序
     * 乱了，但是不重要，2在那守着呢，我们只关心有没有比2大），如果i之后比1大，比2小，那就更新2（这方便后面出现比2大的值，
     * 是正确的更新策略），如果i之后比2大那直接就满足要求了（可能这时候的1并不满足顺序要求，但肯定能在这个1之前找到一个满足顺序且比2小的值），
     * 情况3：递增，也没什么好说的，到第三个直接就满足要求了。
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        int min1 = Integer.MAX_VALUE;//最小值
        int min2 = Integer.MAX_VALUE;//第二小指

        for (int i = 0; i < nums.length; i++){
            if(nums[i] <= min1){
                min1 = nums[i];
            }else if(nums[i] <= min2){
                min2 = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,2,1,0,-1,-3};
        System.out.println(increasingTriplet(nums));
    }
}
