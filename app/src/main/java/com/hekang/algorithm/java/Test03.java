package com.hekang.algorithm.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by HE KANG  on 2017\11\15 0015.
 * 算法题目：10万个用户，随机选出2017个幸运用户
 * 题目升级：在 min 和 max 范围之内，随机生成n个不重复的数字
 * 思路：采用set集合特性，不可以存入重复数据
 */

public class Test03 {

    public static void main(String[] args) {
        getData(10, 100, 30);
    }

    private static Set<Integer> getData(int min, int max, int n) {
        if (min > max || (max - min) < n - 1) {
            System.out.println("参数范围错误");
            return null;
        }
        Set<Integer> set = new HashSet<>();
        while (true) {
            int data = (int) (Math.random() * (max+1));
            if (data < min){
                continue;
            }
            set.add(data);
            if (set.size() == n) {
                break;
            }
        }
        Iterator<Integer> integerIterator = set.iterator();
        while (integerIterator.hasNext()) {
            System.out.print(integerIterator.next() + "  ");
        }
        return set;
    }
}
