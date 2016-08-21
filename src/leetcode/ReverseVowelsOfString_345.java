package leetcode;

import java.util.HashSet;

/**
 * Created by sjh on 2016/8/21.
 * 只reverse元音字母
 */
public class ReverseVowelsOfString_345 {
    public String reverseVowels(String s) {
        HashSet<Character> dic = new HashSet<>();
        dic.add('a');
        dic.add('e');
        dic.add('i');
        dic.add('o');
        dic.add('u');
        dic.add('A');
        dic.add('E');
        dic.add('I');
        dic.add('O');
        dic.add('U');

        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            while (i < j && i < s.length() -1 && !dic.contains(chars[i])){
                i++;
            }
            if(i >= j){
                break;
            }
            while (j > i && j > 0 && !dic.contains(chars[j])){
                j--;
            }
            if(i >= j){
                break;
            }
            exchange(chars, i++, j--);
        }
        return new String(chars);
    }

    private void exchange(char[] chars, int a, int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String[] args){
        String s = "a.";
        s = new ReverseVowelsOfString_345().reverseVowels(s);
        System.out.println(s);
    }
}
