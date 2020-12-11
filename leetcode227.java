package exam;

import java.util.Stack;

public class leetcode227 {
	 public int calculate(String s) {
	        Stack<Integer> stack = new Stack<>();
	        char sign = '+';
	        int number = 0;
	        for(int i = 0; i < s.length();i++){
	            char ch = s.charAt(i);
	            if(Character.isDigit(ch)){
	                number = 10*number + (int)(ch - '0');
	            }
	            if(i == s.length()-1 || !Character.isDigit(ch) && ch != ' '){
	                if(sign =='+')  stack.push(number);
	                else if(sign == '-') stack.push(-number);
	                else if(sign == '*')
	                    stack.push(stack.pop()*number);
	                else if(sign == '/')
	                    stack.push(stack.pop()/number);
	                number = 0;
	                sign = ch;
	            }
	        }
	        int res = 0;
	        while(!stack.empty()) res += stack.pop();
	        return res;
	    }
}
