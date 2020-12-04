package exam;

import java.util.Stack;

public class leetcode402 {
	public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char ch : num.toCharArray()){
            while(!stack.empty() && k>0 && stack.peek()>ch){
                stack.pop();
                k--;
            }
            if(stack.empty() && ch == '0') continue;
            stack.push(ch);
        }

        while(k>0 && !stack.empty()){
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!stack.empty()){
            res.append(stack.pop());
        }
        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}
