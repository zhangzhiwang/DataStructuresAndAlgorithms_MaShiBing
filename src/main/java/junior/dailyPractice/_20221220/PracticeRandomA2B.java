package junior.dailyPractice._20221220;

import junior.sort.SortCommonUtil;

/**
 * 从a-b随机到c-d随机
 * 题目：给定一个函数f，该函数以等概率返回[1,5]，要求在只使用f函数的情况下等概率返回[1,7]。
 */
public class PracticeRandomA2B {
    /**
     * 已知函数f：等概率发生器
     *
     * @return
     */
    private static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 0、1等概率发生器
     *
     * @return
     */
    private static int f1() {
        int i = 0;
        do {
            i = f();
        } while (i == 3);

        return i < 3 ? 0 : 1;
    }

    /**
     * [0,6]范围的最大值6需要3个二进制位才能满足，所以调用等概率发生函数f1三次，分别移动到相关的位置上，然后加起来。
     * 但是三个二进制位的最大值是7，所以本函数f2的结果是[0,7]等概率返回一个
     * @return
     */
    private static int f2() {
//        int i1 = f1() << 2;
//        System.out.println("i1 = " + i1);
//        int i2 = f1() << 1;
//        System.out.println("i2 = " + i2);
//        int i3 = f1();
//        System.out.println("i3 = " + i3);
//        return i1 + i2 + i3;

        return (f1() << 2) + (f1() << 1) + f1();// 注意：算术运算符的优先级比位运算符高，所以要加括号
//        return (int)(f1() << 2) + (int)(f1() << 1) + (int)f1();
    }

    /**
     * 将[0,7]范围修正为[0,6]范围
     * @return
     */
    private static int f3() {
        int i = 0;
        do {
            i = f2();
        } while(i == 7);

        return i;
    }

    /**
     * 目标函数g——等概率返回[1,7]范围内的数
     * @return
     */
    private static int g() {
        return f3() + 1;
    }


    public static void main(String[] args) {
        int testTimes = 100_0000;
        int count = 0;
        int[] arr = new int[6];
//        for (int i = 0; i < testTimes; i++) {
//            arr[f()]++;
//        }
//        SortCommonUtil.printArr(arr);

//        for (int i = 0; i < testTimes; i++) {
//            if (f1() == 0) {
//                count++;
//            }
//        }
//
//        System.out.println((double) count / (double) testTimes);

//        System.out.println(f2());

        arr = new int[8];
        for (int i = 0; i < testTimes; i++) {
            arr[g()]++;
        }

        SortCommonUtil.printArr(arr);
    }
}
