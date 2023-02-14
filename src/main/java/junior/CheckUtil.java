package junior;

import junior.dailyPractice._20221220.PracticeSelectionSort;
import junior.sort.SortCommonUtil;

/**
 * 对数器
 * 对数器用于检测算法的正确性
 */
public class CheckUtil {
    public static void main(String[] args) {
//        int[] arr = createRandomArray(5, 10);
//        SortCommonUtil.printArr(arr);
//
//        int[] copyArr = copyArr(arr);
//        SortCommonUtil.printArr(copyArr);
//
//        arr = new int[]{11,2,3};
//        System.out.println(isSortedAsc(arr));

        // 检查一下选择排序算法写的对不对
//        int[] arr = createRandomArray(5, 10);
//        System.out.println("原始数组：");
//        SortCommonUtil.printArr(arr);
//
//        PracticeSelectionSort.selectSort(arr);
//        System.out.println("排完序之后：");
//        SortCommonUtil.printArr(arr);

        int testTimes = 100_0000;
        for(int i = 0; i < testTimes; i++) {
            int[] arr = createRandomArray(5, 10);
            int[] copyArr = copyArr(arr);

            PracticeSelectionSort.selectSort(arr);
            // 检查是不是已经排好序
            if(!isSortedAsc(arr)) {
                System.out.println("排序算法出错！");
                System.out.println("原数组：");
                SortCommonUtil.printArr(copyArr);
                System.out.println("排完序之后：");
                SortCommonUtil.printArr(arr);
                break;
            }
        }

        System.out.println("ok");
    }

    /**
     * 创建一个随机长度且元素值随机的数组
     *
     * @param maxLength 数组随机长度的最大值，数组的长度范围：[0, maxLength]
     * @param maxValue  数组元素随机值的最大值，元素值的范围：[0, maxValue]
     * @return
     */
    public static int[] createRandomArray(int maxLength, int maxValue) {
        if(maxLength < 0 || maxValue < 0) {
            throw new RuntimeException("参数有误！");
        }

        int len = (int) (Math.random() * (maxLength + 1));
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }

        return arr;
    }

    /**
     * 拷贝数组
     * @param srcArr
     * @return
     */
    public static int[] copyArr(int[] srcArr) {
        if(srcArr == null) {
            throw new RuntimeException("参数有误！");
        }

        int[] desArr = new int[srcArr.length];
        for(int i = 0; i < srcArr.length; i++) {
            desArr[i] = srcArr[i];
        }

        return desArr;
    }

    /**
     * 判断数组是否已升序排序
     * @param arr
     * @return
     */
    private static boolean isSortedAsc(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return true;
        }

        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(maxValue > arr[i]) {
                return false;
            }

            maxValue = arr[i];
        }

        return true;
    }
}
