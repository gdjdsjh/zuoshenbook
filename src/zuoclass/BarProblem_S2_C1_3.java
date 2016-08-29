package zuoclass;

import java.util.Arrays;

/**
 * Created by sjh on 2016/8/29.
 */
public class BarProblem_S2_C1_3 {
    public int maxArea(int[] nums){
        if (nums == null || nums.length < 3){
            return 0;
        }
        int max = Integer.MIN_VALUE;//先初始化为最小值，用来求最大值
        int index1 = 0;
        int index2 = nums.length - 1;

        while (index1 < index2 - 1){
            if(nums[index1] <= nums[index2]){//哪边小，哪边往里缩（因为较大一边缩没意义，瓶颈在较小者这一端）
                max = Math.max(max, (index2 - index1 - 1)*nums[index1]);
                index1++;
            }else{
                max = Math.max(max, (index2 - index1 - 1)*nums[index2]);
                index2--;
            }
        }
        return max;
    }


    public static int[] generateRandomArray() {
        int[] arr = new int[(int) (Math.random() * 98) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 200) + 2;
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = generateRandomArray();
        int[] arr = {3,4,2,5};
        System.out.println(Arrays.toString(arr));
        int r1 = new BarProblem_S2_C1_3().maxArea(arr);
        System.out.println(r1);
    }
}
