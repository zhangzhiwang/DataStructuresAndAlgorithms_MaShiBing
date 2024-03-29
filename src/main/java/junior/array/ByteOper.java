package junior.array;

/**
 * java位运算
 * 
 * @author zhangzhiwang
 * @date 2022年1月10日 下午3:43:13
 */
public class ByteOper {
	public static void main(String[] args) {
		/**
		 * java位运算符：
		 * 1、&：两个操作数对应位上都为1则结果为1
		 * 特性：
		 * （1）一个二进制数与1进行&操作会还原该数本身，即：N & 1 = N
		 * （2）既然同1为1，那么任何一个二进制数与0进行&操作永远等于0
		 * 
		 * 2、｜：两个操作数对应位上都为0则结果为0
		 * 特性：
		 * （1）一个二进制数与0进行|操作会还原该数本身，即：N | 0 = N
		 * 	该特性的应用：想把某个数num的某一个二进制位标位1，那么就让1移动到该位（1 << i）然后进行或运算，将结果赋值给这个数num。因为1<<i之后只有目标位是1，其余都是0，
		 * 	任何二进制数与0进行|操作会还原该数本身，所以num除了目标位之外其余各位的数都不变，目标位与1进行或运算结果肯定是1，将结果再赋值给num，那么最终num只有目标位改为了1，
		 *  其余位不变，即num |= (1 << i);
		 * （2）既然同0则0，那么那么任何一个二进制数与1进行|操作永远等于1
		 * 该特性的应用：同上
		 * 
		 * 3、～：将操作数每一位取反
		 * 
		 * 4、^ ：两个操作数对应位上不一样则结果为1（异为1）
		 * 特性：
		 * （1）相当于无进位相加
		 * （2）^满足交换律和结合律
		 * 		由于^相当于无进位相加，所以可以把异或看成是加法，加法肯定满足交换律和结合律。
		 * 		所以：
		 * 		1）a ^ b = b ^ a
		 * 		2）(a ^ b) ^ c = a ^ (b ^ c)
		 * 	该特性的应用：不用额外变量交换两个数（算法题）
		 * （3）一个二进制数与0进行^操作会还原该数本身，即：N ^ 0 = N。
		 *     总结：任何一个二进制数与0进行|或者^运算都会还原该数本身
		 * （4）两个操作数M和N，如果^的结果是1，说明M和N不相等，如果结果是0，说明M=N
		 * 该特性的应用：
		 * true = 1，false = 0：
		 * true ^ true = 0
		 * false ^ false = 0
		 * true ^ false = 1
		 * false ^ true = 1
		 * 如果a ^ b = 0，说明a和b同时为true或者同时为false；
		 * 如果a ^ b = 1，说明a和b一个是true一个是false
		 * 
		 * 5、<<：将二进制数向左移动指定位数，低位补0，高位截断
		 * 
		 * 6、>>：将二进制数向右移动指定位数，高位补充符号位（向右移几位高位就补几个符号位），低位截断
		 * 
		 * 7、>>>：将二进制数向右移动指定位数，高位补0，低位截断
		 */
		System.out.println(123 & 321);// 0000 0111 1011 & 0001 0100 0001 = 0000 0100 0001 = 65（十进制）
		System.out.println(123 | 321);// 0000 0111 1011 | 0001 0100 0001 = 0001 0111 1011 = 379（十进制）
		System.out.println(~123);// ~0000 0111 1011 = 1111 1000 0100 = -124（十进制）
		System.out.println(123 ^ 321);// 0000 0111 1011 & 0001 0100 0001 = 0001 0011 1010 = 314（十进制）
		System.out.println(123 << 3);// 0000 0111 1011 << 3 = 0011 1101 1000 = 984（十进制）
		System.out.println(123 >> 2);// 0000 0111 1011 >> 2 = 0000 0001 1110 = 30（十进制）
		System.out.println(123 >>> 2);// 0000 0111 1011 >> 2 = 0000 0001 1110 = 30（十进制）

		// 一个数左移n位，等同于乘以2的n次方，即num << 1等同于num * 2^1，即扩大一倍，num << 3等同于num * 2^3 = num * 8

		/**
		 * int的范围为什么是[-2^31,2^31-1]？
		 * 首先，为什么int正数范围的最大值是2^31-1，而不是别的什么2^31或者2^32或者2^30呢？
		 * 1、首先int占几个字节？
		 * 4个字节，32位，所以只要是int类型的整数在内存中都会占用4个字节的存储空间，合32位：0000 0000 0000 0000 0000 0000 0000 0000。
		 * 2、32位的第一位索引index是0，第32位的索引是31。所以为什么int的最大值不是2^32？答案是越界了。
		 * 而且每一位都代表2^index，index范围[0,31]，整个32位二进制数换算为十进制的算法是：值为1所在位代表的2^index之和，比如末四位是0101，只有第1位（index=0）和第3位（index=2）的值是1，那么其分别代表2^0和2^2，所以换算成十进制是：2^2 + 2^0 = 4 + 1 = 5。
		 * 3、为什么int的最大值不是2^31？
		 * 因为2^31在二进制中第32位（即索引为31的位置）的值是1，后面全是0，即2^31只能代表在32位中的最高位是1，后面全是0，二进制位：1000 0000 0000 0000 0000 0000 0000 0000，这显然不是最大值，最大值应该是各位都为1，比如：1111 1111 1111 1111 1111 1111 1111 1111。
		 * 是不是32位的所有位置全是1就代表最大值了？不是，因为最高位是符号位，0代表整数，1代表负数，所以真正的有效位只到第31位，也就是索引为30的位置。那2^30能表示吗？不能，前面已经说了，2^30只能表示第31位上的数字是1，后面全是0，即0100 0000 0000 0000 0000 0000 0000 0000。
		 * 排除第32位的符号位不看，正数部分的最大值应该是这个样子：0111 1111 1111 1111 1111 1111 1111 1111，由于每一位上的值都是1，所以换算成十进制就是：2^0 + 2^1 + 2^2 + …… + 2^31。那怎么表示这个最大值呢？最简单的方式就是让这个数+1，这样所有位都要往前进一位直到进到第32位，
		 * 即：0111 1111 1111 1111 1111 1111 1111 1111 + 1 = 1000 0000 0000 0000 0000 0000 0000 0000，那么这个数怎么表示呢？很简单，是2^31，但又回到原来的话题，第32位是符号位，是不能占用的，那么由于a+1=b等同于a=b-1，所以让2^31减1不就是int整数部分的最大值了吗？
		 * 所以整数部分最大值的表示方法就是2^31-1。
		 * 
		 * 再来说为什么负数的最小值是-2^31，这回为什么不减1了？
		 * 首先负数的最小值就是负数绝对值的最大值，那么从原理上来讲正数部分的最大值取个反就是负数的最小值，正数的最大值是0111 1111 1111 1111 1111 1111 1111 1111，取个反就是将第32位的0改成1，变成：1111 1111 1111 1111 1111 1111 1111 1111，不看符号位的话这不正好是2^31么？由于第32位的1代表负数，所以这个值就表示为-2^31。
		 * 所以int的范围是[-2^31,2^31-1]。上面说这么多其实就是在解释2的n次方中的n为什么是31而不是32或者30，为什么负数边界没有减1，而正数边界要减1。
		 * 
		 * 之所以要保留一位当做符号位是因为int表示的是有符号整数，如果是无符号整数那么就可以用满32个位。所以负数最小值的绝对值要比整数最大值的绝对值大1，也就是能表示负数的个数要比能表示整数的个数多一个，如果把0归入整数范畴那么正能表示正负数的个数就一样了，即正负数各有2^31个数，左移整体加起来一共有2^31 * 2 = 2^32个数。
		 * 
		 * 另外，负数的二进制表示在计算机中存储的值所代表的的真正的值不是他存储的这个值，真正代表的值是在这个值得基础上在经过三步操作后得到的值，这三步是：
		 * 1、取出符号位1，该值只代表这个数是负数
		 * 2、符号位后面的所有位全部按位取反，得到一个数
		 * 3、用第二步得到的数再+1，得到除符号位之外真正值得二进制表示。
		 * 比如：十进制的-1在计算机中存储的32位是1111 1111 1111 1111 1111 1111 1111 1111，乍一看不算符号位后面全是1，那应该是-2^31才对，实则不然。要知道负数在计算机存储的二进制值不是它真正的值，真正的值要根据存储的值在经过三步运算得到：
		 * 1、取出符号位1
		 * 2、将符号位后面的值全部取反：（1）000 0000 0000 0000 0000 0000 0000 0000
		 * 3、将上面的值+1：（1）000 0000 0000 0000 0000 0000 0000 0001，所以1000 0000 0000 0000 0000 0000 0000 0001是-1真正的二进制表示。
		 * 
		 * 为什么计算机在存储负数的时候不直接存储它实际的二进制值而需要取出来之后在经过三步运算才能得到？比如十进制的-1为什么不存储为1000 0000 0000 0000 0000 0000 0000 0001而实际存储的是1111 1111 1111 1111 1111 1111 1111 1111？
		 * 这要从两点说起：
		 * 1、十进制的算术运算（比如：加减乘除、取模等）到计算机里面都会将操作数转换成二进制来操作，而二进制没有加减乘除、取模等运算，只有&、|、^、~、<<、>>、>>>这些位运算，所以是十进制的算数运算最终会被转换成二进制的位运算。
		 * 2、之所以负数不存储实际的二进制值是因为为了让运算逻辑达到通用的目的。具体来说，比如说加减乘除都有各自对应的一套计算逻辑，就拿加法来说，将两个数翻译成二进制后进行位运算，如果负数存储实际值得话，那么两个正数相加和一正一负相加的位运算逻辑不一样，需要进行分支判断：如果两个操作数都是正数的话那么走A逻辑，如果一正一负都B逻辑，如果两负走C逻辑。
		 * 为了提高运算性能，在运算的时候无论操作数是正还是负都统一走一个运算逻辑，负数的存储必须要经过特殊的处理，就是现在看到的样子。
		 * 
		 * 所以，一个数num的相反数就是~num + 1，无论num本身是正还是负。比如+5的相反数是-5，-1024的相反数是1024，有一个比较有意思的是：int最小数的绝对值（2^31）比最大值的绝对值(2^32-1)大1，那么Integer.MIN_VALUE的相反数是谁？答案是它自己，仍然是个负数。
		 * 分析Integer.MIN_VALUE的相反数是它自己：
		 * 1、Integer.MIN_VALUE的二进制表示为：1000 0000 0000 0000 0000 0000 0000 0000
		 * 2、将各位取反：0111 1111 1111 1111 1111 1111 1111 1111
		 * 3、取反后加1：1000 0000 0000 0000 0000 0000 0000 0000，仍然是它自己。
		 * 
		 * 分析0的相反数是它自己：
		 * 1、0的二进制表示为：0000 0000 0000 0000 0000 0000 0000 0000
		 * 2、将各位取反：1111 1111 1111 1111 1111 1111 1111 1111
		 * 3、取反后加1：（1）0000 0000 0000 0000 0000 0000 0000 0000，第33位的1越界了，截断，剩下的有效位还是0自己。
		 */
		System.out.println(Integer.MAX_VALUE);
	}
}
