package leetcode;

/**
 * Created by sjh on 2016/8/23.
 * 不用+ -计算两个整数的和
 */
public class SumOfTwoIntegers_371 {
    /**
     * 递归版
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b){
        //先计算不考虑进位得到的值
        int sum1 = a ^ b;

        //再计算只考虑进位得到的值
        int sum2 = (a & b) << 1;//因为i位置上只有1+1才会导致i-1位置上的进位，所以与了之后再左移一位

        if(sum2 != 0){
            return getSum(sum1, sum2);
        }else{
            return sum1;
        }
    }

    /**
     * 非递归版
     */
    public int getSum2(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers_371().getSum2(2, 3));
    }
}
