package com.mlgg.algorithm.leetcode;

/**
 * 有人说Integer的最大值和最小值首位只能是1或2 ，所以反转后的结果都是1或2，在(-8,7)之间，所以对pop的判断多余，这种情况是用于不知道Integer的最值的情况
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName 整数反转
 * <p>
 * @Date
 * @since v9.0
 */
public class 整数反转 {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            //弹出
            int pop = x % 10;
            x = x / 10;
            //防止反转后溢出
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop>Integer.MAX_VALUE%10)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop<Integer.MIN_VALUE%10)) return 0;
            //压入
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE:"+Integer.MAX_VALUE+",Integer.MIN_VALUE"+Integer.MIN_VALUE);
        整数反转 整数反转 = new 整数反转();
        int reverse = 整数反转.reverse(2333);
        System.out.println(reverse);

    }
}
