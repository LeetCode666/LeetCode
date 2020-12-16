package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode772 {
	 public int calculate(String s) {
	        if(s == null || s.length() == 0) return 0;

	        Queue<Character> q = new LinkedList<>();
	        for(char c : s.toCharArray()) q.offer(c);

	        return cal(q);
	    }

	    private int cal(Queue<Character> q) {
	        Stack<Integer> st = new Stack<>();
	        char sign = '+';
	        int num = 0;

	        while(!q.isEmpty()) {
	            char c = q.poll();
	            if(Character.isDigit(c)) num = num * 10 + (c - '0');

	            if(!Character.isDigit(c) && c != ' ' || q.isEmpty()) {
	                if(c == '(') num = cal(q);
	                if(sign == '+') st.push(num);
	                if(sign == '-') st.push(-num);
	                if(sign == '*') st.push(st.pop() * num);
	                if(sign == '/') st.push(st.pop() / num);
	                if(c == ')') break;
	                num = 0;
	                sign = c;
	            }
	        }

	        int res = 0;
	        for(int n : st) res += n;
	        return res;
	    }
}
