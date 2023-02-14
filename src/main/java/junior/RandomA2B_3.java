package junior;

/**
 * 题目3：函数f以固定且不等概率返回0和1，写一个函数g，要求以固定且相等的概率返回0和1，在g函数中只能调用f函数。
 * 题目解读：已知函数f返回等固定概率P返回0，以固定概率1-P返回1，且P != 1-P，写一个函数g，要求该函数返回0和1的概率是相等的且固定的。
 *
 * 思路：
 * 函数g：
 * 1、调用两次f函数。
 * 2、如果两次调用的结果都返回0，如果最终结果返回0，那么得到0的概率是P*P，如果两次都返回1，那么最终返回1的概率是(1-P)*(1-P)，由于P != 1-P，所以P*P != (1-P)*(1-P)，所以返回0和1的概率是不等的。
 * 3、如果两次调用f函数，第一次返回0，第二次返回1，那么整体结果返回0，所以得到0的概率是P*(1-P)；如果第一次得到1，第二次得到0，最终返回1，那么得到1的概率是(1-P)*P，所以最终得到0和1的概率是相等的。
 * 4、要想满足第3点，只要两次调用f函数返回的结果一样就重做。
 */
public class RandomA2B_3 {
    /**
     * 已知函数f，以固定概率0.8返回0，以固定概率0.2返回1
     * @return
     */
    private static int f() {
        return Math.random() < 0.8 ? 0 : 1;
    }

    private static int g() {
        int result = 0;
        do {
            result = f();
        } while(result == f());// 第二次函数f调用在while的判断条件里面，只要两次得到的结果一样就重做，不一样就退出
        return result;
    }

    public static void main(String[] args) {
        int testTimes = 100_0000;
        int count = 0;
        for(int i = 0; i < testTimes; i++) {
            if(g() == 1) {
                count++;
            }
        }

        System.out.println((double)count / (double)testTimes);
    }
}
