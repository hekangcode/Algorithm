package com.hekang.algorithm.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by HE KANG  on 2017\11\15 0015.
 * 算法题目：输出一个字符串中连续出现次数最多的字符
 * 思路：1、将目标字符串变成字符数组
 * 2、将字符数组存入到Map集合中，存储原理是：将字符作为map集合的key值，对应的该字符出现的次数作为map的value值
 * 3、将map集合的key取出来放到set集合里，通过快速查找找到value的最大值（有时会有同一个Value对应多个key值）
 */

public class Test02 {

    public static void main(String[] args) {
        String str = "jjjjftftftddddefgugtfde";
        Map<Character, Integer> map = stringToMap(str);
        foundMaxCountChar(map);
    }

    /**
     * 将字符串转成字符数组，将字符数组存入到map集合中
     */
    private static Map<Character, Integer> stringToMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        if (string != null && string.length() > 0) {
            char[] charArray = string.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (map.get(charArray[i]) == null) {
                    // 代表该数据还未存入
                    map.put(charArray[i], 1);
                } else {
                    // 代表已存入
                    map.put(charArray[i], map.get(charArray[i]) + 1);
                }
            }
        }
        return map;
    }

    private static void foundMaxCountChar(Map<Character, Integer> map) {
        if (map != null && !map.isEmpty()) {
            // 将key存放到set集合中
            Set<Character> setKey = map.keySet();
            // 实例化迭代器
            Iterator<Character> iteratorKey = setKey.iterator();
            // 初始化变量，次数最多的字符和出现次数
            List<Character> list = new ArrayList<>();
            Character maxValueKey = iteratorKey.next();
            list.add(maxValueKey);
            int maxValue = map.get(maxValueKey);
            while (iteratorKey.hasNext()) {
                // 中间量
                Character temp = iteratorKey.next();
                if (maxValue < map.get(temp)) {
                    maxValue = map.get(temp);
                    list.clear();
                    list.add(temp);
                } else if (maxValue == map.get(temp)) {
                    list.add(temp);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println("出现次数=" + maxValue);
        }
    }
}
