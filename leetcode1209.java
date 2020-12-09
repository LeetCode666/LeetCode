package exam;

import java.util.Stack;

//1209. Remove All Adjacent Duplicates in String II
public class leetcode1209 {
	public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.empty() && stack.peek() == ch){
                stack.push(ch);
                count.push(count.peek()+1);
            }
            else{
                stack.push(ch);
                count.push(1);
            }
            if(count.peek() == k){
                for(int i = 0; i < k;i++){
                    stack.pop();
                    count.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
