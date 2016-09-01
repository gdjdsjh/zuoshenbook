package zuoclass;

/**
 * Created by sjh on 2016/8/31.
 * 未排序非负数组中累加和为给定值的最长子数组长度
 */
public class LongestSumSubArrayLengthInPositiveArray_S2_C2_2 {
    public static int getMaxLength(int[] arr, int k){
        if (arr == null || arr.length == 0 || k < 0){
            return 0;
        }
        int lIndex = 0;
        int rIndex = -1;
        int sum = 0;
        int length = 0;

        while(rIndex < arr.length){
            if(sum < k){
                rIndex++;
                if(rIndex >= arr.length){
                    break;
                }
                sum += arr[rIndex];
            }else if(sum == k){
                length = Math.max(length, rIndex -lIndex +1);
                rIndex++;
                if (rIndex >= arr.length){
                    break;
                }
                sum += arr[rIndex];
            }else {
                sum -= arr[lIndex++];
            }
        }
        return length;
    }


    public static int[] generatePositiveArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 10) + 1;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int len = 20;
        int k = 15;
        int[] arr = generatePositiveArray(len);
        printArray(arr);
        System.out.println(getMaxLength(arr, k));
        System.out.println(getMaxLength1(arr,k));

    }

    /**
     * 左神code, 要求数组元素大于0
     * @param arr
     * @param k
     * @return
     */
    public static int getMaxLength1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }
}
