package com.mlgg.thinkinjava.C8;

import java.util.Stack;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName Stacks
 * <p>
 * @Date
 * @since v9.0
 */
public class Stacks {
    static String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December" };
    public static void main(String[] args) {
        Stack stk = new Stack();
        for(int i = 0; i < months.length; i++)
            stk.push(months[i] + " ");
        System.out.println("stk = " + stk);
        // Treating a stack as a Vector:
        stk.addElement("The last line");
        System.out.println(
                "element 5 = " + stk.elementAt(5));
        System.out.println("popping elements:");
        while(!stk.empty())
            System.out.println(stk.pop());
    }
}
