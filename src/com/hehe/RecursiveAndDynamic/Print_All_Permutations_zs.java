package com.hehe.RecursiveAndDynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 递归
 * 打印 串 的所有排列组合
 * <p>
 * 将串中所有的位置上两两交换 就能得到全排列
 */
public class Print_All_Permutations_zs {
    /**
     * 串的所有排列组合 - ArrayList<String>
     *
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    public static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        }
        for (int j = i; j < cs.length; j++) {
            swap(cs, i, j);
            PermutationHelper(cs, i + 1, list);
            swap(cs, i, j);
        }
    }

    /**
     * 串的所有排列组合 - void
     *
     * @param str
     */
    public static void printAllPermutations1(String str) {
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    public static void process1(char[] chs, int i) {
        if (i == chs.length - 1) {
            System.out.println(String.valueOf(chs));
        }
        for (int j = i; j < chs.length; j++) {
            swap(chs, i, j);
            process1(chs, i + 1);
            swap(chs, i, j);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    //===============================================未看=================================================
    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }


    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("======");
//        printAllPermutations2(test1);
//        System.out.println("======");

        String test2 = "acc";
        printAllPermutations1(test2);
        System.out.println("======");
//        printAllPermutations2(test2);
//        System.out.println("======");


        System.out.println("===========================");
        List<String> list = Permutation("abc");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
