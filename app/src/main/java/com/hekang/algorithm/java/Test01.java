package com.hekang.algorithm.java;

/**
 * Created by HE KANG  on 2017\11\15 0015.
 * 算法题目：已知整数n，用java实现函数f(n)，输出从1到n的字符串，以空格为分隔符
 */

public class Test01 {

    public static void main(String[] args) {
        //System.out.println("main 方法");
        f(15);
    }

    private static void f(int n){
        if (n <= 0){
            System.out.println("参数n异常");
            return;
        }
        if (n == 1){
            System.out.println(1);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1 ; i < n+1 ; i ++){
            stringBuilder.append(i);
            if (i != n){
               stringBuilder.append(" ");
            }
        }
        System.out.println("输出结果："+stringBuilder.toString());
    }
}
