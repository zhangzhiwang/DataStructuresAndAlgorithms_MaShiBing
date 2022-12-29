package junior.dailyPractice._20221220;

/**
 * 题目1：打印int数的二进制形式
 */
public class PractticePrintIntBinary {
    private static void printIntBinary(int num) {
        for(int i = 31; i >= 0; i--) {
            System.out.print(((1 << i) & num) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        printIntBinary(num);
        System.out.println();

        num = ~num + 1;
        printIntBinary(num);
        System.out.println();

        num = Integer.MIN_VALUE;
        printIntBinary(num);
        System.out.println();

        num = ~num + 1;
        printIntBinary(num);
        System.out.println();

        num = 0;
        printIntBinary(num);
        System.out.println();
    }
}
