package com.leetcode.字符串;

import java.util.*;
/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 *
 * @author HigginCui
 * @date 2022/6/7 下午11:58
 */
public class LeeCode_20_有效的括号 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                //这里c2是( [ { 中一个，而此时的c是 ) ] }中一个
                Character c2 = stack.pop();

                if (!map.get(c2).equals(c)) {
                    return false;
                }
            }
        }
        //如果此时栈非空，说明括号没有闭合，比如输入"["的情况
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
