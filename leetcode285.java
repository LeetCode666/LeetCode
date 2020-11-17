package exam;

import java.util.Stack;

public class leetcode285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
		int ans = Integer.MIN_VALUE;
		while(root!=null || !stack.empty()){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(root.val > p.val){
				ans = p.val;
				return root;
			}
			root = root.right;
		}
		return null;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
