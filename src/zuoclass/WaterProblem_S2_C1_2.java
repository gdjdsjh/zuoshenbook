package zuoclass;

/**
 * Created by sjh on 2016/8/29.
 * leetcode 42
 */
public class WaterProblem_S2_C1_2 {
    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }

        int sum = 0;
        int l = 1;//左指针
        int r = height.length - 2;// 右指针
        int lMax = height[0];//l左边最大值
        int rMax = height[height.length - 1];//r右边最大值

        while(l <= r){
            if(lMax <= rMax){
                sum += Math.max(0, lMax - height[l]);//结算
                lMax = Math.max(lMax, height[l++]);//更新最大值，并移动指针
            }else{
                sum += Math.max(0, rMax - height[r]);//同上
                rMax = Math.max(rMax, height[r--]);
            }
        }
        return sum;
    }
}
