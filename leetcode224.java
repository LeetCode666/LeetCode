package exam;

import java.util.Stack;

public class leetcode224 {
	public int calculate(String s) {
        if(s == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1, number = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                number = 10* number + (int)(ch - '0');
            }
            else if(ch == '+'){
                res += sign * number;
                sign = 1;
                number = 0;
            }
            else if(ch == '-'){
                res += sign * number;
                sign = -1;
                number = 0;
            }
            else if(ch == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            else if(ch == ')'){
                res += sign * number;
                res *= stack.pop();
                res += stack.pop();
                number = 0;
            }
        }
        res += sign * number;
        return res
}
