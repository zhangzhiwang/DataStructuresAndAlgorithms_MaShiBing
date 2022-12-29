package junior.dailyPractice._20221220;

/**
 * 1-N的阶乘和
 */
public class PracticeJieCheng {
    private static int jieChengSum(int n) {
        int jieChengTmp = 1;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            jieChengTmp *= i;
            sum += jieChengTmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = jieChengSum(1);
        System.out.println("sum = " + sum);
    }
}
