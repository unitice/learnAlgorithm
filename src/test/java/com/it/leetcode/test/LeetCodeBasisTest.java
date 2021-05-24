package com.it.leetcode.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LY
 * @PackageName:com.it.leetcode.test
 * @ClassName:TwoNumbersSum
 * @date 2021/5/20 10:28
 * 类说明: <br>
 *     LeetCode基础练习
 */
@SpringBootTest
public class LeetCodeBasisTest {

    @Test
    @DisplayName("TwoNumbersSum")
    public void test01(){
        int[] arr = new int[]{-1,-2,-3,3,-5};
        int[] ints = twoSum(arr, 0);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * @Author LY
     * @Date 10:31 2021/5/20
     * @Param [nums, target]
     * @return int[]
     * 功能说明: <br>
     * 获取一个数组里面所有满足等于指定数值的结果集
     */
    public int[] twoSum(int[] nums, int target){
//        int[] data = null;
//        解法思路一，暴力双重循环解决
//        for (int i = 0 ; i < nums.length ; i++){
//            for (int j = nums.length-1 ; j > i ; j--){
//                if (nums[j] + nums[i] == target){
//                    data = new int[]{i,j};
//                    continue;
//                }
//            }
//        }
//        解法思路二，转换hashmap解决
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        for (int j = 0 ; j < nums.length ; j++){
            int a = target - nums[j];
            if (map.containsKey(a) && map.get(a) != j){
                return new int[]{j,map.get(a)};
            }
        }
        return null;
    }

    @Test
    @DisplayName("highFrequencyVocabularyRanking")
    public void test02(){
        String[] aa = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> strings = topKFrequent(aa, 2);
        System.out.println(strings);
    }

    /**
     * @Author LY
     * @Date 11:38 2021/5/20
     * @Param [words, k]
     * @return java.util.List<java.lang.String>
     * 功能说明: <br>
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> aa = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0 ; i < words.length ; i++){
            if (map.isEmpty() || !map.containsKey(words[i])){
                map.put(words[i],1);
            } else {
                map.put(words[i], map.get(words[i])+1);
            }
        }
        Map<Integer,List<String>> amap = new HashMap<Integer, List<String>>();
        for (String a : map.keySet()){
            if (!amap.isEmpty() && amap.containsKey(map.get(a))){
                List<String> strings = amap.get(map.get(a));
                strings.add(a);
            } else {
                List<String> list = new ArrayList<>();
                list.add(a);
                amap.put(map.get(a),list);
            }
        }
        Set<Integer> integers = amap.keySet();
        Object[] objects = integers.toArray();
        Arrays.sort(objects);
        for (int i = objects.length-1 ; i >= 0 ; i--){
            List<String> strings = amap.get(objects[i]);
            if (strings.size() > 1){
                // 通过流对list进行排序
                List<String> collect = strings.stream().sorted().collect(Collectors.toList());
                aa.addAll(collect);
            } else {
                aa.add(strings.get(0));
            }
        }
        List<String> collect = aa.stream().limit(k).collect(Collectors.toList());
        return collect;
    }


    @Test
    @DisplayName("theLongestUnrepeatableString")
    public void test03(){
        String string = "a";
        int i = lengthOfLongestSubstring(string);
        System.out.println(i);
    }

    /**
     * @Author LY
     * @Date 17:53 2021/5/20
     * @Param [s]
     * @return int
     * 功能说明: <br>
     *       不含有重复字符的 最长子串 的长度
     */
    public int lengthOfLongestSubstring(String s) {
        String a = null;
        String k = null;
       for (int i = 0 ; i < s.length(); i++){
          for (int j = i+1 ; j < s.length()+1 ; j++){
              if (j+1 <= s.length()){
                k = s.substring(i,j);
                if (a == null || a.length() <= k.length()){
                    a = k;
                }
                if (k.contains(s.substring(j,j+1))){
                    break;
                }
              }else {
                  k = s.substring(i,j);
                  if (a == null || a.length() <= k.length()){
                      a = k;
                  }
                  break;
              }
          }
       }
       return a != null ? a.length() : 0;
    }


    @Test
    @DisplayName("aa")
    public void test04(){
        int[] aa = {1,3};
        int[] bb = {2};
        int[] cc = new int[aa.length+bb.length];
        int k = 0;
        for (int i = 0; i< (aa.length >= bb.length ? aa.length : bb.length) ; i++){
            if (i < aa.length){
              cc[k++] = aa[i];
            }
            if (i < bb.length){
                cc[k++] = bb[i];
            }
        }
        Arrays.sort(cc);
        int n = cc.length/2;
        double v1;
        if (cc.length%2 == 0){
            v1 = (cc[n] + cc[n -1]) / 2.0;
        } else{
            v1 = cc[n];
        }
        System.out.println(v1);
    }


    public Double median(int[] nums1, int[] nums2){
        // 中位数位置
        int n = (nums1.length + nums2.length) / 2;
        int k = 0;
        int a,b;
//        while (k < (nums1.length >= nums2.length ? nums1.length : nums2.length)){
//            if (nums1[k] > nums2[k]){
//
//            } else {
//
//            }
//        }
        return 0.0;

    }

    public String longestPalindrome(String s) {
        return null;
    }
}
