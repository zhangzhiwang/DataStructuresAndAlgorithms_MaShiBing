package junior.dailyPractice._20221220;

import junior.sort.SortCommonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 从a-b随机到c-d随机
 * 题目：给定一个函数f，该函数以等概率返回[3,20]，要求在只使用f函数的情况下等概率返回[30,57]。
 */
public class PracticeRandomA2B_2 {
    /**
     * 已知函数f
     */
    private static int f() {
        return (int)(Math.random() * 18) + 3;
    }

    /**
     * 将已知范围改成0、1发生器
     * @return
     */
    private static int f1() {
        // 3-11 12-20
        int i = f();
        return i >= 3 && i <= 11 ? 0 : 1;
    }

    /**
     * 将目标范围改成[0,31]
     * @return
     */
    private static int f2() {
        // 27 [0,27] + 30 = [30,57]
        // 2^0 + 2^1 + 2^2 + 2^3 + 2^4 = 16 + 8 + 4 + 2 + 1，27需要5个二进制位
        return (f1() << 4) + (f1() << 3) + (f1() << 2) + (f1() << 1) + f1();
    }

    /**
     * 将[0,31]修正为[0,27]
     * @return
     */
    private static int f3() {
        // 31 - 27 = 4，遇到后4个数就重做
        // [0,27]，28、29、30、31重做
        int i = 0;
        do {
            i = f2();
        } while(i == 28 || i == 29  || i == 30 || i == 31);

        return i;
    }

    /**
     * 目标函数
     * @return
     */
    private static int g() {
        return f3() + 30;
    }

    public static void main(String[] args) {
        int testTimes = 100_0000;
        int[] arr = new int[21];
//        for (int i = 0; i < testTimes; i++) {
//            arr[f()]++;
//        }
//
//        SortCommonUtil.printArr(arr);

//        int count = 0;
//        for (int i = 0; i < testTimes; i++) {
//            if(f1() == 0) {
//                count++;
//            }
//        }
//        System.out.println((double)count / (double)testTimes);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 57; i++) {
            map.put(i, 0);
        }
        System.out.println("初始map = " + map);

        System.out.println("----------");
        for (int i = 0; i < testTimes; i++) {
            int key = g();
            int value = map.get(key);
            map.put(key, ++value);
        }
        System.out.println("map = " + map);
    }
}
