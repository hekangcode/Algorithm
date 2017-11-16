package com.hekang.algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HE KANG  on 2017\11\16 0016.
 * 算法题目：有一个 int[] numbers 数组，指定一个数target，在这个数组中找出两个下标（N1 > 0,N2 > N1）,使得 numbers[N1] + numbers[N2] == target
 * 题目：编写一个函数，输入为一个int型的数组numbers和一个int型变量target，找到这个数组中和为target的两个元素，输出其index。
 * 假设每组输入有且仅有一组输出
 * 示例：
 * Input: numbers={6, 2, 15, 7,11}, target=9
 * Output: index1=1, index2=2
 * 解答：
 * 1.查找法
 * 两层遍历，最直观
 * 时间复杂度：  O(N*N)
 * 2.排序法
 * numbers按递增排序（快排），设置两个游标idx1和idx2
 * Idx1=0
 * Idx2=numbers.size
 * 如果numbers[idx1]+numbers[idx2]==target，则要求的解为numbers[idx1]在原数列中的下标（现在的numbers是已经排序后的）和numbers[idx2]在原数列中的下标；
 * 如果numbers[idx1]+numbers[idx2]>target，则idx2--；
 * 如果numbers[idx1]+numbers[idx2]<target，则idx1++;
 * 时间复杂度： O(N*logN)
 * 3. 利用Map：
 * 建立一个空Map，map中保存的是已经扫描过的number。
 * <K, V>为<numbers值，numbers下标>，
 * 对于numbers[i]，如果map中存在K=target-numbers[i]，则要求的解为V（K=target-numbers对应的）和i；如果不存在，则向map中添加<numbers[i],i>
 * 时间复杂度：O(N)
 */

public class Test05 {

    public static void main(String[] args) {

    }

    /**
     * 方法一：查找法，采用两层循环
     * 时间复杂度=O(n*n)
     */
    private void f1(int[] numbers, int target) {
        int index1;  // 下标1
        int index2;  // 下标2
        if (numbers == null || numbers.length < 0) {
            return;
        }
        int ln = numbers.length;  // 数组长度
        for (int n1 = 0; n1 < ln; n1++) {
            for (int n2 = 0; n2 < ln; n2++) {
                if (n2 > n1) {
                    if (numbers[n1] + numbers[n2] == target) {
                        index1 = n1;
                        index2 = n2;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 排序法：首先将目标数组排序，采用快速排序方法，从小到大排序
     * 时间复杂度： O(N*logN)
     */
    private void f2(int[] numbers, int target) {
        // 假设此处的numbers已经是排序完成的（此处不做排序处理）
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index2 > index1) {
            if (numbers[index1] + numbers[index2] == target) {
                // 找到了,返回index1和index2
                break;
            } else if (numbers[index1] + numbers[index2] > target) {
                // 大于
                index2--;
            } else if (numbers[index1] + numbers[index2] < target) {
                // 小于
                index1++;
            }
        }
    }

    /**
     * 利用map
     * 时间复杂度：O(N)
     */
    private void f3(int[] numbers, int target) {
        // 将numbers存入到map集合中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int k = 0; k < numbers.length; k++) {
            int temp = target - numbers[k];
            if (map.containsKey(temp) && map.get(temp) != k) {
                // 找到了,返回numbers[k]
                return;
            }
        }
    }
}
