package leetcode;

/**
 * Created by sjh on 2016/8/21.
 * leetcode 27 在int数组当中移除指定的值的数字，返回新的数组长度，数值顺序可变
 * 且只关心新数组长度的那些值，要求空间复杂度为O(1)
 * 比如:{3,2,2,3}, 3
 * 返回新数组长度为2，且只要保证数组的前两个值为2就行了（意思是3可以保留，只是不能在返回的数组长度之内就行了）
 * 此题采用双指针法，用一个res记录val相同的值有几个，头指针，尾指针从两端向里靠拢，直到头指针遇到跟val一样的值停住
 * ，然后尾指针开始移动直到遇到第一个不是val的值停住（此时每遇到一个val一样的值就把res加1）
 * 如果此时i还是小于j的话，就交换两者的值，并且res+1（因为出现了一个val一样的值嘛）
 * 最后用nums的长度-res就是新的数组长度，且该长度的值都是与val不一样的值（因为一样的都被换到后面去了嘛）
 * 而且只需要扫一遍，所以时间复杂度为O(n),空间复杂度为O(1)
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        int i = 0;
        int j = nums.length - 1;
        while (true){
            while (i <= j && i < nums.length && nums[i] != val){//这里i<=j，因为有可能出现{3},3这种情况
                i++;
            }
            while(i <= j && j > -1 && nums[j] == val){
                j--;
                res++;//说明后面也有等于val的，跳过的同时要给res+1
            }
            if(i < j){
                res++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }else{
                break;
            }
        }
        return nums.length - res;
    }


    public static void main(String[] args){
        int[] arr = {3,3};
        new RemoveElement_27().removeElement(arr, 5);
    }
}
