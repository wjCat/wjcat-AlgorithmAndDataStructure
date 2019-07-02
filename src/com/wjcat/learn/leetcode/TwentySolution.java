package com.wjcat.learn.leetcode;

import com.wjcat.learn.datastructure.stack.ArrayStack;

/**
 * @Description leetcode -> 20、有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * Created by 厕所里拉屎的猫 on 2019/5/18.
 */
public class TwentySolution {

    public boolean isValid(String s) {
        //================================== 👇使用jdk的stack👇 ==================================//

//        Stack<Character> stack = new Stack();
//
//        for (int i = 0; i < s.length(); i++)
//            if ('(' == s.charAt(i)
//                    || '[' == s.charAt(i)
//                    || '{' == s.charAt(i))
//                stack.push(s.charAt(i));
//            else if (stack.empty())
//                return false;
//            else if ('}' == s.charAt(i) && '{' != stack.pop())
//                return false;
//            else if (']' == s.charAt(i) && '[' != stack.pop())
//                return false;
//            else if (')' == s.charAt(i) && '(' != stack.pop())
//                return false;
//        return !stack.empty();

        //================================== 👆使用jdk的stack👆 ==================================//

        //================================== 👇使用自己实现的stack👇 ==================================//

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.isEmpty())
                return false;
            else if (')' == c && '(' != stack.pop())
                return false;
            else if (']' == c && '[' != stack.pop())
                return false;
            else if ('}' == c && '{' != stack.pop())
                return false;
        }
        return stack.isEmpty();

        //================================== 👆使用自己实现的stack👆 ==================================//

    }

    public static void main(String[] args) {

        System.out.println((new TwentySolution()).isValid("()[]{}"));
        System.out.println((new TwentySolution()).isValid("([)]"));
    }

}
