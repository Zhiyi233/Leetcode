package top50;

import java.util.HashMap;

/**
 * 解题思路：滑动窗口
 * 从左开始，当且仅当当前字符出现重复时，新的子串的开始位置为重复位置+1，继续挨个检查是否重复，及时更新长度
 * 知道遍历到字符串最后一位。
 *
 * leetcode#3
 * 难度：medium
 *
 * @author kevin
 * @create 2023-03-25-17:43
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        /**
         for(int start=0,end=0;end<s.length();end++){
         char subChar = s.charAt(end); //获取当个字符值
         if(map.containsKey(subChar)){
         //重复后新的字符开启的位置
         start = Math.max(map.get(subChar),start);
         }
         //子字符串长度就是末尾index-起始index+1
         ans = Math.max(ans,end-start+1);
         //此时这个字符没有重复加入map中，end+1是为了给start重新赋值为当前重复时index的下一个index
         map.put(s.charAt(end),end+1);
         }
         return ans;
         */

        //no end+1
        int left=0;

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(map.get(s.charAt(i))+1,left);
            }
            map.put(s.charAt(i),i);
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str =  "abcabcbb";
        int n = lengthOfLongestSubstring(str);
        System.out.println(n);
    }
}
