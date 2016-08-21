package leetcode;

/**
 * Created by sjh on 2016/8/21.
 * 反转一个字符串
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return s;
        }
        char[] strings = s.toCharArray();
        int mid = s.length()/2;
        for(int i = 0; i < mid; i++){
            char tmp = strings[i];
            strings[i] = strings[s.length()-1-i];
            strings[s.length()-1-i] = tmp;
        }
        return new String(strings);
    }
}