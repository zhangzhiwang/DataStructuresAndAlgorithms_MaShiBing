package junior.dailyPractice._20221220;

/**
 * 选择排序
 */
public class PracticeSelectionSort {
    public static void selectSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        int N = arr.length;
        for(int i = 0; i < N; i++) {
            int minValueIndex = i;// 每次都假设最左边的位置是最小值
            for(int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, minValueIndex, i);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = tmp;
    }

    private static void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9,8,8,7,6,5,5,4,3,2,1};
        print(arr);
        selectSort(arr);
        print(arr);
    }
}
