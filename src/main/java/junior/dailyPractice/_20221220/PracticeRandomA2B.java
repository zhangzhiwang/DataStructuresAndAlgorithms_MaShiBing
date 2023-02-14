package junior.dailyPractice._20221220;

import junior.sort.SortCommonUtil;

/**
 * 从a-b随机到c-d随机
 * 题目：给定一个函数f，该函数以等概率返回[1,5]，要求在只使用f函数的情况下等概率返回[1,7]。
 */
public class PracticeRandomA2B {
    /**
     * 已知函数f：等概率发生器
     * @return
     */
    private static int f() {
        return (int)(Math.random() * 5) + 1;
    }
    /**
     * 0、1等概率发生器
     * @return
     */
    private static int f1() {
        int i = 0;
        do {
            i = f();
        } while(i == 3);

        return i < 3 ? 0 : 1;
    }

    public static void main(String[] args) {
//        int testTimes = 100_0000;
//        int[] arr = new int[6];
//        for (int i = 0; i < testTimes; i++) {
//            arr[f()]++;
//        }
//        SortCommonUtil.printArr(arr);
    }
}
