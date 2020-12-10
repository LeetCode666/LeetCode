package exam;

import java.util.Stack;

public class Leetcode71 {
	public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : str){
            if(s.equals("..")){
                if(!stack.empty())
                    stack.pop();
            }
            else if(!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.insert(0, "/" + stack.pop());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
